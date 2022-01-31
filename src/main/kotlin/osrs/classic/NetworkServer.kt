package osrs.classic

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import osrs.classic.server.net.pipeline.GameChannelInitializer
import osrs.classic.server.net.util.logger.Logger
import java.net.InetSocketAddress
import kotlin.system.exitProcess

object NetworkServer {
    private val bossGroup = NioEventLoopGroup(2)
    private val workerGroup = NioEventLoopGroup(1)
    private val bootstrap = ServerBootstrap()

    private val channelInitializer = GameChannelInitializer()

    init {
        bootstrap.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel::class.java)
            .childHandler(channelInitializer)
            .childOption(ChannelOption.TCP_NODELAY, true)
            .childOption(ChannelOption.SO_KEEPALIVE, true)
    }

    fun bind(address: InetSocketAddress) {
        Logger.info("Attempting to bind networking socket to ${address.hostString}:${address.port}.")

        bootstrap.bind(address).addListener {
            if(it.isSuccess) {
                onBindSuccess(address)
            } else {
                onBindFailure(address, it.cause())
            }
        }
    }

    fun shutdown() {
        Logger.info("Shutting down networking server.")
        bossGroup.shutdownGracefully()
        workerGroup.shutdownGracefully()
    }

    private fun onBindSuccess(address: InetSocketAddress) {
        Logger.info("Server networking socket is now listening on ${address.hostString}:${address.port}...")
    }

    private fun onBindFailure(address: InetSocketAddress, cause: Throwable) {
        cause.printStackTrace()
        Logger.error("An error occurred when binding the socket to ${address.hostString}:${address.port}.")
        exitProcess(-1)
    }
}