package osrs.classic.server.net.login

import osrs.classic.server.net.Message
import osrs.classic.server.net.Session

data class LoginRequest(
    val session: Session,
    val loginType: LoginType,
    val clientType: Int,
    val xteas: IntArray,
    val seed: Long,
    val password: String?,
    val username: String,
) : Message {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LoginRequest

        if (session != other.session) return false
        if (loginType != other.loginType) return false
        if (clientType != other.clientType) return false
        if (!xteas.contentEquals(other.xteas)) return false
        if (seed != other.seed) return false
        if (password != other.password) return false
        if (username != other.username) return false

        return true
    }

    override fun hashCode(): Int {
        var result = session.hashCode()
        result = 31 * result + loginType.hashCode()
        result = 31 * result + clientType
        result = 31 * result + xteas.contentHashCode()
        result = 31 * result + seed.hashCode()
        result = 31 * result + (password?.hashCode() ?: 0)
        result = 31 * result + username.hashCode()
        return result
    }
}