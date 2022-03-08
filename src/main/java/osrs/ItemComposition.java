package osrs;

public class ItemComposition extends DualNode {
    static class7[] field1026;
    public static AbstractArchive ItemDefinition_archive;
    public static AbstractArchive ItemDefinition_modelArchive;
    public static boolean ItemDefinition_inMembersWorld;
    public static EvictingDualNodeHashTable ItemDefinition_cached = new EvictingDualNodeHashTable(64);
    public static EvictingDualNodeHashTable ItemDefinition_cachedModels = new EvictingDualNodeHashTable(50);
    public static EvictingDualNodeHashTable ItemDefinition_cachedSprites = new EvictingDualNodeHashTable(100);
    public int id;
    int model;
    public String name = "null";
    short[] recolorFrom;
    short[] recolorTo;
    short[] retextureFrom;
    short[] retextureTo;
    public int zoom2d = 2000;
    public int xan2d = 0;
    public int yan2d = 0;
    public int zan2d = 0;
    public int offsetX2d = 0;
    public int offsetY2d = 0;
    public int isStackable = 0;
    public int price = 1;
    public boolean isMembersOnly = false;
    public String[] groundActions = new String[]{null, null, "Take", null, null};
    public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
    int maleModel = -1;
    int field991 = -1;
    int maleOffset = 0;
    int femaleModel = -1;
    int femaleModel1 = -1;
    int femaleOffset = 0;
    int field984 = -1;
    int femaleModel2 = -1;
    int maleHeadModel = -1;
    int field1013 = -1;
    int femaleHeadModel = -1;
    int femaleHeadModel2 = -1;
    int[] countobj;
    int[] countco;
    public int note = -1;
    public int noteTemplate = -1;
    int resizeX = 128;
    int resizeY = 128;
    int resizeZ = 128;
    public int field1023 = 0;
    public int field1001 = 0;
    public int team = 0;

    void method855() {
    }

    void method856(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method857(var1, var2);
        }
    }

    void method857(Buffer var1, int var2) {
        if (var2 == 1) {
            this.model = var1.readUnsignedShort();
        } else if (var2 == 2) {
            this.name = var1.readChatString();
        } else if (var2 == 4) {
            this.zoom2d = var1.readUnsignedShort();
        } else if (var2 == 5) {
            this.xan2d = var1.readUnsignedShort();
        } else if (var2 == 6) {
            this.yan2d = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.offsetX2d = var1.readUnsignedShort();
            if (this.offsetX2d > 32767) {
                this.offsetX2d -= 65536;
            }
        } else if (var2 == 8) {
            this.offsetY2d = var1.readUnsignedShort();
            if (this.offsetY2d > 32767) {
                this.offsetY2d -= 65536;
            }
        } else if (var2 == 11) {
            this.isStackable = 1;
        } else if (var2 == 12) {
            this.price = var1.readInt();
        } else if (var2 == 16) {
            this.isMembersOnly = true;
        } else if (var2 == 23) {
            this.maleModel = var1.readUnsignedShort();
            this.maleOffset = var1.readUnsignedByte();
        } else if (var2 == 24) {
            this.field991 = var1.readUnsignedShort();
        } else if (var2 == 25) {
            this.femaleModel = var1.readUnsignedShort();
            this.femaleOffset = var1.readUnsignedByte();
        } else if (var2 == 26) {
            this.femaleModel1 = var1.readUnsignedShort();
        } else if (var2 >= 30 && var2 < 35) {
            this.groundActions[var2 - 30] = var1.readChatString();
            if (this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
                this.groundActions[var2 - 30] = null;
            }
        } else if (var2 >= 35 && var2 < 40) {
            this.inventoryActions[var2 - 35] = var1.readChatString();
        } else {
            int var3;
            int var4;
            if (var2 == 40) {
                var3 = var1.readUnsignedByte();
                this.recolorFrom = new short[var3];
                this.recolorTo = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.recolorFrom[var4] = (short) var1.readUnsignedShort();
                    this.recolorTo[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUnsignedByte();
                this.retextureFrom = new short[var3];
                this.retextureTo = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.retextureFrom[var4] = (short) var1.readUnsignedShort();
                    this.retextureTo[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 == 78) {
                this.field984 = var1.readUnsignedShort();
            } else if (var2 == 79) {
                this.femaleModel2 = var1.readUnsignedShort();
            } else if (var2 == 90) {
                this.maleHeadModel = var1.readUnsignedShort();
            } else if (var2 == 91) {
                this.femaleHeadModel = var1.readUnsignedShort();
            } else if (var2 == 92) {
                this.field1013 = var1.readUnsignedShort();
            } else if (var2 == 93) {
                this.femaleHeadModel2 = var1.readUnsignedShort();
            } else if (var2 == 95) {
                this.zan2d = var1.readUnsignedShort();
            } else if (var2 == 97) {
                this.note = var1.readUnsignedShort();
            } else if (var2 == 98) {
                this.noteTemplate = var1.readUnsignedShort();
            } else if (var2 >= 100 && var2 < 110) {
                if (this.countobj == null) {
                    this.countobj = new int[10];
                    this.countco = new int[10];
                }

                this.countobj[var2 - 100] = var1.readUnsignedShort();
                this.countco[var2 - 100] = var1.readUnsignedShort();
            } else if (var2 == 110) {
                this.resizeX = var1.readUnsignedShort();
            } else if (var2 == 111) {
                this.resizeY = var1.readUnsignedShort();
            } else if (var2 == 112) {
                this.resizeZ = var1.readUnsignedShort();
            } else if (var2 == 113) {
                this.field1023 = var1.readByte();
            } else if (var2 == 114) {
                this.field1001 = var1.readByte() * 5;
            } else if (var2 == 115) {
                this.team = var1.readUnsignedByte();
            }
        }

    }

    void method892(ItemComposition var1, ItemComposition var2) {
        this.model = var1.model;
        this.zoom2d = var1.zoom2d;
        this.xan2d = var1.xan2d;
        this.yan2d = var1.yan2d;
        this.zan2d = var1.zan2d;
        this.offsetX2d = var1.offsetX2d;
        this.offsetY2d = var1.offsetY2d;
        this.recolorFrom = var1.recolorFrom;
        this.recolorTo = var1.recolorTo;
        this.retextureFrom = var1.retextureFrom;
        this.retextureTo = var1.retextureTo;
        this.name = var2.name;
        this.isMembersOnly = var2.isMembersOnly;
        this.price = var2.price;
        this.isStackable = 1;
    }

    public final ModelData method876(int var1) {
        int var3;
        if (this.countobj != null && var1 > 1) {
            int var2 = -1;

            for (var3 = 0; var3 < 10; ++var3) {
                if (var1 >= this.countco[var3] && this.countco[var3] != 0) {
                    var2 = this.countobj[var3];
                }
            }

            if (var2 != -1) {
                return class27.method571(var2).method876(1);
            }
        }

        ModelData var4 = ModelData.method2222(ItemDefinition_modelArchive, this.model, 0);
        if (var4 == null) {
            return null;
        } else {
            if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
                var4.method2287(this.resizeX, this.resizeY, this.resizeZ);
            }

            if (this.recolorFrom != null) {
                for (var3 = 0; var3 < this.recolorFrom.length; ++var3) {
                    var4.method2234(this.recolorFrom[var3], this.recolorTo[var3]);
                }
            }

            if (this.retextureFrom != null) {
                for (var3 = 0; var3 < this.retextureFrom.length; ++var3) {
                    var4.method2236(this.retextureFrom[var3], this.retextureTo[var3]);
                }
            }

            return var4;
        }
    }

    public final Model method886(int var1) {
        if (this.countobj != null && var1 > 1) {
            int var2 = -1;

            for (int var3 = 0; var3 < 10; ++var3) {
                if (var1 >= this.countco[var3] && this.countco[var3] != 0) {
                    var2 = this.countobj[var3];
                }
            }

            if (var2 != -1) {
                return class27.method571(var2).method886(1);
            }
        }

        Model var5 = (Model) ItemDefinition_cachedModels.method3474(this.id);
        if (var5 != null) {
            return var5;
        } else {
            ModelData var6 = ModelData.method2222(ItemDefinition_modelArchive, this.model, 0);
            if (var6 == null) {
                return null;
            } else {
                if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
                    var6.method2287(this.resizeX, this.resizeY, this.resizeZ);
                }

                int var4;
                if (this.recolorFrom != null) {
                    for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
                        var6.method2234(this.recolorFrom[var4], this.recolorTo[var4]);
                    }
                }

                if (this.retextureFrom != null) {
                    for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
                        var6.method2236(this.retextureFrom[var4], this.retextureTo[var4]);
                    }
                }

                var5 = var6.method2282(this.field1023 + 64, this.field1001 + 768, -50, -10, -50);
                var5.isSingleTile = true;
                ItemDefinition_cachedModels.method3473(var5, this.id);
                return var5;
            }
        }
    }

    public ItemComposition method861(int var1) {
        if (this.countobj != null && var1 > 1) {
            int var2 = -1;

            for (int var3 = 0; var3 < 10; ++var3) {
                if (var1 >= this.countco[var3] && this.countco[var3] != 0) {
                    var2 = this.countobj[var3];
                }
            }

            if (var2 != -1) {
                return class27.method571(var2);
            }
        }

        return this;
    }

    public final boolean method862(boolean var1) {
        int var2 = this.maleModel;
        int var3 = this.field991;
        int var4 = this.field984;
        if (var1) {
            var2 = this.femaleModel;
            var3 = this.femaleModel1;
            var4 = this.femaleModel2;
        }

        if (var2 == -1) {
            return true;
        } else {
            boolean var5 = ItemDefinition_modelArchive.method3206(var2, 0);

            if (var3 != -1 && !ItemDefinition_modelArchive.method3206(var3, 0)) {
                var5 = false;
            }

            if (var4 != -1 && !ItemDefinition_modelArchive.method3206(var4, 0)) {
                var5 = false;
            }

            return var5;
        }
    }

    public final ModelData method860(boolean var1) {
        int var2 = this.maleModel;
        int var3 = this.field991;
        int var4 = this.field984;
        if (var1) {
            var2 = this.femaleModel;
            var3 = this.femaleModel1;
            var4 = this.femaleModel2;
        }

        if (var2 == -1) {
            return null;
        } else {
            ModelData var5 = ModelData.method2222(ItemDefinition_modelArchive, var2, 0);
            if (var3 != -1) {
                ModelData var6 = ModelData.method2222(ItemDefinition_modelArchive, var3, 0);
                if (var4 != -1) {
                    ModelData var7 = ModelData.method2222(ItemDefinition_modelArchive, var4, 0);
                    ModelData[] var8 = new ModelData[]{var5, var6, var7};
                    var5 = new ModelData(var8, 3);
                } else {
                    ModelData[] var10 = new ModelData[]{var5, var6};
                    var5 = new ModelData(var10, 2);
                }
            }

            if (!var1 && this.maleOffset != 0) {
                var5.method2223(0, this.maleOffset, 0);
            }

            if (var1 && this.femaleOffset != 0) {
                var5.method2223(0, this.femaleOffset, 0);
            }

            int var9;
            if (this.recolorFrom != null) {
                for (var9 = 0; var9 < this.recolorFrom.length; ++var9) {
                    var5.method2234(this.recolorFrom[var9], this.recolorTo[var9]);
                }
            }

            if (this.retextureFrom != null) {
                for (var9 = 0; var9 < this.retextureFrom.length; ++var9) {
                    var5.method2236(this.retextureFrom[var9], this.retextureTo[var9]);
                }
            }

            return var5;
        }
    }

    public final boolean method864(boolean var1) {
        int var2 = this.maleHeadModel;
        int var3 = this.field1013;
        if (var1) {
            var2 = this.femaleHeadModel;
            var3 = this.femaleHeadModel2;
        }

        if (var2 == -1) {
            return true;
        } else {
            boolean var4 = ItemDefinition_modelArchive.method3206(var2, 0);

            if (var3 != -1 && !ItemDefinition_modelArchive.method3206(var3, 0)) {
                var4 = false;
            }

            return var4;
        }
    }

    public final ModelData method865(boolean var1) {
        int var2 = this.maleHeadModel;
        int var3 = this.field1013;
        if (var1) {
            var2 = this.femaleHeadModel;
            var3 = this.femaleHeadModel2;
        }

        if (var2 == -1) {
            return null;
        } else {
            ModelData var4 = ModelData.method2222(ItemDefinition_modelArchive, var2, 0);
            if (var3 != -1) {
                ModelData var5 = ModelData.method2222(ItemDefinition_modelArchive, var3, 0);
                ModelData[] var6 = new ModelData[]{var4, var5};
                var4 = new ModelData(var6, 2);
            }

            int var7;
            if (this.recolorFrom != null) {
                for (var7 = 0; var7 < this.recolorFrom.length; ++var7) {
                    var4.method2234(this.recolorFrom[var7], this.recolorTo[var7]);
                }
            }

            if (this.retextureFrom != null) {
                for (var7 = 0; var7 < this.retextureFrom.length; ++var7) {
                    var4.method2236(this.retextureFrom[var7], this.retextureTo[var7]);
                }
            }

            return var4;
        }
    }

    public static void method901(AbstractArchive var0) {
        FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var0;
    }

    static final void method900(PcmStream var0) {
        var0.active = false;
        if (var0.sound != null) {
            var0.sound.position = 0;
        }

        for (PcmStream var1 = var0.vmethod3061(); var1 != null; var1 = var0.vmethod3052()) {
            method900(var1);
        }

    }
}
