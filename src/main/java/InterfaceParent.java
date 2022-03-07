import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
   @ObfuscatedName("q")
   static int[] field58;
   @ObfuscatedName("az")
   @Export("archive7")
   @ObfuscatedSignature(
      descriptor = "Lclass153;"
   )
   static Archive archive7;
   @ObfuscatedName("i")
   @Export("group")
   int group;
   @ObfuscatedName("w")
   int field56;
   @ObfuscatedName("f")
   boolean field54 = false;

   @ObfuscatedName("w")
   static boolean method30(CharSequence var0, int var1, boolean var2) {
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
                  return false;
               }

               var10 = var8 - 87;
            }

            if (var10 >= var1) {
               return false;
            }

            if (var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if (var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("w")
   public static int method29(char var0, int var1) {
      int var2 = var0 << 4;
      if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("e")
   @Export("method27")
   public static String readString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if (var6 != 0) {
            if (var6 >= 128 && var6 < 160) {
               char var7 = class148.cp1252AsciiExtension[var6 - 128];
               if (var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("e")
   public static int method28() {
      return ++MouseHandler.MouseHandler_idleCycles - 1;
   }
}
