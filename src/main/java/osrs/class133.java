package osrs;

public class class133 {
    public static int method2863(int var0) {
        VarbitComposition var2 = (VarbitComposition) VarbitComposition.VarbitDefinition_cached.method3474(var0);
        VarbitComposition var1;
        if (var2 != null) {
            var1 = var2;
        } else {
            byte[] var3 = VarbitComposition.VarbitDefinition_archive.method3204(14, var0);
            var2 = new VarbitComposition();
            if (var3 != null) {
                var2.method830(new Buffer(var3));
            }

            VarbitComposition.VarbitDefinition_cached.method3473(var2, var0);
            var1 = var2;
        }

        int var7 = var1.baseVar;
        int var4 = var1.startBit;
        int var5 = var1.endBit;
        int var6 = Varps.Varps_masks[var5 - var4];
        return Varps.Varps_main[var7] >> var4 & var6;
    }

    public static void method2862(AbstractArchive var0) {
        EnumComposition.field977 = var0;
    }
}
