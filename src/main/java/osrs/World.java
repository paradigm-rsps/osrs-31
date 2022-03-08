package osrs;

public class World {
    static int field203;
    protected static java.awt.Font field206;
    static int field209;
    public static String field199;
    static Archive archive11;
    int id;
    int population;
    String field196;
    String field205;
    int field198;
    int index;
    boolean field197;
    boolean field201;

    public static void method155(Huffman var0) {
        class183.huffman = var0;
    }

    static final int method156(int var0, int var1) {
        if (var0 == -2) {
            return 12345678;
        } else if (var0 == -1) {
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return var1;
        } else {
            var1 = (var0 & 127) * var1 / 128;
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return (var0 & 'ﾀ') + var1;
        }
    }
}
