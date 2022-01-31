package osrs.classic.server.event.player.interf

import osrs.classic.server.event.PlayerEvent
import osrs.classic.server.game.entity.Player

class InterfaceOpenEvent(player: Player, val interfaceId: Int) : PlayerEvent(player)