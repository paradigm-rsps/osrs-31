import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cz")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("ii")
   static int field1523;
   @ObfuscatedName("nc")
   static int field1519;
   @ObfuscatedName("s")
   static String field1522;
   @ObfuscatedName("cs")
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("i")
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @Export("z")
   int z;

   @ObfuscatedName("i")
   public static boolean method2029(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("e")
   public static int method2027(CharSequence var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if (var7 == 0) {
               if (var8 == '-') {
                  var3 = true;
                  continue;
               }

               if (var8 == '+') {
                  continue;
               }
            }

            int var10;
            if (var8 >= '0' && var8 <= '9') {
               var10 = var8 - 48;
            } else if (var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - 55;
            } else {
               if (var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if (var10 >= var1) {
               throw new NumberFormatException();
            }

            if (var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if (var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if (!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("o")
   static final int method2028(int var0, int var1, int var2) {
      if (var2 > 179) {
         var1 /= 2;
      }

      if (var2 > 192) {
         var1 /= 2;
      }

      if (var2 > 217) {
         var1 /= 2;
      }

      if (var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
