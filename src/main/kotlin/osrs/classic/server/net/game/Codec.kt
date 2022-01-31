package osrs.classic.server.net.game

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session

interface Codec<T : Packet> {

    fun encode(session: osrs.classic.server.net.Session, packet: T, buf: ByteBuf) {
        throw UnsupportedOperationException()
    }

    fun decode(session: osrs.classic.server.net.Session, buf: ByteBuf): T {
        throw UnsupportedOperationException()
    }

}