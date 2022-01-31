import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("IterableNodeHashTableIterator")
public final class IterableNodeHashTableIterator implements Runnable {
   @ObfuscatedName("hc")
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("i")
   OutputStream field1281;
   @ObfuscatedName("w")
   InputStream field1292;
   @ObfuscatedName("f")
   Socket field1282;
   @ObfuscatedName("e")
   boolean field1291 = false;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "Lclass73;"
   )
   TaskHandler field1284;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "Lclass78;"
   )
   Task field1280;
   @ObfuscatedName("p")
   byte[] field1286;
   @ObfuscatedName("k")
   int field1287 = 0;
   @ObfuscatedName("r")
   int field1288 = 0;
   @ObfuscatedName("l")
   boolean field1289 = false;

   @ObfuscatedSignature(
      descriptor = "(Ljava/net/Socket;Lclass73;)V"
   )
   public IterableNodeHashTableIterator(Socket var1, TaskHandler var2) throws IOException {
      this.field1284 = var2;
      this.field1282 = var1;
      this.field1282.setSoTimeout(30000);
      this.field1282.setTcpNoDelay(true);
      this.field1292 = this.field1282.getInputStream();
      this.field1281 = this.field1282.getOutputStream();
   }

   @ObfuscatedName("e")
   public void method1471() {
      if (!this.field1291) {
         synchronized(this) {
            this.field1291 = true;
            this.notifyAll();
         }

         if (this.field1280 != null) {
            while(this.field1280.status == 0) {
               SequenceDefinition.method761(1L);
            }

            if (this.field1280.status == 1) {
               try {
                  ((Thread)this.field1280.result).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1280 = null;
      }
   }

   @ObfuscatedName("t")
   public int readByte() throws IOException {
      return this.field1291 ? 0 : this.field1292.read();
   }

   @ObfuscatedName("d")
   public int method1473() throws IOException {
      return this.field1291 ? 0 : this.field1292.available();
   }

   @ObfuscatedName("p")
   public void method1496(byte[] var1, int var2, int var3) throws IOException {
      if (!this.field1291) {
         while(var3 > 0) {
            int var4 = this.field1292.read(var1, var2, var3);
            if (var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("k")
   public void flush(byte[] var1, int var2, int var3) throws IOException {
      if (!this.field1291) {
         if (this.field1289) {
            this.field1289 = false;
            throw new IOException();
         } else {
            if (this.field1286 == null) {
               this.field1286 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1286[this.field1288] = var1[var5 + var2];
                  this.field1288 = (this.field1288 + 1) % 5000;
                  if ((this.field1287 + 4900) % 5000 == this.field1288) {
                     throw new IOException();
                  }
               }

               if (this.field1280 == null) {
                  this.field1280 = this.field1284.method1599(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if (this.field1288 == this.field1287) {
                     if (this.field1291) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1287;
                  if (this.field1288 >= this.field1287) {
                     var1 = this.field1288 - this.field1287;
                  } else {
                     var1 = 5000 - this.field1287;
                  }
               }

               if (var1 <= 0) {
                  continue;
               }

               try {
                  this.field1281.write(this.field1286, var2, var1);
               } catch (IOException var9) {
                  this.field1289 = true;
               }

               this.field1287 = (var1 + this.field1287) % 5000;

               try {
                  if (this.field1287 == this.field1288) {
                     this.field1281.flush();
                  }
               } catch (IOException var8) {
                  this.field1289 = true;
               }
               continue;
            }

            try {
               if (this.field1292 != null) {
                  this.field1292.close();
               }

               if (this.field1281 != null) {
                  this.field1281.close();
               }

               if (this.field1282 != null) {
                  this.field1282.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1286 = null;
            break;
         }
      } catch (Exception var12) {
         ScriptEvent.method3((String)null, var12);
      }

   }

   protected void finalize() {
      this.method1471();
   }

   @ObfuscatedName("w")
   static final void method1485(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               Tiles.field132[0][var5][var4] = 127;
               if (var0 == var5 && var5 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
               }

               if (var0 + var2 == var5 && var5 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
               }

               if (var4 == var1 && var4 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
               }

               if (var3 + var1 == var4 && var4 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("bu")
   static final void method1498() {
      int var0;
      int var2;
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      if (Client.field523 == 220) {
         var0 = Client.field521.method2786();
         byte var1 = Client.field521.method2646();
         var2 = Client.field521.method2665();
         var3 = (var2 >> 4 & 7) + Actor.field478;
         var4 = (var2 & 7) + GraphicsObject.field307;
         byte var5 = Client.field521.method2671();
         byte var6 = Client.field521.method2646();
         var7 = Client.field521.method2676();
         var8 = Client.field521.method2668();
         var9 = var8 >> 2;
         var10 = var8 & 3;
         var11 = Client.field541[var9];
         byte var12 = Client.field521.method2671();
         int var13 = Client.field521.method2808();
         int var14 = Client.field521.method2677();
         Player var15;
         if (var7 == Client.field617) {
            var15 = Tiles.localPlayer;
         } else {
            var15 = Client.players[var7];
         }

         if (var15 != null) {
            ObjectComposition var16 = GameBuild.method2853(var13);
            int var17;
            int var18;
            if (var10 != 1 && var10 != 3) {
               var17 = var16.sizeX;
               var18 = var16.sizeY;
            } else {
               var17 = var16.sizeY;
               var18 = var16.sizeX;
            }

            int var19 = var3 + (var17 >> 1);
            int var20 = var3 + (var17 + 1 >> 1);
            int var21 = var4 + (var18 >> 1);
            int var22 = var4 + (var18 + 1 >> 1);
            int[][] var23 = Tiles.Tiles_heights[class22.Client_plane];
            int var24 = var23[var20][var22] + var23[var19][var22] + var23[var20][var21] + var23[var19][var21] >> 2;
            int var25 = (var3 << 7) + (var17 << 6);
            int var26 = (var4 << 7) + (var18 << 6);
            Model var27 = var16.method664(var9, var10, var23, var25, var24, var26);
            if (var27 != null) {
               class1.method14(class22.Client_plane, var3, var4, var11, -1, 0, 0, var14 + 1, var0 + 1);
               var15.animationCycleStart = var14 + Client.cycle;
               var15.animationCycleEnd = var0 + Client.cycle;
               var15.model0 = var27;
               var15.field34 = var17 * 64 + var3 * 128;
               var15.field42 = var18 * 64 + var4 * 128;
               var15.tileHeight2 = var24;
               byte var28;
               if (var5 > var1) {
                  var28 = var5;
                  var5 = var1;
                  var1 = var28;
               }

               if (var6 > var12) {
                  var28 = var6;
                  var6 = var12;
                  var12 = var28;
               }

               var15.field44 = var3 + var5;
               var15.field46 = var3 + var1;
               var15.field38 = var6 + var4;
               var15.field47 = var12 + var4;
            }
         }
      }

      int var35;
      int var36;
      int var37;
      if (Client.field523 == 182) {
         var0 = Client.field521.method2677();
         var35 = Client.field521.method2670();
         var2 = var35 >> 2;
         var3 = var35 & 3;
         var4 = Client.field541[var2];
         var36 = Client.field521.method2668();
         var37 = (var36 >> 4 & 7) + Actor.field478;
         var7 = (var36 & 7) + GraphicsObject.field307;
         if (var37 >= 0 && var7 >= 0 && var37 < 103 && var7 < 103) {
            if (var4 == 0) {
               BoundaryObject var34 = Interpreter.scene.method2170(class22.Client_plane, var37, var7);
               if (var34 != null) {
                  var9 = var34.field1612 >> 14 & 32767;
                  if (var2 == 2) {
                     var34.renderable1 = new DynamicObject(var9, 2, var3 + 4, class22.Client_plane, var37, var7, var0, false, var34.renderable1);
                     var34.renderable2 = new DynamicObject(var9, 2, var3 + 1 & 3, class22.Client_plane, var37, var7, var0, false, var34.renderable2);
                  } else {
                     var34.renderable1 = new DynamicObject(var9, var2, var3, class22.Client_plane, var37, var7, var0, false, var34.renderable1);
                  }
               }
            }

            if (var4 == 1) {
               WallDecoration var41 = Interpreter.scene.method2064(class22.Client_plane, var37, var7);
               if (var41 != null) {
                  var9 = var41.field1817 >> 14 & 32767;
                  if (var2 != 4 && var2 != 5) {
                     if (var2 == 6) {
                        var41.field1815 = new DynamicObject(var9, 4, var3 + 4, class22.Client_plane, var37, var7, var0, false, var41.field1815);
                     } else if (var2 == 7) {
                        var41.field1815 = new DynamicObject(var9, 4, (var3 + 2 & 3) + 4, class22.Client_plane, var37, var7, var0, false, var41.field1815);
                     } else if (var2 == 8) {
                        var41.field1815 = new DynamicObject(var9, 4, var3 + 4, class22.Client_plane, var37, var7, var0, false, var41.field1815);
                        var41.renderable2 = new DynamicObject(var9, 4, (var3 + 2 & 3) + 4, class22.Client_plane, var37, var7, var0, false, var41.renderable2);
                     }
                  } else {
                     var41.field1815 = new DynamicObject(var9, 4, var3, class22.Client_plane, var37, var7, var0, false, var41.field1815);
                  }
               }
            }

            if (var4 == 2) {
               GameObject var42 = Interpreter.scene.method2196(class22.Client_plane, var37, var7);
               if (var2 == 11) {
                  var2 = 10;
               }

               if (var42 != null) {
                  var42.renderable = new DynamicObject(var42.field1656 >> 14 & 32767, var2, var3, class22.Client_plane, var37, var7, var0, false, var42.renderable);
               }
            }

            if (var4 == 3) {
               FloorDecoration var43 = Interpreter.scene.method2066(class22.Client_plane, var37, var7);
               if (var43 != null) {
                  var43.renderable = new DynamicObject(var43.field1807 >> 14 & 32767, 22, var3, class22.Client_plane, var37, var7, var0, false, var43.renderable);
               }
            }
         }

      } else if (Client.field523 == 64) {
         var0 = Client.field521.method2668();
         var35 = (var0 >> 4 & 7) + Actor.field478;
         var2 = (var0 & 7) + GraphicsObject.field307;
         var3 = Client.field521.method2786();
         var4 = Client.field521.method2676();
         var36 = Client.field521.method2786();
         if (var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104 && var3 != Client.field617) {
            TileItem var40 = new TileItem();
            var40.id = var36;
            var40.quantity = var4;
            if (Client.groundItems[class22.Client_plane][var35][var2] == null) {
               Client.groundItems[class22.Client_plane][var35][var2] = new NodeDeque();
            }

            Client.groundItems[class22.Client_plane][var35][var2].method3528(var40);
            GameObject.method2205(var35, var2);
         }

      } else {
         TileItem var32;
         if (Client.field523 == 89) {
            var0 = Client.field521.method2786();
            var35 = Client.field521.method2665();
            var2 = (var35 >> 4 & 7) + Actor.field478;
            var3 = (var35 & 7) + GraphicsObject.field307;
            if (var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               NodeDeque var33 = Client.groundItems[class22.Client_plane][var2][var3];
               if (var33 != null) {
                  for(var32 = (TileItem)var33.method3533(); var32 != null; var32 = (TileItem)var33.method3535()) {
                     if ((var0 & 32767) == var32.id) {
                        var32.method3567();
                        break;
                     }
                  }

                  if (var33.method3533() == null) {
                     Client.groundItems[class22.Client_plane][var2][var3] = null;
                  }

                  GameObject.method2205(var2, var3);
               }
            }

         } else {
            if (Client.field523 == 111) {
               var0 = Client.field521.method2665();
               var35 = (var0 >> 4 & 7) + Actor.field478;
               var2 = (var0 & 7) + GraphicsObject.field307;
               var3 = Client.field521.method2808();
               var4 = Client.field521.method2665();
               var36 = var4 >> 4 & 15;
               var37 = var4 & 7;
               var7 = Client.field521.method2665();
               if (var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
                  var8 = var36 + 1;
                  if (Tiles.localPlayer.hitSplatTypes2[0] >= var35 - var8 && Tiles.localPlayer.hitSplatTypes2[0] <= var8 + var35 && Tiles.localPlayer.hitSplatValues2[0] >= var2 - var8 && Tiles.localPlayer.hitSplatValues2[0] <= var2 + var8 && Client.field538 != 0 && var37 > 0 && Client.soundEffectCount < 50) {
                     Client.field742[Client.soundEffectCount] = var3;
                     Client.field726[Client.soundEffectCount] = var37;
                     Client.field727[Client.soundEffectCount] = var7;
                     Client.field729[Client.soundEffectCount] = null;
                     Client.field589[Client.soundEffectCount] = var36 + (var2 << 8) + (var35 << 16);
                     ++Client.soundEffectCount;
                  }
               }
            }

            if (Client.field523 == 70) {
               var0 = Client.field521.method2677();
               var35 = Client.field521.method2668();
               var2 = (var35 >> 4 & 7) + Actor.field478;
               var3 = (var35 & 7) + GraphicsObject.field307;
               var4 = Client.field521.method2808();
               if (var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  var32 = new TileItem();
                  var32.id = var4;
                  var32.quantity = var0;
                  if (Client.groundItems[class22.Client_plane][var2][var3] == null) {
                     Client.groundItems[class22.Client_plane][var2][var3] = new NodeDeque();
                  }

                  Client.groundItems[class22.Client_plane][var2][var3].method3528(var32);
                  GameObject.method2205(var2, var3);
               }

            } else if (Client.field523 != 103) {
               if (Client.field523 == 65) {
                  var0 = Client.field521.method2668();
                  var35 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field541[var35];
                  var4 = Client.field521.method2665();
                  var36 = (var4 >> 4 & 7) + Actor.field478;
                  var37 = (var4 & 7) + GraphicsObject.field307;
                  var7 = Client.field521.method2676();
                  if (var36 >= 0 && var37 >= 0 && var36 < 104 && var37 < 104) {
                     class1.method14(class22.Client_plane, var36, var37, var3, var7, var35, var2, 0, -1);
                  }

               } else if (Client.field523 == 13) {
                  var0 = Client.field521.method2668();
                  var35 = (var0 >> 4 & 7) + Actor.field478;
                  var2 = (var0 & 7) + GraphicsObject.field307;
                  var3 = Client.field521.method2668();
                  var4 = var3 >> 2;
                  var36 = var3 & 3;
                  var37 = Client.field541[var4];
                  if (var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
                     class1.method14(class22.Client_plane, var35, var2, var37, -1, var4, var36, 0, -1);
                  }

               } else if (Client.field523 == 238) {
                  var0 = Client.field521.method2665();
                  var35 = (var0 >> 4 & 7) + Actor.field478;
                  var2 = (var0 & 7) + GraphicsObject.field307;
                  var3 = var35 + Client.field521.method2646();
                  var4 = var2 + Client.field521.method2646();
                  var36 = Client.field521.method2648();
                  var37 = Client.field521.method2808();
                  var7 = Client.field521.method2665() * 4;
                  var8 = Client.field521.method2665() * 4;
                  var9 = Client.field521.method2808();
                  var10 = Client.field521.method2808();
                  var11 = Client.field521.method2665();
                  int var38 = Client.field521.method2665();
                  if (var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var37 != 65535) {
                     var35 = var35 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     var3 = var3 * 128 + 64;
                     var4 = var4 * 128 + 64;
                     Projectile var30 = new Projectile(var37, class22.Client_plane, var35, var2, BufferedFile.method603(var35, var2, class22.Client_plane) - var7, var9 + Client.cycle, var10 + Client.cycle, var11, var38, var36, var8);
                     var30.method114(var3, var4, BufferedFile.method603(var3, var4, class22.Client_plane) - var8, var9 + Client.cycle);
                     Client.field619.method3528(var30);
                  }

               } else if (Client.field523 == 41) {
                  var0 = Client.field521.method2665();
                  var35 = (var0 >> 4 & 7) + Actor.field478;
                  var2 = (var0 & 7) + GraphicsObject.field307;
                  var3 = Client.field521.method2808();
                  var4 = Client.field521.method2665();
                  var36 = Client.field521.method2808();
                  if (var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
                     var35 = var35 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     GraphicsObject var39 = new GraphicsObject(var3, class22.Client_plane, var35, var2, BufferedFile.method603(var35, var2, class22.Client_plane) - var4, var36, Client.cycle);
                     Client.field620.method3528(var39);
                  }

               }
            } else {
               var0 = Client.field521.method2665();
               var35 = (var0 >> 4 & 7) + Actor.field478;
               var2 = (var0 & 7) + GraphicsObject.field307;
               var3 = Client.field521.method2808();
               var4 = Client.field521.method2808();
               var36 = Client.field521.method2808();
               if (var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
                  NodeDeque var29 = Client.groundItems[class22.Client_plane][var35][var2];
                  if (var29 != null) {
                     for(TileItem var31 = (TileItem)var29.method3533(); var31 != null; var31 = (TileItem)var29.method3535()) {
                        if ((var3 & 32767) == var31.id && var4 == var31.quantity) {
                           var31.quantity = var36;
                           break;
                        }
                     }

                     GameObject.method2205(var35, var2);
                  }
               }

            }
         }
      }
   }
}
