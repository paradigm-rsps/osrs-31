import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends DualNode {
   @ObfuscatedName("mp")
   static byte field882;
   @ObfuscatedName("i")
   @Export("FloorUnderlayDefinition_archive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   static AbstractArchive FloorUnderlayDefinition_archive;
   @ObfuscatedName("w")
   @Export("HitSplatDefinition_cachedFonts")
   @ObfuscatedSignature(
      descriptor = "Lclass169;"
   )
   static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("k")
   @Export("SpriteBuffer_spritePalette")
   static int[] SpriteBuffer_spritePalette;
   @ObfuscatedName("f")
   @Export("rgb")
   int rgb = 0;
   @ObfuscatedName("e")
   @Export("hue")
   public int hue;
   @ObfuscatedName("t")
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("d")
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("p")
   @Export("hueMultiplier")
   public int hueMultiplier;

   @ObfuscatedName("f")
   @Export("method700")
   void method700() {
      this.method703(this.rgb);
   }

   @ObfuscatedName("e")
   @Export("method701")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;I)V"
   )
   void method701(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2665();
         if (var3 == 0) {
            return;
         }

         this.method699(var1, var3, var2);
      }
   }

   @ObfuscatedName("t")
   @Export("method699")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;II)V"
   )
   void method699(Buffer var1, int var2, int var3) {
      if (var2 == 1) {
         this.rgb = var1.method2801();
      }

   }

   @ObfuscatedName("d")
   @Export("method703")
   void method703(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if (var4 < var2) {
         var8 = var4;
      }

      if (var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if (var4 > var2) {
         var10 = var4;
      }

      if (var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if (var8 != var10) {
         if (var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if (var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if (var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if (var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if (var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(256.0D * var16);
      if (this.saturation < 0) {
         this.saturation = 0;
      } else if (this.saturation > 255) {
         this.saturation = 255;
      }

      if (this.lightness < 0) {
         this.lightness = 0;
      } else if (this.lightness > 255) {
         this.lightness = 255;
      }

      if (var16 > 0.5D) {
         this.hueMultiplier = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.hueMultiplier = (int)(512.0D * var14 * var16);
      }

      if (this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)(var12 * (double)this.hueMultiplier);
   }

   @ObfuscatedName("t")
   public static void method718() {
      VarpDefinition.VarpDefinition_cached.method3482();
   }
}
