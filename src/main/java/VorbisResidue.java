import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
@Implements("VorbisResidue")
public class VorbisResidue {
   @ObfuscatedName("i")
   @Export("residueType")
   int residueType = VorbisSample.method1280(16);
   @ObfuscatedName("w")
   @Export("begin")
   int begin = VorbisSample.method1280(24);
   @ObfuscatedName("f")
   @Export("end")
   int end = VorbisSample.method1280(24);
   @ObfuscatedName("e")
   @Export("partitionSize")
   int partitionSize = VorbisSample.method1280(24) + 1;
   @ObfuscatedName("t")
   @Export("classifications")
   int classifications = VorbisSample.method1280(6) + 1;
   @ObfuscatedName("d")
   @Export("classbook")
   int classbook = VorbisSample.method1280(8);
   @ObfuscatedName("p")
   @Export("cascade")
   int[] cascade;

   VorbisResidue() {
      int[] var1 = new int[this.classifications];

      int var2;
      for(var2 = 0; var2 < this.classifications; ++var2) {
         int var3 = 0;
         int var4 = VorbisSample.method1280(3);
         boolean var5 = VorbisSample.method1307() != 0;
         if (var5) {
            var3 = VorbisSample.method1280(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.cascade = new int[this.classifications * 8];

      for(var2 = 0; var2 < this.classifications * 8; ++var2) {
         this.cascade[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0 ? VorbisSample.method1280(8) : -1;
      }

   }

   @ObfuscatedName("i")
   void method1376(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if (!var3) {
         var4 = VorbisSample.VorbisSample_codebooks[this.classbook].dimensions;
         int var5 = this.end - this.begin;
         int var6 = var5 / this.partitionSize;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if (var8 == 0) {
                  var10 = VorbisSample.VorbisSample_codebooks[this.classbook].method1381();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if (var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.classifications;
                     }

                     var10 /= this.classifications;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.cascade[var8 + var11 * 8];
                  if (var12 >= 0) {
                     int var13 = var9 * this.partitionSize + this.begin;
                     VorbisCodebook var14 = VorbisSample.VorbisSample_codebooks[var12];
                     int var15;
                     if (this.residueType == 0) {
                        var15 = this.partitionSize / var14.dimensions;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1382();

                           for(int var18 = 0; var18 < var14.dimensions; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.partitionSize) {
                           float[] var16 = var14.method1382();

                           for(int var17 = 0; var17 < var14.dimensions; ++var17) {
                              var1[var13 + var15] += var16[var17];
                              ++var15;
                           }
                        }
                     }
                  }

                  ++var9;
                  if (var9 >= var6) {
                     break;
                  }
               }
            }
         }

      }
   }
}
