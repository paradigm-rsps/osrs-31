package osrs.classic.server.net.handshake

import osrs.classic.server.net.Message

sealed class HandshakeRequest : osrs.classic.server.net.Message {
    object LOGIN : HandshakeRequest()
    class JS5(val revision: Int) : HandshakeRequest()
}