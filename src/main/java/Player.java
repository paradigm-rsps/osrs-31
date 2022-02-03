import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("i")
   String field35;
   @ObfuscatedName("w")
   @Export("appearance")
   @ObfuscatedSignature(
      descriptor = "Lclass162;"
   )
   PlayerComposition appearance;
   @ObfuscatedName("f")
   @Export("headIconPk")
   int headIconPk = -1;
   @ObfuscatedName("e")
   @Export("headIconPrayer")
   int headIconPrayer = -1;
   @ObfuscatedName("t")
   @Export("combatLevel")
   int combatLevel = 0;
   @ObfuscatedName("d")
   @Export("skillLevel")
   int skillLevel = 0;
   @ObfuscatedName("p")
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("k")
   @Export("animationCycleStart")
   int animationCycleStart = 0;
   @ObfuscatedName("r")
   @Export("animationCycleEnd")
   int animationCycleEnd = 0;
   @ObfuscatedName("l")
   int field34;
   @ObfuscatedName("a")
   @Export("tileHeight2")
   int tileHeight2;
   @ObfuscatedName("z")
   int field42;
   @ObfuscatedName("s")
   @Export("model0")
   @ObfuscatedSignature(
      descriptor = "Lclass111;"
   )
   Model model0;
   @ObfuscatedName("m")
   int field44;
   @ObfuscatedName("u")
   int field38;
   @ObfuscatedName("g")
   int field46;
   @ObfuscatedName("o")
   int field47;
   @ObfuscatedName("v")
   @Export("isUnanimated")
   boolean isUnanimated = false;
   @ObfuscatedName("j")
   @Export("team")
   int team = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   final void method17(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method2665();
      this.headIconPk = var1.method2646();
      this.headIconPrayer = var1.method2646();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2665();
         if (var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2665();
            var4[var5] = var7 + (var6 << 8);
            if (var5 == 0 && var4[0] == 65535) {
               var3 = var1.readUnsignedShort();
               break;
            }

            if (var4[var5] >= 512) {
               int var8 = class27.method571(var4[var5] - 512).team;
               if (var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2665();
         if (var7 < 0 || var7 >= Skeleton.field1792[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idleSequence = var1.readUnsignedShort();
      if (super.idleSequence == 65535) {
         super.idleSequence = -1;
      }

      super.turnLeftSequence = var1.readUnsignedShort();
      if (super.turnLeftSequence == 65535) {
         super.turnLeftSequence = -1;
      }

      super.turnRightSequence = super.turnLeftSequence;
      super.walkSequence = var1.readUnsignedShort();
      if (super.walkSequence == 65535) {
         super.walkSequence = -1;
      }

      super.walkBackSequence = var1.readUnsignedShort();
      if (super.walkBackSequence == 65535) {
         super.walkBackSequence = -1;
      }

      super.walkLeftSequence = var1.readUnsignedShort();
      if (super.walkLeftSequence == 65535) {
         super.walkLeftSequence = -1;
      }

      super.walkRightSequence = var1.readUnsignedShort();
      if (super.walkRightSequence == 65535) {
         super.walkRightSequence = -1;
      }

      super.runSequence = var1.readUnsignedShort();
      if (super.runSequence == 65535) {
         super.runSequence = -1;
      }

      this.field35 = var1.method2653();
      if (this == Tiles.localPlayer) {
         RunException.field1413 = this.field35;
      }

      this.combatLevel = var1.method2665();
      this.skillLevel = var1.readUnsignedShort();
      if (this.appearance == null) {
         this.appearance = new PlayerComposition();
      }

      this.appearance.setPlayerAppearance(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("w")
   @Export("vmethod2030")
   @ObfuscatedSignature(
      descriptor = "()Lclass111;"
   )
   protected final Model vmethod2030() {
      if (this.appearance == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? class23.method250(super.sequence) : null;
         SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.movementSequence == super.idleSequence && var1 != null ? null : class23.method250(super.movementSequence);
         Model var3 = this.appearance.method3407(var1, super.sequenceFrame, var2, super.movementFrame);
         if (var3 == null) {
            return null;
         } else {
            var3.method2427();
            super.defaultHeight = var3.height;
            Model var4;
            Model[] var5;
            if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
               var4 = NPCComposition.method656(super.spotAnimation).method766(super.spotAnimationFrame);
               if (var4 != null) {
                  var4.method2451(0, -super.field430, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if (!this.isUnanimated && this.model0 != null) {
               if (Client.cycle >= this.animationCycleEnd) {
                  this.model0 = null;
               }

               if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
                  var4 = this.model0;
                  var4.method2451(this.field34 - super.x, this.tileHeight2 - this.tileHeight, this.field42 - super.y);
                  if (super.orientation == 512) {
                     var4.method2488();
                     var4.method2488();
                     var4.method2488();
                  } else if (super.orientation == 1024) {
                     var4.method2488();
                     var4.method2488();
                  } else if (super.orientation == 1536) {
                     var4.method2488();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if (super.orientation == 512) {
                     var4.method2488();
                  } else if (super.orientation == 1024) {
                     var4.method2488();
                     var4.method2488();
                  } else if (super.orientation == 1536) {
                     var4.method2488();
                     var4.method2488();
                     var4.method2488();
                  }

                  var4.method2451(super.x - this.field34, this.tileHeight - this.tileHeight2, super.y - this.field42);
               }
            }

            var3.isSingleTile = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("f")
   @Export("vmethod281")
   final boolean vmethod281() {
      return this.appearance != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Ljava/lang/String;Ljava/lang/String;IZ)V"
   )
   public static void method23(AbstractArchive var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3219(var1);
      int var6 = var0.method3238(var5, var2);
      class161.method3399(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("d")
   @Export("method26")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;IIIIII)V"
   )
   static final void method26(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2665();
            if (var7 == 0) {
               if (var1 == 0) {
                  Tiles.Tiles_heights[0][var2][var3] = -class1.method11(var2 + 932731 + var4, var5 + var3 + 556238) * 8;
               } else {
                  Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if (var7 == 1) {
               int var8 = var0.method2665();
               if (var8 == 1) {
                  var8 = 0;
               }

               if (var1 == 0) {
                  Tiles.Tiles_heights[0][var2][var3] = -var8 * 8;
               } else {
                  Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if (var7 <= 49) {
               VarpDefinition.Tiles_overlays[var1][var2][var3] = var0.method2646();
               Tiles.Tiles_shapes[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class123.field2031[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if (var7 <= 81) {
               Tiles.Tiles_renderFlags[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               Tiles.Tiles_underlays[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2665();
            if (var7 == 0) {
               break;
            }

            if (var7 == 1) {
               var0.method2665();
               break;
            }

            if (var7 <= 49) {
               var0.method2665();
            }
         }
      }

   }
}
