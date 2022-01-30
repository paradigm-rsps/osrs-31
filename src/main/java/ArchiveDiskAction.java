import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
   @ObfuscatedName("i")
   @Export("type")
   int type;
   @ObfuscatedName("w")
   @Export("data")
   public byte[] data;
   @ObfuscatedName("f")
   @Export("archiveDisk")
   @ObfuscatedSignature(
      descriptor = "Lclass70;"
   )
   public ArchiveDisk archiveDisk;
   @ObfuscatedName("e")
   @Export("archive")
   @ObfuscatedSignature(
      descriptor = "Lclass153;"
   )
   public Archive archive;
}
