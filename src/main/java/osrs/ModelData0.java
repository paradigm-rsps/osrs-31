package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("ModelData0")
public class ModelData0 {
    @ObfuscatedName("f")
    @Export("ObjectDefinition_modelsArchive")
    @ObfuscatedSignature(
            descriptor = "Lclass151;"
    )
    static AbstractArchive ObjectDefinition_modelsArchive;

    @ObfuscatedName("u")
    static final int method2301(int var0, int var1) {
        if (var0 == -1) {
            return 12345678;
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
