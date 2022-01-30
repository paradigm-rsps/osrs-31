import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
   @ObfuscatedName("i")
   @Export("FloorOverlayDefinition_archive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   static AbstractArchive FloorOverlayDefinition_archive;
   @ObfuscatedName("w")
   @Export("HitSplatDefinition_cachedSprites")
   @ObfuscatedSignature(
      descriptor = "Lclass169;"
   )
   static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("f")
   @Export("primaryRgb")
   public int primaryRgb = 0;
   @ObfuscatedName("e")
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("t")
   @Export("hideUnderlay")
   public boolean hideUnderlay = true;
   @ObfuscatedName("d")
   @Export("secondaryRgb")
   public int secondaryRgb = -1;
   @ObfuscatedName("p")
   @Export("hue")
   public int hue;
   @ObfuscatedName("k")
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("r")
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("l")
   @Export("secondaryHue")
   public int secondaryHue;
   @ObfuscatedName("a")
   @Export("secondarySaturation")
   public int secondarySaturation;
   @ObfuscatedName("z")
   @Export("secondaryLightness")
   public int secondaryLightness;

   @ObfuscatedName("f")
   @Export("method808")
   void method808() {
      if (this.secondaryRgb != -1) {
         this.method811(this.secondaryRgb);
         this.secondaryHue = this.hue;
         this.secondarySaturation = this.saturation;
         this.secondaryLightness = this.lightness;
      }

      this.method811(this.primaryRgb);
   }

   @ObfuscatedName("e")
   @Export("method809")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;I)V"
   )
   void method809(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2665();
         if (var3 == 0) {
            return;
         }

         this.method810(var1, var3, var2);
      }
   }

   @ObfuscatedName("t")
   @Export("method810")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;II)V"
   )
   void method810(Buffer var1, int var2, int var3) {
      if (var2 == 1) {
         this.primaryRgb = var1.method2801();
      } else if (var2 == 2) {
         this.texture = var1.method2665();
      } else if (var2 == 5) {
         this.hideUnderlay = false;
      } else if (var2 == 7) {
         this.secondaryRgb = var1.method2801();
      } else if (var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("d")
   @Export("method811")
   void method811(int var1) {
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
      double var16 = (var10 + var8) / 2.0D;
      if (var8 != var10) {
         if (var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if (var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if (var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if (var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if (var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(var16 * 256.0D);
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

   }

   @ObfuscatedName("i")
   static String method829(int var0) {
      return "<img=" + var0 + ">";
   }
}
