package osrs;

public class VarpDefinition extends DualNode {
    static int field1040;
    public static AbstractArchive VarpDefinition_archive;
    public static int field1039;
    public static EvictingDualNodeHashTable VarpDefinition_cached = new EvictingDualNodeHashTable(64);
    static byte[][][] Tiles_overlays;
    static int[] field1044;
    public int type = 0;

    public void method924(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method920(var1, var2);
        }
    }

    void method920(Buffer var1, int var2) {
        if (var2 == 5) {
            this.type = var1.readUnsignedShort();
        }

    }

    static byte[] method934(byte[] var0) {
        int var1 = var0.length;
        byte[] var2 = new byte[var1];
        System.arraycopy(var0, 0, var2, 0, var1);
        return var2;
    }

    static final int method936() {
        if (Projectile.clientPreferences.roofsHidden) {
            return class22.scenePlane;
        } else {
            int var0 = 3;
            if (NPC.cameraPitch < 310) {
                int var1 = Login.cameraX >> 7;
                int var2 = class17.cameraZ >> 7;
                int var3 = Tiles.localPlayer.x >> 7;
                int var4 = Tiles.localPlayer.y >> 7;
                if ((Tiles.Tiles_renderFlags[class22.scenePlane][var1][var2] & 4) != 0) {
                    var0 = class22.scenePlane;
                }

                int var5;
                if (var3 > var1) {
                    var5 = var3 - var1;
                } else {
                    var5 = var1 - var3;
                }

                int var6;
                if (var4 > var2) {
                    var6 = var4 - var2;
                } else {
                    var6 = var2 - var4;
                }

                int var7;
                int var8;
                if (var5 > var6) {
                    var7 = var6 * 65536 / var5;
                    var8 = 32768;

                    while (var3 != var1) {
                        if (var1 < var3) {
                            ++var1;
                        } else if (var1 > var3) {
                            --var1;
                        }

                        if ((Tiles.Tiles_renderFlags[class22.scenePlane][var1][var2] & 4) != 0) {
                            var0 = class22.scenePlane;
                        }

                        var8 += var7;
                        if (var8 >= 65536) {
                            var8 -= 65536;
                            if (var2 < var4) {
                                ++var2;
                            } else if (var2 > var4) {
                                --var2;
                            }

                            if ((Tiles.Tiles_renderFlags[class22.scenePlane][var1][var2] & 4) != 0) {
                                var0 = class22.scenePlane;
                            }
                        }
                    }
                } else {
                    var7 = var5 * 65536 / var6;
                    var8 = 32768;

                    while (var2 != var4) {
                        if (var2 < var4) {
                            ++var2;
                        } else if (var2 > var4) {
                            --var2;
                        }

                        if ((Tiles.Tiles_renderFlags[class22.scenePlane][var1][var2] & 4) != 0) {
                            var0 = class22.scenePlane;
                        }

                        var8 += var7;
                        if (var8 >= 65536) {
                            var8 -= 65536;
                            if (var1 < var3) {
                                ++var1;
                            } else if (var1 > var3) {
                                --var1;
                            }

                            if ((Tiles.Tiles_renderFlags[class22.scenePlane][var1][var2] & 4) != 0) {
                                var0 = class22.scenePlane;
                            }
                        }
                    }
                }
            }

            if ((Tiles.Tiles_renderFlags[class22.scenePlane][Tiles.localPlayer.x >> 7][Tiles.localPlayer.y >> 7] & 4) != 0) {
                var0 = class22.scenePlane;
            }

            return var0;
        }
    }

    static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (EnumComposition.method852(var0)) {
            class40.drawInterface(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
        }
    }
}
