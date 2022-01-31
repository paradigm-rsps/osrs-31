package osrs.classic.server.event.player

import osrs.classic.server.event.PlayerEvent
import osrs.classic.server.game.MovementType
import osrs.classic.server.game.entity.Player

class PlayerMoveEvent(player: Player, val type: MovementType) : PlayerEvent(player)