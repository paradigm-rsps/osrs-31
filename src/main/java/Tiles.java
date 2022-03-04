import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("Tiles")
public final class Tiles {
   @ObfuscatedName("pa")
   public static java.awt.Canvas field131;
   @ObfuscatedName("if")
   @Export("mousedOverWidgetIf1")
   @ObfuscatedSignature(
      descriptor = "Lclass157;"
   )
   static Widget mousedOverWidgetIf1;
   @ObfuscatedName("hm")
   @Export("localPlayer")
   @ObfuscatedSignature(
      descriptor = "Lclass2;"
   )
   static Player localPlayer;
   @ObfuscatedName("i")
   @Export("Tiles_heights")
   static int[][][] Tiles_heights = new int[4][105][105];
   @ObfuscatedName("w")
   @Export("Tiles_renderFlags")
   static byte[][][] Tiles_renderFlags = new byte[4][104][104];
   @ObfuscatedName("f")
   @Export("Tiles_minPlane")
   static int Tiles_minPlane = 99;
   @ObfuscatedName("e")
   @Export("Tiles_underlays")
   static byte[][][] Tiles_underlays;
   @ObfuscatedName("d")
   @Export("Tiles_shapes")
   static byte[][][] Tiles_shapes;
   @ObfuscatedName("k")
   static byte[][][] field132;
   @ObfuscatedName("r")
   static int[][] field120;
   @ObfuscatedName("l")
   @Export("Tiles_hue")
   static int[] Tiles_hue;
   @ObfuscatedName("g")
   static int[] field129;
   @ObfuscatedName("j")
   static final int[] field124 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("n")
   static final int[] field125 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("q")
   static final int[] field115 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("c")
   static final int[] field127 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("h")
   static final int[] field128 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("b")
   static final int[] field134 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("y")
   @Export("rndHue")
   static int rndHue = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("x")
   @Export("rndLightness")
   static int rndLightness = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("bd")
   @Export("archive15")
   @ObfuscatedSignature(
      descriptor = "Lclass153;"
   )
   static Archive archive15;

   @ObfuscatedName("i")
   @Export("method112")
   public static boolean method112(CharSequence var0) {
      return InterfaceParent.method30(var0, 10, true);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Lclass151;Lclass151;)V"
   )
   public static void method106(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
      SequenceDefinition.SequenceDefinition_archive = var0;
      SequenceDefinition.SequenceDefinition_animationsArchive = var1;
      SequenceDefinition.SequenceDefinition_skeletonsArchive = var2;
   }

   @ObfuscatedName("i")
   static int method95(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.method3512((long)var0);
      if (var2 == null) {
         return 0;
      } else {
         return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
      }
   }

   @ObfuscatedName("w")
   @Export("method107")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Throwable;Ljava/lang/String;)Lclass79;"
   )
   public static RunException method107(Throwable var0, String var1) {
      RunException var2;
      if (var0 instanceof RunException) {
         var2 = (RunException)var0;
         var2.message = var2.message + ' ' + var1;
      } else {
         var2 = new RunException(var0, var1);
      }

      return var2;
   }

   @ObfuscatedName("e")
   @Export("method110")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Z)Lclass28;"
   )
   public static AccessFile method110(String var0, String var1, boolean var2) {
      File var3 = new File(JagexCache.cacheDir, "preferences" + var0 + ".dat");
      if (var3.exists()) {
         try {
            AccessFile var10 = new AccessFile(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if (JagexCache.cacheGamebuild == 33) {
         var4 = "_rc";
      } else if (JagexCache.cacheGamebuild == 34) {
         var4 = "_wip";
      }

      File var5 = new File(TextureProvider.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      AccessFile var6;
      if (!var2 && var5.exists()) {
         try {
            var6 = new AccessFile(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new AccessFile(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("bh")
   static final void method59(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Interpreter.scene.method2057(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if (var5 != 0) {
         var6 = Interpreter.scene.method2071(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if (var5 > 0) {
            var9 = var4;
         }

         int[] var10 = MouseRecorder.sceneMinimapSprite.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = GameBuild.getObjectComposition(var12);
         if (var13.mapSceneId != -1) {
            IndexedSprite var14 = Decimator.mapSceneSprites[var13.mapSceneId];
            if (var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.subWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.subHeight) / 2;
               var14.method1936(var15 + var1 * 4 + 48, (104 - var2 - var13.sizeY) * 4 + var16 + 48);
            }
         } else {
            if (var8 == 0 || var8 == 2) {
               if (var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if (var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if (var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if (var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if (var8 == 3) {
               if (var7 == 0) {
                  var10[var11] = var9;
               } else if (var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if (var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if (var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if (var8 == 2) {
               if (var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if (var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if (var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if (var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = Interpreter.scene.method2069(var0, var1, var2);
      if (var5 != 0) {
         var6 = Interpreter.scene.method2071(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = GameBuild.getObjectComposition(var9);
         int var18;
         if (var23.mapSceneId != -1) {
            IndexedSprite var19 = Decimator.mapSceneSprites[var23.mapSceneId];
            if (var19 != null) {
               var12 = (var23.sizeX * 4 - var19.subWidth) / 2;
               var18 = (var23.sizeY * 4 - var19.subHeight) / 2;
               var19.method1936(var12 + var1 * 4 + 48, var18 + (104 - var2 - var23.sizeY) * 4 + 48);
            }
         } else if (var8 == 9) {
            var11 = 15658734;
            if (var5 > 0) {
               var11 = 15597568;
            }

            int[] var17 = MouseRecorder.sceneMinimapSprite.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if (var7 != 0 && var7 != 2) {
               var17[var18] = var11;
               var17[var18 + 1 + 512] = var11;
               var17[var18 + 1024 + 2] = var11;
               var17[var18 + 1536 + 3] = var11;
            } else {
               var17[var18 + 1536] = var11;
               var17[var18 + 1 + 1024] = var11;
               var17[var18 + 512 + 2] = var11;
               var17[var18 + 3] = var11;
            }
         }
      }

      var5 = Interpreter.scene.method2070(var0, var1, var2);
      if (var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = GameBuild.getObjectComposition(var6);
         if (var20.mapSceneId != -1) {
            IndexedSprite var21 = Decimator.mapSceneSprites[var20.mapSceneId];
            if (var21 != null) {
               var9 = (var20.sizeX * 4 - var21.subWidth) / 2;
               int var22 = (var20.sizeY * 4 - var21.subHeight) / 2;
               var21.method1936(var1 * 4 + var9 + 48, var22 + (104 - var2 - var20.sizeY) * 4 + 48);
            }
         }
      }

   }

   @ObfuscatedName("bx")
   static boolean method93(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("cw")
   @Export("method99")
   static final void method99(int var0) {
      if (EnumComposition.method852(var0)) {
         Widget[] var1 = Widget.Widget_interfaceComponents[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if (var3 != null) {
               var3.modelFrame = 0;
               var3.modelFrameCycle = 0;
            }
         }

      }
   }

   @ObfuscatedName("cs")
   @Export("method60")
   @ObfuscatedSignature(
      descriptor = "(Lclass3;Z)V"
   )
   static final void method60(InterfaceParent var0, boolean var1) {
      int var2 = var0.group;
      int var3 = (int)var0.key;
      var0.method3567();
      int var5;
      if (var1 && var2 != -1 && Widget.Widget_loadedInterfaces[var2]) {
         Widget.Widget_archive.method3216(var2);
         if (Widget.Widget_interfaceComponents[var2] != null) {
            boolean var4 = true;

            for(var5 = 0; var5 < Widget.Widget_interfaceComponents[var2].length; ++var5) {
               if (Widget.Widget_interfaceComponents[var2][var5] != null) {
                  if (Widget.Widget_interfaceComponents[var2][var5].type != 2) {
                     Widget.Widget_interfaceComponents[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if (var4) {
               Widget.Widget_interfaceComponents[var2] = null;
            }

            Widget.Widget_loadedInterfaces[var2] = false;
         }
      }

      for(IntegerNode var7 = (IntegerNode)Client.widgetFlags.method3515(); var7 != null; var7 = (IntegerNode)Client.widgetFlags.method3516()) {
         if ((long)var2 == (var7.key >> 48 & 65535L)) {
            var7.method3567();
         }
      }

      Widget var8 = class130.getWidget(var3);
      if (var8 != null) {
         class82.invalidateWidget(var8);
      }

      for(var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
         if (method93(Client.menuOpcodes[var5])) {
            if (var5 < Client.menuOptionsCount - 1) {
               for(int var6 = var5; var6 < Client.menuOptionsCount - 1; ++var6) {
                  Client.menuActions[var6] = Client.menuActions[var6 + 1];
                  Client.menuTargets[var6] = Client.menuTargets[var6 + 1];
                  Client.menuOpcodes[var6] = Client.menuOpcodes[var6 + 1];
                  Client.menuIdentifiers[var6] = Client.menuIdentifiers[var6 + 1];
                  Client.menuArguments1[var6] = Client.menuArguments1[var6 + 1];
                  Client.menuArguments2[var6] = Client.menuArguments2[var6 + 1];
               }
            }

            --Client.menuOptionsCount;
         }
      }

      if (Client.field643 != -1) {
         SceneTilePaint.method2208(Client.field643, 1);
      }

   }
}
