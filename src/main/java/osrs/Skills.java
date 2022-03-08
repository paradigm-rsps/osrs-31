package osrs;

public class Skills {
    public static final boolean[] Skills_enabled = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
    public static int[] Skills_experienceTable = new int[99];
    static Widget field2054;
    static int[] field2053;
    static World[] field2058;

    static {
        int var0 = 0;

        for (int var1 = 0; var1 < 99; ++var1) {
            int var2 = var1 + 1;
            int var3 = (int) ((double) var2 + 300.0D * Math.pow(2.0D, (double) var2 / 7.0D));
            var0 += var3;
            Skills_experienceTable[var1] = var0 / 4;
        }

    }
}
