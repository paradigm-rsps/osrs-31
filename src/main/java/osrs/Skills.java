package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("Skills")
public class Skills {
    @ObfuscatedName("w")
    @Export("Skills_enabled")
    public static final boolean[] Skills_enabled = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
    @ObfuscatedName("f")
    @Export("Skills_experienceTable")
    public static int[] Skills_experienceTable = new int[99];
    @ObfuscatedName("a")
    @ObfuscatedSignature(
            descriptor = "Lclass157;"
    )
    static Widget field2054;
    @ObfuscatedName("m")
    static int[] field2053;
    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            descriptor = "[Lclass12;"
    )
    static World[] field2058;

    static {
        int var0 = 0;

        for (int var1 = 0; var1 < 99; ++var1) {
            int var2 = var1 + 1;
            int var3 = (int) ((double) var2 + 300.0D * Math.pow(2.0D, (double) var2 / 7.0D));
            var0 += var3;
            Skills_experienceTable[var1] = var0 / 4;
        }

    }
}
