package osrs.classic.server.task.condition

import kotlin.coroutines.Continuation

class TaskContinuation(
    val condition: TaskCondition,
    val continuation: Continuation<Unit>
) : TaskCondition by condition