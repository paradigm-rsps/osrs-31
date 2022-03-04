import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("BoundaryObject")
public final class BoundaryObject {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lclass15;"
   )
   static MouseRecorder field1625;
   @ObfuscatedName("i")
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("w")
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("t")
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("d")
   @Export("renderable1")
   @ObfuscatedSignature(
      descriptor = "Lclass93;"
   )
   public Renderable renderable1;
   @ObfuscatedName("p")
   @Export("renderable2")
   @ObfuscatedSignature(
      descriptor = "Lclass93;"
   )
   public Renderable renderable2;
   @ObfuscatedName("k")
   public int packedId = 0;
   @ObfuscatedName("r")
   int field1615 = 0;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IILjava/awt/Component;)Lclass84;"
   )
   public static AbstractRasterProvider method2204(int var0, int var1, Component var2) {
      try {
         RasterProvider var3 = new RasterProvider();
         var3.vmethod1940(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class82 var4 = new class82();
         var4.vmethod1940(var0, var1, var2);
         return var4;
      }
   }
}
