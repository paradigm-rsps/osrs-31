import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("MidiFileReader")
public class MidiFileReader {
   @ObfuscatedName("l")
   static final byte[] field2411 = new byte[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   @ObfuscatedName("i")
   @Export("buffer")
   @ObfuscatedSignature(
      descriptor = "Lclass126;"
   )
   Buffer buffer = new Buffer((byte[])null);
   @ObfuscatedName("w")
   @Export("division")
   int division;
   @ObfuscatedName("f")
   @Export("trackStarts")
   int[] trackStarts;
   @ObfuscatedName("e")
   @Export("trackPositions")
   int[] trackPositions;
   @ObfuscatedName("t")
   @Export("trackLengths")
   int[] trackLengths;
   @ObfuscatedName("d")
   int[] field2417;
   @ObfuscatedName("p")
   int field2414;
   @ObfuscatedName("r")
   long field2421;

   MidiFileReader(byte[] var1) {
      this.method3111(var1);
   }

   MidiFileReader() {
   }

   @ObfuscatedName("i")
   @Export("method3111")
   void method3111(byte[] var1) {
      this.buffer.array = var1;
      this.buffer.offset = 10;
      int var2 = this.buffer.readUnsignedShort();
      this.division = this.buffer.readUnsignedShort();
      this.field2414 = 500000;
      this.trackStarts = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.buffer.offset += var5) {
         int var4 = this.buffer.readInt();
         var5 = this.buffer.readInt();
         if (var4 == 1297379947) {
            this.trackStarts[var3] = this.buffer.offset;
            ++var3;
         }
      }

      this.field2421 = 0L;
      this.trackPositions = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.trackPositions[var3] = this.trackStarts[var3];
      }

      this.trackLengths = new int[var2];
      this.field2417 = new int[var2];
   }

   @ObfuscatedName("w")
   @Export("method3067")
   void method3067() {
      this.buffer.array = null;
      this.trackStarts = null;
      this.trackPositions = null;
      this.trackLengths = null;
      this.field2417 = null;
   }

   @ObfuscatedName("f")
   @Export("method3066")
   boolean method3066() {
      return this.buffer.array != null;
   }

   @ObfuscatedName("e")
   @Export("method3068")
   int method3068() {
      return this.trackPositions.length;
   }

   @ObfuscatedName("t")
   @Export("method3070")
   void method3070(int var1) {
      this.buffer.offset = this.trackPositions[var1];
   }

   @ObfuscatedName("d")
   @Export("method3071")
   void method3071(int var1) {
      this.trackPositions[var1] = this.buffer.offset;
   }

   @ObfuscatedName("p")
   @Export("method3083")
   void method3083() {
      this.buffer.offset = -1;
   }

   @ObfuscatedName("k")
   @Export("method3073")
   void method3073(int var1) {
      int var2 = this.buffer.method2660();
      this.trackLengths[var1] += var2;
   }

   @ObfuscatedName("r")
   @Export("method3074")
   int method3074(int var1) {
      int var2 = this.method3075(var1);
      return var2;
   }

   @ObfuscatedName("l")
   @Export("method3075")
   int method3075(int var1) {
      byte var2 = this.buffer.array[this.buffer.offset];
      int var5;
      if (var2 < 0) {
         var5 = var2 & 255;
         this.field2417[var1] = var5;
         ++this.buffer.offset;
      } else {
         var5 = this.field2417[var1];
      }

      if (var5 != 240 && var5 != 247) {
         return this.method3076(var1, var5);
      } else {
         int var3 = this.buffer.method2660();
         if (var5 == 247 && var3 > 0) {
            int var4 = this.buffer.array[this.buffer.offset] & 255;
            if (var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.buffer.offset;
               this.field2417[var1] = var4;
               return this.method3076(var1, var4);
            }
         }

         this.buffer.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("a")
   int method3076(int var1, int var2) {
      int var4;
      if (var2 == 255) {
         int var7 = this.buffer.readUnsignedByte();
         var4 = this.buffer.method2660();
         if (var7 == 47) {
            this.buffer.offset += var4;
            return 1;
         } else if (var7 == 81) {
            int var5 = this.buffer.readMedium();
            var4 -= 3;
            int var6 = this.trackLengths[var1];
            this.field2421 += (long)var6 * (long)(this.field2414 - var5);
            this.field2414 = var5;
            this.buffer.offset += var4;
            return 2;
         } else {
            this.buffer.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2411[var2 - 128];
         var4 = var2;
         if (var3 >= 1) {
            var4 = var2 | this.buffer.readUnsignedByte() << 8;
         }

         if (var3 >= 2) {
            var4 |= this.buffer.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   long method3077(int var1) {
      return this.field2421 + (long)var1 * (long)this.field2414;
   }

   @ObfuscatedName("s")
   @Export("method3087")
   int method3087() {
      int var1 = this.trackPositions.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if (this.trackPositions[var4] >= 0 && this.trackLengths[var4] < var3) {
            var2 = var4;
            var3 = this.trackLengths[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("m")
   @Export("method3079")
   boolean method3079() {
      int var1 = this.trackPositions.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if (this.trackPositions[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("u")
   @Export("method3080")
   void method3080(long var1) {
      this.field2421 = var1;
      int var3 = this.trackPositions.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.trackLengths[var4] = 0;
         this.field2417[var4] = 0;
         this.buffer.offset = this.trackStarts[var4];
         this.method3073(var4);
         this.trackPositions[var4] = this.buffer.offset;
      }

   }
}
