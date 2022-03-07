package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
    @ObfuscatedName("d")
    int field2489;
    @ObfuscatedName("p")
    boolean field2488;
    @ObfuscatedName("q")
    int field2486;
    @ObfuscatedName("x")
    int field2476;
    @ObfuscatedName("ao")
    int field2479;
    @ObfuscatedName("ae")
    int field2480;
    @ObfuscatedName("aa")
    int field2481;
    @ObfuscatedName("ah")
    boolean field2482;
    @ObfuscatedName("aw")
    int field2485;
    @ObfuscatedName("av")
    int field2484;
    @ObfuscatedName("ax")
    int field2468;
    @ObfuscatedName("ab")
    int field2474;
    @ObfuscatedName("af")
    String field2487;
    @ObfuscatedName("ai")
    String field2464;
    @ObfuscatedName("at")
    String field2477;
    @ObfuscatedName("aq")
    String field2490;
    @ObfuscatedName("ac")
    int field2491;
    @ObfuscatedName("al")
    int field2492;
    @ObfuscatedName("ag")
    int field2493;
    @ObfuscatedName("ap")
    int field2494;
    @ObfuscatedName("am")
    String field2483;
    @ObfuscatedName("as")
    String field2496;
    @ObfuscatedName("aj")
    int[] field2497 = new int[3];
    @ObfuscatedName("ar")
    int field2498;

    public PlatformInfo(boolean var1) {
        if (World.field199.startsWith("win")) {
            this.field2489 = 1;
        } else if (World.field199.startsWith("mac")) {
            this.field2489 = 2;
        } else if (World.field199.startsWith("linux")) {
            this.field2489 = 3;
        } else {
            this.field2489 = 4;
        }

        String var2;
        try {
            var2 = System.getProperty("os.arch").toLowerCase();
        } catch (Exception var13) {
            var2 = "";
        }

        String var3;
        try {
            var3 = System.getProperty("os.version").toLowerCase();
        } catch (Exception var12) {
            var3 = "";
        }

        String var4 = "Unknown";
        String var5 = "1.1";

        try {
            var4 = System.getProperty("java.vendor");
            var5 = System.getProperty("java.version");
        } catch (Exception var11) {
        }

        this.field2488 = var2.startsWith("amd64") || var2.startsWith("x86_64");

        if (this.field2489 == 1) {
            if (var3.indexOf("4.0") != -1) {
                this.field2486 = 1;
            } else if (var3.indexOf("4.1") != -1) {
                this.field2486 = 2;
            } else if (var3.indexOf("4.9") != -1) {
                this.field2486 = 3;
            } else if (var3.indexOf("5.0") != -1) {
                this.field2486 = 4;
            } else if (var3.indexOf("5.1") != -1) {
                this.field2486 = 5;
            } else if (var3.indexOf("5.2") != -1) {
                this.field2486 = 8;
            } else if (var3.indexOf("6.0") != -1) {
                this.field2486 = 6;
            } else if (var3.indexOf("6.1") != -1) {
                this.field2486 = 7;
            } else if (var3.indexOf("6.2") != -1) {
                this.field2486 = 9;
            }
        } else if (this.field2489 == 2) {
            if (var3.indexOf("10.4") != -1) {
                this.field2486 = 20;
            } else if (var3.indexOf("10.5") != -1) {
                this.field2486 = 21;
            } else if (var3.indexOf("10.6") != -1) {
                this.field2486 = 22;
            } else if (var3.indexOf("10.7") != -1) {
                this.field2486 = 23;
            }
        }

        if (var4.toLowerCase().indexOf("sun") != -1) {
            this.field2476 = 1;
        } else if (var4.toLowerCase().indexOf("microsoft") != -1) {
            this.field2476 = 2;
        } else if (var4.toLowerCase().indexOf("apple") != -1) {
            this.field2476 = 3;
        } else {
            this.field2476 = 4;
        }

        int var9 = 2;
        int var7 = 0;

        char var8;
        try {
            while (var9 < var5.length()) {
                var8 = var5.charAt(var9);
                if (var8 < '0' || var8 > '9') {
                    break;
                }

                var7 = var8 - 48 + var7 * 10;
                ++var9;
            }
        } catch (Exception var16) {
        }

        this.field2479 = var7;
        var9 = var5.indexOf(46, 2) + 1;
        var7 = 0;

        try {
            while (var9 < var5.length()) {
                var8 = var5.charAt(var9);
                if (var8 < '0' || var8 > '9') {
                    break;
                }

                var7 = var7 * 10 + (var8 - 48);
                ++var9;
            }
        } catch (Exception var15) {
        }

        this.field2480 = var7;
        var9 = var5.indexOf(95, 4) + 1;
        var7 = 0;

        try {
            while (var9 < var5.length()) {
                var8 = var5.charAt(var9);
                if (var8 < '0' || var8 > '9') {
                    break;
                }

                var7 = var8 - 48 + var7 * 10;
                ++var9;
            }
        } catch (Exception var14) {
        }

        this.field2481 = var7;
        this.field2482 = false;
        this.field2485 = (int) (Runtime.getRuntime().maxMemory() / 1048576L) + 1;
        if (this.field2479 > 3) {
            this.field2484 = Runtime.getRuntime().availableProcessors();
        } else {
            this.field2484 = 0;
        }

        this.field2468 = 0;
        if (this.field2487 == null) {
            this.field2487 = "";
        }

        if (this.field2464 == null) {
            this.field2464 = "";
        }

        if (this.field2477 == null) {
            this.field2477 = "";
        }

        if (this.field2490 == null) {
            this.field2490 = "";
        }

        if (this.field2483 == null) {
            this.field2483 = "";
        }

        if (this.field2496 == null) {
            this.field2496 = "";
        }

        this.method3180();
    }

    @ObfuscatedName("i")
    void method3180() {
        if (this.field2487.length() > 40) {
            this.field2487 = this.field2487.substring(0, 40);
        }

        if (this.field2464.length() > 40) {
            this.field2464 = this.field2464.substring(0, 40);
        }

        if (this.field2477.length() > 10) {
            this.field2477 = this.field2477.substring(0, 10);
        }

        if (this.field2490.length() > 10) {
            this.field2490 = this.field2490.substring(0, 10);
        }

    }

    @ObfuscatedName("w")
    @Export("method3181")
    @ObfuscatedSignature(
            descriptor = "(Lclass126;)V"
    )
    public void writePlatformInfo(Buffer var1) {
        var1.writeByte(6);
        var1.writeByte(this.field2489);
        var1.writeByte(this.field2488 ? 1 : 0);
        var1.writeByte(this.field2486);
        var1.writeByte(this.field2476);
        var1.writeByte(this.field2479);
        var1.writeByte(this.field2480);
        var1.writeByte(this.field2481);
        var1.writeByte(this.field2482 ? 1 : 0);
        var1.writeShort(this.field2485);
        var1.writeByte(this.field2484);
        var1.writeMedium(this.field2468);
        var1.writeShort(this.field2474);
        var1.writeStringCp1252NullCircumfixed(this.field2487);
        var1.writeStringCp1252NullCircumfixed(this.field2464);
        var1.writeStringCp1252NullCircumfixed(this.field2477);
        var1.writeStringCp1252NullCircumfixed(this.field2490);
        var1.writeByte(this.field2492);
        var1.writeShort(this.field2491);
        var1.writeStringCp1252NullCircumfixed(this.field2483);
        var1.writeStringCp1252NullCircumfixed(this.field2496);
        var1.writeByte(this.field2493);
        var1.writeByte(this.field2494);

        for (int var2 = 0; var2 < this.field2497.length; ++var2) {
            var1.writeInt(this.field2497[var2]);
        }

        var1.writeInt(this.field2498);
    }

    @ObfuscatedName("f")
    @Export("method3182")
    public int method3182() {
        byte var1 = 38;
        int var2 = var1 + BZip2State.method2509(this.field2487);
        var2 += BZip2State.method2509(this.field2464);
        var2 += BZip2State.method2509(this.field2477);
        var2 += BZip2State.method2509(this.field2490);
        var2 += BZip2State.method2509(this.field2483);
        var2 += BZip2State.method2509(this.field2496);
        return var2;
    }

    @ObfuscatedName("t")
    public static int method3200(int var0, int var1) {
        int var2 = var0 >>> 31;
        return (var0 + var2) / var1 - var2;
    }

    @ObfuscatedName("bq")
    static final boolean method3190(int var0) {
        if (var0 < 0) {
            return false;
        } else {
            int var1 = Client.menuOpcodes[var0];
            if (var1 >= 2000) {
                var1 -= 2000;
            }

            return var1 == 1007;
        }
    }
}
