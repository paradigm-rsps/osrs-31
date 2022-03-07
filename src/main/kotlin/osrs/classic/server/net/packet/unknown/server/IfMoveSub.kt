package osrs.classic.server.net.packet.unknown.server

import io.guthix.buffer.writeIntME
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 60)
class IfMoveSub(
    val fromParent: Int,
    val fromChild: Int,
    val toParent: Int,
    val toChild: Int
) : Packet {
    companion object : Codec<IfMoveSub> {
        override fun encode(session: Session, packet: IfMoveSub, buf: ByteBuf) {
            val from = (packet.fromParent shl 16) or packet.fromChild
            val to = (packet.toParent shl 16) or packet.toChild
            buf.writeIntME(from)
            buf.writeInt(to)
        }
    }
}