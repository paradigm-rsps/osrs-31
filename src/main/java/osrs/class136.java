package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ep")
public class class136 {
    @ObfuscatedName("i")
    public static final class136 field2335 = new class136(0);
    @ObfuscatedName("w")
    public static final class136 field2332 = new class136(1);
    @ObfuscatedName("f")
    public static final class136 field2336 = new class136(2);
    @ObfuscatedName("e")
    @Export("value")
    public final int value;

    class136(int var1) {
        this.value = var1;
    }

    @ObfuscatedName("p")
    public static int method2869(boolean var0, boolean var1) {
        byte var2 = 0;
        int var3 = var2 + NetCache.NetCache_pendingPriorityResponsesCount + NetCache.NetCache_pendingPriorityWritesCount;
        return var3;
    }
}
