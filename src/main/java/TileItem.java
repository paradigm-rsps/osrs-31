import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("TileItem")
public final class TileItem extends Renderable {
   @ObfuscatedName("k")
   @Export("soundSystem")
   @ObfuscatedSignature(
      descriptor = "Lclass54;"
   )
   static SoundSystem soundSystem;
   @ObfuscatedName("i")
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @Export("quantity")
   int quantity;

   @ObfuscatedName("w")
   @Export("vmethod2030")
   @ObfuscatedSignature(
      descriptor = "()Lclass111;"
   )
   protected final Model vmethod2030() {
      return class27.method571(this.id).method886(this.quantity);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;)V"
   )
   public static void method180(AbstractArchive var0) {
      class40.field1035 = var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lclass86;)V"
   )
   static final void method181(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < InterfaceParent.field58.length; ++var2) {
         InterfaceParent.field58[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         InterfaceParent.field58[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class125.field2034[var5] = (InterfaceParent.field58[var5 + 128] + InterfaceParent.field58[var5 - 128] + InterfaceParent.field58[var5 + 1] + InterfaceParent.field58[var5 - 1]) / 4;
            }
         }

         int[] var8 = InterfaceParent.field58;
         InterfaceParent.field58 = class125.field2034;
         class125.field2034 = var8;
      }

      if (var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.subHeight; ++var3) {
            for(var4 = 0; var4 < var0.subWidth; ++var4) {
               if (var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.xOffset + 16;
                  int var6 = var3 + var0.yOffset + 16;
                  int var7 = var5 + (var6 << 7);
                  InterfaceParent.field58[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(Lclass94;[Lclass163;)V"
   )
   static final void method182(Scene var0, CollisionMap[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if ((Tiles.Tiles_renderFlags[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if ((Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if (var5 >= 0) {
                     var1[var5].method3429(var3, var4);
                  }
               }
            }
         }
      }

      Tiles.rndHue += (int)(Math.random() * 5.0D) - 2;
      if (Tiles.rndHue < -8) {
         Tiles.rndHue = -8;
      }

      if (Tiles.rndHue > 8) {
         Tiles.rndHue = 8;
      }

      Tiles.rndLightness += (int)(Math.random() * 5.0D) - 2;
      if (Tiles.rndLightness < -16) {
         Tiles.rndLightness = -16;
      }

      if (Tiles.rndLightness > 16) {
         Tiles.rndLightness = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = Tiles.field132[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = Tiles.Tiles_heights[var2][var12 + 1][var11] - Tiles.Tiles_heights[var2][var12 - 1][var11];
               var14 = Tiles.Tiles_heights[var2][var12][var11 + 1] - Tiles.Tiles_heights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12][var11 + 1] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11] >> 1);
               Tiles.field120[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            Tiles.Tiles_hue[var11] = 0;
            VertexNormal.Tiles_saturation[var11] = 0;
            EnumComposition.Tiles_lightness[var11] = 0;
            class1.Tiles_hueMultiplier[var11] = 0;
            Skills.field2053[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if (var13 >= 0 && var13 < 104) {
                  var14 = Tiles.Tiles_underlays[var2][var13][var12] & 255;
                  if (var14 > 0) {
                     FloorUnderlayDefinition var44 = class83.method1798(var14 - 1);
                     Tiles.Tiles_hue[var12] += var44.hue;
                     VertexNormal.Tiles_saturation[var12] += var44.saturation;
                     EnumComposition.Tiles_lightness[var12] += var44.lightness;
                     class1.Tiles_hueMultiplier[var12] += var44.hueMultiplier;
                     ++Skills.field2053[var12];
                  }
               }

               var14 = var11 - 5;
               if (var14 >= 0 && var14 < 104) {
                  var15 = Tiles.Tiles_underlays[var2][var14][var12] & 255;
                  if (var15 > 0) {
                     FloorUnderlayDefinition var45 = class83.method1798(var15 - 1);
                     Tiles.Tiles_hue[var12] -= var45.hue;
                     VertexNormal.Tiles_saturation[var12] -= var45.saturation;
                     EnumComposition.Tiles_lightness[var12] -= var45.lightness;
                     class1.Tiles_hueMultiplier[var12] -= var45.hueMultiplier;
                     --Skills.field2053[var12];
                  }
               }
            }

            if (var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if (var18 >= 0 && var18 < 104) {
                     var12 += Tiles.Tiles_hue[var18];
                     var13 += VertexNormal.Tiles_saturation[var18];
                     var14 += EnumComposition.Tiles_lightness[var18];
                     var15 += class1.Tiles_hueMultiplier[var18];
                     var16 += Skills.field2053[var18];
                  }

                  var19 = var17 - 5;
                  if (var19 >= 0 && var19 < 104) {
                     var12 -= Tiles.Tiles_hue[var19];
                     var13 -= VertexNormal.Tiles_saturation[var19];
                     var14 -= EnumComposition.Tiles_lightness[var19];
                     var15 -= class1.Tiles_hueMultiplier[var19];
                     var16 -= Skills.field2053[var19];
                  }

                  if (var17 >= 1 && var17 < 103) {
                     if (Client.isLowDetail && (Tiles.Tiles_renderFlags[0][var11][var17] & 2) == 0) {
                        if ((Tiles.Tiles_renderFlags[var2][var11][var17] & 16) != 0) {
                           continue;
                        }

                        if ((Tiles.Tiles_renderFlags[var2][var11][var17] & 8) != 0) {
                           var20 = 0;
                        } else if (var2 > 0 && (Tiles.Tiles_renderFlags[1][var11][var17] & 2) != 0) {
                           var20 = var2 - 1;
                        } else {
                           var20 = var2;
                        }

                        if (var20 != Client.field531) {
                           continue;
                        }
                     }

                     if (var2 < Tiles.Tiles_minPlane) {
                        Tiles.Tiles_minPlane = var2;
                     }

                     var20 = Tiles.Tiles_underlays[var2][var11][var17] & 255;
                     int var21 = VarpDefinition.Tiles_overlays[var2][var11][var17] & 255;
                     if (var20 > 0 || var21 > 0) {
                        int var22 = Tiles.Tiles_heights[var2][var11][var17];
                        int var23 = Tiles.Tiles_heights[var2][var11 + 1][var17];
                        int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
                        int var25 = Tiles.Tiles_heights[var2][var11][var17 + 1];
                        int var26 = Tiles.field120[var11][var17];
                        int var27 = Tiles.field120[var11 + 1][var17];
                        int var28 = Tiles.field120[var11 + 1][var17 + 1];
                        int var29 = Tiles.field120[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if (var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = FaceNormal.method2028(var32, var33, var34);
                           var32 = var32 + Tiles.rndHue & 255;
                           var34 += Tiles.rndLightness;
                           if (var34 < 0) {
                              var34 = 0;
                           } else if (var34 > 255) {
                              var34 = 255;
                           }

                           var31 = FaceNormal.method2028(var32, var33, var34);
                        }

                        if (var2 > 0) {
                           boolean var47 = true;
                           if (var20 == 0 && Tiles.Tiles_shapes[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if (var21 > 0 && !PcmPlayer.method1225(var21 - 1).hideUnderlay) {
                              var47 = false;
                           }

                           if (var47 && var23 == var22 && var22 == var24 && var25 == var22) {
                              VertexNormal.field1510[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if (var31 != -1) {
                           var32 = Rasterizer3D.field1783[ModelData0.method2301(var31, 96)];
                        }

                        if (var21 == 0) {
                           var0.method2047(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, ModelData0.method2301(var30, var26), ModelData0.method2301(var30, var27), ModelData0.method2301(var30, var28), ModelData0.method2301(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = Tiles.Tiles_shapes[var2][var11][var17] + 1;
                           byte var48 = class123.field2031[var2][var11][var17];
                           FloorOverlayDefinition var35 = PcmPlayer.method1225(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if (var36 >= 0) {
                              var38 = Rasterizer3D.Rasterizer3D_textureLoader.vmethod2406(var36);
                              var37 = -1;
                           } else if (var35.primaryRgb == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = FaceNormal.method2028(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + Tiles.rndHue & 255;
                              var40 = var35.lightness + Tiles.rndLightness;
                              if (var40 < 0) {
                                 var40 = 0;
                              } else if (var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = FaceNormal.method2028(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if (var38 != -2) {
                              var39 = Rasterizer3D.field1783[World.method156(var38, 96)];
                           }

                           if (var35.secondaryRgb != -1) {
                              var40 = var35.secondaryHue + Tiles.rndHue & 255;
                              int var41 = var35.secondaryLightness + Tiles.rndLightness;
                              if (var41 < 0) {
                                 var41 = 0;
                              } else if (var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = FaceNormal.method2028(var40, var35.secondarySaturation, var41);
                              var39 = Rasterizer3D.field1783[World.method156(var38, 96)];
                           }

                           var0.method2047(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, ModelData0.method2301(var30, var26), ModelData0.method2301(var30, var27), ModelData0.method2301(var30, var28), ModelData0.method2301(var30, var29), World.method156(var37, var26), World.method156(var37, var27), World.method156(var37, var28), World.method156(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if ((Tiles.Tiles_renderFlags[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if (var2 > 0 && (Tiles.Tiles_renderFlags[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method2046(var2, var12, var11, var17);
            }
         }

         Tiles.Tiles_underlays[var2] = null;
         VarpDefinition.Tiles_overlays[var2] = null;
         Tiles.Tiles_shapes[var2] = null;
         class123.field2031[var2] = null;
         Tiles.field132[var2] = null;
      }

      var0.method2072(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if ((Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
               var0.method2044(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if (var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var46;
                  if ((VertexNormal.field1510[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (VertexNormal.field1510[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (VertexNormal.field1510[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label436:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if ((VertexNormal.field1510[var11 - 1][var8][var13] & var2) == 0) {
                              break label436;
                           }
                        }

                        --var11;
                     }

                     label425:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if ((VertexNormal.field1510[var12 + 1][var8][var13] & var2) == 0) {
                              break label425;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if (var13 >= 8) {
                        var46 = 240;
                        var15 = Tiles.Tiles_heights[var12][var8][var9] - var46;
                        var16 = Tiles.Tiles_heights[var11][var8][var9];
                        Scene.method2045(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              VertexNormal.field1510[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if ((VertexNormal.field1510[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (VertexNormal.field1510[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (VertexNormal.field1510[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label489:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if ((VertexNormal.field1510[var11 - 1][var13][var7] & var3) == 0) {
                              break label489;
                           }
                        }

                        --var11;
                     }

                     label478:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if ((VertexNormal.field1510[var12 + 1][var13][var7] & var3) == 0) {
                              break label478;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if (var13 >= 8) {
                        var46 = 240;
                        var15 = Tiles.Tiles_heights[var12][var9][var7] - var46;
                        var16 = Tiles.Tiles_heights[var11][var9][var7];
                        Scene.method2045(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              VertexNormal.field1510[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if ((VertexNormal.field1510[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (VertexNormal.field1510[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (VertexNormal.field1510[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label542:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if ((VertexNormal.field1510[var6][var9 - 1][var13] & var4) == 0) {
                              break label542;
                           }
                        }

                        --var9;
                     }

                     label531:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if ((VertexNormal.field1510[var6][var10 + 1][var13] & var4) == 0) {
                              break label531;
                           }
                        }

                        ++var10;
                     }

                     if ((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = Tiles.Tiles_heights[var6][var9][var11];
                        Scene.method2045(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              VertexNormal.field1510[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   public static void method179(boolean var0) {
      if (var0 != ItemComposition.ItemDefinition_inMembersWorld) {
         ItemComposition.ItemDefinition_cached.method3482();
         ItemComposition.ItemDefinition_cachedModels.method3482();
         ItemComposition.ItemDefinition_cachedSprites.method3482();
         ItemComposition.ItemDefinition_inMembersWorld = var0;
      }

   }

   @ObfuscatedName("v")
   static final void loggedOutCycle() {
      try {
         if (Client.field574 == 0) {
            if (GraphicsObject.World_request != null) {
               GraphicsObject.World_request.method1471();
               GraphicsObject.World_request = null;
            }

            StudioGame.field2087 = null;
            Client.field530 = false;
            Client.field512 = 0;
            Client.field574 = 1;
         }

         if (Client.field574 == 1) {
            if (StudioGame.field2087 == null) {
               StudioGame.field2087 = ItemContainer.taskHandler.method1612(SoundSystem.worldHost, class82.currentPort);
            }

            if (StudioGame.field2087.status == 2) {
               throw new IOException();
            }

            if (StudioGame.field2087.status == 1) {
               GraphicsObject.World_request = new IterableNodeHashTableIterator((Socket)StudioGame.field2087.result, ItemContainer.taskHandler);
               StudioGame.field2087 = null;
               Client.field574 = 2;
            }
         }

         if (Client.field574 == 2) {
            Client.field519.offset = 0;
            Client.field519.writeByte(14);
            GraphicsObject.World_request.method1474(Client.field519.array, 0, 1);
            Client.field521.offset = 0;
            Client.field574 = 3;
         }

         int var0;
         if (Client.field574 == 3) {
            if (Client.pcmPlayer0 != null) {
               Client.pcmPlayer0.method1228();
            }

            if (class27.pcmPlayer1 != null) {
               class27.pcmPlayer1.method1228();
            }

            var0 = GraphicsObject.World_request.method1472();
            if (Client.pcmPlayer0 != null) {
               Client.pcmPlayer0.method1228();
            }

            if (class27.pcmPlayer1 != null) {
               class27.pcmPlayer1.method1228();
            }

            if (var0 != 0) {
               method183(var0);
               return;
            }

            Client.field521.offset = 0;
            Client.field574 = 5;
         }

         int var1;
         int var2;
         if (Client.field574 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field519.offset = 0;
            Client.field519.writeByte(10);
            Client.field519.writeInt(var7[0]);
            Client.field519.writeInt(var7[1]);
            Client.field519.writeInt(var7[2]);
            Client.field519.writeInt(var7[3]);
            Client.field519.writeLong(0L);
            Client.field519.writeString(Login.field339);
            Client.field519.encryptRSA(class5.modulus, class5.exponent);
            Client.field520.offset = 0;
            if (Client.gameState == 40) {
               Client.field520.writeByte(18);
            } else {
               Client.field520.writeByte(16);
            }

            Client.field520.writeShort(0);
            var1 = Client.field520.offset;
            Client.field520.writeInt(31);
            Client.field520.writeBytes(Client.field519.array, 0, Client.field519.offset);
            var2 = Client.field520.offset;
            Client.field520.writeString(Login.field338);
            Client.field520.writeByte(Client.isLowDetail ? 1 : 0);
            PacketBuffer var3 = Client.field520;
            byte[] var4 = new byte[24];

            int var5;
            try {
               JagexCache.JagexCache_randomDat.method601(0L);
               JagexCache.JagexCache_randomDat.method607(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if (var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var12) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.writeBytes(var4, 0, 24);
           /* Buffer var15 = new Buffer(class68.field1274.method3182());
            class68.field1274.writePlatformInfo(var15);
            Client.field520.writeBytes(var15.array, 0, var15.array.length);
            Client.field520.writeInt(MusicPatchNode.archive1.hash);
            Client.field520.writeInt(class7.archive3.hash);
            Client.field520.writeInt(ClientPreferences.archive2.hash);
            Client.field520.writeInt(class83.archive4.hash);
            Client.field520.writeInt(class7.field102.hash);
            Client.field520.writeInt(class146.archive5.hash);
            Client.field520.writeInt(class40.archive6.hash);
            Client.field520.writeInt(InterfaceParent.archive7.hash);
            Client.field520.writeInt(MouseRecorder.archive8.hash);
            Client.field520.writeInt(class10.archive9.hash);
            Client.field520.writeInt(DynamicObject.archive10.hash);
            Client.field520.writeInt(World.archive11.hash);
            Client.field520.writeInt(AbstractByteArrayCopier.archive12.hash);
            Client.field520.writeInt(class17.archive13.hash);
            Client.field520.writeInt(KeyHandler.archive14.hash);
            Client.field520.writeInt(Tiles.archive15.hash);*/
            Client.field520.encryptXtea(var7, var2, Client.field520.offset);
            Client.field520.writeSmartShort(Client.field520.offset - var1);
            GraphicsObject.World_request.method1474(Client.field520.array, 0, Client.field520.offset);
            Client.field519.initIsaacRandom(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field521.initIsaacRandom(var7);
            Client.field574 = 6;
         }

         if (Client.field574 == 6 && GraphicsObject.World_request.method1473() > 0) {
            var0 = GraphicsObject.World_request.method1472();
            if (var0 == 21 && Client.gameState == 20) {
               Client.field574 = 7;
            } else if (var0 == 2) {
               Client.field574 = 9;
            } else {
               if (var0 == 15 && Client.gameState == 40) {
                  Client.field519.offset = 0;
                  Client.field521.offset = 0;
                  Client.field523 = -1;
                  Client.field527 = -1;
                  Client.field728 = -1;
                  Client.field488 = -1;
                  Client.field611 = 0;
                  Client.field565 = 0;
                  Client.field585 = 0;
                  Client.menuOptionsCount = 0;
                  Client.isMenuOpen = false;
                  Client.field717 = 0;
                  Client.field715 = 0;

                  for(var1 = 0; var1 < Client.players.length; ++var1) {
                     if (Client.players[var1] != null) {
                        Client.players[var1].field444 = -1;
                     }
                  }

                  for(var1 = 0; var1 < Client.npcs.length; ++var1) {
                     if (Client.npcs[var1] != null) {
                        Client.npcs[var1].field444 = -1;
                     }
                  }

                  ItemContainer.itemContainers = new NodeHashTable(32);
                  NPC.method260(30);

                  for(var1 = 0; var1 < 100; ++var1) {
                     Client.field686[var1] = true;
                  }

                  return;
               }

               if (var0 != 23 || Client.field513 >= 1) {
                  method183(var0);
                  return;
               }

               ++Client.field513;
               Client.field574 = 0;
            }
         }

         if (Client.field574 == 7 && GraphicsObject.World_request.method1473() > 0) {
            Client.field514 = (GraphicsObject.World_request.method1472() + 3) * 60;
            Client.field574 = 8;
         }

         if (Client.field574 == 8) {
            Client.field512 = 0;
            BufferedFile.method624("You have only just left another world.", "Your profile will be transferred in:", Client.field514 / 60 + " seconds.");
            if (--Client.field514 <= 0) {
               Client.field574 = 0;
            }

         } else {
            if (Client.field574 == 9 && GraphicsObject.World_request.method1473() >= 8) {
               Client.field563 = GraphicsObject.World_request.method1472();
               Client.field566 = GraphicsObject.World_request.method1472() == 1;
               Client.field617 = GraphicsObject.World_request.method1472();
               Client.field617 <<= 8;
               Client.field617 += GraphicsObject.World_request.method1472();
               Client.field610 = GraphicsObject.World_request.method1472();
               GraphicsObject.World_request.method1496(Client.field521.array, 0, 1);
               Client.field521.offset = 0;
               Client.field523 = Client.field521.method2513();
               GraphicsObject.World_request.method1496(Client.field521.array, 0, 2);
               Client.field521.offset = 0;
               Client.field611 = Client.field521.method2808();
               Client var16;
               if (Client.field610 == 1) {
                  try {
                     var16 = Client.field480;
                     //JSObject.getWindow(var16).call("zap", (Object[])null);
                  } catch (Throwable var11) {
                     ;
                  }
               } else {
                  try {
                     var16 = Client.field480;
                     //JSObject.getWindow(var16).call("unzap", (Object[])null);
                  } catch (Throwable var10) {
                     ;
                  }
               }

               Client.field574 = 10;
            }

            if (Client.field574 != 10) {
               ++Client.field512;
               if (Client.field512 > 2000) {
                  if (Client.field513 < 1) {
                     if (class82.currentPort == MouseRecorder.field259) {
                        class82.currentPort = Client.field515;
                     } else {
                        class82.currentPort = MouseRecorder.field259;
                     }

                     ++Client.field513;
                     Client.field574 = 0;
                  } else {
                     method183(-3);
                  }
               }
            } else {
               if (GraphicsObject.World_request.method1473() >= Client.field611) {
                  Client.field521.offset = 0;
                  GraphicsObject.World_request.method1496(Client.field521.array, 0, Client.field611);
                  Client.field545 = -1L;
                  Client.field494 = -1;
                  BoundaryObject.field1625.index = 0;
                  class23.hasFocus = true;
                  Client.field613 = true;
                  Client.field707 = -1L;
                  class10.method135();
                  Client.field519.offset = 0;
                  Client.field521.offset = 0;
                  Client.field523 = -1;
                  Client.field527 = -1;
                  Client.field728 = -1;
                  Client.field488 = -1;
                  Client.field565 = 0;
                  Client.field585 = 0;
                  Client.logoutTimer = 0;
                  Client.hintArrowType = 0;
                  Client.menuOptionsCount = 0;
                  Client.isMenuOpen = false;
                  MouseHandler.MouseHandler_idleCycles = 0;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field697[var0] = null;
                  }

                  Client.field580 = 0;
                  Client.isItemSelected = 0;
                  Client.isSpellSelected = false;
                  Client.soundEffectCount = 0;
                  Client.field734 = (int)(Math.random() * 100.0D) - 50;
                  Client.field549 = (int)(Math.random() * 110.0D) - 55;
                  Client.field551 = (int)(Math.random() * 80.0D) - 40;
                  Client.field554 = (int)(Math.random() * 120.0D) - 60;
                  Client.field556 = (int)(Math.random() * 30.0D) - 20;
                  Client.field569 = (int)(Math.random() * 20.0D) - 10 & 2047;
                  Client.field717 = 0;
                  Client.field710 = -1;
                  Client.field715 = 0;
                  Client.field716 = 0;
                  Client.field604 = 0;
                  Client.npcCount = 0;

                  for(var0 = 0; var0 < 2048; ++var0) {
                     Client.players[var0] = null;
                     Client.field608[var0] = null;
                  }

                  for(var0 = 0; var0 < 32768; ++var0) {
                     Client.npcs[var0] = null;
                  }

                  Tiles.localPlayer = Client.players[2047] = new Player();
                  Client.field619.method3527();
                  Client.field620.method3527();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           Client.groundItems[var0][var1][var2] = null;
                        }
                     }
                  }

                  Client.pendingSpawns = new NodeDeque();
                  Client.field737 = 0;
                  Client.field736 = 0;
                  Client.field534 = 0;

                  for(var0 = 0; var0 < VarpDefinition.field1039; ++var0) {
                     VarpDefinition var9 = GameBuild.method2854(var0);
                     if (var9 != null && var9.type == 0) {
                        Varps.Varps_temp[var0] = 0;
                        Varps.Varps_main[var0] = 0;
                     }
                  }

                  for(var0 = 0; var0 < Client.field677.length; ++var0) {
                     Client.field677[var0] = -1;
                  }

                  if (Client.field643 != -1) {
                     var0 = Client.field643;
                     if (var0 != -1 && Widget.Widget_loadedInterfaces[var0]) {
                        Widget.Widget_archive.method3216(var0);
                        if (Widget.Widget_interfaceComponents[var0] != null) {
                           boolean var14 = true;

                           for(var2 = 0; var2 < Widget.Widget_interfaceComponents[var0].length; ++var2) {
                              if (Widget.Widget_interfaceComponents[var0][var2] != null) {
                                 if (Widget.Widget_interfaceComponents[var0][var2].type != 2) {
                                    Widget.Widget_interfaceComponents[var0][var2] = null;
                                 } else {
                                    var14 = false;
                                 }
                              }
                           }

                           if (var14) {
                              Widget.Widget_interfaceComponents[var0] = null;
                           }

                           Widget.Widget_loadedInterfaces[var0] = false;
                        }
                     }
                  }

                  for(InterfaceParent var17 = (InterfaceParent)Client.interfaceParents.method3515(); var17 != null; var17 = (InterfaceParent)Client.interfaceParents.method3516()) {
                     Tiles.method60(var17, true);
                  }

                  Client.field643 = -1;
                  Client.interfaceParents = new NodeHashTable(8);
                  Client.meslayerContinueWidget = null;
                  Client.isMenuOpen = false;
                  Client.menuOptionsCount = 0;
                  Client.playerAppearance.method3424((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     Client.playerMenuActions[var0] = null;
                     Client.playerOptionsPriorities[var0] = false;
                  }

                  ItemContainer.itemContainers = new NodeHashTable(32);
                  Client.field489 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     Client.field686[var0] = true;
                  }

                  Client.field660 = null;
                  SoundSystem.field1188 = 0;
                  ItemComposition.field1026 = null;
                  Client.field746 = -1;
                  Login.method242(false);
                  Client.field523 = -1;
               }

            }
         }
      } catch (IOException var13) {
         if (Client.field513 < 1) {
            if (class82.currentPort == MouseRecorder.field259) {
               class82.currentPort = Client.field515;
            } else {
               class82.currentPort = MouseRecorder.field259;
            }

            ++Client.field513;
            Client.field574 = 0;
         } else {
            method183(-2);
         }
      }
   }

   @ObfuscatedName("j")
   @Export("method183")
   static void method183(int var0) {
      if (var0 == -3) {
         BufferedFile.method624("Connection timed out.", "Please try using a different world.", "");
      } else if (var0 == -2) {
         BufferedFile.method624("", "Error connecting to server.", "");
      } else if (var0 == -1) {
         BufferedFile.method624("No response from server.", "Please try using a different world.", "");
      } else if (var0 == 3) {
         BufferedFile.method624("", "Invalid username/email or password.", "");
      } else if (var0 == 4) {
         BufferedFile.method624("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if (var0 == 5) {
         BufferedFile.method624("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if (var0 == 6) {
         BufferedFile.method624("RuneScape has been updated!", "Please reload this page.", "");
      } else if (var0 == 7) {
         BufferedFile.method624("This world is full.", "Please use a different world.", "");
      } else if (var0 == 8) {
         BufferedFile.method624("Unable to connect.", "Login server offline.", "");
      } else if (var0 == 9) {
         BufferedFile.method624("Login limit exceeded.", "Too many connections from your address.", "");
      } else if (var0 == 10) {
         BufferedFile.method624("Unable to connect.", "Bad session id.", "");
      } else if (var0 == 11) {
         BufferedFile.method624("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
      } else if (var0 == 12) {
         BufferedFile.method624("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if (var0 == 13) {
         BufferedFile.method624("Could not complete login.", "Please try using a different world.", "");
      } else if (var0 == 14) {
         BufferedFile.method624("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if (var0 == 16) {
         BufferedFile.method624("Too many incorrect logins from your address.", "Please wait 5 minutes before trying again.", "");
      } else if (var0 == 17) {
         BufferedFile.method624("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if (var0 == 18) {
         BufferedFile.method624("Account locked as we suspect it has been stolen.", "Press 'recover a locked account' on front page.", "");
      } else if (var0 == 19) {
         BufferedFile.method624("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if (var0 == 20) {
         BufferedFile.method624("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if (var0 == 22) {
         BufferedFile.method624("Malformed login packet.", "Please try again.", "");
      } else if (var0 == 23) {
         BufferedFile.method624("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if (var0 == 24) {
         BufferedFile.method624("Error loading your profile.", "Please contact customer support.", "");
      } else if (var0 == 25) {
         BufferedFile.method624("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if (var0 == 26) {
         BufferedFile.method624("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if (var0 == 27) {
         BufferedFile.method624("", "Service unavailable.", "");
      } else if (var0 == 31) {
         BufferedFile.method624("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if (var0 == 32) {
         BufferedFile.method624("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
      } else if (var0 == 37) {
         BufferedFile.method624("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if (var0 == 38) {
         BufferedFile.method624("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if (var0 == 55) {
         BufferedFile.method624("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         BufferedFile.method624("Unexpected server response", "Please try using a different world.", "");
      }

      NPC.method260(10);
   }

   @ObfuscatedName("ck")
   static final String method173(int var0) {
      return var0 < 999999999 ? Integer.toString(var0) : "*";
   }
}
