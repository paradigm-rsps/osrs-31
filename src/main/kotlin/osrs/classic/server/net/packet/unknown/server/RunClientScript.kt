package osrs.classic.server.net.packet.unknown.server

import io.guthix.buffer.writeStringCP1252
import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 91, type = PacketType.VARIABLE_SHORT)
class RunClientScript(val id: Int, vararg val params: Any) : Packet {
    companion object : Codec<RunClientScript> {
        override fun encode(session: Session, packet: RunClientScript, buf: ByteBuf) {
            val paramBuilder = StringBuilder()
            for(param in packet.params.reversed()) {
                if(param is String) {
                    paramBuilder.append("s")
                } else {
                    paramBuilder.append("i")
                }
            }
            buf.writeStringCP1252("$paramBuilder")
            for(param in packet.params) {
                if(param is String) {
                    buf.writeStringCP1252(param)
                } else {
                    buf.writeInt(param as Int)
                }
            }
            buf.writeInt(packet.id)
        }
    }
}