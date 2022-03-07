package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class68 {
    @ObfuscatedName("ok")
    @ObfuscatedSignature(
            descriptor = "Lclass150;"
    )
    static PlatformInfo field1274;
    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "[Lclass86;"
    )
    static IndexedSprite[] field1273;
    @ObfuscatedName("g")
    @Export("NetCache_responseArchiveBuffer")
    @ObfuscatedSignature(
            descriptor = "Lclass126;"
    )
    public static Buffer NetCache_responseArchiveBuffer;

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(Lclass185;)I"
    )
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

    @ObfuscatedName("f")
    public static int method1469(CharSequence var0, int var1) {
        return FaceNormal.method2027(var0, var1, true);
    }
}
