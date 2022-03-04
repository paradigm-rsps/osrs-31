import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("KitDefinition")
public class KitDefinition extends DualNode {
   @ObfuscatedName("i")
   @Export("KitDefinition_archive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   static AbstractArchive KitDefinition_archive;
   @ObfuscatedName("w")
   @Export("KitDefinition_modelsArchive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   static AbstractArchive KitDefinition_modelsArchive;
   @ObfuscatedName("f")
   @Export("KitDefinition_fileCount")
   public static int KitDefinition_fileCount;
   @ObfuscatedName("e")
   @Export("KitDefinition_cached")
   @ObfuscatedSignature(
      descriptor = "Lclass169;"
   )
   static EvictingDualNodeHashTable KitDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("t")
   @Export("bodypartID")
   public int bodypartID = -1;
   @ObfuscatedName("d")
   @Export("models2")
   int[] models2;
   @ObfuscatedName("p")
   @Export("recolorFrom")
   short[] recolorFrom;
   @ObfuscatedName("k")
   @Export("recolorTo")
   short[] recolorTo;
   @ObfuscatedName("r")
   @Export("retextureFrom")
   short[] retextureFrom;
   @ObfuscatedName("l")
   @Export("retextureTo")
   short[] retextureTo;
   @ObfuscatedName("a")
   @Export("models")
   int[] models = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("z")
   @Export("nonSelectable")
   public boolean nonSelectable = false;

   @ObfuscatedName("f")
   @Export("method777")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   void method777(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.method778(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @Export("method778")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;I)V"
   )
   void method778(Buffer var1, int var2) {
      if (var2 == 1) {
         this.bodypartID = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if (var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.models2 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.models2[var4] = var1.readUnsignedShort();
            }
         } else if (var2 == 3) {
            this.nonSelectable = true;
         } else if (var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)var1.readUnsignedShort();
               this.recolorTo[var4] = (short)var1.readUnsignedShort();
            }
         } else if (var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)var1.readUnsignedShort();
               this.retextureTo[var4] = (short)var1.readUnsignedShort();
            }
         } else if (var2 >= 60 && var2 < 70) {
            this.models[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("t")
   @Export("method779")
   public boolean method779() {
      if (this.models2 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.models2.length; ++var2) {
            if (!KitDefinition_modelsArchive.method3206(this.models2[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("d")
   @Export("method787")
   @ObfuscatedSignature(
      descriptor = "()Lclass100;"
   )
   public ModelData method787() {
      if (this.models2 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.models2.length];

         for(int var2 = 0; var2 < this.models2.length; ++var2) {
            var1[var2] = ModelData.method2222(KitDefinition_modelsArchive, this.models2[var2], 0);
         }

         ModelData var4;
         if (var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if (this.recolorFrom != null) {
            for(var3 = 0; var3 < this.recolorFrom.length; ++var3) {
               var4.method2234(this.recolorFrom[var3], this.recolorTo[var3]);
            }
         }

         if (this.retextureFrom != null) {
            for(var3 = 0; var3 < this.retextureFrom.length; ++var3) {
               var4.method2236(this.retextureFrom[var3], this.retextureTo[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   public boolean method784() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if (this.models[var2] != -1 && !KitDefinition_modelsArchive.method3206(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @Export("method780")
   @ObfuscatedSignature(
      descriptor = "()Lclass100;"
   )
   public ModelData method780() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if (this.models[var3] != -1) {
            var1[var2++] = ModelData.method2222(KitDefinition_modelsArchive, this.models[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if (this.recolorFrom != null) {
         for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
            var5.method2234(this.recolorFrom[var4], this.recolorTo[var4]);
         }
      }

      if (this.retextureFrom != null) {
         for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
            var5.method2236(this.retextureFrom[var4], this.retextureTo[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("f")
   @Export("method806")
   static void method806(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.method3512((long)var0);
      if (var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.method3517(var4, (long)var0);
      }

      if (var4.ids.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.ids.length; ++var7) {
            var5[var7] = var4.ids[var7];
            var6[var7] = var4.quantities[var7];
         }

         for(var7 = var4.ids.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.ids = var5;
         var4.quantities = var6;
      }

      var4.ids[var1] = var2;
      var4.quantities[var1] = var3;
   }

   @ObfuscatedName("e")
   public static int method805(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;II)Z"
   )
   public static boolean method796(AbstractArchive var0, int var1, int var2) {
      byte[] var3 = var0.method3204(var1, var2);
      if (var3 == null) {
         return false;
      } else {
         PendingSpawn.method245(var3);
         return true;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(Lclass26;)V"
   )
   static final void method803(Actor var0) {
      var0.movementSequence = var0.idleSequence;
      if (var0.pathLength == 0) {
         var0.field476 = 0;
      } else {
         if (var0.sequence != -1 && var0.sequenceDelay == 0) {
            SequenceDefinition var1 = class23.method250(var0.sequence);
            if (var0.field472 > 0 && var1.field899 == 0) {
               ++var0.field476;
               return;
            }

            if (var0.field472 <= 0 && var1.field900 == 0) {
               ++var0.field476;
               return;
            }
         }

         int var9 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field461 * 64 + var0.hitSplatTypes2[var0.pathLength - 1] * 128;
         int var4 = var0.field461 * 64 + var0.hitSplatValues2[var0.pathLength - 1] * 128;
         if (var3 - var9 <= 256 && var3 - var9 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            if (var9 < var3) {
               if (var2 < var4) {
                  var0.orientation = 1280;
               } else if (var2 > var4) {
                  var0.orientation = 1792;
               } else {
                  var0.orientation = 1536;
               }
            } else if (var9 > var3) {
               if (var2 < var4) {
                  var0.orientation = 768;
               } else if (var2 > var4) {
                  var0.orientation = 256;
               } else {
                  var0.orientation = 512;
               }
            } else if (var2 < var4) {
               var0.orientation = 1024;
            } else if (var2 > var4) {
               var0.orientation = 0;
            }

            int var5 = var0.orientation - var0.field432 & 2047;
            if (var5 > 1024) {
               var5 -= 2048;
            }

            int var6 = var0.walkBackSequence;
            if (var5 >= -256 && var5 <= 256) {
               var6 = var0.walkSequence;
            } else if (var5 >= 256 && var5 < 768) {
               var6 = var0.walkRightSequence;
            } else if (var5 >= -768 && var5 <= -256) {
               var6 = var0.walkLeftSequence;
            }

            if (var6 == -1) {
               var6 = var0.walkSequence;
            }

            var0.movementSequence = var6;
            int var7 = 4;
            boolean var8 = true;
            if (var0 instanceof NPC) {
               var8 = ((NPC)var0).definition.field803;
            }

            if (var8) {
               if (var0.field432 != var0.orientation && var0.field444 == -1 && var0.field471 != 0) {
                  var7 = 2;
               }

               if (var0.pathLength > 2) {
                  var7 = 6;
               }

               if (var0.pathLength > 3) {
                  var7 = 8;
               }

               if (var0.field476 > 0 && var0.pathLength > 1) {
                  var7 = 8;
                  --var0.field476;
               }
            } else {
               if (var0.pathLength > 1) {
                  var7 = 6;
               }

               if (var0.pathLength > 2) {
                  var7 = 8;
               }

               if (var0.field476 > 0 && var0.pathLength > 1) {
                  var7 = 8;
                  --var0.field476;
               }
            }

            if (var0.field459[var0.pathLength - 1]) {
               var7 <<= 1;
            }

            if (var7 >= 8 && var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
               var0.movementSequence = var0.runSequence;
            }

            if (var9 < var3) {
               var0.x += var7;
               if (var0.x > var3) {
                  var0.x = var3;
               }
            } else if (var9 > var3) {
               var0.x -= var7;
               if (var0.x < var3) {
                  var0.x = var3;
               }
            }

            if (var2 < var4) {
               var0.y += var7;
               if (var0.y > var4) {
                  var0.y = var4;
               }
            } else if (var2 > var4) {
               var0.y -= var7;
               if (var0.y < var4) {
                  var0.y = var4;
               }
            }

            if (var3 == var0.x && var4 == var0.y) {
               --var0.pathLength;
               if (var0.field472 > 0) {
                  --var0.field472;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
         }
      }
   }
}
