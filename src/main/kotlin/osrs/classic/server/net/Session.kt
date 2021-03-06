package osrs.classic.server.net

import io.netty.channel.ChannelHandlerContext
import osrs.classic.server.game.entity.Client
import osrs.classic.server.net.game.GameProtocol
import osrs.classic.server.net.game.Packet
import osrs.classic.server.net.handshake.HandshakeProtocol
import osrs.classic.server.util.IsaacRandom
import osrs.classic.server.util.logger.Logger
import java.util.concurrent.atomic.AtomicReference
import kotlin.random.Random
import kotlin.random.nextLong

class Session(val ctx: ChannelHandlerContext) {

    val channel get() = ctx.channel()

    internal lateinit var client: Client

    var seed = Random.nextLong(0.. Long.MAX_VALUE)

    var xteas = IntArray(4) { 0 }
    var reconnectXteas: IntArray? = null

    val protocol = AtomicReference<Protocol>(null)

    val encoderIsaac = IsaacRandom()
    val decoderIsaac = IsaacRandom()

    internal fun onConnect() {
        /*
         * Set the initial protocol as the HandshakeProtocol.
         */
        protocol.set(HandshakeProtocol(this))
    }

    internal fun onDisconnect() {
        if(protocol.get() is GameProtocol) {
/*            client.player.logout()*/
        }
    }

    internal fun onMessage(message: Message) {
        if(protocol.get() is GameProtocol && message is Packet) {
            print(message)
            client.packetQueue.add(message)
        } else {
            protocol.get().handle(message)
        }
    }

    internal fun onError(cause: Throwable) {
        if(cause.stackTrace.isEmpty()
            || (cause.stackTrace[0].methodName != "read0" && cause.stackTrace[0].methodName != "callDecode")
        ) {
            cause.printStackTrace()
            Logger.error("An error occurred in session networking thread. [method: ${cause.stackTrace[0].methodName}]" )
            this.disconnect()
        }
    }

    fun disconnect() {
        if(channel.isActive) {
            channel.close()
        }
    }

    fun write(message: Message) = ctx.write(message)

    fun writeAndFlush(message: Message) = ctx.writeAndFlush(message)

    fun flush() = ctx.flush()

    fun writeAndClose(message: Message) {
        writeAndFlush(message).addListener {
            if(it.isSuccess) {
                this.disconnect()
            }
        }
    }
}