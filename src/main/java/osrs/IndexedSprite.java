package osrs;

public final class IndexedSprite extends Rasterizer2D {
    public byte[] pixels;
    public int[] palette;
    public int subWidth;
    public int subHeight;
    public int xOffset;
    public int yOffset;
    public int width;
    public int height;

    public void method1925() {
        if (this.subWidth != this.width || this.subHeight != this.height) {
            byte[] var1 = new byte[this.width * this.height];
            int var2 = 0;

            for (int var3 = 0; var3 < this.subHeight; ++var3) {
                for (int var4 = 0; var4 < this.subWidth; ++var4) {
                    var1[var4 + (var3 + this.yOffset) * this.width + this.xOffset] = this.pixels[var2++];
                }
            }

            this.pixels = var1;
            this.subWidth = this.width;
            this.subHeight = this.height;
            this.xOffset = 0;
            this.yOffset = 0;
        }
    }

    public void method1926(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.palette.length; ++var4) {
            int var5 = this.palette[var4] >> 16 & 255;
            var5 += var1;
            if (var5 < 0) {
                var5 = 0;
            } else if (var5 > 255) {
                var5 = 255;
            }

            int var6 = this.palette[var4] >> 8 & 255;
            var6 += var2;
            if (var6 < 0) {
                var6 = 0;
            } else if (var6 > 255) {
                var6 = 255;
            }

            int var7 = this.palette[var4] & 255;
            var7 += var3;
            if (var7 < 0) {
                var7 = 0;
            } else if (var7 > 255) {
                var7 = 255;
            }

            this.palette[var4] = var7 + (var6 << 8) + (var5 << 16);
        }

    }

    public void method1936(int var1, int var2) {
        var1 += this.xOffset;
        var2 += this.yOffset;
        int var3 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
        int var4 = 0;
        int var5 = this.subHeight;
        int var6 = this.subWidth;
        int var7 = Rasterizer2D.Rasterizer2D_width - var6;
        int var8 = 0;
        int var9;
        if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
            var9 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
            var5 -= var9;
            var2 = Rasterizer2D.Rasterizer2D_yClipStart;
            var4 += var9 * var6;
            var3 += var9 * Rasterizer2D.Rasterizer2D_width;
        }

        if (var5 + var2 > Rasterizer2D.Rasterizer2D_yClipEnd) {
            var5 -= var5 + var2 - Rasterizer2D.Rasterizer2D_yClipEnd;
        }

        if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
            var9 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
            var6 -= var9;
            var1 = Rasterizer2D.Rasterizer2D_xClipStart;
            var4 += var9;
            var3 += var9;
            var8 += var9;
            var7 += var9;
        }

        if (var6 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
            var9 = var6 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
            var6 -= var9;
            var8 += var9;
            var7 += var9;
        }

        if (var6 > 0 && var5 > 0) {
            method1927(Rasterizer2D.Rasterizer2D_pixels, this.pixels, this.palette, var4, var3, var6, var5, var7, var8);
        }
    }

    static void method1927(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = -(var5 >> 2);
        var5 = -(var5 & 3);

        for (int var10 = -var6; var10 < 0; ++var10) {
            int var11;
            byte var12;
            for (var11 = var9; var11 < 0; ++var11) {
                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255];
                } else {
                    ++var4;
                }

                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255];
                } else {
                    ++var4;
                }

                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255];
                } else {
                    ++var4;
                }

                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255];
                } else {
                    ++var4;
                }
            }

            for (var11 = var5; var11 < 0; ++var11) {
                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255];
                } else {
                    ++var4;
                }
            }

            var4 += var7;
            var3 += var8;
        }

    }
}
