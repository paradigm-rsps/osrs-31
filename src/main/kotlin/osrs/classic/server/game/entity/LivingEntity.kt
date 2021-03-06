package osrs.classic.server.game.entity

import osrs.classic.server.event.Event
import osrs.classic.server.event.EventHandler
import osrs.classic.server.event.EventSubject
import osrs.classic.server.game.MovementType
import osrs.classic.server.game.World
import osrs.classic.server.game.entity.pathfinder.Pathfinder
import osrs.classic.server.game.entity.update.UpdateFlag
import osrs.classic.server.game.map.Tile
import osrs.classic.server.task.Task
import osrs.classic.server.task.TaskSubject
import osrs.classic.server.task.TaskType
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque

@Suppress("LeakingThis")
abstract class LivingEntity : Entity, EventSubject, TaskSubject {

    val world = World

    open var index: Int = -1
    open var size: Int = 1
    override var tile: Tile = Tile(3213, 3213, 0)
    open var prevTile: Tile = Tile(0, 0, 0)
    override var orientation: Int = 0
    open var running: Boolean = false
    open var interacting: LivingEntity? = null
    open var movementType: MovementType = MovementType.NONE
    open var combatLevel: Int = 1
    open var chatMessage: String? = null
    open var teleportTile: Tile? = null
    open var path: MutableList<Tile> = mutableListOf()
    open var prevPathTile: Tile = Tile(0, 0, 0)

    abstract val pathfinder: Pathfinder

    internal abstract val updateFlags: SortedSet<out UpdateFlag>

    override val events = ConcurrentLinkedDeque<EventHandler<Event>>()

    override val tasks = mutableMapOf<TaskType, MutableSet<Task>>()

    internal open val postTasks = mutableListOf<() -> Unit>()

    internal fun processTasks() {
        while(true) {
            while(events.isNotEmpty()) events.poll().handle()
            val resume = tasks.values.flatMap { it.toList().map(Task::run) }
            if(resume.all { !it } && events.isEmpty()) break
        }
    }

    internal fun processMovement() {
        prevTile = tile
        when {
            teleportTile != null -> {
                doTeleport()
                postMovement()
            }

            path.isNotEmpty() -> {
                doStep()
                postMovement()
            }
        }
    }

    private fun doTeleport() {
        movementType = MovementType.TELEPORT
        addMovementUpdateFlag()
        tile = teleportTile!!
        prevPathTile = tile
        doLater { teleportTile = null }
    }

    private fun doStep() {
        tile = when {
            running -> when {
                path.size == 1 -> {
                    movementType = MovementType.WALK
                    addMovementUpdateFlag()
                    prevPathTile = tile
                    path.removeAt(0)
                }
                path.size > 1 && tile.isWithinRadius(path[1], 1) -> {
                    movementType = MovementType.WALK
                    prevPathTile = path.removeAt(0)
                    path.removeAt(0)
                }
                else -> {
                    movementType = MovementType.RUN
                    prevPathTile = path.removeAt(0)
                    path.removeAt(0)
                }
            }
            else -> {
                movementType = MovementType.WALK
                prevPathTile = tile
                path.removeAt(0)
            }
        }
        orientation = getOrientation(prevPathTile, tile)
    }

    private fun postMovement() {
        scheduleMoveEvent(movementType)
    }

    override fun postProcess() {
        super.postProcess()
        updateFlags.clear()
        postTasks.forEach { it.invoke() }
        postTasks.clear()
        movementType = MovementType.NONE
    }

    fun doLater(action: () -> Unit) {
        this.postTasks.add(action)
    }

    internal abstract fun scheduleMoveEvent(type: MovementType)

    abstract fun addAppearanceUpdateFlag()
    abstract fun addForceChatUpdateFlag()
    abstract fun addMovementUpdateFlag()
    abstract fun addMovementModeUpdateFlag()

    fun getOrientation(prev: Tile, new: Tile): Int = getOrientation(new.x - prev.x, new.y - prev.y)

    fun getOrientation(dx: Int, dy: Int): Int = jagexMovementAngle[2 - dy][dx + 2]

    companion object {
        private val jagexMovementAngle = arrayOf(
            intArrayOf(768, 768, 1024, 1280, 1280),
            intArrayOf(768, 768, 1024, 1280, 1280),
            intArrayOf(512, 512, -1, 1536, 1536),
            intArrayOf(256, 256, 0, 1792, 1792),
            intArrayOf(256, 256, 0, 1792, 1792)
        )
    }
}