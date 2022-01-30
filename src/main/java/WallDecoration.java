import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("WallDecoration")
public final class WallDecoration {
   @ObfuscatedName("n")
   @Export("NetCache_reference")
   @ObfuscatedSignature(
      descriptor = "Lclass126;"
   )
   public static Buffer NetCache_reference;
   @ObfuscatedName("i")
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("w")
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @Export("orientation")
   int orientation;
   @ObfuscatedName("t")
   @Export("orientation2")
   int orientation2;
   @ObfuscatedName("d")
   @Export("xOffset")
   int xOffset;
   @ObfuscatedName("p")
   @Export("yOffset")
   int yOffset;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Lclass93;"
   )
   public Renderable field1815;
   @ObfuscatedName("r")
   @Export("renderable2")
   @ObfuscatedSignature(
      descriptor = "Lclass93;"
   )
   public Renderable renderable2;
   @ObfuscatedName("l")
   public int field1817 = 0;
   @ObfuscatedName("a")
   int field1809 = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Lclass151;Z)V"
   )
   public static void method2383(AbstractArchive var0, AbstractArchive var1, boolean var2) {
      ObjectComposition.ObjectDefinition_archive = var0;
      ModelData0.ObjectDefinition_modelsArchive = var1;
      ObjectComposition.ObjectDefinition_isLowDetail = var2;
   }

   @ObfuscatedName("w")
   public static byte[] method2385(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if (var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if (var4 == 8364) {
            var2[var3] = -128;
         } else if (var4 == 8218) {
            var2[var3] = -126;
         } else if (var4 == 402) {
            var2[var3] = -125;
         } else if (var4 == 8222) {
            var2[var3] = -124;
         } else if (var4 == 8230) {
            var2[var3] = -123;
         } else if (var4 == 8224) {
            var2[var3] = -122;
         } else if (var4 == 8225) {
            var2[var3] = -121;
         } else if (var4 == 710) {
            var2[var3] = -120;
         } else if (var4 == 8240) {
            var2[var3] = -119;
         } else if (var4 == 352) {
            var2[var3] = -118;
         } else if (var4 == 8249) {
            var2[var3] = -117;
         } else if (var4 == 338) {
            var2[var3] = -116;
         } else if (var4 == 381) {
            var2[var3] = -114;
         } else if (var4 == 8216) {
            var2[var3] = -111;
         } else if (var4 == 8217) {
            var2[var3] = -110;
         } else if (var4 == 8220) {
            var2[var3] = -109;
         } else if (var4 == 8221) {
            var2[var3] = -108;
         } else if (var4 == 8226) {
            var2[var3] = -107;
         } else if (var4 == 8211) {
            var2[var3] = -106;
         } else if (var4 == 8212) {
            var2[var3] = -105;
         } else if (var4 == 732) {
            var2[var3] = -104;
         } else if (var4 == 8482) {
            var2[var3] = -103;
         } else if (var4 == 353) {
            var2[var3] = -102;
         } else if (var4 == 8250) {
            var2[var3] = -101;
         } else if (var4 == 339) {
            var2[var3] = -100;
         } else if (var4 == 382) {
            var2[var3] = -98;
         } else if (var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }

   @ObfuscatedName("e")
   static void method2384(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.method3512((long)var0);
      if (var1 != null) {
         var1.method3567();
      }
   }
}
