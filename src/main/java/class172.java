import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fu")
public class class172 {
   @ObfuscatedName("i")
   class177 field2802 = new class177();
   @ObfuscatedName("w")
   class177 field2801;

   public class172() {
      this.field2802.field2814 = this.field2802;
      this.field2802.field2813 = this.field2802;
   }

   @ObfuscatedName("i")
   public void method3500(class177 var1) {
      if (var1.field2813 != null) {
         var1.method3563();
      }

      var1.field2813 = this.field2802.field2813;
      var1.field2814 = this.field2802;
      var1.field2813.field2814 = var1;
      var1.field2814.field2813 = var1;
   }

   @ObfuscatedName("w")
   public class177 method3506() {
      class177 var1 = this.field2802.field2814;
      if (var1 == this.field2802) {
         this.field2801 = null;
         return null;
      } else {
         this.field2801 = var1.field2814;
         return var1;
      }
   }

   @ObfuscatedName("f")
   public class177 method3501() {
      class177 var1 = this.field2801;
      if (var1 == this.field2802) {
         this.field2801 = null;
         return null;
      } else {
         this.field2801 = var1.field2814;
         return var1;
      }
   }
}
