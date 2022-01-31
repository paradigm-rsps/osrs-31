package osrs.classic.server.game.entity

import dev.avernic.server.cache.config.NpcConfig
import osrs.classic.server.cache.GameCache
import osrs.classic.server.game.MovementType
import osrs.classic.server.game.entity.pathfinder.Pathfinder
import osrs.classic.server.game.entity.pathfinder.PlayerPathfinder
import osrs.classic.server.game.entity.update.NpcUpdateFlag
import osrs.classic.server.game.map.Tile

@Suppress("LeakingThis")
open class Npc(
    val id: Int,
    override var index: Int,
    override var tile: Tile
) : LivingEntity() {

    private val cache = GameCache
    private val definition: NpcConfig = cache.configArchive.npcConfigs[id]
        ?: throw IllegalStateException("NPC with id: $id is invalid. Ensure the NPC id is correct.")

    init {
        world.getChunk(tile)?.npcs?.add(this)
    }

    open var name: String = definition.name
    override var combatLevel: Int = definition.combatLevel ?: 1
    open var isDead: Boolean = false
    open var spawnTile: Tile = Tile(tile.x, tile.y, tile.plane)
    override var size: Int = definition.size.toInt()
    override val pathfinder: Pathfinder = PlayerPathfinder(this)
    override val updateFlags = sortedSetOf<NpcUpdateFlag>()
    open var options: Array<String?> = definition.options
    override var orientation: Int = 0
    override var prevTile: Tile = Tile(tile.x, tile.y, tile.plane)
    override var prevPathTile: Tile = Tile(tile.x, tile.y, tile.plane)
    override var movementType: MovementType = MovementType.NONE
    open var wanderRadius: Int = 0

    override fun addAppearanceUpdateFlag() {}
    override fun addForceChatUpdateFlag() {}
    override fun addMovementModeUpdateFlag() {}
    override fun addMovementUpdateFlag() {}

    override fun scheduleMoveEvent(type: MovementType) {}
}