package osrs;

import osrs.classic.Applet;
import osrs.classic.server.util.logger.Logger;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;

public final class Client extends GameEngine {
    static boolean field562;
    static PcmPlayer pcmPlayer0;
    static boolean isMenuOpen;
    static int rootInterface;
    static String[] menuActions;
    static String[] menuTargets;
    static int[] menuOpcodes;
    static int menuOptionsCount;
    static int rootWidgetCount;
    static boolean[] field686;
    static int field685;
    static int field633;
    static boolean[] field687;
    static boolean[] field688;
    static int field634;
    static int field654;
    static boolean field652;
    static int[] rootWidgetXs;
    static int field693;
    static int[] rootWidgetWidths;
    static NodeHashTable interfaceParents;
    static int isItemSelected;
    static boolean isSpellSelected;
    static int[] field621;
    static int[] levels;
    static int[] rootWidgetHeights;
    static String field641;
    static String selectedItemName;
    static int[] rootWidgetYs;
    static int[] field529;
    static String field594;
    static Widget clickedWidget;
    static int field538;
    static int[] menuArguments1;
    static int field648;
    static int field558;
    static int[] menuArguments2;
    static int field743;
    static int[] menuIdentifiers;
    static PlayerComposition playerAppearance;
    static int field744;
    static int field717;
    static boolean isDraggingWidget;
    static int privilegeLevel;
    static int currentTrackGroupId;
    static int field715;
    static boolean field659;
    static Player[] players;
    static int widgetClickX;
    static boolean isModerator;
    static int widgetClickY;
    static int field624;
    static int localPlayerIndex;
    static int field623;
    static Widget field740;
    static int playersCount;
    static int field661;
    static boolean isCameraLocked;
    static int field681;
    static int field676;
    static int isMember;
    static int[] field485;
    static int field737;
    static long field707;
    static Widget meslayerContinueWidget;
    static int field674;
    static int field636;
    static int field635;
    static int field736;
    static NodeHashTable widgetFlags;
    static class22[] field532;
    static int[] playersIndex;
    static int field604;
    static int field716;
    static NodeDeque field619;
    static NodeDeque[][][] groundItems;
    static int field711;
    static int[] field712;
    static int[] field578;
    static int field596;
    static int field670;
    static int[] field524;
    static NodeDeque field620;
    static NodeDeque pendingSpawns;
    static int[] field713;
    static int field655;
    static boolean[] field731;
    static SpritePixels[] field714;
    static int field595;
    static int field597;
    static int[] field733;
    static int field675;
    static int field598;
    static int field710;
    static int field534;
    static class10[] field741;
    static int[] field642;
    static class172 field680;
    static int field639;
    static int[] field575;
    static boolean field511;
    static String[] playerMenuActions;
    static int[] field735;
    static int[] field667;
    static long[] field702;
    static int field668;
    static int[] field587;
    static boolean[] playerOptionsPriorities;
    static int xPadding;
    static int field718;
    static int field684;
    static int soundEffectCount;
    static int[] field727;
    static int viewportTempY;
    static int mouseCrossX;
    static SoundEffect[] field729;
    static int mouseCrossY;
    static int leftClickOpensMenu;
    static int field721;
    static int mouseCrossState;
    static int[] field742;
    static int chatEffects;
    static int mouseCrossColor;
    static int[] field589;
    static int field533;
    static int[] field694;
    static String[] field695;
    static int[] field726;
    static int field580;
    static String[] field697;
    static boolean field600;
    static String[] field696;
    static int field646;
    static int field482;
    static int[] field671;
    static int[] field677;
    static int field672;
    static Widget field658;
    static Buffer[] appearanceCache;
    static String[] field678;
    static int[] field699;
    static boolean field703;
    static int field704;
    static int field700;
    static String field660;
    static int[] field612;
    static final int[] playerMenuOpcodes;
    static int[] field705;
    static int field748;
    static NodeDeque field745;
    static NodeDeque field682;
    static String field720;
    static NodeDeque field536;
    static int field708;
    static int field664;
    static int selectedSpellChildIndex;
    static CollisionMap[] collisionMaps = new CollisionMap[4];
    static Client instance;
    static boolean ViewportMouse_isInViewport = true;
    static int ViewportMouse_x = 1;
    static int ViewportMouse_y = 0;
    static StudioGame field484;
    static boolean isMembersWorld = false;
    static boolean isLowDetail = false;
    static int field487 = 0;
    static int gameState = 0;
    static boolean field489 = true;
    static int cycle = 0;
    static long field545 = -1L;
    static int field492 = -1;
    static int field493 = -1;
    static int field494 = -1;
    static boolean field613 = true;
    static boolean field496 = false;
    static int field585 = 0;
    static int hintArrowType = 0;
    static int field499 = 0;
    static int field500 = 0;
    static int hintArrowX = 0;
    static int hintArrowY = 0;
    static int field479 = 0;
    static int field504 = 0;
    static int field505 = 0;
    static Buffer field535 = new Buffer(new byte[5000]);
    static int titleLoadingStage = 0;
    static int js5ConnectState = 0;
    static int field544 = 0;
    static int js5Errors = 0;
    static int loginStep = 0;
    static int socketIdleCycles = 0;
    static int connectedState = 0;
    static int field514 = 0;
    static int somePortIncrement;
    static NPC[] npcs = new NPC['耀'];
    static int npcCount = 0;
    static int[] npcIndices = new int['耀'];
    static PacketBuffer rsaBuf = new PacketBuffer(5000);
    static PacketBuffer loginBuf = new PacketBuffer(5000);
    static PacketBuffer serverPacketBuf = new PacketBuffer(5000);
    static int serverPacketLength = 0;
    static int serverPacketOpcode = 0;
    static int field565 = 0;
    static int field669 = 0;
    static int logoutTimer = 0;
    static int field527 = 0;
    static int field728 = 0;
    static int field488 = 0;
    static boolean field530 = false;
    static int renderPlane = 0;
    static int chunkX;
    static int chunkY;
    static int field509 = 0;
    static int field560 = 1;
    static int field510 = 0;
    static int field491 = 1;
    static int field537 = 0;
    static boolean isInInstance = false;
    static int[][][] instanceChunkTemplates = new int[4][13][13];
    static final int[] field541 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    static int field738 = 0;
    static int[][] field543 = new int[104][104];
    static int[][] field501 = new int[104][104];
    static int[] field666 = new int[4000];
    static int[] field546 = new int[4000];
    static int field734 = 0;
    static int field548 = 2;
    static int field549 = 0;
    static int field550 = 2;
    static int field551 = 0;
    static int field552 = 1;
    static int field553 = 0;
    static int field554 = 0;
    static int field673 = 2;
    static int field556 = 0;
    static int field557 = 1;
    static int field542 = 0;
    static int field525 = 0;
    static SpritePixels[] scrollBarSprites;
    static int[] field561;
    static int field662 = 2301979;
    static int field698 = 5063219;
    static int field564 = 3353893;
    static int field605 = 7759444;
    static boolean field691 = false;
    static int alternativeScrollbarWidth = 0;
    static int field516 = 128;
    static int field569 = 0;
    static int field570 = 0;
    static int field651 = 0;
    static int field572;
    static int field573 = 0;
    static boolean field599 = false;
    static int field568 = 0;
    static int field576 = 0;
    static int field577 = 50;
    static int[] field625;
    static int[] field722;
    static int[] field528;
    static int[] field581;
    static int[] field582;
    static int[] field583;
    static int[] field584;
    static String[] field522;
    static int[][] field586;
    static int field724;
    static int viewportTempX;

    static {
        field625 = new int[field577];
        field722 = new int[field577];
        field528 = new int[field577];
        field581 = new int[field577];
        field582 = new int[field577];
        field583 = new int[field577];
        field584 = new int[field577];
        field522 = new String[field577];
        field586 = new int[104][104];
        field724 = 0;
        viewportTempX = -1;
        viewportTempY = -1;
        mouseCrossX = 0;
        mouseCrossY = 0;
        mouseCrossState = 0;
        mouseCrossColor = 0;
        field533 = 0;
        field595 = 0;
        field596 = 0;
        field597 = 0;
        field598 = 0;
        field655 = 0;
        field600 = false;
        field639 = 0;
        xPadding = 0;
        players = new Player[2048];
        field604 = 0;
        field524 = new int[2048];
        playersCount = 0;
        playersIndex = new int[2048];
        appearanceCache = new Buffer[2048];
        localPlayerIndex = -1;
        isMember = 0;
        field623 = 0;
        field485 = new int[1000];
        playerMenuOpcodes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
        playerMenuActions = new String[8];
        playerOptionsPriorities = new boolean[8];
        field642 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        groundItems = new NodeDeque[4][104][104];
        pendingSpawns = new NodeDeque();
        field619 = new NodeDeque();
        field620 = new NodeDeque();
        field621 = new int[25];
        levels = new int[25];
        field529 = new int[25];
        leftClickOpensMenu = 0;
        isMenuOpen = false;
        menuOptionsCount = 0;
        menuArguments1 = new int[500];
        menuArguments2 = new int[500];
        menuOpcodes = new int[500];
        menuIdentifiers = new int[500];
        menuActions = new String[500];
        menuTargets = new String[500];
        field633 = -1;
        field634 = -1;
        field635 = 0;
        field636 = 50;
        isItemSelected = 0;
        selectedItemName = null;
        isSpellSelected = false;
        selectedSpellChildIndex = -1;
        field641 = null;
        field594 = null;
        rootInterface = -1;
        interfaceParents = new NodeHashTable(8);
        chatEffects = 0;
        field646 = 0;
        meslayerContinueWidget = null;
        field648 = 0;
        field558 = 0;
        privilegeLevel = 0;
        isModerator = false;
        field652 = false;
        field511 = false;
        clickedWidget = null;
        field740 = null;
        widgetClickX = 0;
        widgetClickY = 0;
        field658 = null;
        field659 = false;
        field624 = -1;
        field661 = -1;
        field703 = false;
        field708 = -1;
        field664 = -1;
        isDraggingWidget = false;
        field681 = 1;
        field667 = new int[32];
        field668 = 0;
        field578 = new int[32];
        field670 = 0;
        field671 = new int[32];
        field672 = 0;
        field482 = 0;
        field674 = 0;
        field675 = 0;
        field676 = 0;
        field677 = new int[2000];
        field678 = new String[1000];
        field654 = 0;
        field536 = new NodeDeque();
        field745 = new NodeDeque();
        field682 = new NodeDeque();
        widgetFlags = new NodeHashTable(512);
        rootWidgetCount = 0;
        field685 = -2;
        field686 = new boolean[100];
        field687 = new boolean[100];
        field688 = new boolean[100];
        rootWidgetXs = new int[100];
        rootWidgetYs = new int[100];
        rootWidgetWidths = new int[100];
        rootWidgetHeights = new int[100];
        field693 = 0;
        field694 = new int[100];
        field695 = new String[100];
        field696 = new String[100];
        field697 = new String[100];
        field580 = 0;
        field699 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
        field700 = 0;
        field748 = 0;
        field702 = new long[100];
        field684 = 0;
        field704 = 0;
        field705 = new int[128];
        field612 = new int[128];
        field707 = -1L;
        field660 = null;
        field720 = null;
        field710 = -1;
        field711 = 0;
        field712 = new int[1000];
        field713 = new int[1000];
        field714 = new SpritePixels[1000];
        field715 = 0;
        field716 = 0;
        field717 = 0;
        field718 = 255;
        currentTrackGroupId = -1;
        field562 = false;
        field721 = 127;
        field538 = 127;
        soundEffectCount = 0;
        field742 = new int[50];
        field726 = new int[50];
        field727 = new int[50];
        field589 = new int[50];
        field729 = new SoundEffect[50];
        isCameraLocked = false;
        field731 = new boolean[5];
        field575 = new int[5];
        field733 = new int[5];
        field587 = new int[5];
        field735 = new int[5];
        field736 = 0;
        field737 = 0;
        field532 = new class22[400];
        field680 = new class172();
        field534 = 0;
        field741 = new class10[400];
        playerAppearance = new PlayerComposition();
        field743 = -1;
        field744 = -1;
    }

    protected final void vmethod1534() {
    }

    protected final void vmethod1529() {
        MouseRecorder.OSRS_PORT = ViewportMouse_y == 0 ? 'ꩊ' : ViewportMouse_x + '鱀';
        somePortIncrement = ViewportMouse_y == 0 ? 443 : ViewportMouse_x + '썐';
        class82.currentPort = MouseRecorder.OSRS_PORT;
        PlayerComposition.field2718 = class160.field2703;
        Skeleton.field1792 = class160.field2704;
        PlayerComposition.field2716 = class160.field2708;
        Script.field60 = class160.field2706;
        if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
            KeyHandler.field1359[186] = 57;
            KeyHandler.field1359[187] = 27;
            KeyHandler.field1359[188] = 71;
            KeyHandler.field1359[189] = 26;
            KeyHandler.field1359[190] = 72;
            KeyHandler.field1359[191] = 73;
            KeyHandler.field1359[192] = 58;
            KeyHandler.field1359[219] = 42;
            KeyHandler.field1359[220] = 74;
            KeyHandler.field1359[221] = 43;
            KeyHandler.field1359[222] = 59;
            KeyHandler.field1359[223] = 28;
        } else {
            KeyHandler.field1359[44] = 71;
            KeyHandler.field1359[45] = 26;
            KeyHandler.field1359[46] = 72;
            KeyHandler.field1359[47] = 73;
            KeyHandler.field1359[59] = 57;
            KeyHandler.field1359[61] = 27;
            KeyHandler.field1359[91] = 42;
            KeyHandler.field1359[92] = 74;
            KeyHandler.field1359[93] = 43;
            KeyHandler.field1359[192] = 28;
            KeyHandler.field1359[222] = 58;
            KeyHandler.field1359[520] = 59;
        }

        method559(Tiles.field131);
        MusicPatch.method2911(Tiles.field131);

        NetSocket var1;
        try {
            var1 = new NetSocket();
        } catch (Throwable var3) {
            var1 = null;
        }

        class17.field284 = var1;
        if (class17.field284 != null) {
            class17.field284.vmethod1690(Tiles.field131);
        }

        ObjectSound.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.fontNameVerdana15, 500000);
        Projectile.clientPreferences = GameBuild.method2852();
        if (ViewportMouse_y != 0) {
            field496 = true;
        }

    }

    protected final void cycle() {
        Logger.INSTANCE.setHeader("Client");
        ++cycle;
        this.method521();

        while (true) {
            NodeDeque var2 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
            ArchiveDiskAction var1;
            synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
                var1 = (ArchiveDiskAction) ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.method3549();
            }

            if (var1 == null) {
                class5.method38();
                AnimationDefinition.method759();
                NetCache.method3288();
                MouseHandler var34 = MouseHandler.MouseHandler_instance;
                synchronized (MouseHandler.MouseHandler_instance) {
                    MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButtonVolatile;
                    MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_xVolatile;
                    MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_yVolatile;
                    MouseHandler.PacketBufferNode_packetBufferNodeCount = MouseHandler.field1398;
                    MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedXVolatile;
                    MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedYVolatile;
                    MouseHandler.field1399 = MouseHandler.MouseHandler_lastPressedTimeMillisVolatile;
                    MouseHandler.field1398 = 0;
                }

                int var24;
                if (class17.field284 != null) {
                    var24 = class17.field284.vmethod1679();
                    field654 = var24;
                }

                if (gameState == 0) {
                    Skeleton.method2367();
                    class22.field376.vmethod1698();

                    for (var24 = 0; var24 < 32; ++var24) {
                        GameEngine.graphicsTickTimes[var24] = 0L;
                    }

                    for (var24 = 0; var24 < 32; ++var24) {
                        GameEngine.clientTickTimes[var24] = 0L;
                    }

                    class135.field2329 = 0;
                } else if (gameState == 5) {
                    ItemContainer.method188(this);
                    Skeleton.method2367();
                    class22.field376.vmethod1698();

                    for (var24 = 0; var24 < 32; ++var24) {
                        GameEngine.graphicsTickTimes[var24] = 0L;
                    }

                    for (var24 = 0; var24 < 32; ++var24) {
                        GameEngine.clientTickTimes[var24] = 0L;
                    }

                    class135.field2329 = 0;
                } else if (gameState == 10) {
                    ItemContainer.method188(this);
                } else if (gameState == 20) {
                    ItemContainer.method188(this);
                    TileItem.loggedOutCycle();
                } else if (gameState == 25) {
                    class65.method1454(false);
                    field509 = 0;
                    boolean var36 = true;

                    int var25;
                    for (var25 = 0; var25 < Buffer.regionLandArchives.length; ++var25) {
                        if (ObjectSound.regionMapArchiveIds[var25] != -1 && Buffer.regionLandArchives[var25] == null) {
                            Buffer.regionLandArchives[var25] = class146.archive5.method3204(ObjectSound.regionMapArchiveIds[var25], 0);
                            if (Buffer.regionLandArchives[var25] == null) {
                                var36 = false;
                                ++field509;
                            }
                        }

                        if (ScriptEvent.regionLandArchiveIds[var25] != -1 && PendingSpawn.regionMapArchives[var25] == null) {
                            PendingSpawn.regionMapArchives[var25] = class146.archive5.method3205(ScriptEvent.regionLandArchiveIds[var25], 0, class161.xteaKeys[var25]);
                            if (PendingSpawn.regionMapArchives[var25] == null) {
                                var36 = false;
                                ++field509;
                            }
                        }
                    }

                    if (!var36) {
                        field537 = 1;
                    } else {
                        field510 = 0;
                        var36 = true;

                        int var5;
                        int var26;
                        for (var25 = 0; var25 < Buffer.regionLandArchives.length; ++var25) {
                            byte[] var3 = PendingSpawn.regionMapArchives[var25];
                            if (var3 != null) {
                                var26 = (class149.regions[var25] >> 8) * 64 - FaceNormal.baseX;
                                var5 = (class149.regions[var25] & 255) * 64 - Frames.baseY;
                                if (isInInstance) {
                                    var26 = 10;
                                    var5 = 10;
                                }

                                var36 &= class14.method164(var3, var26, var5);
                            }
                        }

                        if (!var36) {
                            field537 = 2;
                        } else {
                            if (field537 != 0) {
                                class27.method570("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                            }

                            AnimationDefinition.method759();
                            Interpreter.method274();
                            AnimationDefinition.method759();
                            Interpreter.scene.method2138();
                            AnimationDefinition.method759();
                            System.gc();

                            for (var25 = 0; var25 < 4; ++var25) {
                                collisionMaps[var25].method3435();
                            }

                            int var27;
                            for (var25 = 0; var25 < 4; ++var25) {
                                for (var27 = 0; var27 < 104; ++var27) {
                                    for (var26 = 0; var26 < 104; ++var26) {
                                        Tiles.Tiles_renderFlags[var25][var27][var26] = 0;
                                    }
                                }
                            }

                            AnimationDefinition.method759();
                            VertexNormal.method2024();
                            var25 = Buffer.regionLandArchives.length;

                            for (ObjectSound var35 = (ObjectSound) ObjectSound.objectSounds.method3533(); var35 != null; var35 = (ObjectSound) ObjectSound.objectSounds.method3535()) {
                                if (var35.stream1 != null) {
                                    ItemContainer.pcmStreamMixer.method1127(var35.stream1);
                                    var35.stream1 = null;
                                }

                                if (var35.field91 != null) {
                                    ItemContainer.pcmStreamMixer.method1127(var35.field91);
                                    var35.field91 = null;
                                }
                            }

                            ObjectSound.objectSounds.method3527();
                            class65.method1454(true);
                            int var10;
                            int var11;
                            int var12;
                            int var13;
                            int var28;
                            if (!isInInstance) {
                                byte[] var6;
                                for (var27 = 0; var27 < var25; ++var27) {
                                    var26 = (class149.regions[var27] >> 8) * 64 - FaceNormal.baseX;
                                    var5 = (class149.regions[var27] & 255) * 64 - Frames.baseY;
                                    var6 = Buffer.regionLandArchives[var27];
                                    if (var6 != null) {
                                        AnimationDefinition.method759();
                                        Renderable.method2039(var6, var26, var5, chunkX * 8 - 48, chunkY * 8 - 48, collisionMaps);
                                    }
                                }

                                for (var27 = 0; var27 < var25; ++var27) {
                                    var26 = (class149.regions[var27] >> 8) * 64 - FaceNormal.baseX;
                                    var5 = (class149.regions[var27] & 255) * 64 - Frames.baseY;
                                    var6 = Buffer.regionLandArchives[var27];
                                    if (var6 == null && chunkY < 800) {
                                        AnimationDefinition.method759();
                                        IterableNodeHashTableIterator.method1485(var26, var5, 64, 64);
                                    }
                                }

                                class65.method1454(true);

                                for (var27 = 0; var27 < var25; ++var27) {
                                    byte[] var4 = PendingSpawn.regionMapArchives[var27];
                                    if (var4 != null) {
                                        var5 = (class149.regions[var27] >> 8) * 64 - FaceNormal.baseX;
                                        var28 = (class149.regions[var27] & 255) * 64 - Frames.baseY;
                                        AnimationDefinition.method759();
                                        Scene var7 = Interpreter.scene;
                                        CollisionMap[] var8 = collisionMaps;
                                        Buffer var9 = new Buffer(var4);
                                        var10 = -1;

                                        while (true) {
                                            var11 = var9.method2658();
                                            if (var11 == 0) {
                                                break;
                                            }

                                            var10 += var11;
                                            var12 = 0;

                                            while (true) {
                                                var13 = var9.method2658();
                                                if (var13 == 0) {
                                                    break;
                                                }

                                                var12 += var13 - 1;
                                                int var14 = var12 & 63;
                                                int var15 = var12 >> 6 & 63;
                                                int var16 = var12 >> 12;
                                                int var17 = var9.readUnsignedByte();
                                                int var18 = var17 >> 2;
                                                int var19 = var17 & 3;
                                                int var20 = var15 + var5;
                                                int var21 = var14 + var28;
                                                if (var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                                    int var22 = var16;
                                                    if ((Tiles.Tiles_renderFlags[1][var20][var21] & 2) == 2) {
                                                        var22 = var16 - 1;
                                                    }

                                                    CollisionMap var23 = null;
                                                    if (var22 >= 0) {
                                                        var23 = var8[var22];
                                                    }

                                                    Actor.method295(var16, var20, var21, var10, var19, var18, var7, var23);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            int var29;
                            int var30;
                            int var31;
                            if (isInInstance) {
                                var27 = 0;

                                label435:
                                while (true) {
                                    if (var27 >= 4) {
                                        for (var27 = 0; var27 < 13; ++var27) {
                                            for (var26 = 0; var26 < 13; ++var26) {
                                                var5 = instanceChunkTemplates[0][var27][var26];
                                                if (var5 == -1) {
                                                    IterableNodeHashTableIterator.method1485(var27 * 8, var26 * 8, 8, 8);
                                                }
                                            }
                                        }

                                        class65.method1454(true);
                                        var27 = 0;

                                        while (true) {
                                            if (var27 >= 4) {
                                                break label435;
                                            }

                                            AnimationDefinition.method759();

                                            for (var26 = 0; var26 < 13; ++var26) {
                                                for (var5 = 0; var5 < 13; ++var5) {
                                                    var28 = instanceChunkTemplates[var27][var26][var5];
                                                    if (var28 != -1) {
                                                        var29 = var28 >> 24 & 3;
                                                        var30 = var28 >> 1 & 3;
                                                        var31 = var28 >> 14 & 1023;
                                                        var10 = var28 >> 3 & 2047;
                                                        var11 = (var31 / 8 << 8) + var10 / 8;

                                                        for (var12 = 0; var12 < class149.regions.length; ++var12) {
                                                            if (class149.regions[var12] == var11 && PendingSpawn.regionMapArchives[var12] != null) {
                                                                class10.method131(PendingSpawn.regionMapArchives[var12], var27, var26 * 8, var5 * 8, var29, (var31 & 7) * 8, (var10 & 7) * 8, var30, Interpreter.scene, collisionMaps);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            ++var27;
                                        }
                                    }

                                    AnimationDefinition.method759();

                                    for (var26 = 0; var26 < 13; ++var26) {
                                        for (var5 = 0; var5 < 13; ++var5) {
                                            boolean var37 = false;
                                            var29 = instanceChunkTemplates[var27][var26][var5];
                                            if (var29 != -1) {
                                                var30 = var29 >> 24 & 3;
                                                var31 = var29 >> 1 & 3;
                                                var10 = var29 >> 14 & 1023;
                                                var11 = var29 >> 3 & 2047;
                                                var12 = (var10 / 8 << 8) + var11 / 8;

                                                for (var13 = 0; var13 < class149.regions.length; ++var13) {
                                                    if (class149.regions[var13] == var12 && Buffer.regionLandArchives[var13] != null) {
                                                        NPC.method268(Buffer.regionLandArchives[var13], var27, var26 * 8, var5 * 8, var30, (var10 & 7) * 8, (var11 & 7) * 8, var31, collisionMaps);
                                                        var37 = true;
                                                        break;
                                                    }
                                                }
                                            }

                                            if (!var37) {
                                                FloorDecoration.method2381(var27, var26 * 8, var5 * 8);
                                            }
                                        }
                                    }

                                    ++var27;
                                }
                            }

                            class65.method1454(true);
                            Interpreter.method274();
                            AnimationDefinition.method759();
                            TileItem.method182(Interpreter.scene, collisionMaps);
                            class65.method1454(true);
                            var27 = Tiles.Tiles_minPlane;
                            if (var27 > class22.scenePlane) {
                                var27 = class22.scenePlane;
                            }

                            if (var27 < class22.scenePlane - 1) {
                                var27 = class22.scenePlane - 1;
                            }

                            if (isLowDetail) {
                                Interpreter.scene.method2126(Tiles.Tiles_minPlane);
                            } else {
                                Interpreter.scene.method2126(0);
                            }

                            for (var26 = 0; var26 < 104; ++var26) {
                                for (var5 = 0; var5 < 104; ++var5) {
                                    GameObject.method2205(var26, var5);
                                }
                            }

                            AnimationDefinition.method759();
                            class7.method54();
                            ObjectDefinition.ObjectDefinition_cachedModelData.method3482();
                            if (ObjectSound.field87 != null) {
                                rsaBuf.writeByteOpcode(93);
                                rsaBuf.writeInt(1057001181);
                            }

                            if (!isInInstance) {
                                var26 = (chunkX - 6) / 8;
                                var5 = (chunkX + 6) / 8;
                                var28 = (chunkY - 6) / 8;
                                var29 = (chunkY + 6) / 8;

                                for (var30 = var26 - 1; var30 <= var5 + 1; ++var30) {
                                    for (var31 = var28 - 1; var31 <= var29 + 1; ++var31) {
                                        if (var30 < var26 || var30 > var5 || var31 < var28 || var31 > var29) {
                                            class146.archive5.method3231("m" + var30 + "_" + var31);
                                            class146.archive5.method3231("l" + var30 + "_" + var31);
                                        }
                                    }
                                }
                            }

                            NPC.updateGameState(30);
                            AnimationDefinition.method759();
                            Tiles.Tiles_underlays = null;
                            VarpDefinition.Tiles_overlays = null;
                            Tiles.Tiles_shapes = null;
                            class123.field2031 = null;
                            VertexNormal.field1510 = null;
                            Tiles.field132 = null;
                            Tiles.field120 = null;
                            Tiles.Tiles_hue = null;
                            VertexNormal.Tiles_saturation = null;
                            EnumComposition.Tiles_lightness = null;
                            class1.Tiles_hueMultiplier = null;
                            Skills.field2053 = null;
                            rsaBuf.writeByteOpcode(157);
                            class22.field376.vmethod1698();

                            for (var26 = 0; var26 < 32; ++var26) {
                                GameEngine.graphicsTickTimes[var26] = 0L;
                            }

                            for (var26 = 0; var26 < 32; ++var26) {
                                GameEngine.clientTickTimes[var26] = 0L;
                            }

                            class135.field2329 = 0;
                        }
                    }
                }

                if (gameState == 30) {
                    WorldMapCacheName.method3469();
                } else if (gameState == 40) {
                    TileItem.loggedOutCycle();
                }

                return;
            }

            var1.archive.method3317(var1.archiveDisk, (int) var1.key, var1.data, false);
        }
    }

    protected final void vmethod1586() {
        boolean var1 = class112.method2502();
        if (var1 && field562 && pcmPlayer0 != null) {
            pcmPlayer0.method1274();
        }

        if (GameEngine.field1313) {
            java.awt.Canvas var2 = Tiles.field131;
            var2.removeKeyListener(KeyHandler.KeyHandler_instance);
            var2.removeFocusListener(KeyHandler.KeyHandler_instance);
            KeyHandler.field1360 = -1;
            JagexCache.method1722(Tiles.field131);
            if (class17.field284 != null) {
                class17.field284.vmethod1681(Tiles.field131);
            }

            this.method1571();
            method559(Tiles.field131);
            MusicPatch.method2911(Tiles.field131);
            if (class17.field284 != null) {
                class17.field284.vmethod1690(Tiles.field131);
            }
        }

        int var9;
        if (gameState == 0) {
            var9 = Login.Login_loadingPercent;
            String var3 = Login.Login_loadingText;
            Color var4 = null;

            try {
                Graphics var5 = Tiles.field131.getGraphics();
                if (World.field206 == null) {
                    World.field206 = new java.awt.Font("Helvetica", 1, 13);
                    Loot.field1659 = Tiles.field131.getFontMetrics(World.field206);
                }

                if (GameEngine.field1318) {
                    GameEngine.field1318 = false;
                    var5.setColor(Color.black);
                    var5.fillRect(0, 0, SoundSystem.canvasWidth, Loot.canvasHeight);
                }

                if (var4 == null) {
                    var4 = new Color(140, 17, 17);
                }

                try {
                    if (NPCComposition.field801 == null) {
                        NPCComposition.field801 = Tiles.field131.createImage(304, 34);
                    }

                    Graphics var6 = NPCComposition.field801.getGraphics();
                    var6.setColor(var4);
                    var6.drawRect(0, 0, 303, 33);
                    var6.fillRect(2, 2, var9 * 3, 30);
                    var6.setColor(Color.black);
                    var6.drawRect(1, 1, 301, 31);
                    var6.fillRect(var9 * 3 + 2, 2, 300 - var9 * 3, 30);
                    var6.setFont(World.field206);
                    var6.setColor(Color.white);
                    var6.drawString(var3, (304 - Loot.field1659.stringWidth(var3)) / 2, 22);
                    var5.drawImage(NPCComposition.field801, SoundSystem.canvasWidth / 2 - 152, Loot.canvasHeight / 2 - 18, null);
                } catch (Exception var11) {
                    int var7 = SoundSystem.canvasWidth / 2 - 152;
                    int var8 = Loot.canvasHeight / 2 - 18;
                    var5.setColor(var4);
                    var5.drawRect(var7, var8, 303, 33);
                    var5.fillRect(var7 + 2, var8 + 2, var9 * 3, 30);
                    var5.setColor(Color.black);
                    var5.drawRect(var7 + 1, var8 + 1, 301, 31);
                    var5.fillRect(var7 + var9 * 3 + 2, var8 + 2, 300 - var9 * 3, 30);
                    var5.setFont(World.field206);
                    var5.setColor(Color.white);
                    var5.drawString(var3, var7 + (304 - Loot.field1659.stringWidth(var3)) / 2, var8 + 22);
                }
            } catch (Exception var12) {
                Tiles.field131.repaint();
            }
        } else if (gameState == 5) {
            Script.method32(class40.fontBold12, AccessFile.field762);
        } else if (gameState == 10) {
            Script.method32(class40.fontBold12, AccessFile.field762);
        } else if (gameState == 20) {
            Script.method32(class40.fontBold12, AccessFile.field762);
        } else if (gameState == 25) {
            if (field537 == 1) {
                if (field509 > field560) {
                    field560 = field509;
                }

                var9 = (field560 * 50 - field509 * 50) / field560;
                class27.method570("Loading - please wait." + "<br>" + " (" + var9 + "%" + ")", false);
            } else if (field537 == 2) {
                if (field510 > field491) {
                    field491 = field510;
                }

                var9 = (field491 * 50 - field510 * 50) / field491 + 50;
                class27.method570("Loading - please wait." + "<br>" + " (" + var9 + "%" + ")", false);
            } else {
                class27.method570("Loading - please wait.", false);
            }
        } else if (gameState == 30) {
            Script.method36();
        } else if (gameState == 40) {
            class27.method570("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
        }

        int var10;
        Graphics var15;
        if (gameState == 30 && field693 == 0 && !GameEngine.field1318) {
            try {
                var15 = Tiles.field131.getGraphics();

                for (var10 = 0; var10 < rootWidgetCount; ++var10) {
                    if (field687[var10]) {
                        MouseRecorder.field262.vmethod1941(var15, rootWidgetXs[var10], rootWidgetYs[var10], rootWidgetWidths[var10], rootWidgetHeights[var10]);
                        field687[var10] = false;
                    }
                }
            } catch (Exception var14) {
                Tiles.field131.repaint();
            }
        } else if (gameState > 0) {
            try {
                var15 = Tiles.field131.getGraphics();
                MouseRecorder.field262.vmethod1945(var15, 0, 0);
                GameEngine.field1318 = false;

                for (var10 = 0; var10 < rootWidgetCount; ++var10) {
                    field687[var10] = false;
                }
            } catch (Exception var13) {
                Tiles.field131.repaint();
            }
        }

    }

    protected final void vmethod1532() {
        if (BoundaryObject.field1625 != null) {
            BoundaryObject.field1625.isRunning = false;
        }

        BoundaryObject.field1625 = null;
        if (GraphicsObject.gameSocket != null) {
            GraphicsObject.gameSocket.method1471();
            GraphicsObject.gameSocket = null;
        }

        class17.method184();
        ScriptEvent.method2();
        class17.field284 = null;
        if (pcmPlayer0 != null) {
            pcmPlayer0.method1272();
        }

        if (class27.pcmPlayer1 != null) {
            class27.pcmPlayer1.method1272();
        }

        if (NetCache.NetCache_socket != null) {
            NetCache.NetCache_socket.method1471();
        }

        SceneTilePaint.method2209();
        MusicPatchNode.method3122();
    }

    void method521() {
        if (gameState != 1000) {
            long var2 = ClientPreferences.method148();
            int var4 = (int) (var2 - NetCache.field2521);
            NetCache.field2521 = var2;
            if (var4 > 200) {
                var4 = 200;
            }

            NetCache.NetCache_loadTime += var4;
            boolean var1;
            if (NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
                var1 = true;
            } else if (NetCache.NetCache_socket == null) {
                var1 = false;
            } else {
                try {
                    label242:
                    {
                        if (NetCache.NetCache_loadTime > 30000) {
                            throw new IOException();
                        }

                        NetFileRequest var5;
                        Buffer var6;
                        while (NetCache.NetCache_pendingPriorityResponsesCount < 20 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
                            var5 = (NetFileRequest) NetCache.NetCache_pendingPriorityWrites.method3515();
                            var6 = new Buffer(4);
                            var6.writeByte(1);
                            var6.writeMedium((int) var5.key);
                            NetCache.NetCache_socket.flush(var6.array, 0, 4);
                            NetCache.NetCache_pendingPriorityResponses.method3517(var5, var5.key);
                            --NetCache.NetCache_pendingPriorityWritesCount;
                            ++NetCache.NetCache_pendingPriorityResponsesCount;
                        }

                        while (NetCache.NetCache_pendingResponsesCount < 20 && NetCache.NetCache_pendingWritesCount > 0) {
                            var5 = (NetFileRequest) NetCache.NetCache_pendingWritesQueue.method3488();
                            var6 = new Buffer(4);
                            var6.writeByte(0);
                            var6.writeMedium((int) var5.key);
                            NetCache.NetCache_socket.flush(var6.array, 0, 4);
                            var5.method3509();
                            NetCache.NetCache_pendingResponses.method3517(var5, var5.key);
                            --NetCache.NetCache_pendingWritesCount;
                            ++NetCache.NetCache_pendingResponsesCount;
                        }

                        for (int var17 = 0; var17 < 100; ++var17) {
                            int var18 = NetCache.NetCache_socket.available();
                            if (var18 < 0) {
                                throw new IOException();
                            }

                            if (var18 == 0) {
                                break;
                            }

                            NetCache.NetCache_loadTime = 0;
                            byte var7 = 0;
                            if (MusicPatchPcmStream.NetCache_currentResponse == null) {
                                var7 = 8;
                            } else if (NetCache.field2533 == 0) {
                                var7 = 1;
                            }

                            int var8;
                            int var9;
                            int var10;
                            int var12;
                            if (var7 > 0) {
                                var8 = var7 - NetCache.NetCache_responseHeaderBuffer.offset;
                                if (var8 > var18) {
                                    var8 = var18;
                                }

                                NetCache.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var8);
                                if (NetCache.field2536 != 0) {
                                    for (var9 = 0; var9 < var8; ++var9) {
                                        NetCache.NetCache_responseHeaderBuffer.array[NetCache.NetCache_responseHeaderBuffer.offset + var9] ^= NetCache.field2536;
                                    }
                                }

                                NetCache.NetCache_responseHeaderBuffer.offset += var8;
                                if (NetCache.NetCache_responseHeaderBuffer.offset < var7) {
                                    break;
                                }

                                if (MusicPatchPcmStream.NetCache_currentResponse == null) {
                                    NetCache.NetCache_responseHeaderBuffer.offset = 0;
                                    var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                                    var10 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
                                    int var11 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                                    var12 = NetCache.NetCache_responseHeaderBuffer.readInt();
                                    long var13 = var10 + (var9 << 16);
                                    NetFileRequest var15 = (NetFileRequest) NetCache.NetCache_pendingPriorityResponses.method3512(var13);
                                    NetCache.field2519 = true;
                                    if (var15 == null) {
                                        var15 = (NetFileRequest) NetCache.NetCache_pendingResponses.method3512(var13);
                                        NetCache.field2519 = false;
                                    }

                                    if (var15 == null) {
                                        throw new IOException();
                                    }

                                    int var16 = var11 == 0 ? 5 : 9;
                                    MusicPatchPcmStream.NetCache_currentResponse = var15;
                                    class68.NetCache_responseArchiveBuffer = new Buffer(var12 + var16 + MusicPatchPcmStream.NetCache_currentResponse.padding);
                                    class68.NetCache_responseArchiveBuffer.writeByte(var11);
                                    class68.NetCache_responseArchiveBuffer.writeInt(var12);
                                    NetCache.field2533 = 8;
                                    NetCache.NetCache_responseHeaderBuffer.offset = 0;
                                } else if (NetCache.field2533 == 0) {
                                    if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
                                        NetCache.field2533 = 1;
                                        NetCache.NetCache_responseHeaderBuffer.offset = 0;
                                    } else {
                                        MusicPatchPcmStream.NetCache_currentResponse = null;
                                    }
                                }
                            } else {
                                var8 = class68.NetCache_responseArchiveBuffer.array.length - MusicPatchPcmStream.NetCache_currentResponse.padding;
                                var9 = 512 - NetCache.field2533;
                                if (var9 > var8 - class68.NetCache_responseArchiveBuffer.offset) {
                                    var9 = var8 - class68.NetCache_responseArchiveBuffer.offset;
                                }

                                if (var9 > var18) {
                                    var9 = var18;
                                }

                                NetCache.NetCache_socket.read(class68.NetCache_responseArchiveBuffer.array, class68.NetCache_responseArchiveBuffer.offset, var9);
                                if (NetCache.field2536 != 0) {
                                    for (var10 = 0; var10 < var9; ++var10) {
                                        class68.NetCache_responseArchiveBuffer.array[var10 + class68.NetCache_responseArchiveBuffer.offset] ^= NetCache.field2536;
                                    }
                                }

                                class68.NetCache_responseArchiveBuffer.offset += var9;
                                NetCache.field2533 += var9;
                                if (var8 == class68.NetCache_responseArchiveBuffer.offset) {
                                    if (16711935L == MusicPatchPcmStream.NetCache_currentResponse.key) {
                                        WallDecoration.NetCache_reference = class68.NetCache_responseArchiveBuffer;

                                        for (var10 = 0; var10 < 256; ++var10) {
                                            Archive var19 = NetCache.NetCache_archives[var10];
                                            if (var19 != null) {
                                                WallDecoration.NetCache_reference.offset = var10 * 8 + 5;
                                                var12 = WallDecoration.NetCache_reference.readInt();
                                                int var20 = WallDecoration.NetCache_reference.readInt();
                                                var19.method3299(var12, var20);
                                            }
                                        }
                                    } else {
                                        NetCache.NetCache_crc.reset();
                                        NetCache.NetCache_crc.update(class68.NetCache_responseArchiveBuffer.array, 0, var8);
                                        var10 = (int) NetCache.NetCache_crc.getValue();
                                        if (var10 != MusicPatchPcmStream.NetCache_currentResponse.crc) {
                                            try {
                                                NetCache.NetCache_socket.method1471();
                                            } catch (Exception var23) {
                                            }

                                            ++NetCache.NetCache_crcMismatches;
                                            NetCache.NetCache_socket = null;
                                            NetCache.field2536 = (byte) ((int) (Math.random() * 255.0D + 1.0D));
                                            var1 = false;
                                            break label242;
                                        }

                                        NetCache.NetCache_crcMismatches = 0;
                                        NetCache.NetCache_ioExceptions = 0;
                                        MusicPatchPcmStream.NetCache_currentResponse.archive.method3300((int) (MusicPatchPcmStream.NetCache_currentResponse.key & 65535L), class68.NetCache_responseArchiveBuffer.array, (MusicPatchPcmStream.NetCache_currentResponse.key & 16711680L) == 16711680L, NetCache.field2519);
                                    }

                                    MusicPatchPcmStream.NetCache_currentResponse.remove();
                                    if (NetCache.field2519) {
                                        --NetCache.NetCache_pendingPriorityResponsesCount;
                                    } else {
                                        --NetCache.NetCache_pendingResponsesCount;
                                    }

                                    NetCache.field2533 = 0;
                                    MusicPatchPcmStream.NetCache_currentResponse = null;
                                    class68.NetCache_responseArchiveBuffer = null;
                                } else {
                                    if (NetCache.field2533 != 512) {
                                        break;
                                    }

                                    NetCache.field2533 = 0;
                                }
                            }
                        }

                        var1 = true;
                    }
                } catch (IOException var24) {
                    try {
                        NetCache.NetCache_socket.method1471();
                    } catch (Exception var22) {
                    }

                    ++NetCache.NetCache_ioExceptions;
                    NetCache.NetCache_socket = null;
                    var1 = false;
                }
            }

            if (!var1) {
                this.method307();
            }

        }
    }

    void method307() {
        if (NetCache.NetCache_crcMismatches >= 4) {
            this.method1533("js5crc");
            gameState = 1000;
        } else {
            if (NetCache.NetCache_ioExceptions >= 4) {
                if (gameState <= 5) {
                    this.method1533("js5io");
                    gameState = 1000;
                    return;
                }

                field544 = 3000;
                NetCache.NetCache_ioExceptions = 3;
            }

            if (--field544 + 1 <= 0) {
                try {
                    if (js5ConnectState == 0) {
                        Canvas.js5SocketTask = ItemContainer.taskHandler.createSocket(SoundSystem.worldHost, class82.currentPort);
                        ++js5ConnectState;
                    }

                    if (js5ConnectState == 1) {
                        if (Canvas.js5SocketTask.status == 2) {
                            this.method308(-1);
                            return;
                        }

                        if (Canvas.js5SocketTask.status == 1) {
                            ++js5ConnectState;
                        }
                    }

                    if (js5ConnectState == 2) {
                        Decimator.js5Socket = new IterableNodeHashTableIterator((Socket) Canvas.js5SocketTask.result, ItemContainer.taskHandler);
                        Buffer var1 = new Buffer(5);
                        var1.writeByte(15);
                        var1.writeInt(31);
                        Decimator.js5Socket.flush(var1.array, 0, 5);
                        ++js5ConnectState;
                        ItemContainer.field289 = ClientPreferences.method148();
                    }

                    if (js5ConnectState == 3) {
                        if (gameState > 5 && Decimator.js5Socket.available() <= 0) {
                            if (ClientPreferences.method148() - ItemContainer.field289 > 30000L) {
                                this.method308(-2);
                                return;
                            }
                        } else {
                            int var2 = Decimator.js5Socket.readByte();
                            if (var2 != 0) {
                                this.method308(var2);
                                return;
                            }

                            ++js5ConnectState;
                        }
                    }

                    if (js5ConnectState == 4) {
                        VarbitComposition.method837(Decimator.js5Socket, gameState > 20);
                        Canvas.js5SocketTask = null;
                        Decimator.js5Socket = null;
                        js5ConnectState = 0;
                        js5Errors = 0;
                    }
                } catch (IOException var3) {
                    this.method308(-3);
                }

            }
        }
    }

    void method308(int var1) {
        Canvas.js5SocketTask = null;
        Decimator.js5Socket = null;
        js5ConnectState = 0;
        if (MouseRecorder.OSRS_PORT == class82.currentPort) {
            class82.currentPort = somePortIncrement;
        } else {
            class82.currentPort = MouseRecorder.OSRS_PORT;
        }

        ++js5Errors;
        if (js5Errors >= 2 && (var1 == 7 || var1 == 9)) {
            if (gameState <= 5) {
                this.method1533("js5connect_full");
                gameState = 1000;
            } else {
                field544 = 3000;
            }
        } else if (js5Errors >= 2 && var1 == 6) {
            this.method1533("js5connect_outofdate");
            gameState = 1000;
        } else if (js5Errors >= 4) {
            if (gameState <= 5) {
                //this.method1533("js5connect");
                System.out.println("Server unavailable: " + Applet.INSTANCE.getCodeBase());
                System.exit(-1);
            } else {
                field544 = 3000;
            }
        }

    }

    public final void init() {
        Logger.INSTANCE.debug("OSRS Classic: Revision 31");
        try {
            if (this.method1537()) {
                WorldMapCacheName[] var1 = new WorldMapCacheName[]{WorldMapCacheName.field2778, WorldMapCacheName.field2775, WorldMapCacheName.field2783, WorldMapCacheName.field2779, WorldMapCacheName.field2777, WorldMapCacheName.field2776, WorldMapCacheName.field2781, WorldMapCacheName.field2780, WorldMapCacheName.field2782};
                WorldMapCacheName[] var2 = var1;

                for (int var3 = 0; var3 < var2.length; ++var3) {
                    WorldMapCacheName var4 = var2[var3];
                    String var5 = this.getParameter(var4.field2784);
                    if (var5 != null) {
                        int var10;
                        switch (Integer.parseInt(var4.field2784)) {
                            case 1:
                                int var7 = Integer.parseInt(var5);
                                GameBuild[] var8 = new GameBuild[]{GameBuild.RC, GameBuild.WIP, GameBuild.LIVE, GameBuild.BUILDLIVE};
                                GameBuild[] var20 = var8;
                                var10 = 0;

                                GameBuild var19;
                                while (true) {
                                    if (var10 >= var20.length) {
                                        var19 = null;
                                        break;
                                    }

                                    GameBuild var21 = var20[var10];
                                    if (var7 == var21.buildId) {
                                        var19 = var21;
                                        break;
                                    }

                                    ++var10;
                                }
                                assert var19 != null;
                                Logger.INSTANCE.debug("Build: (id) " + var19.buildId + " - (name) " + var19.name);
                                NPC.field400 = var19;
                                break;
                            case 2:
                                StudioGame[] var12 = ObjectDefinition.method672();
                                int var13 = Integer.parseInt(var5);
                                StudioGame[] var9 = var12;
                                var10 = 0;

                                StudioGame var6;
                                while (true) {
                                    if (var10 >= var9.length) {
                                        var6 = null;
                                        break;
                                    }

                                    StudioGame var11 = var9[var10];
                                    if (var13 == var11.vmethod2859()) {
                                        var6 = var11;
                                        break;
                                    }

                                    ++var10;
                                }
                                Logger.INSTANCE.debug("Studio Game: (id) " + var6.id + " - (name) " + var6.name);
                                field484 = var6;
                                if (field484 == StudioGame.oldscape) {
                                    class5.field75 = LoginType.oldscape;
                                } else {
                                    class5.field75 = LoginType.field2862;
                                }
                                break;
                            case 3:
                                ViewportMouse_y = Integer.parseInt(var5);
                                break;
                            case 4:
                                FaceNormal.field1522 = var5;
                            case 5:
                            default:
                                break;
                            case 6:
                                ViewportMouse_x = Integer.parseInt(var5);
                                break;
                            case 7:
                                if (var5.equalsIgnoreCase("true")) {
                                }
                                break;
                            case 9:
                                isMembersWorld = var5.equalsIgnoreCase("true");
                        }
                    }
                }

                class7.method55();
                SoundSystem.worldHost = this.getCodeBase().getHost();
                String var18 = NPC.field400.name;
                byte var14 = 0;

                try {
                    Login.method241("oldschool", var18, var14, 16);
                } catch (Exception var16) {
                    ScriptEvent.method3(null, var16);
                }

                instance = this;
                this.method1519(765, 503, 31);
            }
        } catch (RuntimeException var17) {
            var17.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void method559(Component var0) {
        var0.setFocusTraversalKeysEnabled(false);
        var0.addKeyListener(KeyHandler.KeyHandler_instance);
        var0.addFocusListener(KeyHandler.KeyHandler_instance);
    }

    public static final boolean method530() {
        KeyHandler var0 = KeyHandler.KeyHandler_instance;
        synchronized (KeyHandler.KeyHandler_instance) {
            if (KeyHandler.field1343 == KeyHandler.field1365) {
                return false;
            } else {
                VarbitComposition.field966 = KeyHandler.field1362[KeyHandler.field1365];
                IsaacCipher.field2000 = KeyHandler.field1361[KeyHandler.field1365];
                KeyHandler.field1365 = KeyHandler.field1365 + 1 & 127;
                return true;
            }
        }
    }

    public static void method567(Buffer var0, int var1) {
        if (JagexCache.JagexCache_randomDat != null) {
            try {
                JagexCache.JagexCache_randomDat.method601(0L);
                JagexCache.JagexCache_randomDat.method606(var0.array, var1, 24);
            } catch (Exception var3) {
            }
        }

    }

    static final void method354(PendingSpawn var0) {
        int var1 = 0;
        int var2 = -1;
        int var3 = 0;
        int var4 = 0;
        if (var0.type == 0) {
            var1 = Interpreter.scene.method2057(var0.plane, var0.x, var0.y);
        }

        if (var0.type == 1) {
            var1 = Interpreter.scene.method2061(var0.plane, var0.x, var0.y);
        }

        if (var0.type == 2) {
            var1 = Interpreter.scene.method2069(var0.plane, var0.x, var0.y);
        }

        if (var0.type == 3) {
            var1 = Interpreter.scene.method2070(var0.plane, var0.x, var0.y);
        }

        if (var1 != 0) {
            int var5 = Interpreter.scene.method2071(var0.plane, var0.x, var0.y, var1);
            var2 = var1 >> 14 & 32767;
            var3 = var5 & 31;
            var4 = var5 >> 6 & 3;
        }

        var0.objectId = var2;
        var0.field359 = var3;
        var0.field361 = var4;
    }

    static void method568() {
        for (InterfaceParent var0 = (InterfaceParent) interfaceParents.method3515(); var0 != null; var0 = (InterfaceParent) interfaceParents.method3516()) {
            int var1 = var0.group;
            if (EnumComposition.method852(var1)) {
                boolean var2 = true;
                Widget[] var3 = Widget.Widget_interfaceComponents[var1];

                int var4;
                for (var4 = 0; var4 < var3.length; ++var4) {
                    if (var3[var4] != null) {
                        var2 = var3[var4].isIf3;
                        break;
                    }
                }

                if (!var2) {
                    var4 = (int) var0.key;
                    Widget var5 = class130.getWidget(var4);
                    if (var5 != null) {
                        class82.invalidateWidget(var5);
                    }
                }
            }
        }

    }

    static final boolean method538(Widget var0) {
        int var1 = var0.contentType;
        if (var1 == 205) {
            logoutTimer = 250;
            return true;
        } else {
            int var2;
            int var3;
            if (var1 >= 300 && var1 <= 313) {
                var2 = (var1 - 300) / 2;
                var3 = var1 & 1;
                playerAppearance.method3421(var2, var3 == 1);
            }

            if (var1 >= 314 && var1 <= 323) {
                var2 = (var1 - 314) / 2;
                var3 = var1 & 1;
                playerAppearance.method3403(var2, var3 == 1);
            }

            if (var1 == 324) {
                playerAppearance.method3404(false);
            }

            if (var1 == 325) {
                playerAppearance.method3404(true);
            }

            if (var1 == 326) {
                rsaBuf.writeByteOpcode(115);
                playerAppearance.method3405(rsaBuf);
                return true;
            } else {
                return false;
            }
        }
    }
}
