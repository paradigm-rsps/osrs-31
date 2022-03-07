package osrs.classic.server.net.packet.unknown.server

import io.guthix.buffer.writeByteAdd
import io.guthix.buffer.writeShortAdd
import io.netty.buffer.ByteBuf
import osrs.classic.server.game.interfaces.InterfaceType
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 83, type = PacketType.FIXED)
class IfOpenSub(val parent: Int, val child: Int, val interfaceId: Int, val type: InterfaceType) : Packet {
    companion object : Codec<IfOpenSub> {
        override fun encode(session: Session, packet: IfOpenSub, buf: ByteBuf) {
            val component = (packet.parent shl 16) or packet.child
            buf.writeByteAdd(packet.type.id)
            buf.writeShortAdd(packet.interfaceId)
            buf.writeInt(component)
        }
    }
}