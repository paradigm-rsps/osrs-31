package osrs.classic.server.net.login

import osrs.classic.server.net.StatusResponse

class LoginError(val status: StatusResponse) : RuntimeException()