package osrs.classic.server.net.handshake

import osrs.classic.server.net.StatusResponse

data class HandshakeResponse(val status: StatusResponse, val seed: Long) : osrs.classic.server.net.Message