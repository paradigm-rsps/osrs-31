import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("GameBuild")
public class GameBuild {
   @ObfuscatedName("i")
   @Export("LIVE")
   @ObfuscatedSignature(
      descriptor = "Lclass131;"
   )
   public static final GameBuild LIVE = new GameBuild("LIVE", 0);
   @ObfuscatedName("w")
   @Export("BUILDLIVE")
   @ObfuscatedSignature(
      descriptor = "Lclass131;"
   )
   public static final GameBuild BUILDLIVE = new GameBuild("BUILDLIVE", 3);
   @ObfuscatedName("f")
   @Export("RC")
   @ObfuscatedSignature(
      descriptor = "Lclass131;"
   )
   public static final GameBuild RC = new GameBuild("RC", 1);
   @ObfuscatedName("e")
   @Export("WIP")
   @ObfuscatedSignature(
      descriptor = "Lclass131;"
   )
   public static final GameBuild WIP = new GameBuild("WIP", 2);
   @ObfuscatedName("t")
   @Export("name")
   public final String name;
   @ObfuscatedName("d")
   @Export("buildId")
   public final int buildId;

   GameBuild(String var1, int var2) {
      this.name = var1;
      this.buildId = var2;
   }

   @ObfuscatedName("w")
   @Export("method2853")
   @ObfuscatedSignature(
      descriptor = "(I)Lclass31;"
   )
   public static ObjectComposition method2853(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.ObjectDefinition_cached.method3474((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.ObjectDefinition_archive.method3204(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if (var2 != null) {
            var1.method659(new Buffer(var2));
         }

         var1.method660();
         if (var1.isSolid) {
            var1.interactType = 0;
            var1.boolean1 = false;
         }

         ObjectComposition.ObjectDefinition_cached.method3473(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @Export("method2854")
   @ObfuscatedSignature(
      descriptor = "(I)Lclass41;"
   )
   public static VarpDefinition method2854(int var0) {
      VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.method3474((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarpDefinition.VarpDefinition_archive.method3204(16, var0);
         var1 = new VarpDefinition();
         if (var2 != null) {
            var1.method924(new Buffer(var2));
         }

         VarpDefinition.VarpDefinition_cached.method3473(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "()Lclass11;"
   )
   static ClientPreferences method2852() {
      AccessFile var0 = null;
      ClientPreferences var1 = new ClientPreferences();

      try {
         var0 = Tiles.method110("", Client.field484.name, false);
         byte[] var2 = new byte[(int)var0.method578()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method584(var2, var3, var2.length - var3);
            if (var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new ClientPreferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if (var0 != null) {
            var0.method586();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }
}
