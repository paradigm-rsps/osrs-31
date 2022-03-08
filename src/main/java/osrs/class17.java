package osrs;

public class class17 {
    static class65 field284;
    static int[] BZip2Decompressor_block;
    static Archive archive13;
    static int cameraZ;
    Script field279;
    int field282 = -1;
    int[] field280;
    String[] field281;

    public static void method184() {
        if (KeyHandler.KeyHandler_instance != null) {
            KeyHandler var0 = KeyHandler.KeyHandler_instance;
            synchronized (KeyHandler.KeyHandler_instance) {
                KeyHandler.KeyHandler_instance = null;
            }
        }

    }

    static void method185() {
        AccessFile var0 = null;

        try {
            var0 = Tiles.method110("", Client.field484.name, true);
            Buffer var1 = Projectile.clientPreferences.method139();
            var0.method574(var1.array, 0, var1.offset);
        } catch (Exception var3) {
        }

        try {
            if (var0 != null) {
                var0.method586();
            }
        } catch (Exception var2) {
        }

    }
}
