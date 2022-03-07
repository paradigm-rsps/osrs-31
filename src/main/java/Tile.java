import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("i")
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @Export("originalPlane")
   int originalPlane;
   @ObfuscatedName("t")
   @Export("paint")
   @ObfuscatedSignature(
      descriptor = "Lclass99;"
   )
   SceneTilePaint paint;
   @ObfuscatedName("d")
   @Export("model")
   @ObfuscatedSignature(
      descriptor = "Lclass92;"
   )
   SceneTileModel model;
   @ObfuscatedName("p")
   @Export("boundaryObject")
   @ObfuscatedSignature(
      descriptor = "Lclass95;"
   )
   BoundaryObject boundaryObject;
   @ObfuscatedName("k")
   @Export("wallDecoration")
   @ObfuscatedSignature(
      descriptor = "Lclass107;"
   )
   WallDecoration wallDecoration;
   @ObfuscatedName("r")
   @Export("floorDecoration")
   @ObfuscatedSignature(
      descriptor = "Lclass106;"
   )
   FloorDecoration floorDecoration;
   @ObfuscatedName("l")
   @Export("itemLayer")
   @ObfuscatedSignature(
      descriptor = "Lclass98;"
   )
   ItemLayer itemLayer;
   @ObfuscatedName("a")
   @Export("gameObjectsCount")
   int gameObjectsCount;
   @ObfuscatedName("z")
   @Export("gameObjects")
   @ObfuscatedSignature(
      descriptor = "[Lclass97;"
   )
   GameObject[] gameObjects = new GameObject[5];
   @ObfuscatedName("s")
   @Export("gameObjectEdgeMasks")
   int[] gameObjectEdgeMasks = new int[5];
   @ObfuscatedName("m")
   @Export("gameObjectsEdgeMask")
   int gameObjectsEdgeMask = 0;
   @ObfuscatedName("u")
   @Export("minPlane")
   int minPlane;
   @ObfuscatedName("g")
   @Export("drawPrimary")
   boolean drawPrimary;
   @ObfuscatedName("o")
   @Export("drawSecondary")
   boolean drawSecondary;
   @ObfuscatedName("v")
   @Export("drawGameObjects")
   boolean drawGameObjects;
   @ObfuscatedName("j")
   @Export("drawGameObjectEdges")
   int drawGameObjectEdges;
   @ObfuscatedName("n")
   int field1752;
   @ObfuscatedName("q")
   int field1753;
   @ObfuscatedName("c")
   int field1754;
   @ObfuscatedName("h")
   @Export("linkedBelowTile")
   @ObfuscatedSignature(
      descriptor = "Lclass101;"
   )
   Tile linkedBelowTile;

   Tile(int var1, int var2, int var3) {
      this.originalPlane = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("i")
   @Export("method2297")
   @ObfuscatedSignature(
      descriptor = "(I)Lclass4;"
   )
   static Script method2297(int var0) {
      Script var1 = (Script)Script.field68.method3474((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = AbstractByteArrayCopier.archive12.method3204(var0, 0);
         if (var2 == null) {
            return null;
         } else {
            var1 = new Script();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.array.length - 12;
            int var4 = var3.readInt();
            var1.field64 = var3.readUnsignedShort();
            var1.field65 = var3.readUnsignedShort();
            var1.field66 = var3.readUnsignedShort();
            var1.field70 = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2784();
            var1.field61 = new int[var4];
            var1.field62 = new int[var4];
            var1.field69 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.array.length - 12; var1.field61[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if (var6 == 3) {
                  var1.field69[var5] = var3.method2653();
               } else if (var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field62[var5] = var3.readInt();
               } else {
                  var1.field62[var5] = var3.readUnsignedByte();
               }
            }

            Script.field68.method3473(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   static String method2296(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("ba")
   static final boolean method2298(int var0, int var1, int var2) {
      int var3 = var2 >> 14 & 32767;
      int var4 = Interpreter.scene.method2071(class22.Client_plane, var0, var1, var2);
      if (var4 == -1) {
         return false;
      } else {
         int var5 = var4 & 31;
         int var6 = var4 >> 6 & 3;
         if (var5 != 10 && var5 != 11 && var5 != 22) {
            FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var0, var1, true, var5 + 1, var6, 0, 0, 0, 2);
         } else {
            ObjectComposition var7 = GameBuild.getObjectComposition(var3);
            int var8;
            int var9;
            if (var6 != 0 && var6 != 2) {
               var8 = var7.sizeY;
               var9 = var7.sizeX;
            } else {
               var8 = var7.sizeX;
               var9 = var7.sizeY;
            }

            int var10 = var7.field858;
            if (var6 != 0) {
               var10 = (var10 >> 4 - var6) + (var10 << var6 & 15);
            }

            FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var0, var1, true, 0, 0, var8, var9, var10, 2);
         }

         Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
         Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         return true;
      }
   }

   @ObfuscatedName("bl")
   @Export("method2300")
   @ObfuscatedSignature(
      descriptor = "(Lclass30;III)V"
   )
   static final void method2300(NPCComposition var0, int var1, int var2, int var3) {
      if (Client.menuOptionsCount < 400) {
         if (var0.transforms != null) {
            var0 = var0.method657();
         }

         if (var0 != null) {
            if (var0.isInteractable) {
               String var4 = var0.name;
               int var8;
               if (var0.category != 0) {
                  int var7 = var0.category;
                  var8 = Tiles.localPlayer.combatLevel;
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

                  var4 = var4 + var6 + " " + " (" + "level-" + var0.category + ")";
               }

               if (Client.isItemSelected == 1) {
                  ArchiveDisk.method1503("Use", Client.selectedItemName + " " + "->" + " " + ScriptEvent.method0(16776960) + var4, 7, var1, var2, var3);
               } else if (Client.isSpellSelected) {
                  if ((FaceNormal.field1523 & 2) == 2) {
                     ArchiveDisk.method1503(Client.field641, Client.field594 + " " + "->" + " " + ScriptEvent.method0(16776960) + var4, 8, var1, var2, var3);
                  }
               } else {
                  String[] var5 = var0.actions;
                  if (Client.field511) {
                     var5 = method2299(var5);
                  }

                  int var10;
                  if (var5 != null) {
                     for(var10 = 4; var10 >= 0; --var10) {
                        if (var5[var10] != null && !var5[var10].equalsIgnoreCase("Attack")) {
                           byte var11 = 0;
                           if (var10 == 0) {
                              var11 = 9;
                           }

                           if (var10 == 1) {
                              var11 = 10;
                           }

                           if (var10 == 2) {
                              var11 = 11;
                           }

                           if (var10 == 3) {
                              var11 = 12;
                           }

                           if (var10 == 4) {
                              var11 = 13;
                           }

                           ArchiveDisk.method1503(var5[var10], ScriptEvent.method0(16776960) + var4, var11, var1, var2, var3);
                        }
                     }
                  }

                  if (var5 != null) {
                     for(var10 = 4; var10 >= 0; --var10) {
                        if (var5[var10] != null && var5[var10].equalsIgnoreCase("Attack")) {
                           short var12 = 0;
                           if (var0.category > Tiles.localPlayer.combatLevel) {
                              var12 = 2000;
                           }

                           var8 = 0;
                           if (var10 == 0) {
                              var8 = var12 + 9;
                           }

                           if (var10 == 1) {
                              var8 = var12 + 10;
                           }

                           if (var10 == 2) {
                              var8 = var12 + 11;
                           }

                           if (var10 == 3) {
                              var8 = var12 + 12;
                           }

                           if (var10 == 4) {
                              var8 = var12 + 13;
                           }

                           ArchiveDisk.method1503(var5[var10], ScriptEvent.method0(16776960) + var4, var8, var1, var2, var3);
                        }
                     }
                  }

                  ArchiveDisk.method1503("Examine", ScriptEvent.method0(16776960) + var4, 1003, var1, var2, var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("cz")
   static final String[] method2299(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if (var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
