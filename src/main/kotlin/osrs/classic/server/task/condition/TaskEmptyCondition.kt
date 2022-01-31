package osrs.classic.server.task.condition

object TaskEmptyCondition : TaskCondition {

    override fun resume(): Boolean {
        return true
    }

}