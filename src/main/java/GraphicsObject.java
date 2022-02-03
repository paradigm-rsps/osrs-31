import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("il")
   static int field308;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lclass78;"
   )
   static Task field305;
   @ObfuscatedName("bi")
   @Export("World_request")
   @ObfuscatedSignature(
      descriptor = "Lclass69;"
   )
   static IterableNodeHashTableIterator gameSocket;
   @ObfuscatedName("dl")
   static int field307;
   @ObfuscatedName("i")
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @Export("cycleStart")
   int cycleStart;
   @ObfuscatedName("f")
   @Export("plane")
   int plane;
   @ObfuscatedName("e")
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @Export("height")
   int height;
   @ObfuscatedName("p")
   @Export("sequenceDefinition")
   @ObfuscatedSignature(
      descriptor = "Lclass33;"
   )
   SequenceDefinition sequenceDefinition;
   @ObfuscatedName("k")
   @Export("frame")
   int frame = 0;
   @ObfuscatedName("r")
   @Export("frameCycle")
   int frameCycle = 0;
   @ObfuscatedName("l")
   @Export("isFinished")
   boolean isFinished = false;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.id = var1;
      this.plane = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.cycleStart = var7 + var6;
      int var8 = NPCComposition.method656(this.id).sequence;
      if (var8 != -1) {
         this.isFinished = false;
         this.sequenceDefinition = class23.method250(var8);
      } else {
         this.isFinished = true;
      }

   }

   @ObfuscatedName("i")
   @Export("method207")
   final void method207(int var1) {
      if (!this.isFinished) {
         this.frameCycle += var1;

         while(this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
            this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
            ++this.frame;
            if (this.frame >= this.sequenceDefinition.frameIds.length) {
               this.isFinished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("w")
   @Export("vmethod2030")
   @ObfuscatedSignature(
      descriptor = "()Lclass111;"
   )
   protected final Model vmethod2030() {
      SpotAnimationDefinition var1 = NPCComposition.method656(this.id);
      Model var2;
      if (!this.isFinished) {
         var2 = var1.method766(this.frame);
      } else {
         var2 = var1.method766(-1);
      }

      return var2 == null ? null : var2;
   }
}
