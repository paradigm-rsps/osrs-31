import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
   @ObfuscatedName("je")
   static int field2008;
   @ObfuscatedName("i")
   static boolean field2007 = false;
   @ObfuscatedName("h")
   static int[] field2005;
   @ObfuscatedName("bj")
   @Export("archive12")
   @ObfuscatedSignature(
      descriptor = "Lclass153;"
   )
   static Archive archive12;

   @ObfuscatedName("e")
   @Export("vmethod2620")
   abstract byte[] vmethod2620();

   @ObfuscatedName("t")
   abstract void vmethod2622(byte[] var1);

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lclass26;I)V"
   )
   static final void method2569(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if (var0.field456 > Client.cycle) {
         var2 = var0.field456 - Client.cycle;
         var3 = var0.field461 * 64 + var0.field460 * 128;
         var4 = var0.field461 * 64 + var0.field462 * 128;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field476 = 0;
         if (var0.field466 == 0) {
            var0.orientation = 1024;
         }

         if (var0.field466 == 1) {
            var0.orientation = 1536;
         }

         if (var0.field466 == 2) {
            var0.orientation = 0;
         }

         if (var0.field466 == 3) {
            var0.orientation = 512;
         }
      } else if (var0.field465 >= Client.cycle) {
         class10.method134(var0);
      } else {
         KitDefinition.method803(var0);
      }

      if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.sequence = -1;
         var0.spotAnimation = -1;
         var0.field456 = 0;
         var0.field465 = 0;
         var0.x = var0.hitSplatTypes2[0] * 128 + var0.field461 * 64;
         var0.y = var0.hitSplatValues2[0] * 128 + var0.field461 * 64;
         var0.method280();
      }

      if (Tiles.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.sequence = -1;
         var0.spotAnimation = -1;
         var0.field456 = 0;
         var0.field465 = 0;
         var0.x = var0.field461 * 64 + var0.hitSplatTypes2[0] * 128;
         var0.y = var0.hitSplatValues2[0] * 128 + var0.field461 * 64;
         var0.method280();
      }

      if (var0.field471 != 0) {
         if (var0.field444 != -1 && var0.field444 < 32768) {
            NPC var6 = Client.npcs[var0.field444];
            if (var6 != null) {
               var3 = var0.x - var6.x;
               var4 = var0.y - var6.y;
               if (var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            }
         }

         if (var0.field444 >= 32768) {
            var2 = var0.field444 - '耀';
            if (var2 == Client.localPlayerIndex) {
               var2 = 2047;
            }

            Player var7 = Client.players[var2];
            if (var7 != null) {
               var4 = var0.x - var7.x;
               int var5 = var0.y - var7.y;
               if (var4 != 0 || var5 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var4, (double)var5) * 325.949D) & 2047;
               }
            }
         }

         if ((var0.field475 != 0 || var0.field446 != 0) && (var0.pathLength == 0 || var0.field476 > 0)) {
            var2 = var0.x - (var0.field475 * 64 - FaceNormal.baseX * 64 - FaceNormal.baseX * 64);
            var3 = var0.y - (var0.field446 * 64 - Frames.baseY * 64 - Frames.baseY * 64);
            if (var2 != 0 || var3 != 0) {
               var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
            }

            var0.field475 = 0;
            var0.field446 = 0;
         }

         var2 = var0.orientation - var0.field432 & 2047;
         if (var2 != 0) {
            ++var0.field470;
            boolean var8;
            if (var2 > 1024) {
               var0.field432 -= var0.field471;
               var8 = true;
               if (var2 < var0.field471 || var2 > 2048 - var0.field471) {
                  var0.field432 = var0.orientation;
                  var8 = false;
               }

               if (var0.movementSequence == var0.idleSequence && (var0.field470 > 25 || var8)) {
                  if (var0.turnLeftSequence != -1) {
                     var0.movementSequence = var0.turnLeftSequence;
                  } else {
                     var0.movementSequence = var0.walkSequence;
                  }
               }
            } else {
               var0.field432 += var0.field471;
               var8 = true;
               if (var2 < var0.field471 || var2 > 2048 - var0.field471) {
                  var0.field432 = var0.orientation;
                  var8 = false;
               }

               if (var0.idleSequence == var0.movementSequence && (var0.field470 > 25 || var8)) {
                  if (var0.turnRightSequence != -1) {
                     var0.movementSequence = var0.turnRightSequence;
                  } else {
                     var0.movementSequence = var0.walkSequence;
                  }
               }
            }

            var0.field432 &= 2047;
         } else {
            var0.field470 = 0;
         }
      }

      ItemContainer.method205(var0);
   }
}
