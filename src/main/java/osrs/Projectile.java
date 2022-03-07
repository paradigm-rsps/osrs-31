package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import osrs.cache.Definitions;

@ObfuscatedName("l")
@Implements("Projectile")
public final class Projectile extends Renderable {
    @ObfuscatedName("oo")
    @Export("clientPreferences")
    @ObfuscatedSignature(
            descriptor = "Lclass11;"
    )
    static ClientPreferences clientPreferences;
    @ObfuscatedName("gk")
    @ObfuscatedSignature(
            descriptor = "Lclass157;"
    )
    static Widget field161;
    @ObfuscatedName("ac")
    static class23 field171;
    @ObfuscatedName("i")
    @Export("id")
    int id;
    @ObfuscatedName("w")
    @Export("plane")
    int plane;
    @ObfuscatedName("f")
    @Export("sourceX")
    int sourceX;
    @ObfuscatedName("e")
    @Export("sourceY")
    int sourceY;
    @ObfuscatedName("t")
    @Export("sourceZ")
    int sourceZ;
    @ObfuscatedName("d")
    @Export("endHeight")
    int endHeight;
    @ObfuscatedName("p")
    @Export("cycleStart")
    int cycleStart;
    @ObfuscatedName("k")
    @Export("cycleEnd")
    int cycleEnd;
    @ObfuscatedName("r")
    @Export("slope")
    int slope;
    @ObfuscatedName("l")
    @Export("startHeight")
    int startHeight;
    @ObfuscatedName("a")
    @Export("targetIndex")
    int targetIndex;
    @ObfuscatedName("z")
    @Export("isMoving")
    boolean isMoving = false;
    @ObfuscatedName("s")
    @Export("x")
    double x;
    @ObfuscatedName("m")
    @Export("y")
    double y;
    @ObfuscatedName("u")
    @Export("z")
    double z;
    @ObfuscatedName("g")
    @Export("speedX")
    double speedX;
    @ObfuscatedName("o")
    @Export("speedY")
    double speedY;
    @ObfuscatedName("v")
    @Export("speed")
    double speed;
    @ObfuscatedName("j")
    @Export("speedZ")
    double speedZ;
    @ObfuscatedName("n")
    @Export("accelerationZ")
    double accelerationZ;
    @ObfuscatedName("q")
    @Export("yaw")
    int yaw;
    @ObfuscatedName("c")
    @Export("pitch")
    int pitch;
    @ObfuscatedName("h")
    @Export("sequenceDefinition")
    @ObfuscatedSignature(
            descriptor = "Lclass33;"
    )
    SequenceDefinition sequenceDefinition;
    @ObfuscatedName("b")
    @Export("frame")
    int frame = 0;
    @ObfuscatedName("y")
    int field172 = 0;

    Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        this.id = var1;
        this.plane = var2;
        this.sourceX = var3;
        this.sourceY = var4;
        this.sourceZ = var5;
        this.cycleStart = var6;
        this.cycleEnd = var7;
        this.slope = var8;
        this.startHeight = var9;
        this.targetIndex = var10;
        this.endHeight = var11;
        this.isMoving = false;
        int var12 = NPCComposition.method656(this.id).sequence;
        if (var12 != -1) {
            this.sequenceDefinition = Definitions.getAnimation(var12);
        } else {
            this.sequenceDefinition = null;
        }

    }

    @ObfuscatedName("i")
    @Export("method114")
    final void method114(int var1, int var2, int var3, int var4) {
        double var5;
        if (!this.isMoving) {
            var5 = var1 - this.sourceX;
            double var7 = var2 - this.sourceY;
            double var9 = Math.sqrt(var7 * var7 + var5 * var5);
            this.x = var5 * (double) this.startHeight / var9 + (double) this.sourceX;
            this.y = var7 * (double) this.startHeight / var9 + (double) this.sourceY;
            this.z = this.sourceZ;
        }

        var5 = this.cycleEnd + 1 - var4;
        this.speedX = ((double) var1 - this.x) / var5;
        this.speedY = ((double) var2 - this.y) / var5;
        this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
        if (!this.isMoving) {
            this.speedZ = -this.speed * Math.tan((double) this.slope * 0.02454369D);
        }

        this.accelerationZ = 2.0D * ((double) var3 - this.z - this.speedZ * var5) / (var5 * var5);
    }

    @ObfuscatedName("w")
    @Export("vmethod2030")
    @ObfuscatedSignature(
            descriptor = "()Lclass111;"
    )
    protected final Model vmethod2030() {
        SpotAnimationDefinition var1 = NPCComposition.method656(this.id);
        Model var2 = var1.method766(this.frame);
        if (var2 == null) {
            return null;
        } else {
            var2.method2436(this.pitch);
            return var2;
        }
    }

    @ObfuscatedName("f")
    @Export("method115")
    final void method115(int var1) {
        this.isMoving = true;
        this.x += (double) var1 * this.speedX;
        this.y += this.speedY * (double) var1;
        this.z += (double) var1 * 0.5D * this.accelerationZ * (double) var1 + (double) var1 * this.speedZ;
        this.speedZ += (double) var1 * this.accelerationZ;
        this.yaw = (int) (Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047;
        this.pitch = (int) (Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
        if (this.sequenceDefinition != null) {
            this.field172 += var1;

            while (true) {
                do {
                    do {
                        if (this.field172 <= this.sequenceDefinition.frameLengths[this.frame]) {
                            return;
                        }

                        this.field172 -= this.sequenceDefinition.frameLengths[this.frame];
                        ++this.frame;
                    } while (this.frame < this.sequenceDefinition.frameIds.length);

                    this.frame -= this.sequenceDefinition.frameCount;
                } while (this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

                this.frame = 0;
            }
        }
    }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/CharSequence;Lclass185;)Ljava/lang/String;"
    )
    public static String method125(CharSequence var0, LoginType var1) {
        if (var0 == null) {
            return null;
        } else {
            int var2 = 0;

            int var3;
            boolean var4;
            char var5;
            for (var3 = var0.length(); var2 < var3; ++var2) {
                var5 = var0.charAt(var2);
                var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
                if (!var4) {
                    break;
                }
            }

            while (var3 > var2) {
                var5 = var0.charAt(var3 - 1);
                var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
                if (!var4) {
                    break;
                }

                --var3;
            }

            int var15 = var3 - var2;
            if (var15 >= 1 && var15 <= class68.method1470(var1)) {
                StringBuilder var13 = new StringBuilder(var15);

                for (int var6 = var2; var6 < var3; ++var6) {
                    char var7 = var0.charAt(var6);
                    boolean var8;
                    if (Character.isISOControl(var7)) {
                        var8 = false;
                    } else {
                        boolean var9 = var7 >= '0' && var7 <= '9' || var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                        if (var9) {
                            var8 = true;
                        } else {
                            char[] var10 = class147.field2453;
                            int var11 = 0;

                            label125:
                            while (true) {
                                char var12;
                                if (var11 >= var10.length) {
                                    var10 = class147.field2457;

                                    for (var11 = 0; var11 < var10.length; ++var11) {
                                        var12 = var10[var11];
                                        if (var12 == var7) {
                                            var8 = true;
                                            break label125;
                                        }
                                    }

                                    var8 = false;
                                    break;
                                }

                                var12 = var10[var11];
                                if (var12 == var7) {
                                    var8 = true;
                                    break;
                                }

                                ++var11;
                            }
                        }
                    }

                    if (var8) {
                        char var16;
                        switch (var7) {
                            case ' ':
                            case '-':
                            case '_':
                            case ' ':
                                var16 = '_';
                                break;
                            case '#':
                            case '[':
                            case ']':
                                var16 = var7;
                                break;
                            case 'À':
                            case 'Á':
                            case 'Â':
                            case 'Ã':
                            case 'Ä':
                            case 'à':
                            case 'á':
                            case 'â':
                            case 'ã':
                            case 'ä':
                                var16 = 'a';
                                break;
                            case 'Ç':
                            case 'ç':
                                var16 = 'c';
                                break;
                            case 'È':
                            case 'É':
                            case 'Ê':
                            case 'Ë':
                            case 'è':
                            case 'é':
                            case 'ê':
                            case 'ë':
                                var16 = 'e';
                                break;
                            case 'Í':
                            case 'Î':
                            case 'Ï':
                            case 'í':
                            case 'î':
                            case 'ï':
                                var16 = 'i';
                                break;
                            case 'Ñ':
                            case 'ñ':
                                var16 = 'n';
                                break;
                            case 'Ò':
                            case 'Ó':
                            case 'Ô':
                            case 'Õ':
                            case 'Ö':
                            case 'ò':
                            case 'ó':
                            case 'ô':
                            case 'õ':
                            case 'ö':
                                var16 = 'o';
                                break;
                            case 'Ù':
                            case 'Ú':
                            case 'Û':
                            case 'Ü':
                            case 'ù':
                            case 'ú':
                            case 'û':
                            case 'ü':
                                var16 = 'u';
                                break;
                            case 'ß':
                                var16 = 'b';
                                break;
                            case 'ÿ':
                            case 'Ÿ':
                                var16 = 'y';
                                break;
                            default:
                                var16 = Character.toLowerCase(var7);
                        }

                        if (var16 != 0) {
                            var13.append(var16);
                        }
                    }
                }

                if (var13.length() == 0) {
                    return null;
                } else {
                    return var13.toString();
                }
            } else {
                return null;
            }
        }
    }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            descriptor = "(Lclass151;Lclass151;Ljava/lang/String;Ljava/lang/String;)Lclass182;"
    )
    public static Font method127(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
        int var4 = var0.getGroupId(var2);
        int var5 = var0.method3238(var4, var3);
        return class82.method1757(var0, var1, var4, var5);
    }

    @ObfuscatedName("o")
    static void method128() {
        class148.field2460 = new int[33];
        Client.field561 = new int[33];
        class112.field1931 = new int[151];
        VarpDefinition.field1044 = new int[151];

        int var0;
        int var1;
        int var2;
        int var3;
        for (var0 = 0; var0 < 33; ++var0) {
            var1 = 999;
            var2 = 0;

            for (var3 = 0; var3 < 34; ++var3) {
                if (TextureProvider.field1834.pixels[var3 + var0 * TextureProvider.field1834.subWidth] == 0) {
                    if (var1 == 999) {
                        var1 = var3;
                    }
                } else if (var1 != 999) {
                    var2 = var3;
                    break;
                }
            }

            class148.field2460[var0] = var1;
            Client.field561[var0] = var2 - var1;
        }

        for (var0 = 5; var0 < 156; ++var0) {
            var1 = 999;
            var2 = 0;

            for (var3 = 25; var3 < 172; ++var3) {
                if (TextureProvider.field1834.pixels[var3 + var0 * TextureProvider.field1834.subWidth] != 0 || var3 <= 34 && var0 <= 34) {
                    if (var1 != 999) {
                        var2 = var3;
                        break;
                    }
                } else if (var1 == 999) {
                    var1 = var3;
                }
            }

            class112.field1931[var0 - 5] = var1 - 25;
            VarpDefinition.field1044[var0 - 5] = var2 - var1;
        }

    }

    @ObfuscatedName("ao")
    @Export("method126")
    static void method126(int var0) {
        if (var0 == -1 && !Client.field562) {
            class137.midiPcmStream.method2951();
            class137.musicPlayerStatus = 1;
            class137.musicTrackArchive = null;
        } else if (var0 != -1 && var0 != Client.currentTrackGroupId && Client.field718 != 0 && !Client.field562) {
            ObjectSound.method43(2, class40.archive6, var0, 0, Client.field718, false);
        }

        Client.currentTrackGroupId = var0;
    }

    @ObfuscatedName("cp")
    static final void method123() {
        class82.invalidateWidget(Client.clickedWidget);
        ++ClientPreferences.field191;
        if (Client.field703 && Client.field659) {
            int var0 = MouseHandler.MouseHandler_x;
            int var1 = MouseHandler.MouseHandler_y;
            var0 -= Client.widgetClickX;
            var1 -= Client.widgetClickY;
            if (var0 < Client.field624) {
                var0 = Client.field624;
            }

            if (var0 + Client.clickedWidget.width > Client.field624 + Client.field740.width) {
                var0 = Client.field624 + Client.field740.width - Client.clickedWidget.width;
            }

            if (var1 < Client.field661) {
                var1 = Client.field661;
            }

            if (var1 + Client.clickedWidget.height > Client.field661 + Client.field740.height) {
                var1 = Client.field661 + Client.field740.height - Client.clickedWidget.height;
            }

            int var2 = var0 - Client.field708;
            int var3 = var1 - Client.field664;
            int var4 = Client.clickedWidget.field2567;
            if (ClientPreferences.field191 > Client.clickedWidget.field2640 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
                Client.isDraggingWidget = true;
            }

            int var5 = var0 - Client.field624 + Client.field740.field2589;
            int var6 = var1 - Client.field661 + Client.field740.field2655;
            ScriptEvent var7;
            if (Client.clickedWidget.field2657 != null && Client.isDraggingWidget) {
                var7 = new ScriptEvent();
                var7.widget = Client.clickedWidget;
                var7.field2 = var5;
                var7.field7 = var6;
                var7.args = Client.clickedWidget.field2657;
                Renderable.method2040(var7);
            }

            if (MouseHandler.MouseHandler_currentButton == 0) {
                if (Client.isDraggingWidget) {
                    if (Client.clickedWidget.field2653 != null) {
                        var7 = new ScriptEvent();
                        var7.widget = Client.clickedWidget;
                        var7.field2 = var5;
                        var7.field7 = var6;
                        var7.field5 = Client.field658;
                        var7.args = Client.clickedWidget.field2653;
                        Renderable.method2040(var7);
                    }

                    if (Client.field658 != null) {
                        Widget var8 = Client.clickedWidget;
                        int var9 = class137.method2892(SoundSystem.method1326(var8));
                        Widget var11;
                        if (var9 == 0) {
                            var11 = null;
                        } else {
                            int var10 = 0;

                            while (true) {
                                if (var10 >= var9) {
                                    var11 = var8;
                                    break;
                                }

                                var8 = class130.getWidget(var8.parentId);
                                if (var8 == null) {
                                    var11 = null;
                                    break;
                                }

                                ++var10;
                            }
                        }

                        if (var11 != null) {
                            Client.rsaBuf.writeByteOpcode(79);
                            Client.rsaBuf.writeShortAdd(Client.field658.childIndex);
                            Client.rsaBuf.writeShortLE(Client.clickedWidget.childIndex);
                            Client.rsaBuf.writeIntIME(Client.clickedWidget.id);
                            Client.rsaBuf.writeIntLE(Client.field658.id);
                        }
                    }
                } else if ((Client.leftClickOpensMenu == 1 || PlatformInfo.method3190(Client.menuOptionsCount - 1)) && Client.menuOptionsCount > 2) {
                    class1.method9();
                } else if (Client.menuOptionsCount > 0) {
                    Frames.method2392(Client.menuOptionsCount - 1);
                }

                Client.clickedWidget = null;
            }

        } else {
            if (ClientPreferences.field191 > 1) {
                Client.clickedWidget = null;
            }

        }
    }

    @ObfuscatedName("cb")
    @ObfuscatedSignature(
            descriptor = "(IIIILclass85;)V"
    )
    static final void method124(int var0, int var1, int var2, int var3, SpritePixels var4) {
        int var5 = var3 * var3 + var2 * var2;
        if (var5 > 4225 && var5 < 90000) {
            int var6 = Client.field554 + Client.field569 & 2047;
            int var7 = Rasterizer3D.Rasterizer3D_sine[var6];
            int var8 = Rasterizer3D.Rasterizer3D_cosine[var6];
            var7 = var7 * 256 / (Client.field556 + 256);
            var8 = var8 * 256 / (Client.field556 + 256);
            int var9 = var8 * var2 + var3 * var7 >> 16;
            int var10 = var3 * var8 - var7 * var2 >> 16;
            double var11 = Math.atan2(var9, var10);
            int var13 = (int) (Math.sin(var11) * 63.0D);
            int var14 = (int) (Math.cos(var11) * 57.0D);
            class22.redHintArrowSprite.method1848(var0 + var13 + 94 + 4 - 10, var1 + 83 - var14 - 20, 20, 20, 15, 15, var11, 256);
        } else {
            Script.method35(var0, var1, var2, var3, var4);
        }

    }
}
