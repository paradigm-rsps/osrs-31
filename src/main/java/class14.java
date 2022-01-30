import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class14 {
   @ObfuscatedName("em")
   @Export("mapMarkerSprites")
   @ObfuscatedSignature(
      descriptor = "[Lclass85;"
   )
   static SpritePixels[] mapMarkerSprites;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      descriptor = "[Lclass86;"
   )
   static IndexedSprite[] field246;

   @ObfuscatedName("i")
   static long method163(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if (var5 >= 'A' && var5 <= 'Z') {
            var1 += (long)(var5 + 1 - 65);
         } else if (var5 >= 'a' && var5 <= 'z') {
            var1 += (long)(var5 + 1 - 97);
         } else if (var5 >= '0' && var5 <= '9') {
            var1 += (long)(var5 + 27 - 48);
         }

         if (var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;I)Lclass86;"
   )
   public static IndexedSprite method166(AbstractArchive var0, int var1) {
      if (!ArchiveDisk.method1504(var0, var1)) {
         return null;
      } else {
         IndexedSprite var3 = new IndexedSprite();
         var3.width = class83.SpriteBuffer_spriteWidth;
         var3.height = class83.SpriteBuffer_spriteHeight;
         var3.xOffset = class83.SpriteBuffer_xOffsets[0];
         var3.yOffset = class165.SpriteBuffer_yOffsets[0];
         var3.subWidth = class112.SpriteBuffer_spriteWidths[0];
         var3.subHeight = class83.SpriteBuffer_spriteHeights[0];
         var3.palette = FloorUnderlayDefinition.SpriteBuffer_spritePalette;
         var3.pixels = class145.SpriteBuffer_pixels[0];
         FileSystem.method1515();
         return var3;
      }
   }

   @ObfuscatedName("p")
   static final boolean method164(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label68:
      while(true) {
         int var6 = var4.method2658();
         if (var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2658();
               if (var9 == 0) {
                  continue label68;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2665() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if (var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = GameBuild.method2853(var5);
                  if (var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1 || var15.boolean2) {
                     if (!var15.method662()) {
                        ++Client.field510;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2658();
            if (var9 == 0) {
               break;
            }

            var4.method2665();
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(Lclass33;III)V"
   )
   static void method165(SequenceDefinition var0, int var1, int var2, int var3) {
      if (Client.soundEffectCount < 50 && Client.field538 != 0) {
         if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
            int var4 = var0.soundEffects[var1];
            if (var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field742[Client.soundEffectCount] = var5;
               Client.field726[Client.soundEffectCount] = var6;
               Client.field727[Client.soundEffectCount] = 0;
               Client.field729[Client.soundEffectCount] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field589[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.soundEffectCount;
            }
         }
      }
   }
}
