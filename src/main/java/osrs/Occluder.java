package osrs;

public final class Occluder {
    int minTileX;
    int maxTileX;
    int minTileY;
    int maxTileY;
    int type;
    int minX;
    int maxX;
    int minZ;
    int maxZ;
    int minY;
    int maxY;
    int field1852;
    int field1842;
    int field1854;
    int field1855;
    int field1856;
    int field1857;
    int field1861;

    public static boolean method2420(int var0) {
        return (var0 >> 21 & 1) != 0;
    }

    public static void method2419() {
        FloorUnderlayDefinition.HitSplatDefinition_cachedFonts.method3482();
    }
}
