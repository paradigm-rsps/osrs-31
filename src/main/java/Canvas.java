import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
   @ObfuscatedName("at")
   @Export("js5SocketTask")
   @ObfuscatedSignature(
      descriptor = "Lclass78;"
   )
   static Task js5SocketTask;
   @ObfuscatedName("i")
   @Export("component")
   Component component;

   Canvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("n")
   static final void method1655() {
      if (GraphicsObject.gameSocket != null) {
         GraphicsObject.gameSocket.method1471();
         GraphicsObject.gameSocket = null;
      }

      Interpreter.method274();
      Interpreter.scene.method2138();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method3435();
      }

      System.gc();
      Interpreter.method270(2);
      Client.currentTrackGroupId = -1;
      Client.field562 = false;

      for(ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.method3533(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.method3535()) {
         if (var1.stream1 != null) {
            ItemContainer.pcmStreamMixer.method1127(var1.stream1);
            var1.stream1 = null;
         }

         if (var1.field91 != null) {
            ItemContainer.pcmStreamMixer.method1127(var1.field91);
            var1.field91 = null;
         }
      }

      ObjectSound.objectSounds.method3527();
      NPC.method260(10);
   }
}
