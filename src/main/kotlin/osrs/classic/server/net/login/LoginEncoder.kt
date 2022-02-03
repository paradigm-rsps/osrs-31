package osrs.classic.server.net.login

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Message
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.GameProtocol

class LoginEncoder(private val session: Session) {

    fun encode(message: Message, out: ByteBuf) {
        if(message !is LoginResponse) return

        out.writeByte(message.status.opcode)
        out.writeByte(message.player.privilege.id)
        out.writeBoolean(message.player.privilege.id >= 1)
        out.writeShort(message.player.index)
        out.writeBoolean(message.player.member)

        println("Fired login encoder - index: ${message.player.index}")
    }

}