package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import osrs.cache.Definitions;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@ObfuscatedName("a")
public class class10 {
    @ObfuscatedName("m")
    @Export("JagexCache_idxFiles")
    @ObfuscatedSignature(
            descriptor = "[Lclass29;"
    )
    public static BufferedFile[] JagexCache_idxFiles;
    @ObfuscatedName("bh")
    @Export("archive9")
    @ObfuscatedSignature(
            descriptor = "Lclass153;"
    )
    static Archive archive9;
    @ObfuscatedName("i")
    String field177;
    @ObfuscatedName("w")
    String field178;

    @ObfuscatedName("i")
    public static void method135() {
        class181.reflectionChecks = new NodeDeque();
    }

    @ObfuscatedName("w")
    static void method132(File var0, File var1) {
        try {
            AccessFile var2 = new AccessFile(class183.JagexCache_locationFile, "rw", 10000L);
            Buffer var3 = new Buffer(500);
            var3.writeByte(3);
            var3.writeByte(var1 != null ? 1 : 0);
            var3.writeCESU8(var0.getPath());
            if (var1 != null) {
                var3.writeCESU8("");
            }

            var2.method574(var3.array, 0, var3.offset);
            var2.method586();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    @ObfuscatedName("f")
    static boolean method133(File var0, boolean var1) {
        try {
            RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
            int var3 = var2.read();
            var2.seek(0L);
            var2.write(var3);
            var2.seek(0L);
            var2.close();
            if (var1) {
                var0.delete();
            }

            return true;
        } catch (Exception var4) {
            return false;
        }
    }

    @ObfuscatedName("t")
    static void method129(int var0, int var1) {
        long var2 = (var0 << 16) + var1;
        NetFileRequest var4 = (NetFileRequest) NetCache.NetCache_pendingWrites.method3512(var2);
        if (var4 != null) {
            NetCache.NetCache_pendingWritesQueue.method3486(var4);
        }
    }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "([BIIIIIIILclass94;[Lclass163;)V"
    )
    static final void method131(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, CollisionMap[] var9) {
        Buffer var10 = new Buffer(var0);
        int var11 = -1;

        while (true) {
            int var12 = var10.method2658();
            if (var12 == 0) {
                return;
            }

            var11 += var12;
            int var13 = 0;

            while (true) {
                int var14 = var10.method2658();
                if (var14 == 0) {
                    break;
                }

                var13 += var14 - 1;
                int var15 = var13 & 63;
                int var16 = var13 >> 6 & 63;
                int var17 = var13 >> 12;
                int var18 = var10.readUnsignedByte();
                int var19 = var18 >> 2;
                int var20 = var18 & 3;
                if (var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
                    ObjectComposition var21 = GameBuild.getObjectComposition(var11);
                    int var24 = var16 & 7;
                    int var25 = var15 & 7;
                    int var27 = var21.sizeX;
                    int var28 = var21.sizeY;
                    int var29;
                    if ((var20 & 1) == 1) {
                        var29 = var27;
                        var27 = var28;
                        var28 = var29;
                    }

                    int var26 = var7 & 3;
                    int var23;
                    if (var26 == 0) {
                        var23 = var24;
                    } else if (var26 == 1) {
                        var23 = var25;
                    } else if (var26 == 2) {
                        var23 = 7 - var24 - (var27 - 1);
                    } else {
                        var23 = 7 - var25 - (var28 - 1);
                    }

                    var29 = var23 + var2;
                    int var32 = var16 & 7;
                    int var33 = var15 & 7;
                    int var35 = var21.sizeX;
                    int var36 = var21.sizeY;
                    int var37;
                    if ((var20 & 1) == 1) {
                        var37 = var35;
                        var35 = var36;
                        var36 = var37;
                    }

                    int var34 = var7 & 3;
                    int var31;
                    if (var34 == 0) {
                        var31 = var33;
                    } else if (var34 == 1) {
                        var31 = 7 - var32 - (var35 - 1);
                    } else if (var34 == 2) {
                        var31 = 7 - var33 - (var36 - 1);
                    } else {
                        var31 = var32;
                    }

                    var37 = var31 + var3;
                    if (var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
                        int var38 = var1;
                        if ((Tiles.Tiles_renderFlags[1][var29][var37] & 2) == 2) {
                            var38 = var1 - 1;
                        }

                        CollisionMap var39 = null;
                        if (var38 >= 0) {
                            var39 = var9[var38];
                        }

                        Actor.method295(var1, var29, var37, var11, var20 + var7 & 3, var19, var8, var39);
                    }
                }
            }
        }
    }

    @ObfuscatedName("av")
    @ObfuscatedSignature(
            descriptor = "(Lclass26;)V"
    )
    static final void method134(Actor var0) {
        if (var0.field465 == Client.cycle || var0.animation == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > Definitions.getAnimation(var0.animation).frameLengths[var0.sequenceFrame]) {
            int var1 = var0.field465 - var0.field456;
            int var2 = Client.cycle - var0.field456;
            int var3 = var0.size * 64 + var0.field460 * 128;
            int var4 = var0.size * 64 + var0.field462 * 128;
            int var5 = var0.size * 64 + var0.field439 * 128;
            int var6 = var0.size * 64 + var0.field463 * 128;
            var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
            var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
        }

        var0.delaySteps = 0;
        if (var0.field466 == 0) {
            var0.orientation = 1024;
        }

        if (var0.field466 == 1) {
            var0.orientation = 1536;
        }

        if (var0.field466 == 2) {
            var0.orientation = 0;
        }

        if (var0.field466 == 3) {
            var0.orientation = 512;
        }

        var0.field432 = var0.orientation;
    }

    @ObfuscatedName("bc")
    static final void method130() {
        Client.field623 = 0;
        Client.playersCount = 0;
        Client.serverPacketBuf.switchBitMode();
        int var0 = Client.serverPacketBuf.readBits(1);
        int var1;
        int var2;
        int var3;
        int var4;
        int var5;
        if (var0 != 0) {
            var1 = Client.serverPacketBuf.readBits(2);
            if (var1 == 0) {
                Client.playersIndex[++Client.playersCount - 1] = 2047;
            } else if (var1 == 1) {
                var2 = Client.serverPacketBuf.readBits(3);
                Tiles.localPlayer.method279(var2, false);
                var3 = Client.serverPacketBuf.readBits(1);
                if (var3 == 1) {
                    Client.playersIndex[++Client.playersCount - 1] = 2047;
                }
            } else if (var1 == 2) {
                var2 = Client.serverPacketBuf.readBits(3);
                Tiles.localPlayer.method279(var2, true);
                var3 = Client.serverPacketBuf.readBits(3);
                Tiles.localPlayer.method279(var3, true);
                var4 = Client.serverPacketBuf.readBits(1);
                if (var4 == 1) {
                    Client.playersIndex[++Client.playersCount - 1] = 2047;
                }
            } else if (var1 == 3) {
                var2 = Client.serverPacketBuf.readBits(1);
                class22.scenePlane = Client.serverPacketBuf.readBits(2);
                var3 = Client.serverPacketBuf.readBits(1);
                if (var3 == 1) {
                    Client.playersIndex[++Client.playersCount - 1] = 2047;
                }

                int sceneY = Client.serverPacketBuf.readBits(7);
                int sceneX = Client.serverPacketBuf.readBits(7);
                Tiles.localPlayer.setPosition(sceneX, sceneY, var2 == 1);
            }
        }

        var0 = Client.serverPacketBuf.readBits(8);
        if (var0 < Client.field604) {
            for (var1 = var0; var1 < Client.field604; ++var1) {
                Client.field485[++Client.field623 - 1] = Client.field524[var1];
            }
        }

        if (var0 > Client.field604) {
            throw new RuntimeException("");
        } else {
            Client.field604 = 0;

            int var6;
            int var7;
            for (var1 = 0; var1 < var0; ++var1) {
                var2 = Client.field524[var1];
                Player var10 = Client.players[var2];
                var4 = Client.serverPacketBuf.readBits(1);
                if (var4 == 0) {
                    Client.field524[++Client.field604 - 1] = var2;
                    var10.field467 = Client.cycle;
                } else {
                    var5 = Client.serverPacketBuf.readBits(2);
                    if (var5 == 0) {
                        Client.field524[++Client.field604 - 1] = var2;
                        var10.field467 = Client.cycle;
                        Client.playersIndex[++Client.playersCount - 1] = var2;
                    } else if (var5 == 1) {
                        Client.field524[++Client.field604 - 1] = var2;
                        var10.field467 = Client.cycle;
                        var6 = Client.serverPacketBuf.readBits(3);
                        var10.method279(var6, false);
                        var7 = Client.serverPacketBuf.readBits(1);
                        if (var7 == 1) {
                            Client.playersIndex[++Client.playersCount - 1] = var2;
                        }
                    } else if (var5 == 2) {
                        Client.field524[++Client.field604 - 1] = var2;
                        var10.field467 = Client.cycle;
                        var6 = Client.serverPacketBuf.readBits(3);
                        var10.method279(var6, true);
                        var7 = Client.serverPacketBuf.readBits(3);
                        var10.method279(var7, true);
                        int var8 = Client.serverPacketBuf.readBits(1);
                        if (var8 == 1) {
                            Client.playersIndex[++Client.playersCount - 1] = var2;
                        }
                    } else if (var5 == 3) {
                        Client.field485[++Client.field623 - 1] = var2;
                    }
                }
            }

            Player var9;
            for (; Client.serverPacketBuf.method2514(Client.serverPacketLength) >= 11; var9.setPosition(Tiles.localPlayer.pathX[0] + var7, Tiles.localPlayer.pathY[0] + var6, var4 == 1)) {
                var0 = Client.serverPacketBuf.readBits(11);
                if (var0 == 2047) {
                    break;
                }

                boolean var11 = false;
                if (Client.players[var0] == null) {
                    Client.players[var0] = new Player();
                    if (Client.appearanceCache[var0] != null) {
                        Client.players[var0].updateAppearance(Client.appearanceCache[var0]);
                    }

                    var11 = true;
                }

                Client.field524[++Client.field604 - 1] = var0;
                var9 = Client.players[var0];
                var9.field467 = Client.cycle;
                var3 = Client.field642[Client.serverPacketBuf.readBits(3)];
                if (var11) {
                    var9.orientation = var9.field432 = var3;
                }

                var4 = Client.serverPacketBuf.readBits(1);
                var5 = Client.serverPacketBuf.readBits(1);
                if (var5 == 1) {
                    Client.playersIndex[++Client.playersCount - 1] = var0;
                }

                var6 = Client.serverPacketBuf.readBits(5);
                if (var6 > 15) {
                    var6 -= 32;
                }

                var7 = Client.serverPacketBuf.readBits(5);
                if (var7 > 15) {
                    var7 -= 32;
                }
            }

            Client.serverPacketBuf.switchToByteMode();
            class83.updatePlayers();

            for (var0 = 0; var0 < Client.field623; ++var0) {
                var1 = Client.field485[var0];
                if (Client.players[var1].field467 != Client.cycle) {
                    Client.players[var1] = null;
                }
            }

            if (Client.serverPacketLength != Client.serverPacketBuf.offset) {
                throw new RuntimeException(Client.serverPacketBuf.offset + "," + Client.serverPacketLength);
            } else {
                for (var0 = 0; var0 < Client.field604; ++var0) {
                    if (Client.players[Client.field524[var0]] == null) {
                        throw new RuntimeException(var0 + "," + Client.field604);
                    }
                }

            }
        }
    }
}
