import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("BufferedFile")
public class BufferedFile {
   @ObfuscatedName("hh")
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("i")
   @Export("accessFile")
   @ObfuscatedSignature(
      descriptor = "Lclass28;"
   )
   AccessFile accessFile;
   @ObfuscatedName("w")
   @Export("readBuffer")
   byte[] readBuffer;
   @ObfuscatedName("f")
   @Export("readBufferOffset")
   long readBufferOffset = -1L;
   @ObfuscatedName("e")
   @Export("readBufferLength")
   int readBufferLength;
   @ObfuscatedName("t")
   @Export("writeBuffer")
   byte[] writeBuffer;
   @ObfuscatedName("d")
   @Export("writeBufferOffset")
   long writeBufferOffset = -1L;
   @ObfuscatedName("p")
   @Export("writeBufferLength")
   int writeBufferLength = 0;
   @ObfuscatedName("k")
   @Export("offset")
   long offset;
   @ObfuscatedName("r")
   @Export("fileLength")
   long fileLength;
   @ObfuscatedName("l")
   @Export("length")
   long length;
   @ObfuscatedName("a")
   @Export("fileOffset")
   long fileOffset;

   @ObfuscatedSignature(
      descriptor = "(Lclass28;II)V"
   )
   public BufferedFile(AccessFile var1, int var2, int var3) throws IOException {
      this.accessFile = var1;
      this.length = this.fileLength = var1.method578();
      this.readBuffer = new byte[var2];
      this.writeBuffer = new byte[var3];
      this.offset = 0L;
   }

   @ObfuscatedName("i")
   @Export("method600")
   public void method600() throws IOException {
      this.method614();
      this.accessFile.method586();
   }

   @ObfuscatedName("w")
   @Export("method601")
   public void method601(long var1) throws IOException {
      if (var1 < 0L) {
         throw new IOException("");
      } else {
         this.offset = var1;
      }
   }

   @ObfuscatedName("f")
   @Export("method602")
   public long method602() {
      return this.length;
   }

   @ObfuscatedName("e")
   @Export("method607")
   public void method607(byte[] var1) throws IOException {
      this.method604(var1, 0, var1.length);
   }

   @ObfuscatedName("t")
   @Export("method604")
   public void method604(byte[] var1, int var2, int var3) throws IOException {
      try {
         if (var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if (this.writeBufferOffset != -1L && this.offset >= this.writeBufferOffset && this.offset + (long)var3 <= this.writeBufferOffset + (long)this.writeBufferLength) {
            System.arraycopy(this.writeBuffer, (int)(this.offset - this.writeBufferOffset), var1, var2, var3);
            this.offset += (long)var3;
            return;
         }

         long var4 = this.offset;
         int var7 = var3;
         int var8;
         if (this.offset >= this.readBufferOffset && this.offset < (long)this.readBufferLength + this.readBufferOffset) {
            var8 = (int)((long)this.readBufferLength - (this.offset - this.readBufferOffset));
            if (var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readBuffer, (int)(this.offset - this.readBufferOffset), var1, var2, var8);
            this.offset += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if (var3 > this.readBuffer.length) {
            this.accessFile.method575(this.offset);

            for(this.fileOffset = this.offset; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.method584(var1, var2, var3);
               if (var8 == -1) {
                  break;
               }

               this.fileOffset += (long)var8;
               this.offset += (long)var8;
               var2 += var8;
            }
         } else if (var3 > 0) {
            this.method605();
            var8 = var3;
            if (var3 > this.readBufferLength) {
               var8 = this.readBufferLength;
            }

            System.arraycopy(this.readBuffer, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.offset += (long)var8;
         }

         if (-1L != this.writeBufferOffset) {
            if (this.writeBufferOffset > this.offset && var3 > 0) {
               var8 = var2 + (int)(this.writeBufferOffset - this.offset);
               if (var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.offset;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if (this.writeBufferOffset >= var4 && this.writeBufferOffset < (long)var7 + var4) {
               var13 = this.writeBufferOffset;
            } else if (var4 >= this.writeBufferOffset && var4 < (long)this.writeBufferLength + this.writeBufferOffset) {
               var13 = var4;
            }

            if (this.writeBufferOffset + (long)this.writeBufferLength > var4 && (long)this.writeBufferLength + this.writeBufferOffset <= var4 + (long)var7) {
               var10 = this.writeBufferOffset + (long)this.writeBufferLength;
            } else if ((long)var7 + var4 > this.writeBufferOffset && (long)var7 + var4 <= (long)this.writeBufferLength + this.writeBufferOffset) {
               var10 = (long)var7 + var4;
            }

            if (var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writeBuffer, (int)(var13 - this.writeBufferOffset), var1, (int)(var13 - var4) + var2, var12);
               if (var10 > this.offset) {
                  var3 = (int)((long)var3 - (var10 - this.offset));
                  this.offset = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.fileOffset = -1L;
         throw var16;
      }

      if (var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("d")
   @Export("method605")
   void method605() throws IOException {
      this.readBufferLength = 0;
      if (this.offset != this.fileOffset) {
         this.accessFile.method575(this.offset);
         this.fileOffset = this.offset;
      }

      int var1;
      for(this.readBufferOffset = this.offset; this.readBufferLength < this.readBuffer.length; this.readBufferLength += var1) {
         var1 = this.accessFile.method584(this.readBuffer, this.readBufferLength, this.readBuffer.length - this.readBufferLength);
         if (var1 == -1) {
            break;
         }

         this.fileOffset += (long)var1;
      }

   }

   @ObfuscatedName("p")
   @Export("method606")
   public void method606(byte[] var1, int var2, int var3) throws IOException {
      try {
         if (this.offset + (long)var3 > this.length) {
            this.length = (long)var3 + this.offset;
         }

         if (-1L != this.writeBufferOffset && (this.offset < this.writeBufferOffset || this.offset > this.writeBufferOffset + (long)this.writeBufferLength)) {
            this.method614();
         }

         if (-1L != this.writeBufferOffset && this.offset + (long)var3 > (long)this.writeBuffer.length + this.writeBufferOffset) {
            int var4 = (int)((long)this.writeBuffer.length - (this.offset - this.writeBufferOffset));
            System.arraycopy(var1, var2, this.writeBuffer, (int)(this.offset - this.writeBufferOffset), var4);
            this.offset += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.writeBufferLength = this.writeBuffer.length;
            this.method614();
         }

         if (var3 <= this.writeBuffer.length) {
            if (var3 > 0) {
               if (-1L == this.writeBufferOffset) {
                  this.writeBufferOffset = this.offset;
               }

               System.arraycopy(var1, var2, this.writeBuffer, (int)(this.offset - this.writeBufferOffset), var3);
               this.offset += (long)var3;
               if (this.offset - this.writeBufferOffset > (long)this.writeBufferLength) {
                  this.writeBufferLength = (int)(this.offset - this.writeBufferOffset);
               }

            }
         } else {
            if (this.offset != this.fileOffset) {
               this.accessFile.method575(this.offset);
               this.fileOffset = this.offset;
            }

            this.accessFile.method574(var1, var2, var3);
            this.fileOffset += (long)var3;
            if (this.fileOffset > this.fileLength) {
               this.fileLength = this.fileOffset;
            }

            long var9 = -1L;
            long var6 = -1L;
            if (this.offset >= this.readBufferOffset && this.offset < (long)this.readBufferLength + this.readBufferOffset) {
               var9 = this.offset;
            } else if (this.readBufferOffset >= this.offset && this.readBufferOffset < this.offset + (long)var3) {
               var9 = this.readBufferOffset;
            }

            if (this.offset + (long)var3 > this.readBufferOffset && (long)var3 + this.offset <= this.readBufferOffset + (long)this.readBufferLength) {
               var6 = (long)var3 + this.offset;
            } else if ((long)this.readBufferLength + this.readBufferOffset > this.offset && this.readBufferOffset + (long)this.readBufferLength <= (long)var3 + this.offset) {
               var6 = (long)this.readBufferLength + this.readBufferOffset;
            }

            if (var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.offset), this.readBuffer, (int)(var9 - this.readBufferOffset), var8);
            }

            this.offset += (long)var3;
         }
      } catch (IOException var12) {
         this.fileOffset = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("k")
   @Export("method614")
   void method614() throws IOException {
      if (-1L != this.writeBufferOffset) {
         if (this.writeBufferOffset != this.fileOffset) {
            this.accessFile.method575(this.writeBufferOffset);
            this.fileOffset = this.writeBufferOffset;
         }

         this.accessFile.method574(this.writeBuffer, 0, this.writeBufferLength);
         this.fileOffset += (long)this.writeBufferLength * 1235893383638024193L;
         if (this.fileOffset > this.fileLength) {
            this.fileLength = this.fileOffset;
         }

         long var1 = -1L;
         long var3 = -1L;
         if (this.writeBufferOffset >= this.readBufferOffset && this.writeBufferOffset < (long)this.readBufferLength + this.readBufferOffset) {
            var1 = this.writeBufferOffset;
         } else if (this.readBufferOffset >= this.writeBufferOffset && this.readBufferOffset < (long)this.writeBufferLength + this.writeBufferOffset) {
            var1 = this.readBufferOffset;
         }

         if (this.writeBufferOffset + (long)this.writeBufferLength > this.readBufferOffset && (long)this.writeBufferLength + this.writeBufferOffset <= (long)this.readBufferLength + this.readBufferOffset) {
            var3 = (long)this.writeBufferLength + this.writeBufferOffset;
         } else if ((long)this.readBufferLength + this.readBufferOffset > this.writeBufferOffset && this.readBufferOffset + (long)this.readBufferLength <= this.writeBufferOffset + (long)this.writeBufferLength) {
            var3 = (long)this.readBufferLength + this.readBufferOffset;
         }

         if (var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writeBuffer, (int)(var1 - this.writeBufferOffset), this.readBuffer, (int)(var1 - this.readBufferOffset), var5);
         }

         this.writeBufferOffset = -1L;
         this.writeBufferLength = 0;
      }

   }

   @ObfuscatedName("i")
   public static final boolean method599(String var0, String var1, String var2, String var3) {
      if (var0 != null && var2 != null) {
         return !var0.startsWith("#") && !var2.startsWith("#") ? var1.equals(var3) : var0.equals(var2);
      } else {
         return false;
      }
   }

   @ObfuscatedName("f")
   @Export("method624")
   static void method624(String var0, String var1, String var2) {
      Login.Login_response1 = var0;
      Login.Login_response2 = var1;
      Login.Login_response3 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "()Lclass67;"
   )
   static Clock method617() {
      try {
         return new NanoClock();
      } catch (Throwable var1) {
         return new MilliClock();
      }
   }

   @ObfuscatedName("ar")
   @Export("method603")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
