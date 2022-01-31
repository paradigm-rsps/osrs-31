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
               Client.field519.method2512(29);
               Client.field519.method2673(var1 + FaceNormal.baseX);
               Client.field519.method2673(var2 + baseY);
               Client.field519.writeShort(class82.selectedItemSlot);
               Client.field519.method2683(PcmPlayer.selectedItemWidget);
               Client.field519.method2674(DynamicObject.selectedItemId);
               Client.field519.method2768(var4 >> 14 & 32767);
            }
         } else if (var3 == 2) {
            if (Tile.method2298(var1, var2, var4)) {
               Client.field519.method2512(164);
               Client.field519.writeShort(var2 + baseY);
               Client.field519.method2673(var1 + FaceNormal.baseX);
               Client.field519.method2768(Client.selectedSpellChildIndex);
               Client.field519.writeInt(GraphicsObject.field308);
               Client.field519.method2768(var4 >> 14 & 32767);
            }
         } else if (var3 == 3) {
            Tile.method2298(var1, var2, var4);
            Client.field519.method2512(119);
            Client.field519.method2674(var4 >> 14 & 32767);
            Client.field519.method2673(var2 + baseY);
            Client.field519.writeShort(var1 + FaceNormal.baseX);
         } else if (var3 == 4) {
            Tile.method2298(var1, var2, var4);
            Client.field519.method2512(35);
            Client.field519.method2768(var2 + baseY);
            Client.field519.method2768(var1 + FaceNormal.baseX);
            Client.field519.method2673(var4 >> 14 & 32767);
         } else if (var3 == 5) {
            Tile.method2298(var1, var2, var4);
            Client.field519.method2512(53);
            Client.field519.method2673(var1 + FaceNormal.baseX);
            Client.field519.method2673(var4 >> 14 & 32767);
            Client.field519.writeShort(var2 + baseY);
         } else if (var3 == 6) {
            Tile.method2298(var1, var2, var4);
            Client.field519.method2512(47);
            Client.field519.method2674(var1 + FaceNormal.baseX);
            Client.field519.method2768(var2 + baseY);
            Client.field519.writeShort(var4 >> 14 & 32767);
         } else {
            NPC var5;
            if (var3 == 7) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var5.hitSplatTypes2[0], var5.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.field519.method2512(130);
                  Client.field519.method2768(var4);
                  Client.field519.method2768(DynamicObject.selectedItemId);
                  Client.field519.writeShort(class82.selectedItemSlot);
                  Client.field519.method2684(PcmPlayer.selectedItemWidget);
               }
            } else if (var3 == 8) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var5.hitSplatTypes2[0], var5.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.field519.method2512(101);
                  Client.field519.writeInt(GraphicsObject.field308);
                  Client.field519.method2768(var4);
                  Client.field519.method2673(Client.selectedSpellChildIndex);
               }
            } else if (var3 == 9) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var5.hitSplatTypes2[0], var5.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.field519.method2512(24);
                  Client.field519.writeShort(var4);
               }
            } else if (var3 == 10) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var5.hitSplatTypes2[0], var5.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.field519.method2512(31);
                  Client.field519.writeShort(var4);
               }
            } else if (var3 == 11) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var5.hitSplatTypes2[0], var5.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.field519.method2512(169);
                  Client.field519.method2673(var4);
               }
            } else if (var3 == 12) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var5.hitSplatTypes2[0], var5.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.field519.method2512(106);
                  Client.field519.method2673(var4);
               }
            } else if (var3 == 13) {
               var5 = Client.npcs[var4];
               if (var5 != null) {
                  FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var5.hitSplatTypes2[0], var5.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                  Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                  Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.field519.method2512(235);
                  Client.field519.writeShort(var4);
               }
            } else {
               Player var16;
               if (var3 == 14) {
                  var16 = Client.players[var4];
                  if (var16 != null) {
                     FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(251);
                     Client.field519.method2673(DynamicObject.selectedItemId);
                     Client.field519.method2673(var4);
                     Client.field519.writeInt(PcmPlayer.selectedItemWidget);
                     Client.field519.method2674(class82.selectedItemSlot);
                  }
               } else if (var3 == 15) {
                  var16 = Client.players[var4];
                  if (var16 != null) {
                     FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(252);
                     Client.field519.writeInt(GraphicsObject.field308);
                     Client.field519.method2768(Client.selectedSpellChildIndex);
                     Client.field519.method2673(var4);
                  }
               } else {
                  boolean var11;
                  if (var3 == 16) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(78);
                     Client.field519.method2768(DynamicObject.selectedItemId);
                     Client.field519.method2768(class82.selectedItemSlot);
                     Client.field519.method2768(var2 + baseY);
                     Client.field519.method2682(PcmPlayer.selectedItemWidget);
                     Client.field519.method2768(var4);
                     Client.field519.writeShort(var1 + FaceNormal.baseX);
                  } else if (var3 == 17) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(189);
                     Client.field519.writeInt(GraphicsObject.field308);
                     Client.field519.writeShort(var2 + baseY);
                     Client.field519.method2673(var1 + FaceNormal.baseX);
                     Client.field519.method2674(var4);
                     Client.field519.method2768(Client.selectedSpellChildIndex);
                  } else if (var3 == 18) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(174);
                     Client.field519.method2673(var2 + baseY);
                     Client.field519.method2674(var1 + FaceNormal.baseX);
                     Client.field519.writeShort(var4);
                  } else if (var3 == 19) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(162);
                     Client.field519.method2673(var1 + FaceNormal.baseX);
                     Client.field519.method2768(var4);
                     Client.field519.method2674(var2 + baseY);
                  } else if (var3 == 20) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(69);
                     Client.field519.writeShort(var4);
                     Client.field519.method2674(var1 + FaceNormal.baseX);
                     Client.field519.method2673(var2 + baseY);
                  } else if (var3 == 21) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(120);
                     Client.field519.method2673(var1 + FaceNormal.baseX);
                     Client.field519.writeShort(var4);
                     Client.field519.method2768(var2 + baseY);
                  } else if (var3 == 22) {
                     var11 = FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
                     if (!var11) {
                        FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
                     }

                     Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                     Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                     Client.mouseCrossColor = 2;
                     Client.mouseCrossState = 0;
                     Client.field519.method2512(223);
                     Client.field519.method2673(var1 + FaceNormal.baseX);
                     Client.field519.method2674(var2 + baseY);
                     Client.field519.method2768(var4);
                  } else if (var3 == 23) {
                     Interpreter.scene.method2078(class22.Client_plane, var1, var2);
                  } else {
                     Widget var18;
                     if (var3 == 24) {
                        var18 = class130.method2851(var2);
                        boolean var12 = true;
                        if (var18.contentType > 0) {
                           var12 = Client.method538(var18);
                        }

                        if (var12) {
                           Client.field519.method2512(172);
                           Client.field519.writeInt(var2);
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
                              class82.method1754(var17);
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
                           Client.field519.method2512(255);

                           for(InterfaceParent var19 = (InterfaceParent)Client.interfaceParents.method3515(); var19 != null; var19 = (InterfaceParent)Client.interfaceParents.method3516()) {
                              if (var19.field56 == 0 || var19.field56 == 3) {
                                 Tiles.method60(var19, true);
                              }
                           }

                           if (Client.meslayerContinueWidget != null) {
                              class82.method1754(Client.meslayerContinueWidget);
                              Client.meslayerContinueWidget = null;
                           }
                        } else if (var3 == 28) {
                           Client.field519.method2512(172);
                           Client.field519.writeInt(var2);
                           var18 = class130.method2851(var2);
                           if (var18.cs1Instructions != null && var18.cs1Instructions[0][0] == 5) {
                              var21 = var18.cs1Instructions[0][1];
                              Varps.Varps_main[var21] = 1 - Varps.Varps_main[var21];
                              PendingSpawn.method243(var21);
                           }
                        } else if (var3 == 29) {
                           Client.field519.method2512(172);
                           Client.field519.writeInt(var2);
                           var18 = class130.method2851(var2);
                           if (var18.cs1Instructions != null && var18.cs1Instructions[0][0] == 5) {
                              var21 = var18.cs1Instructions[0][1];
                              if (Varps.Varps_main[var21] != var18.cs1ComparisonValues[0]) {
                                 Varps.Varps_main[var21] = var18.cs1ComparisonValues[0];
                                 PendingSpawn.method243(var21);
                              }
                           }
                        } else if (var3 == 30) {
                           if (Client.meslayerContinueWidget == null) {
                              Client.field519.method2512(50);
                              Client.field519.writeInt(var2);
                              Client.field519.writeShort(var1);
                              Client.meslayerContinueWidget = AbstractArchive.method3230(var2, var1);
                              class82.method1754(Client.meslayerContinueWidget);
                           }
                        } else if (var3 == 31) {
                           Client.field519.method2512(43);
                           Client.field519.method2682(PcmPlayer.selectedItemWidget);
                           Client.field519.writeShort(DynamicObject.selectedItemId);
                           Client.field519.method2768(class82.selectedItemSlot);
                           Client.field519.method2673(var1);
                           Client.field519.method2682(var2);
                           Client.field519.method2674(var4);
                           Client.field533 = 0;
                           Projectile.field161 = class130.method2851(var2);
                           Client.field595 = var1;
                        } else if (var3 == 32) {
                           Client.field519.method2512(112);
                           Client.field519.writeShort(var1);
                           Client.field519.method2768(Client.selectedSpellChildIndex);
                           Client.field519.method2674(var4);
                           Client.field519.method2684(GraphicsObject.field308);
                           Client.field519.method2684(var2);
                           Client.field533 = 0;
                           Projectile.field161 = class130.method2851(var2);
                           Client.field595 = var1;
                        } else if (var3 == 33) {
                           Client.field519.method2512(74);
                           Client.field519.writeShort(var1);
                           Client.field519.method2684(var2);
                           Client.field519.method2768(var4);
                           Client.field533 = 0;
                           Projectile.field161 = class130.method2851(var2);
                           Client.field595 = var1;
                        } else if (var3 == 34) {
                           Client.field519.method2512(226);
                           Client.field519.writeShort(var1);
                           Client.field519.method2684(var2);
                           Client.field519.method2768(var4);
                           Client.field533 = 0;
                           Projectile.field161 = class130.method2851(var2);
                           Client.field595 = var1;
                        } else if (var3 == 35) {
                           Client.field519.method2512(175);
                           Client.field519.method2768(var1);
                           Client.field519.writeShort(var4);
                           Client.field519.method2684(var2);
                           Client.field533 = 0;
                           Projectile.field161 = class130.method2851(var2);
                           Client.field595 = var1;
                        } else if (var3 == 36) {
                           Client.field519.method2512(213);
                           Client.field519.writeShort(var4);
                           Client.field519.method2768(var1);
                           Client.field519.method2684(var2);
                           Client.field533 = 0;
                           Projectile.field161 = class130.method2851(var2);
                           Client.field595 = var1;
                        } else if (var3 == 37) {
                           Client.field519.method2512(184);
                           Client.field519.method2768(var4);
                           Client.field519.method2673(var1);
                           Client.field519.writeInt(var2);
                           Client.field533 = 0;
                           Projectile.field161 = class130.method2851(var2);
                           Client.field595 = var1;
                        } else {
                           if (var3 == 38) {
                              ScriptEvent.method1();
                              var18 = class130.method2851(var2);
                              Client.isItemSelected = 1;
                              class82.selectedItemSlot = var1;
                              PcmPlayer.selectedItemWidget = var2;
                              DynamicObject.selectedItemId = var4;
                              class82.method1754(var18);
                              Client.selectedItemName = ScriptEvent.method0(16748608) + class27.method571(var4).name + ScriptEvent.method0(16777215);
                              if (Client.selectedItemName == null) {
                                 Client.selectedItemName = "null";
                              }

                              return;
                           }

                           if (var3 == 39) {
                              Client.field519.method2512(105);
                              Client.field519.method2674(var1);
                              Client.field519.method2683(var2);
                              Client.field519.writeShort(var4);
                              Client.field533 = 0;
                              Projectile.field161 = class130.method2851(var2);
                              Client.field595 = var1;
                           } else if (var3 == 40) {
                              Client.field519.method2512(45);
                              Client.field519.method2674(var1);
                              Client.field519.method2684(var2);
                              Client.field519.method2674(var4);
                              Client.field533 = 0;
                              Projectile.field161 = class130.method2851(var2);
                              Client.field595 = var1;
                           } else if (var3 == 41) {
                              Client.field519.method2512(94);
                              Client.field519.method2684(var2);
                              Client.field519.method2674(var1);
                              Client.field519.writeShort(var4);
                              Client.field533 = 0;
                              Projectile.field161 = class130.method2851(var2);
                              Client.field595 = var1;
                           } else if (var3 == 42) {
                              Client.field519.method2512(131);
                              Client.field519.method2673(var4);
                              Client.field519.method2673(var1);
                              Client.field519.method2682(var2);
                              Client.field533 = 0;
                              Projectile.field161 = class130.method2851(var2);
                              Client.field595 = var1;
                           } else if (var3 == 43) {
                              Client.field519.method2512(44);
                              Client.field519.method2684(var2);
                              Client.field519.method2673(var4);
                              Client.field519.writeShort(var1);
                              Client.field533 = 0;
                              Projectile.field161 = class130.method2851(var2);
                              Client.field595 = var1;
                           } else if (var3 == 44) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.field519.method2512(2);
                                 Client.field519.method2768(var4);
                              }
                           } else if (var3 == 45) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.field519.method2512(177);
                                 Client.field519.method2674(var4);
                              }
                           } else if (var3 == 46) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.field519.method2512(152);
                                 Client.field519.method2768(var4);
                              }
                           } else if (var3 == 47) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.field519.method2512(142);
                                 Client.field519.method2768(var4);
                              }
                           } else if (var3 == 48) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.field519.method2512(0);
                                 Client.field519.method2674(var4);
                              }
                           } else if (var3 == 49) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.field519.method2512(198);
                                 Client.field519.method2674(var4);
                              }
                           } else if (var3 == 50) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.field519.method2512(254);
                                 Client.field519.writeShort(var4);
                              }
                           } else if (var3 == 51) {
                              var16 = Client.players[var4];
                              if (var16 != null) {
                                 FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var16.hitSplatTypes2[0], var16.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                 Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                 Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                 Client.mouseCrossColor = 2;
                                 Client.mouseCrossState = 0;
                                 Client.field519.method2512(98);
                                 Client.field519.method2673(var4);
                              }
                           } else {
                              label567: {
                                 if (var3 != 57) {
                                    if (var3 == 58) {
                                       Client.field519.method2512(150);
                                       Client.field519.method2673(var1);
                                       Client.field519.method2674(Client.selectedSpellChildIndex);
                                       Client.field519.method2682(GraphicsObject.field308);
                                       Client.field519.method2682(var2);
                                       break label567;
                                    }

                                    if (var3 == 1001) {
                                       Tile.method2298(var1, var2, var4);
                                       Client.field519.method2512(38);
                                       Client.field519.method2674(var1 + FaceNormal.baseX);
                                       Client.field519.method2674(var4 >> 14 & 32767);
                                       Client.field519.method2674(var2 + baseY);
                                       break label567;
                                    }

                                    if (var3 == 1002) {
                                       Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                       Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                       Client.mouseCrossColor = 2;
                                       Client.mouseCrossState = 0;
                                       Client.field519.method2512(84);
                                       Client.field519.method2768(var4 >> 14 & 32767);
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
                                             Client.field519.method2512(75);
                                             Client.field519.method2674(var15.id);
                                          }
                                       }
                                       break label567;
                                    }

                                    if (var3 == 1004) {
                                       Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                       Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                       Client.mouseCrossColor = 2;
                                       Client.mouseCrossState = 0;
                                       Client.field519.method2512(128);
                                       Client.field519.writeShort(var4);
                                       break label567;
                                    }

                                    if (var3 == 1005) {
                                       var18 = class130.method2851(var2);
                                       if (var18 != null && var18.itemQuantities[var1] >= 100000) {
                                          Login.method239(0, "", var18.itemQuantities[var1] + " x " + class27.method571(var4).name);
                                       } else {
                                          Client.field519.method2512(128);
                                          Client.field519.writeShort(var4);
                                       }

                                       Client.field533 = 0;
                                       Projectile.field161 = class130.method2851(var2);
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
                                             Client.field519.method2512(147);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 2) {
                                             Client.field519.method2512(231);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 3) {
                                             Client.field519.method2512(187);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 4) {
                                             Client.field519.method2512(20);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 5) {
                                             Client.field519.method2512(236);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 6) {
                                             Client.field519.method2512(242);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 7) {
                                             Client.field519.method2512(6);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 8) {
                                             Client.field519.method2512(192);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 9) {
                                             Client.field519.method2512(171);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
                                          }

                                          if (var4 == 10) {
                                             Client.field519.method2512(188);
                                             Client.field519.writeInt(var2);
                                             Client.field519.writeShort(var1);
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
            class82.method1754(class130.method2851(PcmPlayer.selectedItemWidget));
         }

         if (Client.isSpellSelected) {
            ScriptEvent.method1();
         }

         if (Projectile.field161 != null && Client.field533 == 0) {
            class82.method1754(Projectile.field161);
         }

      }
   }
}
