package osrs;

public class Widget extends Node {
    public static Widget[][] Widget_interfaceComponents;
    public static boolean[] Widget_loadedInterfaces;
    public static AbstractArchive Widget_archive;
    public static AbstractArchive Widget_spritesArchive;
    public static EvictingDualNodeHashTable Widget_cachedModels = new EvictingDualNodeHashTable(200);
    public static EvictingDualNodeHashTable Widget_cachedFonts = new EvictingDualNodeHashTable(50);
    public static EvictingDualNodeHashTable Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(20);
    public static boolean field2574 = false;
    public boolean isIf3 = false;
    public int id = -1;
    public int childIndex = -1;
    public int type;
    public int buttonType = 0;
    public int contentType = 0;
    public int rawX = 0;
    public int field2579 = 0;
    public int field2623 = 0;
    public int field2584 = 0;
    public int width = 0;
    public int height = 0;
    public int parentId = -1;
    public boolean field2588 = false;
    public int field2589 = 0;
    public int field2655 = 0;
    public int field2576 = 0;
    public int field2592 = 0;
    public int color = 0;
    public int field2678 = 0;
    public int field2595 = 0;
    public int field2596 = 0;
    public boolean field2647 = false;
    public int field2582 = 0;
    public int field2599 = 1;
    public int spriteId2 = -1;
    public int spriteId = -1;
    public int field2688 = 0;
    public boolean field2603 = false;
    public int field2604 = 0;
    public int field2667 = 0;
    public boolean field2606;
    public boolean spriteFlipV;
    public int modelType = 1;
    public int modelId = -1;
    int modelType2 = 1;
    int modelId2 = -1;
    public int sequenceId = -1;
    public int sequenceId2 = -1;
    public int field2577 = 0;
    public int field2668 = 0;
    public int modelAngleX = 0;
    public int modelAngleY = 0;
    public int field2614 = 0;
    public int field2679 = 100;
    public int field2601 = 0;
    public boolean field2621 = false;
    public int fontId = -1;
    public String field2633 = "";
    public String field2624 = "";
    public int field2625 = 0;
    public int field2626 = 0;
    public int field2627 = 0;
    public boolean field2628 = false;
    public int field2611 = 0;
    public int field2652 = 0;
    public int[] field2631;
    public int[] field2632;
    public int[] inventorySprites;
    public String[] field2602;
    public int field2644 = 0;
    public String field2636 = "";
    public String[] actions;
    public Widget parent = null;
    public int field2567 = 0;
    public int field2640 = 0;
    public boolean isScrollBar = false;
    public String spellActionName = "";
    public boolean hasListener = false;
    public Object[] onLoad;
    public Object[] field2645;
    public Object[] field2629;
    public Object[] field2659;
    public Object[] field2648;
    public Object[] field2649;
    public Object[] field2650;
    public Object[] field2651;
    public Object[] field2657;
    public Object[] field2653;
    public Object[] field2660;
    public Object[] onTargetLeave;
    public Object[] field2656;
    public int[] field2654;
    public Object[] field2630;
    public int[] field2605;
    public Object[] field2620;
    public int[] field2687;
    public Object[] field2658;
    public Object[] field2635;
    public Object[] field2661;
    public Object[] field2665;
    public Object[] field2666;
    public Object[] field2571;
    public Object[] field2618;
    public Object[] field2669;
    public Object[] onDialogAbort;
    public Object[] onSubChange;
    public int[][] cs1Instructions;
    public int[] cs1Comparisons;
    public int[] cs1ComparisonValues;
    public int field2675 = -1;
    public String field2676 = "";
    public String field2677 = "Ok";
    public int[] itemIds;
    public int[] itemQuantities;
    public int field2680 = -1;
    public int field2681 = 0;
    public int modelFrame = 0;
    public int modelFrameCycle = 0;
    public Widget[] children;
    public boolean field2685 = false;
    public boolean field2686 = false;
    public int field2662 = -1;
    public int field2594 = 0;
    public int field2689 = 0;
    public int field2590 = 0;
    public int rootIndex = -1;
    public int cycle = -1;

    void method3336(Buffer var1) {
        this.isIf3 = false;
        this.type = var1.readUnsignedByte();
        this.buttonType = var1.readUnsignedByte();
        this.contentType = var1.readUnsignedShort();
        this.field2623 = this.rawX = var1.readShort();
        this.field2584 = this.field2579 = var1.readShort();
        this.width = var1.readUnsignedShort();
        this.height = var1.readUnsignedShort();
        this.field2582 = var1.readUnsignedByte();
        this.parentId = var1.readUnsignedShort();
        if (this.parentId == 65535) {
            this.parentId = -1;
        } else {
            this.parentId += this.id & -65536;
        }

        this.field2675 = var1.readUnsignedShort();
        if (this.field2675 == 65535) {
            this.field2675 = -1;
        }

        int var2 = var1.readUnsignedByte();
        int var3;
        if (var2 > 0) {
            this.cs1Comparisons = new int[var2];
            this.cs1ComparisonValues = new int[var2];

            for (var3 = 0; var3 < var2; ++var3) {
                this.cs1Comparisons[var3] = var1.readUnsignedByte();
                this.cs1ComparisonValues[var3] = var1.readUnsignedShort();
            }
        }

        var3 = var1.readUnsignedByte();
        int var4;
        int var5;
        int var6;
        if (var3 > 0) {
            this.cs1Instructions = new int[var3][];

            for (var4 = 0; var4 < var3; ++var4) {
                var5 = var1.readUnsignedShort();
                this.cs1Instructions[var4] = new int[var5];

                for (var6 = 0; var6 < var5; ++var6) {
                    this.cs1Instructions[var4][var6] = var1.readUnsignedShort();
                    if (this.cs1Instructions[var4][var6] == 65535) {
                        this.cs1Instructions[var4][var6] = -1;
                    }
                }
            }
        }

        if (this.type == 0) {
            this.field2592 = var1.readUnsignedShort();
            this.field2588 = var1.readUnsignedByte() == 1;
        }

        if (this.type == 1) {
            var1.readUnsignedShort();
            var1.readUnsignedByte();
        }

        if (this.type == 2) {
            this.itemIds = new int[this.height * this.width];
            this.itemQuantities = new int[this.height * this.width];
            var4 = var1.readUnsignedByte();
            if (var4 == 1) {
                this.field2644 |= 268435456;
            }

            var5 = var1.readUnsignedByte();
            if (var5 == 1) {
                this.field2644 |= 1073741824;
            }

            var6 = var1.readUnsignedByte();
            if (var6 == 1) {
                this.field2644 |= Integer.MIN_VALUE;
            }

            int var7 = var1.readUnsignedByte();
            if (var7 == 1) {
                this.field2644 |= 536870912;
            }

            this.field2611 = var1.readUnsignedByte();
            this.field2652 = var1.readUnsignedByte();
            this.field2631 = new int[20];
            this.field2632 = new int[20];
            this.inventorySprites = new int[20];

            int var8;
            for (var8 = 0; var8 < 20; ++var8) {
                int var11 = var1.readUnsignedByte();
                if (var11 == 1) {
                    this.field2631[var8] = var1.readShort();
                    this.field2632[var8] = var1.readShort();
                    this.inventorySprites[var8] = var1.readInt();
                } else {
                    this.inventorySprites[var8] = -1;
                }
            }

            this.field2602 = new String[5];

            for (var8 = 0; var8 < 5; ++var8) {
                String var9 = var1.readChatString();
                if (var9.length() > 0) {
                    this.field2602[var8] = var9;
                    this.field2644 |= 1 << var8 + 23;
                }
            }
        }

        if (this.type == 3) {
            this.field2647 = var1.readUnsignedByte() == 1;
        }

        if (this.type == 4 || this.type == 1) {
            this.field2626 = var1.readUnsignedByte();
            this.field2627 = var1.readUnsignedByte();
            this.field2625 = var1.readUnsignedByte();
            this.fontId = var1.readUnsignedShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.field2628 = var1.readUnsignedByte() == 1;
        }

        if (this.type == 4) {
            this.field2633 = var1.readChatString();
            this.field2624 = var1.readChatString();
        }

        if (this.type == 1 || this.type == 3 || this.type == 4) {
            this.color = var1.readInt();
        }

        if (this.type == 3 || this.type == 4) {
            this.field2678 = var1.readInt();
            this.field2595 = var1.readInt();
            this.field2596 = var1.readInt();
        }

        if (this.type == 5) {
            this.spriteId2 = var1.readInt();
            this.spriteId = var1.readInt();
        }

        if (this.type == 6) {
            this.modelType = 1;
            this.modelId = var1.readUnsignedShort();
            if (this.modelId == 65535) {
                this.modelId = -1;
            }

            this.modelType2 = 1;
            this.modelId2 = var1.readUnsignedShort();
            if (this.modelId2 == 65535) {
                this.modelId2 = -1;
            }

            this.sequenceId = var1.readUnsignedShort();
            if (this.sequenceId == 65535) {
                this.sequenceId = -1;
            }

            this.sequenceId2 = var1.readUnsignedShort();
            if (this.sequenceId2 == 65535) {
                this.sequenceId2 = -1;
            }

            this.field2679 = var1.readUnsignedShort();
            this.modelAngleX = var1.readUnsignedShort();
            this.modelAngleY = var1.readUnsignedShort();
        }

        if (this.type == 7) {
            this.itemIds = new int[this.height * this.width];
            this.itemQuantities = new int[this.height * this.width];
            this.field2626 = var1.readUnsignedByte();
            this.fontId = var1.readUnsignedShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.field2628 = var1.readUnsignedByte() == 1;
            this.color = var1.readInt();
            this.field2611 = var1.readShort();
            this.field2652 = var1.readShort();
            var4 = var1.readUnsignedByte();
            if (var4 == 1) {
                this.field2644 |= 1073741824;
            }

            this.field2602 = new String[5];

            for (var5 = 0; var5 < 5; ++var5) {
                String var10 = var1.readChatString();
                if (var10.length() > 0) {
                    this.field2602[var5] = var10;
                    this.field2644 |= 1 << var5 + 23;
                }
            }
        }

        if (this.type == 8) {
            this.field2633 = var1.readChatString();
        }

        if (this.buttonType == 2 || this.type == 2) {
            this.spellActionName = var1.readChatString();
            this.field2676 = var1.readChatString();
            var4 = var1.readUnsignedShort() & 63;
            this.field2644 |= var4 << 11;
        }

        if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
            this.field2677 = var1.readChatString();
            if (this.field2677.length() == 0) {
                if (this.buttonType == 1) {
                    this.field2677 = "Ok";
                }

                if (this.buttonType == 4) {
                    this.field2677 = "Select";
                }

                if (this.buttonType == 5) {
                    this.field2677 = "Select";
                }

                if (this.buttonType == 6) {
                    this.field2677 = "Continue";
                }
            }
        }

        if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
            this.field2644 |= 4194304;
        }

        if (this.buttonType == 6) {
            this.field2644 |= 1;
        }

    }

    void method3337(Buffer var1) {
        var1.readUnsignedByte();
        this.isIf3 = true;
        this.type = var1.readUnsignedByte();
        this.contentType = var1.readUnsignedShort();
        this.field2623 = this.rawX = var1.readShort();
        this.field2584 = this.field2579 = var1.readShort();
        this.width = var1.readUnsignedShort();
        if (this.type == 9) {
            this.height = var1.readShort();
        } else {
            this.height = var1.readUnsignedShort();
        }

        this.parentId = var1.readUnsignedShort();
        if (this.parentId == 65535) {
            this.parentId = -1;
        } else {
            this.parentId += this.id & -65536;
        }

        this.field2588 = var1.readUnsignedByte() == 1;
        if (this.type == 0) {
            this.field2576 = var1.readUnsignedShort();
            this.field2592 = var1.readUnsignedShort();
        }

        if (this.type == 5) {
            this.spriteId2 = var1.readInt();
            this.field2688 = var1.readUnsignedShort();
            this.field2603 = var1.readUnsignedByte() == 1;
            this.field2582 = var1.readUnsignedByte();
            this.field2604 = var1.readUnsignedByte();
            this.field2667 = var1.readInt();
            this.field2606 = var1.readUnsignedByte() == 1;
            this.spriteFlipV = var1.readUnsignedByte() == 1;
        }

        if (this.type == 6) {
            this.modelType = 1;
            this.modelId = var1.readUnsignedShort();
            if (this.modelId == 65535) {
                this.modelId = -1;
            }

            this.field2577 = var1.readShort();
            this.field2668 = var1.readShort();
            this.modelAngleX = var1.readUnsignedShort();
            this.modelAngleY = var1.readUnsignedShort();
            this.field2614 = var1.readUnsignedShort();
            this.field2679 = var1.readUnsignedShort();
            this.sequenceId = var1.readUnsignedShort();
            if (this.sequenceId == 65535) {
                this.sequenceId = -1;
            }

            this.field2621 = var1.readUnsignedByte() == 1;
        }

        if (this.type == 4) {
            this.fontId = var1.readUnsignedShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.field2633 = var1.readChatString();
            this.field2625 = var1.readUnsignedByte();
            this.field2626 = var1.readUnsignedByte();
            this.field2627 = var1.readUnsignedByte();
            this.field2628 = var1.readUnsignedByte() == 1;
            this.color = var1.readInt();
        }

        if (this.type == 3) {
            this.color = var1.readInt();
            this.field2647 = var1.readUnsignedByte() == 1;
            this.field2582 = var1.readUnsignedByte();
        }

        if (this.type == 9) {
            this.field2599 = var1.readUnsignedByte();
            this.color = var1.readInt();
        }

        this.field2644 = var1.readMedium();
        this.field2636 = var1.readChatString();
        int var2 = var1.readUnsignedByte();
        if (var2 > 0) {
            this.actions = new String[var2];

            for (int var3 = 0; var3 < var2; ++var3) {
                this.actions[var3] = var1.readChatString();
            }
        }

        this.field2567 = var1.readUnsignedByte();
        this.field2640 = var1.readUnsignedByte();
        this.isScrollBar = var1.readUnsignedByte() == 1;
        this.spellActionName = var1.readChatString();
        this.onLoad = this.method3376(var1);
        this.field2649 = this.method3376(var1);
        this.field2651 = this.method3376(var1);
        this.onTargetLeave = this.method3376(var1);
        this.field2660 = this.method3376(var1);
        this.field2656 = this.method3376(var1);
        this.field2630 = this.method3376(var1);
        this.field2620 = this.method3376(var1);
        this.field2658 = this.method3376(var1);
        this.field2635 = this.method3376(var1);
        this.field2650 = this.method3376(var1);
        this.field2645 = this.method3376(var1);
        this.field2629 = this.method3376(var1);
        this.field2659 = this.method3376(var1);
        this.field2648 = this.method3376(var1);
        this.field2657 = this.method3376(var1);
        this.field2653 = this.method3376(var1);
        this.field2661 = this.method3376(var1);
        this.field2654 = this.method3362(var1);
        this.field2605 = this.method3362(var1);
        this.field2687 = this.method3362(var1);
    }

    Object[] method3376(Buffer var1) {
        int var2 = var1.readUnsignedByte();
        if (var2 == 0) {
            return null;
        } else {
            Object[] var3 = new Object[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                int var5 = var1.readUnsignedByte();
                if (var5 == 0) {
                    var3[var4] = new Integer(var1.readInt());
                } else if (var5 == 1) {
                    var3[var4] = var1.readChatString();
                }
            }

            this.hasListener = true;
            return var3;
        }
    }

    int[] method3362(Buffer var1) {
        int var2 = var1.readUnsignedByte();
        if (var2 == 0) {
            return null;
        } else {
            int[] var3 = new int[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                var3[var4] = var1.readInt();
            }

            return var3;
        }
    }

    public void method3340(int var1, int var2) {
        int var3 = this.itemIds[var2];
        this.itemIds[var2] = this.itemIds[var1];
        this.itemIds[var1] = var3;
        var3 = this.itemQuantities[var2];
        this.itemQuantities[var2] = this.itemQuantities[var1];
        this.itemQuantities[var1] = var3;
    }

    public SpritePixels method3341(boolean var1) {
        field2574 = false;
        int var2;
        if (var1) {
            var2 = this.spriteId;
        } else {
            var2 = this.spriteId2;
        }

        if (var2 == -1) {
            return null;
        } else {
            long var3 = ((long) this.field2667 << 40) + ((this.spriteFlipV ? 1L : 0L) << 39) + ((this.field2606 ? 1L : 0L) << 38) + ((long) this.field2604 << 36) + (long) var2;
            SpritePixels var5 = (SpritePixels) Widget_cachedModels.method3474(var3);
            if (var5 != null) {
                return var5;
            } else {
                AbstractArchive var7 = Widget_spritesArchive;
                SpritePixels var6;
                if (!KitDefinition.method796(var7, var2, 0)) {
                    var6 = null;
                } else {
                    var6 = ClientPreferences.method152();
                }

                if (var6 == null) {
                    field2574 = true;
                    return null;
                } else {
                    if (this.field2606) {
                        var6.method1832();
                    }

                    if (this.spriteFlipV) {
                        var6.method1831();
                    }

                    if (this.field2604 > 0) {
                        var6.method1830(this.field2604);
                    }

                    if (this.field2604 >= 1) {
                        var6.method1833(1);
                    }

                    if (this.field2604 >= 2) {
                        var6.method1833(16777215);
                    }

                    if (this.field2667 != 0) {
                        var6.method1834(this.field2667);
                    }

                    Widget_cachedModels.method3473(var6, var3);
                    return var6;
                }
            }
        }
    }

    public Font method3342() {
        field2574 = false;
        if (this.fontId == -1) {
            return null;
        } else {
            Font var1 = (Font) Widget_cachedSpriteMasks.method3474(this.fontId);
            if (var1 != null) {
                return var1;
            } else {
                var1 = class82.method1757(Widget_spritesArchive, JagexCache.Widget_fontsArchive, this.fontId, 0);
                if (var1 != null) {
                    Widget_cachedSpriteMasks.method3473(var1, this.fontId);
                } else {
                    field2574 = true;
                }

                return var1;
            }
        }
    }

    public SpritePixels method3374(int var1) {
        field2574 = false;
        if (var1 >= 0 && var1 < this.inventorySprites.length) {
            int var2 = this.inventorySprites[var1];
            if (var2 == -1) {
                return null;
            } else {
                SpritePixels var3 = (SpritePixels) Widget_cachedModels.method3474(var2);
                if (var3 != null) {
                    return var3;
                } else {
                    AbstractArchive var5 = Widget_spritesArchive;
                    SpritePixels var4;
                    if (!KitDefinition.method796(var5, var2, 0)) {
                        var4 = null;
                    } else {
                        var4 = ClientPreferences.method152();
                    }

                    if (var4 != null) {
                        Widget_cachedModels.method3473(var4, var2);
                    } else {
                        field2574 = true;
                    }

                    return var4;
                }
            }
        } else {
            return null;
        }
    }

    public Model method3351(AnimationDefinition var1, int var2, boolean var3, PlayerComposition var4) {
        field2574 = false;
        int var5;
        int var6;
        if (var3) {
            var5 = this.modelType2;
            var6 = this.modelId2;
        } else {
            var5 = this.modelType;
            var6 = this.modelId;
        }

        if (var5 == 0) {
            return null;
        } else if (var5 == 1 && var6 == -1) {
            return null;
        } else {
            Model var7 = (Model) Widget_cachedFonts.method3474(var6 + (var5 << 16));
            if (var7 == null) {
                ModelData var8;
                if (var5 == 1) {
                    var8 = ModelData.method2222(class179.Widget_modelsArchive, var6, 0);
                    if (var8 == null) {
                        field2574 = true;
                        return null;
                    }

                    var7 = var8.method2282(64, 768, -50, -10, -50);
                }

                if (var5 == 2) {
                    var8 = class22.method247(var6).method632();
                    if (var8 == null) {
                        field2574 = true;
                        return null;
                    }

                    var7 = var8.method2282(64, 768, -50, -10, -50);
                }

                if (var5 == 3) {
                    if (var4 == null) {
                        return null;
                    }

                    var8 = var4.method3408();
                    if (var8 == null) {
                        field2574 = true;
                        return null;
                    }

                    var7 = var8.method2282(64, 768, -50, -10, -50);
                }

                if (var5 == 4) {
                    ItemComposition var9 = class27.method571(var6);
                    var8 = var9.method876(10);
                    if (var8 == null) {
                        field2574 = true;
                        return null;
                    }

                    var7 = var8.method2282(var9.field1023 + 64, var9.field1001 + 768, -50, -10, -50);
                }

                Widget_cachedFonts.method3473(var7, var6 + (var5 << 16));
            }

            if (var1 != null) {
                var7 = var1.method729(var7, var2);
            }

            return var7;
        }
    }

    public void method3339(int var1, String var2) {
        if (this.actions == null || this.actions.length <= var1) {
            String[] var3 = new String[var1 + 1];
            if (this.actions != null) {
                for (int var4 = 0; var4 < this.actions.length; ++var4) {
                    var3[var4] = this.actions[var4];
                }
            }

            this.actions = var3;
        }

        this.actions[var1] = var2;
    }
}
