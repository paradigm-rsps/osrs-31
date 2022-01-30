import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class22 {
   @ObfuscatedName("oe")
   @ObfuscatedSignature(
      descriptor = "Lclass67;"
   )
   protected static Clock field376;
   @ObfuscatedName("he")
   @Export("Client_plane")
   static int Client_plane;
   @ObfuscatedName("ep")
   @Export("redHintArrowSprite")
   @ObfuscatedSignature(
      descriptor = "Lclass85;"
   )
   static SpritePixels redHintArrowSprite;
   @ObfuscatedName("fe")
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("i")
   String field381;
   @ObfuscatedName("w")
   String field369;
   @ObfuscatedName("f")
   int field370;
   @ObfuscatedName("e")
   int field371;
   @ObfuscatedName("t")
   boolean field372;
   @ObfuscatedName("d")
   boolean field368;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Lclass151;)V"
   )
   public static void method246(AbstractArchive var0, AbstractArchive var1) {
      KitDefinition.KitDefinition_archive = var0;
      KitDefinition.KitDefinition_modelsArchive = var1;
      KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.method3214(3);
   }

   @ObfuscatedName("w")
   @Export("method247")
   @ObfuscatedSignature(
      descriptor = "(I)Lclass30;"
   )
   public static NPCComposition method247(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.NpcDefinition_cached.method3474((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_archive.method3204(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if (var2 != null) {
            var1.method629(new Buffer(var2));
         }

         var1.method628();
         NPCComposition.NpcDefinition_cached.method3473(var1, (long)var0);
         return var1;
      }
   }
}
