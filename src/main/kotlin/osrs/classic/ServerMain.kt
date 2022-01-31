package osrs.classic

import osrs.classic.server.cache.GameCache
import osrs.classic.server.service.ServiceManager
import osrs.classic.server.util.RSA
import java.net.InetSocketAddress

class ServerMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GameCache.load()
            ServiceManager.initialize()
            RSA.load()
            NetworkServer.bind(InetSocketAddress("127.0.0.1", 43594))
        }
    }
}