package osrs.classic.server.net.packet.server

import io.guthix.buffer.writeShortAdd
import io.guthix.buffer.writeShortAddLE
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 207, type = PacketType.FIXED)
class IF_SETANGLE() : Packet {
    companion object : Codec<IF_SETANGLE> {
        override fun encode(session: Session, packet: IF_SETANGLE, buf: ByteBuf) {
            buf.writeShort(0) //u ModelAngleX
            buf.writeInt(0) //u ?
            buf.writeShortAddLE(0) //u ModelAngleY
            buf.writeShortAdd(0) //u ?
        }
    }
}