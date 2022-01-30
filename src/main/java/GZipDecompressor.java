import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("i")
   @Export("inflater")
   Inflater inflater;

   GZipDecompressor(int var1, int var2, int var3) {
   }

   public GZipDecompressor() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("i")
   @Export("method2583")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;[B)V"
   )
   public void method2583(Buffer var1, byte[] var2) {
      if (var1.array[var1.offset] == 31 && var1.array[var1.offset + 1] == -117) {
         if (this.inflater == null) {
            this.inflater = new Inflater(true);
         }

         try {
            this.inflater.setInput(var1.array, var1.offset + 10, var1.array.length - (var1.offset + 8 + 10));
            this.inflater.inflate(var2);
         } catch (Exception var4) {
            this.inflater.reset();
            throw new RuntimeException("");
         }

         this.inflater.reset();
      } else {
         throw new RuntimeException("");
      }
   }
}
