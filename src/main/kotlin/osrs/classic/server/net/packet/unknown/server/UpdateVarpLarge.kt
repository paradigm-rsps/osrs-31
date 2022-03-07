package osrs.classic.server.net.packet.unknown.server

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 70, type = PacketType.FIXED)
class UpdateVarpLarge(val id: Int, val value: Int) : Packet {
    companion object : Codec<UpdateVarpLarge> {
        override fun encode(session: Session, packet: UpdateVarpLarge, buf: ByteBuf) {
            buf.writeShort(packet.id)
            buf.writeIntLE(packet.value)
        }
    }
}