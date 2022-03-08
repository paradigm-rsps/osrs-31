package osrs;

import meteor.Configuration;
import osrs.cache.Definitions;
import osrs.classic.server.util.logger.Logger;

public final class NPC extends Actor {
    static Widget field398;
    static GameBuild field400;
    static SpritePixels[] modIconSprites;
    static int cameraPitch;
    NPCComposition definition;

    protected final Model vmethod2030() {
        if (this.definition == null) {
            return null;
        } else {
            AnimationDefinition var1 = super.animation != -1 && super.sequenceDelay == 0 ? Definitions.getAnimation(super.animation) : null;
            AnimationDefinition var2 = super.movementSequence == -1 || super.idleSequence == super.movementSequence && var1 != null ? null : Definitions.getAnimation(super.movementSequence);
            Model var3 = this.definition.method643(var1, super.sequenceFrame, var2, super.movementFrame);
            if (var3 == null) {
                return null;
            } else {
                var3.method2427();
                super.defaultHeight = var3.height;
                if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
                    Model var4 = NPCComposition.method656(super.spotAnimation).method766(super.spotAnimationFrame);
                    if (var4 != null) {
                        var4.method2451(0, -super.field430, 0);
                        Model[] var5 = new Model[]{var3, var4};
                        var3 = new Model(var5, 2);
                    }
                }

                if (this.definition.size == 1) {
                    var3.isSingleTile = true;
                }

                return var3;
            }
        }
    }

    final boolean vmethod281() {
        return this.definition != null;
    }

    static final void method268(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionMap[] var8) {
        int var10;
        for (int var9 = 0; var9 < 8; ++var9) {
            for (var10 = 0; var10 < 8; ++var10) {
                if (var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
                    var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
                }
            }
        }

        Buffer var20 = new Buffer(var0);

        for (var10 = 0; var10 < 4; ++var10) {
            for (int var11 = 0; var11 < 64; ++var11) {
                for (int var12 = 0; var12 < 64; ++var12) {
                    if (var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                        int var17 = var11 & 7;
                        int var18 = var12 & 7;
                        int var19 = var7 & 3;
                        int var16;
                        if (var19 == 0) {
                            var16 = var17;
                        } else if (var19 == 1) {
                            var16 = var18;
                        } else if (var19 == 2) {
                            var16 = 7 - var17;
                        } else {
                            var16 = 7 - var18;
                        }

                        Player.method26(var20, var1, var16 + var2, var3 + class7.method57(var11 & 7, var12 & 7, var7), 0, 0, var7);
                    } else {
                        Player.method26(var20, 0, -1, -1, 0, 0, 0);
                    }
                }
            }
        }

    }

    static void updateGameState(int var0) {
        if (Configuration.debugLogin)
            Logger.INSTANCE.debug("GameState {}", var0);
        if (var0 != Client.gameState) {
            if (Client.gameState == 0) {
                NPCComposition.field801 = null;
                World.field206 = null;
                Loot.field1659 = null;
            }

            if (var0 == 20 || var0 == 40) {
                Client.loginStep = 0;
                Client.socketIdleCycles = 0;
                Client.connectedState = 0;
            }

            if (var0 != 20 && var0 != 40 && EnumComposition.field978 != null) {
                EnumComposition.field978.method1471();
                EnumComposition.field978 = null;
            }

            if (Client.gameState == 25) {
                Client.field537 = 0;
                Client.field509 = 0;
                Client.field560 = 1;
                Client.field510 = 0;
                Client.field491 = 1;
            }

            if (var0 != 5 && var0 != 10 && var0 != 20) {
                if (Login.field318) {
                    Login.field314 = null;
                    Login.field315 = null;
                    Login.field341 = null;
                    Login.field317 = null;
                    Login.field332 = null;
                    Login.field319 = null;
                    class68.field1273 = null;
                    class1.worldSelectBackSprites = null;
                    Login.worldSelectFlagSprites = null;
                    FileSystem.worldSelectArrows = null;
                    class159.worldSelectStars = null;
                    class120.field2015 = null;
                    Tiles.field129 = null;
                    Login.field324 = null;
                    class1.field22 = null;
                    Buffer.field2040 = null;
                    InterfaceParent.field58 = null;
                    class125.field2034 = null;
                    AbstractByteArrayCopier.field2005 = null;
                    Login.field327 = null;
                    Interpreter.method270(2);
                    class149.method3176(true);
                    Login.field318 = false;
                }
            } else {
                java.awt.Canvas var1 = Tiles.field131;
                Archive var2 = DynamicObject.archive10;
                Archive var3 = MouseRecorder.archive8;
                if (!Login.field318) {
                    Rasterizer2D.method1957();
                    byte[] var4 = var2.method3263("title.jpg", "");
                    Login.field317 = new SpritePixels(var4, var1);
                    Login.field332 = Login.field317.method1826();
                    Login.field319 = TaskHandler.method1598(var3, "logo", "");
                    Login.field314 = TaskHandler.method1598(var3, "titlebox", "");
                    Login.field315 = TaskHandler.method1598(var3, "titlebutton", "");
                    Login.field341 = ObjectSound.method52(var3, "runes", "");
                    class68.field1273 = ObjectSound.method52(var3, "title_mute", "");
                    Tiles.field129 = new int[256];

                    int var5;
                    for (var5 = 0; var5 < 64; ++var5) {
                        Tiles.field129[var5] = var5 * 262144;
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        Tiles.field129[var5 + 64] = var5 * 1024 + 16711680;
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        Tiles.field129[var5 + 128] = var5 * 4 + 16776960;
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        Tiles.field129[var5 + 192] = 16777215;
                    }

                    Login.field324 = new int[256];

                    for (var5 = 0; var5 < 64; ++var5) {
                        Login.field324[var5] = var5 * 1024;
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        Login.field324[var5 + 64] = var5 * 4 + '\uff00';
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        Login.field324[var5 + 128] = var5 * 262144 + '\uffff';
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        Login.field324[var5 + 192] = 16777215;
                    }

                    class1.field22 = new int[256];

                    for (var5 = 0; var5 < 64; ++var5) {
                        class1.field22[var5] = var5 * 4;
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        class1.field22[var5 + 64] = var5 * 262144 + 255;
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        class1.field22[var5 + 128] = var5 * 1024 + 16711935;
                    }

                    for (var5 = 0; var5 < 64; ++var5) {
                        class1.field22[var5 + 192] = 16777215;
                    }

                    Buffer.field2040 = new int[256];
                    InterfaceParent.field58 = new int['耀'];
                    class125.field2034 = new int['耀'];
                    TileItem.method181(null);
                    AbstractByteArrayCopier.field2005 = new int['耀'];
                    Login.field327 = new int['耀'];
                    Login.field351 = 0;
                    Login.field338 = "";
                    Login.field339 = "";
                    Login.worldSelectOpen = false;
                    if (!Projectile.clientPreferences.titleMusicDisabled) {
                        //Script.method34(2, class40.archive6, "scape main", "", 255, false);
                    } else {
                        Interpreter.method270(2);
                    }

                    class149.method3176(false);
                    Login.field318 = true;
                    Login.field317.method1835(0, 0);
                    Login.field332.method1835(382, 0);
                    Login.field319.method1936(382 - Login.field319.subWidth / 2, 18);
                }
            }

            Client.gameState = var0;
        }
    }

    static final void method267(boolean var0) {
        if (Tiles.localPlayer.x >> 7 == Client.field715 && Tiles.localPlayer.y >> 7 == Client.field716) {
            Client.field715 = 0;
        }

        int var1 = Client.field604;
        if (var0) {
            var1 = 1;
        }

        for (int var2 = 0; var2 < var1; ++var2) {
            Player var3;
            int var4;
            if (var0) {
                var3 = Tiles.localPlayer;
                var4 = 33538048;
            } else {
                var3 = Client.players[Client.field524[var2]];
                var4 = Client.field524[var2] << 14;
            }

            if (var3 != null && var3.vmethod281()) {
                var3.isUnanimated = (Client.isLowDetail && Client.field604 > 50 || Client.field604 > 200) && !var0 && var3.idleSequence == var3.movementSequence;

                int var5 = var3.x >> 7;
                int var6 = var3.y >> 7;
                if (var5 >= 0 && var5 < 104 && var6 >= 0 && var6 < 104) {
                    if (var3.model0 != null && Client.cycle >= var3.animationCycleStart && Client.cycle < var3.animationCycleEnd) {
                        var3.isUnanimated = false;
                        var3.tileHeight = BufferedFile.getTileHeight(var3.x, var3.y, class22.scenePlane);
                        Interpreter.scene.method2053(class22.scenePlane, var3.x, var3.y, var3.tileHeight, 60, var3, var3.field432, var4, var3.minX, var3.minY, var3.maxX, var3.maxY);
                    } else {
                        if ((var3.x & 127) == 64 && (var3.y & 127) == 64) {
                            if (Client.field586[var5][var6] == Client.field724) {
                                continue;
                            }

                            Client.field586[var5][var6] = Client.field724;
                        }

                        var3.tileHeight = BufferedFile.getTileHeight(var3.x, var3.y, class22.scenePlane);
                        Interpreter.scene.method2094(class22.scenePlane, var3.x, var3.y, var3.tileHeight, 60, var3, var3.field432, var4, var3.isWalking);
                    }
                }
            }
        }

    }

    static final void method262(int var0, int var1) {
        if (Client.hintArrowType == 2) {
            class1.method8((Client.hintArrowX - FaceNormal.baseX << 7) + Client.field504, (Client.hintArrowY - Frames.baseY << 7) + Client.field505, Client.field479 * 2);
            if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
                ObjectSound.headIconHintSprites[0].method1855(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
            }

        }
    }

    static final void method266(int var0, int var1, int var2, int var3) {
        for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
            if (Client.rootWidgetXs[var4] + Client.rootWidgetWidths[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetHeights[var4] + Client.rootWidgetYs[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
                Client.field686[var4] = true;
            }
        }

    }

    static final void method254(Widget[] var0, int var1) {
        for (int var2 = 0; var2 < var0.length; ++var2) {
            Widget var3 = var0[var2];
            if (var3 != null) {
                if (var3.type == 0) {
                    if (var3.children != null) {
                        method254(var3.children, var1);
                    }

                    InterfaceParent var4 = (InterfaceParent) Client.interfaceParents.method3512(var3.id);
                    if (var4 != null) {
                        SceneTilePaint.method2208(var4.group, var1);
                    }
                }

                ScriptEvent var5;
                if (var1 == 0 && var3.onDialogAbort != null) {
                    var5 = new ScriptEvent();
                    var5.widget = var3;
                    var5.args = var3.onDialogAbort;
                    Renderable.method2040(var5);
                }

                if (var1 == 1 && var3.onSubChange != null) {
                    if (var3.childIndex >= 0) {
                        Widget var6 = class130.getWidget(var3.id);
                        if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
                            continue;
                        }
                    }

                    var5 = new ScriptEvent();
                    var5.widget = var3;
                    var5.args = var3.onSubChange;
                    Renderable.method2040(var5);
                }
            }
        }

    }

    static final void method256(int var0, String var1, String text, String var3) {
        for (int var4 = 99; var4 > 0; --var4) {
            Client.field694[var4] = Client.field694[var4 - 1];
            Client.field695[var4] = Client.field695[var4 - 1];
            Client.field697[var4] = Client.field697[var4 - 1];
            Client.field696[var4] = Client.field696[var4 - 1];
        }

        Client.field694[0] = var0;
        Client.field695[0] = var1;
        Client.field697[0] = text;
        Client.field696[0] = var3;
        ++Client.field580;
        Client.field482 = Client.field681;
    }

    static final void method264(String var0) {
        if (var0 != null) {
            if ((Client.field736 < 200 || Client.isMember == 1) && Client.field736 < 400) {
                String var1 = Projectile.method125(var0, class5.field75);
                if (var1 != null) {
                    int var2;
                    String var4;
                    String var5;
                    for (var2 = 0; var2 < Client.field736; ++var2) {
                        class22 var7 = Client.field532[var2];
                        var4 = Projectile.method125(var7.field381, class5.field75);
                        if (var4 != null && var4.equals(var1)) {
                            Login.setOverheadText(0, "", var0 + " is already on your friend list");
                            return;
                        }

                        if (var7.field369 != null) {
                            var5 = Projectile.method125(var7.field369, class5.field75);
                            if (var5 != null && var5.equals(var1)) {
                                Login.setOverheadText(0, "", var0 + " is already on your friend list");
                                return;
                            }
                        }
                    }

                    for (var2 = 0; var2 < Client.field534; ++var2) {
                        class10 var8 = Client.field741[var2];
                        var4 = Projectile.method125(var8.field177, class5.field75);
                        if (var4 != null && var4.equals(var1)) {
                            Login.setOverheadText(0, "", "Please remove " + var0 + " from your ignore list first");
                            return;
                        }

                        if (var8.field178 != null) {
                            var5 = Projectile.method125(var8.field178, class5.field75);
                            if (var5 != null && var5.equals(var1)) {
                                Login.setOverheadText(0, "", "Please remove " + var0 + " from your ignore list first");
                                return;
                            }
                        }
                    }

                    if (Projectile.method125(Tiles.localPlayer.field35, class5.field75).equals(var1)) {
                        Login.setOverheadText(0, "", "You can't add yourself to your own friend list");
                    } else {
                        Client.rsaBuf.writeByteOpcode(10);
                        PacketBuffer var6 = Client.rsaBuf;
                        int var3 = var0.length() + 1;
                        var6.writeByte(var3);
                        Client.rsaBuf.writeStringCp1252NullTerminated(var0);
                    }
                }
            } else {
                Login.setOverheadText(0, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
            }
        }
    }

    static final void method265(String var0) {
        if (var0 != null) {
            String var1 = Projectile.method125(var0, class5.field75);
            if (var1 != null) {
                for (int var2 = 0; var2 < Client.field736; ++var2) {
                    class22 var3 = Client.field532[var2];
                    String var4 = var3.field381;
                    String var5 = Projectile.method125(var4, class5.field75);
                    if (BufferedFile.method599(var0, var1, var4, var5)) {
                        --Client.field736;

                        for (int var6 = var2; var6 < Client.field736; ++var6) {
                            Client.field532[var6] = Client.field532[var6 + 1];
                        }

                        Client.field674 = Client.field681;
                        Client.rsaBuf.writeByteOpcode(197);
                        PacketBuffer var8 = Client.rsaBuf;
                        int var7 = var0.length() + 1;
                        var8.writeByte(var7);
                        Client.rsaBuf.writeStringCp1252NullTerminated(var0);
                        break;
                    }
                }

            }
        }
    }
}
