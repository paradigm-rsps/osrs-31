import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
   @ObfuscatedName("f")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("e")
   @Export("width")
   int width;
   @ObfuscatedName("t")
   @Export("height")
   int height;
   @ObfuscatedName("d")
   Image field1458;

   @ObfuscatedName("i")
   abstract void vmethod1940(int var1, int var2, Component var3);

   @ObfuscatedName("w")
   public abstract void vmethod1945(Graphics var1, int var2, int var3);

   @ObfuscatedName("f")
   public abstract void vmethod1941(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("av")
   @Export("method1822")
   public final void method1822() {
      Rasterizer2D.method1951(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Lclass151;)V"
   )
   public static void method1799(AbstractArchive var0, AbstractArchive var1) {
      NPCComposition.NpcDefinition_archive = var0;
      NPCComposition.NpcDefinition_modelArchive = var1;
   }

   @ObfuscatedName("f")
   @Export("method1820")
   public static int method1820(int var0) {
      int var1 = 0;
      if (var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if (var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if (var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if (var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if (var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIILclass94;Lclass163;)V"
   )
   static final void method1819(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Scene var7, CollisionMap var8) {
      ObjectComposition var9 = GameBuild.getObjectComposition(var4);
      int var10;
      int var11;
      if (var5 != 1 && var5 != 3) {
         var10 = var9.sizeX;
         var11 = var9.sizeY;
      } else {
         var10 = var9.sizeY;
         var11 = var9.sizeX;
      }

      int var12;
      int var13;
      if (var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if (var3 + var11 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (var11 + 1 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = Tiles.Tiles_heights[var1];
      int var17 = var16[var12][var15] + var16[var13][var14] + var16[var12][var14] + var16[var13][var15] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if (var9.int1 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if (var9.int3 == 1) {
         var21 += 256;
      }

      Object var27;
      if (var6 == 22) {
         if (var9.animationId == -1 && var9.transforms == null) {
            var27 = var9.method664(22, var5, var16, var18, var17, var19);
         } else {
            var27 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.method2048(var0, var2, var3, var17, (Renderable)var27, var20, var21);
         if (var9.interactType == 1) {
            var8.method3430(var2, var3);
         }

      } else if (var6 != 10 && var6 != 11) {
         if (var6 >= 12) {
            if (var9.animationId == -1 && var9.transforms == null) {
               var27 = var9.method664(var6, var5, var16, var18, var17, var19);
            } else {
               var27 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2042(var0, var2, var3, var17, 1, 1, (Renderable)var27, 0, var20, var21);
            if (var9.interactType != 0) {
               var8.method3428(var2, var3, var10, var11, var9.boolean1);
            }

         } else if (var6 == 0) {
            if (var9.animationId == -1 && var9.transforms == null) {
               var27 = var9.method664(0, var5, var16, var18, var17, var19);
            } else {
               var27 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2049(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, Tiles.field124[var5], 0, var20, var21);
            if (var9.interactType != 0) {
               var8.method3427(var2, var3, var6, var5, var9.boolean1);
            }

         } else if (var6 == 1) {
            if (var9.animationId == -1 && var9.transforms == null) {
               var27 = var9.method664(1, var5, var16, var18, var17, var19);
            } else {
               var27 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2049(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, Tiles.field125[var5], 0, var20, var21);
            if (var9.interactType != 0) {
               var8.method3427(var2, var3, var6, var5, var9.boolean1);
            }

         } else {
            int var22;
            Object var24;
            if (var6 == 2) {
               var22 = var5 + 1 & 3;
               Object var28;
               if (var9.animationId == -1 && var9.transforms == null) {
                  var28 = var9.method664(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method664(2, var22, var16, var18, var17, var19);
               } else {
                  var28 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new DynamicObject(var4, 2, var22, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2049(var0, var2, var3, var17, (Renderable)var28, (Renderable)var24, Tiles.field124[var5], Tiles.field124[var22], var20, var21);
               if (var9.interactType != 0) {
                  var8.method3427(var2, var3, var6, var5, var9.boolean1);
               }

            } else if (var6 == 3) {
               if (var9.animationId == -1 && var9.transforms == null) {
                  var27 = var9.method664(3, var5, var16, var18, var17, var19);
               } else {
                  var27 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2049(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, Tiles.field125[var5], 0, var20, var21);
               if (var9.interactType != 0) {
                  var8.method3427(var2, var3, var6, var5, var9.boolean1);
               }

            } else if (var6 == 9) {
               if (var9.animationId == -1 && var9.transforms == null) {
                  var27 = var9.method664(var6, var5, var16, var18, var17, var19);
               } else {
                  var27 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2042(var0, var2, var3, var17, 1, 1, (Renderable)var27, 0, var20, var21);
               if (var9.interactType != 0) {
                  var8.method3428(var2, var3, var10, var11, var9.boolean1);
               }

            } else if (var6 == 4) {
               if (var9.animationId == -1 && var9.transforms == null) {
                  var27 = var9.method664(4, var5, var16, var18, var17, var19);
               } else {
                  var27 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2041(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, Tiles.field124[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if (var6 == 5) {
                  var22 = 16;
                  var23 = var7.method2057(var0, var2, var3);
                  if (var23 != 0) {
                     var22 = GameBuild.getObjectComposition(var23 >> 14 & 32767).int2;
                  }

                  if (var9.animationId == -1 && var9.transforms == null) {
                     var24 = var9.method664(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method2041(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, Tiles.field124[var5], 0, var22 * Tiles.field115[var5], var22 * Tiles.field127[var5], var20, var21);
               } else if (var6 == 6) {
                  var22 = 8;
                  var23 = var7.method2057(var0, var2, var3);
                  if (var23 != 0) {
                     var22 = GameBuild.getObjectComposition(var23 >> 14 & 32767).int2 / 2;
                  }

                  if (var9.animationId == -1 && var9.transforms == null) {
                     var24 = var9.method664(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method2041(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var22 * Tiles.field128[var5], var22 * Tiles.field134[var5], var20, var21);
               } else if (var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if (var9.animationId == -1 && var9.transforms == null) {
                     var27 = var9.method664(4, var23 + 4, var16, var18, var17, var19);
                  } else {
                     var27 = new DynamicObject(var4, 4, var23 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method2041(var0, var2, var3, var17, (Renderable)var27, (Renderable)null, 256, var23, 0, 0, var20, var21);
               } else if (var6 == 8) {
                  var22 = 8;
                  var23 = var7.method2057(var0, var2, var3);
                  if (var23 != 0) {
                     var22 = GameBuild.getObjectComposition(var23 >> 14 & 32767).int2 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if (var9.animationId == -1 && var9.transforms == null) {
                     var24 = var9.method664(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method664(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new DynamicObject(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method2041(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var22 * Tiles.field128[var5], var22 * Tiles.field134[var5], var20, var21);
               }
            }
         }
      } else {
         if (var9.animationId == -1 && var9.transforms == null) {
            var27 = var9.method664(10, var5, var16, var18, var17, var19);
         } else {
            var27 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if (var27 != null) {
            var7.method2042(var0, var2, var3, var17, var10, var11, (Renderable)var27, var6 == 11 ? 256 : 0, var20, var21);
         }

         if (var9.interactType != 0) {
            var8.method3428(var2, var3, var10, var11, var9.boolean1);
         }

      }
   }

   @ObfuscatedName("bi")
   @Export("method1816")
   @ObfuscatedSignature(
      descriptor = "([Lclass157;IIIIIIII)V"
   )
   static final void method1816(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method1953(var2, var3, var4, var5);
      Rasterizer3D.method2352();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if (var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.clickedWidget)) {
            int var11;
            if (var8 == -1) {
               Client.rootWidgetXs[Client.rootWidgetCount] = var10.rawX + var6;
               Client.rootWidgetYs[Client.rootWidgetCount] = var7 + var10.field2579;
               Client.rootWidgetWidths[Client.rootWidgetCount] = var10.width;
               Client.rootWidgetHeights[Client.rootWidgetCount] = var10.height;
               var11 = ++Client.rootWidgetCount - 1;
            } else {
               var11 = var8;
            }

            var10.rootIndex = var11;
            var10.cycle = Client.cycle;
            if (!var10.isIf3 || !Archive.method3322(var10)) {
               int var12;
               if (var10.contentType > 0) {
                  var12 = var10.contentType;
                  if (var12 == 324) {
                     if (Client.field743 == -1) {
                        Client.field743 = var10.spriteId2;
                        Client.field744 = var10.spriteId;
                     }

                     if (Client.playerAppearance.isFemale) {
                        var10.spriteId2 = Client.field743;
                     } else {
                        var10.spriteId2 = Client.field744;
                     }
                  } else if (var12 == 325) {
                     if (Client.field743 == -1) {
                        Client.field743 = var10.spriteId2;
                        Client.field744 = var10.spriteId;
                     }

                     if (Client.playerAppearance.isFemale) {
                        var10.spriteId2 = Client.field744;
                     } else {
                        var10.spriteId2 = Client.field743;
                     }
                  } else if (var12 == 327) {
                     var10.modelAngleX = 150;
                     var10.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 0;
                  } else if (var12 == 328) {
                     var10.modelAngleX = 150;
                     var10.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 1;
                  }
               }

               var12 = var10.rawX + var6;
               int var13 = var7 + var10.field2579;
               int var14 = var10.field2582;
               int var15;
               int var16;
               if (var10 == Client.clickedWidget) {
                  if (var1 != -1412584499 && !var10.isScrollBar) {
                     Buffer.field2049 = var0;
                     AbstractByteArrayCopier.field2008 = var6;
                     Renderable.field1546 = var7;
                     continue;
                  }

                  if (Client.isDraggingWidget && Client.field659) {
                     var15 = MouseHandler.MouseHandler_x;
                     var16 = MouseHandler.MouseHandler_y;
                     var15 -= Client.widgetClickX;
                     var16 -= Client.widgetClickY;
                     if (var15 < Client.field624) {
                        var15 = Client.field624;
                     }

                     if (var15 + var10.width > Client.field624 + Client.field740.width) {
                        var15 = Client.field624 + Client.field740.width - var10.width;
                     }

                     if (var16 < Client.field661) {
                        var16 = Client.field661;
                     }

                     if (var16 + var10.height > Client.field661 + Client.field740.height) {
                        var16 = Client.field661 + Client.field740.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if (!var10.isScrollBar) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if (var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if (var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if (var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if (var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var19 > var2 ? var19 : var2;
                  var16 = var20 > var3 ? var20 : var3;
                  var17 = var21 < var4 ? var21 : var4;
                  var18 = var22 < var5 ? var22 : var5;
               } else {
                  var19 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2 ? var12 : var2;
                  var16 = var13 > var3 ? var13 : var3;
                  var17 = var19 < var4 ? var19 : var4;
                  var18 = var20 < var5 ? var20 : var5;
               }

               if (!var10.isIf3 || var15 < var17 && var16 < var18) {
                  if (var10.contentType != 0) {
                     if (var10.contentType == 1337) {
                        Client.field633 = var12;
                        Client.field634 = var13;
                        Interpreter.method275(var12, var13, var10.width, var10.height);
                        Rasterizer2D.method1953(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1338) {
                        class82.method1730(var12, var13, var11);
                        Rasterizer2D.method1953(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  var19 = MouseHandler.MouseHandler_x;
                  var20 = MouseHandler.MouseHandler_y;
                  Object var10000;
                  int var23;
                  int var24;
                  String var25;
                  int var26;
                  int var27;
                  int var30;
                  int var31;
                  int var32;
                  int var34;
                  String var38;
                  String var39;
                  int var40;
                  int var54;
                  if (!Client.isMenuOpen && var19 >= var15 && var20 >= var16 && var19 < var17 && var20 < var18) {
                     var21 = var19 - var12;
                     var22 = var20 - var13;
                     if (var10.buttonType == 1) {
                        ArchiveDisk.method1503(var10.field2677, "", 24, 0, 0, var10.id);
                     }

                     if (var10.buttonType == 2 && !Client.isSpellSelected) {
                        var38 = IsaacCipher.method2543(var10);
                        if (var38 != null) {
                           ArchiveDisk.method1503(var38, ScriptEvent.method0(65280) + var10.field2676, 25, 0, -1, var10.id);
                        }
                     }

                     if (var10.buttonType == 3) {
                        ArchiveDisk.method1503("Close", "", 26, 0, 0, var10.id);
                     }

                     if (var10.buttonType == 4) {
                        ArchiveDisk.method1503(var10.field2677, "", 28, 0, 0, var10.id);
                     }

                     if (var10.buttonType == 5) {
                        ArchiveDisk.method1503(var10.field2677, "", 29, 0, 0, var10.id);
                     }

                     if (var10.buttonType == 6 && Client.meslayerContinueWidget == null) {
                        ArchiveDisk.method1503(var10.field2677, "", 30, 0, -1, var10.id);
                     }

                     if (var10.type == 2) {
                        var23 = 0;

                        for(var24 = 0; var24 < var10.height; ++var24) {
                           for(var40 = 0; var40 < var10.width; ++var40) {
                              var26 = var40 * (var10.field2611 + 32);
                              var27 = var24 * (var10.field2652 + 32);
                              if (var23 < 20) {
                                 var26 += var10.field2631[var23];
                                 var27 += var10.field2632[var23];
                              }

                              if (var21 >= var26 && var22 >= var27 && var21 < var26 + 32 && var22 < var27 + 32) {
                                 Client.field655 = var23;
                                 class7.field113 = var10;
                                 if (var10.itemIds[var23] > 0) {
                                    label1286: {
                                       ItemComposition var28 = class27.method571(var10.itemIds[var23] - 1);
                                       boolean var29;
                                       if (Client.isItemSelected == 1) {
                                          var30 = SoundSystem.method1326(var10);
                                          var29 = (var30 >> 30 & 1) != 0;
                                          if (var29) {
                                             if (var10.id != PcmPlayer.selectedItemWidget || var23 != class82.selectedItemSlot) {
                                                ArchiveDisk.method1503("Use", Client.selectedItemName + " " + "->" + " " + ScriptEvent.method0(16748608) + var28.name, 31, var28.id, var23, var10.id);
                                             }
                                             break label1286;
                                          }
                                       }

                                       if (Client.isSpellSelected) {
                                          var30 = SoundSystem.method1326(var10);
                                          var29 = (var30 >> 30 & 1) != 0;
                                          if (var29) {
                                             if ((FaceNormal.field1523 & 16) == 16) {
                                                ArchiveDisk.method1503(Client.field641, Client.field594 + " " + "->" + " " + ScriptEvent.method0(16748608) + var28.name, 32, var28.id, var23, var10.id);
                                             }
                                             break label1286;
                                          }
                                       }

                                       String[] var41 = var28.inventoryActions;
                                       if (Client.field511) {
                                          var41 = Tile.method2299(var41);
                                       }

                                       var31 = SoundSystem.method1326(var10);
                                       boolean var52 = (var31 >> 30 & 1) != 0;
                                       if (var52) {
                                          for(var32 = 4; var32 >= 3; --var32) {
                                             if (var41 != null && var41[var32] != null) {
                                                byte var33;
                                                if (var32 == 3) {
                                                   var33 = 36;
                                                } else {
                                                   var33 = 37;
                                                }

                                                ArchiveDisk.method1503(var41[var32], ScriptEvent.method0(16748608) + var28.name, var33, var28.id, var23, var10.id);
                                             } else if (var32 == 4) {
                                                ArchiveDisk.method1503("Drop", ScriptEvent.method0(16748608) + var28.name, 37, var28.id, var23, var10.id);
                                             }
                                          }
                                       }

                                       var10000 = null;
                                       if (SoundCache.method1356(SoundSystem.method1326(var10))) {
                                          ArchiveDisk.method1503("Use", ScriptEvent.method0(16748608) + var28.name, 38, var28.id, var23, var10.id);
                                       }

                                       var54 = SoundSystem.method1326(var10);
                                       boolean var53 = (var54 >> 30 & 1) != 0;
                                       byte var35;
                                       if (var53 && var41 != null) {
                                          for(var34 = 2; var34 >= 0; --var34) {
                                             if (var41[var34] != null) {
                                                var35 = 0;
                                                if (var34 == 0) {
                                                   var35 = 33;
                                                }

                                                if (var34 == 1) {
                                                   var35 = 34;
                                                }

                                                if (var34 == 2) {
                                                   var35 = 35;
                                                }

                                                ArchiveDisk.method1503(var41[var34], ScriptEvent.method0(16748608) + var28.name, var35, var28.id, var23, var10.id);
                                             }
                                          }
                                       }

                                       var41 = var10.field2602;
                                       if (Client.field511) {
                                          var41 = Tile.method2299(var41);
                                       }

                                       if (var41 != null) {
                                          for(var34 = 4; var34 >= 0; --var34) {
                                             if (var41[var34] != null) {
                                                var35 = 0;
                                                if (var34 == 0) {
                                                   var35 = 39;
                                                }

                                                if (var34 == 1) {
                                                   var35 = 40;
                                                }

                                                if (var34 == 2) {
                                                   var35 = 41;
                                                }

                                                if (var34 == 3) {
                                                   var35 = 42;
                                                }

                                                if (var34 == 4) {
                                                   var35 = 43;
                                                }

                                                ArchiveDisk.method1503(var41[var34], ScriptEvent.method0(16748608) + var28.name, var35, var28.id, var23, var10.id);
                                             }
                                          }
                                       }

                                       ArchiveDisk.method1503("Examine", ScriptEvent.method0(16748608) + var28.name, 1005, var28.id, var23, var10.id);
                                    }
                                 }
                              }

                              ++var23;
                           }
                        }
                     }

                     if (var10.isIf3) {
                        if (Client.isSpellSelected) {
                           if (Occluder.method2420(SoundSystem.method1326(var10)) && (FaceNormal.field1523 & 32) == 32) {
                              ArchiveDisk.method1503(Client.field641, Client.field594 + " " + "->" + " " + var10.field2636, 58, 0, var10.childIndex, var10.id);
                           }
                        } else {
                           for(var23 = 9; var23 >= 5; --var23) {
                              var39 = class7.method58(var10, var23);
                              if (var39 != null) {
                                 ArchiveDisk.method1503(var39, var10.field2636, 1007, var23 + 1, var10.childIndex, var10.id);
                              }
                           }

                           var38 = IsaacCipher.method2543(var10);
                           if (var38 != null) {
                              ArchiveDisk.method1503(var38, var10.field2636, 25, 0, var10.childIndex, var10.id);
                           }

                           for(var24 = 4; var24 >= 0; --var24) {
                              var25 = class7.method58(var10, var24);
                              if (var25 != null) {
                                 ArchiveDisk.method1503(var25, var10.field2636, 57, var24 + 1, var10.childIndex, var10.id);
                              }
                           }

                           if (FaceNormal.method2029(SoundSystem.method1326(var10))) {
                              ArchiveDisk.method1503("Continue", "", 30, 0, var10.childIndex, var10.id);
                           }
                        }
                     }
                  }

                  if (var10.type == 0) {
                     if (!var10.isIf3 && Archive.method3322(var10) && var10 != Tiles.mousedOverWidgetIf1) {
                        continue;
                     }

                     if (!var10.isIf3) {
                        if (var10.field2655 > var10.field2592 - var10.height) {
                           var10.field2655 = var10.field2592 - var10.height;
                        }

                        if (var10.field2655 < 0) {
                           var10.field2655 = 0;
                        }
                     }

                     method1816(var0, var10.id, var15, var16, var17, var18, var12 - var10.field2589, var13 - var10.field2655, var11);
                     if (var10.children != null) {
                        method1816(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.field2589, var13 - var10.field2655, var11);
                     }

                     InterfaceParent var42 = (InterfaceParent)Client.interfaceParents.method3512((long)var10.id);
                     if (var42 != null) {
                        if (var42.field56 == 0 && MouseHandler.MouseHandler_x >= var15 && MouseHandler.MouseHandler_y >= var16 && MouseHandler.MouseHandler_x < var17 && MouseHandler.MouseHandler_y < var18 && !Client.isMenuOpen && !Client.field652) {
                           Client.menuActions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuOpcodes[0] = 1006;
                           Client.menuOptionsCount = 1;
                        }

                        var22 = var42.group;
                        if (!EnumComposition.method852(var22)) {
                           if (var11 != -1) {
                              Client.field686[var11] = true;
                           } else {
                              for(var23 = 0; var23 < 100; ++var23) {
                                 Client.field686[var23] = true;
                              }
                           }
                        } else {
                           Buffer.field2049 = null;
                           method1816(Widget.Widget_interfaceComponents[var22], -1, var15, var16, var17, var18, var12, var13, var11);
                           if (Buffer.field2049 != null) {
                              method1816(Buffer.field2049, -1412584499, var15, var16, var17, var18, AbstractByteArrayCopier.field2008, Renderable.field1546, var11);
                              Buffer.field2049 = null;
                           }
                        }
                     }

                     Rasterizer2D.method1953(var2, var3, var4, var5);
                     Rasterizer3D.method2352();
                  }

                  if (Client.field688[var11] || Client.field693 > 1) {
                     if (var10.type == 0 && !var10.isIf3 && var10.field2592 > var10.height) {
                        var21 = var12 + var10.width;
                        var22 = var10.field2655;
                        var23 = var10.height;
                        var24 = var10.field2592;
                        class14.field246[0].method1936(var21, var13);
                        class14.field246[1].method1936(var21, var23 + var13 - 16);
                        Rasterizer2D.method1962(var21, var13 + 16, 16, var23 - 32, Client.field662);
                        var40 = var23 * (var23 - 32) / var24;
                        if (var40 < 8) {
                           var40 = 8;
                        }

                        var26 = var22 * (var23 - 32 - var40) / (var24 - var23);
                        Rasterizer2D.method1962(var21, var13 + var26 + 16, 16, var40, Client.field698);
                        Rasterizer2D.method1996(var21, var26 + var13 + 16, var40, Client.field605);
                        Rasterizer2D.method1996(var21 + 1, var26 + var13 + 16, var40, Client.field605);
                        Rasterizer2D.method1963(var21, var13 + var26 + 16, 16, Client.field605);
                        Rasterizer2D.method1963(var21, var13 + var26 + 17, 16, Client.field605);
                        Rasterizer2D.method1996(var21 + 15, var26 + var13 + 16, var40, Client.field564);
                        Rasterizer2D.method1996(var21 + 14, var26 + var13 + 17, var40 - 1, Client.field564);
                        Rasterizer2D.method1963(var21, var40 + var26 + var13 + 15, 16, Client.field564);
                        Rasterizer2D.method1963(var21 + 1, var13 + var26 + var40 + 14, 15, Client.field564);
                     }

                     if (var10.type != 1) {
                        int var43;
                        if (var10.type == 2) {
                           var21 = 0;

                           for(var22 = 0; var22 < var10.height; ++var22) {
                              for(var23 = 0; var23 < var10.width; ++var23) {
                                 var24 = var23 * (var10.field2611 + 32) + var12;
                                 var40 = var13 + var22 * (var10.field2652 + 32);
                                 if (var21 < 20) {
                                    var24 += var10.field2631[var21];
                                    var40 += var10.field2632[var21];
                                 }

                                 if (var10.itemIds[var21] <= 0) {
                                    if (var10.inventorySprites != null && var21 < 20) {
                                       SpritePixels var62 = var10.method3374(var21);
                                       if (var62 != null) {
                                          var62.method1855(var24, var40);
                                       } else if (Widget.field2574) {
                                          class82.invalidateWidget(var10);
                                       }
                                    }
                                 } else {
                                    boolean var50 = false;
                                    boolean var51 = false;
                                    var43 = var10.itemIds[var21] - 1;
                                    if (var24 + 32 > var2 && var24 < var4 && var40 + 32 > var3 && var40 < var5 || var10 == SequenceDefinition.field887 && var21 == Client.field596) {
                                       SpritePixels var61;
                                       if (Client.isItemSelected == 1 && var21 == class82.selectedItemSlot && var10.id == PcmPlayer.selectedItemWidget) {
                                          var61 = KeyHandler.method1647(var43, var10.itemQuantities[var21], 2, 0, false);
                                       } else {
                                          var61 = KeyHandler.method1647(var43, var10.itemQuantities[var21], 1, 3153952, false);
                                       }

                                       if (var61 != null) {
                                          if (var10 == SequenceDefinition.field887 && var21 == Client.field596) {
                                             var26 = MouseHandler.MouseHandler_x - Client.field597;
                                             var27 = MouseHandler.MouseHandler_y - Client.field598;
                                             if (var26 < 5 && var26 > -5) {
                                                var26 = 0;
                                             }

                                             if (var27 < 5 && var27 > -5) {
                                                var27 = 0;
                                             }

                                             if (Client.field639 < 5) {
                                                var26 = 0;
                                                var27 = 0;
                                             }

                                             var61.method1843(var26 + var24, var27 + var40, 128);
                                             if (var1 != -1) {
                                                Widget var45 = var0[var1 & '\uffff'];
                                                if (var40 + var27 < Rasterizer2D.Rasterizer2D_yClipStart && var45.field2655 > 0) {
                                                   var31 = (Rasterizer2D.Rasterizer2D_yClipStart - var40 - var27) * Client.field525 / 3;
                                                   if (var31 > Client.field525 * 10) {
                                                      var31 = Client.field525 * 10;
                                                   }

                                                   if (var31 > var45.field2655) {
                                                      var31 = var45.field2655;
                                                   }

                                                   var45.field2655 -= var31;
                                                   Client.field598 += var31;
                                                   class82.invalidateWidget(var45);
                                                }

                                                if (var27 + var40 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var45.field2655 < var45.field2592 - var45.height) {
                                                   var31 = (var27 + var40 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field525 / 3;
                                                   if (var31 > Client.field525 * 10) {
                                                      var31 = Client.field525 * 10;
                                                   }

                                                   if (var31 > var45.field2592 - var45.height - var45.field2655) {
                                                      var31 = var45.field2592 - var45.height - var45.field2655;
                                                   }

                                                   var45.field2655 += var31;
                                                   Client.field598 -= var31;
                                                   class82.invalidateWidget(var45);
                                                }
                                             }
                                          } else if (var10 == Projectile.field161 && var21 == Client.field595) {
                                             var61.method1843(var24, var40, 128);
                                          } else {
                                             var61.method1855(var24, var40);
                                          }
                                       } else {
                                          class82.invalidateWidget(var10);
                                       }
                                    }
                                 }

                                 ++var21;
                              }
                           }
                        } else if (var10.type == 3) {
                           if (class40.method916(var10)) {
                              var21 = var10.field2678;
                              if (var10 == Tiles.mousedOverWidgetIf1 && var10.field2596 != 0) {
                                 var21 = var10.field2596;
                              }
                           } else {
                              var21 = var10.color;
                              if (var10 == Tiles.mousedOverWidgetIf1 && var10.field2595 != 0) {
                                 var21 = var10.field2595;
                              }
                           }

                           if (var14 == 0) {
                              if (var10.field2647) {
                                 Rasterizer2D.method1962(var12, var13, var10.width, var10.height, var21);
                              } else {
                                 Rasterizer2D.method1995(var12, var13, var10.width, var10.height, var21);
                              }
                           } else if (var10.field2647) {
                              Rasterizer2D.method1958(var12, var13, var10.width, var10.height, var21, 256 - (var14 & 255));
                           } else {
                              Rasterizer2D.method1968(var12, var13, var10.width, var10.height, var21, 256 - (var14 & 255));
                           }
                        } else {
                           Font var59;
                           if (var10.type == 4) {
                              var59 = var10.method3342();
                              if (var59 == null) {
                                 if (Widget.field2574) {
                                    class82.invalidateWidget(var10);
                                 }
                              } else {
                                 var38 = var10.field2633;
                                 if (class40.method916(var10)) {
                                    var22 = var10.field2678;
                                    if (var10 == Tiles.mousedOverWidgetIf1 && var10.field2596 != 0) {
                                       var22 = var10.field2596;
                                    }

                                    if (var10.field2624.length() > 0) {
                                       var38 = var10.field2624;
                                    }
                                 } else {
                                    var22 = var10.color;
                                    if (var10 == Tiles.mousedOverWidgetIf1 && var10.field2595 != 0) {
                                       var22 = var10.field2595;
                                    }
                                 }

                                 if (var10.isIf3 && var10.field2680 != -1) {
                                    ItemComposition var58 = class27.method571(var10.field2680);
                                    var38 = var58.name;
                                    if (var38 == null) {
                                       var38 = "null";
                                    }

                                    if ((var58.isStackable == 1 || var10.field2681 != 1) && var10.field2681 != -1) {
                                       var38 = ScriptEvent.method0(16748608) + var38 + "</col>" + " " + 'x' + NPCComposition.method653(var10.field2681);
                                    }
                                 }

                                 if (var10 == Client.meslayerContinueWidget) {
                                    var10000 = null;
                                    var38 = "Please wait...";
                                    var22 = var10.color;
                                 }

                                 if (!var10.isIf3) {
                                    var38 = PendingSpawn.method244(var38, var10);
                                 }

                                 var59.method3609(var38, var12, var13, var10.width, var10.height, var22, var10.field2628 ? 0 : -1, var10.field2626, var10.field2627, var10.field2625);
                              }
                           } else if (var10.type == 5) {
                              SpritePixels var60;
                              if (!var10.isIf3) {
                                 var60 = var10.method3341(class40.method916(var10));
                                 if (var60 != null) {
                                    var60.method1855(var12, var13);
                                 } else if (Widget.field2574) {
                                    class82.invalidateWidget(var10);
                                 }
                              } else {
                                 if (var10.field2680 != -1) {
                                    var60 = KeyHandler.method1647(var10.field2680, var10.field2681, var10.field2604, var10.field2667, false);
                                 } else {
                                    var60 = var10.method3341(false);
                                 }

                                 if (var60 == null) {
                                    if (Widget.field2574) {
                                       class82.invalidateWidget(var10);
                                    }
                                 } else {
                                    var22 = var60.width;
                                    var23 = var60.height;
                                    if (!var10.field2603) {
                                       var24 = var10.width * 4096 / var22;
                                       if (var10.field2688 != 0) {
                                          var60.method1849(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2688, var24);
                                       } else if (var14 != 0) {
                                          var60.method1845(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if (var22 == var10.width && var23 == var10.height) {
                                          var60.method1855(var12, var13);
                                       } else {
                                          var60.method1839(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method1954(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var24 = (var22 - 1 + var10.width) / var22;
                                       var40 = (var23 - 1 + var10.height) / var23;

                                       for(var26 = 0; var26 < var24; ++var26) {
                                          for(var27 = 0; var27 < var40; ++var27) {
                                             if (var10.field2688 != 0) {
                                                var60.method1849(var22 / 2 + var12 + var22 * var26, var23 / 2 + var13 + var27 * var23, var10.field2688, 4096);
                                             } else if (var14 != 0) {
                                                var60.method1843(var12 + var26 * var22, var13 + var27 * var23, 256 - (var14 & 255));
                                             } else {
                                                var60.method1855(var12 + var26 * var22, var13 + var23 * var27);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method1953(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var47;
                              if (var10.type == 6) {
                                 boolean var46 = class40.method916(var10);
                                 if (var46) {
                                    var22 = var10.sequenceId2;
                                 } else {
                                    var22 = var10.sequenceId;
                                 }

                                 Model var56 = null;
                                 var24 = 0;
                                 if (var10.field2680 != -1) {
                                    var47 = class27.method571(var10.field2680);
                                    if (var47 != null) {
                                       var47 = var47.method861(var10.field2681);
                                       var56 = var47.method886(1);
                                       if (var56 != null) {
                                          var56.method2427();
                                          var24 = var56.height / 2;
                                       } else {
                                          class82.invalidateWidget(var10);
                                       }
                                    }
                                 } else if (var10.modelType == 5) {
                                    if (var10.modelId == 0) {
                                       var56 = Client.playerAppearance.method3407((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
                                    } else {
                                       var56 = Tiles.localPlayer.vmethod2030();
                                    }
                                 } else if (var22 == -1) {
                                    var56 = var10.method3351((SequenceDefinition)null, -1, var46, Tiles.localPlayer.appearance);
                                    if (var56 == null && Widget.field2574) {
                                       class82.invalidateWidget(var10);
                                    }
                                 } else {
                                    SequenceDefinition var48 = class23.method250(var22);
                                    var56 = var10.method3351(var48, var10.modelFrame, var46, Tiles.localPlayer.appearance);
                                    if (var56 == null && Widget.field2574) {
                                       class82.invalidateWidget(var10);
                                    }
                                 }

                                 Rasterizer3D.method2303(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var40 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.field2679 >> 16;
                                 var26 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.field2679 >> 16;
                                 if (var56 != null) {
                                    if (!var10.isIf3) {
                                       var56.method2439(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var40, var26);
                                    } else {
                                       var56.method2427();
                                       if (var10.field2621) {
                                          var56.method2440(0, var10.modelAngleY, var10.field2614, var10.modelAngleX, var10.field2577, var24 + var40 + var10.field2668, var26 + var10.field2668, var10.field2679);
                                       } else {
                                          var56.method2439(0, var10.modelAngleY, var10.field2614, var10.modelAngleX, var10.field2577, var24 + var40 + var10.field2668, var26 + var10.field2668);
                                       }
                                    }
                                 }

                                 Rasterizer3D.method2319();
                              } else {
                                 if (var10.type == 7) {
                                    var59 = var10.method3342();
                                    if (var59 == null) {
                                       if (Widget.field2574) {
                                          class82.invalidateWidget(var10);
                                       }
                                       continue;
                                    }

                                    var22 = 0;

                                    for(var23 = 0; var23 < var10.height; ++var23) {
                                       for(var24 = 0; var24 < var10.width; ++var24) {
                                          if (var10.itemIds[var22] > 0) {
                                             var47 = class27.method571(var10.itemIds[var22] - 1);
                                             String var44;
                                             if (var47.isStackable != 1 && var10.itemQuantities[var22] == 1) {
                                                var44 = ScriptEvent.method0(16748608) + var47.name + "</col>";
                                             } else {
                                                var44 = ScriptEvent.method0(16748608) + var47.name + "</col>" + " " + 'x' + NPCComposition.method653(var10.itemQuantities[var22]);
                                             }

                                             var27 = var24 * (var10.field2611 + 115) + var12;
                                             var43 = var23 * (var10.field2652 + 12) + var13;
                                             if (var10.field2626 == 0) {
                                                var59.method3626(var44, var27, var43, var10.color, var10.field2628 ? 0 : -1);
                                             } else if (var10.field2626 == 1) {
                                                var59.method3676(var44, var10.width / 2 + var27, var43, var10.color, var10.field2628 ? 0 : -1);
                                             } else {
                                                var59.method3607(var44, var27 + var10.width - 1, var43, var10.color, var10.field2628 ? 0 : -1);
                                             }
                                          }

                                          ++var22;
                                       }
                                    }
                                 }

                                 int var49;
                                 if (var10.type == 8 && var10 == NPC.field398 && Client.field636 == Client.field635) {
                                    var21 = 0;
                                    var22 = 0;
                                    Font var55 = VertexNormal.field1511;
                                    var39 = var10.field2633;

                                    for(var39 = PendingSpawn.method244(var39, var10); var39.length() > 0; var22 = var22 + var55.ascent + 1) {
                                       var26 = var39.indexOf("<br>");
                                       if (var26 != -1) {
                                          var25 = var39.substring(0, var26);
                                          var39 = var39.substring(var26 + 4);
                                       } else {
                                          var25 = var39;
                                          var39 = "";
                                       }

                                       var27 = var55.method3601(var25);
                                       if (var27 > var21) {
                                          var21 = var27;
                                       }
                                    }

                                    var21 += 6;
                                    var22 += 7;
                                    var26 = var12 + var10.width - 5 - var21;
                                    var27 = var13 + var10.height + 5;
                                    if (var26 < var12 + 5) {
                                       var26 = var12 + 5;
                                    }

                                    if (var26 + var21 > var4) {
                                       var26 = var4 - var21;
                                    }

                                    if (var22 + var27 > var5) {
                                       var27 = var5 - var22;
                                    }

                                    Rasterizer2D.method1962(var26, var27, var21, var22, 16777120);
                                    Rasterizer2D.method1995(var26, var27, var21, var22, 0);
                                    var39 = var10.field2633;
                                    var43 = var27 + var55.ascent + 2;

                                    for(var39 = PendingSpawn.method244(var39, var10); var39.length() > 0; var43 = var43 + var55.ascent + 1) {
                                       var49 = var39.indexOf("<br>");
                                       if (var49 != -1) {
                                          var25 = var39.substring(0, var49);
                                          var39 = var39.substring(var49 + 4);
                                       } else {
                                          var25 = var39;
                                          var39 = "";
                                       }

                                       var55.method3626(var25, var26 + 3, var43, 0, -1);
                                    }
                                 }

                                 if (var10.type == 9) {
                                    if (var10.field2599 == 1) {
                                       Rasterizer2D.method1987(var12, var13, var12 + var10.width, var13 + var10.height, var10.color);
                                    } else {
                                       var21 = var10.width >= 0 ? var10.width * -538789309 * 1353704043 : -var10.width;
                                       var22 = var10.height >= 0 ? var10.height * -1807498407 * 1590318313 : -var10.height;
                                       var23 = var21;
                                       if (var21 < var22) {
                                          var23 = var22;
                                       }

                                       if (var23 != 0) {
                                          var24 = (var10.width << 16) / var23;
                                          var40 = (var10.height << 16) / var23;
                                          if (var40 <= var24) {
                                             var24 = -var24;
                                          } else {
                                             var40 = -var40;
                                          }

                                          var26 = var40 * var10.field2599 >> 17;
                                          var27 = var40 * var10.field2599 + 1 >> 17;
                                          var43 = var24 * var10.field2599 >> 17;
                                          var49 = var24 * var10.field2599 + 1 >> 17;
                                          var30 = var12 + var26;
                                          var31 = var12 - var27;
                                          var32 = var12 + var10.width - var27;
                                          var54 = var26 + var12 + var10.width;
                                          var34 = var43 + var13;
                                          int var57 = var13 - var49;
                                          int var36 = var13 + var10.height - var49;
                                          int var37 = var13 + var43 + var10.height;
                                          Rasterizer3D.method2338(var30, var31, var32);
                                          Rasterizer3D.method2313(var34, var57, var36, var30, var31, var32, var10.color);
                                          Rasterizer3D.method2338(var30, var32, var54);
                                          Rasterizer3D.method2313(var34, var36, var37, var30, var32, var54, var10.color);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
