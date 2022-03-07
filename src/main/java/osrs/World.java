package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("World")
public class World {
    @ObfuscatedName("pk")
    static int field203;
    @ObfuscatedName("pm")
    protected static java.awt.Font field206;
    @ObfuscatedName("no")
    static int field209;
    @ObfuscatedName("n")
    public static String field199;
    @ObfuscatedName("bn")
    @Export("archive11")
    @ObfuscatedSignature(
            descriptor = "Lclass153;"
    )
    static Archive archive11;
    @ObfuscatedName("i")
    @Export("id")
    int id;
    @ObfuscatedName("w")
    @Export("population")
    int population;
    @ObfuscatedName("f")
    String field196;
    @ObfuscatedName("e")
    String field205;
    @ObfuscatedName("t")
    int field198;
    @ObfuscatedName("d")
    @Export("index")
    int index;
    @ObfuscatedName("p")
    boolean field197;
    @ObfuscatedName("k")
    boolean field201;

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(Lclass119;)V"
    )
    public static void method155(Huffman var0) {
        class183.huffman = var0;
    }

    @ObfuscatedName("g")
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
