package osrs;

import net.runelite.rs.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnimationDefinition extends DualNode {
    static Widget field887;
    public static AbstractArchive SequenceDefinition_archive;
    static AbstractArchive SequenceDefinition_animationsArchive;
    static AbstractArchive SequenceDefinition_skeletonsArchive;
    public static EvictingDualNodeHashTable SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
    static EvictingDualNodeHashTable SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
    public int[] frameIds;
    int[] chatFrameIds;
    public int[] frameLengths;
    public int[] soundEffects;
    public int frameCount = -1;
    int[] field883;
    public boolean field902 = false;
    public int field895 = 5;
    public int shield = -1;
    public int weapon = -1;
    public int field898 = 99;
    public int field899 = -1;
    public int field900 = -1;
    public int field901 = 2;

    public void method752(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method724(var1, var2);
        }
    }

    void method724(Buffer var1, int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedShort();
            this.frameLengths = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameLengths[var4] = var1.readUnsignedShort();
            }

            this.frameIds = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIds[var4] = var1.readUnsignedShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIds[var4] += var1.readUnsignedShort() << 16;
            }
        } else if (var2 == 2) {
            this.frameCount = var1.readUnsignedShort();
        } else if (var2 == 3) {
            var3 = var1.readUnsignedByte();
            this.field883 = new int[var3 + 1];

            for (var4 = 0; var4 < var3; ++var4) {
                this.field883[var4] = var1.readUnsignedByte();
            }

            this.field883[var3] = 9999999;
        } else if (var2 == 4) {
            this.field902 = true;
        } else if (var2 == 5) {
            this.field895 = var1.readUnsignedByte();
        } else if (var2 == 6) {
            this.shield = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.weapon = var1.readUnsignedShort();
        } else if (var2 == 8) {
            this.field898 = var1.readUnsignedByte();
        } else if (var2 == 9) {
            this.field899 = var1.readUnsignedByte();
        } else if (var2 == 10) {
            this.field900 = var1.readUnsignedByte();
        } else if (var2 == 11) {
            this.field901 = var1.readUnsignedByte();
        } else if (var2 == 12) {
            var3 = var1.readUnsignedByte();
            this.chatFrameIds = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.chatFrameIds[var4] = var1.readUnsignedShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.chatFrameIds[var4] += var1.readUnsignedShort() << 16;
            }
        } else if (var2 == 13) {
            var3 = var1.readUnsignedByte();
            this.soundEffects = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.soundEffects[var4] = var1.readMedium();
            }
        }

    }

    public void method742() {
        if (this.field899 == -1) {
            if (this.field883 != null) {
                this.field899 = 2;
            } else {
                this.field899 = 0;
            }
        }

        if (this.field900 == -1) {
            if (this.field883 != null) {
                this.field900 = 2;
            } else {
                this.field900 = 0;
            }
        }

    }

    public Model method735(Model var1, int var2) {
        var2 = this.frameIds[var2];
        Frames var3 = MilliClock.method1438(var2 >> 16);
        var2 &= 65535;
        if (var3 == null) {
            return var1.method2424(true);
        } else {
            Model var4 = var1.method2424(!var3.method2387(var2));
            var4.method2430(var3, var2);
            return var4;
        }
    }

    Model method726(Model var1, int var2, int var3) {
        var2 = this.frameIds[var2];
        Frames var4 = MilliClock.method1438(var2 >> 16);
        var2 &= 65535;
        if (var4 == null) {
            return var1.method2424(true);
        } else {
            Model var5 = var1.method2424(!var4.method2387(var2));
            var3 &= 3;
            if (var3 == 1) {
                var5.method2435();
            } else if (var3 == 2) {
                var5.method2444();
            } else if (var3 == 3) {
                var5.method2488();
            }

            var5.method2430(var4, var2);
            if (var3 == 1) {
                var5.method2488();
            } else if (var3 == 2) {
                var5.method2444();
            } else if (var3 == 3) {
                var5.method2435();
            }

            return var5;
        }
    }

    Model method727(Model var1, int var2) {
        var2 = this.frameIds[var2];
        Frames var3 = MilliClock.method1438(var2 >> 16);
        var2 &= 65535;
        if (var3 == null) {
            return var1.method2495(true);
        } else {
            Model var4 = var1.method2495(!var3.method2387(var2));
            var4.method2430(var3, var2);
            return var4;
        }
    }

    public Model method728(Model var1, int var2, AnimationDefinition var3, int var4) {
        var2 = this.frameIds[var2];
        Frames var5 = MilliClock.method1438(var2 >> 16);
        var2 &= 65535;
        if (var5 == null) {
            return var3.method735(var1, var4);
        } else {
            var4 = var3.frameIds[var4];
            Frames var6 = MilliClock.method1438(var4 >> 16);
            var4 &= 65535;
            Model var7;
            if (var6 == null) {
                var7 = var1.method2424(!var5.method2387(var2));
                var7.method2430(var5, var2);
                return var7;
            } else {
                var7 = var1.method2424(!var5.method2387(var2) & !var6.method2387(var4));
                var7.method2431(var5, var2, var6, var4, this.field883);
                return var7;
            }
        }
    }

    public Model method729(Model var1, int var2) {
        int var3 = this.frameIds[var2];
        Frames var4 = MilliClock.method1438(var3 >> 16);
        var3 &= 65535;
        if (var4 == null) {
            return var1.method2424(true);
        } else {
            Frames var5 = null;
            int var6 = 0;
            if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
                var6 = this.chatFrameIds[var2];
                var5 = MilliClock.method1438(var6 >> 16);
                var6 &= 65535;
            }

            Model var7;
            if (var5 != null && var6 != 65535) {
                var7 = var1.method2424(!var4.method2387(var3) & !var5.method2387(var6));
                var7.method2430(var4, var3);
                var7.method2430(var5, var6);
                return var7;
            } else {
                var7 = var1.method2424(!var4.method2387(var3));
                var7.method2430(var4, var3);
                return var7;
            }
        }
    }

    public static final void sleepWeird(long var0) {
        if (var0 > 0L) {
            if (0L == var0 % 10L) {
                ItemContainer.sleep(var0 - 1L);
                ItemContainer.sleep(1L);
            } else {
                ItemContainer.sleep(var0);
            }

        }
    }

    public static int method760(int var0) {
        var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
        var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
        var0 = var0 + (var0 >>> 4) & 252645135;
        var0 += var0 >>> 8;
        var0 += var0 >>> 16;
        return var0 & 255;
    }

    public static void method762(Buffer var0, int var1) {
        ReflectionCheck var2 = new ReflectionCheck();
        var2.size = var0.readUnsignedByte();
        var2.id = var0.readInt();
        var2.operations = new int[var2.size];
        var2.creationErrors = new int[var2.size];
        var2.fields = new Field[var2.size];
        var2.intReplaceValues = new int[var2.size];
        var2.methods = new Method[var2.size];
        var2.arguments = new byte[var2.size][][];

        for (int var3 = 0; var3 < var2.size; ++var3) {
            try {
                int var4 = var0.readUnsignedByte();
                String var5;
                String var6;
                int var7;
                if (var4 != 0 && var4 != 1 && var4 != 2) {
                    if (var4 == 3 || var4 == 4) {
                        var5 = var0.readChatString();
                        var6 = var0.readChatString();
                        var7 = var0.readUnsignedByte();
                        String[] var8 = new String[var7];

                        for (int var9 = 0; var9 < var7; ++var9) {
                            var8[var9] = var0.readChatString();
                        }

                        byte[][] var12 = new byte[var7][];
                        int var11;
                        if (var4 == 3) {
                            for (int var10 = 0; var10 < var7; ++var10) {
                                var11 = var0.readInt();
                                var12[var10] = new byte[var11];
                                var0.readBytes(var12[var10], 0, var11);
                            }
                        }

                        var2.operations[var3] = var4;
                        Class[] var13 = new Class[var7];

                        for (var11 = 0; var11 < var7; ++var11) {
                            var13[var11] = class82.method1737(var8[var11]);
                        }

                        var2.methods[var3] = class82.method1737(var5).getDeclaredMethod(var6, var13);
                        var2.arguments[var3] = var12;
                    }
                } else {
                    var5 = var0.readChatString();
                    var6 = var0.readChatString();
                    var7 = 0;
                    if (var4 == 1) {
                        var7 = var0.readInt();
                    }

                    var2.operations[var3] = var4;
                    var2.intReplaceValues[var3] = var7;
                    var2.fields[var3] = Reflection.findField(class82.method1737(var5), var6);
                }
            } catch (ClassNotFoundException var15) {
                var2.creationErrors[var3] = -1;
            } catch (SecurityException var16) {
                var2.creationErrors[var3] = -2;
            } catch (NullPointerException var17) {
                var2.creationErrors[var3] = -3;
            } catch (Exception var18) {
                var2.creationErrors[var3] = -4;
            } catch (Throwable var19) {
                var2.creationErrors[var3] = -5;
            }
        }

        class181.reflectionChecks.method3528(var2);
    }

    static final void method759() {
        if (class27.pcmPlayer1 != null) {
            class27.pcmPlayer1.method1227();
        }

        if (Client.pcmPlayer0 != null) {
            Client.pcmPlayer0.method1227();
        }

    }
}