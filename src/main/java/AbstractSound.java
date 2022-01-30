import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aj")
@Implements("AbstractSound")
public abstract class AbstractSound extends Node {
   @ObfuscatedName("i")
   @Export("position")
   int position;
}
