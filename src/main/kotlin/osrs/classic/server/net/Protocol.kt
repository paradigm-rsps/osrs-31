package osrs.classic.server.net

import io.netty.buffer.ByteBuf

abstract class Protocol(val session: osrs.classic.server.net.Session) {

    open fun encode(message: osrs.classic.server.net.Message, out: ByteBuf) {
        throw UnsupportedOperationException()
    }

    open fun decode(buf: ByteBuf, out: MutableList<Any>) {
        throw UnsupportedOperationException()
    }

    open fun handle(message: osrs.classic.server.net.Message) {
        throw UnsupportedOperationException()
    }

}