package osrs;

import java.awt.*;

public class class27 extends class177 {
    static PcmPlayer pcmPlayer1;
    int field756 = (int) (ClientPreferences.method148() / 1000L);
    String field749;
    short field751;

    class27(String var1, int var2) {
        this.field749 = var1;
        this.field751 = (short) var2;
    }

    public static ItemComposition method571(int var0) {
        ItemComposition var1 = (ItemComposition) ItemComposition.ItemDefinition_cached.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = ItemComposition.ItemDefinition_archive.method3204(10, var0);
            var1 = new ItemComposition();
            var1.id = var0;
            if (var2 != null) {
                var1.method856(new Buffer(var2));
            }

            var1.method855();
            if (var1.noteTemplate != -1) {
                var1.method892(method571(var1.noteTemplate), method571(var1.note));
            }

            if (!ItemComposition.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
                var1.name = "Members object";
                var1.groundActions = null;
                var1.inventoryActions = null;
                var1.team = 0;
            }

            ItemComposition.ItemDefinition_cached.method3473(var1, var0);
            return var1;
        }
    }

    static final void method570(String var0, boolean var1) {
        byte var2 = 4;
        int var3 = var2 + 6;
        int var4 = var2 + 6;
        int var5 = VertexNormal.field1511.method3604(var0, 250);
        int var6 = VertexNormal.field1511.method3672(var0, 250) * 13;
        Rasterizer2D.method1962(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 0);
        Rasterizer2D.method1995(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
        VertexNormal.field1511.method3609(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
        NPC.method266(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
        if (var1) {
            try {
                Graphics var7 = Tiles.field131.getGraphics();
                MouseRecorder.field262.vmethod1945(var7, 0, 0);
            } catch (Exception var13) {
                Tiles.field131.repaint();
            }
        } else {
            int var12 = var3;
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
                if (Client.rootWidgetXs[var11] + Client.rootWidgetWidths[var11] > var12 && Client.rootWidgetXs[var11] < var9 + var12 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var8 + var10) {
                    Client.field687[var11] = true;
                }
            }
        }

    }
}
