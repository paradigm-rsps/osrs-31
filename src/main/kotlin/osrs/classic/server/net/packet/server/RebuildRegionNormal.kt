package osrs.classic.server.net.packet.server

import io.guthix.buffer.writeShortAdd
import io.netty.buffer.ByteBuf
import osrs.classic.server.game.entity.Player
import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Codec
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 2, type = PacketType.VARIABLE_SHORT)
class RebuildRegionNormal(
    val player: Player,
    val gpi: Boolean = false
) : Packet {
    companion object : Codec<RebuildRegionNormal> {
        override fun encode(session: Session, packet: RebuildRegionNormal, buf: ByteBuf) {
            buf.writeShortAdd(packet.player.scene.currentChunk.y)
            buf.writeShortLE(packet.player.scene.currentChunk.x)

            val xteaKeys = packet.player.scene.getRegionXteaKeys()

            buf.writeShort(xteaKeys.size)
            xteaKeys.flatMap { it.toList() }.forEach { key -> buf.writeInt(key) }
        }
    }
}