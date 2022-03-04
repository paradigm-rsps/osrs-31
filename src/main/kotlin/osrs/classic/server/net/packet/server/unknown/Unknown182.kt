package osrs.classic.server.net.packet.server.unknown

import io.guthix.buffer.*
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 182, type = PacketType.FIXED)
class Unknown182(val u1: Int, val value: Int) : Packet {
    companion object : Codec<Unknown182> {
        override fun encode(session: Session, packet: Unknown182, buf: ByteBuf) {
            buf.writeShortAdd(0) // u AnimationCycleEnd
            buf.writeByteSub(0) // u
            buf.writeByteAdd(0) // u
        }
    }
}