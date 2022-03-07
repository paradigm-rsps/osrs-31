package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class17 {
    @ObfuscatedName("kj")
    static class65 field284;
    @ObfuscatedName("y")
    @Export("BZip2Decompressor_block")
    static int[] BZip2Decompressor_block;
    @ObfuscatedName("bu")
    @Export("archive13")
    @ObfuscatedSignature(
            descriptor = "Lclass153;"
    )
    static Archive archive13;
    @ObfuscatedName("ff")
    @Export("cameraZ")
    static int cameraZ;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "Lclass4;"
    )
    Script field279;
    @ObfuscatedName("w")
    int field282 = -1;
    @ObfuscatedName("f")
    int[] field280;
    @ObfuscatedName("e")
    String[] field281;

    @ObfuscatedName("w")
    public static void method184() {
        if (KeyHandler.KeyHandler_instance != null) {
            KeyHandler var0 = KeyHandler.KeyHandler_instance;
            synchronized (KeyHandler.KeyHandler_instance) {
                KeyHandler.KeyHandler_instance = null;
            }
        }

    }

    @ObfuscatedName("e")
    @Export("method185")
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
