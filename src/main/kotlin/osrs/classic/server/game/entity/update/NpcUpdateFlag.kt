package osrs.classic.server.game.entity.update

import io.netty.buffer.ByteBuf
import osrs.classic.server.game.entity.Npc

class NpcUpdateFlag(
    priority: Int,
    mask: Int,
    val encode: ByteBuf.(Npc) -> Unit
) : UpdateFlag(priority, mask) {
    /*
     * NPC Update flag encoders.
     */

}