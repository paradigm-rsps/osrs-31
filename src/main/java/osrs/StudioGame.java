package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("StudioGame")
public enum StudioGame implements class117 {
    @ObfuscatedName("i")
    @Export("runescape")
    @ObfuscatedSignature(
            descriptor = "Lclass132;"
    )
    runescape("runescape", "RuneScape", 0),
    @ObfuscatedName("w")
    @Export("stellardawn")
    @ObfuscatedSignature(
            descriptor = "Lclass132;"
    )
    stellardawn("stellardawn", "Stellar Dawn", 1),
    @ObfuscatedName("f")
    @Export("game3")
    @ObfuscatedSignature(
            descriptor = "Lclass132;"
    )
    game3("game3", "Game 3", 2),
    @ObfuscatedName("e")
    @Export("game4")
    @ObfuscatedSignature(
            descriptor = "Lclass132;"
    )
    game4("game4", "Game 4", 3),
    @ObfuscatedName("t")
    @Export("game5")
    @ObfuscatedSignature(
            descriptor = "Lclass132;"
    )
    game5("game5", "Game 5", 4),
    @ObfuscatedName("d")
    @Export("oldscape")
    @ObfuscatedSignature(
            descriptor = "Lclass132;"
    )
    oldscape("oldscape", "RuneScape 2007", 5);

    @ObfuscatedName("be")
    @ObfuscatedSignature(
            descriptor = "Lclass78;"
    )
    static Task field2087;
    @ObfuscatedName("p")
    @Export("name")
    public final String name;
    @ObfuscatedName("k")
    @Export("id")
    final int id;

    StudioGame(String var3, String var4, int var5) {
        this.name = var3;
        this.id = var5;
    }

    @ObfuscatedName("i")
    @Export("vmethod2859")
    public int vmethod2859() {
        return this.id;
    }
}
