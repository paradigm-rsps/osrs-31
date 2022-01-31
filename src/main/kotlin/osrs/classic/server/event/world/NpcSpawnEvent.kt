package osrs.classic.server.event.world

import osrs.classic.server.event.WorldEvent
import osrs.classic.server.game.entity.Npc

class NpcSpawnEvent(val npc: Npc) : WorldEvent()