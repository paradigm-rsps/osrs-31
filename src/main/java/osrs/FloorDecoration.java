package osrs;

public final class FloorDecoration {
    static int musicTrackFileId;
    static MusicTrack musicTrack;
    int tileHeight;
    int x;
    int y;
    public Renderable renderable;
    public int packedId;
    int flags;

    public static Frames method2382(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
        boolean var4 = true;
        int[] var5 = var0.method3248(var2);

        for (int var6 = 0; var6 < var5.length; ++var6) {
            byte[] var7 = var0.method3210(var2, var5[var6]);
            if (var7 == null) {
                var4 = false;
            } else {
                int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
                byte[] var9;
                if (var3) {
                    var9 = var1.method3210(0, var8);
                } else {
                    var9 = var1.method3210(var8, 0);
                }

                if (var9 == null) {
                    var4 = false;
                }
            }
        }

        if (!var4) {
            return null;
        } else {
            try {
                return new Frames(var0, var1, var2, var3);
            } catch (Exception var11) {
                return null;
            }
        }
    }

    static final void method2381(int var0, int var1, int var2) {
        int var3;
        for (var3 = 0; var3 < 8; ++var3) {
            for (int var4 = 0; var4 < 8; ++var4) {
                Tiles.tileHeights[var0][var3 + var1][var4 + var2] = 0;
            }
        }

        if (var1 > 0) {
            for (var3 = 1; var3 < 8; ++var3) {
                Tiles.tileHeights[var0][var1][var3 + var2] = Tiles.tileHeights[var0][var1 - 1][var3 + var2];
            }
        }

        if (var2 > 0) {
            for (var3 = 1; var3 < 8; ++var3) {
                Tiles.tileHeights[var0][var3 + var1][var2] = Tiles.tileHeights[var0][var3 + var1][var2 - 1];
            }
        }

        if (var1 > 0 && Tiles.tileHeights[var0][var1 - 1][var2] != 0) {
            Tiles.tileHeights[var0][var1][var2] = Tiles.tileHeights[var0][var1 - 1][var2];
        } else if (var2 > 0 && Tiles.tileHeights[var0][var1][var2 - 1] != 0) {
            Tiles.tileHeights[var0][var1][var2] = Tiles.tileHeights[var0][var1][var2 - 1];
        } else if (var1 > 0 && var2 > 0 && Tiles.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
            Tiles.tileHeights[var0][var1][var2] = Tiles.tileHeights[var0][var1 - 1][var2 - 1];
        }

    }
}
