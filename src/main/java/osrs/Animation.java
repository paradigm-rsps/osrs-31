package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("Animation")
public class Animation {
    @ObfuscatedName("i")
    static int[] field1631 = new int[500];
    @ObfuscatedName("w")
    static int[] field1638 = new int[500];
    @ObfuscatedName("f")
    static int[] field1635 = new int[500];
    @ObfuscatedName("e")
    static int[] field1632 = new int[500];
    @ObfuscatedName("t")
    @Export("skeleton")
    @ObfuscatedSignature(
            descriptor = "Lclass104;"
    )
    Skeleton skeleton = null;
    @ObfuscatedName("d")
    @Export("transformCount")
    int transformCount = -1;
    @ObfuscatedName("p")
    @Export("transformSkeletonLabels")
    int[] transformSkeletonLabels;
    @ObfuscatedName("k")
    @Export("transformXs")
    int[] transformXs;
    @ObfuscatedName("r")
    @Export("transformYs")
    int[] transformYs;
    @ObfuscatedName("l")
    @Export("transformZs")
    int[] transformZs;
    @ObfuscatedName("a")
    @Export("hasAlphaTransform")
    boolean hasAlphaTransform = false;

    @ObfuscatedSignature(
            descriptor = "([BLclass104;)V"
    )
    Animation(byte[] var1, Skeleton var2) {
        this.skeleton = var2;
        Buffer var3 = new Buffer(var1);
        Buffer var4 = new Buffer(var1);
        var3.offset = 2;
        int var5 = var3.readUnsignedByte();
        int var6 = -1;
        int var7 = 0;
        var4.offset = var5 + var3.offset;

        int var8;
        for (var8 = 0; var8 < var5; ++var8) {
            int var9 = var3.readUnsignedByte();
            if (var9 > 0) {
                if (this.skeleton.transformTypes[var8] != 0) {
                    for (int var10 = var8 - 1; var10 > var6; --var10) {
                        if (this.skeleton.transformTypes[var10] == 0) {
                            field1631[var7] = var10;
                            field1638[var7] = 0;
                            field1635[var7] = 0;
                            field1632[var7] = 0;
                            ++var7;
                            break;
                        }
                    }
                }

                field1631[var7] = var8;
                short var11 = 0;
                if (this.skeleton.transformTypes[var8] == 3) {
                    var11 = 128;
                }

                if ((var9 & 1) != 0) {
                    field1638[var7] = var4.method2657();
                } else {
                    field1638[var7] = var11;
                }

                if ((var9 & 2) != 0) {
                    field1635[var7] = var4.method2657();
                } else {
                    field1635[var7] = var11;
                }

                if ((var9 & 4) != 0) {
                    field1632[var7] = var4.method2657();
                } else {
                    field1632[var7] = var11;
                }

                var6 = var8;
                ++var7;
                if (this.skeleton.transformTypes[var8] == 5) {
                    this.hasAlphaTransform = true;
                }
            }
        }

        if (var1.length != var4.offset) {
            throw new RuntimeException();
        } else {
            this.transformCount = var7;
            this.transformSkeletonLabels = new int[var7];
            this.transformXs = new int[var7];
            this.transformYs = new int[var7];
            this.transformZs = new int[var7];

            for (var8 = 0; var8 < var7; ++var8) {
                this.transformSkeletonLabels[var8] = field1631[var8];
                this.transformXs[var8] = field1638[var8];
                this.transformYs[var8] = field1635[var8];
                this.transformZs[var8] = field1632[var8];
            }

        }
    }
}
