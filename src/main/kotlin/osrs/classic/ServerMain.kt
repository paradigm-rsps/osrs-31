package osrs.classic

import kotlinx.coroutines.InternalCoroutinesApi
import osrs.classic.server.Cycle
import osrs.classic.server.XteaConfig
import osrs.classic.server.cache.GameCache
import osrs.classic.server.net.game.GamePackets
import osrs.classic.server.service.ServiceManager
import osrs.classic.server.util.RSA
import osrs.classic.server.util.logger.Logger
import java.net.InetSocketAddress

@InternalCoroutinesApi
class ServerMain {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Logger.header = "Server"
            GameCache.load()
            ServiceManager.initialize()
            GamePackets.loadPackets()
            XteaConfig.load()
            Cycle.start(600)
            RSA.load()
            NetworkServer.bind(InetSocketAddress("127.0.0.1", 43594))
            Thread.sleep(2000)
            Logger.header = "Client"
            ClientMain.main(null)
        }
    }


}