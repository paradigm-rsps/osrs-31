package osrs.classic.server.event.player.packet

import osrs.classic.server.event.PlayerEvent
import osrs.classic.server.game.entity.Player
import osrs.classic.server.game.map.Tile

class MinimapClickEvent(player: Player, val tile: Tile) : PlayerEvent(player)