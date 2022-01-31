package osrs.classic.server.game.entity

import osrs.classic.server.game.map.Tile

interface Entity {

    val tile: Tile

    var orientation: Int

}