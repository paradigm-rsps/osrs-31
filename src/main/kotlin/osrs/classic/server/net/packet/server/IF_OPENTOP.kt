package osrs.classic.server.net.packet.server

import io.guthix.buffer.writeShortAdd
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 69, type = PacketType.FIXED)
class IF_OPENTOP(var id: Int) : Packet {
    companion object : Codec<IF_OPENTOP> {
        override fun encode(session: Session, packet: IF_OPENTOP, buf: ByteBuf) {
            buf.writeShortAdd(packet.id) // ?
        }
    }
}