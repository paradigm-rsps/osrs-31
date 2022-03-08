package osrs;

public class class68 {
    static PlatformInfo field1274;
    static IndexedSprite[] field1273;
    public static Buffer NetCache_responseArchiveBuffer;

    static final int method1470(LoginType var0) {
        if (var0 == null) {
            return 12;
        } else {
            switch (var0.field2857) {
                case 7:
                    return 20;
                default:
                    return 12;
            }
        }
    }

    public static int method1469(CharSequence var0, int var1) {
        return FaceNormal.method2027(var0, var1, true);
    }
}
