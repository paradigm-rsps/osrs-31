package osrs.classic.server.net.game

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ClientPacket(val opcode: Int, val type: PacketType, val length: Int = 0)