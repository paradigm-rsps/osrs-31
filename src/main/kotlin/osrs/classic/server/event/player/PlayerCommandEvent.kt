package osrs.classic.server.event.player

import osrs.classic.server.event.PlayerEvent
import osrs.classic.server.game.entity.Player

class PlayerCommandEvent(player: Player, val command: String, val args: List<String>) : PlayerEvent(player) {
}