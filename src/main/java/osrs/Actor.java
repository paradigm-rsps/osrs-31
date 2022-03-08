package osrs;

import osrs.cache.Definitions;

public abstract class Actor extends Renderable {
    static int field478;
    int x;
    int y;
    int field432;
    boolean isWalking = false;
    int size = 1;
    int idleSequence = -1;
    int turnLeftSequence = -1;
    int turnRightSequence = -1;
    int walkSequence = -1;
    int walkBackSequence = -1;
    int walkLeftSequence = -1;
    int walkRightSequence = -1;
    int runSequence = -1;
    String overheadText = null;
    int field435 = 100;
    int field436 = 0;
    int field445 = 0;
    int[] hitSplatTypes = new int[4];
    int[] hitSplatValues = new int[4];
    int[] hitSplatCycles = new int[4];
    int field441 = -1000;
    int field431;
    int field425;
    int field444 = -1;
    int field475 = 0;
    int field446 = 0;
    int movementSequence = -1;
    int movementFrame = 0;
    int field449 = 0;
    int animation = -1;
    int sequenceFrame = 0;
    int sequenceFrameCycle = 0;
    int sequenceDelay = 0;
    int field421 = 0;
    int spotAnimation = -1;
    int spotAnimationFrame = 0;
    int spotAnimationFrameCycle = 0;
    int field458;
    int field430;
    int field460;
    int field439;
    int field462;
    int field463;
    int field456;
    int field465;
    int field466;
    int field467 = 0;
    int defaultHeight = 200;
    int orientation;
    int field470 = 0;
    int field471 = 32;
    int pathLength = 0;
    int[] pathX = new int[10];
    int[] pathY = new int[10];
    boolean[] field459 = new boolean[10];
    int delaySteps = 0;
    int remainingSteps = 0;

    boolean vmethod281() {
        return false;
    }

    final void setPosition(int x, int y, boolean isTeleport) {
        if (this.animation != -1 && Definitions.getAnimation(this.animation).field900 == 1) {
            this.animation = -1;
        }

        if (!isTeleport) {
            int var4 = x - this.pathX[0];
            int var5 = y - this.pathY[0];
            if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
                if (this.pathLength < 9) {
                    ++this.pathLength;
                }

                for (int var6 = this.pathLength; var6 > 0; --var6) {
                    this.pathX[var6] = this.pathX[var6 - 1];
                    this.pathY[var6] = this.pathY[var6 - 1];
                    this.field459[var6] = this.field459[var6 - 1];
                }

                this.pathX[0] = x;
                this.pathY[0] = y;
                this.field459[0] = false;
                return;
            }
        }

        this.pathLength = 0;
        this.remainingSteps = 0;
        this.delaySteps = 0;
        this.pathX[0] = x;
        this.pathY[0] = y;
        this.x = this.pathX[0] * 128 + this.size * 64;
        this.y = this.pathY[0] * 128 + this.size * 64;
    }

    final void method279(int var1, boolean var2) {
        int var3 = this.pathX[0];
        int var4 = this.pathY[0];
        if (var1 == 0) {
            --var3;
            ++var4;
        }

        if (var1 == 1) {
            ++var4;
        }

        if (var1 == 2) {
            ++var3;
            ++var4;
        }

        if (var1 == 3) {
            --var3;
        }

        if (var1 == 4) {
            ++var3;
        }

        if (var1 == 5) {
            --var3;
            --var4;
        }

        if (var1 == 6) {
            --var4;
        }

        if (var1 == 7) {
            ++var3;
            --var4;
        }

        if (this.animation != -1 && Definitions.getAnimation(this.animation).field900 == 1) {
            this.animation = -1;
        }

        if (this.pathLength < 9) {
            ++this.pathLength;
        }

        for (int var5 = this.pathLength; var5 > 0; --var5) {
            this.pathX[var5] = this.pathX[var5 - 1];
            this.pathY[var5] = this.pathY[var5 - 1];
            this.field459[var5] = this.field459[var5 - 1];
        }

        this.pathX[0] = var3;
        this.pathY[0] = var4;
        this.field459[0] = var2;
    }

    final void method280() {
        this.pathLength = 0;
        this.remainingSteps = 0;
    }

    final void method277(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < 4; ++var4) {
            if (this.hitSplatCycles[var4] <= var3) {
                this.hitSplatTypes[var4] = var1;
                this.hitSplatValues[var4] = var2;
                this.hitSplatCycles[var4] = var3 + 70;
                return;
            }
        }

    }

    static final void method295(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
        if (Client.isLowDetail && (Tiles.Tiles_renderFlags[0][var1][var2] & 2) == 0) {
            if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 16) != 0) {
                return;
            }

            int var8;
            if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 8) != 0) {
                var8 = 0;
            } else if (var0 > 0 && (Tiles.Tiles_renderFlags[1][var1][var2] & 2) != 0) {
                var8 = var0 - 1;
            } else {
                var8 = var0;
            }

            if (var8 != Client.renderPlane) {
                return;
            }
        }

        if (var0 < Tiles.Tiles_minPlane) {
            Tiles.Tiles_minPlane = var0;
        }

        ObjectDefinition var26 = Definitions.getObject(var3);
        int var9;
        int var10;
        if (var4 != 1 && var4 != 3) {
            var9 = var26.sizeX;
            var10 = var26.sizeY;
        } else {
            var9 = var26.sizeY;
            var10 = var26.sizeX;
        }

        int var11;
        int var12;
        if (var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
        } else {
            var11 = var1;
            var12 = var1 + 1;
        }

        int var13;
        int var14;
        if (var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
        } else {
            var13 = var2;
            var14 = var2 + 1;
        }

        int[][] var15 = Tiles.tileHeights[var0];
        int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
        int var17 = (var1 << 7) + (var9 << 6);
        int var18 = (var2 << 7) + (var10 << 6);
        int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
        if (var26.int1 == 0) {
            var19 -= Integer.MIN_VALUE;
        }

        int var20 = var5 + (var4 << 6);
        if (var26.int3 == 1) {
            var20 += 256;
        }

        if (var26.method668()) {
            SoundSystem.method1324(var0, var1, var2, var26, var4);
        }

        Object var27;
        if (var5 == 22) {
            if (!Client.isLowDetail || var26.int1 != 0 || var26.interactType == 1 || var26.boolean2) {
                if (var26.animationId == -1 && var26.transforms == null) {
                    var27 = var26.method669(22, var4, var15, var17, var16, var18);
                } else {
                    var27 = new DynamicObject(var3, 22, var4, var0, var1, var2, var26.animationId, true, null);
                }

                var6.setFloorDecoration(var0, var1, var2, var16, (Renderable) var27, var19, var20);
                if (var26.interactType == 1 && var7 != null) {
                    var7.method3430(var1, var2);
                }

            }
        } else {
            int var22;
            if (var5 != 10 && var5 != 11) {
                if (var5 >= 12) {
                    if (var26.animationId == -1 && var26.transforms == null) {
                        var27 = var26.method669(var5, var4, var15, var17, var16, var18);
                    } else {
                        var27 = new DynamicObject(var3, var5, var4, var0, var1, var2, var26.animationId, true, null);
                    }

                    var6.addGameObject(var0, var1, var2, var16, 1, 1, (Renderable) var27, 0, var19, var20);
                    if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                        VertexNormal.field1510[var0][var1][var2] |= 2340;
                    }

                    if (var26.interactType != 0 && var7 != null) {
                        var7.method3428(var1, var2, var9, var10, var26.boolean1);
                    }

                } else if (var5 == 0) {
                    if (var26.animationId == -1 && var26.transforms == null) {
                        var27 = var26.method669(0, var4, var15, var17, var16, var18);
                    } else {
                        var27 = new DynamicObject(var3, 0, var4, var0, var1, var2, var26.animationId, true, null);
                    }

                    var6.setBoundaryObject(var0, var1, var2, var16, (Renderable) var27, null, Tiles.field124[var4], 0, var19, var20);
                    if (var4 == 0) {
                        if (var26.clipped) {
                            Tiles.field132[var0][var1][var2] = 50;
                            Tiles.field132[var0][var1][var2 + 1] = 50;
                        }

                        if (var26.modelClipped) {
                            VertexNormal.field1510[var0][var1][var2] |= 585;
                        }
                    } else if (var4 == 1) {
                        if (var26.clipped) {
                            Tiles.field132[var0][var1][var2 + 1] = 50;
                            Tiles.field132[var0][var1 + 1][var2 + 1] = 50;
                        }

                        if (var26.modelClipped) {
                            VertexNormal.field1510[var0][var1][1 + var2] |= 1170;
                        }
                    } else if (var4 == 2) {
                        if (var26.clipped) {
                            Tiles.field132[var0][var1 + 1][var2] = 50;
                            Tiles.field132[var0][var1 + 1][var2 + 1] = 50;
                        }

                        if (var26.modelClipped) {
                            VertexNormal.field1510[var0][var1 + 1][var2] |= 585;
                        }
                    } else if (var4 == 3) {
                        if (var26.clipped) {
                            Tiles.field132[var0][var1][var2] = 50;
                            Tiles.field132[var0][var1 + 1][var2] = 50;
                        }

                        if (var26.modelClipped) {
                            VertexNormal.field1510[var0][var1][var2] |= 1170;
                        }
                    }

                    if (var26.interactType != 0 && var7 != null) {
                        var7.method3427(var1, var2, var5, var4, var26.boolean1);
                    }

                    if (var26.int2 != 16) {
                        var6.method2161(var0, var1, var2, var26.int2);
                    }

                } else if (var5 == 1) {
                    if (var26.animationId == -1 && var26.transforms == null) {
                        var27 = var26.method669(1, var4, var15, var17, var16, var18);
                    } else {
                        var27 = new DynamicObject(var3, 1, var4, var0, var1, var2, var26.animationId, true, null);
                    }

                    var6.setBoundaryObject(var0, var1, var2, var16, (Renderable) var27, null, Tiles.field125[var4], 0, var19, var20);
                    if (var26.clipped) {
                        if (var4 == 0) {
                            Tiles.field132[var0][var1][var2 + 1] = 50;
                        } else if (var4 == 1) {
                            Tiles.field132[var0][var1 + 1][var2 + 1] = 50;
                        } else if (var4 == 2) {
                            Tiles.field132[var0][var1 + 1][var2] = 50;
                        } else if (var4 == 3) {
                            Tiles.field132[var0][var1][var2] = 50;
                        }
                    }

                    if (var26.interactType != 0 && var7 != null) {
                        var7.method3427(var1, var2, var5, var4, var26.boolean1);
                    }

                } else {
                    int var21;
                    Object var23;
                    if (var5 == 2) {
                        var21 = var4 + 1 & 3;
                        Object var28;
                        if (var26.animationId == -1 && var26.transforms == null) {
                            var28 = var26.method669(2, var4 + 4, var15, var17, var16, var18);
                            var23 = var26.method669(2, var21, var15, var17, var16, var18);
                        } else {
                            var28 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var26.animationId, true, null);
                            var23 = new DynamicObject(var3, 2, var21, var0, var1, var2, var26.animationId, true, null);
                        }

                        var6.setBoundaryObject(var0, var1, var2, var16, (Renderable) var28, (Renderable) var23, Tiles.field124[var4], Tiles.field124[var21], var19, var20);
                        if (var26.modelClipped) {
                            if (var4 == 0) {
                                VertexNormal.field1510[var0][var1][var2] |= 585;
                                VertexNormal.field1510[var0][var1][var2 + 1] |= 1170;
                            } else if (var4 == 1) {
                                VertexNormal.field1510[var0][var1][1 + var2] |= 1170;
                                VertexNormal.field1510[var0][var1 + 1][var2] |= 585;
                            } else if (var4 == 2) {
                                VertexNormal.field1510[var0][var1 + 1][var2] |= 585;
                                VertexNormal.field1510[var0][var1][var2] |= 1170;
                            } else if (var4 == 3) {
                                VertexNormal.field1510[var0][var1][var2] |= 1170;
                                VertexNormal.field1510[var0][var1][var2] |= 585;
                            }
                        }

                        if (var26.interactType != 0 && var7 != null) {
                            var7.method3427(var1, var2, var5, var4, var26.boolean1);
                        }

                        if (var26.int2 != 16) {
                            var6.method2161(var0, var1, var2, var26.int2);
                        }

                    } else if (var5 == 3) {
                        if (var26.animationId == -1 && var26.transforms == null) {
                            var27 = var26.method669(3, var4, var15, var17, var16, var18);
                        } else {
                            var27 = new DynamicObject(var3, 3, var4, var0, var1, var2, var26.animationId, true, null);
                        }

                        var6.setBoundaryObject(var0, var1, var2, var16, (Renderable) var27, null, Tiles.field125[var4], 0, var19, var20);
                        if (var26.clipped) {
                            if (var4 == 0) {
                                Tiles.field132[var0][var1][var2 + 1] = 50;
                            } else if (var4 == 1) {
                                Tiles.field132[var0][var1 + 1][var2 + 1] = 50;
                            } else if (var4 == 2) {
                                Tiles.field132[var0][var1 + 1][var2] = 50;
                            } else if (var4 == 3) {
                                Tiles.field132[var0][var1][var2] = 50;
                            }
                        }

                        if (var26.interactType != 0 && var7 != null) {
                            var7.method3427(var1, var2, var5, var4, var26.boolean1);
                        }

                    } else if (var5 == 9) {
                        if (var26.animationId == -1 && var26.transforms == null) {
                            var27 = var26.method669(var5, var4, var15, var17, var16, var18);
                        } else {
                            var27 = new DynamicObject(var3, var5, var4, var0, var1, var2, var26.animationId, true, null);
                        }

                        var6.addGameObject(var0, var1, var2, var16, 1, 1, (Renderable) var27, 0, var19, var20);
                        if (var26.interactType != 0 && var7 != null) {
                            var7.method3428(var1, var2, var9, var10, var26.boolean1);
                        }

                        if (var26.int2 != 16) {
                            var6.method2161(var0, var1, var2, var26.int2);
                        }

                    } else if (var5 == 4) {
                        if (var26.animationId == -1 && var26.transforms == null) {
                            var27 = var26.method669(4, var4, var15, var17, var16, var18);
                        } else {
                            var27 = new DynamicObject(var3, 4, var4, var0, var1, var2, var26.animationId, true, null);
                        }

                        var6.setWallDecoration(var0, var1, var2, var16, (Renderable) var27, null, Tiles.field124[var4], 0, 0, 0, var19, var20);
                    } else if (var5 == 5) {
                        var21 = 16;
                        var22 = var6.method2057(var0, var1, var2);
                        if (var22 != 0) {
                            var21 = Definitions.getObject(var22 >> 14 & 32767).int2;
                        }

                        if (var26.animationId == -1 && var26.transforms == null) {
                            var23 = var26.method669(4, var4, var15, var17, var16, var18);
                        } else {
                            var23 = new DynamicObject(var3, 4, var4, var0, var1, var2, var26.animationId, true, null);
                        }

                        var6.setWallDecoration(var0, var1, var2, var16, (Renderable) var23, null, Tiles.field124[var4], 0, var21 * Tiles.field115[var4], var21 * Tiles.field127[var4], var19, var20);
                    } else if (var5 == 6) {
                        var21 = 8;
                        var22 = var6.method2057(var0, var1, var2);
                        if (var22 != 0) {
                            var21 = Definitions.getObject(var22 >> 14 & 32767).int2 / 2;
                        }

                        if (var26.animationId == -1 && var26.transforms == null) {
                            var23 = var26.method669(4, var4 + 4, var15, var17, var16, var18);
                        } else {
                            var23 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var26.animationId, true, null);
                        }

                        var6.setWallDecoration(var0, var1, var2, var16, (Renderable) var23, null, 256, var4, var21 * Tiles.field128[var4], var21 * Tiles.field134[var4], var19, var20);
                    } else if (var5 == 7) {
                        var22 = var4 + 2 & 3;
                        if (var26.animationId == -1 && var26.transforms == null) {
                            var27 = var26.method669(4, var22 + 4, var15, var17, var16, var18);
                        } else {
                            var27 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var26.animationId, true, null);
                        }

                        var6.setWallDecoration(var0, var1, var2, var16, (Renderable) var27, null, 256, var22, 0, 0, var19, var20);
                    } else if (var5 == 8) {
                        var21 = 8;
                        var22 = var6.method2057(var0, var1, var2);
                        if (var22 != 0) {
                            var21 = Definitions.getObject(var22 >> 14 & 32767).int2 / 2;
                        }

                        int var25 = var4 + 2 & 3;
                        Object var24;
                        if (var26.animationId == -1 && var26.transforms == null) {
                            var23 = var26.method669(4, var4 + 4, var15, var17, var16, var18);
                            var24 = var26.method669(4, var25 + 4, var15, var17, var16, var18);
                        } else {
                            var23 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var26.animationId, true, null);
                            var24 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var26.animationId, true, null);
                        }

                        var6.setWallDecoration(var0, var1, var2, var16, (Renderable) var23, (Renderable) var24, 256, var4, var21 * Tiles.field128[var4], var21 * Tiles.field134[var4], var19, var20);
                    }
                }
            } else {
                if (var26.animationId == -1 && var26.transforms == null) {
                    var27 = var26.method669(10, var4, var15, var17, var16, var18);
                } else {
                    var27 = new DynamicObject(var3, 10, var4, var0, var1, var2, var26.animationId, true, null);
                }

                if (var27 != null && var6.addGameObject(var0, var1, var2, var16, var9, var10, (Renderable) var27, var5 == 11 ? 256 : 0, var19, var20) && var26.clipped) {
                    var22 = 15;
                    if (var27 instanceof Model) {
                        var22 = ((Model) var27).method2474() / 4;
                        if (var22 > 30) {
                            var22 = 30;
                        }
                    }

                    for (int var29 = 0; var29 <= var9; ++var29) {
                        for (int var30 = 0; var30 <= var10; ++var30) {
                            if (var22 > Tiles.field132[var0][var29 + var1][var30 + var2]) {
                                Tiles.field132[var0][var29 + var1][var30 + var2] = (byte) var22;
                            }
                        }
                    }
                }

                if (var26.interactType != 0 && var7 != null) {
                    var7.method3428(var1, var2, var9, var10, var26.boolean1);
                }

            }
        }
    }

    static final void method297(Player var0, int var1, int var2, int var3) {
        if (Tiles.localPlayer != var0) {
            if (Client.menuOptionsCount < 400) {
                String var4;
                int var7;
                if (var0.skillLevel == 0) {
                    String var5 = var0.field35;
                    var7 = var0.combatLevel;
                    int var8 = Tiles.localPlayer.combatLevel;
                    int var9 = var8 - var7;
                    String var6;
                    if (var9 < -9) {
                        var6 = ScriptEvent.method0(16711680);
                    } else if (var9 < -6) {
                        var6 = ScriptEvent.method0(16723968);
                    } else if (var9 < -3) {
                        var6 = ScriptEvent.method0(16740352);
                    } else if (var9 < 0) {
                        var6 = ScriptEvent.method0(16756736);
                    } else if (var9 > 9) {
                        var6 = ScriptEvent.method0(65280);
                    } else if (var9 > 6) {
                        var6 = ScriptEvent.method0(4259584);
                    } else if (var9 > 3) {
                        var6 = ScriptEvent.method0(8453888);
                    } else if (var9 > 0) {
                        var6 = ScriptEvent.method0(12648192);
                    } else {
                        var6 = ScriptEvent.method0(16776960);
                    }

                    var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                } else {
                    var4 = var0.field35 + " " + " (" + "skill-" + var0.skillLevel + ")";
                }

                int var10;
                if (Client.isItemSelected == 1) {
                    ArchiveDisk.method1503("Use", Client.selectedItemName + " " + "->" + " " + ScriptEvent.method0(16777215) + var4, 14, var1, var2, var3);
                } else if (Client.isSpellSelected) {
                    if ((FaceNormal.field1523 & 8) == 8) {
                        ArchiveDisk.method1503(Client.field641, Client.field594 + " " + "->" + " " + ScriptEvent.method0(16777215) + var4, 15, var1, var2, var3);
                    }
                } else {
                    for (var10 = 7; var10 >= 0; --var10) {
                        if (Client.playerMenuActions[var10] != null) {
                            short var11 = 0;
                            if (Client.playerMenuActions[var10].equalsIgnoreCase("Attack")) {
                                if (var0.combatLevel > Tiles.localPlayer.combatLevel) {
                                    var11 = 2000;
                                }

                                if (Tiles.localPlayer.team != 0 && var0.team != 0) {
                                    if (var0.team == Tiles.localPlayer.team) {
                                        var11 = 2000;
                                    } else {
                                        var11 = 0;
                                    }
                                }
                            } else if (Client.playerOptionsPriorities[var10]) {
                                var11 = 2000;
                            }

                            boolean var12 = false;
                            var7 = Client.playerMenuOpcodes[var10] + var11;
                            ArchiveDisk.method1503(Client.playerMenuActions[var10], ScriptEvent.method0(16777215) + var4, var7, var1, var2, var3);
                        }
                    }
                }

                for (var10 = 0; var10 < Client.menuOptionsCount; ++var10) {
                    if (Client.menuOpcodes[var10] == 23) {
                        Client.menuTargets[var10] = ScriptEvent.method0(16777215) + var4;
                        break;
                    }
                }

            }
        }
    }
}
