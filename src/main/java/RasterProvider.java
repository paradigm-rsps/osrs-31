import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cj")
@Implements("RasterProvider")
public final class RasterProvider extends AbstractRasterProvider {
   @ObfuscatedName("i")
   Component field1481;

   @ObfuscatedName("i")
   final void vmethod1940(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var2 * var1 + 1];
      DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
      DirectColorModel var5 = new DirectColorModel(32, 16711680, 65280, 255);
      WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height), var4, (Point)null);
      super.field1458 = new BufferedImage(var5, var6, false, new Hashtable());
      this.field1481 = var3;
      this.method1822();
   }

   @ObfuscatedName("w")
   @Export("vmethod1945")
   public final void vmethod1945(Graphics var1, int var2, int var3) {
      var1.drawImage(super.field1458, var2, var3, this.field1481);
   }

   @ObfuscatedName("f")
   @Export("vmethod1941")
   public final void vmethod1941(Graphics var1, int var2, int var3, int var4, int var5) {
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1458, 0, 0, this.field1481);
      var1.setClip(var6);
   }
}
