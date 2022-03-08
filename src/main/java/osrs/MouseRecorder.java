package osrs;

public class MouseRecorder implements Runnable {
    public static AbstractRasterProvider field262;
    static SpritePixels sceneMinimapSprite;
    static Archive archive8;
    static int OSRS_PORT;
    static SpritePixels[] headIconPrayerSprites;
    static int cameraYaw;
    boolean isRunning = true;
    Object lock = new Object();
    int index = 0;
    int[] xs = new int[500];
    int[] ys = new int[500];

    public void run() {
        for (; this.isRunning; AnimationDefinition.sleepWeird(50L)) {
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

    public static int method167(Buffer var0, String var1) {
        int var2 = var0.offset;
        byte[] var3 = WallDecoration.method2385(var1);
        var0.writeSmartByteShort(var3.length);
        var0.offset += class183.huffman.method2571(var3, 0, var3.length, var0.array, var0.offset);
        return var0.offset - var2;
    }

    static void method171(int var0, int var1) {
        if (Client.field718 != 0 && var0 != -1) {
            class161.method3399(World.archive11, var0, 0, Client.field718, false);
            Client.field562 = true;
        }

    }
}
