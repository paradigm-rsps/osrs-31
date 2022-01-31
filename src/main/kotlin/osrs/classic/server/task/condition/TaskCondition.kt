package osrs.classic.server.task.condition

interface TaskCondition {
    fun resume(): Boolean
    fun postProcess() {}
}