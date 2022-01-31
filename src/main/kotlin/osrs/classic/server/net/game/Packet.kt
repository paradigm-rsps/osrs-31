package osrs.classic.server.net.game

import osrs.classic.server.net.Message
import osrs.classic.server.net.Session

interface Packet : osrs.classic.server.net.Message {

    fun handle(session: osrs.classic.server.net.Session) {
        /*
         * Nothing to do.
         */
    }
}