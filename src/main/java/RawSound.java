import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("RawSound")
public class RawSound extends AbstractSound {
   @ObfuscatedName("w")
   @Export("sampleRate")
   public int sampleRate;
   @ObfuscatedName("f")
   @Export("samples")
   public byte[] samples;
   @ObfuscatedName("e")
   @Export("start")
   public int start;
   @ObfuscatedName("t")
   @Export("end")
   int end;
   @ObfuscatedName("d")
   public boolean field1241;

   RawSound(int var1, byte[] var2, int var3, int var4) {
      this.sampleRate = var1;
      this.samples = var2;
      this.start = var3;
      this.end = var4;
   }

   RawSound(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.sampleRate = var1;
      this.samples = var2;
      this.start = var3;
      this.end = var4;
      this.field1241 = var5;
   }

   @ObfuscatedName("i")
   @Export("method1413")
   @ObfuscatedSignature(
      descriptor = "(Lclass61;)Lclass62;"
   )
   public RawSound method1413(Decimator var1) {
      this.samples = var1.method1402(this.samples);
      this.sampleRate = var1.method1404(this.sampleRate);
      if (this.start == this.end) {
         this.start = this.end = var1.method1403(this.start);
      } else {
         this.start = var1.method1403(this.start);
         this.end = var1.method1403(this.end);
         if (this.start == this.end) {
            --this.start;
         }
      }

      return this;
   }
}
