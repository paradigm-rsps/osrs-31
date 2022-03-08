package osrs;

public class FloorOverlayDefinition extends DualNode {
    static AbstractArchive FloorOverlayDefinition_archive;
    static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
    public int primaryRgb = 0;
    public int texture = -1;
    public boolean hideUnderlay = true;
    public int secondaryRgb = -1;
    public int hue;
    public int saturation;
    public int lightness;
    public int secondaryHue;
    public int secondarySaturation;
    public int secondaryLightness;

    void method808() {
        if (this.secondaryRgb != -1) {
            this.method811(this.secondaryRgb);
            this.secondaryHue = this.hue;
            this.secondarySaturation = this.saturation;
            this.secondaryLightness = this.lightness;
        }

        this.method811(this.primaryRgb);
    }

    void method809(Buffer var1, int var2) {
        while (true) {
            int var3 = var1.readUnsignedByte();
            if (var3 == 0) {
                return;
            }

            this.method810(var1, var3, var2);
        }
    }

    void method810(Buffer var1, int var2, int var3) {
        if (var2 == 1) {
            this.primaryRgb = var1.readMedium();
        } else if (var2 == 2) {
            this.texture = var1.readUnsignedByte();
        } else if (var2 == 5) {
            this.hideUnderlay = false;
        } else if (var2 == 7) {
            this.secondaryRgb = var1.readMedium();
        } else if (var2 == 8) {
        }

    }

    void method811(int var1) {
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
        double var16 = (var10 + var8) / 2.0D;
        if (var8 != var10) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var10 + var8);
            }

            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }

            if (var2 == var10) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var4 == var10) {
                var12 = 2.0D + (var6 - var2) / (var10 - var8);
            } else if (var10 == var6) {
                var12 = (var2 - var4) / (var10 - var8) + 4.0D;
            }
        }

        var12 /= 6.0D;
        this.hue = (int) (256.0D * var12);
        this.saturation = (int) (256.0D * var14);
        this.lightness = (int) (var16 * 256.0D);
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

    }

    static String method829(int var0) {
        return "<img=" + var0 + ">";
    }
}
