package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
@Implements("Skeleton")
public class Skeleton extends Node {
    @ObfuscatedName("k")
    public static short[][] field1792;
    @ObfuscatedName("i")
    @Export("id")
    int id;
    @ObfuscatedName("w")
    @Export("count")
    int count;
    @ObfuscatedName("f")
    @Export("transformTypes")
    int[] transformTypes;
    @ObfuscatedName("e")
    @Export("labels")
    int[][] labels;

    Skeleton(int var1, byte[] var2) {
        this.id = var1;
        Buffer var3 = new Buffer(var2);
        this.count = var3.readUnsignedByte();
        this.transformTypes = new int[this.count];
        this.labels = new int[this.count][];

        int var4;
        for (var4 = 0; var4 < this.count; ++var4) {
            this.transformTypes[var4] = var3.readUnsignedByte();
        }

        for (var4 = 0; var4 < this.count; ++var4) {
            this.labels[var4] = new int[var3.readUnsignedByte()];
        }

        for (var4 = 0; var4 < this.count; ++var4) {
            for (int var5 = 0; var5 < this.labels[var4].length; ++var5) {
                this.labels[var4][var5] = var3.readUnsignedByte();
            }
        }

    }

    @ObfuscatedName("u")
    @Export("method2367")
    static void method2367() {
        int var8;
        if (Client.titleLoadingStage == 0) {
            Interpreter.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

            for (var8 = 0; var8 < 4; ++var8) {
                Client.collisionMaps[var8] = new CollisionMap(104, 104);
            }

            MouseRecorder.sceneMinimapSprite = new SpritePixels(512, 512);
            Login.Login_loadingText = "Starting game engine...";
            Login.Login_loadingPercent = 5;
            Client.titleLoadingStage = 20;
        } else {
            int var1;
            int var2;
            int var3;
            int var4;
            if (Client.titleLoadingStage == 20) {
                int[] var16 = new int[9];

                for (var1 = 0; var1 < 9; ++var1) {
                    var2 = var1 * 32 + 15 + 128;
                    var3 = var2 * 3 + 600;
                    var4 = Rasterizer3D.Rasterizer3D_sine[var2];
                    var16[var1] = var3 * var4 >> 16;
                }

                Scene.method2076(var16, 500, 800, 512, 334);
                Login.Login_loadingText = "Prepared visibility map";
                Login.Login_loadingPercent = 10;
                Client.titleLoadingStage = 30;
            } else if (Client.titleLoadingStage == 30) {
                MusicPatchNode.archive1 = SoundCache.method1366(0, false, true, true);
                class7.archive3 = SoundCache.method1366(1, false, true, true);
                ClientPreferences.archive2 = SoundCache.method1366(2, true, false, true);
                class83.archive4 = SoundCache.method1366(3, false, true, true);
                class7.field102 = SoundCache.method1366(4, false, true, true);
                class146.archive5 = SoundCache.method1366(5, true, true, true);
                class40.archive6 = SoundCache.method1366(6, true, true, false);
                InterfaceParent.archive7 = SoundCache.method1366(7, false, true, true);
                MouseRecorder.archive8 = SoundCache.method1366(8, false, true, true);
                class10.archive9 = SoundCache.method1366(9, false, true, true);
                DynamicObject.archive10 = SoundCache.method1366(10, false, true, true);
                World.archive11 = SoundCache.method1366(11, false, true, true);
                AbstractByteArrayCopier.archive12 = SoundCache.method1366(12, false, true, true);
                class17.archive13 = SoundCache.method1366(13, true, false, true);
                KeyHandler.archive14 = SoundCache.method1366(14, false, true, false);
                Tiles.archive15 = SoundCache.method1366(15, false, true, true);
                Login.Login_loadingText = "Connecting to update server";
                Login.Login_loadingPercent = 20;
                Client.titleLoadingStage = 40;
            } else if (Client.titleLoadingStage == 40) {
                byte var22 = 0;
                var8 = var22 + MusicPatchNode.archive1.method3296() * 4 / 100;
                var8 += class7.archive3.method3296() * 4 / 100;
                var8 += ClientPreferences.archive2.method3296() * 2 / 100;
                var8 += class83.archive4.method3296() * 2 / 100;
                var8 += class7.field102.method3296() * 6 / 100;
                var8 += class146.archive5.method3296() * 4 / 100;
                var8 += class40.archive6.method3296() * 2 / 100;
                var8 += InterfaceParent.archive7.method3296() * 60 / 100;
                var8 += MouseRecorder.archive8.method3296() * 2 / 100;
                var8 += class10.archive9.method3296() * 2 / 100;
                var8 += DynamicObject.archive10.method3296() * 2 / 100;
                var8 += World.archive11.method3296() * 2 / 100;
                var8 += AbstractByteArrayCopier.archive12.method3296() * 2 / 100;
                var8 += class17.archive13.method3296() * 2 / 100;
                var8 += KeyHandler.archive14.method3296() * 2 / 100;
                var8 += Tiles.archive15.method3296() * 2 / 100;
                if (var8 != 100) {
                    if (var8 != 0) {
                        Login.Login_loadingText = "Checking for updates - " + var8 + "%";
                    }

                    Login.Login_loadingPercent = 30;
                } else {
                    Login.Login_loadingText = "Loaded update list";
                    Login.Login_loadingPercent = 30;
                    Client.titleLoadingStage = 45;
                }
            } else {
                Archive var11;
                Archive var13;
                if (Client.titleLoadingStage == 45) {
                    boolean var21 = !Client.isLowDetail;
                    PcmPlayer.field1099 = 22050;
                    PcmPlayer.PcmPlayer_stereo = var21;
                    Frames.field1825 = 2;
                    MidiPcmStream var19 = new MidiPcmStream();
                    var19.method2940(9, 128);
                    Client.pcmPlayer0 = AccessFile.method577(ItemContainer.taskHandler, Tiles.field131, 0, 22050);
                    Client.pcmPlayer0.method1226(var19);
                    var13 = Tiles.archive15;
                    Archive var20 = KeyHandler.archive14;
                    var11 = class7.field102;
                    class137.musicPatchesArchive = var13;
                    class137.musicSamplesArchive = var20;
                    class137.soundEffectsArchive = var11;
                    class137.midiPcmStream = var19;
                    class27.pcmPlayer1 = AccessFile.method577(ItemContainer.taskHandler, Tiles.field131, 1, 2048);
                    ItemContainer.pcmStreamMixer = new PcmStreamMixer();
                    class27.pcmPlayer1.method1226(ItemContainer.pcmStreamMixer);
                    MouseHandler.field1392 = new Decimator(22050, PcmPlayer.field1099);
                    Login.Login_loadingText = "Prepared sound engine";
                    Login.Login_loadingPercent = 35;
                    Client.titleLoadingStage = 50;
                } else if (Client.titleLoadingStage == 50) {
                    var8 = 0;
                    if (AccessFile.field762 == null) {
                        AccessFile.field762 = Projectile.method127(MouseRecorder.archive8, class17.archive13, "p11_full", "");
                    } else {
                        ++var8;
                    }

                    if (VertexNormal.field1511 == null) {
                        VertexNormal.field1511 = Projectile.method127(MouseRecorder.archive8, class17.archive13, "p12_full", "");
                    } else {
                        ++var8;
                    }

                    if (class40.fontBold12 == null) {
                        class40.fontBold12 = Projectile.method127(MouseRecorder.archive8, class17.archive13, "b12_full", "");
                    } else {
                        ++var8;
                    }

                    if (var8 < 3) {
                        Login.Login_loadingText = "Loading fonts - " + var8 * 100 / 3 + "%";
                        Login.Login_loadingPercent = 40;
                    } else {
                        class68.field1274 = new PlatformInfo(true);
                        Login.Login_loadingText = "Loaded fonts";
                        Login.Login_loadingPercent = 40;
                        Client.titleLoadingStage = 60;
                    }
                } else {
                    Archive var9;
                    if (Client.titleLoadingStage == 60) {
                        var9 = DynamicObject.archive10;
                        var13 = MouseRecorder.archive8;
                        var3 = 0;
                        if (var9.method3222("title.jpg", "")) {
                            ++var3;
                        }

                        if (var13.method3222("logo", "")) {
                            ++var3;
                        }

                        if (var13.method3222("titlebox", "")) {
                            ++var3;
                        }

                        if (var13.method3222("titlebutton", "")) {
                            ++var3;
                        }

                        if (var13.method3222("runes", "")) {
                            ++var3;
                        }

                        if (var13.method3222("title_mute", "")) {
                            ++var3;
                        }

                        var13.method3222("sl_back", "");
                        var13.method3222("sl_flags", "");
                        var13.method3222("sl_arrows", "");
                        var13.method3222("sl_stars", "");
                        var13.method3222("sl_button", "");
                        byte var18 = 6;
                        if (var3 < var18) {
                            Login.Login_loadingText = "Loading title screen - " + var3 * 100 / var18 + "%";
                            Login.Login_loadingPercent = 50;
                        } else {
                            Login.Login_loadingText = "Loaded title screen";
                            Login.Login_loadingPercent = 50;
                            NPC.updateGameState(5);
                            Client.titleLoadingStage = 70;
                        }
                    } else if (Client.titleLoadingStage == 70) {
                        if (!ClientPreferences.archive2.method3208()) {
                            Login.Login_loadingText = "Loading config - " + ClientPreferences.archive2.method3301() + "%";
                            Login.Login_loadingPercent = 60;
                        } else {
                            class5.method41(ClientPreferences.archive2);
                            ItemComposition.method901(ClientPreferences.archive2);
                            class22.method246(ClientPreferences.archive2, InterfaceParent.archive7);
                            WallDecoration.method2383(ClientPreferences.archive2, InterfaceParent.archive7, Client.isLowDetail);
                            AbstractRasterProvider.method1799(ClientPreferences.archive2, InterfaceParent.archive7);
                            Archive var15 = ClientPreferences.archive2;
                            var9 = InterfaceParent.archive7;
                            boolean var17 = Client.isMembersWorld;
                            Font var10 = AccessFile.field762;
                            ItemComposition.ItemDefinition_archive = var15;
                            ItemComposition.ItemDefinition_modelArchive = var9;
                            ItemComposition.ItemDefinition_inMembersWorld = var17;
                            ItemComposition.ItemDefinition_archive.method3214(10);
                            ClientPreferences.field188 = var10;
                            Tiles.method106(ClientPreferences.archive2, MusicPatchNode.archive1, class7.archive3);
                            AccessFile.method576(ClientPreferences.archive2, InterfaceParent.archive7);
                            VertexNormal.method2026(ClientPreferences.archive2);
                            Login.method240(ClientPreferences.archive2);
                            var11 = class83.archive4;
                            Archive var12 = InterfaceParent.archive7;
                            Archive var6 = MouseRecorder.archive8;
                            Archive var7 = class17.archive13;
                            Widget.Widget_archive = var11;
                            class179.Widget_modelsArchive = var12;
                            Widget.Widget_spritesArchive = var6;
                            JagexCache.Widget_fontsArchive = var7;
                            Widget.Widget_interfaceComponents = new Widget[Widget.Widget_archive.method3264()][];
                            Widget.Widget_loadedInterfaces = new boolean[Widget.Widget_archive.method3264()];
                            TileItem.method180(ClientPreferences.archive2);
                            class133.method2862(ClientPreferences.archive2);
                            Login.Login_loadingText = "Loaded config";
                            Login.Login_loadingPercent = 60;
                            Client.titleLoadingStage = 80;
                        }
                    } else if (Client.titleLoadingStage != 80) {
                        if (Client.titleLoadingStage == 90) {
                            if (!class10.archive9.method3208()) {
                                Login.Login_loadingText = "Loading textures - " + class10.archive9.method3301() + "%";
                                Login.Login_loadingPercent = 90;
                            } else {
                                TextureProvider var14 = new TextureProvider(class10.archive9, MouseRecorder.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
                                Rasterizer3D.method2331(var14);
                                Rasterizer3D.method2307(0.8D);
                                Login.Login_loadingText = "Loaded textures";
                                Login.Login_loadingPercent = 90;
                                Client.titleLoadingStage = 110;
                            }
                        } else if (Client.titleLoadingStage == 110) {
                            BoundaryObject.field1625 = new MouseRecorder();
                            ItemContainer.taskHandler.method1599(BoundaryObject.field1625, 10);
                            Login.Login_loadingText = "Loaded input handler";
                            Login.Login_loadingPercent = 94;
                            Client.titleLoadingStage = 120;
                        } else if (Client.titleLoadingStage == 120) {
                            if (!DynamicObject.archive10.method3222("huffman", "")) {
                                Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
                                Login.Login_loadingPercent = 96;
                            } else {
                                Huffman var0 = new Huffman(DynamicObject.archive10.method3263("huffman", ""));
                                World.method155(var0);
                                Login.Login_loadingText = "Loaded wordpack";
                                Login.Login_loadingPercent = 96;
                                Client.titleLoadingStage = 130;
                            }
                        } else if (Client.titleLoadingStage == 130) {
                            if (!class83.archive4.method3208()) {
                                Login.Login_loadingText = "Loading interfaces - " + class83.archive4.method3301() * 4 / 5 + "%";
                                Login.Login_loadingPercent = 100;
                            } else if (!AbstractByteArrayCopier.archive12.method3208()) {
                                Login.Login_loadingText = "Loading interfaces - " + (80 + AbstractByteArrayCopier.archive12.method3301() / 6) + "%";
                                Login.Login_loadingPercent = 100;
                            } else if (!class17.archive13.method3208()) {
                                Login.Login_loadingText = "Loading interfaces - " + (96 + class17.archive13.method3301() / 20) + "%";
                                Login.Login_loadingPercent = 100;
                            } else {
                                Login.Login_loadingText = "Loaded interfaces";
                                Login.Login_loadingPercent = 100;
                                Client.titleLoadingStage = 140;
                            }
                        } else if (Client.titleLoadingStage == 140) {
                            NPC.updateGameState(10);
                        }
                    } else {
                        var8 = 0;
                        if (TaskHandler.compass == null) {
                            TaskHandler.compass = class1.method13(MouseRecorder.archive8, "compass", "");
                        } else {
                            ++var8;
                        }

                        if (class22.redHintArrowSprite == null) {
                            class22.redHintArrowSprite = class1.method13(MouseRecorder.archive8, "mapedge", "");
                        } else {
                            ++var8;
                        }

                        if (Decimator.mapSceneSprites == null) {
                            Decimator.mapSceneSprites = ObjectSound.method52(MouseRecorder.archive8, "mapscene", "");
                        } else {
                            ++var8;
                        }

                        if (class134.headIconPkSprites == null) {
                            class134.headIconPkSprites = Clock.method1467(MouseRecorder.archive8, "mapfunction", "");
                        } else {
                            ++var8;
                        }

                        if (MouseRecorder.headIconPrayerSprites == null) {
                            MouseRecorder.headIconPrayerSprites = Clock.method1467(MouseRecorder.archive8, "hitmarks", "");
                        } else {
                            ++var8;
                        }

                        if (class161.field2711 == null) {
                            class161.field2711 = Clock.method1467(MouseRecorder.archive8, "headicons_pk", "");
                        } else {
                            ++var8;
                        }

                        if (class14.mapMarkerSprites == null) {
                            class14.mapMarkerSprites = Clock.method1467(MouseRecorder.archive8, "headicons_prayer", "");
                        } else {
                            ++var8;
                        }

                        if (ObjectSound.headIconHintSprites == null) {
                            ObjectSound.headIconHintSprites = Clock.method1467(MouseRecorder.archive8, "headicons_hint", "");
                        } else {
                            ++var8;
                        }

                        if (ItemLayer.mapDotSprites == null) {
                            ItemLayer.mapDotSprites = Clock.method1467(MouseRecorder.archive8, "mapmarker", "");
                        } else {
                            ++var8;
                        }

                        if (Client.scrollBarSprites == null) {
                            Client.scrollBarSprites = Clock.method1467(MouseRecorder.archive8, "cross", "");
                        } else {
                            ++var8;
                        }

                        if (NPC.modIconSprites == null) {
                            NPC.modIconSprites = Clock.method1467(MouseRecorder.archive8, "mapdots", "");
                        } else {
                            ++var8;
                        }

                        if (class14.field246 == null) {
                            class14.field246 = ObjectSound.method52(MouseRecorder.archive8, "scrollbar", "");
                        } else {
                            ++var8;
                        }

                        if (TaskHandler.field1338 == null) {
                            TaskHandler.field1338 = ObjectSound.method52(MouseRecorder.archive8, "mod_icons", "");
                        } else {
                            ++var8;
                        }

                        if (TextureProvider.field1834 == null) {
                            TextureProvider.field1834 = TaskHandler.method1598(MouseRecorder.archive8, "mapback", "");
                        } else {
                            ++var8;
                        }

                        if (var8 < 14) {
                            Login.Login_loadingText = "Loading sprites - " + var8 * 100 / 14 + "%";
                            Login.Login_loadingPercent = 70;
                        } else {
                            AbstractFont.AbstractFont_modIconSprites = TaskHandler.field1338;
                            class22.redHintArrowSprite.method1829();
                            var1 = (int) (Math.random() * 21.0D) - 10;
                            var2 = (int) (Math.random() * 21.0D) - 10;
                            var3 = (int) (Math.random() * 21.0D) - 10;
                            var4 = (int) (Math.random() * 41.0D) - 20;

                            for (int var5 = 0; var5 < class134.headIconPkSprites.length; ++var5) {
                                class134.headIconPkSprites[var5].method1828(var4 + var1, var2 + var4, var4 + var3);
                            }

                            Decimator.mapSceneSprites[0].method1926(var4 + var1, var2 + var4, var3 + var4);
                            Projectile.method128();
                            Login.Login_loadingText = "Loaded sprites";
                            Login.Login_loadingPercent = 70;
                            Client.titleLoadingStage = 90;
                        }
                    }
                }
            }
        }
    }

    @ObfuscatedName("aw")
    static final void method2366() {
        int var0 = Client.field734 + Tiles.localPlayer.x;
        int var1 = Client.field549 + Tiles.localPlayer.y;
        if (Client.field572 - var0 < -500 || Client.field572 - var0 > 500 || MouseHandler.field1402 - var1 < -500 || MouseHandler.field1402 - var1 > 500) {
            Client.field572 = var0;
            MouseHandler.field1402 = var1;
        }

        if (var0 != Client.field572) {
            Client.field572 += (var0 - Client.field572) / 16;
        }

        if (var1 != MouseHandler.field1402) {
            MouseHandler.field1402 += (var1 - MouseHandler.field1402) / 16;
        }

        if (KeyHandler.KeyHandler_pressedKeys[96]) {
            Client.field570 += (-24 - Client.field570) / 2;
        } else if (KeyHandler.KeyHandler_pressedKeys[97]) {
            Client.field570 += (24 - Client.field570) / 2;
        } else {
            Client.field570 /= 2;
        }

        if (KeyHandler.KeyHandler_pressedKeys[98]) {
            Client.field651 += (12 - Client.field651) / 2;
        } else if (KeyHandler.KeyHandler_pressedKeys[99]) {
            Client.field651 += (-12 - Client.field651) / 2;
        } else {
            Client.field651 /= 2;
        }

        Client.field569 = Client.field570 / 2 + Client.field569 & 2047;
        Client.field516 += Client.field651 / 2;
        if (Client.field516 < 128) {
            Client.field516 = 128;
        }

        if (Client.field516 > 383) {
            Client.field516 = 383;
        }

        int var2 = Client.field572 >> 7;
        int var3 = MouseHandler.field1402 >> 7;
        int var4 = BufferedFile.getTileHeight(Client.field572, MouseHandler.field1402, class22.scenePlane);
        int var5 = 0;
        int var6;
        if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for (var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
                for (int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                    int var8 = class22.scenePlane;
                    if (var8 < 3 && (Tiles.Tiles_renderFlags[1][var6][var7] & 2) == 2) {
                        ++var8;
                    }

                    int var9 = var4 - Tiles.Tiles_heights[var8][var6][var7];
                    if (var9 > var5) {
                        var5 = var9;
                    }
                }
            }
        }

        var6 = var5 * 192;
        if (var6 > 98048) {
            var6 = 98048;
        }

        if (var6 < 32768) {
            var6 = 32768;
        }

        if (var6 > Client.field568) {
            Client.field568 += (var6 - Client.field568) / 24;
        } else if (var6 < Client.field568) {
            Client.field568 += (var6 - Client.field568) / 80;
        }

    }
}
