package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;

@ObfuscatedName("ay")
@Implements("PcmPlayer")
public class PcmPlayer {
    @ObfuscatedName("ix")
    @Export("selectedItemWidget")
    static int selectedItemWidget;
    @ObfuscatedName("t")
    public static int field1099;
    @ObfuscatedName("d")
    @Export("PcmPlayer_stereo")
    public static boolean PcmPlayer_stereo;
    @ObfuscatedName("a")
    @Export("samples")
    int[] samples;
    @ObfuscatedName("z")
    @Export("stream")
    @ObfuscatedSignature(
            descriptor = "Lclass47;"
    )
    PcmStream stream;
    @ObfuscatedName("s")
    int field1102 = 32;
    @ObfuscatedName("m")
    @Export("timeMs")
    long timeMs = ClientPreferences.method148();
    @ObfuscatedName("u")
    @Export("capacity")
    int capacity;
    @ObfuscatedName("g")
    int field1105;
    @ObfuscatedName("o")
    int field1113;
    @ObfuscatedName("v")
    long field1107 = 0L;
    @ObfuscatedName("j")
    int field1108 = 0;
    @ObfuscatedName("n")
    int field1104 = 0;
    @ObfuscatedName("q")
    int field1097 = 0;
    @ObfuscatedName("c")
    long field1111 = 0L;
    @ObfuscatedName("h")
    boolean field1112 = true;
    @ObfuscatedName("aa")
    int field1114 = 0;
    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "[Lclass47;"
    )
    PcmStream[] field1115 = new PcmStream[8];
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "[Lclass47;"
    )
    PcmStream[] field1116 = new PcmStream[8];

    @ObfuscatedName("i")
    void vmethod1234(Component var1) throws Exception {
    }

    @ObfuscatedName("w")
    void vmethod1235(int var1) throws Exception {
    }

    @ObfuscatedName("f")
    @Export("vmethod1233")
    int vmethod1233() throws Exception {
        return this.capacity;
    }

    @ObfuscatedName("e")
    void vmethod1237() throws Exception {
    }

    @ObfuscatedName("t")
    void vmethod1238() {
    }

    @ObfuscatedName("d")
    void vmethod1229() throws Exception {
    }

    @ObfuscatedName("c")
    @Export("method1226")
    @ObfuscatedSignature(
            descriptor = "(Lclass47;)V"
    )
    public final synchronized void method1226(PcmStream var1) {
        this.stream = var1;
    }

    @ObfuscatedName("h")
    @Export("method1227")
    public final synchronized void method1227() {
        if (this.samples != null) {
            long var1 = ClientPreferences.method148();

            try {
                if (this.field1107 != 0L) {
                    if (var1 < this.field1107) {
                        return;
                    }

                    this.vmethod1235(this.capacity);
                    this.field1107 = 0L;
                    this.field1112 = true;
                }

                int var3 = this.vmethod1233();
                if (this.field1097 - var3 > this.field1108) {
                    this.field1108 = this.field1097 - var3;
                }

                int var4 = this.field1105 + this.field1113;
                if (var4 + 256 > 16384) {
                    var4 = 16128;
                }

                if (var4 + 256 > this.capacity) {
                    this.capacity += 1024;
                    if (this.capacity > 16384) {
                        this.capacity = 16384;
                    }

                    this.vmethod1238();
                    this.vmethod1235(this.capacity);
                    var3 = 0;
                    this.field1112 = true;
                    if (var4 + 256 > this.capacity) {
                        var4 = this.capacity - 256;
                        this.field1113 = var4 - this.field1105;
                    }
                }

                while (var3 < var4) {
                    this.method1246(this.samples, 256);
                    this.vmethod1237();
                    var3 += 256;
                }

                if (var1 > this.field1111) {
                    if (!this.field1112) {
                        if (this.field1108 == 0 && this.field1104 == 0) {
                            this.vmethod1238();
                            this.field1107 = 2000L + var1;
                            return;
                        }

                        this.field1113 = Math.min(this.field1104, this.field1108);
                        this.field1104 = this.field1108;
                    } else {
                        this.field1112 = false;
                    }

                    this.field1108 = 0;
                    this.field1111 = 2000L + var1;
                }

                this.field1097 = var3;
            } catch (Exception var7) {
                this.vmethod1238();
                this.field1107 = var1 + 2000L;
            }

            try {
                if (var1 > this.timeMs + 500000L) {
                    var1 = this.timeMs;
                }

                while (var1 > this.timeMs + 5000L) {
                    this.method1231(256);
                    this.timeMs += 256000 / field1099;
                }
            } catch (Exception var6) {
                this.timeMs = var1;
            }

        }
    }

    @ObfuscatedName("b")
    public final void method1228() {
        this.field1112 = true;
    }

    @ObfuscatedName("y")
    public final synchronized void method1274() {
        this.field1112 = true;

        try {
            this.vmethod1229();
        } catch (Exception var2) {
            this.vmethod1238();
            this.field1107 = ClientPreferences.method148() + 2000L;
        }

    }

    @ObfuscatedName("x")
    @Export("method1272")
    public final synchronized void method1272() {
        if (TileItem.soundSystem != null) {
            boolean var1 = true;

            for (int var2 = 0; var2 < 2; ++var2) {
                if (this == TileItem.soundSystem.players[var2]) {
                    TileItem.soundSystem.players[var2] = null;
                }

                if (TileItem.soundSystem.players[var2] != null) {
                    var1 = false;
                }
            }

            if (var1) {
                TileItem.soundSystem.field1183 = true;

                while (TileItem.soundSystem.field1182) {
                    SequenceDefinition.sleepWeird(50L);
                }

                TileItem.soundSystem = null;
            }
        }

        this.vmethod1238();
        this.samples = null;
    }

    @ObfuscatedName("ao")
    @Export("method1231")
    final void method1231(int var1) {
        this.field1114 -= var1;
        if (this.field1114 < 0) {
            this.field1114 = 0;
        }

        if (this.stream != null) {
            this.stream.vmethod3048(var1);
        }

    }

    @ObfuscatedName("ae")
    @Export("method1246")
    final void method1246(int[] var1, int var2) {
        int var3 = var2;
        if (PcmPlayer_stereo) {
            var3 = var2 << 1;
        }

        class127.method2846(var1, 0, var3);
        this.field1114 -= var2;
        if (this.stream != null && this.field1114 <= 0) {
            this.field1114 += field1099 >> 4;
            ItemComposition.method900(this.stream);
            this.method1230(this.stream, this.stream.vmethod1184());
            int var4 = 0;
            int var5 = 255;

            int var6;
            PcmStream var10;
            label110:
            for (var6 = 7; var5 != 0; --var6) {
                int var7;
                int var8;
                if (var6 < 0) {
                    var7 = var6 & 3;
                    var8 = -(var6 >> 2);
                } else {
                    var7 = var6;
                    var8 = 0;
                }

                for (int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
                    if ((var9 & 1) != 0) {
                        var5 &= ~(1 << var7);
                        var10 = null;
                        PcmStream var11 = this.field1115[var7];

                        label104:
                        while (true) {
                            while (true) {
                                if (var11 == null) {
                                    break label104;
                                }

                                AbstractSound var12 = var11.sound;
                                if (var12 != null && var12.position > var8) {
                                    var5 |= 1 << var7;
                                    var10 = var11;
                                    var11 = var11.after;
                                } else {
                                    var11.active = true;
                                    int var13 = var11.vmethod3046();
                                    var4 += var13;
                                    if (var12 != null) {
                                        var12.position += var13;
                                    }

                                    if (var4 >= this.field1102) {
                                        break label110;
                                    }

                                    PcmStream var14 = var11.vmethod3061();
                                    if (var14 != null) {
                                        for (int var15 = var11.field1074; var14 != null; var14 = var11.vmethod3052()) {
                                            this.method1230(var14, var15 * var14.vmethod1184() >> 8);
                                        }
                                    }

                                    PcmStream var18 = var11.after;
                                    var11.after = null;
                                    if (var10 == null) {
                                        this.field1115[var7] = var18;
                                    } else {
                                        var10.after = var18;
                                    }

                                    if (var18 == null) {
                                        this.field1116[var7] = var10;
                                    }

                                    var11 = var18;
                                }
                            }
                        }
                    }

                    var7 += 4;
                    ++var8;
                }
            }

            for (var6 = 0; var6 < 8; ++var6) {
                PcmStream var16 = this.field1115[var6];
                PcmStream[] var17 = this.field1115;
                this.field1116[var6] = null;

                for (var17[var6] = null; var16 != null; var16 = var10) {
                    var10 = var16.after;
                    var16.after = null;
                }
            }
        }

        if (this.field1114 < 0) {
            this.field1114 = 0;
        }

        if (this.stream != null) {
            this.stream.vmethod3045(var1, 0, var2);
        }

        this.timeMs = ClientPreferences.method148();
    }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "(Lclass47;I)V"
    )
    final void method1230(PcmStream var1, int var2) {
        int var3 = var2 >> 5;
        PcmStream var4 = this.field1116[var3];
        if (var4 == null) {
            this.field1115[var3] = var1;
        } else {
            var4.after = var1;
        }

        this.field1116[var3] = var1;
        var1.field1074 = var2;
    }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)Lclass36;"
    )
    public static FloorOverlayDefinition method1225(int var0) {
        FloorOverlayDefinition var1 = (FloorOverlayDefinition) FloorOverlayDefinition.HitSplatDefinition_cachedSprites.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = FloorOverlayDefinition.FloorOverlayDefinition_archive.method3204(4, var0);
            var1 = new FloorOverlayDefinition();
            if (var2 != null) {
                var1.method809(new Buffer(var2), var0);
            }

            var1.method808();
            FloorOverlayDefinition.HitSplatDefinition_cachedSprites.method3473(var1, var0);
            return var1;
        }
    }
}
