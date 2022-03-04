package osrs.classic.server.net.packet.server

import io.guthix.buffer.writeShortAdd
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 37, type = PacketType.FIXED)
class CAM_MOVETO() : Packet {
    companion object : Codec<CAM_MOVETO> {
        override fun encode(session: Session, packet: CAM_MOVETO, buf: ByteBuf) {
            buf.writeByte(0) //u ?
            buf.writeByte(0) //u ?
            buf.writeShort(0) //u ?
            buf.writeByte(0) //u ?
            buf.writeByte(0) //u ?
        }
    }
}