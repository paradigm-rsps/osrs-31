import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class161 {
   @ObfuscatedName("dk")
   static int[][] field2709;
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      descriptor = "[Lclass85;"
   )
   static SpritePixels[] field2711;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;IIIZ)V"
   )
   public static void method3399(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
      class137.musicPlayerStatus = 1;
      class137.musicTrackArchive = var0;
      class125.musicTrackGroupId = var1;
      FloorDecoration.musicTrackFileId = var2;
      class147.musicTrackVolume = var3;
      VarbitComposition.musicTrackBoolean = var4;
      class65.pcmSampleLength = 10000;
   }
}
