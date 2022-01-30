import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
   @ObfuscatedName("ap")
   @Export("archive1")
   @ObfuscatedSignature(
      descriptor = "Lclass153;"
   )
   static Archive archive1;
   @ObfuscatedName("i")
   int field2426;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lclass141;"
   )
   MusicPatchNode2 field2425;
   @ObfuscatedName("f")
   @Export("patch")
   @ObfuscatedSignature(
      descriptor = "Lclass139;"
   )
   MusicPatch patch;
   @ObfuscatedName("e")
   @Export("rawSound")
   @ObfuscatedSignature(
      descriptor = "Lclass62;"
   )
   RawSound rawSound;
   @ObfuscatedName("t")
   int field2439;
   @ObfuscatedName("d")
   int field2427;
   @ObfuscatedName("p")
   int field2428;
   @ObfuscatedName("k")
   int field2429;
   @ObfuscatedName("r")
   int field2430;
   @ObfuscatedName("l")
   int field2436;
   @ObfuscatedName("a")
   int field2432;
   @ObfuscatedName("z")
   int field2434;
   @ObfuscatedName("s")
   int field2423;
   @ObfuscatedName("m")
   int field2440;
   @ObfuscatedName("u")
   int field2443;
   @ObfuscatedName("g")
   int field2437;
   @ObfuscatedName("o")
   int field2438;
   @ObfuscatedName("v")
   int field2435;
   @ObfuscatedName("j")
   @Export("stream")
   @ObfuscatedSignature(
      descriptor = "Lclass44;"
   )
   RawPcmStream stream;
   @ObfuscatedName("n")
   int field2441;
   @ObfuscatedName("c")
   int field2442;

   @ObfuscatedName("i")
   void method3118() {
      this.patch = null;
      this.rawSound = null;
      this.field2425 = null;
      this.stream = null;
   }

   @ObfuscatedName("p")
   public static void method3122() {
      try {
         JagexCache.JagexCache_dat2File.method600();

         for(int var0 = 0; var0 < NetFileRequest.field2554; ++var0) {
            class10.JagexCache_idxFiles[var0].method600();
         }

         JagexCache.fontNameVerdana15.method600();
         JagexCache.JagexCache_randomDat.method600();
      } catch (Exception var2) {
         ;
      }

   }
}
