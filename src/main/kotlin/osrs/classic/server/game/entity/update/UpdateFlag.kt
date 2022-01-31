package osrs.classic.server.game.entity.update

abstract class UpdateFlag(val priority: Int, val mask: Int) : Comparable<UpdateFlag> {

    override fun compareTo(other: UpdateFlag): Int {
        return when {
            priority < other.priority -> -1
            priority > other.priority -> 1
            else -> 0
        }
    }
}