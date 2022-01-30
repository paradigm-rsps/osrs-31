import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class5 {
   @ObfuscatedName("nh")
   static int field73;
   @ObfuscatedName("i")
   static final BigInteger field76 = new BigInteger("10001", 16);
   @ObfuscatedName("w")
   static final BigInteger field72 = new BigInteger("8ddbafeca265b877e36d97b0162e12de723996ddffeea125ae62289206e4df60a0057bd688e4bde1148f090f541d3e06d14fc8d00b6ddf6d82454859d3ea71ff", 16);
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   static LoginType field75;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;)V"
   )
   public static void method41(AbstractArchive var0) {
      FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
   }

   @ObfuscatedName("t")
   static final int method39(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & '\uff00') * var2 + (var0 & '\uff00') * var3 & 16711680) + (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) >> 8;
   }

   @ObfuscatedName("p")
   public static void method38() {
      try {
         if (class137.musicPlayerStatus == 1) {
            int var0 = class137.midiPcmStream.method2916();
            if (var0 > 0 && class137.midiPcmStream.method2922()) {
               var0 -= class65.pcmSampleLength;
               if (var0 < 0) {
                  var0 = 0;
               }

               class137.midiPcmStream.method2975(var0);
               return;
            }

            class137.midiPcmStream.method2951();
            class137.midiPcmStream.method2919();
            if (class137.musicTrackArchive != null) {
               class137.musicPlayerStatus = 2;
            } else {
               class137.musicPlayerStatus = 0;
            }

            FloorDecoration.musicTrack = null;
            class23.soundCache = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class137.midiPcmStream.method2951();
         class137.musicPlayerStatus = 0;
         FloorDecoration.musicTrack = null;
         class23.soundCache = null;
         class137.musicTrackArchive = null;
      }

   }

   @ObfuscatedName("az")
   static final void method42(int var0, int var1, int var2, int var3, int var4) {
      if (var0 != Client.field746 || Client.field739 != var1 || var2 != Client.field531 && Client.isLowDetail) {
         Client.field746 = var0;
         Client.field739 = var1;
         Client.field531 = var2;
         if (!Client.isLowDetail) {
            Client.field531 = 0;
         }

         NPC.method260(25);
         class27.method570("Loading - please wait.", true);
         int var5 = FaceNormal.baseX;
         int var6 = Frames.baseY;
         FaceNormal.baseX = (var0 - 6) * 8;
         Frames.baseY = (var1 - 6) * 8;
         int var7 = FaceNormal.baseX - var5;
         int var8 = Frames.baseY - var6;
         var5 = FaceNormal.baseX;
         var6 = Frames.baseY;

         int var9;
         int var11;
         for(var9 = 0; var9 < 32768; ++var9) {
            NPC var21 = Client.npcs[var9];
            if (var21 != null) {
               for(var11 = 0; var11 < 10; ++var11) {
                  var21.hitSplatTypes2[var11] -= var7;
                  var21.hitSplatValues2[var11] -= var8;
               }

               var21.x -= var7 * 128;
               var21.y -= var8 * 128;
            }
         }

         for(var9 = 0; var9 < 2048; ++var9) {
            Player var24 = Client.players[var9];
            if (var24 != null) {
               for(var11 = 0; var11 < 10; ++var11) {
                  var24.hitSplatTypes2[var11] -= var7;
                  var24.hitSplatValues2[var11] -= var8;
               }

               var24.x -= var7 * 128;
               var24.y -= var8 * 128;
            }
         }

         class22.Client_plane = var2;
         Tiles.localPlayer.method290(var3, var4, false);
         byte var22 = 0;
         byte var10 = 104;
         byte var23 = 1;
         if (var7 < 0) {
            var22 = 103;
            var10 = -1;
            var23 = -1;
         }

         byte var12 = 0;
         byte var13 = 104;
         byte var14 = 1;
         if (var8 < 0) {
            var12 = 103;
            var13 = -1;
            var14 = -1;
         }

         for(int var15 = var22; var10 != var15; var15 += var23) {
            for(int var16 = var12; var16 != var13; var16 += var14) {
               int var17 = var7 + var15;
               int var18 = var16 + var8;

               for(int var19 = 0; var19 < 4; ++var19) {
                  if (var17 >= 0 && var18 >= 0 && var17 < 104 && var18 < 104) {
                     Client.groundItems[var19][var15][var16] = Client.groundItems[var19][var17][var18];
                  } else {
                     Client.groundItems[var19][var15][var16] = null;
                  }
               }
            }
         }

         for(PendingSpawn var20 = (PendingSpawn)Client.pendingSpawns.method3533(); var20 != null; var20 = (PendingSpawn)Client.pendingSpawns.method3535()) {
            var20.x -= var7;
            var20.y -= var8;
            if (var20.x < 0 || var20.y < 0 || var20.x >= 104 || var20.y >= 104) {
               var20.method3567();
            }
         }

         if (Client.field715 != 0) {
            Client.field715 -= var7;
            Client.field716 -= var8;
         }

         Client.soundEffectCount = 0;
         Client.field730 = false;
         Client.field710 = -1;
         Client.field620.method3527();
         Client.field619.method3527();
      }
   }

   @ObfuscatedName("dy")
   static final void method40(String var0) {
      if (ItemComposition.field1026 != null) {
         Client.field519.method2512(209);
         PacketBuffer var1 = Client.field519;
         int var2 = var0.length() + 1;
         var1.method2631(var2);
         Client.field519.method2636(var0);
      }
   }
}
