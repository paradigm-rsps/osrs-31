import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("VarbitComposition")
public class VarbitComposition extends DualNode {
   @ObfuscatedName("i")
   @Export("VarbitDefinition_archive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   public static AbstractArchive VarbitDefinition_archive;
   @ObfuscatedName("w")
   @Export("VarbitDefinition_cached")
   @ObfuscatedSignature(
      descriptor = "Lclass169;"
   )
   public static EvictingDualNodeHashTable VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("a")
   @Export("musicTrackBoolean")
   static boolean musicTrackBoolean;
   @ObfuscatedName("cp")
   public static int field966;
   @ObfuscatedName("f")
   @Export("baseVar")
   public int baseVar;
   @ObfuscatedName("e")
   @Export("startBit")
   public int startBit;
   @ObfuscatedName("t")
   @Export("endBit")
   public int endBit;

   @ObfuscatedName("w")
   @Export("method830")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   public void method830(Buffer var1) {
      while(true) {
         int var2 = var1.method2665();
         if (var2 == 0) {
            return;
         }

         this.method831(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @Export("method831")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;I)V"
   )
   void method831(Buffer var1, int var2) {
      if (var2 == 1) {
         this.baseVar = var1.method2808();
         this.startBit = var1.method2665();
         this.endBit = var1.method2665();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lclass69;Z)V"
   )
   public static void method837(IterableNodeHashTableIterator var0, boolean var1) {
      if (NetCache.NetCache_socket != null) {
         try {
            NetCache.NetCache_socket.method1471();
         } catch (Exception var6) {
            ;
         }

         NetCache.NetCache_socket = null;
      }

      NetCache.NetCache_socket = var0;
      class149.method3176(var1);
      NetCache.NetCache_responseHeaderBuffer.offset = 0;
      MusicPatchPcmStream.NetCache_currentResponse = null;
      class68.NetCache_responseArchiveBuffer = null;
      NetCache.field2533 = 0;

      while(true) {
         NetFileRequest var2 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.method3515();
         if (var2 == null) {
            while(true) {
               var2 = (NetFileRequest)NetCache.NetCache_pendingResponses.method3515();
               if (var2 == null) {
                  if (NetCache.field2536 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.method2631(4);
                        var7.method2631(NetCache.field2536);
                        var7.method2778(0);
                        NetCache.NetCache_socket.method1474(var7.array, 0, 4);
                     } catch (IOException var5) {
                        try {
                           NetCache.NetCache_socket.method1471();
                        } catch (Exception var4) {
                           ;
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
