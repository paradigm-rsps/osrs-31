package osrs.classic.server.event.player

import osrs.classic.server.event.PlayerEvent
import osrs.classic.server.game.entity.Player

class PlayerLoginEvent(player: Player) : PlayerEvent(player)