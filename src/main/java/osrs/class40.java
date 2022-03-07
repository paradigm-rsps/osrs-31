package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.RandomAccessFile;

@ObfuscatedName("ac")
public class class40 extends DualNode {
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "Lclass151;"
    )
    static AbstractArchive field1035;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lclass169;"
    )
    static EvictingDualNodeHashTable field1037 = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("ad")
    @Export("archive6")
    @ObfuscatedSignature(
            descriptor = "Lclass153;"
    )
    static Archive archive6;
    @ObfuscatedName("cw")
    @Export("fontBold12")
    @ObfuscatedSignature(
            descriptor = "Lclass182;"
    )
    static Font fontBold12;
    @ObfuscatedName("f")
    public int field1032 = 0;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lclass126;)V"
    )
    void method917(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method906(var1, var2);
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            descriptor = "(Lclass126;I)V"
    )
    void method906(Buffer var1, int var2) {
        if (var2 == 2) {
            this.field1032 = var1.readUnsignedShort();
        }

    }

    @ObfuscatedName("i")
    @Export("method918")
    public static byte method918(char var0) {
        byte var1;
        if (var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
            var1 = (byte) var0;
        } else if (var0 == 8364) {
            var1 = -128;
        } else if (var0 == 8218) {
            var1 = -126;
        } else if (var0 == 402) {
            var1 = -125;
        } else if (var0 == 8222) {
            var1 = -124;
        } else if (var0 == 8230) {
            var1 = -123;
        } else if (var0 == 8224) {
            var1 = -122;
        } else if (var0 == 8225) {
            var1 = -121;
        } else if (var0 == 710) {
            var1 = -120;
        } else if (var0 == 8240) {
            var1 = -119;
        } else if (var0 == 352) {
            var1 = -118;
        } else if (var0 == 8249) {
            var1 = -117;
        } else if (var0 == 338) {
            var1 = -116;
        } else if (var0 == 381) {
            var1 = -114;
        } else if (var0 == 8216) {
            var1 = -111;
        } else if (var0 == 8217) {
            var1 = -110;
        } else if (var0 == 8220) {
            var1 = -109;
        } else if (var0 == 8221) {
            var1 = -108;
        } else if (var0 == 8226) {
            var1 = -107;
        } else if (var0 == 8211) {
            var1 = -106;
        } else if (var0 == 8212) {
            var1 = -105;
        } else if (var0 == 732) {
            var1 = -104;
        } else if (var0 == 8482) {
            var1 = -103;
        } else if (var0 == 353) {
            var1 = -102;
        } else if (var0 == 8250) {
            var1 = -101;
        } else if (var0 == 339) {
            var1 = -100;
        } else if (var0 == 382) {
            var1 = -98;
        } else if (var0 == 376) {
            var1 = -97;
        } else {
            var1 = 63;
        }

        return var1;
    }

    @ObfuscatedName("i")
    @Export("method915")
    static File method915(String var0) {
        if (!FileSystem.FileSystem_hasPermissions) {
            throw new RuntimeException("");
        } else {
            File var1 = (File) FileSystem.FileSystem_cacheFiles.get(var0);
            if (var1 != null) {
                return var1;
            } else {
                File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
                RandomAccessFile var3 = null;

                try {
                    File var4 = new File(var2.getParent());
                    if (!var4.exists()) {
                        throw new RuntimeException("");
                    } else {
                        var3 = new RandomAccessFile(var2, "rw");
                        int var5 = var3.read();
                        var3.seek(0L);
                        var3.write(var5);
                        var3.seek(0L);
                        var3.close();
                        FileSystem.FileSystem_cacheFiles.put(var0, var2);
                        return var2;
                    }
                } catch (Exception var8) {
                    try {
                        if (var3 != null) {
                            var3.close();
                            var3 = null;
                        }
                    } catch (Exception var7) {
                    }

                    throw new RuntimeException();
                }
            }
        }
    }

    @ObfuscatedName("w")
    @Export("method905")
    public static int method905(int var0) {
        return var0 >> 11 & 63;
    }

    @ObfuscatedName("ae")
    static int method913(byte[] var0, int var1, int var2) {
        int var3 = -1;

        for (int var4 = var1; var4 < var2; ++var4) {
            var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
        }

        var3 = ~var3;
        return var3;
    }

    @ObfuscatedName("cq")
    @Export("method916")
    @ObfuscatedSignature(
            descriptor = "(Lclass157;)Z"
    )
    static final boolean method916(Widget var0) {
        if (var0.cs1Comparisons == null) {
            return false;
        } else {
            for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
                int var2 = ItemContainer.method200(var0, var1);
                int var3 = var0.cs1ComparisonValues[var1];
                if (var0.cs1Comparisons[var1] == 2) {
                    if (var2 >= var3) {
                        return false;
                    }
                } else if (var0.cs1Comparisons[var1] == 3) {
                    if (var2 <= var3) {
                        return false;
                    }
                } else if (var0.cs1Comparisons[var1] == 4) {
                    if (var3 == var2) {
                        return false;
                    }
                } else if (var3 != var2) {
                    return false;
                }
            }

            return true;
        }
    }

    @ObfuscatedName("cc")
    @Export("method904")
    @ObfuscatedSignature(
            descriptor = "([Lclass157;IIIIIII)V"
    )
    static final void drawInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        for (int var8 = 0; var8 < var0.length; ++var8) {
            Widget var9 = var0[var8];
            if (var9 != null && (!var9.isIf3 || var9.type == 0 || var9.hasListener || SoundSystem.method1326(var9) != 0 || var9 == Client.field740) && var9.parentId == var1 && (!var9.isIf3 || !Archive.method3322(var9))) {
                int var10 = var9.rawX + var6;
                int var11 = var7 + var9.field2579;
                int var12;
                int var13;
                int var14;
                int var15;
                int var19;
                if (var9.type == 2) {
                    var12 = var2;
                    var13 = var3;
                    var14 = var4;
                    var15 = var5;
                } else {
                    int var16;
                    int var17;
                    if (var9.type == 9) {
                        var16 = var10;
                        var17 = var11;
                        int var18 = var10 + var9.width;
                        var19 = var11 + var9.height;
                        if (var18 < var10) {
                            var16 = var18;
                            var18 = var10;
                        }

                        if (var19 < var11) {
                            var17 = var19;
                            var19 = var11;
                        }

                        ++var18;
                        ++var19;
                        var12 = var16 > var2 ? var16 : var2;
                        var13 = var17 > var3 ? var17 : var3;
                        var14 = var18 < var4 ? var18 : var4;
                        var15 = var19 < var5 ? var19 : var5;
                    } else {
                        var16 = var10 + var9.width;
                        var17 = var11 + var9.height;
                        var12 = var10 > var2 ? var10 : var2;
                        var13 = var11 > var3 ? var11 : var3;
                        var14 = var16 < var4 ? var16 : var4;
                        var15 = var17 < var5 ? var17 : var5;
                    }
                }

                if (var9 == Client.clickedWidget) {
                    Client.field703 = true;
                    Client.field708 = var10;
                    Client.field664 = var11;
                }

                if (!var9.isIf3 || var12 < var14 && var13 < var15) {
                    if (var9.contentType == 1337) {
                        class82.invalidateWidget(var9);
                    } else if (var9.contentType == 1338) {
                        DynamicObject.method160(var10, var11);
                    } else {
                        if (var9.type == 0) {
                            if (!var9.isIf3 && Archive.method3322(var9) && var9 != Tiles.mousedOverWidgetIf1) {
                                continue;
                            }

                            drawInterface(var0, var9.id, var12, var13, var14, var15, var10 - var9.field2589, var11 - var9.field2655);
                            if (var9.children != null) {
                                drawInterface(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.field2589, var11 - var9.field2655);
                            }

                            InterfaceParent var23 = (InterfaceParent) Client.interfaceParents.method3512(var9.id);
                            if (var23 != null) {
                                VarpDefinition.drawWidgets(var23.group, var12, var13, var14, var15, var10, var11);
                            }
                        }

                        if (var9.isIf3) {
                            boolean var26;
                            var26 = MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15;

                            boolean var27 = MouseHandler.MouseHandler_currentButton == 1 && var26;

                            boolean var28 = MouseHandler.PacketBufferNode_packetBufferNodeCount == 1 && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15;

                            if (var28) {
                                ByteArrayPool.method2503(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
                            }

                            if (Client.clickedWidget != null && var9 != Client.clickedWidget && var26 && EnumComposition.method843(SoundSystem.method1326(var9))) {
                                Client.field658 = var9;
                            }

                            if (var9 == Client.field740) {
                                Client.field659 = true;
                                Client.field624 = var10;
                                Client.field661 = var11;
                            }

                            if (var9.hasListener) {
                                ScriptEvent var24;
                                if (var26 && Client.field654 != 0 && var9.field2661 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.field7 = Client.field654;
                                    var24.args = var9.field2661;
                                    Client.field536.method3528(var24);
                                }

                                if (Client.clickedWidget != null || SequenceDefinition.field887 != null || Client.isMenuOpen) {
                                    var28 = false;
                                    var27 = false;
                                    var26 = false;
                                }

                                if (!var9.field2686 && var28) {
                                    var9.field2686 = true;
                                    if (var9.field2645 != null) {
                                        var24 = new ScriptEvent();
                                        var24.widget = var9;
                                        var24.field2 = MouseHandler.MouseHandler_lastPressedX - var10;
                                        var24.field7 = MouseHandler.MouseHandler_lastPressedY - var11;
                                        var24.args = var9.field2645;
                                        Client.field536.method3528(var24);
                                    }
                                }

                                if (var9.field2686 && var27 && var9.field2629 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.field2 = MouseHandler.MouseHandler_x - var10;
                                    var24.field7 = MouseHandler.MouseHandler_y - var11;
                                    var24.args = var9.field2629;
                                    Client.field536.method3528(var24);
                                }

                                if (var9.field2686 && !var27) {
                                    var9.field2686 = false;
                                    if (var9.field2659 != null) {
                                        var24 = new ScriptEvent();
                                        var24.widget = var9;
                                        var24.field2 = MouseHandler.MouseHandler_x - var10;
                                        var24.field7 = MouseHandler.MouseHandler_y - var11;
                                        var24.args = var9.field2659;
                                        Client.field682.method3528(var24);
                                    }
                                }

                                if (var27 && var9.field2648 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.field2 = MouseHandler.MouseHandler_x - var10;
                                    var24.field7 = MouseHandler.MouseHandler_y - var11;
                                    var24.args = var9.field2648;
                                    Client.field536.method3528(var24);
                                }

                                if (!var9.field2685 && var26) {
                                    var9.field2685 = true;
                                    if (var9.field2649 != null) {
                                        var24 = new ScriptEvent();
                                        var24.widget = var9;
                                        var24.field2 = MouseHandler.MouseHandler_x - var10;
                                        var24.field7 = MouseHandler.MouseHandler_y - var11;
                                        var24.args = var9.field2649;
                                        Client.field536.method3528(var24);
                                    }
                                }

                                if (var9.field2685 && var26 && var9.field2650 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.field2 = MouseHandler.MouseHandler_x - var10;
                                    var24.field7 = MouseHandler.MouseHandler_y - var11;
                                    var24.args = var9.field2650;
                                    Client.field536.method3528(var24);
                                }

                                if (var9.field2685 && !var26) {
                                    var9.field2685 = false;
                                    if (var9.field2651 != null) {
                                        var24 = new ScriptEvent();
                                        var24.widget = var9;
                                        var24.field2 = MouseHandler.MouseHandler_x - var10;
                                        var24.field7 = MouseHandler.MouseHandler_y - var11;
                                        var24.args = var9.field2651;
                                        Client.field682.method3528(var24);
                                    }
                                }

                                if (var9.field2658 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.args = var9.field2658;
                                    Client.field745.method3528(var24);
                                }

                                int var20;
                                int var21;
                                ScriptEvent var22;
                                if (var9.field2656 != null && Client.field668 > var9.field2594) {
                                    if (var9.field2654 != null && Client.field668 - var9.field2594 <= 32) {
                                        label475:
                                        for (var19 = var9.field2594; var19 < Client.field668; ++var19) {
                                            var20 = Client.field667[var19 & 31];

                                            for (var21 = 0; var21 < var9.field2654.length; ++var21) {
                                                if (var20 == var9.field2654[var21]) {
                                                    var22 = new ScriptEvent();
                                                    var22.widget = var9;
                                                    var22.args = var9.field2656;
                                                    Client.field536.method3528(var22);
                                                    break label475;
                                                }
                                            }
                                        }
                                    } else {
                                        var24 = new ScriptEvent();
                                        var24.widget = var9;
                                        var24.args = var9.field2656;
                                        Client.field536.method3528(var24);
                                    }

                                    var9.field2594 = Client.field668;
                                }

                                if (var9.field2630 != null && Client.field670 > var9.field2689) {
                                    if (var9.field2605 != null && Client.field670 - var9.field2689 <= 32) {
                                        label455:
                                        for (var19 = var9.field2689; var19 < Client.field670; ++var19) {
                                            var20 = Client.field578[var19 & 31];

                                            for (var21 = 0; var21 < var9.field2605.length; ++var21) {
                                                if (var20 == var9.field2605[var21]) {
                                                    var22 = new ScriptEvent();
                                                    var22.widget = var9;
                                                    var22.args = var9.field2630;
                                                    Client.field536.method3528(var22);
                                                    break label455;
                                                }
                                            }
                                        }
                                    } else {
                                        var24 = new ScriptEvent();
                                        var24.widget = var9;
                                        var24.args = var9.field2630;
                                        Client.field536.method3528(var24);
                                    }

                                    var9.field2689 = Client.field670;
                                }

                                if (var9.field2620 != null && Client.field672 > var9.field2590) {
                                    if (var9.field2687 != null && Client.field672 - var9.field2590 <= 32) {
                                        label435:
                                        for (var19 = var9.field2590; var19 < Client.field672; ++var19) {
                                            var20 = Client.field671[var19 & 31];

                                            for (var21 = 0; var21 < var9.field2687.length; ++var21) {
                                                if (var20 == var9.field2687[var21]) {
                                                    var22 = new ScriptEvent();
                                                    var22.widget = var9;
                                                    var22.args = var9.field2620;
                                                    Client.field536.method3528(var22);
                                                    break label435;
                                                }
                                            }
                                        }
                                    } else {
                                        var24 = new ScriptEvent();
                                        var24.widget = var9;
                                        var24.args = var9.field2620;
                                        Client.field536.method3528(var24);
                                    }

                                    var9.field2590 = Client.field672;
                                }

                                if (Client.field482 > var9.field2662 && var9.field2665 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.args = var9.field2665;
                                    Client.field536.method3528(var24);
                                }

                                if (Client.field674 > var9.field2662 && var9.field2571 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.args = var9.field2571;
                                    Client.field536.method3528(var24);
                                }

                                if (Client.field675 > var9.field2662 && var9.field2618 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.args = var9.field2618;
                                    Client.field536.method3528(var24);
                                }

                                if (Client.field676 > var9.field2662 && var9.field2669 != null) {
                                    var24 = new ScriptEvent();
                                    var24.widget = var9;
                                    var24.args = var9.field2669;
                                    Client.field536.method3528(var24);
                                }

                                var9.field2662 = Client.field681;
                                if (var9.field2666 != null) {
                                    for (var19 = 0; var19 < Client.field704; ++var19) {
                                        ScriptEvent var25 = new ScriptEvent();
                                        var25.widget = var9;
                                        var25.field4 = Client.field612[var19];
                                        var25.field9 = Client.field705[var19];
                                        var25.args = var9.field2666;
                                        Client.field536.method3528(var25);
                                    }
                                }
                            }
                        }

                        if (!var9.isIf3) {
                            if (Client.clickedWidget != null || SequenceDefinition.field887 != null || Client.isMenuOpen) {
                                return;
                            }

                            if ((var9.field2675 >= 0 || var9.field2595 != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                                if (var9.field2675 >= 0) {
                                    Tiles.mousedOverWidgetIf1 = var0[var9.field2675];
                                } else {
                                    Tiles.mousedOverWidgetIf1 = var9;
                                }
                            }

                            if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                                NPC.field398 = var9;
                            }

                            if (var9.field2592 > var9.height) {
                                ClientPreferences.method154(var9, var10 + var9.width, var11, var9.height, var9.field2592, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
                            }
                        }
                    }
                }
            }
        }

    }
}
