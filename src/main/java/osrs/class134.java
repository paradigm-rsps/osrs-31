package osrs;

public class class134 {
    static SpritePixels[] headIconPkSprites;

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
