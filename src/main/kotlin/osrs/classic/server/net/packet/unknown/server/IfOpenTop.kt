package osrs.classic.server.net.packet.unknown.server

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 87, type = PacketType.FIXED)
class IfOpenTop(val interfaceId: Int) : Packet {
    companion object : Codec<IfOpenTop> {
        override fun encode(session: Session, packet: IfOpenTop, buf: ByteBuf) {
            buf.writeShort(packet.interfaceId)
        }
    }
}