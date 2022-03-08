package osrs;

public class Varps {
    public static int[] Varps_masks = new int[32];
    public static int[] Varps_temp;
    public static int[] Varps_main;

    static {
        int var0 = 2;

        for (int var1 = 0; var1 < 32; ++var1) {
            Varps_masks[var1] = var0 - 1;
            var0 += var0;
        }

        Varps_temp = new int[2000];
        Varps_main = new int[2000];
    }
}
