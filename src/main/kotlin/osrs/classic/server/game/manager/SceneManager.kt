package osrs.classic.server.game.manager

import osrs.classic.server.XteaConfig
import osrs.classic.server.game.World
import osrs.classic.server.game.entity.Player
import osrs.classic.server.game.map.Chunk
import osrs.classic.server.net.packet.server.RebuildRegionNormal
import kotlin.math.abs

class SceneManager(private val player: Player) {

    private val world = World

    /**
     * The current chunk the player is in.
     */
    lateinit var currentChunk: Chunk private set

    internal fun initialize() {
        /*
         * Set the player's current chunk.
         */
        currentChunk = player.tile.toChunk()

        /*
         * Tell the client to rebuild the world regions with GPI data.
         */
        player.client.session.ctx.writeAndFlush(RebuildRegionNormal(player, gpi = true))
    }

    fun shouldRebuild(chunk: Chunk): Boolean {
        val dx = abs(currentChunk.x - chunk.x)
        val dy = abs(currentChunk.y - chunk.y)
       return dx > REBUILD_DISTANCE || dy > REBUILD_DISTANCE
    }

    fun checkReload() {
        val currChunk = player.tile.toChunk()
        if(shouldRebuild(currChunk)) {
            currentChunk = currChunk
            player.client.write(RebuildRegionNormal(player))
        }
    }

    fun getRegionXteaKeys(): List<IntArray> {
        val xteas = mutableListOf<IntArray>()

        var forceSend = false

        if((currentChunk.x / Chunk.SIZE == 48 || currentChunk.x / Chunk.SIZE == 49)
            && currentChunk.y / Chunk.SIZE == 48) {
            forceSend = true
        }

        if(currentChunk.x / Chunk.SIZE == 48 && currentChunk.y / Chunk.SIZE == 148) {
            forceSend = true
        }

        for(x in currentChunk.x.sceneMin..currentChunk.x.sceneMax) {
            for(y in currentChunk.y.sceneMin..currentChunk.y.sceneMax) {
                /*
                 * Do not send XTEA keys for tutorial island and surrounding
                 * regions if you are standing outside tutorial island.
                 */
                if(!forceSend || y != 49 && y != 149 && y != 147 && x != 50 && (x != 49 || y != 47)) {
                    val regionId = (x shl 8) or y
                    xteas.add(XteaConfig.regionKeys(regionId))
                }
            }
        }

        return xteas
    }

    internal fun synchronize() {
        checkReload()
    }

    internal fun postProcess() {

    }

    companion object {
        /**
         * The number of chunks away from the edge of the player's scene where we should
         * signal to rebuild the scene and re-center the player's base chunk.
         */
        private const val REBUILD_DISTANCE = 4

        private val Int.sceneMin: Int get() = (this - 6) / Chunk.SIZE
        private val Int.sceneMax: Int get() = (this + 6) / Chunk.SIZE
    }
}