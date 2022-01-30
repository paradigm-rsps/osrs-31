import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
   @ObfuscatedName("w")
   @Export("active")
   volatile boolean active = true;
   @ObfuscatedName("o")
   @Export("after")
   @ObfuscatedSignature(
      descriptor = "Lclass47;"
   )
   PcmStream after;
   @ObfuscatedName("v")
   int field1074;
   @ObfuscatedName("j")
   @Export("sound")
   @ObfuscatedSignature(
      descriptor = "Lclass46;"
   )
   AbstractSound sound;

   @ObfuscatedName("f")
   int vmethod1184() {
      return 255;
   }

   @ObfuscatedName("h")
   @Export("vmethod3061")
   @ObfuscatedSignature(
      descriptor = "()Lclass47;"
   )
   protected abstract PcmStream vmethod3061();

   @ObfuscatedName("b")
   @Export("vmethod3052")
   @ObfuscatedSignature(
      descriptor = "()Lclass47;"
   )
   protected abstract PcmStream vmethod3052();

   @ObfuscatedName("y")
   protected abstract int vmethod3046();

   @ObfuscatedName("x")
   @Export("vmethod3045")
   protected abstract void vmethod3045(int[] var1, int var2, int var3);

   @ObfuscatedName("ao")
   @Export("vmethod3048")
   protected abstract void vmethod3048(int var1);

   @ObfuscatedName("en")
   @Export("method1170")
   final void method1170(int[] var1, int var2, int var3) {
      if (this.active) {
         this.vmethod3045(var1, var2, var3);
      } else {
         this.vmethod3048(var3);
      }

   }
}
