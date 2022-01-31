package osrs.classic.server.event

import osrs.classic.server.game.World

abstract class WorldEvent : Event {
    val world = World
}

fun <E : WorldEvent> EventBus.dispatch(event: E) {
    eventListeners[event::class]?.let {
        it.forEach { listener -> listener.schedule(event, event.world) }
    }
}