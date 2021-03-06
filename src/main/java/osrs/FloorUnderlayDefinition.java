package osrs;

public class FloorUnderlayDefinition extends DualNode {
    static byte field882;
    static AbstractArchive FloorUnderlayDefinition_archive;
    static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(64);
    static int[] SpriteBuffer_spritePalette;
    int rgb = 0;
    public int hue;
    public int saturation;
    public int lightness;
    public int hueMultiplier;

    void method700() {
        this.method703(this.rgb);
    }

    void method701(Buffer var1, int var2) {
        while (true) {
            int var3 = var1.readUnsignedByte();
            if (var3 == 0) {
                return;
            }

            this.method699(var1, var3, var2);
        }
    }

    void method699(Buffer var1, int var2, int var3) {
        if (var2 == 1) {
            this.rgb = var1.readMedium();
        }

    }

    void method703(int var1) {
        double var2 = (double) (var1 >> 16 & 255) / 256.0D;
        double var4 = (double) (var1 >> 8 & 255) / 256.0D;
        double var6 = (double) (var1 & 255) / 256.0D;
        double var8 = var2;
        if (var4 < var2) {
            var8 = var4;
        }

        if (var6 < var8) {
            var8 = var6;
        }

        double var10 = var2;
        if (var4 > var2) {
            var10 = var4;
        }

        if (var6 > var10) {
            var10 = var6;
        }

        double var12 = 0.0D;
        double var14 = 0.0D;
        double var16 = (var8 + var10) / 2.0D;
        if (var8 != var10) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var10 + var8);
            }

            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }

            if (var10 == var2) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var4 == var10) {
                var12 = (var6 - var2) / (var10 - var8) + 2.0D;
            } else if (var6 == var10) {
                var12 = (var2 - var4) / (var10 - var8) + 4.0D;
            }
        }

        var12 /= 6.0D;
        this.saturation = (int) (256.0D * var14);
        this.lightness = (int) (256.0D * var16);
        if (this.saturation < 0) {
            this.saturation = 0;
        } else if (this.saturation > 255) {
            this.saturation = 255;
        }

        if (this.lightness < 0) {
            this.lightness = 0;
        } else if (this.lightness > 255) {
            this.lightness = 255;
        }

        if (var16 > 0.5D) {
            this.hueMultiplier = (int) (512.0D * (1.0D - var16) * var14);
        } else {
            this.hueMultiplier = (int) (512.0D * var14 * var16);
        }

        if (this.hueMultiplier < 1) {
            this.hueMultiplier = 1;
        }

        this.hue = (int) (var12 * (double) this.hueMultiplier);
    }

    public static void method718() {
        VarpDefinition.VarpDefinition_cached.method3482();
    }
}
