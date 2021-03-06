package osrs.classic.server.net.packet.server

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 71, type = PacketType.FIXED)
class IF_SETCOLOUR : Packet {
    companion object : Codec<IF_SETCOLOUR> {
        override fun encode(session: Session, packet: IF_SETCOLOUR, buf: ByteBuf) {
            buf.writeShort(0) // ?
            //buf.writeIntLE(0) // ?
        }
    }
}