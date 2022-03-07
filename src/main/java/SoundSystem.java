import java.awt.event.ActionEvent;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
   @ObfuscatedName("pv")
   @Export("canvasWidth")
   protected static int canvasWidth;
   @ObfuscatedName("mk")
   static int field1188;
   @ObfuscatedName("bw")
   @Export("worldHost")
   static String worldHost;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lclass73;"
   )
   TaskHandler field1181;
   @ObfuscatedName("w")
   @Export("players")
   @ObfuscatedSignature(
      descriptor = "[Lclass51;"
   )
   volatile PcmPlayer[] players = new PcmPlayer[2];
   @ObfuscatedName("f")
   volatile boolean field1183 = false;
   @ObfuscatedName("e")
   volatile boolean field1182 = false;

   public void run() {
      this.field1182 = true;

      try {
         while(!this.field1183) {
            PcmPlayer var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.players[var1];
               if (var2 != null) {
                  var2.method1227();
               }
            }

            SequenceDefinition.sleepWeird(10L);
            TaskHandler var5 = this.field1181;
            var2 = null;
            if (var5.thread != null) {
               for(int var3 = 0; var3 < 50 && var5.thread.peekEvent() != null; ++var3) {
                  SequenceDefinition.sleepWeird(1L);
               }

               if (var2 != null) {
                  var5.thread.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         ScriptEvent.method3((String)null, var8);
      } finally {
         this.field1182 = false;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;I)Lclass139;"
   )
   static MusicPatch method1327(AbstractArchive var0, int var1) {
      byte[] var2 = var0.method3209(var1);
      return var2 == null ? null : new MusicPatch(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IIILclass31;I)V"
   )
   static void method1324(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      ObjectSound var5 = new ObjectSound();
      var5.field79 = var0;
      var5.field80 = var1 * 128;
      var5.field81 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if (var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field82 = (var6 + var1) * 128;
      var5.field95 = (var7 + var2) * 128;
      var5.soundEffectId = var3.ambientSoundId;
      var5.field84 = var3.field841 * 128;
      var5.field96 = var3.int5;
      var5.field88 = var3.int7;
      var5.soundEffectIds = var3.soundEffectIds;
      if (var3.transforms != null) {
         var5.obj = var3;
         var5.method44();
      }

      ObjectSound.objectSounds.method3528(var5);
      if (var5.soundEffectIds != null) {
         var5.field97 = var5.field96 + (int)(Math.random() * (double)(var5.field88 - var5.field96));
      }

   }

   @ObfuscatedName("bg")
   static final void method1329() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.method3533(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.method3535()) {
         if (var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if (var0.hitpoints == 0) {
            if (var0.objectId >= 0) {
               var2 = var0.objectId;
               var3 = var0.field359;
               var4 = GameBuild.getObjectComposition(var2);
               if (var3 == 11) {
                  var3 = 10;
               }

               if (var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method661(var3);
               if (!var1) {
                  continue;
               }
            }

            KeyHandler.method1648(var0.plane, var0.type, var0.x, var0.y, var0.objectId, var0.field361, var0.field359);
            var0.remove();
         } else {
            if (var0.delay > 0) {
               --var0.delay;
            }

            if (var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102) {
               if (var0.id >= 0) {
                  var2 = var0.id;
                  var3 = var0.field362;
                  var4 = GameBuild.getObjectComposition(var2);
                  if (var3 == 11) {
                     var3 = 10;
                  }

                  if (var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method661(var3);
                  if (!var1) {
                     continue;
                  }
               }

               KeyHandler.method1648(var0.plane, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field362);
               var0.delay = -1;
               if (var0.id == var0.objectId && var0.objectId == -1) {
                  var0.remove();
               } else if (var0.id == var0.objectId && var0.field361 == var0.orientation && var0.field362 == var0.field359) {
                  var0.remove();
               }
            }
         }
      }

   }

   @ObfuscatedName("de")
   @Export("method1326")
   @ObfuscatedSignature(
      descriptor = "(Lclass157;)I"
   )
   static int method1326(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.method3512(((long)var0.id << 32) + (long)var0.childIndex);
      return var1 != null ? var1.integer : var0.field2644;
   }
}
