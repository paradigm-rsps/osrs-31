package osrs;

public final class GameObject {
    int plane;
    int height;
    int centerX;
    int centerY;
    public Renderable renderable;
    int field1645;
    int startX;
    int endX;
    int startY;
    int endY;
    int field1650;
    int lastDrawn;
    public int packedId = 0;
    int flags = 0;

    static void method2206(int var0, int var1, int var2, int var3) {
        for (ObjectSound var4 = (ObjectSound) ObjectSound.objectSounds.method3533(); var4 != null; var4 = (ObjectSound) ObjectSound.objectSounds.method3535()) {
            if (var4.soundEffectId != -1 || var4.soundEffectIds != null) {
                int var5 = 0;
                if (var1 > var4.field82) {
                    var5 += var1 - var4.field82;
                } else if (var1 < var4.field80) {
                    var5 += var4.field80 - var1;
                }

                if (var2 > var4.field95) {
                    var5 += var2 - var4.field95;
                } else if (var2 < var4.field81) {
                    var5 += var4.field81 - var2;
                }

                if (var5 - 64 <= var4.field84 && Client.field538 != 0 && var0 == var4.field79) {
                    var5 -= 64;
                    if (var5 < 0) {
                        var5 = 0;
                    }

                    int var6 = (var4.field84 - var5) * Client.field538 / var4.field84;
                    if (var4.stream1 == null) {
                        if (var4.soundEffectId >= 0) {
                            SoundEffect var7 = SoundEffect.method1352(class7.field102, var4.soundEffectId, 0);
                            if (var7 != null) {
                                RawSound var8 = var7.method1343().method1413(MouseHandler.field1392);
                                RawPcmStream var9 = RawPcmStream.method1091(var8, 100, var6);
                                var9.method1055(-1);
                                ItemContainer.pcmStreamMixer.method1126(var9);
                                var4.stream1 = var9;
                            }
                        }
                    } else {
                        var4.stream1.method982(var6);
                    }

                    if (var4.field91 == null) {
                        if (var4.soundEffectIds != null && (var4.field97 -= var3) <= 0) {
                            int var11 = (int) (Math.random() * (double) var4.soundEffectIds.length);
                            SoundEffect var12 = SoundEffect.method1352(class7.field102, var4.soundEffectIds[var11], 0);
                            if (var12 != null) {
                                RawSound var13 = var12.method1343().method1413(MouseHandler.field1392);
                                RawPcmStream var10 = RawPcmStream.method1091(var13, 100, var6);
                                var10.method1055(0);
                                ItemContainer.pcmStreamMixer.method1126(var10);
                                var4.field91 = var10;
                                var4.field97 = var4.field96 + (int) (Math.random() * (double) (var4.field88 - var4.field96));
                            }
                        }
                    } else {
                        var4.field91.method982(var6);
                        if (!var4.field91.method3566()) {
                            var4.field91 = null;
                        }
                    }
                } else {
                    if (var4.stream1 != null) {
                        ItemContainer.pcmStreamMixer.method1127(var4.stream1);
                        var4.stream1 = null;
                    }

                    if (var4.field91 != null) {
                        ItemContainer.pcmStreamMixer.method1127(var4.field91);
                        var4.field91 = null;
                    }
                }
            }
        }

    }

    public static void method2207(int var0) {
        if (class137.musicPlayerStatus != 0) {
            class147.musicTrackVolume = var0;
        } else {
            class137.midiPcmStream.method2975(var0);
        }

    }

    static final void method2205(int var0, int var1) {
        NodeDeque var2 = Client.groundItems[class22.scenePlane][var0][var1];
        if (var2 == null) {
            Interpreter.scene.method2062(class22.scenePlane, var0, var1);
        } else {
            long var3 = -99999999L;
            TileItem var5 = null;

            TileItem var6;
            for (var6 = (TileItem) var2.method3533(); var6 != null; var6 = (TileItem) var2.method3535()) {
                ItemComposition var7 = class27.method571(var6.id);
                long var10 = var7.price;
                if (var7.isStackable == 1) {
                    var10 *= var6.quantity + 1;
                }

                if (var10 > var3) {
                    var3 = var10;
                    var5 = var6;
                }
            }

            if (var5 == null) {
                Interpreter.scene.method2062(class22.scenePlane, var0, var1);
            } else {
                var2.method3529(var5);
                TileItem var12 = null;
                TileItem var8 = null;

                for (var6 = (TileItem) var2.method3533(); var6 != null; var6 = (TileItem) var2.method3535()) {
                    if (var5.id != var6.id) {
                        if (var12 == null) {
                            var12 = var6;
                        }

                        if (var6.id != var12.id && var8 == null) {
                            var8 = var6;
                        }
                    }
                }

                int var9 = var0 + (var1 << 7) + 1610612736;
                Interpreter.scene.addLoot(class22.scenePlane, var0, var1, BufferedFile.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class22.scenePlane), var5, var9, var12, var8);
            }
        }
    }
}
