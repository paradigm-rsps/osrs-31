package osrs.classic.server.net.login

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Message
import osrs.classic.server.net.Protocol
import osrs.classic.server.net.Session
import osrs.classic.server.net.StatusResponse
import osrs.classic.server.service.ServiceManager
import osrs.classic.server.service.login.LoginService

class LoginProtocol(session: Session) : Protocol(session) {

    private val serviceManager = ServiceManager
    private val loginService = serviceManager[LoginService::class]

    private val decoder = LoginDecoder(session)
    private val encoder = LoginEncoder(session)

    override fun decode(buf: ByteBuf, out: MutableList<Any>) {
        decoder.decode(buf, out)
    }

    override fun encode(message: Message, out: ByteBuf) {
        encoder.encode(message, out)
    }

    override fun handle(message: Message) {
        if(message !is LoginRequest) return

        /*
         * Queue the login request for processing.
         */
        session.writeAndFlush(StatusResponse.NORMAL)
    }
}