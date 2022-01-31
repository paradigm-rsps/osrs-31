package osrs.classic.server.game.manager

import osrs.classic.server.game.entity.Npc
import osrs.classic.server.game.entity.Player
import osrs.classic.server.game.entity.update.NpcUpdateTask
import osrs.classic.server.net.packet.server.UpdateNpcSmall

class NpcManager(
    private val player: Player,
    private val npcs: MutableList<Npc> = mutableListOf()
) : MutableList<Npc> by npcs {

    internal fun synchronize() {
        val buf = player.client.session.channel.alloc().buffer()
        val task = NpcUpdateTask(player)
        task.execute(buf)

        /*
         * Send the NPC update task's data in the UpdateNpcSmall packet to the client.
         */
        player.client.write(UpdateNpcSmall(buf))
    }

}