import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class1 {
   @ObfuscatedName("s")
   @Export("Tiles_hueMultiplier")
   static int[] Tiles_hueMultiplier;
   @ObfuscatedName("v")
   static int[] field22;
   @ObfuscatedName("al")
   @Export("worldSelectBackSprites")
   @ObfuscatedSignature(
      descriptor = "[Lclass85;"
   )
   static SpritePixels[] worldSelectBackSprites;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Ljava/lang/String;Ljava/lang/String;)Lclass85;"
   )
   public static SpritePixels method13(AbstractArchive var0, String var1, String var2) {
      int var3 = var0.method3219(var1);
      int var4 = var0.method3238(var3, var2);
      SpritePixels var5;
      if (!KitDefinition.method796(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = ClientPreferences.method152();
      }

      return var5;
   }

   @ObfuscatedName("a")
   static final int method11(int var0, int var1) {
      int var2 = class23.method253('넵' + var0, 91923 + var1, 4) - 128 + (class23.method253(10294 + var0, var1 + '鎽', 2) - 128 >> 1) + (class23.method253(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if (var2 < 10) {
         var2 = 10;
      } else if (var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("aj")
   @Export("method8")
   static final void method8(int var0, int var1, int var2) {
      if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = BufferedFile.method603(var0, var1, class22.Client_plane) - var2;
         var0 -= Login.cameraX;
         var3 -= class22.cameraY;
         var1 -= class17.cameraZ;
         int var4 = Rasterizer3D.Rasterizer3D_sine[NPC.cameraPitch];
         int var5 = Rasterizer3D.Rasterizer3D_cosine[NPC.cameraPitch];
         int var6 = Rasterizer3D.Rasterizer3D_sine[MouseRecorder.cameraYaw];
         int var7 = Rasterizer3D.Rasterizer3D_cosine[MouseRecorder.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if (var1 >= 50) {
            Client.viewportTempX = (var0 << 9) / var1 + 256;
            Client.viewportTempY = (var8 << 9) / var1 + 167;
         } else {
            Client.viewportTempX = -1;
            Client.viewportTempY = -1;
         }

      } else {
         Client.viewportTempX = -1;
         Client.viewportTempY = -1;
      }
   }

   @ObfuscatedName("br")
   @Export("method14")
   static final void method14(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.method3533(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.method3535()) {
         if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if (var9 == null) {
         var9 = new PendingSpawn();
         var9.plane = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         Client.method354(var9);
         Client.pendingSpawns.method3528(var9);
      }

      var9.id = var4;
      var9.field362 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(ILclass2;I)V"
   )
   static final void method10(int var0, Player var1, int var2) {
      if ((var2 & 4) != 0) {
         var1.field475 = Client.serverPacketBuf.readUnsignedShortLE();
         var1.field446 = Client.serverPacketBuf.readUnsignedShortLE();
      }

      if ((var2 & 512) != 0) {
         var1.field460 = Client.serverPacketBuf.method2665();
         var1.field462 = Client.serverPacketBuf.method2665();
         var1.field439 = Client.serverPacketBuf.readUnsignedByteSub();
         var1.field463 = Client.serverPacketBuf.readUnsignedByteSub();
         var1.field456 = Client.serverPacketBuf.readUnsignedShort() + Client.cycle;
         var1.field465 = Client.serverPacketBuf.method2786() + Client.cycle;
         var1.field466 = Client.serverPacketBuf.readUnsignedByteAdd();
         var1.pathLength = 1;
         var1.field472 = 0;
      }

      int var3;
      if ((var2 & 1) != 0) {
         var3 = Client.serverPacketBuf.readUnsignedByteSub();
         byte[] var4 = new byte[var3];
         Buffer var5 = new Buffer(var4);
         Client.serverPacketBuf.readBytes(var4, 0, var3);
         Client.field608[var0] = var5;
         var1.method17(var5);
      }

      int var14;
      if ((var2 & 2) != 0) {
         var3 = Client.serverPacketBuf.readUnsignedShort();
         var14 = Client.serverPacketBuf.method2665();
         int var15 = Client.serverPacketBuf.readUnsignedByteSub();
         int var6 = Client.serverPacketBuf.offset;
         if (var1.field35 != null && var1.appearance != null) {
            boolean var7 = false;
            if (var14 <= 1 && ObjectSound.method45(var1.field35)) {
               var7 = true;
            }

            if (!var7 && Client.xPadding == 0) {
               Client.field535.offset = 0;
               Client.serverPacketBuf.readBytes(Client.field535.array, 0, var15);
               Client.field535.offset = 0;
               Buffer var9 = Client.field535;

               String var10;
               try {
                  int var11 = var9.method2658();
                  if (var11 > 32767) {
                     var11 = 32767;
                  }

                  byte[] var12 = new byte[var11];
                  var9.offset += class183.huffman.method2572(var9.array, var9.offset, var12, 0, var11);
                  String var13 = InterfaceParent.method27(var12, 0, var11);
                  var10 = var13;
               } catch (Exception var17) {
                  var10 = "Cabbage";
               }

               var10 = AbstractFont.method3605(TaskHandler.method1595(var10));
               var1.field434 = var10.trim();
               var1.field436 = var3 >> 8;
               var1.field445 = var3 & 255;
               var1.field435 = 150;
               if (var14 != 2 && var14 != 3) {
                  if (var14 == 1) {
                     Login.method239(1, FloorOverlayDefinition.method829(0) + var1.field35, var10);
                  } else {
                     Login.method239(2, var1.field35, var10);
                  }
               } else {
                  Login.method239(1, FloorOverlayDefinition.method829(1) + var1.field35, var10);
               }
            }
         }

         Client.serverPacketBuf.offset = var6 + var15;
      }

      if ((var2 & 16) != 0) {
         var3 = Client.serverPacketBuf.readUnsignedShort();
         if (var3 == 65535) {
            var3 = -1;
         }

         var14 = Client.serverPacketBuf.method2665();
         SpotAnimationDefinition.method770(var1, var3, var14);
      }

      if ((var2 & 64) != 0) {
         var1.field434 = Client.serverPacketBuf.method2653();
         if (var1.field434.charAt(0) == '~') {
            var1.field434 = var1.field434.substring(1);
            Login.method239(2, var1.field35, var1.field434);
         } else if (var1 == Tiles.localPlayer) {
            Login.method239(2, var1.field35, var1.field434);
         }

         var1.field436 = 0;
         var1.field445 = 0;
         var1.field435 = 150;
      }

      if ((var2 & 8) != 0) {
         var3 = Client.serverPacketBuf.method2665();
         var14 = Client.serverPacketBuf.method2665();
         var1.method277(var3, var14, Client.cycle);
         var1.field441 = Client.cycle + 300;
         var1.field431 = Client.serverPacketBuf.readUnsignedByteNeg();
         var1.field425 = Client.serverPacketBuf.readUnsignedByteSub();
      }

      if ((var2 & 1024) != 0) {
         var1.spotAnimation = Client.serverPacketBuf.readUnsignedShortLE();
         var3 = Client.serverPacketBuf.method2650();
         var1.field430 = var3 >> 16;
         var1.field458 = (var3 & '\uffff') + Client.cycle;
         var1.spotAnimationFrame = 0;
         var1.spotAnimationFrameCycle = 0;
         if (var1.field458 > Client.cycle) {
            var1.spotAnimationFrame = -1;
         }

         if (var1.spotAnimation == 65535) {
            var1.spotAnimation = -1;
         }
      }

      if ((var2 & 256) != 0) {
         var3 = Client.serverPacketBuf.readUnsignedByteNeg();
         var14 = Client.serverPacketBuf.readUnsignedByteAdd();
         var1.method277(var3, var14, Client.cycle);
         var1.field441 = Client.cycle + 300;
         var1.field431 = Client.serverPacketBuf.readUnsignedByteNeg();
         var1.field425 = Client.serverPacketBuf.method2665();
      }

      if ((var2 & 128) != 0) {
         var1.field444 = Client.serverPacketBuf.method2677();
         if (var1.field444 == 65535) {
            var1.field444 = -1;
         }
      }

   }

   @ObfuscatedName("bv")
   static final void method9() {
      int var0 = class40.fontBold12.method3601("Choose Option");

      int var1;
      for(var1 = 0; var1 < Client.menuOptionsCount; ++var1) {
         Font var5 = class40.fontBold12;
         String var6;
         if (Client.menuTargets[var1].length() > 0) {
            var6 = Client.menuActions[var1] + " " + Client.menuTargets[var1];
         } else {
            var6 = Client.menuActions[var1];
         }

         int var4 = var5.method3601(var6);
         if (var4 > var0) {
            var0 = var4;
         }
      }

      var0 += 8;
      var1 = Client.menuOptionsCount * 15 + 21;
      int var2 = MouseHandler.MouseHandler_lastPressedX - var0 / 2;
      if (var0 + var2 > 765) {
         var2 = 765 - var0;
      }

      if (var2 < 0) {
         var2 = 0;
      }

      int var3 = MouseHandler.MouseHandler_lastPressedY;
      if (var1 + var3 > 503) {
         var3 = 503 - var1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      Client.isMenuOpen = true;
      ItemContainer.menuX = var2;
      BufferedFile.menuY = var3;
      IterableNodeHashTableIterator.menuWidth = var0;
      Decimator.menuHeight = Client.menuOptionsCount * 15 + 22;
   }

   @ObfuscatedName("dd")
   static final void method5(String var0, int var1) {
      Client.rsaBuf.writeByteOpcode(173);
      PacketBuffer var2 = Client.rsaBuf;
      int var3 = var0.length() + 1;
      var2.writeByte(var3 + 1);
      Client.rsaBuf.writeString(var0);
      Client.rsaBuf.method2667(var1);
   }
}
