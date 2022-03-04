import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("ByteArrayPool")
public class ByteArrayPool {
   @ObfuscatedName("lh")
   static class136 field1945;
   @ObfuscatedName("i")
   @Export("ByteArrayPool_smallCount")
   static int ByteArrayPool_smallCount = 0;
   @ObfuscatedName("w")
   @Export("ByteArrayPool_mediumCount")
   static int ByteArrayPool_mediumCount = 0;
   @ObfuscatedName("f")
   @Export("ByteArrayPool_largeCount")
   static int ByteArrayPool_largeCount = 0;
   @ObfuscatedName("e")
   @Export("ByteArrayPool_small")
   static byte[][] ByteArrayPool_small = new byte[1000][];
   @ObfuscatedName("t")
   @Export("ByteArrayPool_medium")
   static byte[][] ByteArrayPool_medium = new byte[250][];
   @ObfuscatedName("d")
   @Export("ByteArrayPool_large")
   static byte[][] ByteArrayPool_large = new byte[50][];

   @ObfuscatedName("i")
   @Export("method2506")
   static synchronized byte[] method2506(int var0) {
      byte[] var1;
      if (var0 == 100 && ByteArrayPool_smallCount > 0) {
         var1 = ByteArrayPool_small[--ByteArrayPool_smallCount];
         ByteArrayPool_small[ByteArrayPool_smallCount] = null;
         return var1;
      } else if (var0 == 5000 && ByteArrayPool_mediumCount > 0) {
         var1 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
         ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
         return var1;
      } else if (var0 == 30000 && ByteArrayPool_largeCount > 0) {
         var1 = ByteArrayPool_large[--ByteArrayPool_largeCount];
         ByteArrayPool_large[ByteArrayPool_largeCount] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("i")
   public static String method2508(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if (var7 < 128) {
            if (var7 == 0) {
               var8 = 65533;
            } else {
               var8 = var7;
            }
         } else if (var7 < 192) {
            var8 = 65533;
         } else if (var7 < 224) {
            if (var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if (var8 < 128) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if (var7 < 240) {
            if (var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if (var8 < 2048) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if (var7 < 248) {
            if (var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if (var8 >= 65536 && var8 <= 1114111) {
                  var8 = 65533;
               } else {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else {
            var8 = 65533;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("k")
   public static String method2507(CharSequence var0) {
      return Tile.method2296('*', var0.length());
   }

   @ObfuscatedName("cj")
   @Export("method2503")
   @ObfuscatedSignature(
      descriptor = "(Lclass157;II)V"
   )
   static final void method2503(Widget var0, int var1, int var2) {
      if (Client.clickedWidget == null && !Client.isMenuOpen) {
         if (var0 != null) {
            Widget var5 = var0;
            int var6 = class137.method2892(SoundSystem.method1326(var0));
            Widget var4;
            int var7;
            if (var6 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if (var7 >= var6) {
                     var4 = var5;
                     break;
                  }

                  var5 = class130.getWidget(var5.parentId);
                  if (var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            Widget var8 = var4;
            if (var4 == null) {
               var8 = var0.parent;
            }

            if (var8 != null) {
               Client.clickedWidget = var0;
               var5 = var0;
               var6 = class137.method2892(SoundSystem.method1326(var0));
               if (var6 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if (var7 >= var6) {
                        var4 = var5;
                        break;
                     }

                     var5 = class130.getWidget(var5.parentId);
                     if (var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var8 = var4;
               if (var4 == null) {
                  var8 = var0.parent;
               }

               Client.field740 = var8;
               Client.widgetClickX = var1;
               Client.widgetClickY = var2;
               ClientPreferences.field191 = 0;
               Client.isDraggingWidget = false;
               return;
            }
         }

      }
   }
}
