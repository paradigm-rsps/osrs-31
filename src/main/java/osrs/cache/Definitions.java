package osrs.cache;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import osrs.Buffer;
import osrs.SequenceDefinition;

public class Definitions {
    @ObfuscatedName("w")
    @Export("method250")
    @ObfuscatedSignature(
            descriptor = "(I)Lclass33;"
    )
    public static SequenceDefinition getAnimation(int var0) {
        SequenceDefinition var1 = (SequenceDefinition) SequenceDefinition.SequenceDefinition_cached.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = SequenceDefinition.SequenceDefinition_archive.method3204(12, var0);
            var1 = new SequenceDefinition();
            if (var2 != null) {
                var1.method752(new Buffer(var2));
            }

            var1.method742();
            SequenceDefinition.SequenceDefinition_cached.method3473(var1, var0);
            return var1;
        }
    }
}
