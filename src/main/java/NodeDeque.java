import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("NodeDeque")
public class NodeDeque {
   @ObfuscatedName("i")
   @Export("sentinel")
   @ObfuscatedSignature(
      descriptor = "Lclass178;"
   )
   public Node sentinel = new Node();
   @ObfuscatedName("w")
   @Export("current")
   @ObfuscatedSignature(
      descriptor = "Lclass178;"
   )
   Node current;

   public NodeDeque() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("i")
   @Export("method3527")
   public void method3527() {
      while(true) {
         Node var1 = this.sentinel.previous;
         if (var1 == this.sentinel) {
            this.current = null;
            return;
         }

         var1.method3567();
      }
   }

   @ObfuscatedName("w")
   @Export("method3528")
   @ObfuscatedSignature(
      descriptor = "(Lclass178;)V"
   )
   public void method3528(Node var1) {
      if (var1.next != null) {
         var1.method3567();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("f")
   @Export("method3529")
   @ObfuscatedSignature(
      descriptor = "(Lclass178;)V"
   )
   public void method3529(Node var1) {
      if (var1.next != null) {
         var1.method3567();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("t")
   @Export("method3549")
   @ObfuscatedSignature(
      descriptor = "()Lclass178;"
   )
   public Node method3549() {
      Node var1 = this.sentinel.previous;
      if (var1 == this.sentinel) {
         return null;
      } else {
         var1.method3567();
         return var1;
      }
   }

   @ObfuscatedName("d")
   @Export("method3532")
   @ObfuscatedSignature(
      descriptor = "()Lclass178;"
   )
   public Node method3532() {
      Node var1 = this.sentinel.next;
      if (var1 == this.sentinel) {
         return null;
      } else {
         var1.method3567();
         return var1;
      }
   }

   @ObfuscatedName("p")
   @Export("method3533")
   @ObfuscatedSignature(
      descriptor = "()Lclass178;"
   )
   public Node method3533() {
      Node var1 = this.sentinel.previous;
      if (var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("k")
   @Export("method3554")
   @ObfuscatedSignature(
      descriptor = "()Lclass178;"
   )
   public Node method3554() {
      Node var1 = this.sentinel.next;
      if (var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("r")
   @Export("method3535")
   @ObfuscatedSignature(
      descriptor = "()Lclass178;"
   )
   public Node method3535() {
      Node var1 = this.current;
      if (var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("l")
   @Export("method3561")
   @ObfuscatedSignature(
      descriptor = "()Lclass178;"
   )
   public Node method3561() {
      Node var1 = this.current;
      if (var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("e")
   @Export("method3530")
   @ObfuscatedSignature(
      descriptor = "(Lclass178;Lclass178;)V"
   )
   public static void method3530(Node var0, Node var1) {
      if (var0.next != null) {
         var0.method3567();
      }

      var0.next = var1.next;
      var0.previous = var1;
      var0.next.previous = var0;
      var0.previous.next = var0;
   }
}
