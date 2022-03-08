package osrs;

public abstract class Clock {
    public abstract void vmethod1698();

    abstract int vmethod1701(int var1, int var2);

    public static SpritePixels[] method1467(AbstractArchive var0, String var1, String var2) {
        int var3 = var0.getGroupId(var1);
        int var4 = var0.method3238(var3, var2);
        SpritePixels[] var5;
        if (!KitDefinition.method796(var0, var3, var4)) {
            var5 = null;
        } else {
            SpritePixels[] var7 = new SpritePixels[class83.SpriteBuffer_spriteCount];

            for (int var8 = 0; var8 < class83.SpriteBuffer_spriteCount; ++var8) {
                SpritePixels var9 = var7[var8] = new SpritePixels();
                var9.width = class83.SpriteBuffer_spriteWidth;
                var9.height = class83.SpriteBuffer_spriteHeight;
                var9.xOffset = class83.SpriteBuffer_xOffsets[var8];
                var9.yOffset = class165.SpriteBuffer_yOffsets[var8];
                var9.subWidth = class112.SpriteBuffer_spriteWidths[var8];
                var9.subHeight = class83.SpriteBuffer_spriteHeights[var8];
                int var10 = var9.subHeight * var9.subWidth;
                byte[] var11 = class145.SpriteBuffer_pixels[var8];
                var9.pixels = new int[var10];

                for (int var12 = 0; var12 < var10; ++var12) {
                    var9.pixels[var12] = FloorUnderlayDefinition.SpriteBuffer_spritePalette[var11[var12] & 255];
                }
            }

            FileSystem.method1515();
            var5 = var7;
        }

        return var5;
    }

    static final void method1461() {
        if (Client.logoutTimer > 0) {
            Canvas.method1655();
        } else {
            NPC.updateGameState(40);
            EnumComposition.field978 = GraphicsObject.gameSocket;
            GraphicsObject.gameSocket = null;
        }
    }
}
