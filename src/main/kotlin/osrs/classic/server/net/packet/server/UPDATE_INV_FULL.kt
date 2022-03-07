package osrs.classic.server.net.packet.server

import io.guthix.buffer.writeShortAdd
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 102, type = PacketType.FIXED)
class UPDATE_INV_FULL() : Packet {
    companion object : Codec<UPDATE_INV_FULL> {
        override fun encode(session: Session, packet: UPDATE_INV_FULL, buf: ByteBuf) {
            buf.writeInt(0) // Key
            buf.writeShort(0) // Container
            buf.writeShort(0) // Items length
            //buf.write(items) // Items
        }
    }
}