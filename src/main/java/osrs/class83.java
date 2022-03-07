package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class83 {
    @ObfuscatedName("i")
    @Export("SpriteBuffer_spriteCount")
    static int SpriteBuffer_spriteCount;
    @ObfuscatedName("w")
    @Export("SpriteBuffer_spriteWidth")
    static int SpriteBuffer_spriteWidth;
    @ObfuscatedName("f")
    @Export("SpriteBuffer_spriteHeight")
    static int SpriteBuffer_spriteHeight;
    @ObfuscatedName("e")
    @Export("SpriteBuffer_xOffsets")
    static int[] SpriteBuffer_xOffsets;
    @ObfuscatedName("p")
    @Export("SpriteBuffer_spriteHeights")
    static int[] SpriteBuffer_spriteHeights;
    @ObfuscatedName("aj")
    @Export("archive4")
    @ObfuscatedSignature(
            descriptor = "Lclass153;"
    )
    static Archive archive4;

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)Lclass32;"
    )
    public static FloorUnderlayDefinition method1798(int var0) {
        FloorUnderlayDefinition var1 = (FloorUnderlayDefinition) FloorUnderlayDefinition.HitSplatDefinition_cachedFonts.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.method3204(1, var0);
            var1 = new FloorUnderlayDefinition();
            if (var2 != null) {
                var1.method701(new Buffer(var2), var0);
            }

            var1.method700();
            FloorUnderlayDefinition.HitSplatDefinition_cachedFonts.method3473(var1, var0);
            return var1;
        }
    }

    @ObfuscatedName("by")
    static final void updatePlayers() {
        for (int var0 = 0; var0 < Client.playersCount; ++var0) {
            int playerIndex = Client.playersIndex[var0];
            Player player = Client.players[playerIndex];
            int flag = Client.serverPacketBuf.readUnsignedByte();
            if ((flag & 32) != 0) {
                flag += Client.serverPacketBuf.readUnsignedByte() << 8;
            }

            class1.updatePlayer(playerIndex, player, flag);
        }
    }
}
