import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("Script")
public class Script extends DualNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lclass169;"
   )
   static EvictingDualNodeHashTable field68 = new EvictingDualNodeHashTable(128);
   @ObfuscatedName("l")
   public static short[][] field60;
   @ObfuscatedName("w")
   int[] field61;
   @ObfuscatedName("f")
   int[] field62;
   @ObfuscatedName("e")
   String[] field69;
   @ObfuscatedName("t")
   int field64;
   @ObfuscatedName("d")
   int field65;
   @ObfuscatedName("p")
   int field66;
   @ObfuscatedName("k")
   int field70;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lclass182;Lclass182;)V"
   )
   static void method32(Font var0, Font var1) {
      if (Login.worldSelectOpen) {
         ObjectSound.method53(var0, var1);
      } else {
         byte var2;
         int var3;
         if (Client.gameState == 0 || Client.gameState == 5) {
            var2 = 20;
            var0.method3676("RuneScape is loading - please wait...", 382, 245 - var2, 16777215, -1);
            var3 = 253 - var2;
            Rasterizer2D.method1995(230, var3, 304, 34, 9179409);
            Rasterizer2D.method1995(231, var3 + 1, 302, 32, 0);
            Rasterizer2D.method1962(232, var3 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
            Rasterizer2D.method1962(Login.Login_loadingPercent * 3 + 232, var3 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
            var0.method3676(Login.Login_loadingText, 382, 276 - var2, 16777215, -1);
         }

         String var4;
         short var16;
         int var17;
         short var18;
         if (Client.gameState == 20) {
            Login.field314.method1936(382 - Login.field314.subWidth / 2, 271 - Login.field314.subHeight / 2);
            var16 = 211;
            var0.method3676(Login.Login_response1, 382, var16, 16776960, 0);
            var17 = var16 + 15;
            var0.method3676(Login.Login_response2, 382, var17, 16776960, 0);
            var17 += 15;
            var0.method3676(Login.Login_response3, 382, var17, 16776960, 0);
            var17 += 15;
            var17 += 10;
            var0.method3626("Login: ", 272, var17, 16777215, 0);
            var18 = 200;

            for(var4 = Login.field338; var0.method3601(var4) > var18; var4 = var4.substring(0, var4.length() - 1)) {
               ;
            }

            var0.method3626(AbstractFont.method3605(var4), 312, var17, 16777215, 0);
            var17 += 15;
            var0.method3626("Password: " + ByteArrayPool.method2507(Login.field339), 274, var17, 16777215, 0);
            var17 += 15;
         }

         if (Client.gameState == 10) {
            Login.field314.method1936(202, 171);
            short var13;
            if (Login.field351 == 0) {
               var16 = 251;
               var0.method3676("Welcome to RuneScape", 382, var16, 16776960, 0);
               var17 = var16 + 30;
               var18 = 302;
               var13 = 291;
               Login.field315.method1936(var18 - 73, var13 - 20);
               var0.method3609("New User", var18 - 73, var13 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var18 = 462;
               Login.field315.method1936(var18 - 73, var13 - 20);
               var0.method3609("Existing User", var18 - 73, var13 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if (Login.field351 == 2) {
               var16 = 211;
               var0.method3676(Login.Login_response1, 382, var16, 16776960, 0);
               var17 = var16 + 15;
               var0.method3676(Login.Login_response2, 382, var17, 16776960, 0);
               var17 += 15;
               var0.method3676(Login.Login_response3, 382, var17, 16776960, 0);
               var17 += 15;
               var17 += 10;
               var0.method3626("Login: ", 272, var17, 16777215, 0);
               var18 = 200;

               for(var4 = Login.field338; var0.method3601(var4) > var18; var4 = var4.substring(1)) {
                  ;
               }

               var0.method3626(AbstractFont.method3605(var4) + (Login.field340 == 0 & Client.cycle % 40 < 20 ? ScriptEvent.method0(16776960) + "|" : ""), 312, var17, 16777215, 0);
               var17 += 15;
               var0.method3626("Password: " + ByteArrayPool.method2507(Login.field339) + (Login.field340 == 1 & Client.cycle % 40 < 20 ? ScriptEvent.method0(16776960) + "|" : ""), 274, var17, 16777215, 0);
               var17 += 15;
               short var5 = 302;
               short var6 = 321;
               Login.field315.method1936(var5 - 73, var6 - 20);
               var0.method3676("Login", var5, var6 + 5, 16777215, 0);
               var5 = 462;
               Login.field315.method1936(var5 - 73, var6 - 20);
               var0.method3676("Cancel", var5, var6 + 5, 16777215, 0);
            } else if (Login.field351 == 3) {
               var0.method3676("How to Play", 382, 211, 16776960, 0);
               var16 = 236;
               var0.method3676("", 382, var16, 16777215, 0);
               var17 = var16 + 15;
               var0.method3676("To play Old School RuneScape, you will", 382, var17, 16777215, 0);
               var17 += 15;
               var0.method3676("need to be a current RuneScape member.", 382, var17, 16777215, 0);
               var17 += 15;
               var0.method3676("", 382, var17, 16777215, 0);
               var17 += 15;
               var18 = 382;
               var13 = 321;
               Login.field315.method1936(var18 - 73, var13 - 20);
               var0.method3676("Cancel", var18, var13 + 5, 16777215, 0);
            }
         }

         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var19;
         int var20;
         int var22;
         if (Login.field330 > 0) {
            var17 = Login.field330;
            var18 = 256;
            Login.field328 += var17 * 128;
            if (Login.field328 > InterfaceParent.field58.length) {
               Login.field328 -= InterfaceParent.field58.length;
               var22 = (int)(Math.random() * 12.0D);
               TileItem.method181(Login.field341[var22]);
            }

            var22 = 0;
            var19 = var17 * 128;
            var20 = (var18 - var17) * 128;

            for(var7 = 0; var7 < var20; ++var7) {
               var8 = AbstractByteArrayCopier.field2005[var22 + var19] - InterfaceParent.field58[var22 + Login.field328 & InterfaceParent.field58.length - 1] * var17 / 6;
               if (var8 < 0) {
                  var8 = 0;
               }

               AbstractByteArrayCopier.field2005[var22++] = var8;
            }

            for(var7 = var18 - var17; var7 < var18; ++var7) {
               var8 = var7 * 128;

               for(var9 = 0; var9 < 128; ++var9) {
                  var10 = (int)(Math.random() * 100.0D);
                  if (var10 < 50 && var9 > 10 && var9 < 118) {
                     AbstractByteArrayCopier.field2005[var9 + var8] = 255;
                  } else {
                     AbstractByteArrayCopier.field2005[var9 + var8] = 0;
                  }
               }
            }

            if (Login.field325 > 0) {
               Login.field325 -= var17 * 4;
            }

            if (Login.field352 > 0) {
               Login.field352 -= var17 * 4;
            }

            if (Login.field325 == 0 && Login.field352 == 0) {
               var7 = (int)(Math.random() * (double)(2000 / var17));
               if (var7 == 0) {
                  Login.field325 = 1024;
               }

               if (var7 == 1) {
                  Login.field352 = 1024;
               }
            }

            for(var7 = 0; var7 < var18 - var17; ++var7) {
               Login.field323[var7] = Login.field323[var7 + var17];
            }

            for(var7 = var18 - var17; var7 < var18; ++var7) {
               Login.field323[var7] = (int)(Math.sin((double)Login.field331 / 14.0D) * 16.0D + Math.sin((double)Login.field331 / 15.0D) * 14.0D + Math.sin((double)Login.field331 / 16.0D) * 12.0D);
               ++Login.field331;
            }

            Login.field329 += var17;
            var7 = (var17 + (Client.cycle & 1)) / 2;
            if (var7 > 0) {
               for(var8 = 0; var8 < Login.field329 * 100; ++var8) {
                  var9 = (int)(Math.random() * 124.0D) + 2;
                  var10 = (int)(Math.random() * 128.0D) + 128;
                  AbstractByteArrayCopier.field2005[var9 + (var10 << 7)] = 192;
               }

               Login.field329 = 0;
               var8 = 0;

               label343:
               while(true) {
                  if (var8 >= var18) {
                     var8 = 0;

                     while(true) {
                        if (var8 >= 128) {
                           break label343;
                        }

                        var9 = 0;

                        for(var10 = -var7; var10 < var18; ++var10) {
                           var11 = var10 * 128;
                           if (var10 + var7 < var18) {
                              var9 += Login.field327[var11 + var8 + var7 * 128];
                           }

                           if (var10 - (var7 + 1) >= 0) {
                              var9 -= Login.field327[var8 + var11 - (var7 + 1) * 128];
                           }

                           if (var10 >= 0) {
                              AbstractByteArrayCopier.field2005[var8 + var11] = var9 / (var7 * 2 + 1);
                           }
                        }

                        ++var8;
                     }
                  }

                  var9 = 0;
                  var10 = var8 * 128;

                  for(var11 = -var7; var11 < 128; ++var11) {
                     if (var11 + var7 < 128) {
                        var9 += AbstractByteArrayCopier.field2005[var7 + var11 + var10];
                     }

                     if (var11 - (var7 + 1) >= 0) {
                        var9 -= AbstractByteArrayCopier.field2005[var11 + var10 - (var7 + 1)];
                     }

                     if (var11 >= 0) {
                        Login.field327[var10 + var11] = var9 / (var7 * 2 + 1);
                     }
                  }

                  ++var8;
               }
            }

            Login.field330 = 0;
         }

         var16 = 256;
         if (Login.field325 > 0) {
            for(var3 = 0; var3 < 256; ++var3) {
               if (Login.field325 > 768) {
                  Buffer.field2040[var3] = class5.method39(Tiles.field129[var3], Login.field324[var3], 1024 - Login.field325);
               } else if (Login.field325 > 256) {
                  Buffer.field2040[var3] = Login.field324[var3];
               } else {
                  Buffer.field2040[var3] = class5.method39(Login.field324[var3], Tiles.field129[var3], 256 - Login.field325);
               }
            }
         } else if (Login.field352 > 0) {
            for(var3 = 0; var3 < 256; ++var3) {
               if (Login.field352 > 768) {
                  Buffer.field2040[var3] = class5.method39(Tiles.field129[var3], class1.field22[var3], 1024 - Login.field352);
               } else if (Login.field352 > 256) {
                  Buffer.field2040[var3] = class1.field22[var3];
               } else {
                  Buffer.field2040[var3] = class5.method39(class1.field22[var3], Tiles.field129[var3], 256 - Login.field352);
               }
            }
         } else {
            for(var3 = 0; var3 < 256; ++var3) {
               Buffer.field2040[var3] = Tiles.field129[var3];
            }
         }

         Rasterizer2D.method1953(0, 9, 128, var16 + 7);
         Login.field317.method1835(0, 0);
         Rasterizer2D.method1952();
         var3 = 0;
         var22 = 6885;

         int var12;
         for(var19 = 1; var19 < var16 - 1; ++var19) {
            var20 = Login.field323[var19] * (var16 - var19) / var16;
            var7 = var20 + 22;
            if (var7 < 0) {
               var7 = 0;
            }

            var3 += var7;

            for(var8 = var7; var8 < 128; ++var8) {
               var9 = AbstractByteArrayCopier.field2005[var3++];
               if (var9 != 0) {
                  var10 = var9;
                  var11 = 256 - var9;
                  var9 = Buffer.field2040[var9];
                  var12 = MouseRecorder.field262.pixels[var22];
                  MouseRecorder.field262.pixels[var22++] = ((var12 & 16711935) * var11 + (var9 & 16711935) * var10 & -16711936) + (var10 * (var9 & '\uff00') + var11 * (var12 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var22;
               }
            }

            var22 += var7 + 765 - 128;
         }

         Rasterizer2D.method1953(637, 9, 765, var16 + 7);
         Login.field332.method1835(382, 0);
         Rasterizer2D.method1952();
         var3 = 0;
         var22 = 7546;

         for(var19 = 1; var19 < var16 - 1; ++var19) {
            var20 = Login.field323[var19] * (var16 - var19) / var16;
            var7 = 103 - var20;
            var22 += var20;

            for(var8 = 0; var8 < var7; ++var8) {
               var9 = AbstractByteArrayCopier.field2005[var3++];
               if (var9 != 0) {
                  var10 = var9;
                  var11 = 256 - var9;
                  var9 = Buffer.field2040[var9];
                  var12 = MouseRecorder.field262.pixels[var22];
                  MouseRecorder.field262.pixels[var22++] = (var10 * (var9 & '\uff00') + var11 * (var12 & '\uff00') & 16711680) + ((var9 & 16711935) * var10 + (var12 & 16711935) * var11 & -16711936) >> 8;
               } else {
                  ++var22;
               }
            }

            var3 += 128 - var7;
            var22 += 765 - var7 - var20;
         }

         class68.field1273[Projectile.clientPreferences.titleMusicDisabled ? 1 : 0].method1936(725, 463);
         if (Client.gameState > 5) {
            if (class120.field2015 != null) {
               var2 = 5;
               var18 = 463;
               byte var23 = 100;
               byte var21 = 35;
               class120.field2015.method1936(var2, var18);
               var0.method3676("World" + " " + Client.ViewportMouse_x, var23 / 2 + var2, var21 / 2 + var18 - 2, 16777215, 0);
               if (Projectile.field171 != null) {
                  var1.method3676("Loading...", var23 / 2 + var2, var21 / 2 + var18 + 12, 16777215, 0);
               } else {
                  var1.method3676("Click to switch", var23 / 2 + var2, var21 / 2 + var18 + 12, 16777215, 0);
               }
            } else {
               class120.field2015 = TaskHandler.method1598(MouseRecorder.archive8, "sl_button", "");
            }
         }

         try {
            Graphics var14 = Tiles.field131.getGraphics();
            MouseRecorder.field262.vmethod1945(var14, 0, 0);
         } catch (Exception var15) {
            Tiles.field131.repaint();
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(ILclass151;Ljava/lang/String;Ljava/lang/String;IZ)V"
   )
   public static void method34(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3219(var2);
      int var7 = var1.method3238(var6, var3);
      ObjectSound.method43(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("m")
   static final int method37(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("af")
   static final void method36() {
      if (!Client.isMenuOpen) {
         Client.menuActions[0] = "Cancel";
         Client.menuTargets[0] = "";
         Client.menuOpcodes[0] = 1006;
         Client.menuOptionsCount = 1;
      }

      int var0;
      if (Client.field643 != -1) {
         var0 = Client.field643;
         if (EnumComposition.method852(var0)) {
            ObjectComposition.method698(Widget.Widget_interfaceComponents[var0], -1);
         }
      }

      for(var0 = 0; var0 < Client.rootWidgetCount; ++var0) {
         if (Client.field686[var0]) {
            Client.field687[var0] = true;
         }

         Client.field688[var0] = Client.field686[var0];
         Client.field686[var0] = false;
      }

      Client.field685 = Client.cycle;
      Client.field633 = -1;
      Client.field634 = -1;
      class7.field113 = null;
      int var1;
      if (Client.field643 != -1) {
         Client.rootWidgetCount = 0;
         var0 = Client.field643;
         if (!EnumComposition.method852(var0)) {
            for(var1 = 0; var1 < 100; ++var1) {
               Client.field686[var1] = true;
            }
         } else {
            Buffer.field2049 = null;
            AbstractRasterProvider.method1816(Widget.Widget_interfaceComponents[var0], -1, 0, 0, 765, 503, 0, 0, -1);
            if (Buffer.field2049 != null) {
               AbstractRasterProvider.method1816(Buffer.field2049, -1412584499, 0, 0, 765, 503, AbstractByteArrayCopier.field2008, Renderable.field1546, -1);
               Buffer.field2049 = null;
            }
         }
      }

      Rasterizer2D.method1952();
      boolean var5 = false;

      String var2;
      String var3;
      int var4;
      while(!var5) {
         var5 = true;

         for(var1 = 0; var1 < Client.menuOptionsCount - 1; ++var1) {
            if (Client.menuOpcodes[var1] < 1000 && Client.menuOpcodes[var1 + 1] > 1000) {
               var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               var3 = Client.menuActions[var1];
               Client.menuActions[var1] = Client.menuActions[var1 + 1];
               Client.menuActions[var1 + 1] = var3;
               var4 = Client.menuOpcodes[var1];
               Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
               Client.menuOpcodes[var1 + 1] = var4;
               var4 = Client.menuArguments1[var1];
               Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
               Client.menuArguments1[var1 + 1] = var4;
               var4 = Client.menuArguments2[var1];
               Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
               Client.menuArguments2[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               var5 = false;
            }
         }
      }

      if (!Client.isMenuOpen) {
         if (Client.field633 != -1) {
            var0 = Client.field633;
            var1 = Client.field634;
            if (Client.menuOptionsCount >= 2 || Client.isItemSelected != 0 || Client.isSpellSelected) {
               if (Client.isItemSelected == 1 && Client.menuOptionsCount < 2) {
                  var2 = "Use" + " " + Client.selectedItemName + " " + "->";
               } else if (Client.isSpellSelected && Client.menuOptionsCount < 2) {
                  var2 = Client.field641 + " " + Client.field594 + " " + "->";
               } else {
                  var4 = Client.menuOptionsCount - 1;
                  if (Client.menuTargets[var4].length() > 0) {
                     var3 = Client.menuActions[var4] + " " + Client.menuTargets[var4];
                  } else {
                     var3 = Client.menuActions[var4];
                  }

                  var2 = var3;
               }

               if (Client.menuOptionsCount > 2) {
                  var2 = var2 + ScriptEvent.method0(16777215) + " " + '/' + " " + (Client.menuOptionsCount - 2) + " more options";
               }

               class40.fontBold12.method3613(var2, var0 + 4, var1 + 15, 16777215, 0, Client.cycle / 1000);
            }
         }
      } else {
         Decimator.method1401();
      }

      if (Client.field693 == 3) {
         for(var0 = 0; var0 < Client.rootWidgetCount; ++var0) {
            if (Client.field688[var0]) {
               Rasterizer2D.method1958(Client.rootWidgetXs[var0], Client.rootWidgetYs[var0], Client.rootWidgetWidths[var0], Client.rootWidgetHeights[var0], 16711935, 128);
            } else if (Client.field687[var0]) {
               Rasterizer2D.method1958(Client.rootWidgetXs[var0], Client.rootWidgetYs[var0], Client.rootWidgetWidths[var0], Client.rootWidgetHeights[var0], 16711680, 128);
            }
         }
      }

      GameObject.method2206(class22.Client_plane, Tiles.localPlayer.x, Tiles.localPlayer.y, Client.field525);
      Client.field525 = 0;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(Lclass26;I)V"
   )
   static final void method33(Actor var0, int var1) {
      class1.method8(var0.x, var0.y, var1);
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      descriptor = "(IIIILclass85;)V"
   )
   static final void method35(int var0, int var1, int var2, int var3, SpritePixels var4) {
      if (var4 != null) {
         int var5 = Client.field554 + Client.field569 & 2047;
         int var6 = var3 * var3 + var2 * var2;
         if (var6 <= 6400) {
            int var7 = Rasterizer3D.Rasterizer3D_sine[var5];
            int var8 = Rasterizer3D.Rasterizer3D_cosine[var5];
            var7 = var7 * 256 / (Client.field556 + 256);
            var8 = var8 * 256 / (Client.field556 + 256);
            int var9 = var8 * var2 + var3 * var7 >> 16;
            int var10 = var3 * var8 - var7 * var2 >> 16;
            if (var6 > 2500) {
               var4.method1851(TextureProvider.field1834, var0 + var9 + 94 - var4.width / 2 + 4, var1 + 83 - var10 - var4.height / 2 - 4);
            } else {
               var4.method1855(var0 + var9 + 94 - var4.width / 2 + 4, var1 + 83 - var10 - var4.height / 2 - 4);
            }

         }
      }
   }
}
