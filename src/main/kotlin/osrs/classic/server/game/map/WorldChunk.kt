package osrs.classic.server.game.map

import osrs.classic.server.game.World
import osrs.classic.server.game.entity.GameObject
import osrs.classic.server.game.entity.Npc
import osrs.classic.server.game.entity.Player


class WorldChunk(
    val x: Int,
    val y: Int,
    val plane: Int
) {

    val world = World

    /*
     * Persistent properties.
     */

    val masks = Array(Chunk.SIZE) { IntArray(Chunk.SIZE) }
    internal val loadedPlayers = mutableListOf<Player>()
    val players = mutableListOf<Player>()
    val npcs = mutableListOf<Npc>()
    val staticObjects = mutableMapOf<Int, GameObject>()

    fun addCollision(x: Int, y: Int, mask: Int) {
        masks[x][y] = masks[x][y] or mask
    }

    fun removeCollision(x: Int, y: Int, mask: Int) {
        masks[x][y] = masks[x][y] and mask.inv()
    }

    fun getCollision(tile: Tile): Int = masks[tile.x % Chunk.SIZE][tile.y % Chunk.SIZE]

    fun getCollision(x: Int, y: Int, plane: Int = 0): Int = getCollision(Tile(x, y, plane))


}