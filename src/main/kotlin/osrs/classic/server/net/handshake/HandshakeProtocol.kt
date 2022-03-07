package osrs.classic.server.net.handshake

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.StatusResponse
import osrs.classic.server.net.js5.JS5Protocol
import osrs.classic.server.net.login.LoginProtocol

class HandshakeProtocol(session: osrs.classic.server.net.Session) : osrs.classic.server.net.Protocol(session) {

    override fun decode(buf: ByteBuf, out: MutableList<Any>) {
        val request = when(HandshakeType.fromOpcode(buf.readUnsignedByte().toInt())) {
            HandshakeType.JS5 -> HandshakeRequest.JS5(revision = buf.readInt())
            HandshakeType.LOGIN -> HandshakeRequest.LOGIN
        }
        out.add(request)
    }

    override fun encode(message: osrs.classic.server.net.Message, out: ByteBuf) {
        if(message !is HandshakeResponse) return

        out.writeByte(message.status.opcode)
    }

    override fun handle(message: osrs.classic.server.net.Message) {
        when(message) {
            is HandshakeRequest.JS5 -> message.handle()
            is HandshakeRequest.LOGIN -> handle()
        }
    }

    private fun HandshakeRequest.JS5.handle() {
        if(revision != 31) {
            session.writeAndClose(StatusResponse.OUT_OF_DATE)
            return
        }

        session.protocol.set(JS5Protocol(session))
        session.writeAndFlush(StatusResponse.SUCCESSFUL)
    }

    private fun handle() {
        val response = HandshakeResponse(StatusResponse.SUCCESSFUL, session.seed)
        session.writeAndFlush(response)
        session.protocol.set(LoginProtocol(session))
    }
}