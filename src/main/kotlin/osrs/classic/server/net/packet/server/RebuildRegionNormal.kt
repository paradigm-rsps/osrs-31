package osrs.classic.server.net.packet.server

import io.guthix.buffer.writeByteNeg
import io.guthix.buffer.writeByteSub
import io.guthix.buffer.writeShortAdd
import io.netty.buffer.ByteBuf
import osrs.classic.server.game.entity.Player
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 2, type = PacketType.VARIABLE_SHORT)
class RebuildRegionNormal(val player: Player, var login: Boolean = false) : Packet {
    companion object : Codec<RebuildRegionNormal> {
        override fun encode(session: Session, packet: RebuildRegionNormal, buf: ByteBuf) {
            if (packet.login)
                buf.writeByte(2)
            buf.writeByteSub(0) // plane
            buf.writeShortLE(packet.player.scene.currentChunk.y)
            val xteaKeys = packet.player.scene.getRegionXteaKeys()
            xteaKeys.flatMap { it.toList() }.forEach { key -> buf.writeInt(key) }
            buf.writeShortLE(10) // SceneX - Lumby
            buf.writeShort(10) // SceneY - Lumby
            buf.writeShortAdd(packet.player.scene.currentChunk.x)
        }
    }
}