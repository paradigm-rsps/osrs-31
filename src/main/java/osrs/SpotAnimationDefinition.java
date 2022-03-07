package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import osrs.cache.Definitions;

@ObfuscatedName("ax")
@Implements("SpotAnimationDefinition")
public class SpotAnimationDefinition extends DualNode {
    @ObfuscatedName("i")
    @Export("SpotAnimationDefinition_archive")
    @ObfuscatedSignature(
            descriptor = "Lclass151;"
    )
    static AbstractArchive SpotAnimationDefinition_archive;
    @ObfuscatedName("w")
    @Export("SpotAnimationDefinition_modelArchive")
    @ObfuscatedSignature(
            descriptor = "Lclass151;"
    )
    static AbstractArchive SpotAnimationDefinition_modelArchive;
    @ObfuscatedName("f")
    @Export("SpotAnimationDefinition_cached")
    @ObfuscatedSignature(
            descriptor = "Lclass169;"
    )
    public static EvictingDualNodeHashTable SpotAnimationDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("e")
    @Export("SpotAnimationDefinition_cachedModels")
    @ObfuscatedSignature(
            descriptor = "Lclass169;"
    )
    public static EvictingDualNodeHashTable SpotAnimationDefinition_cachedModels = new EvictingDualNodeHashTable(30);
    @ObfuscatedName("t")
    @Export("id")
    int id;
    @ObfuscatedName("d")
    @Export("archive")
    int archive;
    @ObfuscatedName("p")
    @Export("sequence")
    public int sequence = -1;
    @ObfuscatedName("k")
    @Export("recolorFrom")
    short[] recolorFrom;
    @ObfuscatedName("r")
    @Export("recolorTo")
    short[] recolorTo;
    @ObfuscatedName("l")
    @Export("retextureFrom")
    short[] retextureFrom;
    @ObfuscatedName("a")
    @Export("retextureTo")
    short[] retextureTo;
    @ObfuscatedName("z")
    @Export("widthScale")
    int widthScale = 128;
    @ObfuscatedName("s")
    @Export("heightScale")
    int heightScale = 128;
    @ObfuscatedName("m")
    @Export("orientation")
    int orientation = 0;
    @ObfuscatedName("u")
    @Export("ambient")
    int ambient = 0;
    @ObfuscatedName("g")
    @Export("contrast")
    int contrast = 0;

    @ObfuscatedName("f")
    @Export("method764")
    @ObfuscatedSignature(
            descriptor = "(Lclass126;)V"
    )
    void method764(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method765(var1, var2);
        }
    }

    @ObfuscatedName("e")
    @Export("method765")
    @ObfuscatedSignature(
            descriptor = "(Lclass126;I)V"
    )
    void method765(Buffer var1, int var2) {
        if (var2 == 1) {
            this.archive = var1.readUnsignedShort();
        } else if (var2 == 2) {
            this.sequence = var1.readUnsignedShort();
        } else if (var2 == 4) {
            this.widthScale = var1.readUnsignedShort();
        } else if (var2 == 5) {
            this.heightScale = var1.readUnsignedShort();
        } else if (var2 == 6) {
            this.orientation = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.ambient = var1.readUnsignedByte();
        } else if (var2 == 8) {
            this.contrast = var1.readUnsignedByte();
        } else {
            int var3;
            int var4;
            if (var2 == 40) {
                var3 = var1.readUnsignedByte();
                this.recolorFrom = new short[var3];
                this.recolorTo = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.recolorFrom[var4] = (short) var1.readUnsignedShort();
                    this.recolorTo[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUnsignedByte();
                this.retextureFrom = new short[var3];
                this.retextureTo = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.retextureFrom[var4] = (short) var1.readUnsignedShort();
                    this.retextureTo[var4] = (short) var1.readUnsignedShort();
                }
            }
        }

    }

    @ObfuscatedName("t")
    @Export("method766")
    @ObfuscatedSignature(
            descriptor = "(I)Lclass111;"
    )
    public final Model method766(int var1) {
        Model var2 = (Model) SpotAnimationDefinition_cachedModels.method3474(this.id);
        if (var2 == null) {
            ModelData var3 = ModelData.method2222(SpotAnimationDefinition_modelArchive, this.archive, 0);
            if (var3 == null) {
                return null;
            }

            int var4;
            if (this.recolorFrom != null) {
                for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
                    var3.method2234(this.recolorFrom[var4], this.recolorTo[var4]);
                }
            }

            if (this.retextureFrom != null) {
                for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
                    var3.method2236(this.retextureFrom[var4], this.retextureTo[var4]);
                }
            }

            var2 = var3.method2282(this.ambient + 64, this.contrast + 850, -30, -50, -30);
            SpotAnimationDefinition_cachedModels.method3473(var2, this.id);
        }

        Model var5;
        if (this.sequence != -1 && var1 != -1) {
            var5 = Definitions.getAnimation(this.sequence).method727(var2, var1);
        } else {
            var5 = var2.method2495(true);
        }

        if (this.widthScale != 128 || this.heightScale != 128) {
            var5.method2438(this.widthScale, this.heightScale, this.widthScale);
        }

        if (this.orientation != 0) {
            if (this.orientation == 90) {
                var5.method2488();
            }

            if (this.orientation == 180) {
                var5.method2488();
                var5.method2488();
            }

            if (this.orientation == 270) {
                var5.method2488();
                var5.method2488();
                var5.method2488();
            }
        }

        return var5;
    }

    @ObfuscatedName("ab")
    @Export("method770")
    @ObfuscatedSignature(
            descriptor = "(Lclass2;II)V"
    )
    static void setAnimation(Player player, int id, int delay) {
        if (player.animation == id && id != -1) {
            int var3 = Definitions.getAnimation(id).field901;
            if (var3 == 1) {
                player.sequenceFrame = 0;
                player.sequenceFrameCycle = 0;
                player.sequenceDelay = delay;
                player.field421 = 0;
            }

            if (var3 == 2) {
                player.field421 = 0;
            }
        } else if (id == -1 || player.animation == -1 || Definitions.getAnimation(id).field895 >= Definitions.getAnimation(player.animation).field895) {
            player.animation = id;
            player.sequenceFrame = 0;
            player.sequenceFrameCycle = 0;
            player.sequenceDelay = delay;
            player.field421 = 0;
            player.remainingSteps = player.pathLength;
        }
    }
}
