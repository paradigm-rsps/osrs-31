package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("Model")
public class Model extends Renderable {
    @ObfuscatedName("i")
    @Export("Model_sharedSequenceModel")
    @ObfuscatedSignature(
            descriptor = "Lclass111;"
    )
    static Model Model_sharedSequenceModel = new Model();
    @ObfuscatedName("w")
    @Export("Model_sharedSequenceModelFaceAlphas")
    static byte[] Model_sharedSequenceModelFaceAlphas = new byte[1];
    @ObfuscatedName("f")
    @Export("Model_sharedSpotAnimationModel")
    @ObfuscatedSignature(
            descriptor = "Lclass111;"
    )
    static Model Model_sharedSpotAnimationModel = new Model();
    @ObfuscatedName("e")
    @Export("Model_sharedSpotAnimationModelFaceAlphas")
    static byte[] Model_sharedSpotAnimationModelFaceAlphas = new byte[1];
    @ObfuscatedName("ak")
    static boolean[] field1896 = new boolean[4096];
    @ObfuscatedName("ax")
    static boolean[] field1882 = new boolean[4096];
    @ObfuscatedName("ab")
    @Export("modelViewportXs")
    static int[] modelViewportXs = new int[4096];
    @ObfuscatedName("af")
    @Export("modelViewportYs")
    static int[] modelViewportYs = new int[4096];
    @ObfuscatedName("ai")
    static int[] field1923 = new int[4096];
    @ObfuscatedName("at")
    static int[] field1900 = new int[4096];
    @ObfuscatedName("aq")
    static int[] field1901 = new int[4096];
    @ObfuscatedName("ac")
    static int[] field1902 = new int[4096];
    @ObfuscatedName("ag")
    static int[] field1904 = new int[1600];
    @ObfuscatedName("ap")
    static int[][] field1905 = new int[1600][512];
    @ObfuscatedName("am")
    static int[] field1906 = new int[12];
    @ObfuscatedName("as")
    static int[][] field1907 = new int[12][2000];
    @ObfuscatedName("aj")
    static int[] field1916 = new int[2000];
    @ObfuscatedName("ar")
    static int[] field1909 = new int[2000];
    @ObfuscatedName("au")
    static int[] field1910 = new int[12];
    @ObfuscatedName("ad")
    static int[] field1911 = new int[10];
    @ObfuscatedName("az")
    static int[] field1912 = new int[10];
    @ObfuscatedName("ay")
    static int[] field1895 = new int[10];
    @ObfuscatedName("bh")
    @Export("Model_transformTempX")
    static int Model_transformTempX;
    @ObfuscatedName("ba")
    @Export("Model_transformTempY")
    static int Model_transformTempY;
    @ObfuscatedName("bn")
    @Export("Model_transformTempZ")
    static int Model_transformTempZ;
    @ObfuscatedName("bj")
    public static boolean field1917 = false;
    @ObfuscatedName("bu")
    public static int field1877 = 0;
    @ObfuscatedName("br")
    public static int field1919 = 0;
    @ObfuscatedName("bd")
    public static int field1920 = 0;
    @ObfuscatedName("bf")
    public static int[] field1921 = new int[1000];
    @ObfuscatedName("bg")
    static int[] field1866;
    @ObfuscatedName("bp")
    static int[] field1897;
    @ObfuscatedName("bb")
    static int[] field1924;
    @ObfuscatedName("bc")
    static int[] field1925;
    @ObfuscatedName("t")
    @Export("verticesCount")
    int verticesCount = 0;
    @ObfuscatedName("d")
    @Export("verticesX")
    int[] verticesX;
    @ObfuscatedName("p")
    @Export("verticesY")
    int[] verticesY;
    @ObfuscatedName("k")
    @Export("verticesZ")
    int[] verticesZ;
    @ObfuscatedName("r")
    @Export("indicesCount")
    int indicesCount = 0;
    @ObfuscatedName("l")
    @Export("indices1")
    int[] indices1;
    @ObfuscatedName("a")
    @Export("indices2")
    int[] indices2;
    @ObfuscatedName("z")
    @Export("indices3")
    int[] indices3;
    @ObfuscatedName("s")
    @Export("faceColors1")
    int[] faceColors1;
    @ObfuscatedName("m")
    @Export("faceColors2")
    int[] faceColors2;
    @ObfuscatedName("u")
    @Export("faceColors3")
    int[] faceColors3;
    @ObfuscatedName("g")
    @Export("faceRenderPriorities")
    byte[] faceRenderPriorities;
    @ObfuscatedName("o")
    @Export("faceAlphas")
    byte[] faceAlphas;
    @ObfuscatedName("v")
    byte[] field1879;
    @ObfuscatedName("j")
    @Export("faceTextures")
    short[] faceTextures;
    @ObfuscatedName("n")
    byte field1918 = 0;
    @ObfuscatedName("q")
    int field1914 = 0;
    @ObfuscatedName("c")
    int[] field1892;
    @ObfuscatedName("h")
    int[] field1884;
    @ObfuscatedName("b")
    int[] field1885;
    @ObfuscatedName("y")
    @Export("vertexLabels")
    int[][] vertexLabels;
    @ObfuscatedName("x")
    @Export("faceLabelsAlpha")
    int[][] faceLabelsAlpha;
    @ObfuscatedName("ao")
    @Export("isSingleTile")
    public boolean isSingleTile = false;
    @ObfuscatedName("ae")
    @Export("boundsType")
    int boundsType;
    @ObfuscatedName("aa")
    @Export("bottomY")
    int bottomY;
    @ObfuscatedName("ah")
    @Export("xzRadius")
    int xzRadius;
    @ObfuscatedName("aw")
    @Export("diameter")
    int diameter;
    @ObfuscatedName("an")
    @Export("radius")
    int radius;

    static {
        field1866 = Rasterizer3D.Rasterizer3D_sine;
        field1897 = Rasterizer3D.Rasterizer3D_cosine;
        field1924 = Rasterizer3D.field1783;
        field1925 = Rasterizer3D.field1785;
    }

    Model() {
    }

    @ObfuscatedSignature(
            descriptor = "([Lclass111;I)V"
    )
    public Model(Model[] var1, int var2) {
        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        this.verticesCount = 0;
        this.indicesCount = 0;
        this.field1914 = 0;
        this.field1918 = -1;

        int var7;
        Model var8;
        for (var7 = 0; var7 < var2; ++var7) {
            var8 = var1[var7];
            if (var8 != null) {
                this.verticesCount += var8.verticesCount;
                this.indicesCount += var8.indicesCount;
                this.field1914 += var8.field1914;
                if (var8.faceRenderPriorities != null) {
                    var3 = true;
                } else {
                    if (this.field1918 == -1) {
                        this.field1918 = var8.field1918;
                    }

                    if (this.field1918 != var8.field1918) {
                        var3 = true;
                    }
                }

                var4 |= var8.faceAlphas != null;
                var5 |= var8.faceTextures != null;
                var6 |= var8.field1879 != null;
            }
        }

        this.verticesX = new int[this.verticesCount];
        this.verticesY = new int[this.verticesCount];
        this.verticesZ = new int[this.verticesCount];
        this.indices1 = new int[this.indicesCount];
        this.indices2 = new int[this.indicesCount];
        this.indices3 = new int[this.indicesCount];
        this.faceColors1 = new int[this.indicesCount];
        this.faceColors2 = new int[this.indicesCount];
        this.faceColors3 = new int[this.indicesCount];
        if (var3) {
            this.faceRenderPriorities = new byte[this.indicesCount];
        }

        if (var4) {
            this.faceAlphas = new byte[this.indicesCount];
        }

        if (var5) {
            this.faceTextures = new short[this.indicesCount];
        }

        if (var6) {
            this.field1879 = new byte[this.indicesCount];
        }

        if (this.field1914 > 0) {
            this.field1892 = new int[this.field1914];
            this.field1884 = new int[this.field1914];
            this.field1885 = new int[this.field1914];
        }

        this.verticesCount = 0;
        this.indicesCount = 0;
        this.field1914 = 0;

        for (var7 = 0; var7 < var2; ++var7) {
            var8 = var1[var7];
            if (var8 != null) {
                int var9;
                for (var9 = 0; var9 < var8.indicesCount; ++var9) {
                    this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
                    this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
                    this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
                    this.faceColors1[this.indicesCount] = var8.faceColors1[var9];
                    this.faceColors2[this.indicesCount] = var8.faceColors2[var9];
                    this.faceColors3[this.indicesCount] = var8.faceColors3[var9];
                    if (var3) {
                        if (var8.faceRenderPriorities != null) {
                            this.faceRenderPriorities[this.indicesCount] = var8.faceRenderPriorities[var9];
                        } else {
                            this.faceRenderPriorities[this.indicesCount] = var8.field1918;
                        }
                    }

                    if (var4 && var8.faceAlphas != null) {
                        this.faceAlphas[this.indicesCount] = var8.faceAlphas[var9];
                    }

                    if (var5) {
                        if (var8.faceTextures != null) {
                            this.faceTextures[this.indicesCount] = var8.faceTextures[var9];
                        } else {
                            this.faceTextures[this.indicesCount] = -1;
                        }
                    }

                    if (var6) {
                        if (var8.field1879 != null && var8.field1879[var9] != -1) {
                            this.field1879[this.indicesCount] = (byte) (this.field1914 + var8.field1879[var9]);
                        } else {
                            this.field1879[this.indicesCount] = -1;
                        }
                    }

                    ++this.indicesCount;
                }

                for (var9 = 0; var9 < var8.field1914; ++var9) {
                    this.field1892[this.field1914] = this.verticesCount + var8.field1892[var9];
                    this.field1884[this.field1914] = this.verticesCount + var8.field1884[var9];
                    this.field1885[this.field1914] = this.verticesCount + var8.field1885[var9];
                    ++this.field1914;
                }

                for (var9 = 0; var9 < var8.verticesCount; ++var9) {
                    this.verticesX[this.verticesCount] = var8.verticesX[var9];
                    this.verticesY[this.verticesCount] = var8.verticesY[var9];
                    this.verticesZ[this.verticesCount] = var8.verticesZ[var9];
                    ++this.verticesCount;
                }
            }
        }

    }

    @ObfuscatedName("i")
    @Export("method2423")
    @ObfuscatedSignature(
            descriptor = "([[IIIIZI)Lclass111;"
    )
    public Model method2423(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
        this.method2427();
        int var7 = var2 - this.xzRadius;
        int var8 = var2 + this.xzRadius;
        int var9 = var4 - this.xzRadius;
        int var10 = var4 + this.xzRadius;
        if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
            var7 >>= 7;
            var8 = var8 + 127 >> 7;
            var9 >>= 7;
            var10 = var10 + 127 >> 7;
            if (var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
                return this;
            } else {
                Model var11;
                if (var5) {
                    var11 = new Model();
                    var11.verticesCount = this.verticesCount;
                    var11.indicesCount = this.indicesCount;
                    var11.field1914 = this.field1914;
                    var11.verticesX = this.verticesX;
                    var11.verticesZ = this.verticesZ;
                    var11.indices1 = this.indices1;
                    var11.indices2 = this.indices2;
                    var11.indices3 = this.indices3;
                    var11.faceColors1 = this.faceColors1;
                    var11.faceColors2 = this.faceColors2;
                    var11.faceColors3 = this.faceColors3;
                    var11.faceRenderPriorities = this.faceRenderPriorities;
                    var11.faceAlphas = this.faceAlphas;
                    var11.field1879 = this.field1879;
                    var11.faceTextures = this.faceTextures;
                    var11.field1918 = this.field1918;
                    var11.field1892 = this.field1892;
                    var11.field1884 = this.field1884;
                    var11.field1885 = this.field1885;
                    var11.vertexLabels = this.vertexLabels;
                    var11.faceLabelsAlpha = this.faceLabelsAlpha;
                    var11.isSingleTile = this.isSingleTile;
                    var11.verticesY = new int[var11.verticesCount];
                } else {
                    var11 = this;
                }

                int var12;
                int var13;
                int var14;
                int var15;
                int var16;
                int var17;
                int var18;
                int var19;
                int var20;
                int var21;
                if (var6 == 0) {
                    for (var12 = 0; var12 < var11.verticesCount; ++var12) {
                        var13 = var2 + this.verticesX[var12];
                        var14 = var4 + this.verticesZ[var12];
                        var15 = var13 & 127;
                        var16 = var14 & 127;
                        var17 = var13 >> 7;
                        var18 = var14 >> 7;
                        var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                        var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                        var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                        var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
                    }
                } else {
                    for (var12 = 0; var12 < var11.verticesCount; ++var12) {
                        var13 = (-this.verticesY[var12] << 16) / super.height;
                        if (var13 < var6) {
                            var14 = var2 + this.verticesX[var12];
                            var15 = var4 + this.verticesZ[var12];
                            var16 = var14 & 127;
                            var17 = var15 & 127;
                            var18 = var14 >> 7;
                            var19 = var15 >> 7;
                            var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                            var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                            int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                            var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                        }
                    }
                }

                var11.boundsType = 0;
                return var11;
            }
        } else {
            return this;
        }
    }

    @ObfuscatedName("f")
    @Export("method2424")
    @ObfuscatedSignature(
            descriptor = "(Z)Lclass111;"
    )
    public Model method2424(boolean var1) {
        if (!var1 && Model_sharedSequenceModelFaceAlphas.length < this.indicesCount) {
            Model_sharedSequenceModelFaceAlphas = new byte[this.indicesCount + 100];
        }

        return this.method2426(var1, Model_sharedSequenceModel, Model_sharedSequenceModelFaceAlphas);
    }

    @ObfuscatedName("e")
    @Export("method2495")
    @ObfuscatedSignature(
            descriptor = "(Z)Lclass111;"
    )
    public Model method2495(boolean var1) {
        if (!var1 && Model_sharedSpotAnimationModelFaceAlphas.length < this.indicesCount) {
            Model_sharedSpotAnimationModelFaceAlphas = new byte[this.indicesCount + 100];
        }

        return this.method2426(var1, Model_sharedSpotAnimationModel, Model_sharedSpotAnimationModelFaceAlphas);
    }

    @ObfuscatedName("t")
    @Export("method2426")
    @ObfuscatedSignature(
            descriptor = "(ZLclass111;[B)Lclass111;"
    )
    Model method2426(boolean var1, Model var2, byte[] var3) {
        var2.verticesCount = this.verticesCount;
        var2.indicesCount = this.indicesCount;
        var2.field1914 = this.field1914;
        if (var2.verticesX == null || var2.verticesX.length < this.verticesCount) {
            var2.verticesX = new int[this.verticesCount + 100];
            var2.verticesY = new int[this.verticesCount + 100];
            var2.verticesZ = new int[this.verticesCount + 100];
        }

        int var4;
        for (var4 = 0; var4 < this.verticesCount; ++var4) {
            var2.verticesX[var4] = this.verticesX[var4];
            var2.verticesY[var4] = this.verticesY[var4];
            var2.verticesZ[var4] = this.verticesZ[var4];
        }

        if (var1) {
            var2.faceAlphas = this.faceAlphas;
        } else {
            var2.faceAlphas = var3;
            if (this.faceAlphas == null) {
                for (var4 = 0; var4 < this.indicesCount; ++var4) {
                    var2.faceAlphas[var4] = 0;
                }
            } else {
                for (var4 = 0; var4 < this.indicesCount; ++var4) {
                    var2.faceAlphas[var4] = this.faceAlphas[var4];
                }
            }
        }

        var2.indices1 = this.indices1;
        var2.indices2 = this.indices2;
        var2.indices3 = this.indices3;
        var2.faceColors1 = this.faceColors1;
        var2.faceColors2 = this.faceColors2;
        var2.faceColors3 = this.faceColors3;
        var2.faceRenderPriorities = this.faceRenderPriorities;
        var2.field1879 = this.field1879;
        var2.faceTextures = this.faceTextures;
        var2.field1918 = this.field1918;
        var2.field1892 = this.field1892;
        var2.field1884 = this.field1884;
        var2.field1885 = this.field1885;
        var2.vertexLabels = this.vertexLabels;
        var2.faceLabelsAlpha = this.faceLabelsAlpha;
        var2.isSingleTile = this.isSingleTile;
        var2.boundsType = 0;
        return var2;
    }

    @ObfuscatedName("d")
    @Export("method2427")
    public void method2427() {
        if (this.boundsType != 1) {
            this.boundsType = 1;
            super.height = 0;
            this.bottomY = 0;
            this.xzRadius = 0;

            for (int var1 = 0; var1 < this.verticesCount; ++var1) {
                int var2 = this.verticesX[var1];
                int var3 = this.verticesY[var1];
                int var4 = this.verticesZ[var1];
                if (-var3 > super.height) {
                    super.height = -var3;
                }

                if (var3 > this.bottomY) {
                    this.bottomY = var3;
                }

                int var5 = var2 * var2 + var4 * var4;
                if (var5 > this.xzRadius) {
                    this.xzRadius = var5;
                }
            }

            this.xzRadius = (int) (Math.sqrt(this.xzRadius) + 0.99D);
            this.radius = (int) (Math.sqrt(this.xzRadius * this.xzRadius + super.height * super.height) + 0.99D);
            this.diameter = this.radius + (int) (Math.sqrt(this.xzRadius * this.xzRadius + this.bottomY * this.bottomY) + 0.99D);
        }
    }

    @ObfuscatedName("l")
    void method2428() {
        if (this.boundsType != 2) {
            this.boundsType = 2;
            this.xzRadius = 0;

            for (int var1 = 0; var1 < this.verticesCount; ++var1) {
                int var2 = this.verticesX[var1];
                int var3 = this.verticesY[var1];
                int var4 = this.verticesZ[var1];
                int var5 = var2 * var2 + var4 * var4 + var3 * var3;
                if (var5 > this.xzRadius) {
                    this.xzRadius = var5;
                }
            }

            this.xzRadius = (int) (Math.sqrt(this.xzRadius) + 0.99D);
            this.radius = this.xzRadius;
            this.diameter = this.xzRadius + this.xzRadius;
        }
    }

    @ObfuscatedName("a")
    public int method2474() {
        this.method2427();
        return this.xzRadius;
    }

    @ObfuscatedName("z")
    @Export("method2430")
    @ObfuscatedSignature(
            descriptor = "(Lclass108;I)V"
    )
    public void method2430(Frames var1, int var2) {
        if (this.vertexLabels != null) {
            if (var2 != -1) {
                Animation var3 = var1.frames[var2];
                Skeleton var4 = var3.skeleton;
                Model_transformTempX = 0;
                Model_transformTempY = 0;
                Model_transformTempZ = 0;

                for (int var5 = 0; var5 < var3.transformCount; ++var5) {
                    int var6 = var3.transformSkeletonLabels[var5];
                    this.method2425(var4.transformTypes[var6], var4.labels[var6], var3.transformXs[var5], var3.transformYs[var5], var3.transformZs[var5]);
                }

                this.boundsType = 0;
            }
        }
    }

    @ObfuscatedName("s")
    @Export("method2431")
    @ObfuscatedSignature(
            descriptor = "(Lclass108;ILclass108;I[I)V"
    )
    public void method2431(Frames var1, int var2, Frames var3, int var4, int[] var5) {
        if (var2 != -1) {
            if (var5 != null && var4 != -1) {
                Animation var6 = var1.frames[var2];
                Animation var7 = var3.frames[var4];
                Skeleton var8 = var6.skeleton;
                Model_transformTempX = 0;
                Model_transformTempY = 0;
                Model_transformTempZ = 0;
                byte var9 = 0;
                int var13 = var9 + 1;
                int var10 = var5[var9];

                int var11;
                int var12;
                for (var11 = 0; var11 < var6.transformCount; ++var11) {
                    for (var12 = var6.transformSkeletonLabels[var11]; var12 > var10; var10 = var5[var13++]) {
                    }

                    if (var12 != var10 || var8.transformTypes[var12] == 0) {
                        this.method2425(var8.transformTypes[var12], var8.labels[var12], var6.transformXs[var11], var6.transformYs[var11], var6.transformZs[var11]);
                    }
                }

                Model_transformTempX = 0;
                Model_transformTempY = 0;
                Model_transformTempZ = 0;
                var9 = 0;
                var13 = var9 + 1;
                var10 = var5[var9];

                for (var11 = 0; var11 < var7.transformCount; ++var11) {
                    for (var12 = var7.transformSkeletonLabels[var11]; var12 > var10; var10 = var5[var13++]) {
                    }

                    if (var12 == var10 || var8.transformTypes[var12] == 0) {
                        this.method2425(var8.transformTypes[var12], var8.labels[var12], var7.transformXs[var11], var7.transformYs[var11], var7.transformZs[var11]);
                    }
                }

                this.boundsType = 0;
            } else {
                this.method2430(var1, var2);
            }
        }
    }

    @ObfuscatedName("m")
    @Export("method2425")
    void method2425(int var1, int[] var2, int var3, int var4, int var5) {
        int var6 = var2.length;
        int var7;
        int var8;
        int var11;
        int var12;
        if (var1 == 0) {
            var7 = 0;
            Model_transformTempX = 0;
            Model_transformTempY = 0;
            Model_transformTempZ = 0;

            for (var8 = 0; var8 < var6; ++var8) {
                int var18 = var2[var8];
                if (var18 < this.vertexLabels.length) {
                    int[] var19 = this.vertexLabels[var18];

                    for (var11 = 0; var11 < var19.length; ++var11) {
                        var12 = var19[var11];
                        Model_transformTempX += this.verticesX[var12];
                        Model_transformTempY += this.verticesY[var12];
                        Model_transformTempZ += this.verticesZ[var12];
                        ++var7;
                    }
                }
            }

            if (var7 > 0) {
                Model_transformTempX = var3 + Model_transformTempX / var7;
                Model_transformTempY = var4 + Model_transformTempY / var7;
                Model_transformTempZ = var5 + Model_transformTempZ / var7;
            } else {
                Model_transformTempX = var3;
                Model_transformTempY = var4;
                Model_transformTempZ = var5;
            }

        } else {
            int[] var9;
            int var10;
            if (var1 == 1) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexLabels.length) {
                        var9 = this.vertexLabels[var8];

                        for (var10 = 0; var10 < var9.length; ++var10) {
                            var11 = var9[var10];
                            this.verticesX[var11] += var3;
                            this.verticesY[var11] += var4;
                            this.verticesZ[var11] += var5;
                        }
                    }
                }

            } else if (var1 == 2) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexLabels.length) {
                        var9 = this.vertexLabels[var8];

                        for (var10 = 0; var10 < var9.length; ++var10) {
                            var11 = var9[var10];
                            this.verticesX[var11] -= Model_transformTempX;
                            this.verticesY[var11] -= Model_transformTempY;
                            this.verticesZ[var11] -= Model_transformTempZ;
                            var12 = (var3 & 255) * 8;
                            int var13 = (var4 & 255) * 8;
                            int var14 = (var5 & 255) * 8;
                            int var15;
                            int var16;
                            int var17;
                            if (var14 != 0) {
                                var15 = field1866[var14];
                                var16 = field1897[var14];
                                var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                                this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                                this.verticesX[var11] = var17;
                            }

                            if (var12 != 0) {
                                var15 = field1866[var12];
                                var16 = field1897[var12];
                                var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                                this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                                this.verticesY[var11] = var17;
                            }

                            if (var13 != 0) {
                                var15 = field1866[var13];
                                var16 = field1897[var13];
                                var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                                this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                                this.verticesX[var11] = var17;
                            }

                            this.verticesX[var11] += Model_transformTempX;
                            this.verticesY[var11] += Model_transformTempY;
                            this.verticesZ[var11] += Model_transformTempZ;
                        }
                    }
                }

            } else if (var1 == 3) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = var2[var7];
                    if (var8 < this.vertexLabels.length) {
                        var9 = this.vertexLabels[var8];

                        for (var10 = 0; var10 < var9.length; ++var10) {
                            var11 = var9[var10];
                            this.verticesX[var11] -= Model_transformTempX;
                            this.verticesY[var11] -= Model_transformTempY;
                            this.verticesZ[var11] -= Model_transformTempZ;
                            this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                            this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                            this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                            this.verticesX[var11] += Model_transformTempX;
                            this.verticesY[var11] += Model_transformTempY;
                            this.verticesZ[var11] += Model_transformTempZ;
                        }
                    }
                }

            } else if (var1 == 5) {
                if (this.faceLabelsAlpha != null && this.faceAlphas != null) {
                    for (var7 = 0; var7 < var6; ++var7) {
                        var8 = var2[var7];
                        if (var8 < this.faceLabelsAlpha.length) {
                            var9 = this.faceLabelsAlpha[var8];

                            for (var10 = 0; var10 < var9.length; ++var10) {
                                var11 = var9[var10];
                                var12 = (this.faceAlphas[var11] & 255) + var3 * 8;
                                if (var12 < 0) {
                                    var12 = 0;
                                } else if (var12 > 255) {
                                    var12 = 255;
                                }

                                this.faceAlphas[var11] = (byte) var12;
                            }
                        }
                    }
                }

            }
        }
    }

    @ObfuscatedName("u")
    @Export("method2488")
    public void method2488() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            this.verticesX[var1] = this.verticesZ[var1];
            this.verticesZ[var1] = -var2;
        }

        this.boundsType = 0;
    }

    @ObfuscatedName("g")
    public void method2444() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            this.verticesX[var1] = -this.verticesX[var1];
            this.verticesZ[var1] = -this.verticesZ[var1];
        }

        this.boundsType = 0;
    }

    @ObfuscatedName("o")
    public void method2435() {
        for (int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesZ[var1];
            this.verticesZ[var1] = this.verticesX[var1];
            this.verticesX[var1] = -var2;
        }

        this.boundsType = 0;
    }

    @ObfuscatedName("v")
    @Export("method2436")
    public void method2436(int var1) {
        int var2 = field1866[var1];
        int var3 = field1897[var1];

        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
            this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
            this.verticesY[var4] = var5;
        }

        this.boundsType = 0;
    }

    @ObfuscatedName("j")
    @Export("method2451")
    public void method2451(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            this.verticesX[var4] += var1;
            this.verticesY[var4] += var2;
            this.verticesZ[var4] += var3;
        }

        this.boundsType = 0;
    }

    @ObfuscatedName("n")
    @Export("method2438")
    public void method2438(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.verticesCount; ++var4) {
            this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
            this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
            this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
        }

        this.boundsType = 0;
    }

    @ObfuscatedName("q")
    public final void method2439(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        field1904[0] = -1;
        if (this.boundsType != 2 && this.boundsType != 1) {
            this.method2428();
        }

        int var8 = Rasterizer3D.Rasterizer3D_clipMidX;
        int var9 = Rasterizer3D.Rasterizer3D_clipMidY;
        int var10 = field1866[var1];
        int var11 = field1897[var1];
        int var12 = field1866[var2];
        int var13 = field1897[var2];
        int var14 = field1866[var3];
        int var15 = field1897[var3];
        int var16 = field1866[var4];
        int var17 = field1897[var4];
        int var18 = var16 * var6 + var17 * var7 >> 16;

        for (int var19 = 0; var19 < this.verticesCount; ++var19) {
            int var20 = this.verticesX[var19];
            int var21 = this.verticesY[var19];
            int var22 = this.verticesZ[var19];
            int var23;
            if (var3 != 0) {
                var23 = var21 * var14 + var20 * var15 >> 16;
                var21 = var21 * var15 - var20 * var14 >> 16;
                var20 = var23;
            }

            if (var1 != 0) {
                var23 = var21 * var11 - var22 * var10 >> 16;
                var22 = var21 * var10 + var22 * var11 >> 16;
                var21 = var23;
            }

            if (var2 != 0) {
                var23 = var22 * var12 + var20 * var13 >> 16;
                var22 = var22 * var13 - var20 * var12 >> 16;
                var20 = var23;
            }

            var20 += var5;
            var21 += var6;
            var22 += var7;
            var23 = var21 * var17 - var22 * var16 >> 16;
            var22 = var21 * var16 + var22 * var17 >> 16;
            field1923[var19] = var22 - var18;
            modelViewportXs[var19] = var8 + (var20 << 9) / var22;
            modelViewportYs[var19] = var9 + (var23 << 9) / var22;
            if (this.field1914 > 0) {
                field1900[var19] = var20;
                field1901[var19] = var23;
                field1902[var19] = var22;
            }
        }

        try {
            this.method2482(false, false, 0);
        } catch (Exception var25) {
        }

    }

    @ObfuscatedName("c")
    public final void method2440(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        field1904[0] = -1;
        if (this.boundsType != 2 && this.boundsType != 1) {
            this.method2428();
        }

        int var9 = Rasterizer3D.Rasterizer3D_clipMidX;
        int var10 = Rasterizer3D.Rasterizer3D_clipMidY;
        int var11 = field1866[var1];
        int var12 = field1897[var1];
        int var13 = field1866[var2];
        int var14 = field1897[var2];
        int var15 = field1866[var3];
        int var16 = field1897[var3];
        int var17 = field1866[var4];
        int var18 = field1897[var4];
        int var19 = var17 * var6 + var18 * var7 >> 16;

        for (int var20 = 0; var20 < this.verticesCount; ++var20) {
            int var21 = this.verticesX[var20];
            int var22 = this.verticesY[var20];
            int var23 = this.verticesZ[var20];
            int var24;
            if (var3 != 0) {
                var24 = var22 * var15 + var21 * var16 >> 16;
                var22 = var22 * var16 - var21 * var15 >> 16;
                var21 = var24;
            }

            if (var1 != 0) {
                var24 = var22 * var12 - var23 * var11 >> 16;
                var23 = var22 * var11 + var23 * var12 >> 16;
                var22 = var24;
            }

            if (var2 != 0) {
                var24 = var23 * var13 + var21 * var14 >> 16;
                var23 = var23 * var14 - var21 * var13 >> 16;
                var21 = var24;
            }

            var21 += var5;
            var22 += var6;
            var23 += var7;
            var24 = var22 * var18 - var23 * var17 >> 16;
            var23 = var22 * var17 + var23 * var18 >> 16;
            field1923[var20] = var23 - var19;
            modelViewportXs[var20] = var9 + (var21 << 9) / var8;
            modelViewportYs[var20] = var10 + (var24 << 9) / var8;
            if (this.field1914 > 0) {
                field1900[var20] = var21;
                field1901[var20] = var24;
                field1902[var20] = var23;
            }
        }

        try {
            this.method2482(false, false, 0);
        } catch (Exception var26) {
        }

    }

    @ObfuscatedName("h")
    final void method2482(boolean var1, boolean var2, int var3) {
        if (this.diameter < 1600) {
            int var4;
            for (var4 = 0; var4 < this.diameter; ++var4) {
                field1904[var4] = 0;
            }

            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var12;
            int var13;
            int var15;
            int var25;
            for (var4 = 0; var4 < this.indicesCount; ++var4) {
                if (this.faceColors3[var4] != -2) {
                    var5 = this.indices1[var4];
                    var6 = this.indices2[var4];
                    var7 = this.indices3[var4];
                    var8 = modelViewportXs[var5];
                    var9 = modelViewportXs[var6];
                    var25 = modelViewportXs[var7];
                    int var26;
                    if (var1 && (var8 == -5000 || var9 == -5000 || var25 == -5000)) {
                        var26 = field1900[var5];
                        var12 = field1900[var6];
                        var13 = field1900[var7];
                        int var27 = field1901[var5];
                        var15 = field1901[var6];
                        int var16 = field1901[var7];
                        int var17 = field1902[var5];
                        int var18 = field1902[var6];
                        int var19 = field1902[var7];
                        var26 -= var12;
                        var13 -= var12;
                        var27 -= var15;
                        var16 -= var15;
                        var17 -= var18;
                        var19 -= var18;
                        int var20 = var27 * var19 - var17 * var16;
                        int var21 = var17 * var13 - var26 * var19;
                        int var22 = var26 * var16 - var27 * var13;
                        if (var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                            field1882[var4] = true;
                            int var23 = (field1923[var5] + field1923[var6] + field1923[var7]) / 3 + this.radius;
                            field1905[var23][field1904[var23]++] = var4;
                        }
                    } else {
                        if (var2 && this.method2487(field1877, field1919, modelViewportYs[var5], modelViewportYs[var6], modelViewportYs[var7], var8, var9, var25)) {
                            field1921[field1920++] = var3;
                            var2 = false;
                        }

                        if ((var8 - var9) * (modelViewportYs[var7] - modelViewportYs[var6]) - (var25 - var9) * (modelViewportYs[var5] - modelViewportYs[var6]) > 0) {
                            field1882[var4] = false;
                            field1896[var4] = var8 < 0 || var9 < 0 || var25 < 0 || var8 > Rasterizer3D.Rasterizer3D_clipWidth || var9 > Rasterizer3D.Rasterizer3D_clipWidth || var25 > Rasterizer3D.Rasterizer3D_clipWidth;

                            var26 = (field1923[var5] + field1923[var6] + field1923[var7]) / 3 + this.radius;
                            field1905[var26][field1904[var26]++] = var4;
                        }
                    }
                }
            }

            int[] var24;
            if (this.faceRenderPriorities == null) {
                for (var4 = this.diameter - 1; var4 >= 0; --var4) {
                    var5 = field1904[var4];
                    if (var5 > 0) {
                        var24 = field1905[var4];

                        for (var7 = 0; var7 < var5; ++var7) {
                            this.method2472(var24[var7]);
                        }
                    }
                }

            } else {
                for (var4 = 0; var4 < 12; ++var4) {
                    field1906[var4] = 0;
                    field1910[var4] = 0;
                }

                for (var4 = this.diameter - 1; var4 >= 0; --var4) {
                    var5 = field1904[var4];
                    if (var5 > 0) {
                        var24 = field1905[var4];

                        for (var7 = 0; var7 < var5; ++var7) {
                            var8 = var24[var7];
                            byte var28 = this.faceRenderPriorities[var8];
                            var25 = field1906[var28]++;
                            field1907[var28][var25] = var8;
                            if (var28 < 10) {
                                field1910[var28] += var4;
                            } else if (var28 == 10) {
                                field1916[var25] = var4;
                            } else {
                                field1909[var25] = var4;
                            }
                        }
                    }
                }

                var4 = 0;
                if (field1906[1] > 0 || field1906[2] > 0) {
                    var4 = (field1910[1] + field1910[2]) / (field1906[1] + field1906[2]);
                }

                var5 = 0;
                if (field1906[3] > 0 || field1906[4] > 0) {
                    var5 = (field1910[3] + field1910[4]) / (field1906[3] + field1906[4]);
                }

                var6 = 0;
                if (field1906[6] > 0 || field1906[8] > 0) {
                    var6 = (field1910[8] + field1910[6]) / (field1906[8] + field1906[6]);
                }

                var8 = 0;
                var9 = field1906[10];
                int[] var10 = field1907[10];
                int[] var11 = field1916;
                if (var8 == var9) {
                    var8 = 0;
                    var9 = field1906[11];
                    var10 = field1907[11];
                    var11 = field1909;
                }

                if (var8 < var9) {
                    var7 = var11[var8];
                } else {
                    var7 = -1000;
                }

                for (var12 = 0; var12 < 10; ++var12) {
                    while (var12 == 0 && var7 > var4) {
                        this.method2472(var10[var8++]);
                        if (var8 == var9 && var10 != field1907[11]) {
                            var8 = 0;
                            var9 = field1906[11];
                            var10 = field1907[11];
                            var11 = field1909;
                        }

                        if (var8 < var9) {
                            var7 = var11[var8];
                        } else {
                            var7 = -1000;
                        }
                    }

                    while (var12 == 3 && var7 > var5) {
                        this.method2472(var10[var8++]);
                        if (var8 == var9 && var10 != field1907[11]) {
                            var8 = 0;
                            var9 = field1906[11];
                            var10 = field1907[11];
                            var11 = field1909;
                        }

                        if (var8 < var9) {
                            var7 = var11[var8];
                        } else {
                            var7 = -1000;
                        }
                    }

                    while (var12 == 5 && var7 > var6) {
                        this.method2472(var10[var8++]);
                        if (var8 == var9 && var10 != field1907[11]) {
                            var8 = 0;
                            var9 = field1906[11];
                            var10 = field1907[11];
                            var11 = field1909;
                        }

                        if (var8 < var9) {
                            var7 = var11[var8];
                        } else {
                            var7 = -1000;
                        }
                    }

                    var13 = field1906[var12];
                    int[] var14 = field1907[var12];

                    for (var15 = 0; var15 < var13; ++var15) {
                        this.method2472(var14[var15]);
                    }
                }

                while (var7 != -1000) {
                    this.method2472(var10[var8++]);
                    if (var8 == var9 && var10 != field1907[11]) {
                        var8 = 0;
                        var10 = field1907[11];
                        var9 = field1906[11];
                        var11 = field1909;
                    }

                    if (var8 < var9) {
                        var7 = var11[var8];
                    } else {
                        var7 = -1000;
                    }
                }

            }
        }
    }

    @ObfuscatedName("b")
    @Export("method2472")
    final void method2472(int var1) {
        if (field1882[var1]) {
            this.method2433(var1);
        } else {
            int var2 = this.indices1[var1];
            int var3 = this.indices2[var1];
            int var4 = this.indices3[var1];
            Rasterizer3D.field1777 = field1896[var1];
            if (this.faceAlphas == null) {
                Rasterizer3D.Rasterizer3D_alpha = 0;
            } else {
                Rasterizer3D.Rasterizer3D_alpha = this.faceAlphas[var1] & 255;
            }

            if (this.faceTextures != null && this.faceTextures[var1] != -1) {
                int var5;
                int var6;
                int var7;
                if (this.field1879 != null && this.field1879[var1] != -1) {
                    int var8 = this.field1879[var1] & 255;
                    var5 = this.field1892[var8];
                    var6 = this.field1884[var8];
                    var7 = this.field1885[var8];
                } else {
                    var5 = var2;
                    var6 = var3;
                    var7 = var4;
                }

                if (this.faceColors3[var1] == -1) {
                    Rasterizer3D.method2355(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field1900[var5], field1900[var6], field1900[var7], field1901[var5], field1901[var6], field1901[var7], field1902[var5], field1902[var6], field1902[var7], this.faceTextures[var1]);
                } else {
                    Rasterizer3D.method2355(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1], field1900[var5], field1900[var6], field1900[var7], field1901[var5], field1901[var6], field1901[var7], field1902[var5], field1902[var6], field1902[var7], this.faceTextures[var1]);
                }
            } else if (this.faceColors3[var1] == -1) {
                Rasterizer3D.method2313(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], field1924[this.faceColors1[var1]]);
            } else {
                Rasterizer3D.method2311(modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], this.faceColors1[var1], this.faceColors2[var1], this.faceColors3[var1]);
            }

        }
    }

    @ObfuscatedName("y")
    final void method2433(int var1) {
        int var2 = Rasterizer3D.Rasterizer3D_clipMidX;
        int var3 = Rasterizer3D.Rasterizer3D_clipMidY;
        int var4 = 0;
        int var5 = this.indices1[var1];
        int var6 = this.indices2[var1];
        int var7 = this.indices3[var1];
        int var8 = field1902[var5];
        int var9 = field1902[var6];
        int var10 = field1902[var7];
        if (this.faceAlphas == null) {
            Rasterizer3D.Rasterizer3D_alpha = 0;
        } else {
            Rasterizer3D.Rasterizer3D_alpha = this.faceAlphas[var1] & 255;
        }

        int var11;
        int var12;
        int var13;
        int var14;
        if (var8 >= 50) {
            field1911[var4] = modelViewportXs[var5];
            field1912[var4] = modelViewportYs[var5];
            field1895[var4++] = this.faceColors1[var1];
        } else {
            var11 = field1900[var5];
            var12 = field1901[var5];
            var13 = this.faceColors1[var1];
            if (var10 >= 50) {
                var14 = field1925[var10 - var8] * (50 - var8);
                field1911[var4] = var2 + (var11 + ((field1900[var7] - var11) * var14 >> 16) << 9) / 50;
                field1912[var4] = var3 + (var12 + ((field1901[var7] - var12) * var14 >> 16) << 9) / 50;
                field1895[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
            }

            if (var9 >= 50) {
                var14 = field1925[var9 - var8] * (50 - var8);
                field1911[var4] = var2 + (var11 + ((field1900[var6] - var11) * var14 >> 16) << 9) / 50;
                field1912[var4] = var3 + (var12 + ((field1901[var6] - var12) * var14 >> 16) << 9) / 50;
                field1895[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
            }
        }

        if (var9 >= 50) {
            field1911[var4] = modelViewportXs[var6];
            field1912[var4] = modelViewportYs[var6];
            field1895[var4++] = this.faceColors2[var1];
        } else {
            var11 = field1900[var6];
            var12 = field1901[var6];
            var13 = this.faceColors2[var1];
            if (var8 >= 50) {
                var14 = field1925[var8 - var9] * (50 - var9);
                field1911[var4] = var2 + (var11 + ((field1900[var5] - var11) * var14 >> 16) << 9) / 50;
                field1912[var4] = var3 + (var12 + ((field1901[var5] - var12) * var14 >> 16) << 9) / 50;
                field1895[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
            }

            if (var10 >= 50) {
                var14 = field1925[var10 - var9] * (50 - var9);
                field1911[var4] = var2 + (var11 + ((field1900[var7] - var11) * var14 >> 16) << 9) / 50;
                field1912[var4] = var3 + (var12 + ((field1901[var7] - var12) * var14 >> 16) << 9) / 50;
                field1895[var4++] = var13 + ((this.faceColors3[var1] - var13) * var14 >> 16);
            }
        }

        if (var10 >= 50) {
            field1911[var4] = modelViewportXs[var7];
            field1912[var4] = modelViewportYs[var7];
            field1895[var4++] = this.faceColors3[var1];
        } else {
            var11 = field1900[var7];
            var12 = field1901[var7];
            var13 = this.faceColors3[var1];
            if (var9 >= 50) {
                var14 = field1925[var9 - var10] * (50 - var10);
                field1911[var4] = var2 + (var11 + ((field1900[var6] - var11) * var14 >> 16) << 9) / 50;
                field1912[var4] = var3 + (var12 + ((field1901[var6] - var12) * var14 >> 16) << 9) / 50;
                field1895[var4++] = var13 + ((this.faceColors2[var1] - var13) * var14 >> 16);
            }

            if (var8 >= 50) {
                var14 = field1925[var8 - var10] * (50 - var10);
                field1911[var4] = var2 + (var11 + ((field1900[var5] - var11) * var14 >> 16) << 9) / 50;
                field1912[var4] = var3 + (var12 + ((field1901[var5] - var12) * var14 >> 16) << 9) / 50;
                field1895[var4++] = var13 + ((this.faceColors1[var1] - var13) * var14 >> 16);
            }
        }

        var11 = field1911[0];
        var12 = field1911[1];
        var13 = field1911[2];
        var14 = field1912[0];
        int var15 = field1912[1];
        int var16 = field1912[2];
        Rasterizer3D.field1777 = false;
        int var17;
        int var18;
        int var19;
        int var20;
        if (var4 == 3) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Rasterizer3D.Rasterizer3D_clipWidth || var12 > Rasterizer3D.Rasterizer3D_clipWidth || var13 > Rasterizer3D.Rasterizer3D_clipWidth) {
                Rasterizer3D.field1777 = true;
            }

            if (this.faceTextures != null && this.faceTextures[var1] != -1) {
                if (this.field1879 != null && this.field1879[var1] != -1) {
                    var20 = this.field1879[var1] & 255;
                    var17 = this.field1892[var20];
                    var18 = this.field1884[var20];
                    var19 = this.field1885[var20];
                } else {
                    var17 = var5;
                    var18 = var6;
                    var19 = var7;
                }

                if (this.faceColors3[var1] == -1) {
                    Rasterizer3D.method2355(var14, var15, var16, var11, var12, var13, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], field1902[var17], field1902[var18], field1902[var19], this.faceTextures[var1]);
                } else {
                    Rasterizer3D.method2355(var14, var15, var16, var11, var12, var13, field1895[0], field1895[1], field1895[2], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], field1902[var17], field1902[var18], field1902[var19], this.faceTextures[var1]);
                }
            } else if (this.faceColors3[var1] == -1) {
                Rasterizer3D.method2313(var14, var15, var16, var11, var12, var13, field1924[this.faceColors1[var1]]);
            } else {
                Rasterizer3D.method2311(var14, var15, var16, var11, var12, var13, field1895[0], field1895[1], field1895[2]);
            }
        }

        if (var4 == 4) {
            if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > Rasterizer3D.Rasterizer3D_clipWidth || var12 > Rasterizer3D.Rasterizer3D_clipWidth || var13 > Rasterizer3D.Rasterizer3D_clipWidth || field1911[3] < 0 || field1911[3] > Rasterizer3D.Rasterizer3D_clipWidth) {
                Rasterizer3D.field1777 = true;
            }

            if (this.faceTextures != null && this.faceTextures[var1] != -1) {
                if (this.field1879 != null && this.field1879[var1] != -1) {
                    var20 = this.field1879[var1] & 255;
                    var17 = this.field1892[var20];
                    var18 = this.field1884[var20];
                    var19 = this.field1885[var20];
                } else {
                    var17 = var5;
                    var18 = var6;
                    var19 = var7;
                }

                short var21 = this.faceTextures[var1];
                if (this.faceColors3[var1] == -1) {
                    Rasterizer3D.method2355(var14, var15, var16, var11, var12, var13, this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], field1902[var17], field1902[var18], field1902[var19], var21);
                    Rasterizer3D.method2355(var14, var16, field1912[3], var11, var13, field1911[3], this.faceColors1[var1], this.faceColors1[var1], this.faceColors1[var1], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], field1902[var17], field1902[var18], field1902[var19], var21);
                } else {
                    Rasterizer3D.method2355(var14, var15, var16, var11, var12, var13, field1895[0], field1895[1], field1895[2], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], field1902[var17], field1902[var18], field1902[var19], var21);
                    Rasterizer3D.method2355(var14, var16, field1912[3], var11, var13, field1911[3], field1895[0], field1895[2], field1895[3], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], field1902[var17], field1902[var18], field1902[var19], var21);
                }
            } else if (this.faceColors3[var1] == -1) {
                var17 = field1924[this.faceColors1[var1]];
                Rasterizer3D.method2313(var14, var15, var16, var11, var12, var13, var17);
                Rasterizer3D.method2313(var14, var16, field1912[3], var11, var13, field1911[3], var17);
            } else {
                Rasterizer3D.method2311(var14, var15, var16, var11, var12, var13, field1895[0], field1895[1], field1895[2]);
                Rasterizer3D.method2311(var14, var16, field1912[3], var11, var13, field1911[3], field1895[0], field1895[2], field1895[3]);
            }
        }

    }

    @ObfuscatedName("x")
    final boolean method2487(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        if (var2 < var3 && var2 < var4 && var2 < var5) {
            return false;
        } else if (var2 > var3 && var2 > var4 && var2 > var5) {
            return false;
        } else if (var1 < var6 && var1 < var7 && var1 < var8) {
            return false;
        } else {
            return var1 <= var6 || var1 <= var7 || var1 <= var8;
        }
    }

    @ObfuscatedName("ae")
    void vmethod2441(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
        field1904[0] = -1;
        if (this.boundsType != 1) {
            this.method2427();
        }

        int var10 = var5 * var8 - var4 * var6 >> 16;
        int var11 = var2 * var7 + var3 * var10 >> 16;
        int var12 = var3 * this.xzRadius >> 16;
        int var13 = var11 + var12;
        if (var13 > 50 && var11 < 3500) {
            int var14 = var8 * var4 + var5 * var6 >> 16;
            int var15 = var14 - this.xzRadius << 9;
            if (var15 / var13 < Rasterizer3D.Rasterizer3D_clipMidX2) {
                int var16 = var14 + this.xzRadius << 9;
                if (var16 / var13 > Rasterizer3D.Rasterizer3D_clipNegativeMidX) {
                    int var17 = var3 * var7 - var10 * var2 >> 16;
                    int var18 = var2 * this.xzRadius >> 16;
                    int var19 = var17 + var18 << 9;
                    if (var19 / var13 > Rasterizer3D.Rasterizer3D_clipNegativeMidY) {
                        int var20 = (var3 * super.height >> 16) + var18;
                        int var21 = var17 - var20 << 9;
                        if (var21 / var13 < Rasterizer3D.Rasterizer3D_clipMidY2) {
                            int var22 = var12 + (var2 * super.height >> 16);
                            boolean var23 = false;
                            boolean var24 = var11 - var22 <= 50;

                            boolean var25 = var24 || this.field1914 > 0;
                            boolean var26 = false;
                            int var27;
                            int var28;
                            int var29;
                            if (var9 > 0 && field1917) {
                                var27 = var11 - var12;
                                if (var27 <= 50) {
                                    var27 = 50;
                                }

                                if (var14 > 0) {
                                    var15 /= var13;
                                    var16 /= var27;
                                } else {
                                    var16 /= var13;
                                    var15 /= var27;
                                }

                                if (var17 > 0) {
                                    var21 /= var13;
                                    var19 /= var27;
                                } else {
                                    var19 /= var13;
                                    var21 /= var27;
                                }

                                var28 = field1877 - Rasterizer3D.Rasterizer3D_clipMidX;
                                var29 = field1919 - Rasterizer3D.Rasterizer3D_clipMidY;
                                if (var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                                    if (this.isSingleTile) {
                                        field1921[field1920++] = var9;
                                    } else {
                                        var26 = true;
                                    }
                                }
                            }

                            var27 = Rasterizer3D.Rasterizer3D_clipMidX;
                            var28 = Rasterizer3D.Rasterizer3D_clipMidY;
                            var29 = 0;
                            int var30 = 0;
                            if (var1 != 0) {
                                var29 = field1866[var1];
                                var30 = field1897[var1];
                            }

                            for (int var31 = 0; var31 < this.verticesCount; ++var31) {
                                int var32 = this.verticesX[var31];
                                int var33 = this.verticesY[var31];
                                int var34 = this.verticesZ[var31];
                                int var35;
                                if (var1 != 0) {
                                    var35 = var34 * var29 + var32 * var30 >> 16;
                                    var34 = var34 * var30 - var32 * var29 >> 16;
                                    var32 = var35;
                                }

                                var32 += var6;
                                var33 += var7;
                                var34 += var8;
                                var35 = var34 * var4 + var5 * var32 >> 16;
                                var34 = var5 * var34 - var32 * var4 >> 16;
                                var32 = var35;
                                var35 = var3 * var33 - var34 * var2 >> 16;
                                var34 = var33 * var2 + var3 * var34 >> 16;
                                field1923[var31] = var34 - var11;
                                if (var34 >= 50) {
                                    modelViewportXs[var31] = var27 + (var32 << 9) / var34;
                                    modelViewportYs[var31] = var28 + (var35 << 9) / var34;
                                } else {
                                    modelViewportXs[var31] = -5000;
                                    var23 = true;
                                }

                                if (var25) {
                                    field1900[var31] = var32;
                                    field1901[var31] = var35;
                                    field1902[var31] = var34;
                                }
                            }

                            try {
                                this.method2482(var23, var26, var9);
                            } catch (Exception var37) {
                            }

                        }
                    }
                }
            }
        }
    }
}
