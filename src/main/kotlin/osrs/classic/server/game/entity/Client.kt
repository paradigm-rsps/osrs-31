package osrs.classic.server.game.entity

import osrs.classic.server.net.Session
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.util.logger.Logger
import java.util.*

class Client(val session: Session) {

    internal val packetQueue = LinkedList<Packet>()

    val player: Player = Player(this)

    var resizableMode: Boolean = false
    var width: Int = 0
    var height: Int = 0

    internal fun processPackets() {
        for(i in 0 until MAX_PACKETS_PER_CYCLE) {
            val packet = packetQueue.poll() ?: break
            try {
                packet.handle(session)
            } catch (e : Exception) {
                e.printStackTrace()
                Logger.error("An error occurred while handling a client packet: ${packet::class.simpleName}.")
            }
        }
    }

    fun write(packet: Packet) {
        session.write(packet)
    }

    fun writeAndFlush(packet: Packet) {
        session.writeAndFlush(packet)
    }

    fun flush() {
        session.flush()
    }

    companion object {
        private const val MAX_PACKETS_PER_CYCLE = 16
    }
}