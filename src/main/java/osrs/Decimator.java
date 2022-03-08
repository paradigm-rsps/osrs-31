package osrs;

public class Decimator {
    static int menuHeight;
    static IterableNodeHashTableIterator js5Socket;
    static IndexedSprite[] mapSceneSprites;
    int inputRate;
    int outputRate;
    int[][] table;

    public Decimator(int var1, int var2) {
        if (var2 != var1) {
            int var4 = var1;
            int var5 = var2;
            if (var2 > var1) {
                var4 = var2;
                var5 = var1;
            }

            while (var5 != 0) {
                int var6 = var4 % var5;
                var4 = var5;
                var5 = var6;
            }

            var1 /= var4;
            var2 /= var4;
            this.inputRate = var1;
            this.outputRate = var2;
            this.table = new int[var1][14];

            for (int var7 = 0; var7 < var1; ++var7) {
                int[] var8 = this.table[var7];
                double var9 = 6.0D + (double) var7 / (double) var1;
                int var11 = (int) Math.floor(1.0D + (var9 - 7.0D));
                if (var11 < 0) {
                    var11 = 0;
                }

                int var12 = (int) Math.ceil(7.0D + var9);
                if (var12 > 14) {
                    var12 = 14;
                }

                for (double var13 = (double) var2 / (double) var1; var11 < var12; ++var11) {
                    double var15 = ((double) var11 - var9) * 3.141592653589793D;
                    double var17 = var13;
                    if (var15 < -1.0E-4D || var15 > 1.0E-4D) {
                        var17 = var13 * (Math.sin(var15) / var15);
                    }

                    var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double) var11 - var9));
                    var8[var11] = (int) Math.floor(0.5D + 65536.0D * var17);
                }
            }

        }
    }

    byte[] method1402(byte[] var1) {
        if (this.table != null) {
            int var2 = (int) ((long) this.outputRate * (long) var1.length / (long) this.inputRate) + 14;
            int[] var3 = new int[var2];
            int var4 = 0;
            int var5 = 0;

            int var6;
            for (var6 = 0; var6 < var1.length; ++var6) {
                byte var7 = var1[var6];
                int[] var8 = this.table[var5];

                int var9;
                for (var9 = 0; var9 < 14; ++var9) {
                    var3[var4 + var9] += var8[var9] * var7;
                }

                var5 += this.outputRate;
                var9 = var5 / this.inputRate;
                var4 += var9;
                var5 -= var9 * this.inputRate;
            }

            var1 = new byte[var2];

            for (var6 = 0; var6 < var2; ++var6) {
                int var10 = var3[var6] + '耀' >> 16;
                if (var10 < -128) {
                    var1[var6] = -128;
                } else if (var10 > 127) {
                    var1[var6] = 127;
                } else {
                    var1[var6] = (byte) var10;
                }
            }
        }

        return var1;
    }

    int method1404(int var1) {
        if (this.table != null) {
            var1 = (int) ((long) var1 * (long) this.outputRate / (long) this.inputRate);
        }

        return var1;
    }

    int method1403(int var1) {
        if (this.table != null) {
            var1 = (int) ((long) var1 * (long) this.outputRate / (long) this.inputRate) + 6;
        }

        return var1;
    }

    static int method1409(int var0, int var1) {
        long var2 = (var0 << 16) + var1;
        return MusicPatchPcmStream.NetCache_currentResponse != null && var2 == MusicPatchPcmStream.NetCache_currentResponse.key ? class68.NetCache_responseArchiveBuffer.offset * 99 / (class68.NetCache_responseArchiveBuffer.array.length - MusicPatchPcmStream.NetCache_currentResponse.padding) + 1 : 0;
    }

    static final void method1401() {
        int var0 = ItemContainer.menuX;
        int var1 = BufferedFile.menuY;
        int var2 = IterableNodeHashTableIterator.menuWidth;
        int var3 = menuHeight;
        int var4 = 6116423;
        Rasterizer2D.method1962(var0, var1, var2, var3, var4);
        Rasterizer2D.method1962(var0 + 1, var1 + 1, var2 - 2, 16, 0);
        Rasterizer2D.method1995(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
        class40.fontBold12.method3626("Choose Option", var0 + 3, var1 + 14, var4, -1);
        int var5 = MouseHandler.MouseHandler_x;
        int var6 = MouseHandler.MouseHandler_y;

        int var7;
        int var8;
        int var9;
        for (var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
            var8 = (Client.menuOptionsCount - 1 - var7) * 15 + var1 + 31;
            var9 = 16777215;
            if (var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
                var9 = 16776960;
            }

            Font var12 = class40.fontBold12;
            String var13;
            if (Client.menuTargets[var7].length() > 0) {
                var13 = Client.menuActions[var7] + " " + Client.menuTargets[var7];
            } else {
                var13 = Client.menuActions[var7];
            }

            var12.method3626(var13, var0 + 3, var8, var9, 0);
        }

        var7 = ItemContainer.menuX;
        var8 = BufferedFile.menuY;
        var9 = IterableNodeHashTableIterator.menuWidth;
        int var10 = menuHeight;

        for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
            if (Client.rootWidgetWidths[var11] + Client.rootWidgetXs[var11] > var7 && Client.rootWidgetXs[var11] < var7 + var9 && Client.rootWidgetYs[var11] + Client.rootWidgetHeights[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
                Client.field687[var11] = true;
            }
        }

    }
}
