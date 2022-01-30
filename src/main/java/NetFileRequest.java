import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
   @ObfuscatedName("d")
   static int field2554;
   @ObfuscatedName("i")
   @Export("archive")
   @ObfuscatedSignature(
      descriptor = "Lclass153;"
   )
   public Archive archive;
   @ObfuscatedName("w")
   @Export("crc")
   public int crc;
   @ObfuscatedName("f")
   @Export("padding")
   public byte padding;
}
