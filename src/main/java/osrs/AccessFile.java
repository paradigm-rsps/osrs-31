package osrs;

import java.awt.*;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class AccessFile {
    static int field757;
    static Font field762;
    RandomAccessFile file;
    long maxSize;
    long offset;

    public AccessFile(File var1, String var2, long var3) throws IOException {
        if (-1L == var3) {
            var3 = Long.MAX_VALUE;
        }

        if (var1.length() >= var3) {
            var1.delete();
        }

        this.file = new RandomAccessFile(var1, var2);
        this.maxSize = var3;
        this.offset = 0L;
        int var5 = this.file.read();
        if (var5 != -1 && !var2.equals("r")) {
            this.file.seek(0L);
            this.file.write(var5);
        }

        this.file.seek(0L);
    }

    final void method575(long var1) throws IOException {
        this.file.seek(var1);
        this.offset = var1;
    }

    public final void method574(byte[] var1, int var2, int var3) throws IOException {
        if (this.offset + (long) var3 > this.maxSize) {
            this.file.seek(1L + this.maxSize);
            this.file.write(1);
            throw new EOFException();
        } else {
            this.file.write(var1, var2, var3);
            this.offset += var3;
        }
    }

    public final void method586() throws IOException {
        if (this.file != null) {
            this.file.close();
            this.file = null;
        }

    }

    public final long method578() throws IOException {
        return this.file.length();
    }

    public final int method584(byte[] var1, int var2, int var3) throws IOException {
        int var4 = this.file.read(var1, var2, var3);
        if (var4 > 0) {
            this.offset += var4;
        }

        return var4;
    }

    protected void finalize() throws Throwable {
        if (this.file != null) {
            System.out.println();
            this.method586();
        }

    }

    public static void method576(AbstractArchive var0, AbstractArchive var1) {
        SpotAnimationDefinition.SpotAnimationDefinition_archive = var0;
        SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var1;
    }

    static void method573(int var0, int var1) {
        int[] var2 = new int[4];
        int[] var3 = new int[4];
        var2[0] = var0;
        var3[0] = var1;
        int var4 = 1;

        for (int var5 = 0; var5 < 4; ++var5) {
            if (Login.World_sortOption1[var5] != var0) {
                var2[var4] = Login.World_sortOption1[var5];
                var3[var4] = Login.World_sortOption2[var5];
                ++var4;
            }
        }

        Login.World_sortOption1 = var2;
        Login.World_sortOption2 = var3;
        JagexCache.method1720(Skills.field2058, 0, Skills.field2058.length - 1, Login.World_sortOption1, Login.World_sortOption2);
    }

    public static final PcmPlayer method577(TaskHandler var0, Component var1, int var2, int var3) {
        if (PcmPlayer.field1099 == 0) {
            throw new IllegalStateException();
        } else if (var2 >= 0 && var2 < 2) {
            if (var3 < 256) {
                var3 = 256;
            }

            try {
                DevicePcmPlayer var7 = new DevicePcmPlayer();
                var7.samples = new int[256 * (PcmPlayer.PcmPlayer_stereo ? 2 : 1)];
                var7.field1105 = var3;
                var7.vmethod1234(var1);
                var7.capacity = (var3 & -1024) + 1024;
                if (var7.capacity > 16384) {
                    var7.capacity = 16384;
                }

                var7.vmethod1235(var7.capacity);
                if (Frames.field1825 > 0 && TileItem.soundSystem == null) {
                    TileItem.soundSystem = new SoundSystem();
                    TileItem.soundSystem.field1181 = var0;
                    var0.method1599(TileItem.soundSystem, Frames.field1825);
                }

                if (TileItem.soundSystem != null) {
                    if (TileItem.soundSystem.players[var2] != null) {
                        throw new IllegalArgumentException();
                    }

                    TileItem.soundSystem.players[var2] = var7;
                }

                return var7;
            } catch (Throwable var6) {
                try {
                    class43 var4 = new class43(var0, var2);
                    var4.samples = new int[(PcmPlayer.PcmPlayer_stereo ? 2 : 1) * 256];
                    var4.field1105 = var3;
                    var4.vmethod1234(var1);
                    var4.capacity = 16384;
                    var4.vmethod1235(var4.capacity);
                    if (Frames.field1825 > 0 && TileItem.soundSystem == null) {
                        TileItem.soundSystem = new SoundSystem();
                        TileItem.soundSystem.field1181 = var0;
                        var0.method1599(TileItem.soundSystem, Frames.field1825);
                    }

                    if (TileItem.soundSystem != null) {
                        if (TileItem.soundSystem.players[var2] != null) {
                            throw new IllegalArgumentException();
                        }

                        TileItem.soundSystem.players[var2] = var4;
                    }

                    return var4;
                } catch (Throwable var5) {
                    return new PcmPlayer();
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
