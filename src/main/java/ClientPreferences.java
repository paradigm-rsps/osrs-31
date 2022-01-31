import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("ClientPreferences")
public class ClientPreferences {
   @ObfuscatedName("ja")
   static int field191;
   @ObfuscatedName("i")
   @Export("ClientPreferences_optionCount")
   static int ClientPreferences_optionCount = 2;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "Lclass182;"
   )
   public static Font field188;
   @ObfuscatedName("g")
   static String[] field187;
   @ObfuscatedName("as")
   @Export("archive2")
   @ObfuscatedSignature(
      descriptor = "Lclass153;"
   )
   static Archive archive2;
   @ObfuscatedName("w")
   @Export("roofsHidden")
   boolean roofsHidden;
   @ObfuscatedName("f")
   @Export("titleMusicDisabled")
   boolean titleMusicDisabled;

   ClientPreferences() {
      this.method136(true);
   }

   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   ClientPreferences(Buffer var1) {
      if (var1 != null && var1.array != null) {
         int var2 = var1.method2665();
         if (var2 >= 0 && var2 <= ClientPreferences_optionCount) {
            if (var1.method2665() == 1) {
               this.roofsHidden = true;
            }

            if (var2 > 1) {
               this.titleMusicDisabled = var1.method2665() == 1;
            }
         } else {
            this.method136(true);
         }
      } else {
         this.method136(true);
      }

   }

   @ObfuscatedName("i")
   void method136(boolean var1) {
   }

   @ObfuscatedName("w")
   @Export("method139")
   @ObfuscatedSignature(
      descriptor = "()Lclass126;"
   )
   Buffer method139() {
      Buffer var1 = new Buffer(100);
      var1.writeByte(ClientPreferences_optionCount);
      var1.writeByte(this.roofsHidden ? 1 : 0);
      var1.writeByte(this.titleMusicDisabled ? 1 : 0);
      return var1;
   }

   @ObfuscatedName("i")
   public static synchronized long method148() {
      long var0 = System.currentTimeMillis();
      if (var0 < class120.field2016) {
         class120.field2013 += class120.field2016 - var0;
      }

      class120.field2016 = var0;
      return class120.field2013 + var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "()Lclass85;"
   )
   public static SpritePixels method152() {
      SpritePixels var0 = new SpritePixels();
      var0.width = class83.SpriteBuffer_spriteWidth;
      var0.height = class83.SpriteBuffer_spriteHeight;
      var0.xOffset = class83.SpriteBuffer_xOffsets[0];
      var0.yOffset = class165.SpriteBuffer_yOffsets[0];
      var0.subWidth = class112.SpriteBuffer_spriteWidths[0];
      var0.subHeight = class83.SpriteBuffer_spriteHeights[0];
      int var1 = var0.subWidth * var0.subHeight;
      byte[] var2 = class145.SpriteBuffer_pixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = FloorUnderlayDefinition.SpriteBuffer_spritePalette[var2[var3] & 255];
      }

      FileSystem.method1515();
      return var0;
   }

   @ObfuscatedName("x")
   static void method151(int var0, int var1, int var2) {
      if (Client.field721 != 0 && var1 != 0 && Client.soundEffectCount < 50) {
         Client.field742[Client.soundEffectCount] = var0;
         Client.field726[Client.soundEffectCount] = var1;
         Client.field727[Client.soundEffectCount] = var2;
         Client.field729[Client.soundEffectCount] = null;
         Client.field589[Client.soundEffectCount] = 0;
         ++Client.soundEffectCount;
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      descriptor = "(Lclass157;IIIIII)V"
   )
   static final void method154(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (Client.field691) {
         Client.alternativeScrollbarWidth = 32;
      } else {
         Client.alternativeScrollbarWidth = 0;
      }

      Client.field691 = false;
      int var7;
      if (MouseHandler.MouseHandler_currentButton != 0) {
         if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.field2655 -= 4;
            class82.method1754(var0);
         } else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.field2655 += 4;
            class82.method1754(var0);
         } else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if (var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2655 = var8 * (var4 - var3) / var9;
            class82.method1754(var0);
            Client.field691 = true;
         }
      }

      if (Client.field654 != 0) {
         var7 = var0.width;
         if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.field2655 += Client.field654 * 45;
            class82.method1754(var0);
         }
      }

   }
}
