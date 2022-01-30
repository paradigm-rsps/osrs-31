import java.awt.Component;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public abstract class class65 {
   @ObfuscatedName("nf")
   static int field1268;
   @ObfuscatedName("l")
   @Export("pcmSampleLength")
   static int pcmSampleLength;

   @ObfuscatedName("i")
   public abstract void vmethod1690(Component var1);

   @ObfuscatedName("w")
   public abstract void vmethod1681(Component var1);

   @ObfuscatedName("f")
   public abstract int vmethod1679();

   @ObfuscatedName("w")
   @Export("method1455")
   @ObfuscatedSignature(
      descriptor = "(I)Lclass35;"
   )
   public static KitDefinition method1455(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.method3474((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.KitDefinition_archive.method3204(3, var0);
         var1 = new KitDefinition();
         if (var2 != null) {
            var1.method777(new Buffer(var2));
         }

         KitDefinition.KitDefinition_cached.method3473(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @Export("method1456")
   public static int method1456(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class40.method918(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("ay")
   static final void method1454(boolean var0) {
      SequenceDefinition.method759();
      ++Client.field669;
      if (Client.field669 >= 50 || var0) {
         Client.field669 = 0;
         if (!Client.field530 && GraphicsObject.World_request != null) {
            Client.field519.method2512(217);

            try {
               GraphicsObject.World_request.method1474(Client.field519.array, 0, Client.field519.offset);
               Client.field519.offset = 0;
            } catch (IOException var2) {
               Client.field530 = true;
            }
         }

      }
   }
}
