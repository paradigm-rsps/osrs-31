package osrs.classic.server.event

import osrs.classic.server.game.entity.Npc

abstract class NpcEvent(val npc: Npc) : WorldEvent()

fun <E : NpcEvent> EventBus.dispatch(event: E) {
    eventListeners[event::class]?.let {
        it.forEach { listener -> listener.schedule(event, event.npc) }
    }
}