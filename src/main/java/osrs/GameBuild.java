package osrs;

import java.io.IOException;

public class GameBuild {
    public static final GameBuild LIVE = new GameBuild("LIVE", 0);
    public static final GameBuild BUILDLIVE = new GameBuild("BUILDLIVE", 3);
    public static final GameBuild RC = new GameBuild("RC", 1);
    public static final GameBuild WIP = new GameBuild("WIP", 2);
    public final String name;
    public final int buildId;

    GameBuild(String var1, int var2) {
        this.name = var1;
        this.buildId = var2;
    }

    static ClientPreferences method2852() {
        AccessFile var0 = null;
        ClientPreferences var1 = new ClientPreferences();

        try {
            var0 = Tiles.method110("", Client.field484.name, false);
            byte[] var2 = new byte[(int) var0.method578()];

            int var4;
            for (int var3 = 0; var3 < var2.length; var3 += var4) {
                var4 = var0.method584(var2, var3, var2.length - var3);
                if (var4 == -1) {
                    throw new IOException();
                }
            }

            var1 = new ClientPreferences(new Buffer(var2));
        } catch (Exception var6) {
        }

        try {
            if (var0 != null) {
                var0.method586();
            }
        } catch (Exception var5) {
        }

        return var1;
    }
}
