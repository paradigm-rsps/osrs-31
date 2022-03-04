import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("KeyHandler")
public final class KeyHandler implements KeyListener, FocusListener {
   @ObfuscatedName("i")
   @Export("KeyHandler_instance")
   @ObfuscatedSignature(
      descriptor = "Lclass74;"
   )
   public static KeyHandler KeyHandler_instance = new KeyHandler();
   @ObfuscatedName("br")
   @Export("archive14")
   @ObfuscatedSignature(
      descriptor = "Lclass153;"
   )
   static Archive archive14;
   @ObfuscatedName("cu")
   @Export("KeyHandler_pressedKeys")
   public static boolean[] KeyHandler_pressedKeys = new boolean[112];
   @ObfuscatedName("cm")
   static int[] field1370 = new int[128];
   @ObfuscatedName("ch")
   static int field1363 = 0;
   @ObfuscatedName("cz")
   public static int field1360 = 0;
   @ObfuscatedName("cw")
   static char[] field1361 = new char[128];
   @ObfuscatedName("cr")
   static int[] field1362 = new int[128];
   @ObfuscatedName("cy")
   public static int[] field1348 = new int[128];
   @ObfuscatedName("cs")
   public static int field1364 = 0;
   @ObfuscatedName("cf")
   static int field1365 = 0;
   @ObfuscatedName("ci")
   static int field1356 = 0;
   @ObfuscatedName("cb")
   static int field1343 = 0;
   @ObfuscatedName("cl")
   @Export("KeyHandler_idleCycles")
   public static volatile int KeyHandler_idleCycles = 0;
   @ObfuscatedName("co")
   public static int[] field1359 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

   public final void keyTyped(KeyEvent var1) {
      if (KeyHandler_instance != null) {
         char var2 = var1.getKeyChar();
         if (var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if (var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label57: {
                  if (var2 != 0) {
                     char[] var4 = class148.cp1252AsciiExtension;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if (var6 == var2) {
                           var3 = true;
                           break label57;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if (var3) {
               int var7 = field1356 + 1 & 127;
               if (var7 != field1365) {
                  field1362[field1356] = -1;
                  field1361[field1356] = var2;
                  field1356 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if (KeyHandler_instance != null) {
         KeyHandler_idleCycles = 0;
         int var2 = var1.getKeyCode();
         if (var2 >= 0 && var2 < field1359.length) {
            var2 = field1359[var2];
            if ((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if (field1360 >= 0 && var2 >= 0) {
            field1370[field1360] = var2;
            field1360 = field1360 + 1 & 127;
            if (field1363 == field1360) {
               field1360 = -1;
            }
         }

         int var3;
         if (var2 >= 0) {
            var3 = field1356 + 1 & 127;
            if (var3 != field1365) {
               field1362[field1356] = var2;
               field1361[field1356] = 0;
               field1356 = var3;
            }
         }

         var3 = var1.getModifiers();
         if ((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if (KeyHandler_instance != null) {
         field1360 = -1;
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if (KeyHandler_instance != null) {
         KeyHandler_idleCycles = 0;
         int var2 = var1.getKeyCode();
         if (var2 >= 0 && var2 < field1359.length) {
            var2 = field1359[var2] & -129;
         } else {
            var2 = -1;
         }

         if (field1360 >= 0 && var2 >= 0) {
            field1370[field1360] = ~var2;
            field1360 = field1360 + 1 & 127;
            if (field1363 == field1360) {
               field1360 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IIIIZ)Lclass85;"
   )
   public static final SpritePixels method1647(int var0, int var1, int var2, int var3, boolean var4) {
      long var5 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var3 << 40);
      SpritePixels var7;
      if (!var4) {
         var7 = (SpritePixels)ItemComposition.ItemDefinition_cachedSprites.method3474(var5);
         if (var7 != null) {
            return var7;
         }
      }

      ItemComposition var8 = class27.method571(var0);
      if (var1 > 1 && var8.countobj != null) {
         int var9 = -1;

         for(int var10 = 0; var10 < 10; ++var10) {
            if (var1 >= var8.countco[var10] && var8.countco[var10] != 0) {
               var9 = var8.countobj[var10];
            }
         }

         if (var9 != -1) {
            var8 = class27.method571(var9);
         }
      }

      Model var20 = var8.method886(1);
      if (var20 == null) {
         return null;
      } else {
         SpritePixels var21 = null;
         if (var8.noteTemplate != -1) {
            var21 = method1647(var8.note, 10, 1, 0, true);
            if (var21 == null) {
               return null;
            }
         }

         int[] var11 = Rasterizer2D.Rasterizer2D_pixels;
         int var12 = Rasterizer2D.Rasterizer2D_width;
         int var13 = Rasterizer2D.Rasterizer2D_height;
         int[] var14 = new int[4];
         Rasterizer2D.method1955(var14);
         var7 = new SpritePixels(36, 32);
         Rasterizer2D.method1951(var7.pixels, 36, 32);
         Rasterizer2D.method1957();
         Rasterizer3D.method2352();
         Rasterizer3D.method2303(16, 16);
         Rasterizer3D.field1766 = false;
         int var15 = var8.zoom2d;
         if (var4) {
            var15 = (int)((double)var15 * 1.5D);
         } else if (var2 == 2) {
            var15 = (int)(1.04D * (double)var15);
         }

         int var16 = var15 * Rasterizer3D.Rasterizer3D_sine[var8.xan2d] >> 16;
         int var17 = var15 * Rasterizer3D.Rasterizer3D_cosine[var8.xan2d] >> 16;
         var20.method2427();
         var20.method2439(0, var8.yan2d, var8.zan2d, var8.xan2d, var8.offsetX2d, var20.height / 2 + var16 + var8.offsetY2d, var17 + var8.offsetY2d);
         if (var2 >= 1) {
            var7.method1833(1);
         }

         if (var2 >= 2) {
            var7.method1833(16777215);
         }

         if (var3 != 0) {
            var7.method1834(var3);
         }

         Rasterizer2D.method1951(var7.pixels, 36, 32);
         if (var8.noteTemplate != -1) {
            var21.method1855(0, 0);
         }

         if (!var4 && (var8.isStackable == 1 || var1 != 1) && var1 != -1) {
            Font var18 = ClientPreferences.field188;
            String var19;
            if (var1 < 100000) {
               var19 = "<col=ffff00>" + var1 + "</col>";
            } else if (var1 < 10000000) {
               var19 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var19 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var18.method3626(var19, 0, 9, 16776960, 1);
         }

         if (!var4) {
            ItemComposition.ItemDefinition_cachedSprites.method3473(var7, var5);
         }

         Rasterizer2D.method1951(var11, var12, var13);
         Rasterizer2D.method1956(var14);
         Rasterizer3D.method2352();
         Rasterizer3D.field1766 = true;
         return var7;
      }
   }

   @ObfuscatedName("ah")
   static final void method1649() {
      int var0 = World.field209 * 128 + 64;
      int var1 = Interpreter.field416 * 128 + 64;
      int var2 = BufferedFile.getTileHeight(var0, var1, class22.Client_plane) - class5.field73;
      if (Login.cameraX < var0) {
         Login.cameraX = (var0 - Login.cameraX) * SoundCache.field1206 / 1000 + Login.cameraX + ObjectSound.field78;
         if (Login.cameraX > var0) {
            Login.cameraX = var0;
         }
      }

      if (Login.cameraX > var0) {
         Login.cameraX -= SoundCache.field1206 * (Login.cameraX - var0) / 1000 + ObjectSound.field78;
         if (Login.cameraX < var0) {
            Login.cameraX = var0;
         }
      }

      if (class22.cameraY < var2) {
         class22.cameraY = (var2 - class22.cameraY) * SoundCache.field1206 / 1000 + class22.cameraY + ObjectSound.field78;
         if (class22.cameraY > var2) {
            class22.cameraY = var2;
         }
      }

      if (class22.cameraY > var2) {
         class22.cameraY -= SoundCache.field1206 * (class22.cameraY - var2) / 1000 + ObjectSound.field78;
         if (class22.cameraY < var2) {
            class22.cameraY = var2;
         }
      }

      if (class17.cameraZ < var1) {
         class17.cameraZ = (var1 - class17.cameraZ) * SoundCache.field1206 / 1000 + class17.cameraZ + ObjectSound.field78;
         if (class17.cameraZ > var1) {
            class17.cameraZ = var1;
         }
      }

      if (class17.cameraZ > var1) {
         class17.cameraZ -= SoundCache.field1206 * (class17.cameraZ - var1) / 1000 + ObjectSound.field78;
         if (class17.cameraZ < var1) {
            class17.cameraZ = var1;
         }
      }

      var0 = AccessFile.field757 * 128 + 64;
      var1 = class125.field2036 * 128 + 64;
      var2 = BufferedFile.getTileHeight(var0, var1, class22.Client_plane) - SceneTilePaint.field1681;
      int var3 = var0 - Login.cameraX;
      int var4 = var2 - class22.cameraY;
      int var5 = var1 - class17.cameraZ;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if (var7 < 128) {
         var7 = 128;
      }

      if (var7 > 383) {
         var7 = 383;
      }

      if (NPC.cameraPitch < var7) {
         NPC.cameraPitch = (var7 - NPC.cameraPitch) * class65.field1268 / 1000 + NPC.cameraPitch + FaceNormal.field1519;
         if (NPC.cameraPitch > var7) {
            NPC.cameraPitch = var7;
         }
      }

      if (NPC.cameraPitch > var7) {
         NPC.cameraPitch -= class65.field1268 * (NPC.cameraPitch - var7) / 1000 + FaceNormal.field1519;
         if (NPC.cameraPitch < var7) {
            NPC.cameraPitch = var7;
         }
      }

      int var9 = var8 - MouseRecorder.cameraYaw;
      if (var9 > 1024) {
         var9 -= 2048;
      }

      if (var9 < -1024) {
         var9 += 2048;
      }

      if (var9 > 0) {
         MouseRecorder.cameraYaw = MouseRecorder.cameraYaw + FaceNormal.field1519 + var9 * class65.field1268 / 1000;
         MouseRecorder.cameraYaw &= 2047;
      }

      if (var9 < 0) {
         MouseRecorder.cameraYaw -= FaceNormal.field1519 + -var9 * class65.field1268 / 1000;
         MouseRecorder.cameraYaw &= 2047;
      }

      int var10 = var8 - MouseRecorder.cameraYaw;
      if (var10 > 1024) {
         var10 -= 2048;
      }

      if (var10 < -1024) {
         var10 += 2048;
      }

      if (var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         MouseRecorder.cameraYaw = var8;
      }

   }

   @ObfuscatedName("bp")
   @Export("method1648")
   static final void method1648(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if (Client.isLowDetail && var0 != class22.Client_plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if (var1 == 0) {
            var7 = Interpreter.scene.method2057(var0, var2, var3);
         }

         if (var1 == 1) {
            var7 = Interpreter.scene.method2061(var0, var2, var3);
         }

         if (var1 == 2) {
            var7 = Interpreter.scene.method2069(var0, var2, var3);
         }

         if (var1 == 3) {
            var7 = Interpreter.scene.method2070(var0, var2, var3);
         }

         int var11;
         if (var7 != 0) {
            var11 = Interpreter.scene.method2071(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if (var1 == 0) {
               Interpreter.scene.method2058(var0, var2, var3);
               var12 = GameBuild.getObjectComposition(var13);
               if (var12.interactType != 0) {
                  Client.collisionMaps[var0].method3432(var2, var3, var14, var15, var12.boolean1);
               }
            }

            if (var1 == 1) {
               Interpreter.scene.method2059(var0, var2, var3);
            }

            if (var1 == 2) {
               Interpreter.scene.method2043(var0, var2, var3);
               var12 = GameBuild.getObjectComposition(var13);
               if (var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if (var12.interactType != 0) {
                  Client.collisionMaps[var0].method3446(var2, var3, var12.sizeX, var12.sizeY, var15, var12.boolean1);
               }
            }

            if (var1 == 3) {
               Interpreter.scene.method2184(var0, var2, var3);
               var12 = GameBuild.getObjectComposition(var13);
               if (var12.interactType == 1) {
                  Client.collisionMaps[var0].method3425(var2, var3);
               }
            }
         }

         if (var4 >= 0) {
            var11 = var0;
            if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            AbstractRasterProvider.method1819(var0, var11, var2, var3, var4, var5, var6, Interpreter.scene, Client.collisionMaps[var0]);
         }
      }

   }
}
