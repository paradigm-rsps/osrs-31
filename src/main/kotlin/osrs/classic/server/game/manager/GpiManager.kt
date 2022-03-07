package osrs.classic.server.game.manager

import io.guthix.buffer.toBitMode
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import osrs.classic.server.game.World
import osrs.classic.server.game.entity.Player
import osrs.classic.server.game.entity.update.PlayerUpdateTask
import osrs.classic.server.net.packet.unknown.server.PlayerUpdate

class GpiManager(private val player: Player) {

    private val world = World

    var localPlayerCount: Int = 0
    val localPlayers = arrayOfNulls<Player>(World.MAX_PLAYERS)
    val localPlayerIndexes = IntArray(World.MAX_PLAYERS)

    var externalPlayerCount = 0
    val externalPlayerIndexes = IntArray(World.MAX_PLAYERS)

    val tileMultipliers = IntArray(World.MAX_PLAYERS)

    val skipFlags = IntArray(World.MAX_PLAYERS)

    internal fun initialize() {
        localPlayers[player.index] = player
        localPlayerIndexes[localPlayerCount++] = player.index
        for(index in 1 until World.MAX_PLAYERS) {
            if(index != player.index) {
                val externalPlayer = world.players[index]
                tileMultipliers[index] = externalPlayer?.tile?.as18BitInteger ?: 0
                externalPlayerIndexes[externalPlayerCount++] = index
            }
        }
    }

    internal fun synchronize() {
        val updateBuf = Unpooled.buffer()
        val task = PlayerUpdateTask(player)
        task.execute(updateBuf)

        /*
         * Send the player update packet with the encoded data.
         */
        player.client.write(PlayerUpdate(updateBuf))
    }

    internal fun encode(buf: ByteBuf) {
        val gpiBuf = Unpooled.buffer()
        val bitBuf = gpiBuf.toBitMode()

        bitBuf.writeBits(player.tile.as30BitInteger, 30)

        for(index in 1 until World.MAX_PLAYERS) {
            if(index != player.index) {
                bitBuf.writeBits(tileMultipliers[index], 18)
            }
        }

        bitBuf.toByteMode()
        val gpiBytes = ByteArray(gpiBuf.readableBytes())
        gpiBuf.readBytes(gpiBytes)

        buf.writeBytes(gpiBytes)
    }

    companion object {

        /**
         * The distance that players and entities are rendered from the local player.
         */
        const val RENDER_DISTANCE = 15
    }
}