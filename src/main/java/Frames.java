import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("Frames")
public class Frames extends DualNode {
   @ObfuscatedName("p")
   public static int field1825;
   @ObfuscatedName("cf")
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("i")
   @Export("frames")
   @ObfuscatedSignature(
      descriptor = "[Lclass96;"
   )
   Animation[] frames;

   @ObfuscatedSignature(
      descriptor = "(Lclass151;Lclass151;IZ)V"
   )
   Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
      NodeDeque var5 = new NodeDeque();
      int var6 = var1.method3214(var3);
      this.frames = new Animation[var6];
      int[] var7 = var1.method3248(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3204(var3, var7[var8]);
         Skeleton var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(Skeleton var12 = (Skeleton)var5.method3533(); var12 != null; var12 = (Skeleton)var5.method3535()) {
            if (var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if (var10 == null) {
            byte[] var13;
            if (var4) {
               var13 = var2.method3210(0, var11);
            } else {
               var13 = var2.method3210(var11, 0);
            }

            var10 = new Skeleton(var11, var13);
            var5.method3528(var10);
         }

         this.frames[var7[var8]] = new Animation(var9, var10);
      }

   }

   @ObfuscatedName("w")
   @Export("method2387")
   public boolean method2387(int var1) {
      return this.frames[var1].hasAlphaTransform;
   }

   @ObfuscatedName("bk")
   static final void method2392(int var0) {
      if (var0 >= 0) {
         int var1 = Client.menuArguments1[var0];
         int var2 = Client.menuArguments2[var0];
         int var3 = Client.menuOpcodes[var0];
         int var4 = Client.menuIdentifiers[var0];
         if (var3 >= 2000) {
            var3 -= 2000;
         }

         if (var3 == 1) {
            if (Tile.method2298(var1, var2, var4)) {
               Client.rsaBuf.writeByteOpcode(29);
               Client.rsaBuf.writeShortLE(var1 + FaceNormal.baseX);
               Client.rsaBuf.writeShortLE(var2 + baseY);
               Client.rsaBuf.writeShort(class82.selectedItemSlot);
               Client.rsaBuf.writeIntIME(PcmPlayer.selectedItemWidget);
               Client.rsaBuf.writeShortAdd(DynamicObject.selectedItemId);
               Client.rsaBuf.writeShortAddLE(var4 >> 14 & 32767);
            }
         } else if (var3 == 2) {
            if (Tile.method2298(var1, var2, var4)) {
               Client.rsaBuf.writeByteOpcode(164);
               Client.rsaBuf.writeShort(var2 + baseY);
               Client.rsaBuf.writeShortLE(var1 + FaceNormal.baseX);
               Client.rsaBuf.writeShortAddLE(Client.selectedSpellChildIndex);
               Client.rsaBuf.writeInt(GraphicsObject.field308);
               Client.rsaBuf.writeShortAddLE(var4 >> 14 & 32767);
            }
         } else if (var3 == 3) {
            Tile.method2298(var1, var2, var4);
            Client.rsaBuf.writeByteOpcode(119);
            Client.rsaBuf.writeShortAdd(var4 >> 14 & 32767);
            Client.rsaBuf.writeShortLE(var2 + baseY);
            Client.rsaBuf.writeShort(var1 + FaceNormal.baseX);
         } else if (var3 == 4) {
            Tile.method2298(var1, var2, var4);
            Client.rsaBuf.writeByteOpcode(35);
            Client.rsaBuf.writeShortAddLE(var2 + baseY);
            Client.rsaBuf.writeShortAddLE(var1 + FaceNormal.baseX);
            Client.rsaBuf.writeShortLE(var4 >> 14 & 32767);
         } else if (var3 == 5) {
            Tile.method2298(var1, var2, var4);
            Client.rsaBuf.writeByteOpcode(53);
            Client.rsaBuf.writeShortLE(var1 + FaceNormal.baseX);
            Client.rsaBuf.writeShortLE(var4 >> 14 & 32767);
            Client.rsaBuf.writeShort(var2 + baseY);
         } else if (var3 == 6) {
            Tile.method2298(var1, var2, var4);
            Client.rsaBuf.writeByteOpcode(47);
            Client.rsaBuf.writeShortAdd(var1 + FaceNormal.baseX);
            Client.rsaBuf.writeShortAddLE(var2 + baseY);
            Client.rsaBuf.writeShort(var4 >> 14 & 32767);
         } else {
            NPC var5;
            if (var3 == 7) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var5.pathX[0], var5.pathY[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.rsaBuf.writeByteOpcode(130);
                  Client.rsaBuf.writeShortAddLE(var4);
                  Client.rsaBuf.writeShortAddLE(DynamicObject.selectedItemId);
                  Client.rsaBuf.writeShort(class82.selectedItemSlot);
                  Client.rsaBuf.writeIntME(PcmPlayer.selectedItemWidget);
               }
            } else if (var3 == 8) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var5.pathX[0], var5.pathY[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.rsaBuf.writeByteOpcode(101);
                  Client.rsaBuf.writeInt(GraphicsObject.field308);
                  Client.rsaBuf.writeShortAddLE(var4);
                  Client.rsaBuf.writeShortLE(Client.selectedSpellChildIndex);
               }
            } else if (var3 == 9) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var5.pathX[0], var5.pathY[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.rsaBuf.writeByteOpcode(24);
                  Client.rsaBuf.writeShort(var4);
               }
            } else if (var3 == 10) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var5.pathX[0], var5.pathY[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.rsaBuf.writeByteOpcode(31);
                  Client.rsaBuf.writeShort(var4);
               }
            } else if (var3 == 11) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var5.pathX[0], var5.pathY[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.rsaBuf.writeByteOpcode(169);
                  Client.rsaBuf.writeShortLE(var4);
               }
            } else if (var3 == 12) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var5.pathX[0], var5.pathY[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.rsaBuf.writeByteOpcode(106);
                  Client.rsaBuf.writeShortLE(var4);
               }
            } else if (var3 == 13) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var5.pathX[0], var5.pathY[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.rsaBuf.writeByteOpcode(235);
                  Client.rsaBuf.writeShort(var4);
               }
            } else {
               Player var16;
               if (var3 == 14) {
                  var16 = Client.players[var4];
                  if (var16 != null) {
                     FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(251);
                     Client.rsaBuf.writeShortLE(DynamicObject.selectedItemId);
                     Client.rsaBuf.writeShortLE(var4);
                     Client.rsaBuf.writeInt(PcmPlayer.selectedItemWidget);
                     Client.rsaBuf.writeShortAdd(class82.selectedItemSlot);
                  }
               } else if (var3 == 15) {
                  var16 = Client.players[var4];
                  if (var16 != null) {
                     FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(252);
                     Client.rsaBuf.writeInt(GraphicsObject.field308);
                     Client.rsaBuf.writeShortAddLE(Client.selectedSpellChildIndex);
                     Client.rsaBuf.writeShortLE(var4);
                  }
               } else {
                  boolean var11;
                  if (var3 == 16) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(78);
                     Client.rsaBuf.writeShortAddLE(DynamicObject.selectedItemId);
                     Client.rsaBuf.writeShortAddLE(class82.selectedItemSlot);
                     Client.rsaBuf.writeShortAddLE(var2 + baseY);
                     Client.rsaBuf.writeIntLE(PcmPlayer.selectedItemWidget);
                     Client.rsaBuf.writeShortAddLE(var4);
                     Client.rsaBuf.writeShort(var1 + FaceNormal.baseX);
                  } else if (var3 == 17) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(189);
                     Client.rsaBuf.writeInt(GraphicsObject.field308);
                     Client.rsaBuf.writeShort(var2 + baseY);
                     Client.rsaBuf.writeShortLE(var1 + FaceNormal.baseX);
                     Client.rsaBuf.writeShortAdd(var4);
                     Client.rsaBuf.writeShortAddLE(Client.selectedSpellChildIndex);
                  } else if (var3 == 18) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(174);
                     Client.rsaBuf.writeShortLE(var2 + baseY);
                     Client.rsaBuf.writeShortAdd(var1 + FaceNormal.baseX);
                     Client.rsaBuf.writeShort(var4);
                  } else if (var3 == 19) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(162);
                     Client.rsaBuf.writeShortLE(var1 + FaceNormal.baseX);
                     Client.rsaBuf.writeShortAddLE(var4);
                     Client.rsaBuf.writeShortAdd(var2 + baseY);
                  } else if (var3 == 20) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(69);
                     Client.rsaBuf.writeShort(var4);
                     Client.rsaBuf.writeShortAdd(var1 + FaceNormal.baseX);
                     Client.rsaBuf.writeShortLE(var2 + baseY);
                  } else if (var3 == 21) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(120);
                     Client.rsaBuf.writeShortLE(var1 + FaceNormal.baseX);
                     Client.rsaBuf.writeShort(var4);
                     Client.rsaBuf.writeShortAddLE(var2 + baseY);
                  } else if (var3 == 22) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.rsaBuf.writeByteOpcode(223);
                     Client.rsaBuf.writeShortLE(var1 + FaceNormal.baseX);
                     Client.rsaBuf.writeShortAdd(var2 + baseY);
                     Client.rsaBuf.writeShortAddLE(var4);
                  } else if (var3 == 23) {
                     Interpreter.scene.method2078(class22.Client_plane, var1, var2);
                  } else {
                     Widget var18;
                     if (var3 == 24) {
                        var18 = class130.getWidget(var2);
                        boolean var12 = true;
                        if (var18.contentType > 0) {
                           var12 = Client.method538(var18);
                        }

                        if (var12) {
                           Client.rsaBuf.writeByteOpcode(172);
                           Client.rsaBuf.writeInt(var2);
                        }
                     } else {
                        int var21;
                        if (var3 == 25) {
                           var18 = AbstractArchive.method3230(var2, var1);
                           if (var18 != null) {
                              ScriptEvent.method1();
                              var21 = class40.method905(SoundSystem.method1326(var18));
                              Widget var17 = AbstractArchive.method3230(var2, var1);
                              if (var17 != null && var17.field2660 != null) {
                                 ScriptEvent var14 = new ScriptEvent();
                                 var14.widget = var17;
                                 var14.args = var17.field2660;
                                 Renderable.method2040(var14);
                              }

                              Client.isSpellSelected = true;
                              GraphicsObject.field308 = var2;
                              Client.selectedSpellChildIndex = var1;
                              FaceNormal.field1523 = var21;
                              class82.invalidateWidget(var17);
                              Client.isItemSelected = 0;
                              Client.field641 = IsaacCipher.method2543(var18);
                              if (Client.field641 == null) {
                                 Client.field641 = "Null";
                              }

                              if (var18.isIf3) {
                                 Client.field594 = var18.field2636 + ScriptEvent.method0(16777215);
                              } else {
                                 Client.field594 = ScriptEvent.method0(65280) + var18.field2676 + ScriptEvent.method0(16777215);
                              }
                           }

                           return;
                        }

                        if (var3 == 26) {
                           Client.rsaBuf.writeByteOpcode(255);

                           for(InterfaceParent var19 = (InterfaceParent)Client.interfaceParents.method3515(); var19 != null; var19 = (InterfaceParent)Client.interfaceParents.method3516()) {
                              if (var19.field56 == 0 || var19.field56 == 3) {
                                 Tiles.method60(var19, true);
                              }
                           }

                           if (Client.meslayerContinueWidget != null) {
                              class82.invalidateWidget(Client.meslayerContinueWidget);
                              Client.meslayerContinueWidget = null;
                           }
                        } else if (var3 == 28) {
                           Client.rsaBuf.writeByteOpcode(172);
                           Client.rsaBuf.writeInt(var2);
                           var18 = class130.getWidget(var2);
                           if (var18.cs1Instructions != null && var18.cs1Instructions[0][0] == 5) {
                              var21 = var18.cs1Instructions[0][1];
                              Varps.Varps_main[var21] = 1 - Varps.Varps_main[var21];
                              PendingSpawn.method243(var21);
                           }
                        } else if (var3 == 29) {
                           Client.rsaBuf.writeByteOpcode(172);
                           Client.rsaBuf.writeInt(var2);
                           var18 = class130.getWidget(var2);
                           if (var18.cs1Instructions != null && var18.cs1Instructions[0][0] == 5) {
                              var21 = var18.cs1Instructions[0][1];
                              if (Varps.Varps_main[var21] != var18.cs1ComparisonValues[0]) {
                                 Varps.Varps_main[var21] = var18.cs1ComparisonValues[0];
                                 PendingSpawn.method243(var21);
                              }
                           }
                        } else if (var3 == 30) {
                           if (Client.meslayerContinueWidget == null) {
                              Client.rsaBuf.writeByteOpcode(50);
                              Client.rsaBuf.writeInt(var2);
                              Client.rsaBuf.writeShort(var1);
                              Client.meslayerContinueWidget = AbstractArchive.method3230(var2, var1);
                              class82.invalidateWidget(Client.meslayerContinueWidget);
                           }
                        } else if (var3 == 31) {
                           Client.rsaBuf.writeByteOpcode(43);
                           Client.rsaBuf.writeIntLE(PcmPlayer.selectedItemWidget);
                           Client.rsaBuf.writeShort(DynamicObject.selectedItemId);
                           Client.rsaBuf.writeShortAddLE(class82.selectedItemSlot);
                           Client.rsaBuf.writeShortLE(var1);
                           Client.rsaBuf.writeIntLE(var2);
                           Client.rsaBuf.writeShortAdd(var4);
                           Client.field533 = 0;
                           Projectile.field161 = class130.getWidget(var2);
                           Client.field595 = var1;
                        } else if (var3 == 32) {
                           Client.rsaBuf.writeByteOpcode(112);
                           Client.rsaBuf.writeShort(var1);
                           Client.rsaBuf.writeShortAddLE(Client.selectedSpellChildIndex);
                           Client.rsaBuf.writeShortAdd(var4);
                           Client.rsaBuf.writeIntME(GraphicsObject.field308);
                           Client.rsaBuf.writeIntME(var2);
                           Client.field533 = 0;
                           Projectile.field161 = class130.getWidget(var2);
                           Client.field595 = var1;
                        } else if (var3 == 33) {
                           Client.rsaBuf.writeByteOpcode(74);
                           Client.rsaBuf.writeShort(var1);
                           Client.rsaBuf.writeIntME(var2);
                           Client.rsaBuf.writeShortAddLE(var4);
                           Client.field533 = 0;
                           Projectile.field161 = class130.getWidget(var2);
                           Client.field595 = var1;
                        } else if (var3 == 34) {
                           Client.rsaBuf.writeByteOpcode(226);
                           Client.rsaBuf.writeShort(var1);
                           Client.rsaBuf.writeIntME(var2);
                           Client.rsaBuf.writeShortAddLE(var4);
                           Client.field533 = 0;
                           Projectile.field161 = class130.getWidget(var2);
                           Client.field595 = var1;
                        } else if (var3 == 35) {
                           Client.rsaBuf.writeByteOpcode(175);
                           Client.rsaBuf.writeShortAddLE(var1);
                           Client.rsaBuf.writeShort(var4);
                           Client.rsaBuf.writeIntME(var2);
                           Client.field533 = 0;
                           Projectile.field161 = class130.getWidget(var2);
                           Client.field595 = var1;
                        } else if (var3 == 36) {
                           Client.rsaBuf.writeByteOpcode(213);
                           Client.rsaBuf.writeShort(var4);
                           Client.rsaBuf.writeShortAddLE(var1);
                           Client.rsaBuf.writeIntME(var2);
                           Client.field533 = 0;
                           Projectile.field161 = class130.getWidget(var2);
                           Client.field595 = var1;
                        } else if (var3 == 37) {
                           Client.rsaBuf.writeByteOpcode(184);
                           Client.rsaBuf.writeShortAddLE(var4);
                           Client.rsaBuf.writeShortLE(var1);
                           Client.rsaBuf.writeInt(var2);
                           Client.field533 = 0;
                           Projectile.field161 = class130.getWidget(var2);
                           Client.field595 = var1;
                        } else {
                           if (var3 == 38) {
                              ScriptEvent.method1();
                              var18 = class130.getWidget(var2);
                              Client.isItemSelected = 1;
                              class82.selectedItemSlot = var1;
                              PcmPlayer.selectedItemWidget = var2;
                              DynamicObject.selectedItemId = var4;
                              class82.invalidateWidget(var18);
                              Client.selectedItemName = ScriptEvent.method0(16748608) + class27.method571(var4).name + ScriptEvent.method0(16777215);
                              if (Client.selectedItemName == null) {
                                 Client.selectedItemName = "null";
                              }

                              return;
                           }

                           if (var3 == 39) {
                              Client.rsaBuf.writeByteOpcode(105);
                              Client.rsaBuf.writeShortAdd(var1);
                              Client.rsaBuf.writeIntIME(var2);
                              Client.rsaBuf.writeShort(var4);
                              Client.field533 = 0;
                              Projectile.field161 = class130.getWidget(var2);
                              Client.field595 = var1;
                           } else if (var3 == 40) {
                              Client.rsaBuf.writeByteOpcode(45);
                              Client.rsaBuf.writeShortAdd(var1);
                              Client.rsaBuf.writeIntME(var2);
                              Client.rsaBuf.writeShortAdd(var4);
                              Client.field533 = 0;
                              Projectile.field161 = class130.getWidget(var2);
                              Client.field595 = var1;
                           } else if (var3 == 41) {
                              Client.rsaBuf.writeByteOpcode(94);
                              Client.rsaBuf.writeIntME(var2);
                              Client.rsaBuf.writeShortAdd(var1);
                              Client.rsaBuf.writeShort(var4);
                              Client.field533 = 0;
                              Projectile.field161 = class130.getWidget(var2);
                              Client.field595 = var1;
                           } else if (var3 == 42) {
                              Client.rsaBuf.writeByteOpcode(131);
                              Client.rsaBuf.writeShortLE(var4);
                              Client.rsaBuf.writeShortLE(var1);
                              Client.rsaBuf.writeIntLE(var2);
                              Client.field533 = 0;
                              Projectile.field161 = class130.getWidget(var2);
                              Client.field595 = var1;
                           } else if (var3 == 43) {
                              Client.rsaBuf.writeByteOpcode(44);
                              Client.rsaBuf.writeIntME(var2);
                              Client.rsaBuf.writeShortLE(var4);
                              Client.rsaBuf.writeShort(var1);
                              Client.field533 = 0;
                              Projectile.field161 = class130.getWidget(var2);
                              Client.field595 = var1;
                           } else if (var3 == 44) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.rsaBuf.writeByteOpcode(2);
                                 Client.rsaBuf.writeShortAddLE(var4);
                              }
                           } else if (var3 == 45) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.rsaBuf.writeByteOpcode(177);
                                 Client.rsaBuf.writeShortAdd(var4);
                              }
                           } else if (var3 == 46) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.rsaBuf.writeByteOpcode(152);
                                 Client.rsaBuf.writeShortAddLE(var4);
                              }
                           } else if (var3 == 47) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.rsaBuf.writeByteOpcode(142);
                                 Client.rsaBuf.writeShortAddLE(var4);
                              }
                           } else if (var3 == 48) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.rsaBuf.writeByteOpcode(0);
                                 Client.rsaBuf.writeShortAdd(var4);
                              }
                           } else if (var3 == 49) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.rsaBuf.writeByteOpcode(198);
                                 Client.rsaBuf.writeShortAdd(var4);
                              }
                           } else if (var3 == 50) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.rsaBuf.writeByteOpcode(254);
                                 Client.rsaBuf.writeShort(var4);
                              }
                           } else if (var3 == 51) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var16.pathX[0], var16.pathY[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.rsaBuf.writeByteOpcode(98);
                                 Client.rsaBuf.writeShortLE(var4);
                              }
                           } else {
                              label567: {
                                 if (var3 != 57) {
                                    if (var3 == 58) {
                                       Client.rsaBuf.writeByteOpcode(150);
                                       Client.rsaBuf.writeShortLE(var1);
                                       Client.rsaBuf.writeShortAdd(Client.selectedSpellChildIndex);
                                       Client.rsaBuf.writeIntLE(GraphicsObject.field308);
                                       Client.rsaBuf.writeIntLE(var2);
                                       break label567;
                                    }

                                    if (var3 == 1001) {
                                       Tile.method2298(var1, var2, var4);
                                       Client.rsaBuf.writeByteOpcode(38);
                                       Client.rsaBuf.writeShortAdd(var1 + FaceNormal.baseX);
                                       Client.rsaBuf.writeShortAdd(var4 >> 14 & 32767);
                                       Client.rsaBuf.writeShortAdd(var2 + baseY);
                                       break label567;
                                    }

                                    if (var3 == 1002) {
                                       Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                       Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                       Client.mouseCrossColor = 2;
                                       Client.mouseCrossState = 0;
                                       Client.rsaBuf.writeByteOpcode(84);
                                       Client.rsaBuf.writeShortAddLE(var4 >> 14 & 32767);
                                       break label567;
                                    }

                                    if (var3 == 1003) {
                                       Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                       Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                       Client.mouseCrossColor = 2;
                                       Client.mouseCrossState = 0;
                                       var5 = Client.npcs[var4];
                                       if (var5 != null) {
                                          NPCComposition var15 = var5.definition;
                                          if (var15.transforms != null) {
                                             var15 = var15.method657();
                                          }

                                          if (var15 != null) {
                                             Client.rsaBuf.writeByteOpcode(75);
                                             Client.rsaBuf.writeShortAdd(var15.id);
                                          }
                                       }
                                       break label567;
                                    }

                                    if (var3 == 1004) {
                                       Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                       Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                       Client.mouseCrossColor = 2;
                                       Client.mouseCrossState = 0;
                                       Client.rsaBuf.writeByteOpcode(128);
                                       Client.rsaBuf.writeShort(var4);
                                       break label567;
                                    }

                                    if (var3 == 1005) {
                                       var18 = class130.getWidget(var2);
                                       if (var18 != null && var18.itemQuantities[var1] >= 100000) {
                                          Login.method239(0, "", var18.itemQuantities[var1] + " x " + class27.method571(var4).name);
                                       } else {
                                          Client.rsaBuf.writeByteOpcode(128);
                                          Client.rsaBuf.writeShort(var4);
                                       }

                                       Client.field533 = 0;
                                       Projectile.field161 = class130.getWidget(var2);
                                       Client.field595 = var1;
                                       break label567;
                                    }

                                    if (var3 != 1007) {
                                       break label567;
                                    }
                                 }

                                 String var20 = Client.menuTargets[var0];
                                 Widget var6 = AbstractArchive.method3230(var2, var1);
                                 if (var6 != null) {
                                    if (var6.field2635 != null) {
                                       ScriptEvent var7 = new ScriptEvent();
                                       var7.widget = var6;
                                       var7.field3 = var4;
                                       var7.field8 = var20;
                                       var7.args = var6.field2635;
                                       Renderable.method2040(var7);
                                    }

                                    boolean var13 = true;
                                    if (var6.contentType > 0) {
                                       var13 = Client.method538(var6);
                                    }

                                    if (var13) {
                                       int var9 = SoundSystem.method1326(var6);
                                       int var10 = var4 - 1;
                                       boolean var8 = (var9 >> var10 + 1 & 1) != 0;
                                       if (var8) {
                                          if (var4 == 1) {
                                             Client.rsaBuf.writeByteOpcode(147);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 2) {
                                             Client.rsaBuf.writeByteOpcode(231);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 3) {
                                             Client.rsaBuf.writeByteOpcode(187);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 4) {
                                             Client.rsaBuf.writeByteOpcode(20);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 5) {
                                             Client.rsaBuf.writeByteOpcode(236);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 6) {
                                             Client.rsaBuf.writeByteOpcode(242);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 7) {
                                             Client.rsaBuf.writeByteOpcode(6);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 8) {
                                             Client.rsaBuf.writeByteOpcode(192);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 9) {
                                             Client.rsaBuf.writeByteOpcode(171);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
                                          }

                                          if (var4 == 10) {
                                             Client.rsaBuf.writeByteOpcode(188);
                                             Client.rsaBuf.writeInt(var2);
                                             Client.rsaBuf.writeShort(var1);
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

         if (Client.isItemSelected != 0) {
            Client.isItemSelected = 0;
            class82.invalidateWidget(class130.getWidget(PcmPlayer.selectedItemWidget));
         }

         if (Client.isSpellSelected) {
            ScriptEvent.method1();
         }

         if (Projectile.field161 != null && Client.field533 == 0) {
            class82.invalidateWidget(Projectile.field161);
         }

      }
   }
}
