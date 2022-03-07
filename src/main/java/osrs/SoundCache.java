package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("SoundCache")
public class SoundCache {
    @ObfuscatedName("nz")
    static int field1206;
    @ObfuscatedName("i")
    @Export("soundEffectIndex")
    @ObfuscatedSignature(
            descriptor = "Lclass151;"
    )
    AbstractArchive soundEffectIndex;
    @ObfuscatedName("w")
    @Export("musicSampleIndex")
    @ObfuscatedSignature(
            descriptor = "Lclass151;"
    )
    AbstractArchive musicSampleIndex;
    @ObfuscatedName("f")
    @Export("musicSamples")
    @ObfuscatedSignature(
            descriptor = "Lclass174;"
    )
    NodeHashTable musicSamples = new NodeHashTable(256);
    @ObfuscatedName("e")
    @Export("rawSounds")
    @ObfuscatedSignature(
            descriptor = "Lclass174;"
    )
    NodeHashTable rawSounds = new NodeHashTable(256);

    @ObfuscatedSignature(
            descriptor = "(Lclass151;Lclass151;)V"
    )
    public SoundCache(AbstractArchive var1, AbstractArchive var2) {
        this.soundEffectIndex = var1;
        this.musicSampleIndex = var2;
    }

    @ObfuscatedName("i")
    @Export("method1359")
    @ObfuscatedSignature(
            descriptor = "(II[I)Lclass62;"
    )
    RawSound method1359(int var1, int var2, int[] var3) {
        int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
        var4 |= var1 << 16;
        long var5 = var4;
        RawSound var7 = (RawSound) this.rawSounds.method3512(var5);
        if (var7 != null) {
            return var7;
        } else if (var3 != null && var3[0] <= 0) {
            return null;
        } else {
            SoundEffect var8 = SoundEffect.method1352(this.soundEffectIndex, var1, var2);
            if (var8 == null) {
                return null;
            } else {
                var7 = var8.method1343();
                this.rawSounds.method3517(var7, var5);
                if (var3 != null) {
                    var3[0] -= var7.samples.length;
                }

                return var7;
            }
        }
    }

    @ObfuscatedName("w")
    @Export("method1355")
    @ObfuscatedSignature(
            descriptor = "(II[I)Lclass62;"
    )
    RawSound method1355(int var1, int var2, int[] var3) {
        int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
        var4 |= var1 << 16;
        long var5 = (long) var4 ^ 4294967296L;
        RawSound var7 = (RawSound) this.rawSounds.method3512(var5);
        if (var7 != null) {
            return var7;
        } else if (var3 != null && var3[0] <= 0) {
            return null;
        } else {
            VorbisSample var8 = (VorbisSample) this.musicSamples.method3512(var5);
            if (var8 == null) {
                var8 = VorbisSample.method1293(this.musicSampleIndex, var1, var2);
                if (var8 == null) {
                    return null;
                }

                this.musicSamples.method3517(var8, var5);
            }

            var7 = var8.method1286(var3);
            if (var7 == null) {
                return null;
            } else {
                var8.remove();
                this.rawSounds.method3517(var7, var5);
                return var7;
            }
        }
    }

    @ObfuscatedName("f")
    @Export("method1370")
    @ObfuscatedSignature(
            descriptor = "(I[I)Lclass62;"
    )
    public RawSound method1370(int var1, int[] var2) {
        if (this.soundEffectIndex.method3264() == 1) {
            return this.method1359(0, var1, var2);
        } else if (this.soundEffectIndex.method3214(var1) == 1) {
            return this.method1359(var1, 0, var2);
        } else {
            throw new RuntimeException();
        }
    }

    @ObfuscatedName("e")
    @Export("method1358")
    @ObfuscatedSignature(
            descriptor = "(I[I)Lclass62;"
    )
    public RawSound method1358(int var1, int[] var2) {
        if (this.musicSampleIndex.method3264() == 1) {
            return this.method1355(0, var1, var2);
        } else if (this.musicSampleIndex.method3214(var1) == 1) {
            return this.method1355(var1, 0, var2);
        } else {
            throw new RuntimeException();
        }
    }

    @ObfuscatedName("f")
    public static String method1371(CharSequence var0) {
        String var1 = Interpreter.method276(class14.method163(var0));
        if (var1 == null) {
            var1 = "";
        }

        return var1;
    }

    @ObfuscatedName("p")
    public static boolean method1356(int var0) {
        return (var0 >> 31 & 1) != 0;
    }

    @ObfuscatedName("g")
    @Export("method1366")
    @ObfuscatedSignature(
            descriptor = "(IZZZ)Lclass153;"
    )
    static Archive method1366(int var0, boolean var1, boolean var2, boolean var3) {
        ArchiveDisk var4 = null;
        if (JagexCache.JagexCache_dat2File != null) {
            var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, class10.JagexCache_idxFiles[var0], 1000000);
        }

        return new Archive(var4, ObjectSound.masterDisk, var0, var1, var2, var3);
    }
}
