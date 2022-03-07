package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;

@ObfuscatedName("cb")
@Implements("ItemLayer")
public final class ItemLayer {
    @ObfuscatedName("py")
    @Export("canvasHeight")
    protected static int canvasHeight;
    @ObfuscatedName("bf")
    protected static FontMetrics field1659;
    @ObfuscatedName("eq")
    @Export("mapDotSprites")
    @ObfuscatedSignature(
            descriptor = "[Lclass85;"
    )
    static SpritePixels[] mapDotSprites;
    @ObfuscatedName("i")
    @Export("tileHeight")
    int tileHeight;
    @ObfuscatedName("w")
    @Export("x")
    int x;
    @ObfuscatedName("f")
    @Export("y")
    int y;
    @ObfuscatedName("e")
    @Export("first")
    @ObfuscatedSignature(
            descriptor = "Lclass93;"
    )
    Renderable first;
    @ObfuscatedName("t")
    @Export("second")
    @ObfuscatedSignature(
            descriptor = "Lclass93;"
    )
    Renderable second;
    @ObfuscatedName("d")
    @Export("third")
    @ObfuscatedSignature(
            descriptor = "Lclass93;"
    )
    Renderable third;
    @ObfuscatedName("p")
    int field1664;
    @ObfuscatedName("k")
    @Export("height")
    int height;
}
