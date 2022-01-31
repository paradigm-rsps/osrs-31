package osrs.classic.server.task.condition

class TaskPredicateCondition(private val predicate: () -> Boolean) : TaskCondition {

    override fun resume(): Boolean {
        return predicate()
    }

}