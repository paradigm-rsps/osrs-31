import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("w")
   static final int[] field1988 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("i")
   @Export("isaacCipher")
   @ObfuscatedSignature(
      descriptor = "Lclass116;"
   )
   IsaacCipher isaacCipher;
   @ObfuscatedName("f")
   @Export("bitIndex")
   int bitIndex;

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("i")
   @Export("method2511")
   public void method2511(int[] var1) {
      this.isaacCipher = new IsaacCipher(var1);
   }

   @ObfuscatedName("w")
   @Export("method2512")
   public void method2512(int var1) {
      super.array[++super.offset - 1] = (byte)(var1 + this.isaacCipher.method2539());
   }

   @ObfuscatedName("f")
   @Export("method2513")
   public int method2513() {
      return super.array[++super.offset - 1] - this.isaacCipher.method2539() & 255;
   }

   @ObfuscatedName("e")
   @Export("method2531")
   public void method2531() {
      this.bitIndex = super.offset * 8;
   }

   @ObfuscatedName("t")
   @Export("method2515")
   public int method2515(int var1) {
      int var2 = this.bitIndex >> 3;
      int var3 = 8 - (this.bitIndex & 7);
      int var4 = 0;

      for(this.bitIndex += var1; var1 > var3; var3 = 8) {
         var4 += (super.array[var2++] & field1988[var3]) << var1 - var3;
         var1 -= var3;
      }

      if (var3 == var1) {
         var4 += super.array[var2] & field1988[var3];
      } else {
         var4 += super.array[var2] >> var3 - var1 & field1988[var1];
      }

      return var4;
   }

   @ObfuscatedName("d")
   @Export("method2516")
   public void method2516() {
      super.offset = (this.bitIndex + 7) / 8;
   }

   @ObfuscatedName("p")
   @Export("method2514")
   public int method2514(int var1) {
      return var1 * 8 - this.bitIndex;
   }

   @ObfuscatedName("i")
   public static Object method2537(byte[] var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else {
         if (var0.length > 136 && !AbstractByteArrayCopier.field2007) {
            try {
               DirectByteArrayCopier var2 = new DirectByteArrayCopier();
               var2.vmethod2622(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteArrayCopier.field2007 = true;
            }
         }

         return var0;
      }
   }
}
