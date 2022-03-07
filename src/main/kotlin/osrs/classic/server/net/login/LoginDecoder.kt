package osrs.classic.server.net.login

import io.guthix.buffer.readString0CP1252
import io.guthix.buffer.readStringCP1252
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import osrs.classic.server.net.Session
import osrs.classic.server.net.StatusResponse
import osrs.classic.server.util.RSA
import osrs.classic.server.util.Xtea
import java.math.BigInteger

class LoginDecoder(private val session: Session) {

    private val rsa = RSA

    private var stage = Stage.HANDSHAKE
    private var retries = 0
    private var payloadLength = 0

    private lateinit var loginType: LoginType

    fun decode(buf: ByteBuf, out: MutableList<Any>) {
        try {
            when(stage) {
                Stage.HANDSHAKE -> decodeHandshake(buf, out)
                Stage.HEADER -> decodeHeader(buf, out)
                Stage.PAYLOAD -> decodePayload(buf, out)
            }
        } catch(e : LoginError) {
            session.writeAndClose(e.status)
            return
        }
    }

    private fun decodeHandshake(buf: ByteBuf, out: MutableList<Any>) {
        loginType = LoginType.fromOpcode(buf.readUnsignedByte().toInt())

        /*
         * Check if login type is a reconnection.
         */

        stage = Stage.HEADER
    }

    private fun decodeHeader(buf: ByteBuf, out: MutableList<Any>) {
        payloadLength = buf.readUnsignedShort()

        if(payloadLength == 0) {
            throw LoginError(StatusResponse.COULD_NOT_COMPLETE_LOGIN)
        }

        retries = 0
        stage = Stage.PAYLOAD
    }

    private fun decodePayload(buf: ByteBuf, out: MutableList<Any>) {
        if(buf.readableBytes() < payloadLength) {
            retry()
            return
        }

        val clientRevision = buf.readInt()
        if(clientRevision != 31) {
            throw LoginError(StatusResponse.OUT_OF_DATE)
        }

        val rsaBuf = run {
            val length = buf.readUnsignedShort()//skip 2 bytes cuz fuck you, thats why.
            buf.decryptRSA(rsa.privateExponent, rsa.privateModulus, length)
        }

        val payload = ByteArray(buf.readableBytes())
        buf.readBytes(payload)

        /*
         * ======== RSA BUFFER DECODE =========
         */

        val decryptCheck = rsaBuf.readByte().toInt()
        if(decryptCheck != 10) {
            throw LoginError(StatusResponse.COULD_NOT_COMPLETE_LOGIN)
        }

        val xteas = IntArray(4) { rsaBuf.readInt() }
        val seed = rsaBuf.readLong()
        if(seed != 0L) {
            throw LoginError(StatusResponse.COULD_NOT_COMPLETE_LOGIN)
        }

        val password: String = rsaBuf.readStringCP1252()


        /*
         * ======== XTEA BUFFER DECODE =======
         */

        val xteaBuf = Unpooled.wrappedBuffer(Xtea.decipher(payload, xteas))

        val username = xteaBuf.readStringCP1252()
        if(username.isBlank()
            || Regex("[^a-zA-Z0-9\\d ]").containsMatchIn(username)
        ) {
            throw LoginError(StatusResponse.INVALID_CREDENTIALS)
        }

        val isLowDetail = xteaBuf.readByte()
        ByteArray(24) { xteaBuf.readByte() }

        val request = LoginRequest(
            session,
            loginType,
            0,
            xteas,
            seed,
            password,
            username,
        )
        out.add(request)
    }

    private fun retry() {
        retries++
        if(retries >= MAX_RETRIES) {
            throw LoginError(StatusResponse.COULD_NOT_COMPLETE_LOGIN)
        }
    }

    private fun ByteBuf.decryptRSA(exponent: BigInteger, modulus: BigInteger, length: Int): ByteBuf {
        val bytes = ByteArray(length)
        readBytes(bytes)
        return Unpooled.wrappedBuffer(BigInteger(bytes).modPow(exponent, modulus).toByteArray())
    }

    enum class Stage {
        HANDSHAKE,
        HEADER,
        PAYLOAD;
    }

    companion object {

        private const val MAX_RETRIES = 5

    }
}