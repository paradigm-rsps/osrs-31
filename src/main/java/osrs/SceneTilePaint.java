package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cl")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
    @ObfuscatedName("ng")
    static int field1681;
    @ObfuscatedName("i")
    @Export("swColor")
    int swColor;
    @ObfuscatedName("w")
    @Export("seColor")
    int seColor;
    @ObfuscatedName("f")
    @Export("neColor")
    int neColor;
    @ObfuscatedName("e")
    @Export("nwColor")
    int nwColor;
    @ObfuscatedName("t")
    @Export("texture")
    int texture;
    @ObfuscatedName("d")
    @Export("isFlat")
    boolean isFlat = true;
    @ObfuscatedName("p")
    @Export("rgb")
    int rgb;

    SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
        this.swColor = var1;
        this.seColor = var2;
        this.neColor = var3;
        this.nwColor = var4;
        this.texture = var5;
        this.rgb = var6;
        this.isFlat = var7;
    }

    @ObfuscatedName("t")
    public static void method2209() {
        Object var0 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
        synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
            if (ArchiveDiskActionHandler.field2565 != 0) {
                ArchiveDiskActionHandler.field2565 = 1;

                try {
                    ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
                } catch (InterruptedException var3) {
                }
            }

        }
    }

    @ObfuscatedName("au")
    static final void method2210(int var0, int var1, int var2, int var3, int var4, int var5) {
        int var6 = 2048 - var3 & 2047;
        int var7 = 2048 - var4 & 2047;
        int var8 = 0;
        int var9 = 0;
        int var10 = var5;
        int var11;
        int var12;
        int var13;
        if (var6 != 0) {
            var11 = Rasterizer3D.Rasterizer3D_sine[var6];
            var12 = Rasterizer3D.Rasterizer3D_cosine[var6];
            var13 = var9 * var12 - var11 * var5 >> 16;
            var10 = var5 * var12 + var9 * var11 >> 16;
            var9 = var13;
        }

        if (var7 != 0) {
            var11 = Rasterizer3D.Rasterizer3D_sine[var7];
            var12 = Rasterizer3D.Rasterizer3D_cosine[var7];
            var13 = var11 * var10 + var12 * var8 >> 16;
            var10 = var12 * var10 - var8 * var11 >> 16;
            var8 = var13;
        }

        Login.cameraX = var0 - var8;
        class22.cameraY = var1 - var9;
        class17.cameraZ = var2 - var10;
        NPC.cameraPitch = var3;
        MouseRecorder.cameraYaw = var4;
    }

    @ObfuscatedName("cx")
    @Export("method2208")
    static final void method2208(int var0, int var1) {
        if (EnumComposition.method852(var0)) {
            NPC.method254(Widget.Widget_interfaceComponents[var0], var1);
        }
    }
}
