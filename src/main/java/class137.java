import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class137 {
   @ObfuscatedName("i")
   @Export("musicPatchesArchive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   public static AbstractArchive musicPatchesArchive;
   @ObfuscatedName("w")
   @Export("musicSamplesArchive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   public static AbstractArchive musicSamplesArchive;
   @ObfuscatedName("f")
   @Export("soundEffectsArchive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   public static AbstractArchive soundEffectsArchive;
   @ObfuscatedName("e")
   @Export("midiPcmStream")
   @ObfuscatedSignature(
      descriptor = "Lclass140;"
   )
   public static MidiPcmStream midiPcmStream;
   @ObfuscatedName("t")
   @Export("musicPlayerStatus")
   public static int musicPlayerStatus = 0;
   @ObfuscatedName("d")
   @Export("musicTrackArchive")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   public static AbstractArchive musicTrackArchive;

   @ObfuscatedName("f")
   public static int method2892(int var0) {
      return var0 >> 17 & 7;
   }
}
