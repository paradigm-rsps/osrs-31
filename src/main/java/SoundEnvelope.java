import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("SoundEnvelope")
public class SoundEnvelope {
   @ObfuscatedName("i")
   @Export("segments")
   int segments = 2;
   @ObfuscatedName("w")
   @Export("durations")
   int[] durations = new int[2];
   @ObfuscatedName("f")
   @Export("phases")
   int[] phases = new int[2];
   @ObfuscatedName("e")
   @Export("start")
   int start;
   @ObfuscatedName("t")
   @Export("end")
   int end;
   @ObfuscatedName("d")
   @Export("form")
   int form;
   @ObfuscatedName("p")
   @Export("ticks")
   int ticks;
   @ObfuscatedName("k")
   @Export("phaseIndex")
   int phaseIndex;
   @ObfuscatedName("r")
   @Export("step")
   int step;
   @ObfuscatedName("l")
   @Export("amplitude")
   int amplitude;
   @ObfuscatedName("a")
   @Export("max")
   int max;

   SoundEnvelope() {
      this.durations[0] = 0;
      this.durations[1] = 65535;
      this.phases[0] = 0;
      this.phases[1] = 65535;
   }

   @ObfuscatedName("i")
   @Export("method1331")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   final void method1331(Buffer var1) {
      this.form = var1.method2665();
      this.start = var1.method2650();
      this.end = var1.method2650();
      this.method1341(var1);
   }

   @ObfuscatedName("w")
   @Export("method1341")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   final void method1341(Buffer var1) {
      this.segments = var1.method2665();
      this.durations = new int[this.segments];
      this.phases = new int[this.segments];

      for(int var2 = 0; var2 < this.segments; ++var2) {
         this.durations[var2] = var1.readUnsignedShort();
         this.phases[var2] = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("f")
   @Export("method1333")
   final void method1333() {
      this.ticks = 0;
      this.phaseIndex = 0;
      this.step = 0;
      this.amplitude = 0;
      this.max = 0;
   }

   @ObfuscatedName("e")
   @Export("method1330")
   final int method1330(int var1) {
      if (this.max >= this.ticks) {
         this.amplitude = this.phases[this.phaseIndex++] << 15;
         if (this.phaseIndex >= this.segments) {
            this.phaseIndex = this.segments - 1;
         }

         this.ticks = (int)((double)this.durations[this.phaseIndex] / 65536.0D * (double)var1);
         if (this.ticks > this.max) {
            this.step = ((this.phases[this.phaseIndex] << 15) - this.amplitude) / (this.ticks - this.max);
         }
      }

      this.amplitude += this.step;
      ++this.max;
      return this.amplitude - this.step >> 15;
   }
}
