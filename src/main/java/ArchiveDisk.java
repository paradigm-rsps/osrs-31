import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("ArchiveDisk")
public final class ArchiveDisk {
   @ObfuscatedName("w")
   @Export("ArchiveDisk_buffer")
   static byte[] ArchiveDisk_buffer = new byte[520];
   @ObfuscatedName("i")
   @Export("archive")
   int archive;
   @ObfuscatedName("f")
   @Export("datFile")
   @ObfuscatedSignature(
      descriptor = "Lclass29;"
   )
   BufferedFile datFile = null;
   @ObfuscatedName("e")
   @Export("idxFile")
   @ObfuscatedSignature(
      descriptor = "Lclass29;"
   )
   BufferedFile idxFile = null;
   @ObfuscatedName("t")
   @Export("maxEntrySize")
   int maxEntrySize = 65000;

   @ObfuscatedSignature(
      descriptor = "(ILclass29;Lclass29;I)V"
   )
   public ArchiveDisk(int var1, BufferedFile var2, BufferedFile var3, int var4) {
      this.archive = var1;
      this.datFile = var2;
      this.idxFile = var3;
      this.maxEntrySize = var4;
   }

   @ObfuscatedName("i")
   @Export("method1500")
   public byte[] method1500(int var1) {
      BufferedFile var2 = this.datFile;
      synchronized(this.datFile) {
         try {
            Object var10000;
            if (this.idxFile.method602() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.idxFile.method601((long)(var1 * 6));
               this.idxFile.method604(ArchiveDisk_buffer, 0, 6);
               int var3 = ((ArchiveDisk_buffer[0] & 255) << 16) + (ArchiveDisk_buffer[2] & 255) + ((ArchiveDisk_buffer[1] & 255) << 8);
               int var4 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
               if (var3 < 0 || var3 > this.maxEntrySize) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if (var4 <= 0 || (long)var4 > this.datFile.method602() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;

                  for(int var7 = 0; var6 < var3; ++var7) {
                     if (var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.datFile.method601((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if (var8 > 512) {
                        var8 = 512;
                     }

                     this.datFile.method604(ArchiveDisk_buffer, 0, var8 + 8);
                     int var9 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
                     int var10 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                     int var11 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
                     int var12 = ArchiveDisk_buffer[7] & 255;
                     if (var9 != var1 || var7 != var10 || var12 != this.archive) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     if (var11 < 0 || (long)var11 > this.datFile.method602() / 520L) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     for(int var13 = 0; var13 < var8; ++var13) {
                        var5[var6++] = ArchiveDisk_buffer[var13 + 8];
                     }

                     var4 = var11;
                  }

                  byte[] var18 = var5;
                  return var18;
               }
            }
         } catch (IOException var16) {
            return null;
         }
      }
   }

   @ObfuscatedName("w")
   @Export("method1501")
   public boolean method1501(int var1, byte[] var2, int var3) {
      BufferedFile var4 = this.datFile;
      synchronized(this.datFile) {
         if (var3 >= 0 && var3 <= this.maxEntrySize) {
            boolean var5 = this.method1502(var1, var2, var3, true);
            if (!var5) {
               var5 = this.method1502(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("f")
   @Export("method1502")
   boolean method1502(int var1, byte[] var2, int var3, boolean var4) {
      BufferedFile var5 = this.datFile;
      synchronized(this.datFile) {
         try {
            int var6;
            boolean var10000;
            if (var4) {
               if (this.idxFile.method602() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.idxFile.method601((long)(var1 * 6));
               this.idxFile.method604(ArchiveDisk_buffer, 0, 6);
               var6 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
               if (var6 <= 0 || (long)var6 > this.datFile.method602() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.datFile.method602() + 519L) / 520L);
               if (var6 == 0) {
                  var6 = 1;
               }
            }

            ArchiveDisk_buffer[0] = (byte)(var3 >> 16);
            ArchiveDisk_buffer[1] = (byte)(var3 >> 8);
            ArchiveDisk_buffer[2] = (byte)var3;
            ArchiveDisk_buffer[3] = (byte)(var6 >> 16);
            ArchiveDisk_buffer[4] = (byte)(var6 >> 8);
            ArchiveDisk_buffer[5] = (byte)var6;
            this.idxFile.method601((long)(var1 * 6));
            this.idxFile.method606(ArchiveDisk_buffer, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if (var7 < var3) {
                  label140: {
                     int var9 = 0;
                     int var14;
                     if (var4) {
                        this.datFile.method601((long)(var6 * 520));

                        try {
                           this.datFile.method604(ArchiveDisk_buffer, 0, 8);
                        } catch (EOFException var16) {
                           break label140;
                        }

                        var14 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
                        int var11 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                        var9 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
                        int var12 = ArchiveDisk_buffer[7] & 255;
                        if (var14 != var1 || var11 != var8 || var12 != this.archive) {
                           var10000 = false;
                           return var10000;
                        }

                        if (var9 < 0 || (long)var9 > this.datFile.method602() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if (var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.datFile.method602() + 519L) / 520L);
                        if (var9 == 0) {
                           ++var9;
                        }

                        if (var9 == var6) {
                           ++var9;
                        }
                     }

                     if (var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     ArchiveDisk_buffer[0] = (byte)(var1 >> 8);
                     ArchiveDisk_buffer[1] = (byte)var1;
                     ArchiveDisk_buffer[2] = (byte)(var8 >> 8);
                     ArchiveDisk_buffer[3] = (byte)var8;
                     ArchiveDisk_buffer[4] = (byte)(var9 >> 16);
                     ArchiveDisk_buffer[5] = (byte)(var9 >> 8);
                     ArchiveDisk_buffer[6] = (byte)var9;
                     ArchiveDisk_buffer[7] = (byte)this.archive;
                     this.datFile.method601((long)(var6 * 520));
                     this.datFile.method606(ArchiveDisk_buffer, 0, 8);
                     var14 = var3 - var7;
                     if (var14 > 512) {
                        var14 = 512;
                     }

                     this.datFile.method606(var2, var7, var14);
                     var7 += var14;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "()[Lclass86;"
   )
   static IndexedSprite[] method1512() {
      IndexedSprite[] var0 = new IndexedSprite[class83.SpriteBuffer_spriteCount];

      for(int var1 = 0; var1 < class83.SpriteBuffer_spriteCount; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class83.SpriteBuffer_spriteWidth;
         var2.height = class83.SpriteBuffer_spriteHeight;
         var2.xOffset = class83.SpriteBuffer_xOffsets[var1];
         var2.yOffset = class165.SpriteBuffer_yOffsets[var1];
         var2.subWidth = class112.SpriteBuffer_spriteWidths[var1];
         var2.subHeight = class83.SpriteBuffer_spriteHeights[var1];
         var2.palette = FloorUnderlayDefinition.SpriteBuffer_spritePalette;
         var2.pixels = class145.SpriteBuffer_pixels[var1];
      }

      FileSystem.method1515();
      return var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;I)Z"
   )
   static boolean method1504(AbstractArchive var0, int var1) {
      byte[] var2 = var0.method3209(var1);
      if (var2 == null) {
         return false;
      } else {
         PendingSpawn.method245(var2);
         return true;
      }
   }

   @ObfuscatedName("bs")
   @Export("method1503")
   static final void method1503(String var0, String var1, int var2, int var3, int var4, int var5) {
      if (!Client.isMenuOpen) {
         if (Client.menuOptionsCount < 500) {
            Client.menuActions[Client.menuOptionsCount] = var0;
            Client.menuTargets[Client.menuOptionsCount] = var1;
            Client.menuOpcodes[Client.menuOptionsCount] = var2;
            Client.menuIdentifiers[Client.menuOptionsCount] = var3;
            Client.menuArguments1[Client.menuOptionsCount] = var4;
            Client.menuArguments2[Client.menuOptionsCount] = var5;
            ++Client.menuOptionsCount;
         }

      }
   }
}
