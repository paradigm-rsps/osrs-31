package osrs.classic.server.net.login

import osrs.classic.server.game.entity.Player
import osrs.classic.server.net.Message
import osrs.classic.server.net.StatusResponse

data class LoginResponse(val status: StatusResponse, val player: Player) : Message