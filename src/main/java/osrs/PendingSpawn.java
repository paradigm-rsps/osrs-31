package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
    @ObfuscatedName("q")
    static String field358;
    @ObfuscatedName("do")
    static byte[][] regionMapArchives;
    @ObfuscatedName("i")
    @Export("plane")
    int plane;
    @ObfuscatedName("w")
    @Export("type")
    int type;
    @ObfuscatedName("f")
    @Export("x")
    int x;
    @ObfuscatedName("e")
    @Export("y")
    int y;
    @ObfuscatedName("t")
    @Export("objectId")
    int objectId;
    @ObfuscatedName("d")
    int field361;
    @ObfuscatedName("p")
    int field359;
    @ObfuscatedName("k")
    @Export("id")
    int id;
    @ObfuscatedName("r")
    @Export("orientation")
    int orientation;
    @ObfuscatedName("l")
    int field362;
    @ObfuscatedName("a")
    @Export("delay")
    int delay = 0;
    @ObfuscatedName("z")
    @Export("hitpoints")
    int hitpoints = -1;

    @ObfuscatedName("s")
    @Export("method245")
    static void method245(byte[] var0) {
        Buffer var1 = new Buffer(var0);
        var1.offset = var0.length - 2;
        class83.SpriteBuffer_spriteCount = var1.readUnsignedShort();
        class83.SpriteBuffer_xOffsets = new int[class83.SpriteBuffer_spriteCount];
        class165.SpriteBuffer_yOffsets = new int[class83.SpriteBuffer_spriteCount];
        class112.SpriteBuffer_spriteWidths = new int[class83.SpriteBuffer_spriteCount];
        class83.SpriteBuffer_spriteHeights = new int[class83.SpriteBuffer_spriteCount];
        class145.SpriteBuffer_pixels = new byte[class83.SpriteBuffer_spriteCount][];
        var1.offset = var0.length - 7 - class83.SpriteBuffer_spriteCount * 8;
        class83.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
        class83.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
        int var2 = (var1.readUnsignedByte() & 255) + 1;

        int var3;
        for (var3 = 0; var3 < class83.SpriteBuffer_spriteCount; ++var3) {
            class83.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
        }

        for (var3 = 0; var3 < class83.SpriteBuffer_spriteCount; ++var3) {
            class165.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
        }

        for (var3 = 0; var3 < class83.SpriteBuffer_spriteCount; ++var3) {
            class112.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
        }

        for (var3 = 0; var3 < class83.SpriteBuffer_spriteCount; ++var3) {
            class83.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
        }

        var1.offset = var0.length - 7 - class83.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
        FloorUnderlayDefinition.SpriteBuffer_spritePalette = new int[var2];

        for (var3 = 1; var3 < var2; ++var3) {
            FloorUnderlayDefinition.SpriteBuffer_spritePalette[var3] = var1.readMedium();
            if (FloorUnderlayDefinition.SpriteBuffer_spritePalette[var3] == 0) {
                FloorUnderlayDefinition.SpriteBuffer_spritePalette[var3] = 1;
            }
        }

        var1.offset = 0;

        for (var3 = 0; var3 < class83.SpriteBuffer_spriteCount; ++var3) {
            int var4 = class112.SpriteBuffer_spriteWidths[var3];
            int var5 = class83.SpriteBuffer_spriteHeights[var3];
            int var6 = var5 * var4;
            byte[] var7 = new byte[var6];
            class145.SpriteBuffer_pixels[var3] = var7;
            int var8 = var1.readUnsignedByte();
            int var9;
            if (var8 == 0) {
                for (var9 = 0; var9 < var6; ++var9) {
                    var7[var9] = var1.readByte();
                }
            } else if (var8 == 1) {
                for (var9 = 0; var9 < var4; ++var9) {
                    for (int var10 = 0; var10 < var5; ++var10) {
                        var7[var9 + var4 * var10] = var1.readByte();
                    }
                }
            }
        }

    }

    @ObfuscatedName("bt")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;Lclass157;)Ljava/lang/String;"
    )
    static String method244(String var0, Widget var1) {
        if (var0.indexOf("%") != -1) {
            int var2;
            for (var2 = 1; var2 <= 5; ++var2) {
                while (true) {
                    int var6 = var0.indexOf("%" + var2);
                    if (var6 == -1) {
                        break;
                    }

                    var0 = var0.substring(0, var6) + TileItem.method173(ItemContainer.method200(var1, var2 - 1)) + var0.substring(var6 + 2);
                }
            }

            while (true) {
                var2 = var0.indexOf("%dns");
                if (var2 == -1) {
                    break;
                }

                String var3 = "";
                if (GraphicsObject.field305 != null) {
                    int var5 = GraphicsObject.field305.intArgument;
                    String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
                    var3 = var4;
                    if (GraphicsObject.field305.result != null) {
                        var3 = (String) GraphicsObject.field305.result;
                    }
                }

                var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
            }
        }

        return var0;
    }

    @ObfuscatedName("cy")
    @Export("method243")
    static final void method243(int var0) {
        Client.method568();

        for (ObjectSound var1 = (ObjectSound) ObjectSound.objectSounds.method3533(); var1 != null; var1 = (ObjectSound) ObjectSound.objectSounds.method3535()) {
            if (var1.obj != null) {
                var1.method44();
            }
        }

        int var4 = GameBuild.method2854(var0).type;
        if (var4 != 0) {
            int var2 = Varps.Varps_main[var0];
            if (var4 == 1) {
                if (var2 == 1) {
                    Rasterizer3D.method2307(0.9D);
                    ((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).method2396(0.9D);
                }

                if (var2 == 2) {
                    Rasterizer3D.method2307(0.8D);
                    ((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).method2396(0.8D);
                }

                if (var2 == 3) {
                    Rasterizer3D.method2307(0.7D);
                    ((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).method2396(0.7D);
                }

                if (var2 == 4) {
                    Rasterizer3D.method2307(0.6D);
                    ((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).method2396(0.6D);
                }

                ItemComposition.ItemDefinition_cachedSprites.method3482();
            }

            if (var4 == 3) {
                short var3 = 0;
                if (var2 == 0) {
                    var3 = 255;
                }

                if (var2 == 1) {
                    var3 = 192;
                }

                if (var2 == 2) {
                    var3 = 128;
                }

                if (var2 == 3) {
                    var3 = 64;
                }

                if (var2 == 4) {
                    var3 = 0;
                }

                if (var3 != Client.field718) {
                    if (Client.field718 == 0 && Client.currentTrackGroupId != -1) {
                        class161.method3399(class40.archive6, Client.currentTrackGroupId, 0, var3, false);
                        Client.field562 = false;
                    } else if (var3 == 0) {
                        class137.midiPcmStream.method2951();
                        class137.musicPlayerStatus = 1;
                        class137.musicTrackArchive = null;
                        Client.field562 = false;
                    } else {
                        GameObject.method2207(var3);
                    }

                    Client.field718 = var3;
                }
            }

            if (var4 == 4) {
                if (var2 == 0) {
                    Client.field721 = 127;
                }

                if (var2 == 1) {
                    Client.field721 = 96;
                }

                if (var2 == 2) {
                    Client.field721 = 64;
                }

                if (var2 == 3) {
                    Client.field721 = 32;
                }

                if (var2 == 4) {
                    Client.field721 = 0;
                }
            }

            if (var4 == 5) {
                Client.leftClickOpensMenu = var2;
            }

            if (var4 == 6) {
                Client.chatEffects = var2;
            }

            if (var4 == 9) {
                Client.field646 = var2;
            }

            if (var4 == 10) {
                if (var2 == 0) {
                    Client.field538 = 127;
                }

                if (var2 == 1) {
                    Client.field538 = 96;
                }

                if (var2 == 2) {
                    Client.field538 = 64;
                }

                if (var2 == 3) {
                    Client.field538 = 32;
                }

                if (var2 == 4) {
                    Client.field538 = 0;
                }
            }

        }
    }
}
