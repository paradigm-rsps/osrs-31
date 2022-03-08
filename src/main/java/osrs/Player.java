package osrs;

import osrs.cache.Definitions;

public final class Player extends Actor {
    String field35;
    PlayerComposition appearance;
    int headIconPk = -1;
    int headIconPrayer = -1;
    int combatLevel = 0;
    int skillLevel = 0;
    int tileHeight;
    int animationCycleStart = 0;
    int animationCycleEnd = 0;
    int field34;
    int tileHeight2;
    int field42;
    Model model0;
    int minX;
    int minY;
    int maxX;
    int maxY;
    boolean isUnanimated = false;
    int team = 0;

    void updateAppearance(Buffer var1) {
        var1.offset = 0;
        int var2 = var1.readUnsignedByte();
        this.headIconPk = var1.readByte();
        this.headIconPrayer = var1.readByte();
        int var3 = -1;
        this.team = 0;
        int[] var4 = new int[12];

        int var6;
        int var7;
        for (int var5 = 0; var5 < 12; ++var5) {
            var6 = var1.readUnsignedByte();
            if (var6 == 0) {
                var4[var5] = 0;
            } else {
                var7 = var1.readUnsignedByte();
                var4[var5] = var7 + (var6 << 8);
                if (var5 == 0 && var4[0] == 65535) {
                    var3 = var1.readUnsignedShort();
                    break;
                }

                if (var4[var5] >= 512) {
                    int var8 = class27.method571(var4[var5] - 512).team;
                    if (var8 != 0) {
                        this.team = var8;
                    }
                }
            }
        }

        int[] var9 = new int[5];

        for (var6 = 0; var6 < 5; ++var6) {
            var7 = var1.readUnsignedByte();
            if (var7 < 0 || var7 >= Skeleton.field1792[var6].length) {
                var7 = 0;
            }

            var9[var6] = var7;
        }

        super.idleSequence = var1.readUnsignedShort();
        if (super.idleSequence == 65535) {
            super.idleSequence = -1;
        }

        super.turnLeftSequence = var1.readUnsignedShort();
        if (super.turnLeftSequence == 65535) {
            super.turnLeftSequence = -1;
        }

        super.turnRightSequence = super.turnLeftSequence;
        super.walkSequence = var1.readUnsignedShort();
        if (super.walkSequence == 65535) {
            super.walkSequence = -1;
        }

        super.walkBackSequence = var1.readUnsignedShort();
        if (super.walkBackSequence == 65535) {
            super.walkBackSequence = -1;
        }

        super.walkLeftSequence = var1.readUnsignedShort();
        if (super.walkLeftSequence == 65535) {
            super.walkLeftSequence = -1;
        }

        super.walkRightSequence = var1.readUnsignedShort();
        if (super.walkRightSequence == 65535) {
            super.walkRightSequence = -1;
        }

        super.runSequence = var1.readUnsignedShort();
        if (super.runSequence == 65535) {
            super.runSequence = -1;
        }

        this.field35 = var1.readChatString();
        if (this == Tiles.localPlayer) {
            RunException.field1413 = this.field35;
        }

        this.combatLevel = var1.readUnsignedByte();
        this.skillLevel = var1.readUnsignedShort();
        if (this.appearance == null) {
            this.appearance = new PlayerComposition();
        }

        this.appearance.setPlayerAppearance(var4, var9, var2 == 1, var3);
    }

    protected final Model vmethod2030() {
        if (this.appearance == null) {
            return null;
        } else {
            AnimationDefinition var1 = super.animation != -1 && super.sequenceDelay == 0 ? Definitions.getAnimation(super.animation) : null;
            AnimationDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.movementSequence == super.idleSequence && var1 != null ? null : Definitions.getAnimation(super.movementSequence);
            Model var3 = this.appearance.method3407(var1, super.sequenceFrame, var2, super.movementFrame);
            if (var3 == null) {
                return null;
            } else {
                var3.method2427();
                super.defaultHeight = var3.height;
                Model var4;
                Model[] var5;
                if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
                    var4 = NPCComposition.method656(super.spotAnimation).method766(super.spotAnimationFrame);
                    if (var4 != null) {
                        var4.method2451(0, -super.field430, 0);
                        var5 = new Model[]{var3, var4};
                        var3 = new Model(var5, 2);
                    }
                }

                if (!this.isUnanimated && this.model0 != null) {
                    if (Client.cycle >= this.animationCycleEnd) {
                        this.model0 = null;
                    }

                    if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
                        var4 = this.model0;
                        var4.method2451(this.field34 - super.x, this.tileHeight2 - this.tileHeight, this.field42 - super.y);
                        if (super.orientation == 512) {
                            var4.method2488();
                            var4.method2488();
                            var4.method2488();
                        } else if (super.orientation == 1024) {
                            var4.method2488();
                            var4.method2488();
                        } else if (super.orientation == 1536) {
                            var4.method2488();
                        }

                        var5 = new Model[]{var3, var4};
                        var3 = new Model(var5, 2);
                        if (super.orientation == 512) {
                            var4.method2488();
                        } else if (super.orientation == 1024) {
                            var4.method2488();
                            var4.method2488();
                        } else if (super.orientation == 1536) {
                            var4.method2488();
                            var4.method2488();
                            var4.method2488();
                        }

                        var4.method2451(super.x - this.field34, this.tileHeight - this.tileHeight2, super.y - this.field42);
                    }
                }

                var3.isSingleTile = true;
                return var3;
            }
        }
    }

    final boolean vmethod281() {
        return this.appearance != null;
    }

    public static void method23(AbstractArchive var0, String var1, String var2, int var3, boolean var4) {
        int var5 = var0.getGroupId(var1);
        int var6 = var0.method3238(var5, var2);
        class161.method3399(var0, var5, var6, var3, var4);
    }

    static final void method26(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7;
        if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
            Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

            while (true) {
                var7 = var0.readUnsignedByte();
                if (var7 == 0) {
                    if (var1 == 0) {
                        Tiles.tileHeights[0][var2][var3] = -class1.method11(var2 + 932731 + var4, var5 + var3 + 556238) * 8;
                    } else {
                        Tiles.tileHeights[var1][var2][var3] = Tiles.tileHeights[var1 - 1][var2][var3] - 240;
                    }
                    break;
                }

                if (var7 == 1) {
                    int var8 = var0.readUnsignedByte();
                    if (var8 == 1) {
                        var8 = 0;
                    }

                    if (var1 == 0) {
                        Tiles.tileHeights[0][var2][var3] = -var8 * 8;
                    } else {
                        Tiles.tileHeights[var1][var2][var3] = Tiles.tileHeights[var1 - 1][var2][var3] - var8 * 8;
                    }
                    break;
                }

                if (var7 <= 49) {
                    VarpDefinition.Tiles_overlays[var1][var2][var3] = var0.readByte();
                    Tiles.Tiles_shapes[var1][var2][var3] = (byte) ((var7 - 2) / 4);
                    class123.field2031[var1][var2][var3] = (byte) (var7 - 2 + var6 & 3);
                } else if (var7 <= 81) {
                    Tiles.Tiles_renderFlags[var1][var2][var3] = (byte) (var7 - 49);
                } else {
                    Tiles.Tiles_underlays[var1][var2][var3] = (byte) (var7 - 81);
                }
            }
        } else {
            while (true) {
                var7 = var0.readUnsignedByte();
                if (var7 == 0) {
                    break;
                }

                if (var7 == 1) {
                    var0.readUnsignedByte();
                    break;
                }

                if (var7 <= 49) {
                    var0.readUnsignedByte();
                }
            }
        }

    }
}
