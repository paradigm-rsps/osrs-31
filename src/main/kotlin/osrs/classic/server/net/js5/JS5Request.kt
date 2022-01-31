package osrs.classic.server.net.js5

import osrs.classic.server.net.Message


data class JS5Request(val archive: Int, val group: Int) : osrs.classic.server.net.Message