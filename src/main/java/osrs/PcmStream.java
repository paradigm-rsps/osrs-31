package osrs;

public abstract class PcmStream extends Node {
    volatile boolean active = true;
    PcmStream after;
    int field1074;
    AbstractSound sound;

    int vmethod1184() {
        return 255;
    }

    protected abstract PcmStream vmethod3061();

    protected abstract PcmStream vmethod3052();

    protected abstract int vmethod3046();

    protected abstract void vmethod3045(int[] var1, int var2, int var3);

    protected abstract void vmethod3048(int var1);

    final void method1170(int[] var1, int var2, int var3) {
        if (this.active) {
            this.vmethod3045(var1, var2, var3);
        } else {
            this.vmethod3048(var3);
        }

    }
}
