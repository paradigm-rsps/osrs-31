package osrs.classic.server.event

import osrs.classic.server.util.logger.Logger


class EventHandler<out E : Event>(
    val event: E,
    private val action: E.() -> Unit
) {

    fun handle(): Unit = try {
        event.action()
    } catch (e : Exception) {
        e.printStackTrace()
        Logger.error("An error occurred while handling event $event.")
    }
}