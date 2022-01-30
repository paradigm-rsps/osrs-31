import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
   @ObfuscatedName("i")
   @Export("ArchiveDiskActionHandler_requestQueue")
   @ObfuscatedSignature(
      descriptor = "Lclass176;"
   )
   public static NodeDeque ArchiveDiskActionHandler_requestQueue = new NodeDeque();
   @ObfuscatedName("w")
   @Export("ArchiveDiskActionHandler_responseQueue")
   @ObfuscatedSignature(
      descriptor = "Lclass176;"
   )
   public static NodeDeque ArchiveDiskActionHandler_responseQueue = new NodeDeque();
   @ObfuscatedName("f")
   static int field2565 = 0;
   @ObfuscatedName("e")
   @Export("ArchiveDiskActionHandler_lock")
   static Object ArchiveDiskActionHandler_lock = new Object();

   public void run() {
      try {
         while(true) {
            NodeDeque var2 = ArchiveDiskActionHandler_requestQueue;
            ArchiveDiskAction var1;
            synchronized(ArchiveDiskActionHandler_requestQueue) {
               var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.method3533();
            }

            Object var14;
            if (var1 != null) {
               if (var1.type == 0) {
                  var1.archiveDisk.method1501((int)var1.key, var1.data, var1.data.length);
                  var2 = ArchiveDiskActionHandler_requestQueue;
                  synchronized(ArchiveDiskActionHandler_requestQueue) {
                     var1.method3567();
                  }
               } else if (var1.type == 1) {
                  var1.data = var1.archiveDisk.method1500((int)var1.key);
                  var2 = ArchiveDiskActionHandler_requestQueue;
                  synchronized(ArchiveDiskActionHandler_requestQueue) {
                     ArchiveDiskActionHandler_responseQueue.method3528(var1);
                  }
               }

               var14 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if (field2565 <= 1) {
                     field2565 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  field2565 = 600;
               }
            } else {
               SequenceDefinition.method761(100L);
               var14 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if (field2565 <= 1) {
                     field2565 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  --field2565;
               }
            }
         }
      } catch (Exception var13) {
         ScriptEvent.method3((String)null, var13);
      }
   }

   @ObfuscatedName("r")
   public static void method3323() {
      KitDefinition.KitDefinition_cached.method3482();
   }
}
