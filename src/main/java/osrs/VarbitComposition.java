package osrs;

import java.io.IOException;

public class VarbitComposition extends DualNode {
    public static AbstractArchive VarbitDefinition_archive;
    public static EvictingDualNodeHashTable VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
    static boolean musicTrackBoolean;
    public static int field966;
    public int baseVar;
    public int startBit;
    public int endBit;

    public void method830(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method831(var1, var2);
        }
    }

    void method831(Buffer var1, int var2) {
        if (var2 == 1) {
            this.baseVar = var1.readUnsignedShort();
            this.startBit = var1.readUnsignedByte();
            this.endBit = var1.readUnsignedByte();
        }

    }

    public static void method837(IterableNodeHashTableIterator var0, boolean var1) {
        if (NetCache.NetCache_socket != null) {
            try {
                NetCache.NetCache_socket.method1471();
            } catch (Exception var6) {
            }

            NetCache.NetCache_socket = null;
        }

        NetCache.NetCache_socket = var0;
        class149.method3176(var1);
        NetCache.NetCache_responseHeaderBuffer.offset = 0;
        MusicPatchPcmStream.NetCache_currentResponse = null;
        class68.NetCache_responseArchiveBuffer = null;
        NetCache.field2533 = 0;

        while (true) {
            NetFileRequest var2 = (NetFileRequest) NetCache.NetCache_pendingPriorityResponses.method3515();
            if (var2 == null) {
                while (true) {
                    var2 = (NetFileRequest) NetCache.NetCache_pendingResponses.method3515();
                    if (var2 == null) {
                        if (NetCache.field2536 != 0) {
                            try {
                                Buffer var7 = new Buffer(4);
                                var7.writeByte(4);
                                var7.writeByte(NetCache.field2536);
                                var7.writeShort(0);
                                NetCache.NetCache_socket.flush(var7.array, 0, 4);
                            } catch (IOException var5) {
                                try {
                                    NetCache.NetCache_socket.method1471();
                                } catch (Exception var4) {
                                }

                                ++NetCache.NetCache_ioExceptions;
                                NetCache.NetCache_socket = null;
                            }
                        }

                        NetCache.NetCache_loadTime = 0;
                        NetCache.field2521 = ClientPreferences.method148();
                        return;
                    }

                    NetCache.NetCache_pendingWritesQueue.method3486(var2);
                    NetCache.NetCache_pendingWrites.method3517(var2, var2.key);
                    ++NetCache.NetCache_pendingWritesCount;
                    --NetCache.NetCache_pendingResponsesCount;
                }
            }

            NetCache.NetCache_pendingPriorityWrites.method3517(var2, var2.key);
            ++NetCache.NetCache_pendingPriorityWritesCount;
            --NetCache.NetCache_pendingPriorityResponsesCount;
        }
    }
}
