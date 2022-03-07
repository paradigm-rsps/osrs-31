package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
    @ObfuscatedName("i")
    int field1225;

    @ObfuscatedName("i")
    @Export("method1394")
    abstract void method1394();

    @ObfuscatedName("w")
    @Export("method1395")
    abstract int method1395();
}
