import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("dj")
   static int field478;
   @ObfuscatedName("n")
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @Export("y")
   int y;
   @ObfuscatedName("c")
   int field432;
   @ObfuscatedName("h")
   @Export("isWalking")
   boolean isWalking = false;
   @ObfuscatedName("b")
   int field461 = 1;
   @ObfuscatedName("y")
   @Export("idleSequence")
   int idleSequence = -1;
   @ObfuscatedName("x")
   @Export("turnLeftSequence")
   int turnLeftSequence = -1;
   @ObfuscatedName("ao")
   @Export("turnRightSequence")
   int turnRightSequence = -1;
   @ObfuscatedName("ae")
   @Export("walkSequence")
   int walkSequence = -1;
   @ObfuscatedName("aa")
   @Export("walkBackSequence")
   int walkBackSequence = -1;
   @ObfuscatedName("ah")
   @Export("walkLeftSequence")
   int walkLeftSequence = -1;
   @ObfuscatedName("aw")
   @Export("walkRightSequence")
   int walkRightSequence = -1;
   @ObfuscatedName("an")
   @Export("runSequence")
   int runSequence = -1;
   @ObfuscatedName("av")
   String field434 = null;
   @ObfuscatedName("ak")
   int field435 = 100;
   @ObfuscatedName("ax")
   int field436 = 0;
   @ObfuscatedName("ab")
   int field445 = 0;
   @ObfuscatedName("ai")
   @Export("hitSplatTypes")
   int[] hitSplatTypes = new int[4];
   @ObfuscatedName("at")
   @Export("hitSplatValues")
   int[] hitSplatValues = new int[4];
   @ObfuscatedName("aq")
   @Export("hitSplatCycles")
   int[] hitSplatCycles = new int[4];
   @ObfuscatedName("ac")
   int field441 = -1000;
   @ObfuscatedName("al")
   int field431;
   @ObfuscatedName("ag")
   int field425;
   @ObfuscatedName("ap")
   int field444 = -1;
   @ObfuscatedName("am")
   int field475 = 0;
   @ObfuscatedName("as")
   int field446 = 0;
   @ObfuscatedName("aj")
   @Export("movementSequence")
   int movementSequence = -1;
   @ObfuscatedName("ar")
   @Export("movementFrame")
   int movementFrame = 0;
   @ObfuscatedName("au")
   int field449 = 0;
   @ObfuscatedName("ad")
   @Export("sequence")
   int sequence = -1;
   @ObfuscatedName("az")
   @Export("sequenceFrame")
   int sequenceFrame = 0;
   @ObfuscatedName("ay")
   @Export("sequenceFrameCycle")
   int sequenceFrameCycle = 0;
   @ObfuscatedName("bh")
   @Export("sequenceDelay")
   int sequenceDelay = 0;
   @ObfuscatedName("ba")
   int field421 = 0;
   @ObfuscatedName("bn")
   @Export("spotAnimation")
   int spotAnimation = -1;
   @ObfuscatedName("bj")
   @Export("spotAnimationFrame")
   int spotAnimationFrame = 0;
   @ObfuscatedName("bu")
   @Export("spotAnimationFrameCycle")
   int spotAnimationFrameCycle = 0;
   @ObfuscatedName("br")
   int field458;
   @ObfuscatedName("bd")
   int field430;
   @ObfuscatedName("bf")
   int field460;
   @ObfuscatedName("bg")
   int field439;
   @ObfuscatedName("bp")
   int field462;
   @ObfuscatedName("bb")
   int field463;
   @ObfuscatedName("bc")
   int field456;
   @ObfuscatedName("by")
   int field465;
   @ObfuscatedName("bw")
   int field466;
   @ObfuscatedName("bm")
   int field467 = 0;
   @ObfuscatedName("bz")
   @Export("defaultHeight")
   int defaultHeight = 200;
   @ObfuscatedName("bv")
   @Export("orientation")
   int orientation;
   @ObfuscatedName("bq")
   int field470 = 0;
   @ObfuscatedName("bk")
   int field471 = 32;
   @ObfuscatedName("bo")
   @Export("pathLength")
   int pathLength = 0;
   @ObfuscatedName("bs")
   @Export("hitSplatTypes2")
   int[] hitSplatTypes2 = new int[10];
   @ObfuscatedName("bx")
   @Export("hitSplatValues2")
   int[] hitSplatValues2 = new int[10];
   @ObfuscatedName("bl")
   boolean[] field459 = new boolean[10];
   @ObfuscatedName("be")
   int field476 = 0;
   @ObfuscatedName("bi")
   int field472 = 0;

   @ObfuscatedName("f")
   @Export("vmethod281")
   boolean vmethod281() {
      return false;
   }

   @ObfuscatedName("a")
   final void method290(int var1, int var2, boolean var3) {
      if (this.sequence != -1 && class23.method250(this.sequence).field900 == 1) {
         this.sequence = -1;
      }

      if (!var3) {
         int var4 = var1 - this.hitSplatTypes2[0];
         int var5 = var2 - this.hitSplatValues2[0];
         if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if (this.pathLength < 9) {
               ++this.pathLength;
            }

            for(int var6 = this.pathLength; var6 > 0; --var6) {
               this.hitSplatTypes2[var6] = this.hitSplatTypes2[var6 - 1];
               this.hitSplatValues2[var6] = this.hitSplatValues2[var6 - 1];
               this.field459[var6] = this.field459[var6 - 1];
            }

            this.hitSplatTypes2[0] = var1;
            this.hitSplatValues2[0] = var2;
            this.field459[0] = false;
            return;
         }
      }

      this.pathLength = 0;
      this.field472 = 0;
      this.field476 = 0;
      this.hitSplatTypes2[0] = var1;
      this.hitSplatValues2[0] = var2;
      this.x = this.hitSplatTypes2[0] * 128 + this.field461 * 64;
      this.y = this.hitSplatValues2[0] * 128 + this.field461 * 64;
   }

   @ObfuscatedName("z")
   final void method279(int var1, boolean var2) {
      int var3 = this.hitSplatTypes2[0];
      int var4 = this.hitSplatValues2[0];
      if (var1 == 0) {
         --var3;
         ++var4;
      }

      if (var1 == 1) {
         ++var4;
      }

      if (var1 == 2) {
         ++var3;
         ++var4;
      }

      if (var1 == 3) {
         --var3;
      }

      if (var1 == 4) {
         ++var3;
      }

      if (var1 == 5) {
         --var3;
         --var4;
      }

      if (var1 == 6) {
         --var4;
      }

      if (var1 == 7) {
         ++var3;
         --var4;
      }

      if (this.sequence != -1 && class23.method250(this.sequence).field900 == 1) {
         this.sequence = -1;
      }

      if (this.pathLength < 9) {
         ++this.pathLength;
      }

      for(int var5 = this.pathLength; var5 > 0; --var5) {
         this.hitSplatTypes2[var5] = this.hitSplatTypes2[var5 - 1];
         this.hitSplatValues2[var5] = this.hitSplatValues2[var5 - 1];
         this.field459[var5] = this.field459[var5 - 1];
      }

      this.hitSplatTypes2[0] = var3;
      this.hitSplatValues2[0] = var4;
      this.field459[0] = var2;
   }

   @ObfuscatedName("s")
   @Export("method280")
   final void method280() {
      this.pathLength = 0;
      this.field472 = 0;
   }

   @ObfuscatedName("m")
   final void method277(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < 4; ++var4) {
         if (this.hitSplatCycles[var4] <= var3) {
            this.hitSplatTypes[var4] = var1;
            this.hitSplatValues[var4] = var2;
            this.hitSplatCycles[var4] = var3 + 70;
            return;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IIIIIILclass94;Lclass163;)V"
   )
   static final void method295(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
      if (Client.isLowDetail && (Tiles.Tiles_renderFlags[0][var1][var2] & 2) == 0) {
         if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 16) != 0) {
            return;
         }

         int var8;
         if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 8) != 0) {
            var8 = 0;
         } else if (var0 > 0 && (Tiles.Tiles_renderFlags[1][var1][var2] & 2) != 0) {
            var8 = var0 - 1;
         } else {
            var8 = var0;
         }

         if (var8 != Client.field531) {
            return;
         }
      }

      if (var0 < Tiles.Tiles_minPlane) {
         Tiles.Tiles_minPlane = var0;
      }

      ObjectComposition var26 = GameBuild.getObjectComposition(var3);
      int var9;
      int var10;
      if (var4 != 1 && var4 != 3) {
         var9 = var26.sizeX;
         var10 = var26.sizeY;
      } else {
         var9 = var26.sizeY;
         var10 = var26.sizeX;
      }

      int var11;
      int var12;
      if (var9 + var1 <= 104) {
         var11 = (var9 >> 1) + var1;
         var12 = (var9 + 1 >> 1) + var1;
      } else {
         var11 = var1;
         var12 = var1 + 1;
      }

      int var13;
      int var14;
      if (var10 + var2 <= 104) {
         var13 = (var10 >> 1) + var2;
         var14 = var2 + (var10 + 1 >> 1);
      } else {
         var13 = var2;
         var14 = var2 + 1;
      }

      int[][] var15 = Tiles.Tiles_heights[var0];
      int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
      int var17 = (var1 << 7) + (var9 << 6);
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
      if (var26.int1 == 0) {
         var19 -= Integer.MIN_VALUE;
      }

      int var20 = var5 + (var4 << 6);
      if (var26.int3 == 1) {
         var20 += 256;
      }

      if (var26.method668()) {
         SoundSystem.method1324(var0, var1, var2, var26, var4);
      }

      Object var27;
      if (var5 == 22) {
         if (!Client.isLowDetail || var26.int1 != 0 || var26.interactType == 1 || var26.boolean2) {
            if (var26.animationId == -1 && var26.transforms == null) {
               var27 = var26.method669(22, var4, var15, var17, var16, var18);
            } else {
               var27 = new DynamicObject(var3, 22, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
            }

            var6.method2048(var0, var1, var2, var16, (Renderable)var27, var19, var20);
            if (var26.interactType == 1 && var7 != null) {
               var7.method3430(var1, var2);
            }

         }
      } else {
         int var22;
         if (var5 != 10 && var5 != 11) {
            if (var5 >= 12) {
               if (var26.animationId == -1 && var26.transforms == null) {
                  var27 = var26.method669(var5, var4, var15, var17, var16, var18);
               } else {
                  var27 = new DynamicObject(var3, var5, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
               }

               var6.method2042(var0, var1, var2, var16, 1, 1, (Renderable)var27, 0, var19, var20);
               if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  VertexNormal.field1510[var0][var1][var2] |= 2340;
               }

               if (var26.interactType != 0 && var7 != null) {
                  var7.method3428(var1, var2, var9, var10, var26.boolean1);
               }

            } else if (var5 == 0) {
               if (var26.animationId == -1 && var26.transforms == null) {
                  var27 = var26.method669(0, var4, var15, var17, var16, var18);
               } else {
                  var27 = new DynamicObject(var3, 0, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
               }

               var6.method2049(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, Tiles.field124[var4], 0, var19, var20);
               if (var4 == 0) {
                  if (var26.clipped) {
                     Tiles.field132[var0][var1][var2] = 50;
                     Tiles.field132[var0][var1][var2 + 1] = 50;
                  }

                  if (var26.modelClipped) {
                     VertexNormal.field1510[var0][var1][var2] |= 585;
                  }
               } else if (var4 == 1) {
                  if (var26.clipped) {
                     Tiles.field132[var0][var1][var2 + 1] = 50;
                     Tiles.field132[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if (var26.modelClipped) {
                     VertexNormal.field1510[var0][var1][1 + var2] |= 1170;
                  }
               } else if (var4 == 2) {
                  if (var26.clipped) {
                     Tiles.field132[var0][var1 + 1][var2] = 50;
                     Tiles.field132[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if (var26.modelClipped) {
                     VertexNormal.field1510[var0][var1 + 1][var2] |= 585;
                  }
               } else if (var4 == 3) {
                  if (var26.clipped) {
                     Tiles.field132[var0][var1][var2] = 50;
                     Tiles.field132[var0][var1 + 1][var2] = 50;
                  }

                  if (var26.modelClipped) {
                     VertexNormal.field1510[var0][var1][var2] |= 1170;
                  }
               }

               if (var26.interactType != 0 && var7 != null) {
                  var7.method3427(var1, var2, var5, var4, var26.boolean1);
               }

               if (var26.int2 != 16) {
                  var6.method2161(var0, var1, var2, var26.int2);
               }

            } else if (var5 == 1) {
               if (var26.animationId == -1 && var26.transforms == null) {
                  var27 = var26.method669(1, var4, var15, var17, var16, var18);
               } else {
                  var27 = new DynamicObject(var3, 1, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
               }

               var6.method2049(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, Tiles.field125[var4], 0, var19, var20);
               if (var26.clipped) {
                  if (var4 == 0) {
                     Tiles.field132[var0][var1][var2 + 1] = 50;
                  } else if (var4 == 1) {
                     Tiles.field132[var0][var1 + 1][var2 + 1] = 50;
                  } else if (var4 == 2) {
                     Tiles.field132[var0][var1 + 1][var2] = 50;
                  } else if (var4 == 3) {
                     Tiles.field132[var0][var1][var2] = 50;
                  }
               }

               if (var26.interactType != 0 && var7 != null) {
                  var7.method3427(var1, var2, var5, var4, var26.boolean1);
               }

            } else {
               int var21;
               Object var23;
               if (var5 == 2) {
                  var21 = var4 + 1 & 3;
                  Object var28;
                  if (var26.animationId == -1 && var26.transforms == null) {
                     var28 = var26.method669(2, var4 + 4, var15, var17, var16, var18);
                     var23 = var26.method669(2, var21, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                     var23 = new DynamicObject(var3, 2, var21, var0, var1, var2, var26.animationId, true, (Renderable)null);
                  }

                  var6.method2049(var0, var1, var2, var16, (Renderable)var28, (Renderable)var23, Tiles.field124[var4], Tiles.field124[var21], var19, var20);
                  if (var26.modelClipped) {
                     if (var4 == 0) {
                        VertexNormal.field1510[var0][var1][var2] |= 585;
                        VertexNormal.field1510[var0][var1][var2 + 1] |= 1170;
                     } else if (var4 == 1) {
                        VertexNormal.field1510[var0][var1][1 + var2] |= 1170;
                        VertexNormal.field1510[var0][var1 + 1][var2] |= 585;
                     } else if (var4 == 2) {
                        VertexNormal.field1510[var0][var1 + 1][var2] |= 585;
                        VertexNormal.field1510[var0][var1][var2] |= 1170;
                     } else if (var4 == 3) {
                        VertexNormal.field1510[var0][var1][var2] |= 1170;
                        VertexNormal.field1510[var0][var1][var2] |= 585;
                     }
                  }

                  if (var26.interactType != 0 && var7 != null) {
                     var7.method3427(var1, var2, var5, var4, var26.boolean1);
                  }

                  if (var26.int2 != 16) {
                     var6.method2161(var0, var1, var2, var26.int2);
                  }

               } else if (var5 == 3) {
                  if (var26.animationId == -1 && var26.transforms == null) {
                     var27 = var26.method669(3, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 3, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                  }

                  var6.method2049(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, Tiles.field125[var4], 0, var19, var20);
                  if (var26.clipped) {
                     if (var4 == 0) {
                        Tiles.field132[var0][var1][var2 + 1] = 50;
                     } else if (var4 == 1) {
                        Tiles.field132[var0][var1 + 1][var2 + 1] = 50;
                     } else if (var4 == 2) {
                        Tiles.field132[var0][var1 + 1][var2] = 50;
                     } else if (var4 == 3) {
                        Tiles.field132[var0][var1][var2] = 50;
                     }
                  }

                  if (var26.interactType != 0 && var7 != null) {
                     var7.method3427(var1, var2, var5, var4, var26.boolean1);
                  }

               } else if (var5 == 9) {
                  if (var26.animationId == -1 && var26.transforms == null) {
                     var27 = var26.method669(var5, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, var5, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                  }

                  var6.method2042(var0, var1, var2, var16, 1, 1, (Renderable)var27, 0, var19, var20);
                  if (var26.interactType != 0 && var7 != null) {
                     var7.method3428(var1, var2, var9, var10, var26.boolean1);
                  }

                  if (var26.int2 != 16) {
                     var6.method2161(var0, var1, var2, var26.int2);
                  }

               } else if (var5 == 4) {
                  if (var26.animationId == -1 && var26.transforms == null) {
                     var27 = var26.method669(4, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 4, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                  }

                  var6.method2041(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, Tiles.field124[var4], 0, 0, 0, var19, var20);
               } else if (var5 == 5) {
                  var21 = 16;
                  var22 = var6.method2057(var0, var1, var2);
                  if (var22 != 0) {
                     var21 = GameBuild.getObjectComposition(var22 >> 14 & 32767).int2;
                  }

                  if (var26.animationId == -1 && var26.transforms == null) {
                     var23 = var26.method669(4, var4, var15, var17, var16, var18);
                  } else {
                     var23 = new DynamicObject(var3, 4, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                  }

                  var6.method2041(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, Tiles.field124[var4], 0, var21 * Tiles.field115[var4], var21 * Tiles.field127[var4], var19, var20);
               } else if (var5 == 6) {
                  var21 = 8;
                  var22 = var6.method2057(var0, var1, var2);
                  if (var22 != 0) {
                     var21 = GameBuild.getObjectComposition(var22 >> 14 & 32767).int2 / 2;
                  }

                  if (var26.animationId == -1 && var26.transforms == null) {
                     var23 = var26.method669(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var23 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                  }

                  var6.method2041(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, var21 * Tiles.field128[var4], var21 * Tiles.field134[var4], var19, var20);
               } else if (var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if (var26.animationId == -1 && var26.transforms == null) {
                     var27 = var26.method669(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                  }

                  var6.method2041(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if (var5 == 8) {
                  var21 = 8;
                  var22 = var6.method2057(var0, var1, var2);
                  if (var22 != 0) {
                     var21 = GameBuild.getObjectComposition(var22 >> 14 & 32767).int2 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var24;
                  if (var26.animationId == -1 && var26.transforms == null) {
                     var23 = var26.method669(4, var4 + 4, var15, var17, var16, var18);
                     var24 = var26.method669(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var23 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                     var24 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var26.animationId, true, (Renderable)null);
                  }

                  var6.method2041(var0, var1, var2, var16, (Renderable)var23, (Renderable)var24, 256, var4, var21 * Tiles.field128[var4], var21 * Tiles.field134[var4], var19, var20);
               }
            }
         } else {
            if (var26.animationId == -1 && var26.transforms == null) {
               var27 = var26.method669(10, var4, var15, var17, var16, var18);
            } else {
               var27 = new DynamicObject(var3, 10, var4, var0, var1, var2, var26.animationId, true, (Renderable)null);
            }

            if (var27 != null && var6.method2042(var0, var1, var2, var16, var9, var10, (Renderable)var27, var5 == 11 ? 256 : 0, var19, var20) && var26.clipped) {
               var22 = 15;
               if (var27 instanceof Model) {
                  var22 = ((Model)var27).method2474() / 4;
                  if (var22 > 30) {
                     var22 = 30;
                  }
               }

               for(int var29 = 0; var29 <= var9; ++var29) {
                  for(int var30 = 0; var30 <= var10; ++var30) {
                     if (var22 > Tiles.field132[var0][var29 + var1][var30 + var2]) {
                        Tiles.field132[var0][var29 + var1][var30 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if (var26.interactType != 0 && var7 != null) {
               var7.method3428(var1, var2, var9, var10, var26.boolean1);
            }

         }
      }
   }

   @ObfuscatedName("be")
   @Export("method297")
   @ObfuscatedSignature(
      descriptor = "(Lclass2;III)V"
   )
   static final void method297(Player var0, int var1, int var2, int var3) {
      if (Tiles.localPlayer != var0) {
         if (Client.menuOptionsCount < 400) {
            String var4;
            int var7;
            if (var0.skillLevel == 0) {
               String var5 = var0.field35;
               var7 = var0.combatLevel;
               int var8 = Tiles.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if (var9 < -9) {
                  var6 = ScriptEvent.method0(16711680);
               } else if (var9 < -6) {
                  var6 = ScriptEvent.method0(16723968);
               } else if (var9 < -3) {
                  var6 = ScriptEvent.method0(16740352);
               } else if (var9 < 0) {
                  var6 = ScriptEvent.method0(16756736);
               } else if (var9 > 9) {
                  var6 = ScriptEvent.method0(65280);
               } else if (var9 > 6) {
                  var6 = ScriptEvent.method0(4259584);
               } else if (var9 > 3) {
                  var6 = ScriptEvent.method0(8453888);
               } else if (var9 > 0) {
                  var6 = ScriptEvent.method0(12648192);
               } else {
                  var6 = ScriptEvent.method0(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
            } else {
               var4 = var0.field35 + " " + " (" + "skill-" + var0.skillLevel + ")";
            }

            int var10;
            if (Client.isItemSelected == 1) {
               ArchiveDisk.method1503("Use", Client.selectedItemName + " " + "->" + " " + ScriptEvent.method0(16777215) + var4, 14, var1, var2, var3);
            } else if (Client.isSpellSelected) {
               if ((FaceNormal.field1523 & 8) == 8) {
                  ArchiveDisk.method1503(Client.field641, Client.field594 + " " + "->" + " " + ScriptEvent.method0(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if (Client.playerMenuActions[var10] != null) {
                     short var11 = 0;
                     if (Client.playerMenuActions[var10].equalsIgnoreCase("Attack")) {
                        if (var0.combatLevel > Tiles.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if (Tiles.localPlayer.team != 0 && var0.team != 0) {
                           if (var0.team == Tiles.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if (Client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuOpcodes[var10] + var11;
                     ArchiveDisk.method1503(Client.playerMenuActions[var10], ScriptEvent.method0(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionsCount; ++var10) {
               if (Client.menuOpcodes[var10] == 23) {
                  Client.menuTargets[var10] = ScriptEvent.method0(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
