import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Task")
public class Task {
   @ObfuscatedName("i")
   @Export("next")
   @ObfuscatedSignature(
      descriptor = "Lclass78;"
   )
   Task next;
   @ObfuscatedName("t")
   @Export("status")
   public volatile int status = 0;
   @ObfuscatedName("d")
   @Export("type")
   int type;
   @ObfuscatedName("p")
   @Export("intArgument")
   public int intArgument;
   @ObfuscatedName("k")
   @Export("objectArgument")
   Object objectArgument;
   @ObfuscatedName("r")
   @Export("result")
   public volatile Object result;
}
