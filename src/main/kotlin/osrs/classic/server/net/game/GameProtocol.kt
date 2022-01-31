package osrs.classic.server.net.game

import io.netty.buffer.ByteBuf
import osrs.classic.server.net.Message
import osrs.classic.server.net.Protocol
import osrs.classic.server.net.Session

class GameProtocol(session: osrs.classic.server.net.Session) : osrs.classic.server.net.Protocol(session) {

    private val encoder = PacketEncoder(this)
    private val decoder = PacketDecoder(this)

    override fun encode(message: osrs.classic.server.net.Message, out: ByteBuf) {
        if(message !is Packet) return
        encoder.encode(message, out)
    }

    override fun decode(buf: ByteBuf, out: MutableList<Any>) {
        if(buf.readableBytes() > 0) {
            decoder.decode(buf, out)
        } else {
            val codec = GamePackets.CLIENT.getCodec(-1)
            val packet = codec.decode(session, buf)
            out.add(packet)
        }
    }

    override fun handle(message: osrs.classic.server.net.Message) {
        if(message !is Packet) return
        message.handle(session)
    }

}