package osrs;

public class VertexNormal {
    static int[] Tiles_saturation;
    static int[][][] field1510;
    static Font field1511;
    int x;
    int y;
    int z;
    int magnitude;

    VertexNormal() {
    }

    VertexNormal(VertexNormal var1) {
        this.x = var1.x;
        this.y = var1.y;
        this.z = var1.z;
        this.magnitude = var1.magnitude;
    }

    static void method2024() {
        Tiles.Tiles_minPlane = 99;
        Tiles.Tiles_underlays = new byte[4][104][104];
        VarpDefinition.Tiles_overlays = new byte[4][104][104];
        Tiles.Tiles_shapes = new byte[4][104][104];
        class123.field2031 = new byte[4][104][104];
        field1510 = new int[4][105][105];
        Tiles.field132 = new byte[4][105][105];
        Tiles.field120 = new int[105][105];
        Tiles.Tiles_hue = new int[104];
        Tiles_saturation = new int[104];
        EnumComposition.Tiles_lightness = new int[104];
        class1.Tiles_hueMultiplier = new int[104];
        Skills.field2053 = new int[104];
    }

    public static void method2026(AbstractArchive var0) {
        VarbitComposition.VarbitDefinition_archive = var0;
    }

    public static class40 method2025(int var0) {
        class40 var1 = (class40) class40.field1037.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = class40.field1035.method3204(5, var0);
            var1 = new class40();
            if (var2 != null) {
                var1.method917(new Buffer(var2));
            }

            class40.field1037.method3473(var1, var0);
            return var1;
        }
    }
}
