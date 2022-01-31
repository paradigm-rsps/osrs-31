package osrs.classic.server.net.packet.server

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 38, type = PacketType.VARIABLE_SHORT)
class PlayerUpdate(val payload: ByteBuf) : Packet {
    companion object : Codec<PlayerUpdate> {
        override fun encode(session: Session, packet: PlayerUpdate, buf: ByteBuf) {
            buf.writeBytes(packet.payload)
        }
    }
}