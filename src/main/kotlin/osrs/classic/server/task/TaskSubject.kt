package osrs.classic.server.task

import osrs.classic.server.task.condition.TaskContinuation
import osrs.classic.server.task.condition.TaskEmptyCondition
import kotlin.coroutines.intrinsics.createCoroutineUnintercepted

interface TaskSubject {

    val tasks: MutableMap<TaskType, MutableSet<Task>>

    fun queue(type: TaskType = NormalTask, action: suspend Task.() -> Unit): Task {
        val task = Task(type, this)
        task.next = TaskContinuation(TaskEmptyCondition, action.createCoroutineUnintercepted(task, task))
        tasks.getOrPut(type) { mutableSetOf() }.add(task)
        return task
    }

    fun cancelTasks(type: TaskType) {
        tasks[type]?.forEach { it.cancel() }
    }

    fun postProcess() {
        tasks.values.forEach { it.forEach(Task::postProcess) }
    }

}