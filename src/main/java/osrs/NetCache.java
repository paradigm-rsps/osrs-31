package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.zip.CRC32;

@ObfuscatedName("ea")
@Implements("NetCache")
public class NetCache {
    @ObfuscatedName("i")
    @Export("NetCache_socket")
    @ObfuscatedSignature(
            descriptor = "Lclass69;"
    )
    public static IterableNodeHashTableIterator NetCache_socket;
    @ObfuscatedName("w")
    @Export("NetCache_loadTime")
    public static int NetCache_loadTime = 0;
    @ObfuscatedName("f")
    public static long field2521;
    @ObfuscatedName("e")
    @Export("NetCache_pendingPriorityWrites")
    @ObfuscatedSignature(
            descriptor = "Lclass174;"
    )
    public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);
    @ObfuscatedName("t")
    @Export("NetCache_pendingPriorityWritesCount")
    public static int NetCache_pendingPriorityWritesCount = 0;
    @ObfuscatedName("d")
    @Export("NetCache_pendingPriorityResponses")
    @ObfuscatedSignature(
            descriptor = "Lclass174;"
    )
    public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);
    @ObfuscatedName("p")
    @Export("NetCache_pendingPriorityResponsesCount")
    public static int NetCache_pendingPriorityResponsesCount = 0;
    @ObfuscatedName("k")
    @Export("NetCache_pendingWritesQueue")
    @ObfuscatedSignature(
            descriptor = "Lclass171;"
    )
    public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();
    @ObfuscatedName("r")
    @Export("NetCache_pendingWrites")
    @ObfuscatedSignature(
            descriptor = "Lclass174;"
    )
    static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);
    @ObfuscatedName("l")
    @Export("NetCache_pendingWritesCount")
    public static int NetCache_pendingWritesCount = 0;
    @ObfuscatedName("a")
    @Export("NetCache_pendingResponses")
    @ObfuscatedSignature(
            descriptor = "Lclass174;"
    )
    public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);
    @ObfuscatedName("z")
    @Export("NetCache_pendingResponsesCount")
    public static int NetCache_pendingResponsesCount = 0;
    @ObfuscatedName("s")
    public static boolean field2519;
    @ObfuscatedName("u")
    @Export("NetCache_responseHeaderBuffer")
    @ObfuscatedSignature(
            descriptor = "Lclass126;"
    )
    public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);
    @ObfuscatedName("o")
    public static int field2533 = 0;
    @ObfuscatedName("j")
    @Export("NetCache_crc")
    public static CRC32 NetCache_crc = new CRC32();
    @ObfuscatedName("q")
    @Export("NetCache_archives")
    @ObfuscatedSignature(
            descriptor = "[Lclass153;"
    )
    public static Archive[] NetCache_archives = new Archive[256];
    @ObfuscatedName("c")
    public static byte field2536 = 0;
    @ObfuscatedName("h")
    @Export("NetCache_crcMismatches")
    public static int NetCache_crcMismatches = 0;
    @ObfuscatedName("b")
    @Export("NetCache_ioExceptions")
    public static int NetCache_ioExceptions = 0;

    @ObfuscatedName("f")
    public static void method3288() {
        KeyHandler var0 = KeyHandler.KeyHandler_instance;
        synchronized (KeyHandler.KeyHandler_instance) {
            ++KeyHandler.KeyHandler_idleCycles;
            KeyHandler.field1365 = KeyHandler.field1343;
            KeyHandler.field1364 = 0;
            int var1;
            if (KeyHandler.field1360 < 0) {
                for (var1 = 0; var1 < 112; ++var1) {
                    KeyHandler.KeyHandler_pressedKeys[var1] = false;
                }

                KeyHandler.field1360 = KeyHandler.field1363;
            } else {
                while (KeyHandler.field1360 != KeyHandler.field1363) {
                    var1 = KeyHandler.field1370[KeyHandler.field1363];
                    KeyHandler.field1363 = KeyHandler.field1363 + 1 & 127;
                    if (var1 < 0) {
                        KeyHandler.KeyHandler_pressedKeys[~var1] = false;
                    } else {
                        if (!KeyHandler.KeyHandler_pressedKeys[var1] && KeyHandler.field1364 < KeyHandler.field1348.length - 1) {
                            KeyHandler.field1348[++KeyHandler.field1364 - 1] = var1;
                        }

                        KeyHandler.KeyHandler_pressedKeys[var1] = true;
                    }
                }
            }

            KeyHandler.field1343 = KeyHandler.field1356;
        }
    }
}
