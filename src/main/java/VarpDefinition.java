import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("VarpDefinition")
public class VarpDefinition extends DualNode {
   @ObfuscatedName("pc")
   static int field1040;
   @ObfuscatedName("i")
   @Export("VarpDefinition_archive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   static AbstractArchive VarpDefinition_archive;
   @ObfuscatedName("w")
   public static int field1039;
   @ObfuscatedName("f")
   @Export("VarpDefinition_cached")
   @ObfuscatedSignature(
      descriptor = "Lclass169;"
   )
   static EvictingDualNodeHashTable VarpDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("t")
   @Export("Tiles_overlays")
   static byte[][][] Tiles_overlays;
   @ObfuscatedName("ea")
   static int[] field1044;
   @ObfuscatedName("e")
   @Export("type")
   public int type = 0;

   @ObfuscatedName("f")
   @Export("method924")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   void method924(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.method920(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @Export("method920")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;I)V"
   )
   void method920(Buffer var1, int var2) {
      if (var2 == 5) {
         this.type = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("f")
   static byte[] method934(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("al")
   static final int method936() {
      if (Projectile.clientPreferences.roofsHidden) {
         return class22.Client_plane;
      } else {
         int var0 = 3;
         if (NPC.cameraPitch < 310) {
            int var1 = Login.cameraX >> 7;
            int var2 = class17.cameraZ >> 7;
            int var3 = Tiles.localPlayer.x >> 7;
            int var4 = Tiles.localPlayer.y >> 7;
            if ((Tiles.Tiles_renderFlags[class22.Client_plane][var1][var2] & 4) != 0) {
               var0 = class22.Client_plane;
            }

            int var5;
            if (var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if (var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if (var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var3 != var1) {
                  if (var1 < var3) {
                     ++var1;
                  } else if (var1 > var3) {
                     --var1;
                  }

                  if ((Tiles.Tiles_renderFlags[class22.Client_plane][var1][var2] & 4) != 0) {
                     var0 = class22.Client_plane;
                  }

                  var8 += var7;
                  if (var8 >= 65536) {
                     var8 -= 65536;
                     if (var2 < var4) {
                        ++var2;
                     } else if (var2 > var4) {
                        --var2;
                     }

                     if ((Tiles.Tiles_renderFlags[class22.Client_plane][var1][var2] & 4) != 0) {
                        var0 = class22.Client_plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var2 != var4) {
                  if (var2 < var4) {
                     ++var2;
                  } else if (var2 > var4) {
                     --var2;
                  }

                  if ((Tiles.Tiles_renderFlags[class22.Client_plane][var1][var2] & 4) != 0) {
                     var0 = class22.Client_plane;
                  }

                  var8 += var7;
                  if (var8 >= 65536) {
                     var8 -= 65536;
                     if (var1 < var3) {
                        ++var1;
                     } else if (var1 > var3) {
                        --var1;
                     }

                     if ((Tiles.Tiles_renderFlags[class22.Client_plane][var1][var2] & 4) != 0) {
                        var0 = class22.Client_plane;
                     }
                  }
               }
            }
         }

         if ((Tiles.Tiles_renderFlags[class22.Client_plane][Tiles.localPlayer.x >> 7][Tiles.localPlayer.y >> 7] & 4) != 0) {
            var0 = class22.Client_plane;
         }

         return var0;
      }
   }

   @ObfuscatedName("ct")
   @Export("method927")
   static final void method927(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (EnumComposition.method852(var0)) {
         class40.method904(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
