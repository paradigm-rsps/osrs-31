package osrs;

public class Rasterizer2D extends DualNode {
    public static int[] Rasterizer2D_pixels;
    public static int Rasterizer2D_width;
    public static int Rasterizer2D_height;
    public static int Rasterizer2D_yClipStart = 0;
    public static int Rasterizer2D_yClipEnd = 0;
    protected static int Rasterizer2D_xClipStart = 0;
    protected static int Rasterizer2D_xClipEnd = 0;

    public static void method1951(int[] var0, int var1, int var2) {
        Rasterizer2D_pixels = var0;
        Rasterizer2D_width = var1;
        Rasterizer2D_height = var2;
        method1953(0, 0, var1, var2);
    }

    public static void method1952() {
        Rasterizer2D_xClipStart = 0;
        Rasterizer2D_yClipStart = 0;
        Rasterizer2D_xClipEnd = Rasterizer2D_width;
        Rasterizer2D_yClipEnd = Rasterizer2D_height;
    }

    public static void method1953(int var0, int var1, int var2, int var3) {
        if (var0 < 0) {
            var0 = 0;
        }

        if (var1 < 0) {
            var1 = 0;
        }

        if (var2 > Rasterizer2D_width) {
            var2 = Rasterizer2D_width;
        }

        if (var3 > Rasterizer2D_height) {
            var3 = Rasterizer2D_height;
        }

        Rasterizer2D_xClipStart = var0;
        Rasterizer2D_yClipStart = var1;
        Rasterizer2D_xClipEnd = var2;
        Rasterizer2D_yClipEnd = var3;
    }

    public static void method1954(int var0, int var1, int var2, int var3) {
        if (Rasterizer2D_xClipStart < var0) {
            Rasterizer2D_xClipStart = var0;
        }

        if (Rasterizer2D_yClipStart < var1) {
            Rasterizer2D_yClipStart = var1;
        }

        if (Rasterizer2D_xClipEnd > var2) {
            Rasterizer2D_xClipEnd = var2;
        }

        if (Rasterizer2D_yClipEnd > var3) {
            Rasterizer2D_yClipEnd = var3;
        }

    }

    public static void method1955(int[] var0) {
        var0[0] = Rasterizer2D_xClipStart;
        var0[1] = Rasterizer2D_yClipStart;
        var0[2] = Rasterizer2D_xClipEnd;
        var0[3] = Rasterizer2D_yClipEnd;
    }

    public static void method1956(int[] var0) {
        Rasterizer2D_xClipStart = var0[0];
        Rasterizer2D_yClipStart = var0[1];
        Rasterizer2D_xClipEnd = var0[2];
        Rasterizer2D_yClipEnd = var0[3];
    }

    public static void method1957() {
        int var0 = 0;

        int var1;
        for (var1 = Rasterizer2D_width * Rasterizer2D_height - 7; var0 < var1; Rasterizer2D_pixels[var0++] = 0) {
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
        }

        for (var1 += 7; var0 < var1; Rasterizer2D_pixels[var0++] = 0) {
        }

    }

    public static void method1958(int var0, int var1, int var2, int var3, int var4, int var5) {
        if (var0 < Rasterizer2D_xClipStart) {
            var2 -= Rasterizer2D_xClipStart - var0;
            var0 = Rasterizer2D_xClipStart;
        }

        if (var1 < Rasterizer2D_yClipStart) {
            var3 -= Rasterizer2D_yClipStart - var1;
            var1 = Rasterizer2D_yClipStart;
        }

        if (var0 + var2 > Rasterizer2D_xClipEnd) {
            var2 = Rasterizer2D_xClipEnd - var0;
        }

        if (var3 + var1 > Rasterizer2D_yClipEnd) {
            var3 = Rasterizer2D_yClipEnd - var1;
        }

        var4 = (var5 * (var4 & 16711935) >> 8 & 16711935) + (var5 * (var4 & '\uff00') >> 8 & '\uff00');
        int var6 = 256 - var5;
        int var7 = Rasterizer2D_width - var2;
        int var8 = var0 + Rasterizer2D_width * var1;

        for (int var9 = 0; var9 < var3; ++var9) {
            for (int var10 = -var2; var10 < 0; ++var10) {
                int var11 = Rasterizer2D_pixels[var8];
                var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + (var6 * (var11 & '\uff00') >> 8 & '\uff00');
                Rasterizer2D_pixels[var8++] = var11 + var4;
            }

            var8 += var7;
        }

    }

    public static void method1962(int var0, int var1, int var2, int var3, int var4) {
        if (var0 < Rasterizer2D_xClipStart) {
            var2 -= Rasterizer2D_xClipStart - var0;
            var0 = Rasterizer2D_xClipStart;
        }

        if (var1 < Rasterizer2D_yClipStart) {
            var3 -= Rasterizer2D_yClipStart - var1;
            var1 = Rasterizer2D_yClipStart;
        }

        if (var0 + var2 > Rasterizer2D_xClipEnd) {
            var2 = Rasterizer2D_xClipEnd - var0;
        }

        if (var3 + var1 > Rasterizer2D_yClipEnd) {
            var3 = Rasterizer2D_yClipEnd - var1;
        }

        int var5 = Rasterizer2D_width - var2;
        int var6 = var0 + Rasterizer2D_width * var1;

        for (int var7 = -var3; var7 < 0; ++var7) {
            for (int var8 = -var2; var8 < 0; ++var8) {
                Rasterizer2D_pixels[var6++] = var4;
            }

            var6 += var5;
        }

    }

    public static void method1960(int var0, int var1, int var2, int var3, int var4, int var5) {
        int var6 = 0;
        int var7 = 65536 / var3;
        if (var0 < Rasterizer2D_xClipStart) {
            var2 -= Rasterizer2D_xClipStart - var0;
            var0 = Rasterizer2D_xClipStart;
        }

        if (var1 < Rasterizer2D_yClipStart) {
            var6 += (Rasterizer2D_yClipStart - var1) * var7;
            var3 -= Rasterizer2D_yClipStart - var1;
            var1 = Rasterizer2D_yClipStart;
        }

        if (var0 + var2 > Rasterizer2D_xClipEnd) {
            var2 = Rasterizer2D_xClipEnd - var0;
        }

        if (var3 + var1 > Rasterizer2D_yClipEnd) {
            var3 = Rasterizer2D_yClipEnd - var1;
        }

        int var8 = Rasterizer2D_width - var2;
        int var9 = var0 + Rasterizer2D_width * var1;

        for (int var10 = -var3; var10 < 0; ++var10) {
            int var11 = 65536 - var6 >> 8;
            int var12 = var6 >> 8;
            int var13 = (var12 * (var5 & 16711935) + var11 * (var4 & 16711935) & -16711936) + (var12 * (var5 & '\uff00') + var11 * (var4 & '\uff00') & 16711680) >>> 8;

            for (int var14 = -var2; var14 < 0; ++var14) {
                Rasterizer2D_pixels[var9++] = var13;
            }

            var9 += var8;
            var6 += var7;
        }

    }

    public static void method1995(int var0, int var1, int var2, int var3, int var4) {
        method1963(var0, var1, var2, var4);
        method1963(var0, var3 + var1 - 1, var2, var4);
        method1996(var0, var1, var3, var4);
        method1996(var0 + var2 - 1, var1, var3, var4);
    }

    public static void method1968(int var0, int var1, int var2, int var3, int var4, int var5) {
        method1981(var0, var1, var2, var4, var5);
        method1981(var0, var3 + var1 - 1, var2, var4, var5);
        if (var3 >= 3) {
            method1966(var0, var1 + 1, var3 - 2, var4, var5);
            method1966(var0 + var2 - 1, var1 + 1, var3 - 2, var4, var5);
        }

    }

    public static void method1963(int var0, int var1, int var2, int var3) {
        if (var1 >= Rasterizer2D_yClipStart && var1 < Rasterizer2D_yClipEnd) {
            if (var0 < Rasterizer2D_xClipStart) {
                var2 -= Rasterizer2D_xClipStart - var0;
                var0 = Rasterizer2D_xClipStart;
            }

            if (var0 + var2 > Rasterizer2D_xClipEnd) {
                var2 = Rasterizer2D_xClipEnd - var0;
            }

            int var4 = var0 + Rasterizer2D_width * var1;

            for (int var5 = 0; var5 < var2; ++var5) {
                Rasterizer2D_pixels[var4 + var5] = var3;
            }

        }
    }

    static void method1981(int var0, int var1, int var2, int var3, int var4) {
        if (var1 >= Rasterizer2D_yClipStart && var1 < Rasterizer2D_yClipEnd) {
            if (var0 < Rasterizer2D_xClipStart) {
                var2 -= Rasterizer2D_xClipStart - var0;
                var0 = Rasterizer2D_xClipStart;
            }

            if (var0 + var2 > Rasterizer2D_xClipEnd) {
                var2 = Rasterizer2D_xClipEnd - var0;
            }

            int var5 = 256 - var4;
            int var6 = (var3 >> 16 & 255) * var4;
            int var7 = (var3 >> 8 & 255) * var4;
            int var8 = var4 * (var3 & 255);
            int var12 = var0 + Rasterizer2D_width * var1;

            for (int var13 = 0; var13 < var2; ++var13) {
                int var9 = var5 * (Rasterizer2D_pixels[var12] >> 16 & 255);
                int var10 = (Rasterizer2D_pixels[var12] >> 8 & 255) * var5;
                int var11 = var5 * (Rasterizer2D_pixels[var12] & 255);
                int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                Rasterizer2D_pixels[var12++] = var14;
            }

        }
    }

    public static void method1996(int var0, int var1, int var2, int var3) {
        if (var0 >= Rasterizer2D_xClipStart && var0 < Rasterizer2D_xClipEnd) {
            if (var1 < Rasterizer2D_yClipStart) {
                var2 -= Rasterizer2D_yClipStart - var1;
                var1 = Rasterizer2D_yClipStart;
            }

            if (var2 + var1 > Rasterizer2D_yClipEnd) {
                var2 = Rasterizer2D_yClipEnd - var1;
            }

            int var4 = var0 + Rasterizer2D_width * var1;

            for (int var5 = 0; var5 < var2; ++var5) {
                Rasterizer2D_pixels[var4 + var5 * Rasterizer2D_width] = var3;
            }

        }
    }

    static void method1966(int var0, int var1, int var2, int var3, int var4) {
        if (var0 >= Rasterizer2D_xClipStart && var0 < Rasterizer2D_xClipEnd) {
            if (var1 < Rasterizer2D_yClipStart) {
                var2 -= Rasterizer2D_yClipStart - var1;
                var1 = Rasterizer2D_yClipStart;
            }

            if (var2 + var1 > Rasterizer2D_yClipEnd) {
                var2 = Rasterizer2D_yClipEnd - var1;
            }

            int var5 = 256 - var4;
            int var6 = (var3 >> 16 & 255) * var4;
            int var7 = (var3 >> 8 & 255) * var4;
            int var8 = var4 * (var3 & 255);
            int var12 = var0 + Rasterizer2D_width * var1;

            for (int var13 = 0; var13 < var2; ++var13) {
                int var9 = var5 * (Rasterizer2D_pixels[var12] >> 16 & 255);
                int var10 = (Rasterizer2D_pixels[var12] >> 8 & 255) * var5;
                int var11 = var5 * (Rasterizer2D_pixels[var12] & 255);
                int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                Rasterizer2D_pixels[var12] = var14;
                var12 += Rasterizer2D_width;
            }

        }
    }

    public static void method1987(int var0, int var1, int var2, int var3, int var4) {
        var2 -= var0;
        var3 -= var1;
        if (var3 == 0) {
            if (var2 >= 0) {
                method1963(var0, var1, var2 + 1, var4);
            } else {
                method1963(var0 + var2, var1, -var2 + 1, var4);
            }

        } else if (var2 == 0) {
            if (var3 >= 0) {
                method1996(var0, var1, var3 + 1, var4);
            } else {
                method1996(var0, var3 + var1, -var3 + 1, var4);
            }

        } else {
            if (var3 + var2 < 0) {
                var0 += var2;
                var2 = -var2;
                var1 += var3;
                var3 = -var3;
            }

            int var5;
            int var6;
            if (var2 > var3) {
                var1 <<= 16;
                var1 += 32768;
                var3 <<= 16;
                var5 = (int) Math.floor((double) var3 / (double) var2 + 0.5D);
                var2 += var0;
                if (var0 < Rasterizer2D_xClipStart) {
                    var1 += var5 * (Rasterizer2D_xClipStart - var0);
                    var0 = Rasterizer2D_xClipStart;
                }

                if (var2 >= Rasterizer2D_xClipEnd) {
                    var2 = Rasterizer2D_xClipEnd - 1;
                }

                while (var0 <= var2) {
                    var6 = var1 >> 16;
                    if (var6 >= Rasterizer2D_yClipStart && var6 < Rasterizer2D_yClipEnd) {
                        Rasterizer2D_pixels[var0 + var6 * Rasterizer2D_width] = var4;
                    }

                    var1 += var5;
                    ++var0;
                }
            } else {
                var0 <<= 16;
                var0 += 32768;
                var2 <<= 16;
                var5 = (int) Math.floor((double) var2 / (double) var3 + 0.5D);
                var3 += var1;
                if (var1 < Rasterizer2D_yClipStart) {
                    var0 += (Rasterizer2D_yClipStart - var1) * var5;
                    var1 = Rasterizer2D_yClipStart;
                }

                if (var3 >= Rasterizer2D_yClipEnd) {
                    var3 = Rasterizer2D_yClipEnd - 1;
                }

                while (var1 <= var3) {
                    var6 = var0 >> 16;
                    if (var6 >= Rasterizer2D_xClipStart && var6 < Rasterizer2D_xClipEnd) {
                        Rasterizer2D_pixels[var6 + Rasterizer2D_width * var1] = var4;
                    }

                    var0 += var5;
                    ++var1;
                }
            }

        }
    }

    public static void method2003(int var0, int var1, int var2, int[] var3, int[] var4) {
        int var5 = var0 + Rasterizer2D_width * var1;

        for (var1 = 0; var1 < var3.length; ++var1) {
            int var6 = var5 + var3[var1];

            for (var0 = -var4[var1]; var0 < 0; ++var0) {
                Rasterizer2D_pixels[var6++] = var2;
            }

            var5 += Rasterizer2D_width;
        }

    }
}
