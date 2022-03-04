import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("AudioFilter")
public class AudioFilter {
   @ObfuscatedName("d")
   static float[][] field1247 = new float[2][8];
   @ObfuscatedName("p")
   @Export("coefficients")
   static int[][] coefficients = new int[2][8];
   @ObfuscatedName("k")
   static float field1244;
   @ObfuscatedName("r")
   @Export("forwardMultiplier")
   static int forwardMultiplier;
   @ObfuscatedName("i")
   @Export("pairs")
   int[] pairs = new int[2];
   @ObfuscatedName("f")
   int[][][] field1248 = new int[2][2][4];
   @ObfuscatedName("e")
   int[][][] field1245 = new int[2][2][4];
   @ObfuscatedName("t")
   int[] field1246 = new int[2];

   @ObfuscatedName("i")
   float method1417(int var1, int var2, float var3) {
      float var4 = (float)this.field1245[var1][0][var2] + var3 * (float)(this.field1245[var1][1][var2] - this.field1245[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("f")
   float method1424(int var1, int var2, float var3) {
      float var4 = (float)this.field1248[var1][0][var2] + var3 * (float)(this.field1248[var1][1][var2] - this.field1248[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1418(var4);
   }

   @ObfuscatedName("e")
   @Export("method1419")
   int method1419(int var1, float var2) {
      float var3;
      if (var1 == 0) {
         var3 = (float)this.field1246[0] + (float)(this.field1246[1] - this.field1246[0]) * var2;
         var3 *= 0.0030517578F;
         field1244 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         forwardMultiplier = (int)(field1244 * 65536.0F);
      }

      if (this.pairs[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1417(var1, 0, var2);
         field1247[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1424(var1, 0, var2));
         field1247[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.pairs[var1]; ++var4) {
            var3 = this.method1417(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1424(var1, var4, var2));
            float var6 = var3 * var3;
            field1247[var1][var4 * 2 + 1] = field1247[var1][var4 * 2 - 1] * var6;
            field1247[var1][var4 * 2] = field1247[var1][var4 * 2 - 1] * var5 + field1247[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1247[var1][var7] += field1247[var1][var7 - 1] * var5 + field1247[var1][var7 - 2] * var6;
            }

            field1247[var1][1] += field1247[var1][0] * var5 + var6;
            field1247[var1][0] += var5;
         }

         if (var1 == 0) {
            for(var4 = 0; var4 < this.pairs[0] * 2; ++var4) {
               field1247[0][var4] *= field1244;
            }
         }

         for(var4 = 0; var4 < this.pairs[var1] * 2; ++var4) {
            coefficients[var1][var4] = (int)(field1247[var1][var4] * 65536.0F);
         }

         return this.pairs[var1] * 2;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;Lclass55;)V"
   )
   final void method1420(Buffer var1, SoundEnvelope var2) {
      int var3 = var1.readUnsignedByte();
      this.pairs[0] = var3 >> 4;
      this.pairs[1] = var3 & 15;
      if (var3 != 0) {
         this.field1246[0] = var1.readUnsignedShort();
         this.field1246[1] = var1.readUnsignedShort();
         int var7 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.pairs[var5]; ++var6) {
               this.field1248[var5][0][var6] = var1.readUnsignedShort();
               this.field1245[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.pairs[var5]; ++var6) {
               if ((var7 & 1 << var5 * 4 << var6) != 0) {
                  this.field1248[var5][1][var6] = var1.readUnsignedShort();
                  this.field1245[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1248[var5][1][var6] = this.field1248[var5][0][var6];
                  this.field1245[var5][1][var6] = this.field1245[var5][0][var6];
               }
            }
         }

         if (var7 != 0 || this.field1246[1] != this.field1246[0]) {
            var2.method1341(var1);
         }
      } else {
         int[] var4 = this.field1246;
         this.field1246[1] = 0;
         var4[0] = 0;
      }

   }

   @ObfuscatedName("w")
   @Export("method1418")
   static float method1418(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
