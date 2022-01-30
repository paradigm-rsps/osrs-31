import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("IsaacCipher")
public final class IsaacCipher {
   @ObfuscatedName("cj")
   public static char field2000;
   @ObfuscatedName("e")
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("t")
   @Export("results")
   int[] results = new int[256];
   @ObfuscatedName("d")
   @Export("mm")
   int[] mm = new int[256];
   @ObfuscatedName("p")
   @Export("aa")
   int aa;
   @ObfuscatedName("k")
   @Export("bb")
   int bb;
   @ObfuscatedName("r")
   @Export("cc")
   int cc;

   IsaacCipher(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.results[var2] = var1[var2];
      }

      this.method2538();
   }

   @ObfuscatedName("i")
   @Export("method2539")
   final int method2539() {
      if (0 == --this.valuesRemaining + 1) {
         this.method2540();
         this.valuesRemaining = 255;
      }

      return this.results[this.valuesRemaining];
   }

   @ObfuscatedName("w")
   @Export("method2540")
   final void method2540() {
      this.bb += ++this.cc;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if ((var1 & 2) == 0) {
            if ((var1 & 1) == 0) {
               this.aa ^= this.aa << 13;
            } else {
               this.aa ^= this.aa >>> 6;
            }
         } else if ((var1 & 1) == 0) {
            this.aa ^= this.aa << 2;
         } else {
            this.aa ^= this.aa >>> 16;
         }

         this.aa += this.mm[128 + var1 & 255];
         int var3;
         this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.bb + this.aa;
         this.results[var1] = this.bb = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("f")
   final void method2538() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.results[var1];
         var3 += this.results[var1 + 1];
         var4 += this.results[var1 + 2];
         var5 += this.results[var1 + 3];
         var6 += this.results[var1 + 4];
         var7 += this.results[var1 + 5];
         var8 += this.results[var1 + 6];
         var9 += this.results[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.mm[var1];
         var3 += this.mm[var1 + 1];
         var4 += this.mm[var1 + 2];
         var5 += this.mm[var1 + 3];
         var6 += this.mm[var1 + 4];
         var7 += this.mm[var1 + 5];
         var8 += this.mm[var1 + 6];
         var9 += this.mm[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      this.method2540();
      this.valuesRemaining = 256;
   }

   @ObfuscatedName("i")
   public static int method2548(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if ((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if (var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("dx")
   @Export("method2543")
   @ObfuscatedSignature(
      descriptor = "(Lclass157;)Ljava/lang/String;"
   )
   static String method2543(Widget var0) {
      if (class40.method905(SoundSystem.method1326(var0)) == 0) {
         return null;
      } else {
         return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
      }
   }
}
