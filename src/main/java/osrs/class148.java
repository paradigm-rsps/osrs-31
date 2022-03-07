package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class148 {
    @ObfuscatedName("i")
    @Export("cp1252AsciiExtension")
    public static final char[] cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
    @ObfuscatedName("el")
    static int[] field2460;

    @ObfuscatedName("e")
    @Export("method3173")
    @ObfuscatedSignature(
            descriptor = "(Lclass153;IIIBZ)V"
    )
    static void method3173(Archive var0, int var1, int var2, int var3, byte var4, boolean var5) {
        long var6 = (var1 << 16) + var2;
        NetFileRequest var8 = (NetFileRequest) NetCache.NetCache_pendingPriorityWrites.method3512(var6);
        if (var8 == null) {
            var8 = (NetFileRequest) NetCache.NetCache_pendingPriorityResponses.method3512(var6);
            if (var8 == null) {
                var8 = (NetFileRequest) NetCache.NetCache_pendingWrites.method3512(var6);
                if (var8 != null) {
                    if (var5) {
                        var8.method3509();
                        NetCache.NetCache_pendingPriorityWrites.method3517(var8, var6);
                        --NetCache.NetCache_pendingWritesCount;
                        ++NetCache.NetCache_pendingPriorityWritesCount;
                    }

                } else {
                    if (!var5) {
                        var8 = (NetFileRequest) NetCache.NetCache_pendingResponses.method3512(var6);
                        if (var8 != null) {
                            return;
                        }
                    }

                    var8 = new NetFileRequest();
                    var8.archive = var0;
                    var8.crc = var3;
                    var8.padding = var4;
                    if (var5) {
                        NetCache.NetCache_pendingPriorityWrites.method3517(var8, var6);
                        ++NetCache.NetCache_pendingPriorityWritesCount;
                    } else {
                        NetCache.NetCache_pendingWritesQueue.method3485(var8);
                        NetCache.NetCache_pendingWrites.method3517(var8, var6);
                        ++NetCache.NetCache_pendingWritesCount;
                    }

                }
            }
        }
    }
}
