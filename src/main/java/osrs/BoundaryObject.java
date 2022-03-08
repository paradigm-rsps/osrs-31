package osrs;

import java.awt.*;

public final class BoundaryObject {
    static MouseRecorder field1625;
    int tileHeight;
    int x;
    int y;
    int orientationA;
    int orientationB;
    public Renderable renderable1;
    public Renderable renderable2;
    public int packedId = 0;
    int flags = 0;

    public static AbstractRasterProvider method2204(int var0, int var1, Component var2) {
        try {
            RasterProvider var3 = new RasterProvider();
            var3.vmethod1940(var0, var1, var2);
            return var3;
        } catch (Throwable var5) {
            class82 var4 = new class82();
            var4.vmethod1940(var0, var1, var2);
            return var4;
        }
    }
}
