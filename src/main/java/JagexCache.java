import java.awt.Component;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("JagexCache")
public class JagexCache {
   @ObfuscatedName("t")
   @Export("cacheDir")
   static File cacheDir;
   @ObfuscatedName("d")
   @Export("Widget_fontsArchive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   public static AbstractArchive Widget_fontsArchive;
   @ObfuscatedName("a")
   @Export("JagexCache_randomDat")
   @ObfuscatedSignature(
      descriptor = "Lclass29;"
   )
   public static BufferedFile JagexCache_randomDat = null;
   @ObfuscatedName("z")
   @Export("JagexCache_dat2File")
   @ObfuscatedSignature(
      descriptor = "Lclass29;"
   )
   public static BufferedFile JagexCache_dat2File = null;
   @ObfuscatedName("s")
   @Export("fontNameVerdana15")
   @ObfuscatedSignature(
      descriptor = "Lclass29;"
   )
   public static BufferedFile fontNameVerdana15 = null;
   @ObfuscatedName("u")
   @Export("cacheGamebuild")
   static int cacheGamebuild;

   @ObfuscatedName("w")
   public static void method1722(Component var0) {
      var0.removeMouseListener(MouseHandler.MouseHandler_instance);
      var0.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
      var0.removeFocusListener(MouseHandler.MouseHandler_instance);
      MouseHandler.MouseHandler_currentButtonVolatile = 0;
   }

   @ObfuscatedName("l")
   @Export("method1720")
   @ObfuscatedSignature(
      descriptor = "([Lclass12;II[I[I)V"
   )
   static void method1720(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if (var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if (var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if (var3[var10] == 1) {
                     var11 = var0[var6].population;
                     var12 = var8.population;
                     if (var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if (var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if (var3[var10] == 3) {
                     var11 = var0[var6].field197 ? 1 : 0;
                     var12 = var8.field197 ? 1 : 0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if (var12 != var11) {
                     if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if (var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if (var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if (var3[var10] == 1) {
                     var11 = var0[var5].population;
                     var12 = var8.population;
                     if (var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if (var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if (var3[var10] == 3) {
                     var11 = var0[var5].field197 ? 1 : 0;
                     var12 = var8.field197 ? 1 : 0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if (var11 != var12) {
                     if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if (var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if (var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method1720(var0, var1, var6, var3, var4);
         method1720(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("bj")
   @Export("method1723")
   static final boolean handleServerPacket() {
      if (GraphicsObject.gameSocket == null) {
         return false;
      } else {
         int var2;
         String var28;
         try {
            int var0 = GraphicsObject.gameSocket.available();
            if (var0 == 0) {
               return false;
            }

            if (Client.serverPacketOpcode == -1) {
               GraphicsObject.gameSocket.read(Client.serverPacketBuf.array, 0, 1);
               Client.serverPacketBuf.offset = 0;
               Client.serverPacketOpcode = Client.serverPacketBuf.readOpcode();
               Client.serverPacketLength = class164.field2771[Client.serverPacketOpcode];
               --var0;
            }

            if (Client.serverPacketLength == -1) {
               if (var0 <= 0) {
                  return false;
               }

               GraphicsObject.gameSocket.read(Client.serverPacketBuf.array, 0, 1);
               Client.serverPacketLength = Client.serverPacketBuf.array[0] & 255;
               --var0;
            }

            if (Client.serverPacketLength == -2) {
               if (var0 <= 1) {
                  return false;
               }

               GraphicsObject.gameSocket.read(Client.serverPacketBuf.array, 0, 2);
               Client.serverPacketBuf.offset = 0;
               Client.serverPacketLength = Client.serverPacketBuf.readUnsignedShort();
               var0 -= 2;
            }

            if (var0 < Client.serverPacketLength) {
               return false;
            }

            Client.serverPacketBuf.offset = 0;
            GraphicsObject.gameSocket.read(Client.serverPacketBuf.array, 0, Client.serverPacketLength);
            Client.field565 = 0;
            Client.field488 = Client.field728;
            Client.field728 = Client.field527;
            Client.field527 = Client.serverPacketOpcode;
            int var1;
            int var3;
            int var5;
            int var6;
            int var7;
            int var8;
            int var19;
            int var62;
            boolean var65;
            if (Client.serverPacketOpcode == 197) {
               Client.field623 = 0;
               Client.Players_count = 0;
               Client.serverPacketBuf.switchBitMode();
               var1 = Client.serverPacketBuf.readBits(8);
               if (var1 < Client.npcCount) {
                  for(var2 = var1; var2 < Client.npcCount; ++var2) {
                     Client.field485[++Client.field623 - 1] = Client.npcIndices[var2];
                  }
               }

               if (var1 > Client.npcCount) {
                  throw new RuntimeException("");
               }

               Client.npcCount = 0;

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = Client.npcIndices[var2];
                  NPC var58 = Client.npcs[var3];
                  var5 = Client.serverPacketBuf.readBits(1);
                  if (var5 == 0) {
                     Client.npcIndices[++Client.npcCount - 1] = var3;
                     var58.field467 = Client.cycle;
                  } else {
                     var6 = Client.serverPacketBuf.readBits(2);
                     if (var6 == 0) {
                        Client.npcIndices[++Client.npcCount - 1] = var3;
                        var58.field467 = Client.cycle;
                        Client.Players_indices[++Client.Players_count - 1] = var3;
                     } else if (var6 == 1) {
                        Client.npcIndices[++Client.npcCount - 1] = var3;
                        var58.field467 = Client.cycle;
                        var7 = Client.serverPacketBuf.readBits(3);
                        var58.method279(var7, false);
                        var8 = Client.serverPacketBuf.readBits(1);
                        if (var8 == 1) {
                           Client.Players_indices[++Client.Players_count - 1] = var3;
                        }
                     } else if (var6 == 2) {
                        Client.npcIndices[++Client.npcCount - 1] = var3;
                        var58.field467 = Client.cycle;
                        var7 = Client.serverPacketBuf.readBits(3);
                        var58.method279(var7, true);
                        var8 = Client.serverPacketBuf.readBits(3);
                        var58.method279(var8, true);
                        var62 = Client.serverPacketBuf.readBits(1);
                        if (var62 == 1) {
                           Client.Players_indices[++Client.Players_count - 1] = var3;
                        }
                     } else if (var6 == 3) {
                        Client.field485[++Client.field623 - 1] = var3;
                     }
                  }
               }

               NPC var84;
               while(Client.serverPacketBuf.method2514(Client.serverPacketLength) >= 27) {
                  var1 = Client.serverPacketBuf.readBits(15);
                  if (var1 == 32767) {
                     break;
                  }

                  var65 = false;
                  if (Client.npcs[var1] == null) {
                     Client.npcs[var1] = new NPC();
                     var65 = true;
                  }

                  var84 = Client.npcs[var1];
                  Client.npcIndices[++Client.npcCount - 1] = var1;
                  var84.field467 = Client.cycle;
                  var19 = Client.serverPacketBuf.readBits(5);
                  if (var19 > 15) {
                     var19 -= 32;
                  }

                  var5 = Client.serverPacketBuf.readBits(5);
                  if (var5 > 15) {
                     var5 -= 32;
                  }

                  var84.definition = class22.method247(Client.serverPacketBuf.readBits(14));
                  var6 = Client.field642[Client.serverPacketBuf.readBits(3)];
                  if (var65) {
                     var84.orientation = var84.field432 = var6;
                  }

                  var7 = Client.serverPacketBuf.readBits(1);
                  var8 = Client.serverPacketBuf.readBits(1);
                  if (var8 == 1) {
                     Client.Players_indices[++Client.Players_count - 1] = var1;
                  }

                  var84.field461 = var84.definition.size;
                  var84.field471 = var84.definition.field800;
                  if (var84.field471 == 0) {
                     var84.field432 = 0;
                  }

                  var84.walkSequence = var84.definition.walkSequence;
                  var84.walkBackSequence = var84.definition.walkBackSequence;
                  var84.walkLeftSequence = var84.definition.walkLeftSequence;
                  var84.walkRightSequence = var84.definition.walkRightSequence;
                  var84.idleSequence = var84.definition.field789;
                  var84.turnLeftSequence = var84.definition.textSize;
                  var84.turnRightSequence = var84.definition.turnRightSequence;
                  var84.method290(Tiles.localPlayer.hitSplatTypes2[0] + var5, Tiles.localPlayer.hitSplatValues2[0] + var19, var7 == 1);
               }

               Client.serverPacketBuf.switchToByteMode();

               for(var1 = 0; var1 < Client.Players_count; ++var1) {
                  var2 = Client.Players_indices[var1];
                  var84 = Client.npcs[var2];
                  var19 = Client.serverPacketBuf.readUnsignedByte();
                  if ((var19 & 2) != 0) {
                     var84.field475 = Client.serverPacketBuf.readUnsignedShortLE();
                     var84.field446 = Client.serverPacketBuf.readUnsignedShortAdd();
                  }

                  if ((var19 & 16) != 0) {
                     var5 = Client.serverPacketBuf.readUnsignedByte();
                     var6 = Client.serverPacketBuf.readUnsignedByteAdd();
                     var84.method277(var5, var6, Client.cycle);
                     var84.field441 = Client.cycle + 300;
                     var84.field431 = Client.serverPacketBuf.readUnsignedByteNeg();
                     var84.field425 = Client.serverPacketBuf.readUnsignedByte();
                  }

                  if ((var19 & 128) != 0) {
                     var84.definition = class22.method247(Client.serverPacketBuf.readUnsignedShortAddLE());
                     var84.field461 = var84.definition.size;
                     var84.field471 = var84.definition.field800;
                     var84.walkSequence = var84.definition.walkSequence;
                     var84.walkBackSequence = var84.definition.walkBackSequence;
                     var84.walkLeftSequence = var84.definition.walkLeftSequence;
                     var84.walkRightSequence = var84.definition.walkRightSequence;
                     var84.idleSequence = var84.definition.field789;
                     var84.turnLeftSequence = var84.definition.textSize;
                     var84.turnRightSequence = var84.definition.turnRightSequence;
                  }

                  if ((var19 & 64) != 0) {
                     var84.field434 = Client.serverPacketBuf.method2653();
                     var84.field435 = 100;
                  }

                  if ((var19 & 1) != 0) {
                     var5 = Client.serverPacketBuf.readUnsignedByteNeg();
                     var6 = Client.serverPacketBuf.readUnsignedByte();
                     var84.method277(var5, var6, Client.cycle);
                     var84.field441 = Client.cycle + 300;
                     var84.field431 = Client.serverPacketBuf.readUnsignedByteAdd();
                     var84.field425 = Client.serverPacketBuf.readUnsignedByte();
                  }

                  if ((var19 & 8) != 0) {
                     var84.spotAnimation = Client.serverPacketBuf.readUnsignedShortLE();
                     var5 = Client.serverPacketBuf.readInt();
                     var84.field430 = var5 >> 16;
                     var84.field458 = (var5 & '\uffff') + Client.cycle;
                     var84.spotAnimationFrame = 0;
                     var84.spotAnimationFrameCycle = 0;
                     if (var84.field458 > Client.cycle) {
                        var84.spotAnimationFrame = -1;
                     }

                     if (var84.spotAnimation == 65535) {
                        var84.spotAnimation = -1;
                     }
                  }

                  if ((var19 & 4) != 0) {
                     var5 = Client.serverPacketBuf.readUnsignedShortAddLE();
                     if (var5 == 65535) {
                        var5 = -1;
                     }

                     var6 = Client.serverPacketBuf.readUnsignedByteSub();
                     if (var5 == var84.sequence && var5 != -1) {
                        var7 = class23.method250(var5).field901;
                        if (var7 == 1) {
                           var84.sequenceFrame = 0;
                           var84.sequenceFrameCycle = 0;
                           var84.sequenceDelay = var6;
                           var84.field421 = 0;
                        }

                        if (var7 == 2) {
                           var84.field421 = 0;
                        }
                     } else if (var5 == -1 || var84.sequence == -1 || class23.method250(var5).field895 >= class23.method250(var84.sequence).field895) {
                        var84.sequence = var5;
                        var84.sequenceFrame = 0;
                        var84.sequenceFrameCycle = 0;
                        var84.sequenceDelay = var6;
                        var84.field421 = 0;
                        var84.field472 = var84.pathLength;
                     }
                  }

                  if ((var19 & 32) != 0) {
                     var84.field444 = Client.serverPacketBuf.readUnsignedShortAdd();
                     if (var84.field444 == 65535) {
                        var84.field444 = -1;
                     }
                  }
               }

               for(var1 = 0; var1 < Client.field623; ++var1) {
                  var2 = Client.field485[var1];
                  if (Client.npcs[var2].field467 != Client.cycle) {
                     Client.npcs[var2].definition = null;
                     Client.npcs[var2] = null;
                  }
               }

               if (Client.serverPacketLength != Client.serverPacketBuf.offset) {
                  throw new RuntimeException(Client.serverPacketBuf.offset + "," + Client.serverPacketLength);
               }

               for(var1 = 0; var1 < Client.npcCount; ++var1) {
                  if (Client.npcs[Client.npcIndices[var1]] == null) {
                     throw new RuntimeException(var1 + "," + Client.npcCount);
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 212) {
               Client.method568();
               Client.field558 = Client.serverPacketBuf.readShort();
               Client.field676 = Client.field681;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 233) {
               Client.field715 = 0;
               Client.serverPacketOpcode = -1;
               return true;
            }

            long var20;
            if (Client.serverPacketOpcode == 214) {
               var1 = Client.serverPacketBuf.readUnsignedIntIME();
               var2 = Client.serverPacketBuf.readUnsignedShortAddLE();
               if (var2 == 65535) {
                  var2 = -1;
               }

               var3 = Client.serverPacketBuf.readUnsignedIntME();
               var19 = Client.serverPacketBuf.readUnsignedShortLE();
               if (var19 == 65535) {
                  var19 = -1;
               }

               for(var5 = var2; var5 <= var19; ++var5) {
                  var20 = (long)var5 + ((long)var1 << 32);
                  Node var22 = Client.widgetFlags.method3512(var20);
                  if (var22 != null) {
                     var22.method3567();
                  }

                  Client.widgetFlags.method3517(new IntegerNode(var3), var20);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 207) {
               var1 = Client.serverPacketBuf.readUnsignedShort();
               var2 = Client.serverPacketBuf.readInt();
               var3 = Client.serverPacketBuf.readUnsignedShortAddLE();
               var19 = Client.serverPacketBuf.readUnsignedShortAdd();
               Widget var80 = class130.getWidget(var2);
               if (var1 != var80.modelAngleX || var3 != var80.modelAngleY || var19 != var80.field2679) {
                  var80.modelAngleX = var1;
                  var80.modelAngleY = var3;
                  var80.field2679 = var19;
                  class82.invalidateWidget(var80);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 37) {
               Client.field730 = true;
               World.field209 = Client.serverPacketBuf.readUnsignedByte();
               Interpreter.field416 = Client.serverPacketBuf.readUnsignedByte();
               class5.field73 = Client.serverPacketBuf.readUnsignedShort();
               ObjectSound.field78 = Client.serverPacketBuf.readUnsignedByte();
               SoundCache.field1206 = Client.serverPacketBuf.readUnsignedByte();
               if (SoundCache.field1206 >= 100) {
                  Login.cameraX = World.field209 * 128 + 64;
                  class17.cameraZ = Interpreter.field416 * 128 + 64;
                  class22.cameraY = BufferedFile.method603(Login.cameraX, class17.cameraZ, class22.Client_plane) - class5.field73;
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            String var18;
            boolean var52;
            boolean var59;
            boolean var67;
            boolean var74;
            String var78;
            if (Client.serverPacketOpcode == 126) {
               while(Client.serverPacketBuf.offset < Client.serverPacketLength) {
                  var52 = Client.serverPacketBuf.readUnsignedByte() == 1;
                  var78 = Client.serverPacketBuf.method2653();
                  var18 = Client.serverPacketBuf.method2653();
                  var19 = Client.serverPacketBuf.readUnsignedShort();
                  var5 = Client.serverPacketBuf.readUnsignedByte();
                  var6 = Client.serverPacketBuf.readUnsignedByte();
                  boolean var64 = (var6 & 2) != 0;
                  var59 = (var6 & 1) != 0;
                  if (var19 > 0) {
                     Client.serverPacketBuf.method2653();
                     Client.serverPacketBuf.readUnsignedByte();
                     Client.serverPacketBuf.readInt();
                  }

                  Client.serverPacketBuf.method2653();

                  for(var62 = 0; var62 < Client.field736; ++var62) {
                     class22 var63 = Client.field532[var62];
                     if (!var52) {
                        if (var78.equals(var63.field381)) {
                           if (var19 != var63.field370) {
                              var67 = true;

                              for(class27 var68 = (class27)Client.field680.method3506(); var68 != null; var68 = (class27)Client.field680.method3501()) {
                                 if (var68.field749.equals(var78)) {
                                    if (var19 != 0 && var68.field751 == 0) {
                                       var68.method3563();
                                       var67 = false;
                                    } else if (var19 == 0 && var68.field751 != 0) {
                                       var68.method3563();
                                       var67 = false;
                                    }
                                 }
                              }

                              if (var67) {
                                 Client.field680.method3500(new class27(var78, var19));
                              }

                              var63.field370 = var19;
                           }

                           var63.field369 = var18;
                           var63.field371 = var5;
                           var63.field372 = var64;
                           var63.field368 = var59;
                           var78 = null;
                           break;
                        }
                     } else if (var18.equals(var63.field381)) {
                        var63.field381 = var78;
                        var63.field369 = var18;
                        var78 = null;
                        break;
                     }
                  }

                  if (var78 != null && Client.field736 < 400) {
                     class22 var83 = new class22();
                     Client.field532[Client.field736] = var83;
                     var83.field381 = var78;
                     var83.field369 = var18;
                     var83.field370 = var19;
                     var83.field371 = var5;
                     var83.field372 = var64;
                     var83.field368 = var59;
                     ++Client.field736;
                  }
               }

               Client.field737 = 2;
               Client.field674 = Client.field681;
               var52 = false;
               var2 = Client.field736;

               while(var2 > 0) {
                  var52 = true;
                  --var2;

                  for(var3 = 0; var3 < var2; ++var3) {
                     var74 = false;
                     class22 var79 = Client.field532[var3];
                     class22 var89 = Client.field532[var3 + 1];
                     if (var79.field370 != Client.ViewportMouse_x && var89.field370 == Client.ViewportMouse_x) {
                        var74 = true;
                     }

                     if (!var74 && var79.field370 == 0 && var89.field370 != 0) {
                        var74 = true;
                     }

                     if (!var74 && !var79.field372 && var89.field372) {
                        var74 = true;
                     }

                     if (!var74 && !var79.field368 && var89.field368) {
                        var74 = true;
                     }

                     if (var74) {
                        class22 var95 = Client.field532[var3];
                        Client.field532[var3] = Client.field532[var3 + 1];
                        Client.field532[var3 + 1] = var95;
                        var52 = false;
                     }
                  }

                  if (var52) {
                     break;
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            Widget var70;
            if (Client.serverPacketOpcode == 102) {
               var1 = Client.serverPacketBuf.readInt();
               var2 = Client.serverPacketBuf.readUnsignedShort();
               if (var1 < -70000) {
                  var2 += 32768;
               }

               if (var1 >= 0) {
                  var70 = class130.getWidget(var1);
               } else {
                  var70 = null;
               }

               if (var70 != null) {
                  for(var19 = 0; var19 < var70.itemIds.length; ++var19) {
                     var70.itemIds[var19] = 0;
                     var70.itemQuantities[var19] = 0;
                  }
               }

               ItemContainer var57 = (ItemContainer)ItemContainer.itemContainers.method3512((long)var2);
               if (var57 != null) {
                  for(var5 = 0; var5 < var57.ids.length; ++var5) {
                     var57.ids[var5] = -1;
                     var57.quantities[var5] = 0;
                  }
               }

               var19 = Client.serverPacketBuf.readUnsignedShort();

               for(var5 = 0; var5 < var19; ++var5) {
                  var6 = Client.serverPacketBuf.readUnsignedShort();
                  var7 = Client.serverPacketBuf.readUnsignedByte();
                  if (var7 == 255) {
                     var7 = Client.serverPacketBuf.readInt();
                  }

                  if (var70 != null && var5 < var70.itemIds.length) {
                     var70.itemIds[var5] = var6;
                     var70.itemQuantities[var5] = var7;
                  }

                  KitDefinition.method806(var2, var5, var6 - 1, var7);
               }

               if (var70 != null) {
                  class82.invalidateWidget(var70);
               }

               Client.method568();
               Client.field578[++Client.field670 - 1 & 31] = var2 & 32767;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 68) {
               var1 = Client.serverPacketBuf.readUnsignedIntLE();
               GraphicsObject.field305 = ItemContainer.taskHandler.method1605(var1);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 53) {
               var1 = Client.serverPacketBuf.readUnsignedShort();
               var2 = Client.serverPacketBuf.readUnsignedIntLE();
               var70 = class130.getWidget(var2);
               if (var70.modelType != 1 || var1 != var70.modelId) {
                  var70.modelType = 1;
                  var70.modelId = var1;
                  class82.invalidateWidget(var70);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 44) {
               Client.field737 = 1;
               Client.field674 = Client.field681;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 216) {
               var1 = Client.serverPacketBuf.readInt();
               InterfaceParent var93 = (InterfaceParent)Client.interfaceParents.method3512((long)var1);
               if (var93 != null) {
                  Tiles.method60(var93, true);
               }

               if (Client.meslayerContinueWidget != null) {
                  class82.invalidateWidget(Client.meslayerContinueWidget);
                  Client.meslayerContinueWidget = null;
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            Widget var4;
            if (Client.serverPacketOpcode == 78) {
               var1 = Client.serverPacketBuf.readUnsignedShort();
               var2 = Client.serverPacketBuf.readUnsignedIntLE();
               var3 = Client.serverPacketBuf.readUnsignedShortLE();
               var4 = class130.getWidget(var2);
               var4.field2601 = var1 + (var3 << 16);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 131) {
               Client.field585 = Client.serverPacketBuf.readUnsignedShort() * 30;
               Client.field676 = Client.field681;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 86) {
               var28 = Client.serverPacketBuf.method2653();
               var2 = Client.serverPacketBuf.readUnsignedShort();
               byte var66 = Client.serverPacketBuf.readByte();
               var74 = false;
               if (var66 == -128) {
                  var74 = true;
               }

               if (var74) {
                  if (SoundSystem.field1188 == 0) {
                     Client.serverPacketOpcode = -1;
                     return true;
                  }

                  boolean var60 = false;

                  for(var5 = 0; var5 < SoundSystem.field1188 && (!ItemComposition.field1026[var5].field112.equals(var28) || var2 != ItemComposition.field1026[var5].field109); ++var5) {
                     ;
                  }

                  if (var5 < SoundSystem.field1188) {
                     while(var5 < SoundSystem.field1188 - 1) {
                        ItemComposition.field1026[var5] = ItemComposition.field1026[var5 + 1];
                        ++var5;
                     }

                     --SoundSystem.field1188;
                     ItemComposition.field1026[SoundSystem.field1188] = null;
                  }
               } else {
                  Client.serverPacketBuf.method2653();
                  class7 var77 = new class7();
                  var77.field112 = var28;
                  var77.field103 = Projectile.method125(var77.field112, class5.field75);
                  var77.field109 = var2;
                  var77.field105 = var66;

                  for(var6 = SoundSystem.field1188 - 1; var6 >= 0; --var6) {
                     var7 = ItemComposition.field1026[var6].field103.compareTo(var77.field112);
                     if (var7 == 0) {
                        ItemComposition.field1026[var6].field109 = var2;
                        ItemComposition.field1026[var6].field105 = var66;
                        if (var28.equals(Tiles.localPlayer.field35)) {
                           MusicPatch.field2354 = var66;
                        }

                        Client.field675 = Client.field681;
                        Client.serverPacketOpcode = -1;
                        return true;
                     }

                     if (var7 < 0) {
                        break;
                     }
                  }

                  if (SoundSystem.field1188 >= ItemComposition.field1026.length) {
                     Client.serverPacketOpcode = -1;
                     return true;
                  }

                  for(var7 = SoundSystem.field1188 - 1; var7 > var6; --var7) {
                     ItemComposition.field1026[var7 + 1] = ItemComposition.field1026[var7];
                  }

                  if (SoundSystem.field1188 == 0) {
                     ItemComposition.field1026 = new class7[100];
                  }

                  ItemComposition.field1026[var6 + 1] = var77;
                  ++SoundSystem.field1188;
                  if (var28.equals(Tiles.localPlayer.field35)) {
                     MusicPatch.field2354 = var66;
                  }
               }

               Client.field675 = Client.field681;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 40) {
               var1 = Client.serverPacketBuf.readInt();
               var2 = Client.serverPacketBuf.readUnsignedShort();
               if (var1 < -70000) {
                  var2 += 32768;
               }

               if (var1 >= 0) {
                  var70 = class130.getWidget(var1);
               } else {
                  var70 = null;
               }

               for(; Client.serverPacketBuf.offset < Client.serverPacketLength; KitDefinition.method806(var2, var19, var5 - 1, var6)) {
                  var19 = Client.serverPacketBuf.method2658();
                  var5 = Client.serverPacketBuf.readUnsignedShort();
                  var6 = 0;
                  if (var5 != 0) {
                     var6 = Client.serverPacketBuf.readUnsignedByte();
                     if (var6 == 255) {
                        var6 = Client.serverPacketBuf.readInt();
                     }
                  }

                  if (var70 != null && var19 >= 0 && var19 < var70.itemIds.length) {
                     var70.itemIds[var19] = var5;
                     var70.itemQuantities[var19] = var6;
                  }
               }

               if (var70 != null) {
                  class82.invalidateWidget(var70);
               }

               Client.method568();
               Client.field578[++Client.field670 - 1 & 31] = var2 & 32767;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 188) {
               var1 = Client.serverPacketBuf.readUnsignedByteAdd();
               var2 = Client.serverPacketBuf.readUnsignedByteSub();
               var3 = Client.serverPacketBuf.readUnsignedByte();
               class22.Client_plane = var1 >> 1;
               Tiles.localPlayer.method290(var3, var2, (var1 & 1) == 1);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 232) {
               var1 = Client.serverPacketBuf.readUnsignedShort();
               WallDecoration.method2384(var1);
               Client.field578[++Client.field670 - 1 & 31] = var1 & 32767;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 38) {
               Client.method568();
               Client.field648 = Client.serverPacketBuf.readUnsignedByte();
               Client.field676 = Client.field681;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 23) {
               Login.loadRegions(true);
               Client.serverPacketOpcode = -1;
               return true;
            }

            String var55;
            if (Client.serverPacketOpcode == 244) {
               while(Client.serverPacketBuf.offset < Client.serverPacketLength) {
                  var1 = Client.serverPacketBuf.readUnsignedByte();
                  var65 = (var1 & 1) == 1;
                  var18 = Client.serverPacketBuf.method2653();
                  var55 = Client.serverPacketBuf.method2653();
                  Client.serverPacketBuf.method2653();

                  for(var5 = 0; var5 < Client.field534; ++var5) {
                     class10 var87 = Client.field741[var5];
                     if (var65) {
                        if (var55.equals(var87.field177)) {
                           var87.field177 = var18;
                           var87.field178 = var55;
                           var18 = null;
                           break;
                        }
                     } else if (var18.equals(var87.field177)) {
                        var87.field177 = var18;
                        var87.field178 = var55;
                        var18 = null;
                        break;
                     }
                  }

                  if (var18 != null && Client.field534 < 400) {
                     class10 var76 = new class10();
                     Client.field741[Client.field534] = var76;
                     var76.field177 = var18;
                     var76.field178 = var55;
                     ++Client.field534;
                  }
               }

               Client.field674 = Client.field681;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 210) {
               var1 = Client.serverPacketBuf.readUnsignedShortLE();
               var2 = Client.serverPacketBuf.readUnsignedIntIME();
               var70 = class130.getWidget(var2);
               if (var70.modelType != 2 || var1 != var70.modelId) {
                  var70.modelType = 2;
                  var70.modelId = var1;
                  class82.invalidateWidget(var70);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 90) {
               for(var1 = 0; var1 < Varps.Varps_main.length; ++var1) {
                  if (Varps.Varps_temp[var1] != Varps.Varps_main[var1]) {
                     Varps.Varps_main[var1] = Varps.Varps_temp[var1];
                     PendingSpawn.method243(var1);
                     Client.field667[++Client.field668 - 1 & 31] = var1;
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 1) {
               Actor.field478 = Client.serverPacketBuf.readUnsignedByteAdd();
               GraphicsObject.field307 = Client.serverPacketBuf.readUnsignedByteNeg();

               for(var1 = Actor.field478; var1 < Actor.field478 + 8; ++var1) {
                  for(var2 = GraphicsObject.field307; var2 < GraphicsObject.field307 + 8; ++var2) {
                     if (Client.groundItems[class22.Client_plane][var1][var2] != null) {
                        Client.groundItems[class22.Client_plane][var1][var2] = null;
                        GameObject.method2205(var1, var2);
                     }
                  }
               }

               for(PendingSpawn var97 = (PendingSpawn)Client.pendingSpawns.method3533(); var97 != null; var97 = (PendingSpawn)Client.pendingSpawns.method3535()) {
                  if (var97.x >= Actor.field478 && var97.x < Actor.field478 + 8 && var97.y >= GraphicsObject.field307 && var97.y < GraphicsObject.field307 + 8 && var97.plane == class22.Client_plane) {
                     var97.hitpoints = 0;
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 69) {
               var1 = Client.serverPacketBuf.readUnsignedShortAdd();
               Client.field643 = var1;
               Tiles.method99(var1);
               MouseRecorder.method168(Client.field643);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field686[var2] = true;
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 56) {
               var1 = Client.serverPacketBuf.readUnsignedShortAddLE();
               var2 = Client.serverPacketBuf.readUnsignedIntIME();
               var70 = class130.getWidget(var2);
               if (var70 != null && var70.type == 0) {
                  if (var1 > var70.field2592 - var70.height) {
                     var1 = var70.field2592 - var70.height;
                  }

                  if (var1 < 0) {
                     var1 = 0;
                  }

                  if (var1 != var70.field2655) {
                     var70.field2655 = var1;
                     class82.invalidateWidget(var70);
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            long var29;
            long var31;
            long var33;
            int var35;
            if (Client.serverPacketOpcode == 63) {
               var28 = Client.serverPacketBuf.method2653();
               var29 = Client.serverPacketBuf.readLong();
               var31 = (long)Client.serverPacketBuf.readUnsignedShort();
               var20 = (long)Client.serverPacketBuf.readMedium();
               var8 = Client.serverPacketBuf.readUnsignedByte();
               var33 = var20 + (var31 << 32);
               var67 = false;

               for(var35 = 0; var35 < 100; ++var35) {
                  if (Client.field702[var35] == var33) {
                     var67 = true;
                     break;
                  }
               }

               if (var8 <= 1 && ObjectSound.method45(var28)) {
                  var67 = true;
               }

               if (!var67 && Client.xPadding == 0) {
                  Client.field702[Client.field684] = var33;
                  Client.field684 = (Client.field684 + 1) % 100;
                  PacketBuffer var13 = Client.serverPacketBuf;

                  String var69;
                  try {
                     int var15 = var13.method2658();
                     if (var15 > 32767) {
                        var15 = 32767;
                     }

                     byte[] var16 = new byte[var15];
                     var13.offset += class183.huffman.method2572(var13.array, var13.offset, var16, 0, var15);
                     String var17 = InterfaceParent.method27(var16, 0, var15);
                     var69 = var17;
                  } catch (Exception var49) {
                     var69 = "Cabbage";
                  }

                  var69 = AbstractFont.method3605(TaskHandler.method1595(var69));
                  if (var8 != 2 && var8 != 3) {
                     if (var8 == 1) {
                        NPC.method256(9, FloorOverlayDefinition.method829(0) + var28, var69, Interpreter.method276(var29));
                     } else {
                        NPC.method256(9, var28, var69, Interpreter.method276(var29));
                     }
                  } else {
                     NPC.method256(9, FloorOverlayDefinition.method829(1) + var28, var69, Interpreter.method276(var29));
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 88) {
               var28 = Client.serverPacketBuf.method2653();
               var2 = Client.serverPacketBuf.readUnsignedByteSub();
               var3 = Client.serverPacketBuf.readUnsignedByteNeg();
               if (var2 >= 1 && var2 <= 8) {
                  if (var28.equalsIgnoreCase("null")) {
                     var28 = null;
                  }

                  Client.playerMenuActions[var2 - 1] = var28;
                  Client.playerOptionsPriorities[var2 - 1] = var3 == 0;
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 237) {
               var2 = Client.serverPacketBuf.readUnsignedByte();
               class136[] var73 = new class136[]{class136.field2336, class136.field2332, class136.field2335};
               class136[] var56 = var73;
               var5 = 0;

               class136 var96;
               while(true) {
                  if (var5 >= var56.length) {
                     var96 = null;
                     break;
                  }

                  class136 var86 = var56[var5];
                  if (var2 == var86.value) {
                     var96 = var86;
                     break;
                  }

                  ++var5;
               }

               ByteArrayPool.field1945 = var96;
               Client.serverPacketOpcode = -1;
               return true;
            }

            long var37;
            int var39;
            if (Client.serverPacketOpcode == 153) {
               var28 = Client.serverPacketBuf.method2653();
               var29 = (long)Client.serverPacketBuf.readUnsignedShort();
               var31 = (long)Client.serverPacketBuf.readMedium();
               var6 = Client.serverPacketBuf.readUnsignedByte();
               var37 = var31 + (var29 << 32);
               boolean var9 = false;

               for(var39 = 0; var39 < 100; ++var39) {
                  if (Client.field702[var39] == var37) {
                     var9 = true;
                     break;
                  }
               }

               if (ObjectSound.method45(var28)) {
                  var9 = true;
               }

               if (!var9 && Client.xPadding == 0) {
                  Client.field702[Client.field684] = var37;
                  Client.field684 = (Client.field684 + 1) % 100;
                  PacketBuffer var40 = Client.serverPacketBuf;

                  String var12;
                  try {
                     int var41 = var40.method2658();
                     if (var41 > 32767) {
                        var41 = 32767;
                     }

                     byte[] var14 = new byte[var41];
                     var40.offset += class183.huffman.method2572(var40.array, var40.offset, var14, 0, var41);
                     String var36 = InterfaceParent.method27(var14, 0, var41);
                     var12 = var36;
                  } catch (Exception var48) {
                     var12 = "Cabbage";
                  }

                  var12 = AbstractFont.method3605(TaskHandler.method1595(var12));
                  if (var6 != 2 && var6 != 3) {
                     if (var6 == 1) {
                        Login.method239(7, FloorOverlayDefinition.method829(0) + var28, var12);
                     } else {
                        Login.method239(3, var28, var12);
                     }
                  } else {
                     Login.method239(7, FloorOverlayDefinition.method829(1) + var28, var12);
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 51) {
               Client.hintArrowType = Client.serverPacketBuf.readUnsignedByte();
               if (Client.hintArrowType == 1) {
                  Client.field499 = Client.serverPacketBuf.readUnsignedShort();
               }

               if (Client.hintArrowType >= 2 && Client.hintArrowType <= 6) {
                  if (Client.hintArrowType == 2) {
                     Client.field504 = 64;
                     Client.field505 = 64;
                  }

                  if (Client.hintArrowType == 3) {
                     Client.field504 = 0;
                     Client.field505 = 64;
                  }

                  if (Client.hintArrowType == 4) {
                     Client.field504 = 128;
                     Client.field505 = 64;
                  }

                  if (Client.hintArrowType == 5) {
                     Client.field504 = 64;
                     Client.field505 = 0;
                  }

                  if (Client.hintArrowType == 6) {
                     Client.field504 = 64;
                     Client.field505 = 128;
                  }

                  Client.hintArrowType = 2;
                  Client.hintArrowX = Client.serverPacketBuf.readUnsignedShort();
                  Client.hintArrowY = Client.serverPacketBuf.readUnsignedShort();
                  Client.field479 = Client.serverPacketBuf.readUnsignedByte();
               }

               if (Client.hintArrowType == 10) {
                  Client.field500 = Client.serverPacketBuf.readUnsignedShort();
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 177) {
               var28 = Client.serverPacketBuf.method2653();
               Object[] var91 = new Object[var28.length() + 1];

               for(var3 = var28.length() - 1; var3 >= 0; --var3) {
                  if (var28.charAt(var3) == 's') {
                     var91[var3 + 1] = Client.serverPacketBuf.method2653();
                  } else {
                     var91[var3 + 1] = new Integer(Client.serverPacketBuf.readInt());
                  }
               }

               var91[0] = new Integer(Client.serverPacketBuf.readInt());
               ScriptEvent var72 = new ScriptEvent();
               var72.args = var91;
               Renderable.method2040(var72);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 111 || Client.serverPacketOpcode == 103 || Client.serverPacketOpcode == 220 || Client.serverPacketOpcode == 64 || Client.serverPacketOpcode == 41 || Client.serverPacketOpcode == 238 || Client.serverPacketOpcode == 89 || Client.serverPacketOpcode == 70 || Client.serverPacketOpcode == 182 || Client.serverPacketOpcode == 13 || Client.serverPacketOpcode == 65) {
               IterableNodeHashTableIterator.handleServerPacket();
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 107) {
               GraphicsObject.field307 = Client.serverPacketBuf.readUnsignedByte();
               Actor.field478 = Client.serverPacketBuf.readUnsignedByte();
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 138) {
               Client.field717 = Client.serverPacketBuf.readUnsignedByte();
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 141) {
               class10.method130();
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 208) {
               var28 = Client.serverPacketBuf.method2653();
               PacketBuffer var71 = Client.serverPacketBuf;

               try {
                  var5 = var71.method2658();
                  if (var5 > 32767) {
                     var5 = 32767;
                  }

                  byte[] var85 = new byte[var5];
                  var71.offset += class183.huffman.method2572(var71.array, var71.offset, var85, 0, var5);
                  String var94 = InterfaceParent.method27(var85, 0, var5);
                  var55 = var94;
               } catch (Exception var47) {
                  var55 = "Cabbage";
               }

               var55 = AbstractFont.method3605(TaskHandler.method1595(var55));
               Login.method239(6, var28, var55);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 173) {
               SequenceDefinition.method762(Client.serverPacketBuf, Client.serverPacketLength);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 149) {
               byte var61 = Client.serverPacketBuf.readByteSub();
               var2 = Client.serverPacketBuf.readUnsignedShortLE();
               Varps.Varps_temp[var2] = var61;
               if (Varps.Varps_main[var2] != var61) {
                  Varps.Varps_main[var2] = var61;
                  PendingSpawn.method243(var2);
               }

               Client.field667[++Client.field668 - 1 & 31] = var2;
               Client.serverPacketOpcode = -1;
               return true;
            }

            InterfaceParent var53;
            if (Client.serverPacketOpcode == 66) {
               var1 = Client.serverPacketBuf.readUnsignedIntME();
               var2 = Client.serverPacketBuf.readUnsignedShort();
               var3 = Client.serverPacketBuf.readUnsignedByte();
               var53 = (InterfaceParent)Client.interfaceParents.method3512((long)var1);
               if (var53 != null) {
                  Tiles.method60(var53, var2 != var53.group);
               }

               InterfaceParent var75 = new InterfaceParent();
               var75.group = var2;
               var75.field56 = var3;
               Client.interfaceParents.method3517(var75, (long)var1);
               Tiles.method99(var2);
               MouseRecorder.method168(var2);
               Widget var26 = class130.getWidget(var1);
               if (var26 != null) {
                  class82.invalidateWidget(var26);
               }

               if (Client.meslayerContinueWidget != null) {
                  class82.invalidateWidget(Client.meslayerContinueWidget);
                  Client.meslayerContinueWidget = null;
               }

               for(var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
                  if (Tiles.method93(Client.menuOpcodes[var7])) {
                     if (var7 < Client.menuOptionsCount - 1) {
                        for(var8 = var7; var8 < Client.menuOptionsCount - 1; ++var8) {
                           Client.menuActions[var8] = Client.menuActions[var8 + 1];
                           Client.menuTargets[var8] = Client.menuTargets[var8 + 1];
                           Client.menuOpcodes[var8] = Client.menuOpcodes[var8 + 1];
                           Client.menuIdentifiers[var8] = Client.menuIdentifiers[var8 + 1];
                           Client.menuArguments1[var8] = Client.menuArguments1[var8 + 1];
                           Client.menuArguments2[var8] = Client.menuArguments2[var8 + 1];
                        }
                     }

                     --Client.menuOptionsCount;
                  }
               }

               if (Client.field643 != -1) {
                  SceneTilePaint.method2208(Client.field643, 1);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 135) {
               Client.field730 = true;
               AccessFile.field757 = Client.serverPacketBuf.readUnsignedByte();
               class125.field2036 = Client.serverPacketBuf.readUnsignedByte();
               SceneTilePaint.field1681 = Client.serverPacketBuf.readUnsignedShort();
               FaceNormal.field1519 = Client.serverPacketBuf.readUnsignedByte();
               class65.field1268 = Client.serverPacketBuf.readUnsignedByte();
               if (class65.field1268 >= 100) {
                  var1 = AccessFile.field757 * 128 + 64;
                  var2 = class125.field2036 * 128 + 64;
                  var3 = BufferedFile.method603(var1, var2, class22.Client_plane) - SceneTilePaint.field1681;
                  var19 = var1 - Login.cameraX;
                  var5 = var3 - class22.cameraY;
                  var6 = var2 - class17.cameraZ;
                  var7 = (int)Math.sqrt((double)(var19 * var19 + var6 * var6));
                  NPC.cameraPitch = (int)(Math.atan2((double)var5, (double)var7) * 325.949D) & 2047;
                  MouseRecorder.cameraYaw = (int)(Math.atan2((double)var19, (double)var6) * -325.949D) & 2047;
                  if (NPC.cameraPitch < 128) {
                     NPC.cameraPitch = 128;
                  }

                  if (NPC.cameraPitch > 383) {
                     NPC.cameraPitch = 383;
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 42) {
               Client.method568();
               var1 = Client.serverPacketBuf.readUnsignedByteNeg();
               var2 = Client.serverPacketBuf.readUnsignedByteAdd();
               var3 = Client.serverPacketBuf.readUnsignedIntLE();
               Client.field529[var2] = var3;
               Client.field621[var2] = var1;
               Client.levels[var2] = 1;

               for(var19 = 0; var19 < 98; ++var19) {
                  if (var3 >= Skills.Skills_experienceTable[var19]) {
                     Client.levels[var2] = var19 + 2;
                  }
               }

               Client.field671[++Client.field672 - 1 & 31] = var2;
               Client.serverPacketOpcode = -1;
               return true;
            }

            Widget var88;
            if (Client.serverPacketOpcode == 8) {
               var1 = Client.serverPacketBuf.readUnsignedIntIME();
               var88 = class130.getWidget(var1);

               for(var3 = 0; var3 < var88.itemIds.length; ++var3) {
                  var88.itemIds[var3] = -1;
                  var88.itemIds[var3] = 0;
               }

               class82.invalidateWidget(var88);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 163) {
               Actor.field478 = Client.serverPacketBuf.readUnsignedByteAdd();
               GraphicsObject.field307 = Client.serverPacketBuf.readUnsignedByteAdd();

               while(Client.serverPacketBuf.offset < Client.serverPacketLength) {
                  Client.serverPacketOpcode = Client.serverPacketBuf.readUnsignedByte();
                  IterableNodeHashTableIterator.handleServerPacket();
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 31) {
               var1 = Client.serverPacketBuf.readUnsignedIntLE();
               var2 = Client.serverPacketBuf.readShortAdd();
               var70 = class130.getWidget(var1);
               if (var2 != var70.sequenceId || var2 == -1) {
                  var70.sequenceId = var2;
                  var70.modelFrame = 0;
                  var70.modelFrameCycle = 0;
                  class82.invalidateWidget(var70);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 217) {
               var1 = Client.serverPacketBuf.readUnsignedIntIME();
               var88 = class130.getWidget(var1);
               var88.modelType = 3;
               var88.modelId = Tiles.localPlayer.appearance.method3401();
               class82.invalidateWidget(var88);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 87) {
               Login.loadRegions(false);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 191) {
               var28 = Client.serverPacketBuf.method2653();
               boolean var54;
               if (var28.endsWith(":tradereq:")) {
                  var78 = var28.substring(0, var28.indexOf(":"));
                  var54 = false;
                  if (ObjectSound.method45(var78)) {
                     var54 = true;
                  }

                  if (!var54 && Client.xPadding == 0) {
                     Login.method239(4, var78, "wishes to trade with you.");
                  }
               } else if (var28.endsWith(":duelreq:")) {
                  var78 = var28.substring(0, var28.indexOf(":"));
                  var54 = false;
                  if (ObjectSound.method45(var78)) {
                     var54 = true;
                  }

                  if (!var54 && Client.xPadding == 0) {
                     Login.method239(8, var78, "wishes to duel with you.");
                  }
               } else if (var28.endsWith(":chalreq:")) {
                  var78 = var28.substring(0, var28.indexOf(":"));
                  var54 = false;
                  if (ObjectSound.method45(var78)) {
                     var54 = true;
                  }

                  if (!var54 && Client.xPadding == 0) {
                     var55 = var28.substring(var28.indexOf(":") + 1, var28.length() - 9);
                     Login.method239(8, var78, var55);
                  }
               } else if (var28.endsWith(":assistreq:")) {
                  var78 = var28.substring(0, var28.indexOf(":"));
                  var54 = false;
                  if (ObjectSound.method45(var78)) {
                     var54 = true;
                  }

                  if (!var54 && Client.xPadding == 0) {
                     Login.method239(10, var78, "");
                  }
               } else if (var28.endsWith(":clan:")) {
                  var78 = var28.substring(0, var28.indexOf(":clan:"));
                  Login.method239(11, "", var78);
               } else if (var28.endsWith(":trade:")) {
                  var78 = var28.substring(0, var28.indexOf(":trade:"));
                  if (Client.xPadding == 0) {
                     Login.method239(12, "", var78);
                  }
               } else if (var28.endsWith(":assist:")) {
                  var78 = var28.substring(0, var28.indexOf(":assist:"));
                  if (Client.xPadding == 0) {
                     Login.method239(13, "", var78);
                  }
               } else {
                  Login.method239(0, "", var28);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 94) {
               for(var1 = 0; var1 < Client.players.length; ++var1) {
                  if (Client.players[var1] != null) {
                     Client.players[var1].sequence = -1;
                  }
               }

               for(var1 = 0; var1 < Client.npcs.length; ++var1) {
                  if (Client.npcs[var1] != null) {
                     Client.npcs[var1].sequence = -1;
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 73) {
               Client.serverPacketBuf.offset += 28;
               if (Client.serverPacketBuf.method2679()) {
                  Client.method567(Client.serverPacketBuf, Client.serverPacketBuf.offset - 28);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 137) {
               var1 = Client.serverPacketBuf.readUnsignedIntME();
               var2 = Client.serverPacketBuf.readUnsignedShort();
               Varps.Varps_temp[var2] = var1;
               if (Varps.Varps_main[var2] != var1) {
                  Varps.Varps_main[var2] = var1;
                  PendingSpawn.method243(var2);
               }

               Client.field667[++Client.field668 - 1 & 31] = var2;
               Client.serverPacketOpcode = -1;
               return true;
            }

            int var11;
            if (Client.serverPacketOpcode == 99) {
               var1 = Client.serverPacketLength + Client.serverPacketBuf.offset;
               var2 = Client.serverPacketBuf.readUnsignedShort();
               var3 = Client.serverPacketBuf.readUnsignedShort();
               if (var2 != Client.field643) {
                  Client.field643 = var2;
                  Tiles.method99(Client.field643);
                  MouseRecorder.method168(Client.field643);

                  for(var19 = 0; var19 < 100; ++var19) {
                     Client.field686[var19] = true;
                  }
               }

               InterfaceParent var92;
               for(; var3-- > 0; var92.field54 = true) {
                  var19 = Client.serverPacketBuf.readInt();
                  var5 = Client.serverPacketBuf.readUnsignedShort();
                  var6 = Client.serverPacketBuf.readUnsignedByte();
                  var92 = (InterfaceParent)Client.interfaceParents.method3512((long)var19);
                  if (var92 != null && var5 != var92.group) {
                     Tiles.method60(var92, true);
                     var92 = null;
                  }

                  if (var92 == null) {
                     InterfaceParent var82 = new InterfaceParent();
                     var82.group = var5;
                     var82.field56 = var6;
                     Client.interfaceParents.method3517(var82, (long)var19);
                     Tiles.method99(var5);
                     MouseRecorder.method168(var5);
                     Widget var10 = class130.getWidget(var19);
                     if (var10 != null) {
                        class82.invalidateWidget(var10);
                     }

                     if (Client.meslayerContinueWidget != null) {
                        class82.invalidateWidget(Client.meslayerContinueWidget);
                        Client.meslayerContinueWidget = null;
                     }

                     for(var11 = 0; var11 < Client.menuOptionsCount; ++var11) {
                        if (Tiles.method93(Client.menuOpcodes[var11])) {
                           if (var11 < Client.menuOptionsCount - 1) {
                              for(var35 = var11; var35 < Client.menuOptionsCount - 1; ++var35) {
                                 Client.menuActions[var35] = Client.menuActions[var35 + 1];
                                 Client.menuTargets[var35] = Client.menuTargets[var35 + 1];
                                 Client.menuOpcodes[var35] = Client.menuOpcodes[var35 + 1];
                                 Client.menuIdentifiers[var35] = Client.menuIdentifiers[var35 + 1];
                                 Client.menuArguments1[var35] = Client.menuArguments1[var35 + 1];
                                 Client.menuArguments2[var35] = Client.menuArguments2[var35 + 1];
                              }
                           }

                           --Client.menuOptionsCount;
                        }
                     }

                     if (Client.field643 != -1) {
                        SceneTilePaint.method2208(Client.field643, 1);
                     }

                     var92 = var82;
                  }
               }

               for(var53 = (InterfaceParent)Client.interfaceParents.method3515(); var53 != null; var53 = (InterfaceParent)Client.interfaceParents.method3516()) {
                  if (var53.field54) {
                     var53.field54 = false;
                  } else {
                     Tiles.method60(var53, true);
                  }
               }

               Client.widgetFlags = new NodeHashTable(512);

               while(Client.serverPacketBuf.offset < var1) {
                  var19 = Client.serverPacketBuf.readInt();
                  var5 = Client.serverPacketBuf.readUnsignedShort();
                  var6 = Client.serverPacketBuf.readUnsignedShort();
                  var7 = Client.serverPacketBuf.readInt();

                  for(var8 = var5; var8 <= var6; ++var8) {
                     var33 = ((long)var19 << 32) + (long)var8;
                     Client.widgetFlags.method3517(new IntegerNode(var7), var33);
                  }
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 123) {
               Client.field730 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field731[var1] = false;
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 198) {
               var1 = Client.serverPacketBuf.readShortAddLE();
               var2 = Client.serverPacketBuf.readShortAdd();
               var3 = Client.serverPacketBuf.readInt();
               var4 = class130.getWidget(var3);
               var5 = var1 + var4.field2623;
               var6 = var2 + var4.field2584;
               if (var5 != var4.rawX || var6 != var4.field2579) {
                  var4.rawX = var5;
                  var4.field2579 = var6;
                  class82.invalidateWidget(var4);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 35) {
               var1 = Client.serverPacketBuf.readUnsignedIntME();
               var78 = Client.serverPacketBuf.method2653();
               var70 = class130.getWidget(var1);
               if (!var78.equals(var70.field2633)) {
                  var70.field2633 = var78;
                  class82.invalidateWidget(var70);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 61) {
               for(var1 = 0; var1 < VarpDefinition.field1039; ++var1) {
                  VarpDefinition var24 = GameBuild.method2854(var1);
                  if (var24 != null && var24.type == 0) {
                     Varps.Varps_temp[var1] = 0;
                     Varps.Varps_main[var1] = 0;
                  }
               }

               Client.method568();
               Client.field668 += 32;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 52) {
               if (Client.field643 != -1) {
                  SceneTilePaint.method2208(Client.field643, 0);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 190) {
               var1 = Client.serverPacketBuf.readUnsignedByte();
               var2 = Client.serverPacketBuf.readUnsignedByte();
               var3 = Client.serverPacketBuf.readUnsignedByte();
               var19 = Client.serverPacketBuf.readUnsignedByte();
               Client.field731[var1] = true;
               Client.field575[var1] = var2;
               Client.field733[var1] = var3;
               Client.field587[var1] = var19;
               Client.field735[var1] = 0;
               Client.serverPacketOpcode = -1;
               return true;
            }

            int IF_SETCOLOUR = 71;
            if (Client.serverPacketOpcode == IF_SETCOLOUR) {
               var1 = Client.serverPacketBuf.readUnsignedShortAdd();
               var2 = Client.serverPacketBuf.readUnsignedIntLE();
               var3 = var1 >> 10 & 31;
               var19 = var1 >> 5 & 31;
               var5 = var1 & 31;
               var6 = (var19 << 11) + (var3 << 19) + (var5 << 3);
               Widget var90 = class130.getWidget(var2);
               if (var6 != var90.color) {
                  var90.color = var6;
                  class82.invalidateWidget(var90);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 24) {
               Client.field700 = Client.serverPacketBuf.readUnsignedByte();
               Client.field748 = Client.serverPacketBuf.readUnsignedByte();
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 22) {
               var1 = Client.serverPacketBuf.readUnsignedShort();
               var2 = Client.serverPacketBuf.readUnsignedByte();
               var3 = Client.serverPacketBuf.readUnsignedShort();
               ClientPreferences.method151(var1, var2, var3);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 101) {
               Canvas.method1655();
               Client.serverPacketOpcode = -1;
               return false;
            }

            if (Client.serverPacketOpcode == 253) {
               var52 = Client.serverPacketBuf.readUnsignedByteNeg() == 1;
               var2 = Client.serverPacketBuf.readUnsignedIntME();
               var70 = class130.getWidget(var2);
               if (var52 != var70.field2588) {
                  var70.field2588 = var52;
                  class82.invalidateWidget(var70);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 30) {
               var1 = Client.serverPacketBuf.readUnsignedShortAdd();
               if (var1 == 65535) {
                  var1 = -1;
               }

               Projectile.method126(var1);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 136) {
               var1 = Client.serverPacketBuf.readMedium();
               var2 = Client.serverPacketBuf.readUnsignedShortAddLE();
               if (var2 == 65535) {
                  var2 = -1;
               }

               MouseRecorder.method171(var2, var1);
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 127) {
               Client.field675 = Client.field681;
               if (Client.serverPacketLength == 0) {
                  Client.field660 = null;
                  Client.field720 = null;
                  SoundSystem.field1188 = 0;
                  ItemComposition.field1026 = null;
                  Client.serverPacketOpcode = -1;
                  return true;
               }

               Client.field720 = Client.serverPacketBuf.method2653();
               long var42 = Client.serverPacketBuf.readLong();
               var31 = var42;
               if (var42 > 0L && var42 < 6582952005840035281L) {
                  if (0L == var42 % 37L) {
                     var18 = null;
                  } else {
                     var6 = 0;

                     for(var37 = var42; var37 != 0L; var37 /= 37L) {
                        ++var6;
                     }

                     StringBuilder var25 = new StringBuilder(var6);

                     while(var31 != 0L) {
                        long var44 = var31;
                        var31 /= 37L;
                        var25.append(class145.base37Table[(int)(var44 - var31 * 37L)]);
                     }

                     var18 = var25.reverse().toString();
                  }
               } else {
                  var18 = null;
               }

               Client.field660 = var18;
               FloorUnderlayDefinition.field882 = Client.serverPacketBuf.readByte();
               var6 = Client.serverPacketBuf.readUnsignedByte();
               if (var6 == 255) {
                  Client.serverPacketOpcode = -1;
                  return true;
               }

               SoundSystem.field1188 = var6;
               class7[] var27 = new class7[100];

               for(var8 = 0; var8 < SoundSystem.field1188; ++var8) {
                  var27[var8] = new class7();
                  var27[var8].field112 = Client.serverPacketBuf.method2653();
                  var27[var8].field103 = Projectile.method125(var27[var8].field112, class5.field75);
                  var27[var8].field109 = Client.serverPacketBuf.readUnsignedShort();
                  var27[var8].field105 = Client.serverPacketBuf.readByte();
                  Client.serverPacketBuf.method2653();
                  if (var27[var8].field112.equals(Tiles.localPlayer.field35)) {
                     MusicPatch.field2354 = var27[var8].field105;
                  }
               }

               var59 = false;
               var39 = SoundSystem.field1188;

               while(var39 > 0) {
                  var59 = true;
                  --var39;

                  for(var11 = 0; var11 < var39; ++var11) {
                     if (var27[var11].field103.compareTo(var27[var11 + 1].field103) > 0) {
                        class7 var81 = var27[var11];
                        var27[var11] = var27[var11 + 1];
                        var27[var11 + 1] = var81;
                        var59 = false;
                     }
                  }

                  if (var59) {
                     break;
                  }
               }

               ItemComposition.field1026 = var27;
               Client.serverPacketOpcode = -1;
               return true;
            }

            if (Client.serverPacketOpcode == 150) {
               var1 = Client.serverPacketBuf.readUnsignedIntIME();
               var2 = Client.serverPacketBuf.readUnsignedShortAddLE();
               if (var2 == 65535) {
                  var2 = -1;
               }

               var3 = Client.serverPacketBuf.readUnsignedIntME();
               var4 = class130.getWidget(var3);
               ItemComposition var23;
               if (!var4.isIf3) {
                  if (var2 == -1) {
                     var4.modelType = 0;
                     Client.serverPacketOpcode = -1;
                     return true;
                  }

                  var23 = class27.method571(var2);
                  var4.modelType = 4;
                  var4.modelId = var2;
                  var4.modelAngleX = var23.xan2d;
                  var4.modelAngleY = var23.yan2d;
                  var4.field2679 = var23.zoom2d * 100 / var1;
                  class82.invalidateWidget(var4);
               } else {
                  var4.field2680 = var2;
                  var4.field2681 = var1;
                  var23 = class27.method571(var2);
                  var4.modelAngleX = var23.xan2d;
                  var4.modelAngleY = var23.yan2d;
                  var4.field2614 = var23.zan2d;
                  var4.field2577 = var23.offsetX2d;
                  var4.field2668 = var23.offsetY2d;
                  var4.field2679 = var23.zoom2d;
                  if (var4.width > 0) {
                     var4.field2679 = var4.field2679 * 32 / var4.width;
                  }

                  class82.invalidateWidget(var4);
               }

               Client.serverPacketOpcode = -1;
               return true;
            }

            ScriptEvent.method3("" + Client.serverPacketOpcode + "," + Client.field728 + "," + Client.field488 + "," + Client.serverPacketLength, (Throwable)null);
            Canvas.method1655();
         } catch (IOException var50) {
            Clock.method1461();
         } catch (Exception var51) {
            var28 = "" + Client.serverPacketOpcode + "," + Client.field728 + "," + Client.field488 + "," + Client.serverPacketLength + "," + (Tiles.localPlayer.hitSplatTypes2[0] + FaceNormal.baseX) + "," + (Tiles.localPlayer.hitSplatValues2[0] + Frames.baseY) + ",";

            for(var2 = 0; var2 < Client.serverPacketLength && var2 < 50; ++var2) {
               var28 = var28 + Client.serverPacketBuf.array[var2] + ",";
            }

            ScriptEvent.method3(var28, var51);
            Canvas.method1655();
         }

         return true;
      }
   }
}
