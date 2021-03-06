package osrs;

public class PcmStreamMixer extends PcmStream {
    NodeDeque subStreams = new NodeDeque();
    NodeDeque field1068 = new NodeDeque();
    int field1070 = 0;
    int field1071 = -1;

    public final synchronized void method1126(PcmStream var1) {
        this.subStreams.method3529(var1);
    }

    public final synchronized void method1127(PcmStream var1) {
        var1.remove();
    }

    void method1151() {
        if (this.field1070 > 0) {
            for (PcmStreamMixerListener var1 = (PcmStreamMixerListener) this.field1068.method3533(); var1 != null; var1 = (PcmStreamMixerListener) this.field1068.method3535()) {
                var1.field1225 -= this.field1070;
            }

            this.field1071 -= this.field1070;
            this.field1070 = 0;
        }

    }

    void method1129(Node var1, PcmStreamMixerListener var2) {
        while (this.field1068.sentinel != var1 && ((PcmStreamMixerListener) var1).field1225 <= var2.field1225) {
            var1 = var1.previous;
        }

        NodeDeque.method3530(var2, var1);
        this.field1071 = ((PcmStreamMixerListener) this.field1068.sentinel.previous).field1225;
    }

    void method1137(PcmStreamMixerListener var1) {
        var1.remove();
        var1.method1394();
        Node var2 = this.field1068.sentinel.previous;
        if (var2 == this.field1068.sentinel) {
            this.field1071 = -1;
        } else {
            this.field1071 = ((PcmStreamMixerListener) var2).field1225;
        }

    }

    void method1135(int[] var1, int var2, int var3) {
        for (PcmStream var4 = (PcmStream) this.subStreams.method3533(); var4 != null; var4 = (PcmStream) this.subStreams.method3535()) {
            var4.method1170(var1, var2, var3);
        }

    }

    void method1157(int var1) {
        for (PcmStream var2 = (PcmStream) this.subStreams.method3533(); var2 != null; var2 = (PcmStream) this.subStreams.method3535()) {
            var2.vmethod3048(var1);
        }

    }

    protected PcmStream vmethod3061() {
        return (PcmStream) this.subStreams.method3533();
    }

    protected PcmStream vmethod3052() {
        return (PcmStream) this.subStreams.method3535();
    }

    protected int vmethod3046() {
        return 0;
    }

    public final synchronized void vmethod3045(int[] var1, int var2, int var3) {
        do {
            if (this.field1071 < 0) {
                this.method1135(var1, var2, var3);
                return;
            }

            if (var3 + this.field1070 < this.field1071) {
                this.field1070 += var3;
                this.method1135(var1, var2, var3);
                return;
            }

            int var4 = this.field1071 - this.field1070;
            this.method1135(var1, var2, var4);
            var2 += var4;
            var3 -= var4;
            this.field1070 += var4;
            this.method1151();
            PcmStreamMixerListener var5 = (PcmStreamMixerListener) this.field1068.method3533();
            synchronized (var5) {
                int var7 = var5.method1395();
                if (var7 < 0) {
                    var5.field1225 = 0;
                    this.method1137(var5);
                } else {
                    var5.field1225 = var7;
                    this.method1129(var5.previous, var5);
                }
            }
        } while (var3 != 0);

    }

    public final synchronized void vmethod3048(int var1) {
        do {
            if (this.field1071 < 0) {
                this.method1157(var1);
                return;
            }

            if (this.field1070 + var1 < this.field1071) {
                this.field1070 += var1;
                this.method1157(var1);
                return;
            }

            int var2 = this.field1071 - this.field1070;
            this.method1157(var2);
            var1 -= var2;
            this.field1070 += var2;
            this.method1151();
            PcmStreamMixerListener var3 = (PcmStreamMixerListener) this.field1068.method3533();
            synchronized (var3) {
                int var5 = var3.method1395();
                if (var5 < 0) {
                    var3.field1225 = 0;
                    this.method1137(var3);
                } else {
                    var3.field1225 = var5;
                    this.method1129(var3.previous, var3);
                }
            }
        } while (var1 != 0);

    }
}
