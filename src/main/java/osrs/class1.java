package osrs;

public class class1 {
    static int[] Tiles_hueMultiplier;
    static int[] field22;
    static SpritePixels[] worldSelectBackSprites;

    public static SpritePixels method13(AbstractArchive var0, String var1, String var2) {
        int var3 = var0.getGroupId(var1);
        int var4 = var0.method3238(var3, var2);
        SpritePixels var5;
        if (!KitDefinition.method796(var0, var3, var4)) {
            var5 = null;
        } else {
            var5 = ClientPreferences.method152();
        }

        return var5;
    }

    static final int method11(int var0, int var1) {
        int var2 = class23.method253('넵' + var0, 91923 + var1, 4) - 128 + (class23.method253(10294 + var0, var1 + '鎽', 2) - 128 >> 1) + (class23.method253(var0, var1, 1) - 128 >> 2);
        var2 = (int) ((double) var2 * 0.3D) + 35;
        if (var2 < 10) {
            var2 = 10;
        } else if (var2 > 60) {
            var2 = 60;
        }

        return var2;
    }

    static final void method8(int var0, int var1, int var2) {
        if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
            int var3 = BufferedFile.getTileHeight(var0, var1, class22.scenePlane) - var2;
            var0 -= Login.cameraX;
            var3 -= class22.cameraY;
            var1 -= class17.cameraZ;
            int var4 = Rasterizer3D.Rasterizer3D_sine[NPC.cameraPitch];
            int var5 = Rasterizer3D.Rasterizer3D_cosine[NPC.cameraPitch];
            int var6 = Rasterizer3D.Rasterizer3D_sine[MouseRecorder.cameraYaw];
            int var7 = Rasterizer3D.Rasterizer3D_cosine[MouseRecorder.cameraYaw];
            int var8 = var6 * var1 + var0 * var7 >> 16;
            var1 = var7 * var1 - var0 * var6 >> 16;
            var0 = var8;
            var8 = var3 * var5 - var4 * var1 >> 16;
            var1 = var5 * var1 + var3 * var4 >> 16;
            if (var1 >= 50) {
                Client.viewportTempX = (var0 << 9) / var1 + 256;
                Client.viewportTempY = (var8 << 9) / var1 + 167;
            } else {
                Client.viewportTempX = -1;
                Client.viewportTempY = -1;
            }

        } else {
            Client.viewportTempX = -1;
            Client.viewportTempY = -1;
        }
    }

    static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        PendingSpawn var9 = null;

        for (PendingSpawn var10 = (PendingSpawn) Client.pendingSpawns.method3533(); var10 != null; var10 = (PendingSpawn) Client.pendingSpawns.method3535()) {
            if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
                var9 = var10;
                break;
            }
        }

        if (var9 == null) {
            var9 = new PendingSpawn();
            var9.plane = var0;
            var9.type = var3;
            var9.x = var1;
            var9.y = var2;
            Client.method354(var9);
            Client.pendingSpawns.method3528(var9);
        }

        var9.id = var4;
        var9.field362 = var5;
        var9.orientation = var6;
        var9.delay = var7;
        var9.hitpoints = var8;
    }

    static final void updatePlayer(int playerIndex, Player player, int flag) {
        if ((flag & 4) != 0) {
            player.field475 = Client.serverPacketBuf.readUnsignedShortLE();
            player.field446 = Client.serverPacketBuf.readUnsignedShortLE();
        }

        //forceMovement
        if ((flag & 512) != 0) {
            player.field460 = Client.serverPacketBuf.readUnsignedByte();
            player.field462 = Client.serverPacketBuf.readUnsignedByte();
            player.field439 = Client.serverPacketBuf.readUnsignedByteSub();
            player.field463 = Client.serverPacketBuf.readUnsignedByteSub();
            player.field456 = Client.serverPacketBuf.readUnsignedShort() + Client.cycle;
            player.field465 = Client.serverPacketBuf.readUnsignedShortAddLE() + Client.cycle;
            player.field466 = Client.serverPacketBuf.readUnsignedByteAdd();
            player.pathLength = 1;
            player.remainingSteps = 0;
        }

        //Appearance
        int index;
        if ((flag & 1) != 0) {
            index = Client.serverPacketBuf.readUnsignedByteSub();
            byte[] b = new byte[index];
            Buffer appearanceCache = new Buffer(b);
            Client.serverPacketBuf.readBytes(b, 0, index);
            Client.appearanceCache[playerIndex] = appearanceCache;
            player.updateAppearance(appearanceCache);
        }

        int var14;
        if ((flag & 2) != 0) {
            index = Client.serverPacketBuf.readUnsignedShort();
            var14 = Client.serverPacketBuf.readUnsignedByte();
            int var15 = Client.serverPacketBuf.readUnsignedByteSub();
            int var6 = Client.serverPacketBuf.offset;
            if (player.field35 != null && player.appearance != null) {
                boolean var7 = var14 <= 1 && ObjectSound.method45(player.field35);

                if (!var7 && Client.xPadding == 0) {
                    Client.field535.offset = 0;
                    Client.serverPacketBuf.readBytes(Client.field535.array, 0, var15);
                    Client.field535.offset = 0;
                    Buffer var9 = Client.field535;

                    String var10;
                    try {
                        int var11 = var9.method2658();
                        if (var11 > 32767) {
                            var11 = 32767;
                        }

                        byte[] var12 = new byte[var11];
                        var9.offset += class183.huffman.method2572(var9.array, var9.offset, var12, 0, var11);
                        String var13 = InterfaceParent.readString(var12, 0, var11);
                        var10 = var13;
                    } catch (Exception var17) {
                        var10 = "Cabbage";
                    }

                    var10 = AbstractFont.method3605(TaskHandler.method1595(var10));
                    player.overheadText = var10.trim();
                    player.field436 = index >> 8;
                    player.field445 = index & 255;
                    player.field435 = 150;
                    if (var14 != 2 && var14 != 3) {
                        if (var14 == 1) {
                            Login.setOverheadText(1, FloorOverlayDefinition.method829(0) + player.field35, var10);
                        } else {
                            Login.setOverheadText(2, player.field35, var10);
                        }
                    } else {
                        Login.setOverheadText(1, FloorOverlayDefinition.method829(1) + player.field35, var10);
                    }
                }
            }

            Client.serverPacketBuf.offset = var6 + var15;
        }

        //Animation
        if ((flag & 16) != 0) {
            index = Client.serverPacketBuf.readUnsignedShort();
            if (index == 65535) {
                index = -1;
            }

            var14 = Client.serverPacketBuf.readUnsignedByte();
            SpotAnimationDefinition.setAnimation(player, index, var14);
        }

        //ForceChat
        if ((flag & 64) != 0) {
            player.overheadText = Client.serverPacketBuf.readChatString();
            if (player.overheadText.charAt(0) == '~') {
                player.overheadText = player.overheadText.substring(1);
                Login.setOverheadText(2, player.field35, player.overheadText);
            } else if (player == Tiles.localPlayer) {
                Login.setOverheadText(2, player.field35, player.overheadText);
            }

            player.field436 = 0;
            player.field445 = 0;
            player.field435 = 150;
        }

        if ((flag & 8) != 0) {
            index = Client.serverPacketBuf.readUnsignedByte();
            var14 = Client.serverPacketBuf.readUnsignedByte();
            player.method277(index, var14, Client.cycle);
            player.field441 = Client.cycle + 300;
            player.field431 = Client.serverPacketBuf.readUnsignedByteNeg();
            player.field425 = Client.serverPacketBuf.readUnsignedByteSub();
        }

        if ((flag & 1024) != 0) {
            player.spotAnimation = Client.serverPacketBuf.readUnsignedShortLE();
            index = Client.serverPacketBuf.readInt();
            player.field430 = index >> 16;
            player.field458 = (index & '\uffff') + Client.cycle;
            player.spotAnimationFrame = 0;
            player.spotAnimationFrameCycle = 0;
            if (player.field458 > Client.cycle) {
                player.spotAnimationFrame = -1;
            }

            if (player.spotAnimation == 65535) {
                player.spotAnimation = -1;
            }
        }

        if ((flag & 256) != 0) {
            index = Client.serverPacketBuf.readUnsignedByteNeg();
            var14 = Client.serverPacketBuf.readUnsignedByteAdd();
            player.method277(index, var14, Client.cycle);
            player.field441 = Client.cycle + 300;
            player.field431 = Client.serverPacketBuf.readUnsignedByteNeg();
            player.field425 = Client.serverPacketBuf.readUnsignedByte();
        }

        if ((flag & 128) != 0) {
            player.field444 = Client.serverPacketBuf.readUnsignedShortAdd();
            if (player.field444 == 65535) {
                player.field444 = -1;
            }
        }

    }

    static final void method9() {
        int var0 = class40.fontBold12.method3601("Choose Option");

        int var1;
        for (var1 = 0; var1 < Client.menuOptionsCount; ++var1) {
            Font var5 = class40.fontBold12;
            String var6;
            if (Client.menuTargets[var1].length() > 0) {
                var6 = Client.menuActions[var1] + " " + Client.menuTargets[var1];
            } else {
                var6 = Client.menuActions[var1];
            }

            int var4 = var5.method3601(var6);
            if (var4 > var0) {
                var0 = var4;
            }
        }

        var0 += 8;
        var1 = Client.menuOptionsCount * 15 + 21;
        int var2 = MouseHandler.MouseHandler_lastPressedX - var0 / 2;
        if (var0 + var2 > 765) {
            var2 = 765 - var0;
        }

        if (var2 < 0) {
            var2 = 0;
        }

        int var3 = MouseHandler.MouseHandler_lastPressedY;
        if (var1 + var3 > 503) {
            var3 = 503 - var1;
        }

        if (var3 < 0) {
            var3 = 0;
        }

        Client.isMenuOpen = true;
        ItemContainer.menuX = var2;
        BufferedFile.menuY = var3;
        IterableNodeHashTableIterator.menuWidth = var0;
        Decimator.menuHeight = Client.menuOptionsCount * 15 + 22;
    }

    static final void method5(String var0, int var1) {
        Client.rsaBuf.writeByteOpcode(173);
        PacketBuffer var2 = Client.rsaBuf;
        int var3 = var0.length() + 1;
        var2.writeByte(var3 + 1);
        Client.rsaBuf.writeStringCp1252NullTerminated(var0);
        Client.rsaBuf.method2667(var1);
    }
}
