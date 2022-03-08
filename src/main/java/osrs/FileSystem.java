package osrs;

import java.io.File;
import java.util.Hashtable;

public class FileSystem {
    static boolean FileSystem_hasPermissions = false;
    static File FileSystem_cacheDir;
    static Hashtable FileSystem_cacheFiles = new Hashtable(16);
    static IndexedSprite[] worldSelectArrows;

    static int method1514(int var0, int var1) {
        ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.method3512(var0);
        if (var2 == null) {
            return 0;
        } else if (var1 == -1) {
            return 0;
        } else {
            int var3 = 0;

            for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
                if (var2.ids[var4] == var1) {
                    var3 += var2.quantities[var4];
                }
            }

            return var3;
        }
    }

    static void method1515() {
        class83.SpriteBuffer_xOffsets = null;
        class165.SpriteBuffer_yOffsets = null;
        class112.SpriteBuffer_spriteWidths = null;
        class83.SpriteBuffer_spriteHeights = null;
        FloorUnderlayDefinition.SpriteBuffer_spritePalette = null;
        class145.SpriteBuffer_pixels = null;
    }

    public static int method1516(byte[] var0, int var1) {
        return class40.method913(var0, 0, var1);
    }

    static final boolean method1517(int var0, int var1, int var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, int var10) {
        int var13;
        int var14;
        for (var13 = 0; var13 < 104; ++var13) {
            for (var14 = 0; var14 < 104; ++var14) {
                Client.field543[var13][var14] = 0;
                Client.field501[var13][var14] = 99999999;
            }
        }

        var13 = var0;
        var14 = var1;
        Client.field543[var0][var1] = 99;
        Client.field501[var0][var1] = 0;
        byte var15 = 0;
        int var16 = 0;
        Client.field666[var15] = var0;
        int var28 = var15 + 1;
        Client.field546[var15] = var1;
        boolean var17 = false;
        int var18 = Client.field666.length;
        int[][] var19 = Client.collisionMaps[class22.scenePlane].flags;

        int var20;
        while (var28 != var16) {
            var13 = Client.field666[var16];
            var14 = Client.field546[var16];
            var16 = (var16 + 1) % var18;
            if (var13 == var2 && var3 == var14) {
                var17 = true;
                break;
            }

            if (var5 != 0) {
                if ((var5 < 5 || var5 == 10) && Client.collisionMaps[class22.scenePlane].method3438(var13, var14, var2, var3, var5 - 1, var6)) {
                    var17 = true;
                    break;
                }

                if (var5 < 10 && Client.collisionMaps[class22.scenePlane].method3444(var13, var14, var2, var3, var5 - 1, var6)) {
                    var17 = true;
                    break;
                }
            }

            if (var7 != 0 && var8 != 0 && Client.collisionMaps[class22.scenePlane].method3467(var13, var14, var2, var3, var7, var8, var9)) {
                var17 = true;
                break;
            }

            var20 = Client.field501[var13][var14] + 1;
            if (var13 > 0 && Client.field543[var13 - 1][var14] == 0 && (var19[var13 - 1][var14] & 19661064) == 0) {
                Client.field666[var28] = var13 - 1;
                Client.field546[var28] = var14;
                var28 = (var28 + 1) % var18;
                Client.field543[var13 - 1][var14] = 2;
                Client.field501[var13 - 1][var14] = var20;
            }

            if (var13 < 103 && Client.field543[var13 + 1][var14] == 0 && (var19[var13 + 1][var14] & 19661184) == 0) {
                Client.field666[var28] = var13 + 1;
                Client.field546[var28] = var14;
                var28 = (var28 + 1) % var18;
                Client.field543[var13 + 1][var14] = 8;
                Client.field501[var13 + 1][var14] = var20;
            }

            if (var14 > 0 && Client.field543[var13][var14 - 1] == 0 && (var19[var13][var14 - 1] & 19661058) == 0) {
                Client.field666[var28] = var13;
                Client.field546[var28] = var14 - 1;
                var28 = (var28 + 1) % var18;
                Client.field543[var13][var14 - 1] = 1;
                Client.field501[var13][var14 - 1] = var20;
            }

            if (var14 < 103 && Client.field543[var13][var14 + 1] == 0 && (var19[var13][var14 + 1] & 19661088) == 0) {
                Client.field666[var28] = var13;
                Client.field546[var28] = var14 + 1;
                var28 = (var28 + 1) % var18;
                Client.field543[var13][var14 + 1] = 4;
                Client.field501[var13][var14 + 1] = var20;
            }

            if (var13 > 0 && var14 > 0 && Client.field543[var13 - 1][var14 - 1] == 0 && (var19[var13 - 1][var14 - 1] & 19661070) == 0 && (var19[var13 - 1][var14] & 19661064) == 0 && (var19[var13][var14 - 1] & 19661058) == 0) {
                Client.field666[var28] = var13 - 1;
                Client.field546[var28] = var14 - 1;
                var28 = (var28 + 1) % var18;
                Client.field543[var13 - 1][var14 - 1] = 3;
                Client.field501[var13 - 1][var14 - 1] = var20;
            }

            if (var13 < 103 && var14 > 0 && Client.field543[var13 + 1][var14 - 1] == 0 && (var19[var13 + 1][var14 - 1] & 19661187) == 0 && (var19[var13 + 1][var14] & 19661184) == 0 && (var19[var13][var14 - 1] & 19661058) == 0) {
                Client.field666[var28] = var13 + 1;
                Client.field546[var28] = var14 - 1;
                var28 = (var28 + 1) % var18;
                Client.field543[var13 + 1][var14 - 1] = 9;
                Client.field501[var13 + 1][var14 - 1] = var20;
            }

            if (var13 > 0 && var14 < 103 && Client.field543[var13 - 1][var14 + 1] == 0 && (var19[var13 - 1][var14 + 1] & 19661112) == 0 && (var19[var13 - 1][var14] & 19661064) == 0 && (var19[var13][var14 + 1] & 19661088) == 0) {
                Client.field666[var28] = var13 - 1;
                Client.field546[var28] = var14 + 1;
                var28 = (var28 + 1) % var18;
                Client.field543[var13 - 1][var14 + 1] = 6;
                Client.field501[var13 - 1][var14 + 1] = var20;
            }

            if (var13 < 103 && var14 < 103 && Client.field543[var13 + 1][var14 + 1] == 0 && (var19[var13 + 1][var14 + 1] & 19661280) == 0 && (var19[var13 + 1][var14] & 19661184) == 0 && (var19[var13][var14 + 1] & 19661088) == 0) {
                Client.field666[var28] = var13 + 1;
                Client.field546[var28] = var14 + 1;
                var28 = (var28 + 1) % var18;
                Client.field543[var13 + 1][var14 + 1] = 12;
                Client.field501[var13 + 1][var14 + 1] = var20;
            }
        }

        Client.field738 = 0;
        int var21;
        int var23;
        int var24;
        if (!var17) {
            if (!var4) {
                return false;
            }

            var20 = 1000;
            var21 = 100;
            byte var22 = 10;

            for (var23 = var2 - var22; var23 <= var22 + var2; ++var23) {
                for (var24 = var3 - var22; var24 <= var3 + var22; ++var24) {
                    if (var23 >= 0 && var24 >= 0 && var23 < 104 && var24 < 104 && Client.field501[var23][var24] < 100) {
                        int var25 = 0;
                        if (var23 < var2) {
                            var25 = var2 - var23;
                        } else if (var23 > var2 + var7 - 1) {
                            var25 = var23 - (var2 + var7 - 1);
                        }

                        int var26 = 0;
                        if (var24 < var3) {
                            var26 = var3 - var24;
                        } else if (var24 > var3 + var8 - 1) {
                            var26 = var24 - (var3 + var8 - 1);
                        }

                        int var27 = var26 * var26 + var25 * var25;
                        if (var27 < var20 || var27 == var20 && Client.field501[var23][var24] < var21) {
                            var20 = var27;
                            var21 = Client.field501[var23][var24];
                            var13 = var23;
                            var14 = var24;
                        }
                    }
                }
            }

            if (var20 == 1000) {
                return false;
            }

            if (var0 == var13 && var14 == var1) {
                return false;
            }

            Client.field738 = 1;
        }

        byte var29 = 0;
        Client.field666[var29] = var13;
        var16 = var29 + 1;
        Client.field546[var29] = var14;

        for (var20 = var21 = Client.field543[var13][var14]; var0 != var13 || var14 != var1; var20 = Client.field543[var13][var14]) {
            if (var20 != var21) {
                var21 = var20;
                Client.field666[var16] = var13;
                Client.field546[var16++] = var14;
            }

            if ((var20 & 2) != 0) {
                ++var13;
            } else if ((var20 & 8) != 0) {
                --var13;
            }

            if ((var20 & 1) != 0) {
                ++var14;
            } else if ((var20 & 4) != 0) {
                --var14;
            }
        }

        if (var16 <= 0) {
            return var10 != 1;
        } else {
            var18 = var16;
            if (var16 > 25) {
                var18 = 25;
            }

            --var16;
            int var30 = Client.field666[var16];
            var23 = Client.field546[var16];
            if (var10 == 0) {
                Client.rsaBuf.writeByteOpcode(166);
                Client.rsaBuf.writeByte(var18 + var18 + 3);
            }

            if (var10 == 1) {
                Client.rsaBuf.writeByteOpcode(76);
                Client.rsaBuf.writeByte(var18 + var18 + 3 + 14);
            }

            if (var10 == 2) {
                Client.rsaBuf.writeByteOpcode(117);
                Client.rsaBuf.writeByte(var18 + var18 + 3);
            }

            Client.field715 = Client.field666[0];
            Client.field716 = Client.field546[0];

            for (var24 = 1; var24 < var18; ++var24) {
                --var16;
                Client.rsaBuf.method2645(Client.field666[var16] - var30);
                Client.rsaBuf.method2667(Client.field546[var16] - var23);
            }

            Client.rsaBuf.writeShortAdd(var23 + Frames.baseY);
            Client.rsaBuf.method2667(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
            Client.rsaBuf.writeShort(var30 + FaceNormal.baseX);
            return true;
        }
    }
}
