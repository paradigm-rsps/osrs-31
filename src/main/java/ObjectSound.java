import java.awt.Frame;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
   @ObfuscatedName("pj")
   protected static Frame field87;
   @ObfuscatedName("ou")
   @Export("masterDisk")
   @ObfuscatedSignature(
      descriptor = "Lclass70;"
   )
   static ArchiveDisk masterDisk;
   @ObfuscatedName("ni")
   static int field78;
   @ObfuscatedName("i")
   @Export("objectSounds")
   @ObfuscatedSignature(
      descriptor = "Lclass176;"
   )
   static NodeDeque objectSounds = new NodeDeque();
   @ObfuscatedName("dd")
   static int[] regionMapArchiveIds;
   @ObfuscatedName("ev")
   @Export("headIconHintSprites")
   @ObfuscatedSignature(
      descriptor = "[Lclass85;"
   )
   static SpritePixels[] headIconHintSprites;
   @ObfuscatedName("w")
   int field79;
   @ObfuscatedName("f")
   int field80;
   @ObfuscatedName("e")
   int field81;
   @ObfuscatedName("t")
   int field82;
   @ObfuscatedName("d")
   int field95;
   @ObfuscatedName("p")
   int field84;
   @ObfuscatedName("k")
   @Export("soundEffectId")
   int soundEffectId;
   @ObfuscatedName("r")
   @Export("obj")
   @ObfuscatedSignature(
      descriptor = "Lclass31;"
   )
   ObjectComposition obj;
   @ObfuscatedName("l")
   @Export("stream1")
   @ObfuscatedSignature(
      descriptor = "Lclass44;"
   )
   RawPcmStream stream1;
   @ObfuscatedName("a")
   int field96;
   @ObfuscatedName("z")
   int field88;
   @ObfuscatedName("s")
   @Export("soundEffectIds")
   int[] soundEffectIds;
   @ObfuscatedName("m")
   int field97;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Lclass44;"
   )
   RawPcmStream field91;

   @ObfuscatedName("i")
   @Export("method44")
   void method44() {
      int var1 = this.soundEffectId;
      ObjectComposition var2 = this.obj.method673();
      if (var2 != null) {
         this.soundEffectId = var2.ambientSoundId;
         this.field84 = var2.field841 * 128;
         this.field96 = var2.int5;
         this.field88 = var2.int7;
         this.soundEffectIds = var2.soundEffectIds;
      } else {
         this.soundEffectId = -1;
         this.field84 = 0;
         this.field96 = 0;
         this.field88 = 0;
         this.soundEffectIds = null;
      }

      if (var1 != this.soundEffectId && this.stream1 != null) {
         ItemContainer.pcmStreamMixer.method1127(this.stream1);
         this.stream1 = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Ljava/lang/String;Ljava/lang/String;)[Lclass86;"
   )
   public static IndexedSprite[] method52(AbstractArchive var0, String var1, String var2) {
      int var3 = var0.getGroupId(var1);
      int var4 = var0.method3238(var3, var2);
      IndexedSprite[] var5;
      if (!KitDefinition.method796(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = ArchiveDisk.method1512();
      }

      return var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(ILclass151;IIIZ)V"
   )
   public static void method43(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
      class137.musicPlayerStatus = 1;
      class137.musicTrackArchive = var1;
      class125.musicTrackGroupId = var2;
      FloorDecoration.musicTrackFileId = var3;
      class147.musicTrackVolume = var4;
      VarbitComposition.musicTrackBoolean = var5;
      class65.pcmSampleLength = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(Lclass182;Lclass182;)V"
   )
   static void method53(Font var0, Font var1) {
      if (class1.worldSelectBackSprites == null) {
         class1.worldSelectBackSprites = Clock.method1467(MouseRecorder.archive8, "sl_back", "");
      }

      if (Login.worldSelectFlagSprites == null) {
         Login.worldSelectFlagSprites = method52(MouseRecorder.archive8, "sl_flags", "");
      }

      if (FileSystem.worldSelectArrows == null) {
         FileSystem.worldSelectArrows = method52(MouseRecorder.archive8, "sl_arrows", "");
      }

      if (class159.worldSelectStars == null) {
         class159.worldSelectStars = method52(MouseRecorder.archive8, "sl_stars", "");
      }

      Rasterizer2D.method1962(0, 23, 765, 480, 0);
      Rasterizer2D.method1960(0, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method1960(125, 0, 640, 23, 5197647, 2697513);
      var0.method3676("Select a world", 62, 15, 0, -1);
      if (class159.worldSelectStars != null) {
         class159.worldSelectStars[1].method1936(140, 1);
         var1.method3626("Members only world", 152, 10, 16777215, -1);
         class159.worldSelectStars[0].method1936(140, 12);
         var1.method3626("Free world", 152, 21, 16777215, -1);
      }

      if (FileSystem.worldSelectArrows != null) {
         short var2 = 280;
         if (Login.World_sortOption1[0] == 0 && Login.World_sortOption2[0] == 0) {
            FileSystem.worldSelectArrows[2].method1936(var2, 4);
         } else {
            FileSystem.worldSelectArrows[0].method1936(var2, 4);
         }

         if (Login.World_sortOption1[0] == 0 && Login.World_sortOption2[0] == 1) {
            FileSystem.worldSelectArrows[3].method1936(var2 + 15, 4);
         } else {
            FileSystem.worldSelectArrows[1].method1936(var2 + 15, 4);
         }

         var0.method3626("World", var2 + 32, 17, 16777215, -1);
         short var3 = 390;
         if (Login.World_sortOption1[0] == 1 && Login.World_sortOption2[0] == 0) {
            FileSystem.worldSelectArrows[2].method1936(var3, 4);
         } else {
            FileSystem.worldSelectArrows[0].method1936(var3, 4);
         }

         if (Login.World_sortOption1[0] == 1 && Login.World_sortOption2[0] == 1) {
            FileSystem.worldSelectArrows[3].method1936(var3 + 15, 4);
         } else {
            FileSystem.worldSelectArrows[1].method1936(var3 + 15, 4);
         }

         var0.method3626("Players", var3 + 32, 17, 16777215, -1);
         short var4 = 500;
         if (Login.World_sortOption1[0] == 2 && Login.World_sortOption2[0] == 0) {
            FileSystem.worldSelectArrows[2].method1936(var4, 4);
         } else {
            FileSystem.worldSelectArrows[0].method1936(var4, 4);
         }

         if (Login.World_sortOption1[0] == 2 && Login.World_sortOption2[0] == 1) {
            FileSystem.worldSelectArrows[3].method1936(var4 + 15, 4);
         } else {
            FileSystem.worldSelectArrows[1].method1936(var4 + 15, 4);
         }

         var0.method3626("Location", var4 + 32, 17, 16777215, -1);
         short var5 = 610;
         if (Login.World_sortOption1[0] == 3 && Login.World_sortOption2[0] == 0) {
            FileSystem.worldSelectArrows[2].method1936(var5, 4);
         } else {
            FileSystem.worldSelectArrows[0].method1936(var5, 4);
         }

         if (Login.World_sortOption1[0] == 3 && Login.World_sortOption2[0] == 1) {
            FileSystem.worldSelectArrows[3].method1936(var5 + 15, 4);
         } else {
            FileSystem.worldSelectArrows[1].method1936(var5 + 15, 4);
         }

         var0.method3626("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method1962(708, 4, 50, 16, 0);
      var1.method3676("Cancel", 733, 16, 16777215, -1);
      Login.field348 = -1;
      if (class1.worldSelectBackSprites != null) {
         byte var22 = 88;
         byte var23 = 19;
         int var24 = 765 / (var22 + 1);
         int var25 = 480 / (var23 + 1);

         int var6;
         int var7;
         do {
            var6 = var25;
            var7 = var24;
            if (var25 * (var24 - 1) >= Login.field334) {
               --var24;
            }

            if (var24 * (var25 - 1) >= Login.field334) {
               --var25;
            }

            if (var24 * (var25 - 1) >= Login.field334) {
               --var25;
            }
         } while(var6 != var25 || var7 != var24);

         var6 = (765 - var22 * var24) / (var24 + 1);
         if (var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var23 * var25) / (var25 + 1);
         if (var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var24 * var22 - var6 * (var24 - 1)) / 2;
         int var9 = (480 - var25 * var23 - var7 * (var25 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < Login.field334; ++var14) {
            World var15 = Skills.field2058[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.population);
            if (var15.population == -1) {
               var17 = "OFF";
               var16 = false;
            } else if (var15.population > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            byte var18;
            if (var15.field201) {
               if (var15.field197) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if (var15.field197) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if (MouseHandler.MouseHandler_x >= var11 && MouseHandler.MouseHandler_y >= var10 && MouseHandler.MouseHandler_x < var11 + var22 && MouseHandler.MouseHandler_y < var10 + var23 && var16) {
               Login.field348 = var14;
               class1.worldSelectBackSprites[var18].method1837(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class1.worldSelectBackSprites[var18].method1835(var11, var10);
            }

            if (Login.worldSelectFlagSprites != null) {
               Login.worldSelectFlagSprites[(var15.field197 ? 8 : 0) + var15.field198].method1936(var11 + 29, var10);
            }

            var0.method3676(Integer.toString(var15.id), var11 + 15, var23 / 2 + var10 + 5, 0, -1);
            var1.method3676(var17, var11 + 60, var23 / 2 + var10 + 5, 268435455, -1);
            var10 = var10 + var7 + var23;
            ++var12;
            if (var12 >= var25) {
               var10 = var9 + 23;
               var11 = var11 + var6 + var22;
               var12 = 0;
            }
         }

         if (var13) {
            var14 = var1.method3601(Skills.field2058[Login.field348].field205) + 6;
            int var19 = var1.ascent + 8;
            Rasterizer2D.method1962(MouseHandler.MouseHandler_x - var14 / 2, MouseHandler.MouseHandler_y + 20 + 5, var14, var19, 16777120);
            Rasterizer2D.method1995(MouseHandler.MouseHandler_x - var14 / 2, MouseHandler.MouseHandler_y + 20 + 5, var14, var19, 0);
            var1.method3676(Skills.field2058[Login.field348].field205, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y + var1.ascent + 20 + 5 + 4, 0, -1);
         }
      }

      try {
         Graphics var20 = Tiles.field131.getGraphics();
         MouseRecorder.field262.vmethod1945(var20, 0, 0);
      } catch (Exception var21) {
         Tiles.field131.repaint();
      }

   }

   @ObfuscatedName("cv")
   static boolean method45(String var0) {
      if (var0 == null) {
         return false;
      } else {
         String var1 = Projectile.method125(var0, class5.field75);

         for(int var2 = 0; var2 < Client.field534; ++var2) {
            class10 var3 = Client.field741[var2];
            if (var1.equalsIgnoreCase(Projectile.method125(var3.field177, class5.field75))) {
               return true;
            }

            if (var1.equalsIgnoreCase(Projectile.method125(var3.field178, class5.field75))) {
               return true;
            }
         }

         return false;
      }
   }
}
