package osrs.classic.server.net.packet.unknown.server

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 79, type = PacketType.VARIABLE_SHORT)
class UpdateNpcSmall(val buf: ByteBuf) : Packet {
    companion object : Codec<UpdateNpcSmall> {
        override fun encode(session: Session, packet: UpdateNpcSmall, buf: ByteBuf) {
            buf.writeBytes(packet.buf)
        }
    }
}