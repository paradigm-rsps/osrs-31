package osrs;

public class MusicPatchPcmStream extends PcmStream {
    public static NetFileRequest NetCache_currentResponse;
    MidiPcmStream superStream;
    NodeDeque queue = new NodeDeque();
    PcmStreamMixer mixer = new PcmStreamMixer();

    MusicPatchPcmStream(MidiPcmStream var1) {
        this.superStream = var1;
    }

    void method3049(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
        if ((this.superStream.field2384[var1.field2426] & 4) != 0 && var1.field2443 < 0) {
            int var6 = this.superStream.field2381[var1.field2426] / PcmPlayer.field1099;

            while (true) {
                int var7 = (var6 + 1048575 - var1.field2442) / var6;
                if (var7 > var4) {
                    var1.field2442 += var4 * var6;
                    break;
                }

                var1.stream.vmethod3045(var2, var3, var7);
                var3 += var7;
                var4 -= var7;
                var1.field2442 += var6 * var7 - 1048576;
                int var8 = PcmPlayer.field1099 / 100;
                int var9 = 262144 / var6;
                if (var9 < var8) {
                    var8 = var9;
                }

                RawPcmStream var10 = var1.stream;
                if (this.superStream.field2379[var1.field2426] == 0) {
                    var1.stream = RawPcmStream.method979(var1.rawSound, var10.method994(), var10.method1043(), var10.method986());
                } else {
                    var1.stream = RawPcmStream.method979(var1.rawSound, var10.method994(), 0, var10.method986());
                    this.superStream.method2927(var1, var1.patch.field2352[var1.field2427] < 0);
                    var1.stream.method990(var8, var10.method1043());
                }

                if (var1.patch.field2352[var1.field2427] < 0) {
                    var1.stream.method1055(-1);
                }

                var10.method992(var8);
                var10.vmethod3045(var2, var3, var5 - var3);
                if (var10.method996()) {
                    this.mixer.method1126(var10);
                }
            }
        }

        var1.stream.vmethod3045(var2, var3, var4);
    }

    void method3050(MusicPatchNode var1, int var2) {
        if ((this.superStream.field2384[var1.field2426] & 4) != 0 && var1.field2443 < 0) {
            int var3 = this.superStream.field2381[var1.field2426] / PcmPlayer.field1099;
            int var4 = (var3 + 1048575 - var1.field2442) / var3;
            var1.field2442 = var3 * var2 + var1.field2442 & 1048575;
            if (var4 <= var2) {
                if (this.superStream.field2379[var1.field2426] == 0) {
                    var1.stream = RawPcmStream.method979(var1.rawSound, var1.stream.method994(), var1.stream.method1043(), var1.stream.method986());
                } else {
                    var1.stream = RawPcmStream.method979(var1.rawSound, var1.stream.method994(), 0, var1.stream.method986());
                    this.superStream.method2927(var1, var1.patch.field2352[var1.field2427] < 0);
                }

                if (var1.patch.field2352[var1.field2427] < 0) {
                    var1.stream.method1055(-1);
                }

                var2 = var1.field2442 / var3;
            }
        }

        var1.stream.vmethod3048(var2);
    }

    protected PcmStream vmethod3061() {
        MusicPatchNode var1 = (MusicPatchNode) this.queue.method3533();
        if (var1 == null) {
            return null;
        } else {
            return var1.stream != null ? var1.stream : this.vmethod3052();
        }
    }

    protected PcmStream vmethod3052() {
        MusicPatchNode var1;
        do {
            var1 = (MusicPatchNode) this.queue.method3535();
            if (var1 == null) {
                return null;
            }
        } while (var1.stream == null);

        return var1.stream;
    }

    protected int vmethod3046() {
        return 0;
    }

    protected void vmethod3045(int[] var1, int var2, int var3) {
        this.mixer.vmethod3045(var1, var2, var3);

        for (MusicPatchNode var6 = (MusicPatchNode) this.queue.method3533(); var6 != null; var6 = (MusicPatchNode) this.queue.method3535()) {
            if (!this.superStream.method2948(var6)) {
                int var4 = var2;
                int var5 = var3;

                do {
                    if (var5 <= var6.field2441) {
                        this.method3049(var6, var1, var4, var5, var5 + var4);
                        var6.field2441 -= var5;
                        break;
                    }

                    this.method3049(var6, var1, var4, var6.field2441, var5 + var4);
                    var4 += var6.field2441;
                    var5 -= var6.field2441;
                } while (!this.superStream.method2949(var6, var1, var4, var5));
            }
        }

    }

    protected void vmethod3048(int var1) {
        this.mixer.vmethod3048(var1);

        for (MusicPatchNode var3 = (MusicPatchNode) this.queue.method3533(); var3 != null; var3 = (MusicPatchNode) this.queue.method3535()) {
            if (!this.superStream.method2948(var3)) {
                int var2 = var1;

                do {
                    if (var2 <= var3.field2441) {
                        this.method3050(var3, var2);
                        var3.field2441 -= var2;
                        break;
                    }

                    this.method3050(var3, var3.field2441);
                    var2 -= var3.field2441;
                } while (!this.superStream.method2949(var3, null, 0, var2));
            }
        }

    }
}
