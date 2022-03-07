package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
    @ObfuscatedName("i")
    @Export("musicPatches")
    @ObfuscatedSignature(
            descriptor = "Lclass174;"
    )
    NodeHashTable musicPatches = new NodeHashTable(128);
    @ObfuscatedName("f")
    int field2390 = 256;
    @ObfuscatedName("e")
    int field2365 = 1000000;
    @ObfuscatedName("t")
    int[] field2377 = new int[16];
    @ObfuscatedName("d")
    int[] field2373 = new int[16];
    @ObfuscatedName("p")
    int[] field2368 = new int[16];
    @ObfuscatedName("k")
    int[] field2369 = new int[16];
    @ObfuscatedName("r")
    int[] field2370 = new int[16];
    @ObfuscatedName("l")
    int[] field2371 = new int[16];
    @ObfuscatedName("a")
    int[] field2366 = new int[16];
    @ObfuscatedName("z")
    int[] field2367 = new int[16];
    @ObfuscatedName("s")
    int[] field2374 = new int[16];
    @ObfuscatedName("n")
    int[] field2384 = new int[16];
    @ObfuscatedName("q")
    int[] field2364 = new int[16];
    @ObfuscatedName("c")
    int[] field2378 = new int[16];
    @ObfuscatedName("h")
    int[] field2379 = new int[16];
    @ObfuscatedName("b")
    int[] field2380 = new int[16];
    @ObfuscatedName("y")
    int[] field2381 = new int[16];
    @ObfuscatedName("x")
    @ObfuscatedSignature(
            descriptor = "[[Lclass144;"
    )
    MusicPatchNode[][] field2382 = new MusicPatchNode[16][128];
    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "[[Lclass144;"
    )
    MusicPatchNode[][] field2383 = new MusicPatchNode[16][128];
    @ObfuscatedName("ae")
    @Export("midiFile")
    @ObfuscatedSignature(
            descriptor = "Lclass143;"
    )
    MidiFileReader midiFile = new MidiFileReader();
    @ObfuscatedName("aa")
    boolean field2385;
    @ObfuscatedName("ah")
    @Export("track")
    int track;
    @ObfuscatedName("aw")
    @Export("trackLength")
    int trackLength;
    @ObfuscatedName("an")
    long field2388;
    @ObfuscatedName("av")
    long field2389;
    @ObfuscatedName("ak")
    @Export("patchStream")
    @ObfuscatedSignature(
            descriptor = "Lclass142;"
    )
    MusicPatchPcmStream patchStream = new MusicPatchPcmStream(this);

    public MidiPcmStream() {
        this.method2935();
    }

    @ObfuscatedName("i")
    @Export("method2975")
    synchronized void method2975(int var1) {
        this.field2390 = var1;
    }

    @ObfuscatedName("w")
    int method2916() {
        return this.field2390;
    }

    @ObfuscatedName("e")
    @Export("method2917")
    @ObfuscatedSignature(
            descriptor = "(Lclass138;Lclass151;Lclass57;I)Z"
    )
    synchronized boolean method2917(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
        var1.method2895();
        boolean var5 = true;
        int[] var6 = null;
        if (var4 > 0) {
            var6 = new int[]{var4};
        }

        for (ByteArrayNode var7 = (ByteArrayNode) var1.table.method3515(); var7 != null; var7 = (ByteArrayNode) var1.table.method3516()) {
            int var8 = (int) var7.key;
            MusicPatch var9 = (MusicPatch) this.musicPatches.method3512(var8);
            if (var9 == null) {
                var9 = SoundSystem.method1327(var2, var8);
                if (var9 == null) {
                    var5 = false;
                    continue;
                }

                this.musicPatches.method3517(var9, var8);
            }

            if (!var9.method2907(var3, var7.byteArray, var6)) {
                var5 = false;
            }
        }

        if (var5) {
            var1.method2893();
        }

        return var5;
    }

    @ObfuscatedName("t")
    @Export("method2918")
    synchronized void method2918() {
        for (MusicPatch var1 = (MusicPatch) this.musicPatches.method3515(); var1 != null; var1 = (MusicPatch) this.musicPatches.method3516()) {
            var1.method2908();
        }

    }

    @ObfuscatedName("d")
    @Export("method2919")
    synchronized void method2919() {
        for (MusicPatch var1 = (MusicPatch) this.musicPatches.method3515(); var1 != null; var1 = (MusicPatch) this.musicPatches.method3516()) {
            var1.remove();
        }

    }

    @ObfuscatedName("p")
    @Export("method2920")
    @ObfuscatedSignature(
            descriptor = "(Lclass138;Z)V"
    )
    synchronized void method2920(MusicTrack var1, boolean var2) {
        this.method2951();
        this.midiFile.method3111(var1.midi);
        this.field2385 = var2;
        this.field2388 = 0L;
        int var3 = this.midiFile.method3068();

        for (int var4 = 0; var4 < var3; ++var4) {
            this.midiFile.method3070(var4);
            this.midiFile.method3073(var4);
            this.midiFile.method3071(var4);
        }

        this.track = this.midiFile.method3087();
        this.trackLength = this.midiFile.trackLengths[this.track];
        this.field2389 = this.midiFile.method3077(this.trackLength);
    }

    @ObfuscatedName("k")
    @Export("method2951")
    public synchronized void method2951() {
        this.midiFile.method3067();
        this.method2935();
    }

    @ObfuscatedName("r")
    @Export("method2922")
    public synchronized boolean method2922() {
        return this.midiFile.method3066();
    }

    @ObfuscatedName("l")
    public synchronized void method2940(int var1, int var2) {
        this.method2924(var1, var2);
    }

    @ObfuscatedName("a")
    void method2924(int var1, int var2) {
        this.field2369[var1] = var2;
        this.field2371[var1] = var2 & -128;
        this.method2925(var1, var2);
    }

    @ObfuscatedName("z")
    void method2925(int var1, int var2) {
        if (var2 != this.field2370[var1]) {
            this.field2370[var1] = var2;

            for (int var3 = 0; var3 < 128; ++var3) {
                this.field2383[var1][var3] = null;
            }
        }

    }

    @ObfuscatedName("s")
    void method2926(int var1, int var2, int var3) {
        this.method3024(var1, var2, 64);
        if ((this.field2384[var1] & 2) != 0) {
            for (MusicPatchNode var4 = (MusicPatchNode) this.patchStream.queue.method3554(); var4 != null; var4 = (MusicPatchNode) this.patchStream.queue.method3561()) {
                if (var4.field2426 == var1 && var4.field2443 < 0) {
                    this.field2382[var1][var4.field2427] = null;
                    this.field2382[var1][var2] = var4;
                    int var8 = (var4.field2436 * var4.field2432 >> 12) + var4.field2430;
                    var4.field2430 += var2 - var4.field2427 << 8;
                    var4.field2436 = var8 - var4.field2430;
                    var4.field2432 = 4096;
                    var4.field2427 = var2;
                    return;
                }
            }
        }

        MusicPatch var9 = (MusicPatch) this.musicPatches.method3512(this.field2370[var1]);
        if (var9 != null) {
            RawSound var5 = var9.rawSounds[var2];
            if (var5 != null) {
                MusicPatchNode var6 = new MusicPatchNode();
                var6.field2426 = var1;
                var6.patch = var9;
                var6.rawSound = var5;
                var6.field2425 = var9.field2355[var2];
                var6.field2439 = var9.field2356[var2];
                var6.field2427 = var2;
                var6.field2428 = var3 * var3 * var9.field2353[var2] * var9.field2351 + 1024 >> 11;
                var6.field2429 = var9.field2360[var2] & 255;
                var6.field2430 = (var2 << 8) - (var9.field2352[var2] & 32767);
                var6.field2434 = 0;
                var6.field2423 = 0;
                var6.field2440 = 0;
                var6.field2443 = -1;
                var6.field2437 = 0;
                if (this.field2379[var1] == 0) {
                    var6.stream = RawPcmStream.method979(var5, this.method2939(var6), this.method2992(var6), this.method3042(var6));
                } else {
                    var6.stream = RawPcmStream.method979(var5, this.method2939(var6), 0, this.method3042(var6));
                    this.method2927(var6, var9.field2352[var2] < 0);
                }

                if (var9.field2352[var2] < 0) {
                    var6.stream.method1055(-1);
                }

                if (var6.field2439 >= 0) {
                    MusicPatchNode var7 = this.field2383[var1][var6.field2439];
                    if (var7 != null && var7.field2443 < 0) {
                        this.field2382[var1][var7.field2427] = null;
                        var7.field2443 = 0;
                    }

                    this.field2383[var1][var6.field2439] = var6;
                }

                this.patchStream.queue.method3528(var6);
                this.field2382[var1][var2] = var6;
            }
        }
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            descriptor = "(Lclass144;Z)V"
    )
    void method2927(MusicPatchNode var1, boolean var2) {
        int var3 = var1.rawSound.samples.length;
        int var4;
        if (var2 && var1.rawSound.field1241) {
            int var5 = var3 + var3 - var1.rawSound.start;
            var4 = (int) ((long) this.field2379[var1.field2426] * (long) var5 >> 6);
            var3 <<= 8;
            if (var4 >= var3) {
                var4 = var3 + var3 - 1 - var4;
                var1.stream.method988();
            }
        } else {
            var4 = (int) ((long) var3 * (long) this.field2379[var1.field2426] >> 6);
        }

        var1.stream.method987(var4);
    }

    @ObfuscatedName("u")
    void method3024(int var1, int var2, int var3) {
        MusicPatchNode var4 = this.field2382[var1][var2];
        if (var4 != null) {
            this.field2382[var1][var2] = null;
            if ((this.field2384[var1] & 2) != 0) {
                for (MusicPatchNode var5 = (MusicPatchNode) this.patchStream.queue.method3533(); var5 != null; var5 = (MusicPatchNode) this.patchStream.queue.method3535()) {
                    if (var4.field2426 == var5.field2426 && var5.field2443 < 0 && var4 != var5) {
                        var4.field2443 = 0;
                        break;
                    }
                }
            } else {
                var4.field2443 = 0;
            }

        }
    }

    @ObfuscatedName("g")
    void method2929(int var1, int var2, int var3) {
    }

    @ObfuscatedName("o")
    void method2930(int var1, int var2) {
    }

    @ObfuscatedName("v")
    void method2931(int var1, int var2) {
        this.field2366[var1] = var2;
    }

    @ObfuscatedName("j")
    void method2932(int var1) {
        for (MusicPatchNode var2 = (MusicPatchNode) this.patchStream.queue.method3533(); var2 != null; var2 = (MusicPatchNode) this.patchStream.queue.method3535()) {
            if (var1 < 0 || var2.field2426 == var1) {
                if (var2.stream != null) {
                    var2.stream.method992(PcmPlayer.field1099 / 100);
                    if (var2.stream.method996()) {
                        this.patchStream.mixer.method1126(var2.stream);
                    }

                    var2.method3118();
                }

                if (var2.field2443 < 0) {
                    this.field2382[var2.field2426][var2.field2427] = null;
                }

                var2.remove();
            }
        }

    }

    @ObfuscatedName("n")
    void method3036(int var1) {
        if (var1 >= 0) {
            this.field2377[var1] = 12800;
            this.field2373[var1] = 8192;
            this.field2368[var1] = 16383;
            this.field2366[var1] = 8192;
            this.field2367[var1] = 0;
            this.field2374[var1] = 8192;
            this.method2936(var1);
            this.method3000(var1);
            this.field2384[var1] = 0;
            this.field2364[var1] = 32767;
            this.field2378[var1] = 256;
            this.field2379[var1] = 0;
            this.method2996(var1, 8192);
        } else {
            for (var1 = 0; var1 < 16; ++var1) {
                this.method3036(var1);
            }

        }
    }

    @ObfuscatedName("q")
    void method2978(int var1) {
        for (MusicPatchNode var2 = (MusicPatchNode) this.patchStream.queue.method3533(); var2 != null; var2 = (MusicPatchNode) this.patchStream.queue.method3535()) {
            if ((var1 < 0 || var2.field2426 == var1) && var2.field2443 < 0) {
                this.field2382[var2.field2426][var2.field2427] = null;
                var2.field2443 = 0;
            }
        }

    }

    @ObfuscatedName("c")
    void method2935() {
        this.method2932(-1);
        this.method3036(-1);

        int var1;
        for (var1 = 0; var1 < 16; ++var1) {
            this.field2370[var1] = this.field2369[var1];
        }

        for (var1 = 0; var1 < 16; ++var1) {
            this.field2371[var1] = this.field2369[var1] & -128;
        }

    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            descriptor = "()Lclass47;"
    )
    protected synchronized PcmStream vmethod3061() {
        return this.patchStream;
    }

    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "()Lclass47;"
    )
    protected synchronized PcmStream vmethod3052() {
        return null;
    }

    @ObfuscatedName("y")
    protected synchronized int vmethod3046() {
        return 0;
    }

    @ObfuscatedName("x")
    @Export("vmethod3045")
    protected synchronized void vmethod3045(int[] var1, int var2, int var3) {
        if (this.midiFile.method3066()) {
            int var4 = this.midiFile.division * this.field2365 / PcmPlayer.field1099;

            do {
                long var5 = this.field2388 + (long) var4 * (long) var3;
                if (this.field2389 - var5 >= 0L) {
                    this.field2388 = var5;
                    break;
                }

                int var7 = (int) (((long) var4 + (this.field2389 - this.field2388) - 1L) / (long) var4);
                this.field2388 += (long) var4 * (long) var7;
                this.patchStream.vmethod3045(var1, var2, var7);
                var2 += var7;
                var3 -= var7;
                this.method2947();
            } while (this.midiFile.method3066());
        }

        this.patchStream.vmethod3045(var1, var2, var3);
    }

    @ObfuscatedName("ao")
    @Export("vmethod3048")
    protected synchronized void vmethod3048(int var1) {
        if (this.midiFile.method3066()) {
            int var2 = this.midiFile.division * this.field2365 / PcmPlayer.field1099;

            do {
                long var3 = this.field2388 + (long) var1 * (long) var2;
                if (this.field2389 - var3 >= 0L) {
                    this.field2388 = var3;
                    break;
                }

                int var5 = (int) (((long) var2 + (this.field2389 - this.field2388) - 1L) / (long) var2);
                this.field2388 += (long) var5 * (long) var2;
                this.patchStream.vmethod3048(var5);
                var1 -= var5;
                this.method2947();
            } while (this.midiFile.method3066());
        }

        this.patchStream.vmethod3048(var1);
    }

    @ObfuscatedName("ae")
    void method2936(int var1) {
        if ((this.field2384[var1] & 2) != 0) {
            for (MusicPatchNode var2 = (MusicPatchNode) this.patchStream.queue.method3533(); var2 != null; var2 = (MusicPatchNode) this.patchStream.queue.method3535()) {
                if (var2.field2426 == var1 && this.field2382[var1][var2.field2427] == null && var2.field2443 < 0) {
                    var2.field2443 = 0;
                }
            }
        }

    }

    @ObfuscatedName("aa")
    void method3000(int var1) {
        if ((this.field2384[var1] & 4) != 0) {
            for (MusicPatchNode var2 = (MusicPatchNode) this.patchStream.queue.method3533(); var2 != null; var2 = (MusicPatchNode) this.patchStream.queue.method3535()) {
                if (var2.field2426 == var1) {
                    var2.field2442 = 0;
                }
            }
        }

    }

    @ObfuscatedName("ah")
    void method2914(int var1) {
        int var2 = var1 & 240;
        int var3;
        int var4;
        int var5;
        if (var2 == 128) {
            var3 = var1 & 15;
            var4 = var1 >> 8 & 127;
            var5 = var1 >> 16 & 127;
            this.method3024(var3, var4, var5);
        } else if (var2 == 144) {
            var3 = var1 & 15;
            var4 = var1 >> 8 & 127;
            var5 = var1 >> 16 & 127;
            if (var5 > 0) {
                this.method2926(var3, var4, var5);
            } else {
                this.method3024(var3, var4, 64);
            }

        } else if (var2 == 160) {
            var3 = var1 & 15;
            var4 = var1 >> 8 & 127;
            var5 = var1 >> 16 & 127;
            this.method2929(var3, var4, var5);
        } else if (var2 == 176) {
            var3 = var1 & 15;
            var4 = var1 >> 8 & 127;
            var5 = var1 >> 16 & 127;
            if (var4 == 0) {
                this.field2371[var3] = (var5 << 14) + (this.field2371[var3] & -2080769);
            }

            if (var4 == 32) {
                this.field2371[var3] = (var5 << 7) + (this.field2371[var3] & -16257);
            }

            if (var4 == 1) {
                this.field2367[var3] = (var5 << 7) + (this.field2367[var3] & -16257);
            }

            if (var4 == 33) {
                this.field2367[var3] = var5 + (this.field2367[var3] & -128);
            }

            if (var4 == 5) {
                this.field2374[var3] = (var5 << 7) + (this.field2374[var3] & -16257);
            }

            if (var4 == 37) {
                this.field2374[var3] = var5 + (this.field2374[var3] & -128);
            }

            if (var4 == 7) {
                this.field2377[var3] = (var5 << 7) + (this.field2377[var3] & -16257);
            }

            if (var4 == 39) {
                this.field2377[var3] = var5 + (this.field2377[var3] & -128);
            }

            if (var4 == 10) {
                this.field2373[var3] = (var5 << 7) + (this.field2373[var3] & -16257);
            }

            if (var4 == 42) {
                this.field2373[var3] = var5 + (this.field2373[var3] & -128);
            }

            if (var4 == 11) {
                this.field2368[var3] = (var5 << 7) + (this.field2368[var3] & -16257);
            }

            if (var4 == 43) {
                this.field2368[var3] = var5 + (this.field2368[var3] & -128);
            }

            if (var4 == 64) {
                if (var5 >= 64) {
                    this.field2384[var3] |= 1;
                } else {
                    this.field2384[var3] &= -2;
                }
            }

            if (var4 == 65) {
                if (var5 >= 64) {
                    this.field2384[var3] |= 2;
                } else {
                    this.method2936(var3);
                    this.field2384[var3] &= -3;
                }
            }

            if (var4 == 99) {
                this.field2364[var3] = (var5 << 7) + (this.field2364[var3] & 127);
            }

            if (var4 == 98) {
                this.field2364[var3] = (this.field2364[var3] & 16256) + var5;
            }

            if (var4 == 101) {
                this.field2364[var3] = (var5 << 7) + (this.field2364[var3] & 127) + 16384;
            }

            if (var4 == 100) {
                this.field2364[var3] = (this.field2364[var3] & 16256) + var5 + 16384;
            }

            if (var4 == 120) {
                this.method2932(var3);
            }

            if (var4 == 121) {
                this.method3036(var3);
            }

            if (var4 == 123) {
                this.method2978(var3);
            }

            int var6;
            if (var4 == 6) {
                var6 = this.field2364[var3];
                if (var6 == 16384) {
                    this.field2378[var3] = (var5 << 7) + (this.field2378[var3] & -16257);
                }
            }

            if (var4 == 38) {
                var6 = this.field2364[var3];
                if (var6 == 16384) {
                    this.field2378[var3] = var5 + (this.field2378[var3] & -128);
                }
            }

            if (var4 == 16) {
                this.field2379[var3] = (var5 << 7) + (this.field2379[var3] & -16257);
            }

            if (var4 == 48) {
                this.field2379[var3] = var5 + (this.field2379[var3] & -128);
            }

            if (var4 == 81) {
                if (var5 >= 64) {
                    this.field2384[var3] |= 4;
                } else {
                    this.method3000(var3);
                    this.field2384[var3] &= -5;
                }
            }

            if (var4 == 17) {
                this.method2996(var3, (var5 << 7) + (this.field2380[var3] & -16257));
            }

            if (var4 == 49) {
                this.method2996(var3, var5 + (this.field2380[var3] & -128));
            }

        } else if (var2 == 192) {
            var3 = var1 & 15;
            var4 = var1 >> 8 & 127;
            this.method2925(var3, var4 + this.field2371[var3]);
        } else if (var2 == 208) {
            var3 = var1 & 15;
            var4 = var1 >> 8 & 127;
            this.method2930(var3, var4);
        } else if (var2 == 224) {
            var3 = var1 & 15;
            var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
            this.method2931(var3, var4);
        } else {
            var2 = var1 & 255;
            if (var2 == 255) {
                this.method2935();
            }
        }
    }

    @ObfuscatedName("aw")
    void method2996(int var1, int var2) {
        this.field2380[var1] = var2;
        this.field2381[var1] = (int) (2097152.0D * Math.pow(2.0D, (double) var2 * 5.4931640625E-4D) + 0.5D);
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lclass144;)I"
    )
    int method2939(MusicPatchNode var1) {
        int var2 = (var1.field2436 * var1.field2432 >> 12) + var1.field2430;
        var2 += (this.field2366[var1.field2426] - 8192) * this.field2378[var1.field2426] >> 12;
        MusicPatchNode2 var3 = var1.field2425;
        int var4;
        if (var3.field2392 > 0 && (var3.field2397 > 0 || this.field2367[var1.field2426] > 0)) {
            var4 = var3.field2397 << 2;
            int var5 = var3.field2399 << 1;
            if (var1.field2438 < var5) {
                var4 = var4 * var1.field2438 / var5;
            }

            var4 += this.field2367[var1.field2426] >> 7;
            double var6 = Math.sin((double) (var1.field2435 & 511) * 0.01227184630308513D);
            var2 += (int) ((double) var4 * var6);
        }

        var4 = (int) ((double) (var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double) var2 * 3.255208333333333E-4D) / (double) PcmPlayer.field1099 + 0.5D);
        return var4 < 1 ? 1 : var4;
    }

    @ObfuscatedName("av")
    @ObfuscatedSignature(
            descriptor = "(Lclass144;)I"
    )
    int method2992(MusicPatchNode var1) {
        MusicPatchNode2 var2 = var1.field2425;
        int var3 = this.field2368[var1.field2426] * this.field2377[var1.field2426] + 4096 >> 13;
        var3 = var3 * var3 + 16384 >> 15;
        var3 = var3 * var1.field2428 + 16384 >> 15;
        var3 = var3 * this.field2390 + 128 >> 8;
        if (var2.field2393 > 0) {
            var3 = (int) ((double) var3 * Math.pow(0.5D, (double) var2.field2393 * (double) var1.field2434 * 1.953125E-5D) + 0.5D);
        }

        int var4;
        int var5;
        int var6;
        int var7;
        if (var2.field2401 != null) {
            var4 = var1.field2423;
            var5 = var2.field2401[var1.field2440 + 1];
            if (var1.field2440 < var2.field2401.length - 2) {
                var6 = (var2.field2401[var1.field2440] & 255) << 8;
                var7 = (var2.field2401[var1.field2440 + 2] & 255) << 8;
                var5 += (var2.field2401[var1.field2440 + 3] - var5) * (var4 - var6) / (var7 - var6);
            }

            var3 = var3 * var5 + 32 >> 6;
        }

        if (var1.field2443 > 0 && var2.field2398 != null) {
            var4 = var1.field2443;
            var5 = var2.field2398[var1.field2437 + 1];
            if (var1.field2437 < var2.field2398.length - 2) {
                var6 = (var2.field2398[var1.field2437] & 255) << 8;
                var7 = (var2.field2398[var1.field2437 + 2] & 255) << 8;
                var5 += (var2.field2398[var1.field2437 + 3] - var5) * (var4 - var6) / (var7 - var6);
            }

            var3 = var3 * var5 + 32 >> 6;
        }

        return var3;
    }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            descriptor = "(Lclass144;)I"
    )
    int method3042(MusicPatchNode var1) {
        int var2 = this.field2373[var1.field2426];
        return var2 < 8192 ? var2 * var1.field2429 + 32 >> 6 : 16384 - ((128 - var1.field2429) * (16384 - var2) + 32 >> 6);
    }

    @ObfuscatedName("ax")
    void method2947() {
        int var1 = this.track;
        int var2 = this.trackLength;

        long var3;
        for (var3 = this.field2389; var2 == this.trackLength; var3 = this.midiFile.method3077(var2)) {
            while (var2 == this.midiFile.trackLengths[var1]) {
                this.midiFile.method3070(var1);
                int var5 = this.midiFile.method3074(var1);
                if (var5 == 1) {
                    this.midiFile.method3083();
                    this.midiFile.method3071(var1);
                    if (this.midiFile.method3079()) {
                        if (!this.field2385 || var2 == 0) {
                            this.method2935();
                            this.midiFile.method3067();
                            return;
                        }

                        this.midiFile.method3080(var3);
                    }
                    break;
                }

                if ((var5 & 128) != 0) {
                    this.method2914(var5);
                }

                this.midiFile.method3073(var1);
                this.midiFile.method3071(var1);
            }

            var1 = this.midiFile.method3087();
            var2 = this.midiFile.trackLengths[var1];
        }

        this.track = var1;
        this.trackLength = var2;
        this.field2389 = var3;
    }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(Lclass144;)Z"
    )
    boolean method2948(MusicPatchNode var1) {
        if (var1.stream == null) {
            if (var1.field2443 >= 0) {
                var1.remove();
                if (var1.field2439 > 0 && var1 == this.field2383[var1.field2426][var1.field2439]) {
                    this.field2383[var1.field2426][var1.field2439] = null;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lclass144;[III)Z"
    )
    boolean method2949(MusicPatchNode var1, int[] var2, int var3, int var4) {
        var1.field2441 = PcmPlayer.field1099 / 100;
        if (var1.field2443 < 0 || var1.stream != null && !var1.stream.method995()) {
            int var5 = var1.field2432;
            if (var5 > 0) {
                var5 -= (int) (16.0D * Math.pow(2.0D, (double) this.field2374[var1.field2426] * 4.921259842519685E-4D) + 0.5D);
                if (var5 < 0) {
                    var5 = 0;
                }

                var1.field2432 = var5;
            }

            var1.stream.method993(this.method2939(var1));
            MusicPatchNode2 var6 = var1.field2425;
            boolean var7 = false;
            ++var1.field2438;
            var1.field2435 += var6.field2392;
            double var8 = 5.086263020833333E-6D * (double) ((var1.field2427 - 60 << 8) + (var1.field2436 * var1.field2432 >> 12));
            if (var6.field2393 > 0) {
                if (var6.field2391 > 0) {
                    var1.field2434 += (int) (128.0D * Math.pow(2.0D, var8 * (double) var6.field2391) + 0.5D);
                } else {
                    var1.field2434 += 128;
                }
            }

            if (var6.field2401 != null) {
                if (var6.field2394 > 0) {
                    var1.field2423 += (int) (128.0D * Math.pow(2.0D, var8 * (double) var6.field2394) + 0.5D);
                } else {
                    var1.field2423 += 128;
                }

                while (var1.field2440 < var6.field2401.length - 2 && var1.field2423 > (var6.field2401[var1.field2440 + 2] & 255) << 8) {
                    var1.field2440 += 2;
                }

                if (var6.field2401.length - 2 == var1.field2440 && var6.field2401[var1.field2440 + 1] == 0) {
                    var7 = true;
                }
            }

            if (var1.field2443 >= 0 && var6.field2398 != null && (this.field2384[var1.field2426] & 1) == 0 && (var1.field2439 < 0 || var1 != this.field2383[var1.field2426][var1.field2439])) {
                if (var6.field2395 > 0) {
                    var1.field2443 += (int) (128.0D * Math.pow(2.0D, (double) var6.field2395 * var8) + 0.5D);
                } else {
                    var1.field2443 += 128;
                }

                while (var1.field2437 < var6.field2398.length - 2 && var1.field2443 > (var6.field2398[var1.field2437 + 2] & 255) << 8) {
                    var1.field2437 += 2;
                }

                if (var6.field2398.length - 2 == var1.field2437) {
                    var7 = true;
                }
            }

            if (var7) {
                var1.stream.method992(var1.field2441);
                if (var2 != null) {
                    var1.stream.vmethod3045(var2, var3, var4);
                } else {
                    var1.stream.vmethod3048(var4);
                }

                if (var1.stream.method996()) {
                    this.patchStream.mixer.method1126(var1.stream);
                }

                var1.method3118();
                if (var1.field2443 >= 0) {
                    var1.remove();
                    if (var1.field2439 > 0 && var1 == this.field2383[var1.field2426][var1.field2439]) {
                        this.field2383[var1.field2426][var1.field2439] = null;
                    }
                }

                return true;
            } else {
                var1.stream.method1061(var1.field2441, this.method2992(var1), this.method3042(var1));
                return false;
            }
        } else {
            var1.method3118();
            var1.remove();
            if (var1.field2439 > 0 && var1 == this.field2383[var1.field2426][var1.field2439]) {
                this.field2383[var1.field2426][var1.field2439] = null;
            }

            return true;
        }
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            descriptor = "(ILclass70;Lclass153;)V"
    )
    static void method2941(int var0, ArchiveDisk var1, Archive var2) {
        ArchiveDiskAction var3 = new ArchiveDiskAction();
        var3.type = 1;
        var3.key = var0;
        var3.archiveDisk = var1;
        var3.archive = var2;
        NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
        synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method3528(var3);
        }

        Object var9 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
        synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
            if (ArchiveDiskActionHandler.field2565 == 0) {
                ItemContainer.taskHandler.method1599(new ArchiveDiskActionHandler(), 5);
            }

            ArchiveDiskActionHandler.field2565 = 600;
        }
    }
}
