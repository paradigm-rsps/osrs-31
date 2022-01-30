import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("LoginType")
public class LoginType {
   @ObfuscatedName("i")
   @Export("oldscape")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   public static final LoginType oldscape = new LoginType(6, 0, "", "");
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   static final LoginType field2856 = new LoginType(1, 1, "", "");
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   static final LoginType field2865 = new LoginType(5, 2, "", "");
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   static final LoginType field2858 = new LoginType(2, 3, "", "");
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   static final LoginType field2859 = new LoginType(0, 4, "", "");
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   static final LoginType field2863 = new LoginType(7, 5, "", "");
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   static final LoginType field2861 = new LoginType(3, 6, "", "");
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Lclass185;"
   )
   public static final LoginType field2862;
   @ObfuscatedName("r")
   public final int field2857;
   @ObfuscatedName("l")
   final String field2864;

   static {
      field2862 = new LoginType(4, -1, "", "", true, new LoginType[]{oldscape, field2856, field2865, field2859, field2858});
   }

   LoginType(int var1, int var2, String var3, String var4) {
      this.field2857 = var1;
      this.field2864 = var4;
   }

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Lclass185;)V"
   )
   LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
      this.field2857 = var1;
      this.field2864 = var4;
   }

   public String toString() {
      return this.field2864;
   }
}
