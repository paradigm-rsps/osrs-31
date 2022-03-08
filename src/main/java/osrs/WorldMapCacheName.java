package osrs;

import osrs.cache.Definitions;

import java.io.IOException;

public class WorldMapCacheName {
    public static final WorldMapCacheName field2783 = new WorldMapCacheName("7", "7");
    public static final WorldMapCacheName field2776 = new WorldMapCacheName("3", "3");
    public static final WorldMapCacheName field2777 = new WorldMapCacheName("1", "1");
    public static final WorldMapCacheName field2778 = new WorldMapCacheName("2", "2");
    public static final WorldMapCacheName field2779 = new WorldMapCacheName("5", "5");
    public static final WorldMapCacheName field2780 = new WorldMapCacheName("6", "6");
    public static final WorldMapCacheName field2775 = new WorldMapCacheName("9", "9");
    public static final WorldMapCacheName field2782 = new WorldMapCacheName("8", "8");
    public static final WorldMapCacheName field2781 = new WorldMapCacheName("4", "4");
    public final String field2784;

    WorldMapCacheName(String var1, String var2) {
        this.field2784 = var2;
    }

    static final void method3469() {
        if (Client.field585 > 1) {
            --Client.field585;
        }

        if (Client.logoutTimer > 0) {
            --Client.logoutTimer;
        }

        if (Client.field530) {
            Client.field530 = false;
            Clock.method1461();
        } else {
            int var0;
            for (var0 = 0; var0 < 100 && JagexCache.handleServerPacket(); ++var0) {
            }

            if (Client.gameState == 30) {
                Object var16 = BoundaryObject.field1625.lock;
                int var1;
                int var2;
                int var3;
                int var4;
                int var5;
                int var6;
                int var7;
                int var8;
                synchronized (BoundaryObject.field1625.lock) {
                    if (!Client.ViewportMouse_isInViewport) {
                        BoundaryObject.field1625.index = 0;
                    } else if (MouseHandler.PacketBufferNode_packetBufferNodeCount != 0 || BoundaryObject.field1625.index >= 40) {
                        Client.rsaBuf.writeByteOpcode(220);
                        Client.rsaBuf.writeByte(0);
                        var1 = Client.rsaBuf.offset;
                        var2 = 0;

                        for (var3 = 0; var3 < BoundaryObject.field1625.index && Client.rsaBuf.offset - var1 < 240; ++var3) {
                            ++var2;
                            var4 = BoundaryObject.field1625.ys[var3];
                            if (var4 < 0) {
                                var4 = 0;
                            } else if (var4 > 502) {
                                var4 = 502;
                            }

                            var5 = BoundaryObject.field1625.xs[var3];
                            if (var5 < 0) {
                                var5 = 0;
                            } else if (var5 > 764) {
                                var5 = 764;
                            }

                            var6 = var5 + var4 * 765;
                            if (BoundaryObject.field1625.ys[var3] == -1 && BoundaryObject.field1625.xs[var3] == -1) {
                                var5 = -1;
                                var4 = -1;
                                var6 = 524287;
                            }

                            if (var5 == Client.field492 && var4 == Client.field493) {
                                if (Client.field494 < 2047) {
                                    ++Client.field494;
                                }
                            } else {
                                var7 = var5 - Client.field492;
                                Client.field492 = var5;
                                var8 = var4 - Client.field493;
                                Client.field493 = var4;
                                if (Client.field494 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                                    var7 += 32;
                                    var8 += 32;
                                    Client.rsaBuf.writeShort(var8 + (Client.field494 << 12) + (var7 << 6));
                                    Client.field494 = 0;
                                } else if (Client.field494 < 8) {
                                    Client.rsaBuf.writeMedium((Client.field494 << 19) + var6 + 8388608);
                                    Client.field494 = 0;
                                } else {
                                    Client.rsaBuf.writeInt((Client.field494 << 19) + var6 + -1073741824);
                                    Client.field494 = 0;
                                }
                            }
                        }

                        Client.rsaBuf.writeLengthByte(Client.rsaBuf.offset - var1);
                        if (var2 >= BoundaryObject.field1625.index) {
                            BoundaryObject.field1625.index = 0;
                        } else {
                            BoundaryObject.field1625.index -= var2;

                            for (var3 = 0; var3 < BoundaryObject.field1625.index; ++var3) {
                                BoundaryObject.field1625.xs[var3] = BoundaryObject.field1625.xs[var2 + var3];
                                BoundaryObject.field1625.ys[var3] = BoundaryObject.field1625.ys[var3 + var2];
                            }
                        }
                    }
                }

                if (MouseHandler.PacketBufferNode_packetBufferNodeCount != 0) {
                    long var17 = (MouseHandler.field1399 - Client.field545) / 50L;
                    if (var17 > 4095L) {
                        var17 = 4095L;
                    }

                    Client.field545 = MouseHandler.field1399;
                    var2 = MouseHandler.MouseHandler_lastPressedY;
                    if (var2 < 0) {
                        var2 = 0;
                    } else if (var2 > 502) {
                        var2 = 502;
                    }

                    var3 = MouseHandler.MouseHandler_lastPressedX;
                    if (var3 < 0) {
                        var3 = 0;
                    } else if (var3 > 764) {
                        var3 = 764;
                    }

                    var4 = var3 + var2 * 765;
                    byte var35 = 0;
                    if (MouseHandler.PacketBufferNode_packetBufferNodeCount == 2) {
                        var35 = 1;
                    }

                    var6 = (int) var17;
                    Client.rsaBuf.writeByteOpcode(205);
                    Client.rsaBuf.writeInt((var6 << 20) + var4 + (var35 << 19));
                }

                if (KeyHandler.field1364 > 0) {
                    Client.rsaBuf.writeByteOpcode(111);
                    Client.rsaBuf.writeShort(0);
                    var0 = Client.rsaBuf.offset;
                    long var19 = ClientPreferences.method148();

                    for (var3 = 0; var3 < KeyHandler.field1364; ++var3) {
                        long var21 = var19 - Client.field707;
                        if (var21 > 16777215L) {
                            var21 = 16777215L;
                        }

                        Client.field707 = var19;
                        Client.rsaBuf.method2675((int) var21);
                        Client.rsaBuf.method2667(KeyHandler.field1348[var3]);
                    }

                    Client.rsaBuf.writeLengthShort(Client.rsaBuf.offset - var0);
                }

                if (Client.field573 > 0) {
                    --Client.field573;
                }

                if (KeyHandler.KeyHandler_pressedKeys[96] || KeyHandler.KeyHandler_pressedKeys[97] || KeyHandler.KeyHandler_pressedKeys[98] || KeyHandler.KeyHandler_pressedKeys[99]) {
                    Client.field599 = true;
                }

                if (Client.field599 && Client.field573 <= 0) {
                    Client.field573 = 20;
                    Client.field599 = false;
                    Client.rsaBuf.writeByteOpcode(97);
                    Client.rsaBuf.writeShort(Client.field516);
                    Client.rsaBuf.writeShortLE(Client.field569);
                }

                if (class23.hasFocus && !Client.field613) {
                    Client.field613 = true;
                    Client.rsaBuf.writeByteOpcode(116);
                    Client.rsaBuf.writeByte(1);
                }

                if (!class23.hasFocus && Client.field613) {
                    Client.field613 = false;
                    Client.rsaBuf.writeByteOpcode(116);
                    Client.rsaBuf.writeByte(0);
                }

                int var10;
                int var24;
                if (Client.isLowDetail && Client.renderPlane != class22.scenePlane) {
                    class5.updateScene(Client.chunkX, Client.chunkY, class22.scenePlane, Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0]);
                } else if (Client.field710 != class22.scenePlane) {
                    Client.field710 = class22.scenePlane;
                    var0 = class22.scenePlane;
                    int[] var23 = MouseRecorder.sceneMinimapSprite.pixels;
                    var2 = var23.length;

                    for (var3 = 0; var3 < var2; ++var3) {
                        var23[var3] = 0;
                    }

                    for (var3 = 1; var3 < 103; ++var3) {
                        var4 = (103 - var3) * 2048 + 24628;

                        for (var5 = 1; var5 < 103; ++var5) {
                            if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
                                Interpreter.scene.method2075(var23, var4, 512, var0, var5, var3);
                            }

                            if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
                                Interpreter.scene.method2075(var23, var4, 512, var0 + 1, var5, var3);
                            }

                            var4 += 4;
                        }
                    }

                    var3 = (238 + (int) (Math.random() * 20.0D) - 10 << 16) + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + (238 + (int) (Math.random() * 20.0D) - 10);
                    var4 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
                    MouseRecorder.sceneMinimapSprite.method1862();

                    for (var5 = 1; var5 < 103; ++var5) {
                        for (var6 = 1; var6 < 103; ++var6) {
                            if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
                                Tiles.method59(var0, var6, var5, var3, var4);
                            }

                            if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
                                Tiles.method59(var0 + 1, var6, var5, var3, var4);
                            }
                        }
                    }

                    Client.field711 = 0;

                    for (var5 = 0; var5 < 104; ++var5) {
                        for (var6 = 0; var6 < 104; ++var6) {
                            var7 = Interpreter.scene.method2070(class22.scenePlane, var5, var6);
                            if (var7 != 0) {
                                var7 = var7 >> 14 & 32767;
                                var8 = Definitions.getObject(var7).field848;
                                if (var8 >= 0) {
                                    var24 = var5;
                                    var10 = var6;
                                    if (var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                                        int[][] var13 = Client.collisionMaps[class22.scenePlane].flags;

                                        for (int var14 = 0; var14 < 10; ++var14) {
                                            int var15 = (int) (Math.random() * 4.0D);
                                            if (var15 == 0 && var24 > 0 && var24 > var5 - 3 && (var13[var24 - 1][var10] & 19661064) == 0) {
                                                --var24;
                                            }

                                            if (var15 == 1 && var24 < 103 && var24 < var5 + 3 && (var13[var24 + 1][var10] & 19661184) == 0) {
                                                ++var24;
                                            }

                                            if (var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var24][var10 - 1] & 19661058) == 0) {
                                                --var10;
                                            }

                                            if (var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var24][var10 + 1] & 19661088) == 0) {
                                                ++var10;
                                            }
                                        }
                                    }

                                    Client.field714[Client.field711] = class134.headIconPkSprites[var8];
                                    Client.field712[Client.field711] = var24;
                                    Client.field713[Client.field711] = var10;
                                    ++Client.field711;
                                }
                            }
                        }
                    }

                    MouseRecorder.field262.method1822();
                }

                if (Client.gameState == 30) {
                    SoundSystem.method1329();

                    for (var0 = 0; var0 < Client.soundEffectCount; ++var0) {
                        --Client.field727[var0];
                        if (Client.field727[var0] >= -10) {
                            SoundEffect var39 = Client.field729[var0];
                            if (var39 == null) {
                                Object var10000 = null;
                                var39 = SoundEffect.method1352(class7.field102, Client.field742[var0], 0);
                                if (var39 == null) {
                                    continue;
                                }

                                Client.field727[var0] += var39.method1344();
                                Client.field729[var0] = var39;
                            }

                            if (Client.field727[var0] < 0) {
                                if (Client.field589[var0] != 0) {
                                    var3 = (Client.field589[var0] & 255) * 128;
                                    var4 = Client.field589[var0] >> 16 & 255;
                                    var5 = var4 * 128 + 64 - Tiles.localPlayer.x;
                                    if (var5 < 0) {
                                        var5 = -var5;
                                    }

                                    var6 = Client.field589[var0] >> 8 & 255;
                                    var7 = var6 * 128 + 64 - Tiles.localPlayer.y;
                                    if (var7 < 0) {
                                        var7 = -var7;
                                    }

                                    var8 = var7 + var5 - 128;
                                    if (var8 > var3) {
                                        Client.field727[var0] = -100;
                                        continue;
                                    }

                                    if (var8 < 0) {
                                        var8 = 0;
                                    }

                                    var2 = (var3 - var8) * Client.field538 / var3;
                                } else {
                                    var2 = Client.field721;
                                }

                                if (var2 > 0) {
                                    RawSound var25 = var39.method1343().method1413(MouseHandler.field1392);
                                    RawPcmStream var26 = RawPcmStream.method1091(var25, 100, var2);
                                    var26.method1055(Client.field726[var0] - 1);
                                    ItemContainer.pcmStreamMixer.method1126(var26);
                                }

                                Client.field727[var0] = -100;
                            }
                        } else {
                            --Client.soundEffectCount;

                            for (var1 = var0; var1 < Client.soundEffectCount; ++var1) {
                                Client.field742[var1] = Client.field742[var1 + 1];
                                Client.field729[var1] = Client.field729[var1 + 1];
                                Client.field726[var1] = Client.field726[var1 + 1];
                                Client.field727[var1] = Client.field727[var1 + 1];
                                Client.field589[var1] = Client.field589[var1 + 1];
                            }

                            --var0;
                        }
                    }

                    if (Client.field562) {
                        boolean var32;
                        if (class137.musicPlayerStatus != 0) {
                            var32 = true;
                        } else {
                            var32 = class137.midiPcmStream.method2922();
                        }

                        if (!var32) {
                            if (Client.field718 != 0 && Client.currentTrackGroupId != -1) {
                                class161.method3399(class40.archive6, Client.currentTrackGroupId, 0, Client.field718, false);
                            }

                            Client.field562 = false;
                        }
                    }

                    ++Client.field565;
                    if (Client.field565 > 750) {
                        Clock.method1461();
                    } else {
                        Player var27;
                        for (var0 = -1; var0 < Client.field604; ++var0) {
                            if (var0 == -1) {
                                var1 = 2047;
                            } else {
                                var1 = Client.field524[var0];
                            }

                            var27 = Client.players[var1];
                            if (var27 != null) {
                                AbstractByteArrayCopier.method2569(var27, 1);
                            }
                        }

                        NPC var43;
                        for (var0 = 0; var0 < Client.npcCount; ++var0) {
                            var1 = Client.npcIndices[var0];
                            var43 = Client.npcs[var1];
                            if (var43 != null) {
                                AbstractByteArrayCopier.method2569(var43, var43.definition.size);
                            }
                        }

                        for (var0 = -1; var0 < Client.field604; ++var0) {
                            if (var0 == -1) {
                                var1 = 2047;
                            } else {
                                var1 = Client.field524[var0];
                            }

                            var27 = Client.players[var1];
                            if (var27 != null && var27.field435 > 0) {
                                --var27.field435;
                                if (var27.field435 == 0) {
                                    var27.overheadText = null;
                                }
                            }
                        }

                        for (var0 = 0; var0 < Client.npcCount; ++var0) {
                            var1 = Client.npcIndices[var0];
                            var43 = Client.npcs[var1];
                            if (var43 != null && var43.field435 > 0) {
                                --var43.field435;
                                if (var43.field435 == 0) {
                                    var43.overheadText = null;
                                }
                            }
                        }

                        ++Client.field525;
                        if (Client.mouseCrossColor != 0) {
                            Client.mouseCrossState += 20;
                            if (Client.mouseCrossState >= 400) {
                                Client.mouseCrossColor = 0;
                            }
                        }

                        if (Projectile.field161 != null) {
                            ++Client.field533;
                            if (Client.field533 >= 15) {
                                class82.invalidateWidget(Projectile.field161);
                                Projectile.field161 = null;
                            }
                        }

                        Widget var38;
                        if (AnimationDefinition.field887 != null) {
                            class82.invalidateWidget(AnimationDefinition.field887);
                            ++Client.field639;
                            if (MouseHandler.MouseHandler_x > Client.field597 + 5 || MouseHandler.MouseHandler_x < Client.field597 - 5 || MouseHandler.MouseHandler_y > Client.field598 + 5 || MouseHandler.MouseHandler_y < Client.field598 - 5) {
                                Client.field600 = true;
                            }

                            if (MouseHandler.MouseHandler_currentButton == 0) {
                                if (Client.field600 && Client.field639 >= 5) {
                                    if (AnimationDefinition.field887 == class7.field113 && Client.field596 != Client.field655) {
                                        var38 = AnimationDefinition.field887;
                                        byte var33 = 0;
                                        if (Client.field646 == 1 && var38.contentType == 206) {
                                            var33 = 1;
                                        }

                                        if (var38.itemIds[Client.field655] <= 0) {
                                            var33 = 0;
                                        }

                                        var3 = SoundSystem.method1326(var38);
                                        boolean var34 = (var3 >> 29 & 1) != 0;
                                        if (var34) {
                                            var4 = Client.field596;
                                            var5 = Client.field655;
                                            var38.itemIds[var5] = var38.itemIds[var4];
                                            var38.itemQuantities[var5] = var38.itemQuantities[var4];
                                            var38.itemIds[var4] = -1;
                                            var38.itemQuantities[var4] = 0;
                                        } else if (var33 == 1) {
                                            var4 = Client.field596;
                                            var5 = Client.field655;

                                            while (var5 != var4) {
                                                if (var4 > var5) {
                                                    var38.method3340(var4 - 1, var4);
                                                    --var4;
                                                } else if (var4 < var5) {
                                                    var38.method3340(var4 + 1, var4);
                                                    ++var4;
                                                }
                                            }
                                        } else {
                                            var38.method3340(Client.field655, Client.field596);
                                        }

                                        Client.rsaBuf.writeByteOpcode(42);
                                        Client.rsaBuf.writeIntLE(AnimationDefinition.field887.id);
                                        Client.rsaBuf.writeShortAdd(Client.field596);
                                        Client.rsaBuf.writeByte(var33);
                                        Client.rsaBuf.writeShortAddLE(Client.field655);
                                    }
                                } else if ((Client.leftClickOpensMenu == 1 || PlatformInfo.method3190(Client.menuOptionsCount - 1)) && Client.menuOptionsCount > 2) {
                                    class1.method9();
                                } else if (Client.menuOptionsCount > 0) {
                                    Frames.method2392(Client.menuOptionsCount - 1);
                                }

                                Client.field533 = 10;
                                MouseHandler.PacketBufferNode_packetBufferNodeCount = 0;
                                AnimationDefinition.field887 = null;
                            }
                        }

                        var38 = Tiles.mousedOverWidgetIf1;
                        Widget var40 = NPC.field398;
                        Tiles.mousedOverWidgetIf1 = null;
                        NPC.field398 = null;
                        Client.field658 = null;
                        Client.field703 = false;
                        Client.field659 = false;

                        for (Client.field704 = 0; Client.method530() && Client.field704 < 128; ++Client.field704) {
                            Client.field612[Client.field704] = VarbitComposition.field966;
                            Client.field705[Client.field704] = IsaacCipher.field2000;
                        }

                        VarpDefinition.drawWidgets(Client.rootInterface, 0, 0, 765, 503, 0, 0);
                        ++Client.field681;

                        while (true) {
                            Widget var41;
                            Widget var42;
                            ScriptEvent var44;
                            do {
                                var44 = (ScriptEvent) Client.field745.method3549();
                                if (var44 == null) {
                                    while (true) {
                                        do {
                                            var44 = (ScriptEvent) Client.field682.method3549();
                                            if (var44 == null) {
                                                while (true) {
                                                    do {
                                                        var44 = (ScriptEvent) Client.field536.method3549();
                                                        if (var44 == null) {
                                                            if (Client.clickedWidget != null) {
                                                                Projectile.method123();
                                                            }

                                                            if (Scene.Scene_selectedX != -1) {
                                                                var2 = Scene.Scene_selectedX;
                                                                var3 = Scene.Scene_selectedY;
                                                                boolean var36 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var2, var3, true, 0, 0, 0, 0, 0, 0);
                                                                Scene.Scene_selectedX = -1;
                                                                if (var36) {
                                                                    Client.mouseCrossX = MouseHandler.MouseHandler_lastPressedX;
                                                                    Client.mouseCrossY = MouseHandler.MouseHandler_lastPressedY;
                                                                    Client.mouseCrossColor = 1;
                                                                    Client.mouseCrossState = 0;
                                                                }
                                                            }

                                                            if (AnimationDefinition.field887 == null && Client.clickedWidget == null) {
                                                                var2 = MouseHandler.PacketBufferNode_packetBufferNodeCount;
                                                                if (Client.isMenuOpen) {
                                                                    if (var2 != 1) {
                                                                        var3 = MouseHandler.MouseHandler_x;
                                                                        var4 = MouseHandler.MouseHandler_y;
                                                                        if (var3 < ItemContainer.menuX - 10 || var3 > ItemContainer.menuX + IterableNodeHashTableIterator.menuWidth + 10 || var4 < BufferedFile.menuY - 10 || var4 > BufferedFile.menuY + Decimator.menuHeight + 10) {
                                                                            Client.isMenuOpen = false;
                                                                            NPC.method266(ItemContainer.menuX, BufferedFile.menuY, IterableNodeHashTableIterator.menuWidth, Decimator.menuHeight);
                                                                        }
                                                                    }

                                                                    if (var2 == 1) {
                                                                        var3 = ItemContainer.menuX;
                                                                        var4 = BufferedFile.menuY;
                                                                        var5 = IterableNodeHashTableIterator.menuWidth;
                                                                        var6 = MouseHandler.MouseHandler_lastPressedX;
                                                                        var7 = MouseHandler.MouseHandler_lastPressedY;
                                                                        var8 = -1;

                                                                        for (var24 = 0; var24 < Client.menuOptionsCount; ++var24) {
                                                                            var10 = (Client.menuOptionsCount - 1 - var24) * 15 + var4 + 31;
                                                                            if (var6 > var3 && var6 < var3 + var5 && var7 > var10 - 13 && var7 < var10 + 3) {
                                                                                var8 = var24;
                                                                            }
                                                                        }

                                                                        if (var8 != -1) {
                                                                            Frames.method2392(var8);
                                                                        }

                                                                        Client.isMenuOpen = false;
                                                                        NPC.method266(ItemContainer.menuX, BufferedFile.menuY, IterableNodeHashTableIterator.menuWidth, Decimator.menuHeight);
                                                                    }
                                                                } else {
                                                                    label1220:
                                                                    {
                                                                        label1258:
                                                                        {
                                                                            if (var2 == 1 && Client.menuOptionsCount > 0) {
                                                                                var3 = Client.menuOpcodes[Client.menuOptionsCount - 1];
                                                                                if (var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                                                                                    var4 = Client.menuArguments1[Client.menuOptionsCount - 1];
                                                                                    var5 = Client.menuArguments2[Client.menuOptionsCount - 1];
                                                                                    Widget var28 = class130.getWidget(var5);
                                                                                    if (Buffer.method2811(SoundSystem.method1326(var28))) {
                                                                                        break label1258;
                                                                                    }

                                                                                    var8 = SoundSystem.method1326(var28);
                                                                                    boolean var37 = (var8 >> 29 & 1) != 0;
                                                                                    if (var37) {
                                                                                        break label1258;
                                                                                    }
                                                                                }
                                                                            }

                                                                            if (var2 == 1 && (Client.leftClickOpensMenu == 1 && Client.menuOptionsCount > 2 || PlatformInfo.method3190(Client.menuOptionsCount - 1))) {
                                                                                var2 = 2;
                                                                            }

                                                                            if (var2 == 1 && Client.menuOptionsCount > 0) {
                                                                                Frames.method2392(Client.menuOptionsCount - 1);
                                                                            }

                                                                            if (var2 == 2 && Client.menuOptionsCount > 0) {
                                                                                class1.method9();
                                                                            }
                                                                            break label1220;
                                                                        }

                                                                        Client.field600 = false;
                                                                        Client.field639 = 0;
                                                                        if (AnimationDefinition.field887 != null) {
                                                                            class82.invalidateWidget(AnimationDefinition.field887);
                                                                        }

                                                                        AnimationDefinition.field887 = class130.getWidget(var5);
                                                                        Client.field596 = var4;
                                                                        Client.field597 = MouseHandler.MouseHandler_lastPressedX;
                                                                        Client.field598 = MouseHandler.MouseHandler_lastPressedY;
                                                                        class82.invalidateWidget(AnimationDefinition.field887);
                                                                    }
                                                                }
                                                            }

                                                            if (var38 != Tiles.mousedOverWidgetIf1) {
                                                                if (var38 != null) {
                                                                    class82.invalidateWidget(var38);
                                                                }

                                                                if (Tiles.mousedOverWidgetIf1 != null) {
                                                                    class82.invalidateWidget(Tiles.mousedOverWidgetIf1);
                                                                }
                                                            }

                                                            if (var40 != NPC.field398 && Client.field635 == Client.field636) {
                                                                if (var40 != null) {
                                                                    class82.invalidateWidget(var40);
                                                                }

                                                                if (NPC.field398 != null) {
                                                                    class82.invalidateWidget(NPC.field398);
                                                                }
                                                            }

                                                            if (NPC.field398 != null) {
                                                                if (Client.field635 < Client.field636) {
                                                                    ++Client.field635;
                                                                    if (Client.field636 == Client.field635) {
                                                                        class82.invalidateWidget(NPC.field398);
                                                                    }
                                                                }
                                                            } else if (Client.field635 > 0) {
                                                                --Client.field635;
                                                            }

                                                            Skeleton.method2366();
                                                            if (Client.isCameraLocked) {
                                                                KeyHandler.method1649();
                                                            }

                                                            for (var2 = 0; var2 < 5; ++var2) {
                                                                ++Client.field735[var2];
                                                            }

                                                            var2 = InterfaceParent.method28();
                                                            var3 = KeyHandler.KeyHandler_idleCycles;
                                                            if (var2 > 15000 && var3 > 15000) {
                                                                Client.logoutTimer = 250;
                                                                MouseHandler.MouseHandler_idleCycles = 14500;
                                                                Client.rsaBuf.writeByteOpcode(224);
                                                            }

                                                            ++Client.field553;
                                                            if (Client.field553 > 500) {
                                                                Client.field553 = 0;
                                                                var5 = (int) (Math.random() * 8.0D);
                                                                if ((var5 & 1) == 1) {
                                                                    Client.field734 += Client.field548;
                                                                }

                                                                if ((var5 & 2) == 2) {
                                                                    Client.field549 += Client.field550;
                                                                }

                                                                if ((var5 & 4) == 4) {
                                                                    Client.field551 += Client.field552;
                                                                }
                                                            }

                                                            if (Client.field734 < -50) {
                                                                Client.field548 = 2;
                                                            }

                                                            if (Client.field734 > 50) {
                                                                Client.field548 = -2;
                                                            }

                                                            if (Client.field549 < -55) {
                                                                Client.field550 = 2;
                                                            }

                                                            if (Client.field549 > 55) {
                                                                Client.field550 = -2;
                                                            }

                                                            if (Client.field551 < -40) {
                                                                Client.field552 = 1;
                                                            }

                                                            if (Client.field551 > 40) {
                                                                Client.field552 = -1;
                                                            }

                                                            ++Client.field542;
                                                            if (Client.field542 > 500) {
                                                                Client.field542 = 0;
                                                                var5 = (int) (Math.random() * 8.0D);
                                                                if ((var5 & 1) == 1) {
                                                                    Client.field554 += Client.field673;
                                                                }

                                                                if ((var5 & 2) == 2) {
                                                                    Client.field556 += Client.field557;
                                                                }
                                                            }

                                                            if (Client.field554 < -60) {
                                                                Client.field673 = 2;
                                                            }

                                                            if (Client.field554 > 60) {
                                                                Client.field673 = -2;
                                                            }

                                                            if (Client.field556 < -20) {
                                                                Client.field557 = 1;
                                                            }

                                                            if (Client.field556 > 10) {
                                                                Client.field557 = -1;
                                                            }

                                                            for (class27 var29 = (class27) Client.field680.method3506(); var29 != null; var29 = (class27) Client.field680.method3501()) {
                                                                if ((long) var29.field756 < ClientPreferences.method148() / 1000L - 5L) {
                                                                    if (var29.field751 > 0) {
                                                                        Login.setOverheadText(5, "", var29.field749 + " has logged in.");
                                                                    }

                                                                    if (var29.field751 == 0) {
                                                                        Login.setOverheadText(5, "", var29.field749 + " has logged out.");
                                                                    }

                                                                    var29.method3563();
                                                                }
                                                            }

                                                            ++Client.field669;
                                                            if (Client.field669 > 50) {
                                                                Client.rsaBuf.writeByteOpcode(217);
                                                            }

                                                            try {
                                                                if (GraphicsObject.gameSocket != null && Client.rsaBuf.offset > 0) {
                                                                    GraphicsObject.gameSocket.flush(Client.rsaBuf.array, 0, Client.rsaBuf.offset);
                                                                    Client.rsaBuf.offset = 0;
                                                                    Client.field669 = 0;
                                                                }
                                                            } catch (IOException var30) {
                                                                Clock.method1461();
                                                            }

                                                            return;
                                                        }

                                                        var41 = var44.widget;
                                                        if (var41.childIndex < 0) {
                                                            break;
                                                        }

                                                        var42 = class130.getWidget(var41.parentId);
                                                    } while (var42 == null || var42.children == null || var41.childIndex >= var42.children.length || var41 != var42.children[var41.childIndex]);

                                                    Renderable.method2040(var44);
                                                }
                                            }

                                            var41 = var44.widget;
                                            if (var41.childIndex < 0) {
                                                break;
                                            }

                                            var42 = class130.getWidget(var41.parentId);
                                        } while (var42 == null || var42.children == null || var41.childIndex >= var42.children.length || var41 != var42.children[var41.childIndex]);

                                        Renderable.method2040(var44);
                                    }
                                }

                                var41 = var44.widget;
                                if (var41.childIndex < 0) {
                                    break;
                                }

                                var42 = class130.getWidget(var41.parentId);
                            } while (var42 == null || var42.children == null || var41.childIndex >= var42.children.length || var41 != var42.children[var41.childIndex]);

                            Renderable.method2040(var44);
                        }
                    }
                }
            }
        }
    }
}
