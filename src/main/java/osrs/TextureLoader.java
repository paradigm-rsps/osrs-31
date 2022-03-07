package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
@Implements("TextureLoader")
public interface TextureLoader {
    @ObfuscatedName("i")
    @Export("vmethod2397")
    int[] vmethod2397(int var1);

    @ObfuscatedName("w")
    @Export("vmethod2406")
    int vmethod2406(int var1);

    @ObfuscatedName("f")
    boolean vmethod2418(int var1);

    @ObfuscatedName("e")
    @Export("vmethod2395")
    boolean vmethod2395(int var1);
}
