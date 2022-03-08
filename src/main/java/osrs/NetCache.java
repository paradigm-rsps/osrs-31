package osrs;

import java.util.zip.CRC32;

public class NetCache {
    public static IterableNodeHashTableIterator NetCache_socket;
    public static int NetCache_loadTime = 0;
    public static long field2521;
    public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);
    public static int NetCache_pendingPriorityWritesCount = 0;
    public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);
    public static int NetCache_pendingPriorityResponsesCount = 0;
    public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();
    static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);
    public static int NetCache_pendingWritesCount = 0;
    public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);
    public static int NetCache_pendingResponsesCount = 0;
    public static boolean field2519;
    public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);
    public static int field2533 = 0;
    public static CRC32 NetCache_crc = new CRC32();
    public static Archive[] NetCache_archives = new Archive[256];
    public static byte field2536 = 0;
    public static int NetCache_crcMismatches = 0;
    public static int NetCache_ioExceptions = 0;

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
