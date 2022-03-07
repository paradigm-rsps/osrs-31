package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class134 {
    @ObfuscatedName("et")
    @Export("headIconPkSprites")
    @ObfuscatedSignature(
            descriptor = "[Lclass85;"
    )
    static SpritePixels[] headIconPkSprites;

    @ObfuscatedName("l")
    @Export("method2864")
    @ObfuscatedSignature(
            descriptor = "([B)Lclass182;"
    )
    static Font method2864(byte[] var0) {
        if (var0 == null) {
            return null;
        } else {
            Font var1 = new Font(var0, class83.SpriteBuffer_xOffsets, class165.SpriteBuffer_yOffsets, class112.SpriteBuffer_spriteWidths, class83.SpriteBuffer_spriteHeights, FloorUnderlayDefinition.SpriteBuffer_spritePalette, class145.SpriteBuffer_pixels);
            FileSystem.method1515();
            return var1;
        }
    }
}
