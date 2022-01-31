package osrs.classic.server.event

interface EventSubject {

    val events: MutableCollection<EventHandler<Event>>

}