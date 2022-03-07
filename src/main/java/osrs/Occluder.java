package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("do")
@Implements("Occluder")
public final class Occluder {
    @ObfuscatedName("i")
    @Export("minTileX")
    int minTileX;
    @ObfuscatedName("w")
    @Export("maxTileX")
    int maxTileX;
    @ObfuscatedName("f")
    @Export("minTileY")
    int minTileY;
    @ObfuscatedName("e")
    @Export("maxTileY")
    int maxTileY;
    @ObfuscatedName("t")
    @Export("type")
    int type;
    @ObfuscatedName("d")
    @Export("minX")
    int minX;
    @ObfuscatedName("p")
    @Export("maxX")
    int maxX;
    @ObfuscatedName("k")
    @Export("minZ")
    int minZ;
    @ObfuscatedName("r")
    @Export("maxZ")
    int maxZ;
    @ObfuscatedName("l")
    @Export("minY")
    int minY;
    @ObfuscatedName("a")
    @Export("maxY")
    int maxY;
    @ObfuscatedName("z")
    int field1852;
    @ObfuscatedName("s")
    int field1842;
    @ObfuscatedName("m")
    int field1854;
    @ObfuscatedName("u")
    int field1855;
    @ObfuscatedName("g")
    int field1856;
    @ObfuscatedName("o")
    int field1857;
    @ObfuscatedName("v")
    int field1861;

    @ObfuscatedName("t")
    public static boolean method2420(int var0) {
        return (var0 >> 21 & 1) != 0;
    }

    @ObfuscatedName("p")
    public static void method2419() {
        FloorUnderlayDefinition.HitSplatDefinition_cachedFonts.method3482();
    }
}
