package osrs;

public final class class130 {
    public static Widget getWidget(int var0) {
        int var1 = var0 >> 16;
        int var2 = var0 & '\uffff';
        if (Widget.Widget_interfaceComponents[var1] == null || Widget.Widget_interfaceComponents[var1][var2] == null) {
            boolean var3 = EnumComposition.method852(var1);
            if (!var3) {
                return null;
            }
        }

        return Widget.Widget_interfaceComponents[var1][var2];
    }
}
