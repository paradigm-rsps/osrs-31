package osrs.classic.server.net.pipeline

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder
import osrs.classic.server.net.StatusResponse

class GameChannelEncoder(private val handler: GameChannelHandler) : MessageToByteEncoder<osrs.classic.server.net.Message>() {
    override fun encode(ctx: ChannelHandlerContext, msg: osrs.classic.server.net.Message, out: ByteBuf) {
        val session = handler.session.get()
        val protocol = session.protocol.get()

        if(msg is StatusResponse) {
            out.writeByte(msg.opcode)
        } else {
            protocol.encode(msg, out)
        }
    }
}