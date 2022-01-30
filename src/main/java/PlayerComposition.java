import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("p")
   public static short[] field2718;
   @ObfuscatedName("r")
   public static short[] field2716;
   @ObfuscatedName("a")
   @Export("equipmentIndices")
   static final int[] equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("z")
   @Export("Widget_cachedSprites")
   @ObfuscatedSignature(
      descriptor = "Lclass169;"
   )
   public static EvictingDualNodeHashTable Widget_cachedSprites = new EvictingDualNodeHashTable(260);
   @ObfuscatedName("i")
   @Export("equipment")
   int[] equipment;
   @ObfuscatedName("w")
   @Export("bodyColors")
   int[] bodyColors;
   @ObfuscatedName("f")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("e")
   @Export("npcTransformId")
   int npcTransformId;
   @ObfuscatedName("t")
   @Export("hash")
   long hash;
   @ObfuscatedName("d")
   long field2712;

   @ObfuscatedName("i")
   @Export("method3424")
   public void method3424(int[] var1, int[] var2, boolean var3, int var4) {
      if (var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
               KitDefinition var7 = class65.method1455(var6);
               if (var7 != null && !var7.nonSelectable && var7.bodypartID == var5 + (var3 ? 7 : 0)) {
                  var1[equipmentIndices[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipment = var1;
      this.bodyColors = var2;
      this.isFemale = var3;
      this.npcTransformId = var4;
      this.method3406();
   }

   @ObfuscatedName("w")
   @Export("method3421")
   public void method3421(int var1, boolean var2) {
      if (var1 != 1 || !this.isFemale) {
         int var3 = this.equipment[equipmentIndices[var1]];
         if (var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if (!var2) {
                  --var3;
                  if (var3 < 0) {
                     var3 = KitDefinition.KitDefinition_fileCount - 1;
                  }
               } else {
                  ++var3;
                  if (var3 >= KitDefinition.KitDefinition_fileCount) {
                     var3 = 0;
                  }
               }

               var4 = class65.method1455(var3);
            } while(var4 == null || var4.nonSelectable || (this.isFemale ? 7 : 0) + var1 != var4.bodypartID);

            this.equipment[equipmentIndices[var1]] = var3 + 256;
            this.method3406();
         }
      }
   }

   @ObfuscatedName("f")
   public void method3403(int var1, boolean var2) {
      int var3 = this.bodyColors[var1];
      if (!var2) {
         --var3;
         if (var3 < 0) {
            var3 = Skeleton.field1792[var1].length - 1;
         }
      } else {
         ++var3;
         if (var3 >= Skeleton.field1792[var1].length) {
            var3 = 0;
         }
      }

      this.bodyColors[var1] = var3;
      this.method3406();
   }

   @ObfuscatedName("e")
   @Export("method3404")
   public void method3404(boolean var1) {
      if (this.isFemale != var1) {
         this.method3424((int[])null, this.bodyColors, var1, -1);
      }
   }

   @ObfuscatedName("t")
   @Export("method3405")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   public void method3405(Buffer var1) {
      var1.method2631(this.isFemale ? 1 : 0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipment[equipmentIndices[var2]];
         if (var3 == 0) {
            var1.method2631(-1);
         } else {
            var1.method2631(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2631(this.bodyColors[var2]);
      }

   }

   @ObfuscatedName("d")
   @Export("method3406")
   void method3406() {
      long var1 = this.hash;
      int var3 = this.equipment[5];
      int var4 = this.equipment[9];
      this.equipment[5] = var4;
      this.equipment[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if (this.equipment[var5] >= 256) {
            this.hash += (long)(this.equipment[var5] - 256);
         }
      }

      if (this.equipment[0] >= 256) {
         this.hash += (long)(this.equipment[0] - 256 >> 4);
      }

      if (this.equipment[1] >= 256) {
         this.hash += (long)(this.equipment[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyColors[var5];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale ? 1 : 0);
      this.equipment[5] = var3;
      this.equipment[9] = var4;
      if (0L != var1 && var1 != this.hash) {
         Widget_cachedSprites.method3475(var1);
      }

   }

   @ObfuscatedName("p")
   @Export("method3407")
   @ObfuscatedSignature(
      descriptor = "(Lclass33;ILclass33;I)Lclass111;"
   )
   public Model method3407(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
      if (this.npcTransformId != -1) {
         return class22.method247(this.npcTransformId).method643(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipment;
         if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.equipment[var8];
            }

            if (var1.shield >= 0) {
               var5 += (long)(var1.shield - this.equipment[5] << 40);
               var7[5] = var1.shield;
            }

            if (var1.weapon >= 0) {
               var5 += (long)(var1.weapon - this.equipment[3] << 48);
               var7[3] = var1.weapon;
            }
         }

         Model var15 = (Model)Widget_cachedSprites.method3474(var5);
         if (var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if (var11 >= 256 && var11 < 512 && !class65.method1455(var11 - 256).method779()) {
                  var9 = true;
               }

               if (var11 >= 512 && !class27.method571(var11 - 512).method862(this.isFemale)) {
                  var9 = true;
               }
            }

            if (var9) {
               if (this.field2712 != -1L) {
                  var15 = (Model)Widget_cachedSprites.method3474(this.field2712);
               }

               if (var15 == null) {
                  return null;
               }
            }

            if (var15 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if (var13 >= 256 && var13 < 512) {
                     var14 = class65.method1455(var13 - 256).method787();
                     if (var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if (var13 >= 512) {
                     var14 = class27.method571(var13 - 512).method860(this.isFemale);
                     if (var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var17 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if (this.bodyColors[var13] < Skeleton.field1792[var13].length) {
                     var17.method2234(field2718[var13], Skeleton.field1792[var13][this.bodyColors[var13]]);
                  }

                  if (this.bodyColors[var13] < Script.field60[var13].length) {
                     var17.method2234(field2716[var13], Script.field60[var13][this.bodyColors[var13]]);
                  }
               }

               var15 = var17.method2282(64, 850, -30, -50, -30);
               Widget_cachedSprites.method3473(var15, var5);
               this.field2712 = var5;
            }
         }

         if (var1 == null && var3 == null) {
            return var15;
         } else {
            Model var18;
            if (var1 != null && var3 != null) {
               var18 = var1.method728(var15, var2, var3, var4);
            } else if (var1 != null) {
               var18 = var1.method735(var15, var2);
            } else {
               var18 = var3.method735(var15, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("k")
   @Export("method3408")
   @ObfuscatedSignature(
      descriptor = "()Lclass100;"
   )
   ModelData method3408() {
      if (this.npcTransformId != -1) {
         return class22.method247(this.npcTransformId).method632();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipment[var2];
            if (var3 >= 256 && var3 < 512 && !class65.method1455(var3 - 256).method784()) {
               var1 = true;
            }

            if (var3 >= 512 && !class27.method571(var3 - 512).method864(this.isFemale)) {
               var1 = true;
            }
         }

         if (var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipment[var4];
               ModelData var6;
               if (var5 >= 256 && var5 < 512) {
                  var6 = class65.method1455(var5 - 256).method780();
                  if (var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if (var5 >= 512) {
                  var6 = class27.method571(var5 - 512).method865(this.isFemale);
                  if (var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if (this.bodyColors[var5] < Skeleton.field1792[var5].length) {
                  var8.method2234(field2718[var5], Skeleton.field1792[var5][this.bodyColors[var5]]);
               }

               if (this.bodyColors[var5] < Script.field60[var5].length) {
                  var8.method2234(field2716[var5], Script.field60[var5][this.bodyColors[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("r")
   @Export("method3401")
   public int method3401() {
      return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + class22.method247(this.npcTransformId).id;
   }
}
