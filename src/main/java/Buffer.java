import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      descriptor = "[Lclass157;"
   )
   static Widget[] field2049;
   @ObfuscatedName("d")
   @Export("crc32Table")
   static int[] crc32Table = new int[256];
   @ObfuscatedName("u")
   static int[] field2040;
   @ObfuscatedName("de")
   static byte[][] field2045;
   @ObfuscatedName("e")
   @Export("array")
   public byte[] array;
   @ObfuscatedName("t")
   @Export("offset")
   public int offset;

   static {
      for(int var1 = 0; var1 < 256; ++var1) {
         int var0 = var1;

         for(int var2 = 0; var2 < 8; ++var2) {
            if ((var0 & 1) == 1) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         crc32Table[var1] = var0;
      }

   }

   public Buffer(int var1) {
      this.array = ByteArrayPool.method2506(var1);
      this.offset = 0;
   }

   public Buffer(byte[] var1) {
      this.array = var1;
      this.offset = 0;
   }

   @ObfuscatedName("ah")
   @Export("method2631")
   public void writeByte(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("aw")
   @Export("method2778")
   public void writeShort(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("an")
   @Export("method2720")
   public void writeMedium(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("av")
   @Export("method2634")
   public void writeInt(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ak")
   @Export("method2635")
   public void writeLong(long var1) {
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.array[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.array[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("ax")
   @Export("method2636")
   public void writeStringCp1252NullTerminated(String var1) {
      int var2 = var1.indexOf(0);
      if (var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += TaskHandler.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
         this.array[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("af")
   @Export("method2637")
   public void writeStringCp1252NullCircumfixed(String var1) {
      int var2 = var1.indexOf(0);
      if (var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.array[++this.offset - 1] = 0;
         this.offset += TaskHandler.encodeStringCp1252(var1, 0, var1.length(), this.array, this.offset);
         this.array[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("ai")
   @Export("method2638")
   public void writeCESU8(CharSequence var1) {
      int var3 = var1.length();
      int var4 = 0;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         char var12 = var1.charAt(var5);
         if (var12 <= 127) {
            ++var4;
         } else if (var12 <= 2047) {
            var4 += 2;
         } else {
            var4 += 3;
         }
      }

      this.array[++this.offset - 1] = 0;
      this.writeVarInt(var4);
      var4 = this.offset * 565881095;
      byte[] var6 = this.array;
      int var7 = this.offset;
      int var8 = var1.length();
      int var9 = var7;

      for(int var10 = 0; var10 < var8; ++var10) {
         char var11 = var1.charAt(var10);
         if (var11 <= 127) {
            var6[var9++] = (byte)var11;
         } else if (var11 <= 2047) {
            var6[var9++] = (byte)(192 | var11 >> 6);
            var6[var9++] = (byte)(128 | var11 & 63);
         } else {
            var6[var9++] = (byte)(224 | var11 >> 12);
            var6[var9++] = (byte)(128 | var11 >> 6 & 63);
            var6[var9++] = (byte)(128 | var11 & 63);
         }
      }

      var5 = var9 - var7;
      this.offset = (var4 + var5 * 565881095) * -1128893257;
   }

   @ObfuscatedName("at")
   @Export("method2802")
   public void writeBytes(byte[] data, int start, int length) {
      for(int i = start; i < length + start; ++i) {
         this.array[++this.offset - 1] = data[i];
      }

   }

   @ObfuscatedName("aq")
   @Export("method2748")
   public void writeLengthInt(int var1) {
      this.array[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.array[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.array[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.array[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ac")
   public void writeLengthShort(int var1) {
      this.array[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.array[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("al")
   public void writeLengthByte(int var1) {
      this.array[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ag")
   @Export("method2643")
   public void writeSmartByteShort(int var1) {
      if (var1 >= 0 && var1 < 128) {
         this.writeByte(var1);
      } else if (var1 >= 0 && var1 < 32768) {
         this.writeShort(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ap")
   @Export("method2644")
   public void writeVarInt(int var1) {
      if ((var1 & -128) != 0) {
         if ((var1 & -16384) != 0) {
            if ((var1 & -2097152) != 0) {
               if ((var1 & -268435456) != 0) {
                  this.writeByte(var1 >>> 28 | 128);
               }

               this.writeByte(var1 >>> 21 | 128);
            }

            this.writeByte(var1 >>> 14 | 128);
         }

         this.writeByte(var1 >>> 7 | 128);
      }

      this.writeByte(var1 & 127);
   }

   @ObfuscatedName("am")
   @Export("method2665")
   public int readUnsignedByte() {
      return this.array[++this.offset - 1] & 255;
   }

   @ObfuscatedName("as")
   @Export("method2646")
   public byte readByte() {
      return this.array[++this.offset - 1];
   }

   @ObfuscatedName("aj")
   @Export("method2808")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ar")
   @Export("method2648")
   public int readShort() {
      this.offset += 2;
      int var1 = (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
      if (var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("au")
   @Export("method2801")
   public int readMedium() {
      this.offset += 3;
      return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ad")
   @Export("method2650")
   public int readInt() {
      this.offset += 4;
      return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 24);
   }

   @ObfuscatedName("az")
   @Export("method2757")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("ay")
   @Export("method2784")
   public String method2784() {
      if (this.array[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method2653();
      }
   }

   @ObfuscatedName("bh")
   @Export("method2653")
   public String method2653() {
      int var1 = this.offset;

      while(this.array[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0 ? "" : InterfaceParent.method27(this.array, var1, var2);
   }

   @ObfuscatedName("ba")
   @Export("method2731")
   public String method2731() {
      byte var1 = this.array[++this.offset - 1];
      if (var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.array[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0 ? "" : InterfaceParent.method27(this.array, var2, var3);
      }
   }

   @ObfuscatedName("bn")
   @Export("method2655")
   public String method2655() {
      byte var1 = this.array[++this.offset - 1];
      if (var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2660();
         if (var2 + this.offset > this.array.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = ByteArrayPool.method2508(this.array, this.offset, var2);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("bj")
   @Export("method2656")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.array[++this.offset - 1];
      }

   }

   @ObfuscatedName("bu")
   @Export("method2657")
   public int method2657() {
      int var1 = this.array[this.offset] & 255;
      return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - '쀀';
   }

   @ObfuscatedName("br")
   @Export("method2658")
   public int method2658() {
      int var1 = this.array[this.offset] & 255;
      return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("bd")
   public int method2680() {
      return this.array[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort();
   }

   @ObfuscatedName("bf")
   @Export("method2660")
   public int method2660() {
      byte var1 = this.array[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.array[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("bg")
   @Export("method2777")
   public void encryptXtea(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.offset -= 8;
         this.writeInt(var7);
         this.writeInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("bp")
   @Export("method2662")
   public void method2662(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.writeInt(var7);
         this.writeInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("bb")
   @Export("method2712")
   public void encryptRSA(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.readBytes(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.writeShort(var7.length);
      this.writeBytes(var7, 0, var7.length);
   }

   @ObfuscatedName("bc")
   @Export("method2664")
   public int method2664(int var1) {
      int var2 = class40.method913(this.array, var1, this.offset);
      this.writeInt(var2);
      return var2;
   }

   @ObfuscatedName("by")
   @Export("method2679")
   public boolean method2679() {
      this.offset -= 4;
      int var1 = class40.method913(this.array, 0, this.offset);
      int var2 = this.readInt();
      return var2 == var1;
   }

   @ObfuscatedName("bw")
   public void method2645(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bm")
   public void method2667(int var1) {
      this.array[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("bz")
   public int readUnsignedByteAdd() {
      return this.array[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("bv")
   public int readUnsignedByteNeg() {
      return 0 - this.array[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bq")
   public int readUnsignedByteSub() {
      return 128 - this.array[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bk")
   public byte readByteAdd() {
      return (byte)(this.array[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bo")
   public byte readByteSub() {
      return (byte)(128 - this.array[++this.offset - 1]);
   }

   @ObfuscatedName("bs")
   public void writeShortLE(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bx")
   public void writeShortAdd(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bl")
   public void writeShortAddLE(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 + 128);
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("be")
   public int readUnsignedShortLE() {
      this.offset += 2;
      return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
   }

   @ObfuscatedName("bi")
   public int readUnsignedShortAdd() {
      this.offset += 2;
      return (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bt")
   public int readUnsignedShortAddLE() {
      this.offset += 2;
      return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("cd")
   public int readShortAdd() {
      this.offset += 2;
      int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255);
      if (var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ca")
   public int readShortAddLE() {
      this.offset += 2;
      int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255);
      if (var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ck")
   public void method2675(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("cq")
   public void writeIntLE(int var1) {
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("cg")
   public void writeIntIME(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("ct")
   public void writeIntME(int var1) {
      this.array[++this.offset - 1] = (byte)(var1 >> 16);
      this.array[++this.offset - 1] = (byte)(var1 >> 24);
      this.array[++this.offset - 1] = (byte)var1;
      this.array[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("cc")
   public int readUnsignedIntLE() {
      this.offset += 4;
      return (this.array[this.offset - 4] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16) + ((this.array[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("cx")
   public int readUnsignedIntIME() {
      this.offset += 4;
      return ((this.array[this.offset - 2] & 255) << 24) + ((this.array[this.offset - 4] & 255) << 8) + (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("cu")
   public int readUnsignedIntME() {
      this.offset += 4;
      return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 16) + (this.array[this.offset - 2] & 255) + ((this.array[this.offset - 3] & 255) << 24);
   }

   @ObfuscatedName("i")
   public static char method2810(char var0, int var1) {
      if (var0 >= 192 && var0 <= 255) {
         if (var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if (var0 == 199) {
            return 'C';
         }

         if (var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if (var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if (var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if (var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if (var0 == 221) {
            return 'Y';
         }

         if (var0 == 223) {
            return 's';
         }

         if (var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if (var0 == 231) {
            return 'c';
         }

         if (var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if (var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if (var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if (var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if (var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if (var0 == 338) {
         return 'O';
      } else if (var0 == 339) {
         return 'o';
      } else if (var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("d")
   public static boolean method2811(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
