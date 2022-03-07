package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
@Implements("BZip2State")
public final class BZip2State {
    @ObfuscatedName("i")
    final int field1955 = 4096;
    @ObfuscatedName("w")
    final int field1953 = 16;
    @ObfuscatedName("f")
    final int field1948 = 258;
    @ObfuscatedName("e")
    final int field1949 = 6;
    @ObfuscatedName("t")
    final int field1950 = 50;
    @ObfuscatedName("d")
    final int field1961 = 18002;
    @ObfuscatedName("p")
    @Export("inputArray")
    byte[] inputArray;
    @ObfuscatedName("k")
    @Export("nextByte")
    int nextByte = 0;
    @ObfuscatedName("r")
    @Export("nextBit_unused")
    int nextBit_unused;
    @ObfuscatedName("l")
    @Export("outputArray")
    byte[] outputArray;
    @ObfuscatedName("a")
    @Export("next_out")
    int next_out = 0;
    @ObfuscatedName("z")
    @Export("outputLength")
    int outputLength;
    @ObfuscatedName("s")
    int field1970;
    @ObfuscatedName("m")
    @Export("out_char")
    byte out_char;
    @ObfuscatedName("u")
    @Export("su_rNToGo")
    int su_rNToGo;
    @ObfuscatedName("g")
    @Export("bsBuff")
    int bsBuff;
    @ObfuscatedName("o")
    @Export("bsLive")
    int bsLive;
    @ObfuscatedName("v")
    @Export("blockSize100k")
    int blockSize100k;
    @ObfuscatedName("j")
    @Export("originalPointer")
    int originalPointer;
    @ObfuscatedName("n")
    int field1965;
    @ObfuscatedName("q")
    @Export("su_ch2")
    int su_ch2;
    @ObfuscatedName("c")
    @Export("unzftab")
    int[] unzftab = new int[256];
    @ObfuscatedName("h")
    @Export("nblocks_used")
    int nblocks_used;
    @ObfuscatedName("b")
    @Export("cftab")
    int[] cftab = new int[257];
    @ObfuscatedName("x")
    @Export("nInUse")
    int nInUse;
    @ObfuscatedName("ao")
    @Export("inUse")
    boolean[] inUse = new boolean[256];
    @ObfuscatedName("ae")
    @Export("inUse16")
    boolean[] inUse16 = new boolean[16];
    @ObfuscatedName("aa")
    @Export("seqToUnseq")
    byte[] seqToUnseq = new byte[256];
    @ObfuscatedName("ah")
    @Export("ll8")
    byte[] ll8 = new byte[4096];
    @ObfuscatedName("aw")
    @Export("getAndMoveToFrontDecode_yy")
    int[] getAndMoveToFrontDecode_yy = new int[16];
    @ObfuscatedName("an")
    @Export("selector")
    byte[] selector = new byte[18002];
    @ObfuscatedName("av")
    @Export("selectorMtf")
    byte[] selectorMtf = new byte[18002];
    @ObfuscatedName("ak")
    @Export("temp_charArray2d")
    byte[][] temp_charArray2d = new byte[6][258];
    @ObfuscatedName("ax")
    @Export("limit")
    int[][] limit = new int[6][258];
    @ObfuscatedName("ab")
    @Export("base")
    int[][] base = new int[6][258];
    @ObfuscatedName("af")
    @Export("perm")
    int[][] perm = new int[6][258];
    @ObfuscatedName("ai")
    @Export("minLens")
    int[] minLens = new int[6];
    @ObfuscatedName("at")
    int field1983;

    @ObfuscatedName("ab")
    @Export("method2509")
    public static int method2509(String var0) {
        return var0.length() + 2;
    }
}
