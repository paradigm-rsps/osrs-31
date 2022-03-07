package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
    @ObfuscatedName("i")
    int field1061;
    @ObfuscatedName("f")
    int field1058;
    @ObfuscatedName("e")
    int field1055;
    @ObfuscatedName("t")
    int field1056;
    @ObfuscatedName("d")
    int field1057;
    @ObfuscatedName("p")
    int field1067;
    @ObfuscatedName("k")
    int field1059;
    @ObfuscatedName("r")
    @Export("numLoops")
    int numLoops;
    @ObfuscatedName("l")
    @Export("start")
    int start;
    @ObfuscatedName("a")
    @Export("end")
    int end;
    @ObfuscatedName("z")
    boolean field1063;
    @ObfuscatedName("s")
    int field1064;
    @ObfuscatedName("m")
    int field1054;
    @ObfuscatedName("u")
    int field1066;
    @ObfuscatedName("g")
    int field1065;

    @ObfuscatedSignature(
            descriptor = "(Lclass62;III)V"
    )
    RawPcmStream(RawSound var1, int var2, int var3, int var4) {
        super.sound = var1;
        this.start = var1.start;
        this.end = var1.end;
        this.field1063 = var1.field1241;
        this.field1058 = var2;
        this.field1055 = var3;
        this.field1056 = var4;
        this.field1061 = 0;
        this.method980();
    }

    @ObfuscatedSignature(
            descriptor = "(Lclass62;II)V"
    )
    RawPcmStream(RawSound var1, int var2, int var3) {
        super.sound = var1;
        this.start = var1.start;
        this.end = var1.end;
        this.field1063 = var1.field1241;
        this.field1058 = var2;
        this.field1055 = var3;
        this.field1056 = 8192;
        this.field1061 = 0;
        this.method980();
    }

    @ObfuscatedName("f")
    int vmethod1184() {
        int var1 = this.field1057 * 3 >> 6;
        var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
        if (this.numLoops == 0) {
            var1 -= var1 * this.field1061 / (((RawSound) super.sound).samples.length << 8);
        } else if (this.numLoops >= 0) {
            var1 -= var1 * this.start / ((RawSound) super.sound).samples.length;
        }

        return var1 > 255 ? 255 : var1;
    }

    @ObfuscatedName("d")
    void method980() {
        this.field1057 = this.field1055;
        this.field1067 = method1112(this.field1055, this.field1056);
        this.field1059 = method1059(this.field1055, this.field1056);
    }

    @ObfuscatedName("p")
    @Export("method1055")
    public synchronized void method1055(int var1) {
        this.numLoops = var1;
    }

    @ObfuscatedName("k")
    public synchronized void method982(int var1) {
        this.method1070(var1 << 6, this.method986());
    }

    @ObfuscatedName("r")
    synchronized void method983(int var1) {
        this.method1070(var1, this.method986());
    }

    @ObfuscatedName("l")
    synchronized void method1070(int var1, int var2) {
        this.field1055 = var1;
        this.field1056 = var2;
        this.field1064 = 0;
        this.method980();
    }

    @ObfuscatedName("a")
    public synchronized int method1043() {
        return this.field1055 == Integer.MIN_VALUE ? 0 : this.field1055;
    }

    @ObfuscatedName("z")
    public synchronized int method986() {
        return this.field1056 < 0 ? -1 : this.field1056;
    }

    @ObfuscatedName("s")
    public synchronized void method987(int var1) {
        int var2 = ((RawSound) super.sound).samples.length << 8;
        if (var1 < -1) {
            var1 = -1;
        }

        if (var1 > var2) {
            var1 = var2;
        }

        this.field1061 = var1;
    }

    @ObfuscatedName("m")
    public synchronized void method988() {
        this.field1058 = (this.field1058 ^ this.field1058 >> 31) + (this.field1058 >>> 31);
        this.field1058 = -this.field1058;
    }

    @ObfuscatedName("u")
    void method989() {
        if (this.field1064 != 0) {
            if (this.field1055 == Integer.MIN_VALUE) {
                this.field1055 = 0;
            }

            this.field1064 = 0;
            this.method980();
        }

    }

    @ObfuscatedName("g")
    public synchronized void method990(int var1, int var2) {
        this.method1061(var1, var2, this.method986());
    }

    @ObfuscatedName("o")
    public synchronized void method1061(int var1, int var2, int var3) {
        if (var1 == 0) {
            this.method1070(var2, var3);
        } else {
            int var4 = method1112(var2, var3);
            int var5 = method1059(var2, var3);
            if (var4 == this.field1067 && var5 == this.field1059) {
                this.field1064 = 0;
            } else {
                int var6 = var2 - this.field1057;
                if (this.field1057 - var2 > var6) {
                    var6 = this.field1057 - var2;
                }

                if (var4 - this.field1067 > var6) {
                    var6 = var4 - this.field1067;
                }

                if (this.field1067 - var4 > var6) {
                    var6 = this.field1067 - var4;
                }

                if (var5 - this.field1059 > var6) {
                    var6 = var5 - this.field1059;
                }

                if (this.field1059 - var5 > var6) {
                    var6 = this.field1059 - var5;
                }

                if (var1 > var6) {
                    var1 = var6;
                }

                this.field1064 = var1;
                this.field1055 = var2;
                this.field1056 = var3;
                this.field1054 = (var2 - this.field1057) / var1;
                this.field1066 = (var4 - this.field1067) / var1;
                this.field1065 = (var5 - this.field1059) / var1;
            }
        }
    }

    @ObfuscatedName("v")
    public synchronized void method992(int var1) {
        if (var1 == 0) {
            this.method983(0);
            this.remove();
        } else if (this.field1067 == 0 && this.field1059 == 0) {
            this.field1064 = 0;
            this.field1055 = 0;
            this.field1057 = 0;
            this.remove();
        } else {
            int var2 = -this.field1057;
            if (this.field1057 > var2) {
                var2 = this.field1057;
            }

            if (-this.field1067 > var2) {
                var2 = -this.field1067;
            }

            if (this.field1067 > var2) {
                var2 = this.field1067;
            }

            if (-this.field1059 > var2) {
                var2 = -this.field1059;
            }

            if (this.field1059 > var2) {
                var2 = this.field1059;
            }

            if (var1 > var2) {
                var1 = var2;
            }

            this.field1064 = var1;
            this.field1055 = Integer.MIN_VALUE;
            this.field1054 = -this.field1057 / var1;
            this.field1066 = -this.field1067 / var1;
            this.field1065 = -this.field1059 / var1;
        }
    }

    @ObfuscatedName("j")
    public synchronized void method993(int var1) {
        if (this.field1058 < 0) {
            this.field1058 = -var1;
        } else {
            this.field1058 = var1;
        }

    }

    @ObfuscatedName("n")
    public synchronized int method994() {
        return this.field1058 < 0 ? -this.field1058 : this.field1058;
    }

    @ObfuscatedName("q")
    public boolean method995() {
        return this.field1061 < 0 || this.field1061 >= ((RawSound) super.sound).samples.length << 8;
    }

    @ObfuscatedName("c")
    public boolean method996() {
        return this.field1064 != 0;
    }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            descriptor = "()Lclass47;"
    )
    protected PcmStream vmethod3061() {
        return null;
    }

    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "()Lclass47;"
    )
    protected PcmStream vmethod3052() {
        return null;
    }

    @ObfuscatedName("y")
    protected int vmethod3046() {
        return this.field1055 == 0 && this.field1064 == 0 ? 0 : 1;
    }

    @ObfuscatedName("x")
    @Export("vmethod3045")
    public synchronized void vmethod3045(int[] var1, int var2, int var3) {
        if (this.field1055 == 0 && this.field1064 == 0) {
            this.vmethod3048(var3);
        } else {
            RawSound var4 = (RawSound) super.sound;
            int var5 = this.start << 8;
            int var6 = this.end << 8;
            int var7 = var4.samples.length << 8;
            int var8 = var6 - var5;
            if (var8 <= 0) {
                this.numLoops = 0;
            }

            int var9 = var2;
            var3 += var2;
            if (this.field1061 < 0) {
                if (this.field1058 <= 0) {
                    this.method989();
                    this.remove();
                    return;
                }

                this.field1061 = 0;
            }

            if (this.field1061 >= var7) {
                if (this.field1058 >= 0) {
                    this.method989();
                    this.remove();
                    return;
                }

                this.field1061 = var7 - 1;
            }

            if (this.numLoops < 0) {
                if (this.field1063) {
                    if (this.field1058 < 0) {
                        var9 = this.method1003(var1, var2, var5, var3, var4.samples[this.start]);
                        if (this.field1061 >= var5) {
                            return;
                        }

                        this.field1061 = var5 + var5 - 1 - this.field1061;
                        this.field1058 = -this.field1058;
                    }

                    while (true) {
                        var9 = this.method1119(var1, var9, var6, var3, var4.samples[this.end - 1]);
                        if (this.field1061 < var6) {
                            return;
                        }

                        this.field1061 = var6 + var6 - 1 - this.field1061;
                        this.field1058 = -this.field1058;
                        var9 = this.method1003(var1, var9, var5, var3, var4.samples[this.start]);
                        if (this.field1061 >= var5) {
                            return;
                        }

                        this.field1061 = var5 + var5 - 1 - this.field1061;
                        this.field1058 = -this.field1058;
                    }
                } else if (this.field1058 < 0) {
                    while (true) {
                        var9 = this.method1003(var1, var9, var5, var3, var4.samples[this.end - 1]);
                        if (this.field1061 >= var5) {
                            return;
                        }

                        this.field1061 = var6 - 1 - (var6 - 1 - this.field1061) % var8;
                    }
                } else {
                    while (true) {
                        var9 = this.method1119(var1, var9, var6, var3, var4.samples[this.start]);
                        if (this.field1061 < var6) {
                            return;
                        }

                        this.field1061 = var5 + (this.field1061 - var5) % var8;
                    }
                }
            } else {
                if (this.numLoops > 0) {
                    if (this.field1063) {
                        label127:
                        {
                            if (this.field1058 < 0) {
                                var9 = this.method1003(var1, var2, var5, var3, var4.samples[this.start]);
                                if (this.field1061 >= var5) {
                                    return;
                                }

                                this.field1061 = var5 + var5 - 1 - this.field1061;
                                this.field1058 = -this.field1058;
                                if (--this.numLoops == 0) {
                                    break label127;
                                }
                            }

                            do {
                                var9 = this.method1119(var1, var9, var6, var3, var4.samples[this.end - 1]);
                                if (this.field1061 < var6) {
                                    return;
                                }

                                this.field1061 = var6 + var6 - 1 - this.field1061;
                                this.field1058 = -this.field1058;
                                if (--this.numLoops == 0) {
                                    break;
                                }

                                var9 = this.method1003(var1, var9, var5, var3, var4.samples[this.start]);
                                if (this.field1061 >= var5) {
                                    return;
                                }

                                this.field1061 = var5 + var5 - 1 - this.field1061;
                                this.field1058 = -this.field1058;
                            } while (--this.numLoops != 0);
                        }
                    } else {
                        int var10;
                        if (this.field1058 < 0) {
                            while (true) {
                                var9 = this.method1003(var1, var9, var5, var3, var4.samples[this.end - 1]);
                                if (this.field1061 >= var5) {
                                    return;
                                }

                                var10 = (var6 - 1 - this.field1061) / var8;
                                if (var10 >= this.numLoops) {
                                    this.field1061 += var8 * this.numLoops;
                                    this.numLoops = 0;
                                    break;
                                }

                                this.field1061 += var8 * var10;
                                this.numLoops -= var10;
                            }
                        } else {
                            while (true) {
                                var9 = this.method1119(var1, var9, var6, var3, var4.samples[this.start]);
                                if (this.field1061 < var6) {
                                    return;
                                }

                                var10 = (this.field1061 - var5) / var8;
                                if (var10 >= this.numLoops) {
                                    this.field1061 -= var8 * this.numLoops;
                                    this.numLoops = 0;
                                    break;
                                }

                                this.field1061 -= var8 * var10;
                                this.numLoops -= var10;
                            }
                        }
                    }
                }

                if (this.field1058 < 0) {
                    this.method1003(var1, var9, 0, var3, 0);
                    if (this.field1061 < 0) {
                        this.field1061 = -1;
                        this.method989();
                        this.remove();
                    }
                } else {
                    this.method1119(var1, var9, var7, var3, 0);
                    if (this.field1061 >= var7) {
                        this.field1061 = var7;
                        this.method989();
                        this.remove();
                    }
                }

            }
        }
    }

    @ObfuscatedName("ao")
    @Export("vmethod3048")
    public synchronized void vmethod3048(int var1) {
        if (this.field1064 > 0) {
            if (var1 >= this.field1064) {
                if (this.field1055 == Integer.MIN_VALUE) {
                    this.field1055 = 0;
                    this.field1059 = 0;
                    this.field1067 = 0;
                    this.field1057 = 0;
                    this.remove();
                    var1 = this.field1064;
                }

                this.field1064 = 0;
                this.method980();
            } else {
                this.field1057 += this.field1054 * var1;
                this.field1067 += this.field1066 * var1;
                this.field1059 += this.field1065 * var1;
                this.field1064 -= var1;
            }
        }

        RawSound var2 = (RawSound) super.sound;
        int var3 = this.start << 8;
        int var4 = this.end << 8;
        int var5 = var2.samples.length << 8;
        int var6 = var4 - var3;
        if (var6 <= 0) {
            this.numLoops = 0;
        }

        if (this.field1061 < 0) {
            if (this.field1058 <= 0) {
                this.method989();
                this.remove();
                return;
            }

            this.field1061 = 0;
        }

        if (this.field1061 >= var5) {
            if (this.field1058 >= 0) {
                this.method989();
                this.remove();
                return;
            }

            this.field1061 = var5 - 1;
        }

        this.field1061 += this.field1058 * var1;
        if (this.numLoops < 0) {
            if (!this.field1063) {
                if (this.field1058 < 0) {
                    if (this.field1061 >= var3) {
                        return;
                    }

                    this.field1061 = var4 - 1 - (var4 - 1 - this.field1061) % var6;
                } else {
                    if (this.field1061 < var4) {
                        return;
                    }

                    this.field1061 = var3 + (this.field1061 - var3) % var6;
                }

            } else {
                if (this.field1058 < 0) {
                    if (this.field1061 >= var3) {
                        return;
                    }

                    this.field1061 = var3 + var3 - 1 - this.field1061;
                    this.field1058 = -this.field1058;
                }

                while (this.field1061 >= var4) {
                    this.field1061 = var4 + var4 - 1 - this.field1061;
                    this.field1058 = -this.field1058;
                    if (this.field1061 >= var3) {
                        return;
                    }

                    this.field1061 = var3 + var3 - 1 - this.field1061;
                    this.field1058 = -this.field1058;
                }

            }
        } else {
            if (this.numLoops > 0) {
                if (this.field1063) {
                    label129:
                    {
                        if (this.field1058 < 0) {
                            if (this.field1061 >= var3) {
                                return;
                            }

                            this.field1061 = var3 + var3 - 1 - this.field1061;
                            this.field1058 = -this.field1058;
                            if (--this.numLoops == 0) {
                                break label129;
                            }
                        }

                        do {
                            if (this.field1061 < var4) {
                                return;
                            }

                            this.field1061 = var4 + var4 - 1 - this.field1061;
                            this.field1058 = -this.field1058;
                            if (--this.numLoops == 0) {
                                break;
                            }

                            if (this.field1061 >= var3) {
                                return;
                            }

                            this.field1061 = var3 + var3 - 1 - this.field1061;
                            this.field1058 = -this.field1058;
                        } while (--this.numLoops != 0);
                    }
                } else {
                    label161:
                    {
                        int var7;
                        if (this.field1058 < 0) {
                            if (this.field1061 >= var3) {
                                return;
                            }

                            var7 = (var4 - 1 - this.field1061) / var6;
                            if (var7 >= this.numLoops) {
                                this.field1061 += var6 * this.numLoops;
                                this.numLoops = 0;
                                break label161;
                            }

                            this.field1061 += var6 * var7;
                            this.numLoops -= var7;
                        } else {
                            if (this.field1061 < var4) {
                                return;
                            }

                            var7 = (this.field1061 - var3) / var6;
                            if (var7 >= this.numLoops) {
                                this.field1061 -= var6 * this.numLoops;
                                this.numLoops = 0;
                                break label161;
                            }

                            this.field1061 -= var6 * var7;
                            this.numLoops -= var7;
                        }

                        return;
                    }
                }
            }

            if (this.field1058 < 0) {
                if (this.field1061 < 0) {
                    this.field1061 = -1;
                    this.method989();
                    this.remove();
                }
            } else if (this.field1061 >= var5) {
                this.field1061 = var5;
                this.method989();
                this.remove();
            }

        }
    }

    @ObfuscatedName("ae")
    int method1119(int[] var1, int var2, int var3, int var4, int var5) {
        while (true) {
            if (this.field1064 > 0) {
                int var6 = var2 + this.field1064;
                if (var6 > var4) {
                    var6 = var4;
                }

                this.field1064 += var2;
                if (this.field1058 == 256 && (this.field1061 & 255) == 0) {
                    if (PcmPlayer.PcmPlayer_stereo) {
                        var2 = method1124(0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1067, this.field1059, this.field1066, this.field1065, 0, var6, var3, this);
                    } else {
                        var2 = method1022(((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1057, this.field1054, 0, var6, var3, this);
                    }
                } else if (PcmPlayer.PcmPlayer_stereo) {
                    var2 = method976(0, 0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1067, this.field1059, this.field1066, this.field1065, 0, var6, var3, this, this.field1058, var5);
                } else {
                    var2 = method1017(0, 0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1057, this.field1054, 0, var6, var3, this, this.field1058, var5);
                }

                this.field1064 -= var2;
                if (this.field1064 != 0) {
                    return var2;
                }

                if (!this.method1014()) {
                    continue;
                }

                return var4;
            }

            if (this.field1058 == 256 && (this.field1061 & 255) == 0) {
                if (PcmPlayer.PcmPlayer_stereo) {
                    return method1006(0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1067, this.field1059, 0, var4, var3, this);
                }

                return method1005(((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1057, 0, var4, var3, this);
            }

            if (PcmPlayer.PcmPlayer_stereo) {
                return method1076(0, 0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1067, this.field1059, 0, var4, var3, this, this.field1058, var5);
            }

            return method1009(0, 0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1057, 0, var4, var3, this, this.field1058, var5);
        }
    }

    @ObfuscatedName("aa")
    int method1003(int[] var1, int var2, int var3, int var4, int var5) {
        while (true) {
            if (this.field1064 > 0) {
                int var6 = var2 + this.field1064;
                if (var6 > var4) {
                    var6 = var4;
                }

                this.field1064 += var2;
                if (this.field1058 == -256 && (this.field1061 & 255) == 0) {
                    if (PcmPlayer.PcmPlayer_stereo) {
                        var2 = method1056(0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1067, this.field1059, this.field1066, this.field1065, 0, var6, var3, this);
                    } else {
                        var2 = method1015(((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1057, this.field1054, 0, var6, var3, this);
                    }
                } else if (PcmPlayer.PcmPlayer_stereo) {
                    var2 = method1020(0, 0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1067, this.field1059, this.field1066, this.field1065, 0, var6, var3, this, this.field1058, var5);
                } else {
                    var2 = method1019(0, 0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1057, this.field1054, 0, var6, var3, this, this.field1058, var5);
                }

                this.field1064 -= var2;
                if (this.field1064 != 0) {
                    return var2;
                }

                if (!this.method1014()) {
                    continue;
                }

                return var4;
            }

            if (this.field1058 == -256 && (this.field1061 & 255) == 0) {
                if (PcmPlayer.PcmPlayer_stereo) {
                    return method1097(0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1067, this.field1059, 0, var4, var3, this);
                }

                return method1007(((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1057, 0, var4, var3, this);
            }

            if (PcmPlayer.PcmPlayer_stereo) {
                return method1012(0, 0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1067, this.field1059, 0, var4, var3, this, this.field1058, var5);
            }

            return method1044(0, 0, ((RawSound) super.sound).samples, var1, this.field1061, var2, this.field1057, 0, var4, var3, this, this.field1058, var5);
        }
    }

    @ObfuscatedName("ah")
    boolean method1014() {
        int var1 = this.field1055;
        int var2;
        int var3;
        if (var1 == Integer.MIN_VALUE) {
            var3 = 0;
            var2 = 0;
            var1 = 0;
        } else {
            var2 = method1112(var1, this.field1056);
            var3 = method1059(var1, this.field1056);
        }

        if (var1 == this.field1057 && var2 == this.field1067 && var3 == this.field1059) {
            if (this.field1055 == Integer.MIN_VALUE) {
                this.field1055 = 0;
                this.field1059 = 0;
                this.field1067 = 0;
                this.field1057 = 0;
                this.remove();
                return true;
            } else {
                this.method980();
                return false;
            }
        } else {
            if (this.field1057 < var1) {
                this.field1054 = 1;
                this.field1064 = var1 - this.field1057;
            } else if (this.field1057 > var1) {
                this.field1054 = -1;
                this.field1064 = this.field1057 - var1;
            } else {
                this.field1054 = 0;
            }

            if (this.field1067 < var2) {
                this.field1066 = 1;
                if (this.field1064 == 0 || this.field1064 > var2 - this.field1067) {
                    this.field1064 = var2 - this.field1067;
                }
            } else if (this.field1067 > var2) {
                this.field1066 = -1;
                if (this.field1064 == 0 || this.field1064 > this.field1067 - var2) {
                    this.field1064 = this.field1067 - var2;
                }
            } else {
                this.field1066 = 0;
            }

            if (this.field1059 < var3) {
                this.field1065 = 1;
                if (this.field1064 == 0 || this.field1064 > var3 - this.field1059) {
                    this.field1064 = var3 - this.field1059;
                }
            } else if (this.field1059 > var3) {
                this.field1065 = -1;
                if (this.field1064 == 0 || this.field1064 > this.field1059 - var3) {
                    this.field1064 = this.field1059 - var3;
                }
            } else {
                this.field1065 = 0;
            }

            return false;
        }
    }

    @ObfuscatedName("i")
    static int method1112(int var0, int var1) {
        return var1 < 0 ? var0 : (int) ((double) var0 * Math.sqrt((double) (16384 - var1) * 1.220703125E-4D) + 0.5D);
    }

    @ObfuscatedName("w")
    static int method1059(int var0, int var1) {
        return var1 < 0 ? -var0 : (int) ((double) var0 * Math.sqrt((double) var1 * 1.220703125E-4D) + 0.5D);
    }

    @ObfuscatedName("e")
    @Export("method1091")
    @ObfuscatedSignature(
            descriptor = "(Lclass62;II)Lclass44;"
    )
    public static RawPcmStream method1091(RawSound var0, int var1, int var2) {
        return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int) ((long) var0.sampleRate * 256L * (long) var1 / (long) (PcmPlayer.field1099 * 100)), var2 << 6) : null;
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "(Lclass62;III)Lclass44;"
    )
    public static RawPcmStream method979(RawSound var0, int var1, int var2, int var3) {
        return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
    }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "([B[IIIIIIILclass44;)I"
    )
    static int method1005(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
        var2 >>= 8;
        var7 >>= 8;
        var4 <<= 2;
        if ((var5 = var3 + var7 - var2) > var6) {
            var5 = var6;
        }

        int var10001;
        for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
        }

        for (var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
            var10001 = var3++;
        }

        var8.field1061 = var2 << 8;
        return var3;
    }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(I[B[IIIIIIIILclass44;)I"
    )
    static int method1006(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
        var3 >>= 8;
        var9 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        if ((var7 = var4 + var9 - var3) > var8) {
            var7 = var8;
        }

        var4 <<= 1;
        var7 <<= 1;

        int var10001;
        byte var11;
        for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        var10.field1061 = var3 << 8;
        return var4 >> 1;
    }

    @ObfuscatedName("av")
    @ObfuscatedSignature(
            descriptor = "([B[IIIIIIILclass44;)I"
    )
    static int method1007(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
        var2 >>= 8;
        var7 >>= 8;
        var4 <<= 2;
        if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
            var5 = var6;
        }

        int var10001;
        for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
        }

        for (var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
            var10001 = var3++;
        }

        var8.field1061 = var2 << 8;
        return var3;
    }

    @ObfuscatedName("ak")
    @ObfuscatedSignature(
            descriptor = "(I[B[IIIIIIIILclass44;)I"
    )
    static int method1097(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
        var3 >>= 8;
        var9 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
            var7 = var8;
        }

        var4 <<= 1;
        var7 <<= 1;

        int var10001;
        byte var11;
        for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        var10.field1061 = var3 << 8;
        return var4 >> 1;
    }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(II[B[IIIIIIILclass44;II)I"
    )
    static int method1009(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
            var7 = var8;
        }

        byte var13;
        int var10001;
        while (var5 < var7) {
            var1 = var4 >> 8;
            var13 = var2[var1];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
            var4 += var11;
        }

        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
            var7 = var8;
        }

        for (var1 = var12; var5 < var7; var4 += var11) {
            var13 = var2[var4 >> 8];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
        }

        var10.field1061 = var4;
        return var5;
    }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(II[B[IIIIIIIILclass44;II)I"
    )
    static int method1076(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
            var8 = var9;
        }

        var5 <<= 1;

        byte var14;
        int var10001;
        for (var8 <<= 1; var5 < var8; var4 += var12) {
            var1 = var4 >> 8;
            var14 = var2[var1];
            var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
            var8 = var9;
        }

        var8 <<= 1;

        for (var1 = var13; var5 < var8; var4 += var12) {
            var14 = var2[var4 >> 8];
            var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        var11.field1061 = var4;
        return var5 >> 1;
    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(II[B[IIIIIIILclass44;II)I"
    )
    static int method1044(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
        if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
            var7 = var8;
        }

        int var10001;
        while (var5 < var7) {
            var1 = var4 >> 8;
            byte var13 = var2[var1 - 1];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
            var4 += var11;
        }

        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
            var7 = var8;
        }

        var0 = var12;

        for (var1 = var11; var5 < var7; var4 += var1) {
            var10001 = var5++;
            var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
        }

        var10.field1061 = var4;
        return var5;
    }

    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            descriptor = "(II[B[IIIIIIIILclass44;II)I"
    )
    static int method1012(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
        if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        var5 <<= 1;

        int var10001;
        for (var8 <<= 1; var5 < var8; var4 += var12) {
            var1 = var4 >> 8;
            byte var14 = var2[var1 - 1];
            var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        var8 <<= 1;

        for (var1 = var13; var5 < var8; var4 += var12) {
            var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        var11.field1061 = var4;
        return var5 >> 1;
    }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "([B[IIIIIIIILclass44;)I"
    )
    static int method1022(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
        var2 >>= 8;
        var8 >>= 8;
        var4 <<= 2;
        var5 <<= 2;
        if ((var6 = var3 + var8 - var2) > var7) {
            var6 = var7;
        }

        var9.field1067 += var9.field1066 * (var6 - var3);
        var9.field1059 += var9.field1065 * (var6 - var3);

        int var10001;
        for (var6 -= 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
        }

        for (var6 += 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
        }

        var9.field1057 = var4 >> 2;
        var9.field1061 = var2 << 8;
        return var3;
    }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(I[B[IIIIIIIIIILclass44;)I"
    )
    static int method1124(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
        var3 >>= 8;
        var11 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        var7 <<= 2;
        var8 <<= 2;
        if ((var9 = var11 + var4 - var3) > var10) {
            var9 = var10;
        }

        var12.field1057 += var12.field1054 * (var9 - var4);
        var4 <<= 1;
        var9 <<= 1;

        byte var13;
        int var10001;
        for (var9 -= 6; var4 < var9; var6 += var8) {
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        for (var9 += 6; var4 < var9; var6 += var8) {
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        var12.field1067 = var5 >> 2;
        var12.field1059 = var6 >> 2;
        var12.field1061 = var3 << 8;
        return var4 >> 1;
    }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "([B[IIIIIIIILclass44;)I"
    )
    static int method1015(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
        var2 >>= 8;
        var8 >>= 8;
        var4 <<= 2;
        var5 <<= 2;
        if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
            var6 = var7;
        }

        var9.field1067 += var9.field1066 * (var6 - var3);
        var9.field1059 += var9.field1065 * (var6 - var3);

        int var10001;
        for (var6 -= 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
        }

        for (var6 += 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
        }

        var9.field1057 = var4 >> 2;
        var9.field1061 = var2 << 8;
        return var3;
    }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(I[B[IIIIIIIIIILclass44;)I"
    )
    static int method1056(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
        var3 >>= 8;
        var11 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        var7 <<= 2;
        var8 <<= 2;
        if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
            var9 = var10;
        }

        var12.field1057 += var12.field1054 * (var9 - var4);
        var4 <<= 1;
        var9 <<= 1;

        byte var13;
        int var10001;
        for (var9 -= 6; var4 < var9; var6 += var8) {
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        for (var9 += 6; var4 < var9; var6 += var8) {
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        var12.field1067 = var5 >> 2;
        var12.field1059 = var6 >> 2;
        var12.field1061 = var3 << 8;
        return var4 >> 1;
    }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            descriptor = "(II[B[IIIIIIIILclass44;II)I"
    )
    static int method1017(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
        var11.field1067 -= var11.field1066 * var5;
        var11.field1059 -= var11.field1065 * var5;
        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
            var8 = var9;
        }

        byte var14;
        int var10001;
        while (var5 < var8) {
            var1 = var4 >> 8;
            var14 = var2[var1];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
            var4 += var12;
        }

        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
            var8 = var9;
        }

        for (var1 = var13; var5 < var8; var4 += var12) {
            var14 = var2[var4 >> 8];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
        }

        var11.field1067 += var11.field1066 * var5;
        var11.field1059 += var11.field1065 * var5;
        var11.field1057 = var6;
        var11.field1061 = var4;
        return var5;
    }

    @ObfuscatedName("ap")
    @ObfuscatedSignature(
            descriptor = "(II[B[IIIIIIIIIILclass44;II)I"
    )
    static int method976(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
        var13.field1057 -= var5 * var13.field1054;
        if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
            var10 = var11;
        }

        var5 <<= 1;

        byte var16;
        int var10001;
        for (var10 <<= 1; var5 < var10; var4 += var14) {
            var1 = var4 >> 8;
            var16 = var2[var1];
            var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
            var10 = var11;
        }

        var10 <<= 1;

        for (var1 = var15; var5 < var10; var4 += var14) {
            var16 = var2[var4 >> 8];
            var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        var5 >>= 1;
        var13.field1057 += var13.field1054 * var5;
        var13.field1067 = var6;
        var13.field1059 = var7;
        var13.field1061 = var4;
        return var5;
    }

    @ObfuscatedName("am")
    @ObfuscatedSignature(
            descriptor = "(II[B[IIIIIIIILclass44;II)I"
    )
    static int method1019(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
        var11.field1067 -= var11.field1066 * var5;
        var11.field1059 -= var11.field1065 * var5;
        if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        int var10001;
        while (var5 < var8) {
            var1 = var4 >> 8;
            byte var14 = var2[var1 - 1];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
            var4 += var12;
        }

        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        var0 = var13;

        for (var1 = var12; var5 < var8; var4 += var1) {
            var10001 = var5++;
            var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
        }

        var11.field1067 += var11.field1066 * var5;
        var11.field1059 += var11.field1065 * var5;
        var11.field1057 = var6;
        var11.field1061 = var4;
        return var5;
    }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            descriptor = "(II[B[IIIIIIIIIILclass44;II)I"
    )
    static int method1020(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
        var13.field1057 -= var5 * var13.field1054;
        if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
            var10 = var11;
        }

        var5 <<= 1;

        int var10001;
        for (var10 <<= 1; var5 < var10; var4 += var14) {
            var1 = var4 >> 8;
            byte var16 = var2[var1 - 1];
            var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
            var10 = var11;
        }

        var10 <<= 1;

        for (var1 = var15; var5 < var10; var4 += var14) {
            var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        var5 >>= 1;
        var13.field1057 += var13.field1054 * var5;
        var13.field1067 = var6;
        var13.field1059 = var7;
        var13.field1061 = var4;
        return var5;
    }
}
