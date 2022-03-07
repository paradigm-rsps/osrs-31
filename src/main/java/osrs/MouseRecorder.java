package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
    @ObfuscatedName("pd")
    @ObfuscatedSignature(
            descriptor = "Lclass84;"
    )
    public static AbstractRasterProvider field262;
    @ObfuscatedName("ms")
    @Export("sceneMinimapSprite")
    @ObfuscatedSignature(
            descriptor = "Lclass85;"
    )
    static SpritePixels sceneMinimapSprite;
    @ObfuscatedName("ay")
    @Export("archive8")
    @ObfuscatedSignature(
            descriptor = "Lclass153;"
    )
    static Archive archive8;
    @ObfuscatedName("bm")
    static int OSRS_PORT;
    @ObfuscatedName("ed")
    @Export("headIconPrayerSprites")
    @ObfuscatedSignature(
            descriptor = "[Lclass85;"
    )
    static SpritePixels[] headIconPrayerSprites;
    @ObfuscatedName("fa")
    @Export("cameraYaw")
    static int cameraYaw;
    @ObfuscatedName("i")
    @Export("isRunning")
    boolean isRunning = true;
    @ObfuscatedName("w")
    @Export("lock")
    Object lock = new Object();
    @ObfuscatedName("f")
    @Export("index")
    int index = 0;
    @ObfuscatedName("e")
    @Export("xs")
    int[] xs = new int[500];
    @ObfuscatedName("t")
    @Export("ys")
    int[] ys = new int[500];

    public void run() {
        for (; this.isRunning; SequenceDefinition.sleepWeird(50L)) {
            Object var1 = this.lock;
            synchronized (this.lock) {
                if (this.index < 500) {
                    this.xs[this.index] = MouseHandler.MouseHandler_x;
                    this.ys[this.index] = MouseHandler.MouseHandler_y;
                    ++this.index;
                }
            }
        }

    }

    @ObfuscatedName("w")
    @Export("method168")
    static void method168(int var0) {
        if (var0 != -1) {
            if (EnumComposition.method852(var0)) {
                Widget[] var1 = Widget.Widget_interfaceComponents[var0];

                for (int var2 = 0; var2 < var1.length; ++var2) {
                    Widget var3 = var1[var2];
                    if (var3.onLoad != null) {
                        ScriptEvent var4 = new ScriptEvent();
                        var4.widget = var3;
                        var4.args = var3.onLoad;
                        Renderable.method2040(var4);
                    }
                }

            }
        }
    }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lclass126;Ljava/lang/String;)I"
    )
    public static int method167(Buffer var0, String var1) {
        int var2 = var0.offset;
        byte[] var3 = WallDecoration.method2385(var1);
        var0.writeSmartByteShort(var3.length);
        var0.offset += class183.huffman.method2571(var3, 0, var3.length, var0.array, var0.offset);
        return var0.offset - var2;
    }

    @ObfuscatedName("ae")
    static void method171(int var0, int var1) {
        if (Client.field718 != 0 && var0 != -1) {
            class161.method3399(World.archive11, var0, 0, Client.field718, false);
            Client.field562 = true;
        }

    }
}
