package osrs.classic

import osrs.classic.server.cache.GameCache
import osrs.classic.server.net.game.GamePackets
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
            GamePackets.loadPackets()
            NetworkServer.bind(InetSocketAddress("127.0.0.1", 43594))
            Thread.sleep(2000)
            ClientMain.main(null)
        }
    }
}