package osrs.classic.server.game.entity.pathfinder

import osrs.classic.server.game.entity.pathfinder.destination.Destination
import osrs.classic.server.game.map.Tile

interface Pathfinder {

    fun calculatePath(start: Tile, destination: Destination): MutableList<Tile>
}