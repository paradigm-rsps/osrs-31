package dev.avernic.server.cache.config

import io.netty.buffer.ByteBuf
import osrs.classic.server.cache.config.Config
import osrs.classic.server.cache.config.ConfigCompanion

class VarClientConfig(override val id: Int) : Config(id) {
    var isPersistent: Boolean = false

    companion object : ConfigCompanion<VarClientConfig>() {
        override val id: Int = 19

        override fun decode(id: Int, data: ByteBuf): VarClientConfig {
            val varClientConfig = VarClientConfig(id)
            decoder@ while(true) {
                when(val opcode = data.readUnsignedByte().toInt()) {
                    0 -> break@decoder
                    2 -> varClientConfig.isPersistent = true
                    else -> throw IllegalStateException("Unknown opcode: $opcode.")
                }
            }
            return varClientConfig
        }
    }
}