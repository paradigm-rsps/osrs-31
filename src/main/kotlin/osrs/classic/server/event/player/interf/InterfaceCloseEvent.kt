package osrs.classic.server.event.player.interf

import osrs.classic.server.event.PlayerEvent
import osrs.classic.server.game.entity.Player

class InterfaceCloseEvent(player: Player, val interfaceId: Int) : PlayerEvent(player)