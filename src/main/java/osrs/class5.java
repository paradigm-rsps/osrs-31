package osrs;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.math.BigInteger;

@ObfuscatedName("d")
public class class5 {
    @ObfuscatedName("nh")
    static int field73;
    @ObfuscatedName("i")
    static final BigInteger modulus = new BigInteger("10001", 16);
    @ObfuscatedName("w")
    static final BigInteger exponent = new BigInteger("d1b7a2b187c81341fde6dbe64541f50a9ad191209faa1e17cf5b02b78dcffca3a16a0492dc2e30f940b7c30159477bc769a574d3849a5e31a2a228dd351a0334602e483471301a5165b91586267196c2eaebbfb9cb9d349f57ba22ed0407185caf02e181efa69eb5b683ff9af0c72c99f2ce12ec4221e7fdec7718abc39a53f12ca59dae94d84b2ca34efd5094d3819a2d74605c82fd533b38dc5f7312e40d559b89d405aaa6c79939ed704b4ff042c240507ddc251646c3a5aac4ba05bfa4fd86094ec2e1673f6e7b175ac3905895e2092e0434057fb1b92707fea8222e5de4443b2f4716bf037863451b0579f85ed7bdf1fbc6c1f9fa9f603d504044a6bc8b", 16);
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "Lclass185;"
    )
    static LoginType field75;

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(Lclass151;)V"
    )
    public static void method41(AbstractArchive var0) {
        FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
    }

    @ObfuscatedName("t")
    static final int method39(int var0, int var1, int var2) {
        int var3 = 256 - var2;
        return ((var1 & '\uff00') * var2 + (var0 & '\uff00') * var3 & 16711680) + (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) >> 8;
    }

    @ObfuscatedName("p")
    public static void method38() {
        try {
            if (class137.musicPlayerStatus == 1) {
                int var0 = class137.midiPcmStream.method2916();
                if (var0 > 0 && class137.midiPcmStream.method2922()) {
                    var0 -= class65.pcmSampleLength;
                    if (var0 < 0) {
                        var0 = 0;
                    }

                    class137.midiPcmStream.method2975(var0);
                    return;
                }

                class137.midiPcmStream.method2951();
                class137.midiPcmStream.method2919();
                if (class137.musicTrackArchive != null) {
                    class137.musicPlayerStatus = 2;
                } else {
                    class137.musicPlayerStatus = 0;
                }

                FloorDecoration.musicTrack = null;
                class23.soundCache = null;
            }
        } catch (Exception var2) {
            var2.printStackTrace();
            class137.midiPcmStream.method2951();
            class137.musicPlayerStatus = 0;
            FloorDecoration.musicTrack = null;
            class23.soundCache = null;
            class137.musicTrackArchive = null;
        }

    }

    @ObfuscatedName("az")
    static final void updateScene(int chunkX, int chunkY, int clientPlane, int tileX, int tileY) {
        if (chunkX != Client.chunkX || Client.chunkY != chunkY || clientPlane != Client.renderPlane && Client.isLowDetail) {
            Client.chunkX = chunkX;
            Client.chunkY = chunkY;
            Client.renderPlane = clientPlane;
            if (!Client.isLowDetail) {
                Client.renderPlane = 0;
            }

            NPC.updateGameState(25);
            class27.method570("Loading - please wait.", true);
            int var5 = FaceNormal.baseX;
            int var6 = Frames.baseY;
            FaceNormal.baseX = (chunkX - 6) * 8;
            Frames.baseY = (chunkY - 6) * 8;
            int spawnX = FaceNormal.baseX - var5;
            int spawnY = Frames.baseY - var6;
            var5 = FaceNormal.baseX;
            var6 = Frames.baseY;

            int index;
            int var11;
            for (index = 0; index < 32768; ++index) {
                NPC var21 = Client.npcs[index];
                if (var21 != null) {
                    for (var11 = 0; var11 < 10; ++var11) {
                        var21.pathX[var11] -= spawnX;
                        var21.pathY[var11] -= spawnY;
                    }

                    var21.x -= spawnX * 128;
                    var21.y -= spawnY * 128;
                }
            }

            for (index = 0; index < 2048; ++index) {
                Player var24 = Client.players[index];
                if (var24 != null) {
                    for (var11 = 0; var11 < 10; ++var11) {
                        var24.pathX[var11] -= spawnX;
                        var24.pathY[var11] -= spawnY;
                    }

                    var24.x -= spawnX * 128;
                    var24.y -= spawnY * 128;
                }
            }

            class22.scenePlane = clientPlane;
            Tiles.localPlayer.setPosition(tileX, tileY, false);
            byte var22 = 0;
            byte var10 = 104;
            byte var23 = 1;
            if (spawnX < 0) {
                var22 = 103;
                var10 = -1;
                var23 = -1;
            }

            byte var12 = 0;
            byte var13 = 104;
            byte var14 = 1;
            if (spawnY < 0) {
                var12 = 103;
                var13 = -1;
                var14 = -1;
            }

            for (int var15 = var22; var10 != var15; var15 += var23) {
                for (int var16 = var12; var16 != var13; var16 += var14) {
                    int var17 = spawnX + var15;
                    int var18 = var16 + spawnY;

                    for (int var19 = 0; var19 < 4; ++var19) {
                        if (var17 >= 0 && var18 >= 0 && var17 < 104 && var18 < 104) {
                            Client.groundItems[var19][var15][var16] = Client.groundItems[var19][var17][var18];
                        } else {
                            Client.groundItems[var19][var15][var16] = null;
                        }
                    }
                }
            }

            for (PendingSpawn spawn = (PendingSpawn) Client.pendingSpawns.method3533(); spawn != null; spawn = (PendingSpawn) Client.pendingSpawns.method3535()) {
                spawn.x -= spawnX;
                spawn.y -= spawnY;
                if (spawn.x < 0 || spawn.y < 0 || spawn.x >= 104 || spawn.y >= 104) {
                    spawn.remove();
                }
            }

            if (Client.field715 != 0) {
                Client.field715 -= spawnX;
                Client.field716 -= spawnY;
            }

            Client.soundEffectCount = 0;
            Client.isCameraLocked = false;
            Client.field710 = -1;
            Client.field620.method3527();
            Client.field619.method3527();
        }
    }

    @ObfuscatedName("dy")
    static final void method40(String var0) {
        if (ItemComposition.field1026 != null) {
            Client.rsaBuf.writeByteOpcode(209);
            PacketBuffer var1 = Client.rsaBuf;
            int var2 = var0.length() + 1;
            var1.writeByte(var2);
            Client.rsaBuf.writeStringCp1252NullTerminated(var0);
        }
    }
}
