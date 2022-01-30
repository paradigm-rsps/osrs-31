import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fv")
@Implements("Varps")
public class Varps {
   @ObfuscatedName("i")
   @Export("Varps_masks")
   public static int[] Varps_masks = new int[32];
   @ObfuscatedName("w")
   @Export("Varps_temp")
   public static int[] Varps_temp;
   @ObfuscatedName("f")
   @Export("Varps_main")
   public static int[] Varps_main;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         Varps_masks[var1] = var0 - 1;
         var0 += var0;
      }

      Varps_temp = new int[2000];
      Varps_main = new int[2000];
   }
}
