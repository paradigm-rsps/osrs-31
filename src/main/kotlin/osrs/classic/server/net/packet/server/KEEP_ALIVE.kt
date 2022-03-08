package osrs.classic.server.net.packet.server

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 255, type = PacketType.FIXED)
class KEEP_ALIVE : Packet {
    companion object : Codec<KEEP_ALIVE> {
        override fun encode(session: Session, packet: KEEP_ALIVE, buf: ByteBuf) {}
    }
}