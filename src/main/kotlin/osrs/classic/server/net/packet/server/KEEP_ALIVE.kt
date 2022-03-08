package osrs.classic.server.net.packet.server

import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.game.PacketType
import osrs.classic.server.net.game.ServerPacket

@ServerPacket(opcode = 255, type = PacketType.FIXED)
class KEEP_ALIVE : Packet