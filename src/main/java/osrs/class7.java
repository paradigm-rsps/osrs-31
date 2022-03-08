package osrs;

public class class7 extends Node {
    static Widget field113;
    static Archive archive3;
    static Archive field102;
    String field112;
    String field103;
    int field109;
    byte field105;

    public static int method57(int var0, int var1, int var2) {
        var2 &= 3;
        if (var2 == 0) {
            return var1;
        } else if (var2 == 1) {
            return 7 - var0;
        } else {
            return var2 == 2 ? 7 - var1 : var0;
        }
    }

    public static byte[] method56(Object var0, boolean var1) {
        if (var0 == null) {
            return null;
        } else if (var0 instanceof byte[]) {
            byte[] var3 = (byte[]) var0;
            return var1 ? VarpDefinition.method934(var3) : var3;
        } else if (var0 instanceof AbstractByteArrayCopier) {
            AbstractByteArrayCopier var2 = (AbstractByteArrayCopier) var0;
            return var2.vmethod2620();
        } else {
            throw new IllegalArgumentException();
        }
    }

    static final void method55() {
        Scene.Scene_isLowDetail = false;
        Client.isLowDetail = false;
    }

    static final void method54() {
        for (PendingSpawn var0 = (PendingSpawn) Client.pendingSpawns.method3533(); var0 != null; var0 = (PendingSpawn) Client.pendingSpawns.method3535()) {
            if (var0.hitpoints == -1) {
                var0.delay = 0;
                Client.method354(var0);
            } else {
                var0.remove();
            }
        }

    }

    static String method58(Widget var0, int var1) {
        int var3 = SoundSystem.method1326(var0);
        boolean var2 = (var3 >> var1 + 1 & 1) != 0;
        if (!var2 && var0.field2635 == null) {
            return null;
        } else {
            return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
        }
    }
}
