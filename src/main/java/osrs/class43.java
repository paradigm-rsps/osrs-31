package osrs;

import java.awt.*;

public class class43 extends PcmPlayer {
    static class42 field1051;
    int field1052;

    class43(TaskHandler var1, int var2) {
        field1051 = var1.method1602();
        this.field1052 = var2;
    }

    void vmethod1234(Component var1) throws Exception {
        field1051.method939(var1, PcmPlayer.field1099, PcmPlayer.PcmPlayer_stereo, -1760138480);
    }

    void vmethod1235(int var1) throws Exception {
        if (var1 > 32768) {
            throw new IllegalArgumentException();
        } else {
            field1051.method943(this.field1052, var1, (byte) -28);
        }
    }

    int vmethod1233() {
        return field1051.method945(this.field1052, 34740438);
    }

    void vmethod1237() {
        field1051.method949(this.field1052, super.samples, (byte) 10);
    }

    void vmethod1238() {
        field1051.method937(this.field1052, 2146695330);
    }

    void vmethod1229() {
        field1051.method940(this.field1052, 1632443377);
    }
}
