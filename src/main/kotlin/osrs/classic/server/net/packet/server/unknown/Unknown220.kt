package osrs.classic.server.net.packet.server.unknown

import io.guthix.buffer.writeByteAdd
import io.guthix.buffer.writeByteNeg
import io.guthix.buffer.writeShortAdd
import io.guthix.buffer.writeShortAddLE
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 220, type = PacketType.FIXED)
class Unknown220(val u1: Int, val value: Int) : Packet {
    companion object : Codec<Unknown220> {
        override fun encode(session: Session, packet: Unknown220, buf: ByteBuf) {
            buf.writeShortAddLE(packet.value) // AnimationCycleEnd
            buf.writeByte(0) // ?
            buf.writeByteNeg(0) // ?
            buf.writeByteAdd(0) // ?
            buf.writeByte(0) // ?
            buf.writeShortLE(0) // u PlayerIndex
            buf.writeByteAdd(0) // u ?
            buf.writeByteAdd(0) // ?
            buf.writeShort(0) // u ObjectID
            buf.writeShortAdd(0)// u AnimationCycleStart
        }
    }
}