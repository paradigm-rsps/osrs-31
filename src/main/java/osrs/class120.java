package osrs;

public class class120 {
    static long field2016;
    static long field2013;
    static IndexedSprite field2015;

    public static boolean method2581(char var0) {
        if (var0 >= ' ' && var0 <= '~') {
            return true;
        } else if (var0 >= 160 && var0 <= 255) {
            return true;
        } else {
            return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
        }
    }

    static final byte[] method2582(byte[] var0) {
        Buffer var1 = new Buffer(var0);
        int var2 = var1.readUnsignedByte();
        int var3 = var1.readInt();
        if (var3 < 0 || AbstractArchive.field2507 != 0 && var3 > AbstractArchive.field2507) {
            throw new RuntimeException();
        } else if (var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.readBytes(var6, 0, var3);
            return var6;
        } else {
            int var4 = var1.readInt();
            if (var4 >= 0 && (AbstractArchive.field2507 == 0 || var4 <= AbstractArchive.field2507)) {
                byte[] var5 = new byte[var4];
                if (var2 == 1) {
                    BZip2Decompressor.method2587(var5, var4, var0, var3, 9);
                } else {
                    AbstractArchive.gzipDecompressor.method2583(var1, var5);
                }

                return var5;
            } else {
                throw new RuntimeException();
            }
        }
    }
}
