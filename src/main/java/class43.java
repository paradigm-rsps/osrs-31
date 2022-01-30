import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class43 extends PcmPlayer {
   @ObfuscatedName("i")
   static class42 field1051;
   @ObfuscatedName("w")
   int field1052;

   @ObfuscatedSignature(
      descriptor = "(Lclass73;I)V"
   )
   class43(TaskHandler var1, int var2) {
      field1051 = var1.method1602();
      this.field1052 = var2;
   }

   @ObfuscatedName("i")
   void vmethod1234(Component var1) throws Exception {
      field1051.method939(var1, PcmPlayer.field1099, PcmPlayer.PcmPlayer_stereo, -1760138480);
   }

   @ObfuscatedName("w")
   void vmethod1235(int var1) throws Exception {
      if (var1 > 32768) {
         throw new IllegalArgumentException();
      } else {
         field1051.method943(this.field1052, var1, (byte)-28);
      }
   }

   @ObfuscatedName("f")
   int vmethod1233() {
      return field1051.method945(this.field1052, 34740438);
   }

   @ObfuscatedName("e")
   void vmethod1237() {
      field1051.method949(this.field1052, super.samples, (byte)10);
   }

   @ObfuscatedName("t")
   void vmethod1238() {
      field1051.method937(this.field1052, 2146695330);
   }

   @ObfuscatedName("d")
   void vmethod1229() {
      field1051.method940(this.field1052, 1632443377);
   }
}
