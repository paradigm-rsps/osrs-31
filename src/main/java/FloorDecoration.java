import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("FloorDecoration")
public final class FloorDecoration {
   @ObfuscatedName("k")
   @Export("musicTrackFileId")
   static int musicTrackFileId;
   @ObfuscatedName("z")
   @Export("musicTrack")
   @ObfuscatedSignature(
      descriptor = "Lclass138;"
   )
   static MusicTrack musicTrack;
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
   @Export("renderable")
   @ObfuscatedSignature(
      descriptor = "Lclass93;"
   )
   public Renderable renderable;
   @ObfuscatedName("t")
   public int field1807;
   @ObfuscatedName("d")
   int field1794;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Lclass151;IZ)Lclass108;"
   )
   public static Frames method2382(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3248(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3210(var2, var5[var6]);
         if (var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if (var3) {
               var9 = var1.method3210(0, var8);
            } else {
               var9 = var1.method3210(var8, 0);
            }

            if (var9 == null) {
               var4 = false;
            }
         }
      }

      if (!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("t")
   static final void method2381(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            Tiles.Tiles_heights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if (var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            Tiles.Tiles_heights[var0][var1][var3 + var2] = Tiles.Tiles_heights[var0][var1 - 1][var3 + var2];
         }
      }

      if (var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            Tiles.Tiles_heights[var0][var3 + var1][var2] = Tiles.Tiles_heights[var0][var3 + var1][var2 - 1];
         }
      }

      if (var1 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2] != 0) {
         Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2];
      } else if (var2 > 0 && Tiles.Tiles_heights[var0][var1][var2 - 1] != 0) {
         Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1][var2 - 1];
      } else if (var1 > 0 && var2 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2 - 1] != 0) {
         Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2 - 1];
      }

   }
}
