package osrs.classic.server.event.player

import osrs.classic.server.event.PlayerEvent
import osrs.classic.server.game.entity.Player

class PlayerLogoutEvent(player: Player) : PlayerEvent(player)