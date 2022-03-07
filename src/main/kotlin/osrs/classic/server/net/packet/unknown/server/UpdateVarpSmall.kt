package osrs.classic.server.net.packet.unknown.server

import io.guthix.buffer.writeByteNeg
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 69, type = PacketType.FIXED)
class UpdateVarpSmall(val id: Int, val value: Int) : Packet {
    companion object : Codec<UpdateVarpSmall> {
        override fun encode(session: Session, packet: UpdateVarpSmall, buf: ByteBuf) {
            buf.writeByteNeg(packet.value)
            buf.writeShortLE(packet.id)
        }
    }
}