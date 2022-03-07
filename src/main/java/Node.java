import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
@Implements("Node")
public class Node {
   @ObfuscatedName("dw")
   @Export("key")
   public long key;
   @ObfuscatedName("dg")
   @Export("previous")
   @ObfuscatedSignature(
      descriptor = "Lclass178;"
   )
   public Node previous;
   @ObfuscatedName("ec")
   @Export("next")
   @ObfuscatedSignature(
      descriptor = "Lclass178;"
   )
   Node next;

   @ObfuscatedName("he")
   @Export("method3567")
   public void remove() {
      if (this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }

   @ObfuscatedName("hp")
   public boolean method3566() {
      return this.next != null;
   }
}
