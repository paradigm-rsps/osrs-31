package osrs;

import osrs.cache.Definitions;

public class ObjectDefinition extends DualNode {
    static boolean ObjectDefinition_isLowDetail = false;
    public static AbstractArchive ObjectDefinition_archive;
    public static EvictingDualNodeHashTable ObjectDefinition_cached = new EvictingDualNodeHashTable(64);
    public static EvictingDualNodeHashTable ObjectDefinition_cachedModelData = new EvictingDualNodeHashTable(500);
    public static EvictingDualNodeHashTable ObjectDefinition_cachedEntities = new EvictingDualNodeHashTable(30);
    public static EvictingDualNodeHashTable ObjectDefinition_cachedModels = new EvictingDualNodeHashTable(30);
    static ModelData[] field826 = new ModelData[4];
    public int id;
    int[] modelIds;
    int[] models;
    public String name = "null";
    short[] recolorFrom;
    short[] recolorTo;
    short[] retextureFrom;
    short[] retextureTo;
    public int sizeX = 1;
    public int sizeY = 1;
    public int interactType = 2;
    public boolean boolean1 = true;
    public int int1 = -1;
    int clipType = -1;
    boolean nonFlatShading = false;
    public boolean modelClipped = false;
    public int animationId = -1;
    public int int2 = 16;
    int ambient = 0;
    int contrast = 0;
    public String[] actions = new String[5];
    public int field848 = -1;
    public int mapSceneId = -1;
    boolean isRotated = false;
    public boolean clipped = true;
    int modelSizeX = 128;
    int modelHeight = 128;
    int modelSizeY = 128;
    int offsetX = 0;
    int offsetHeight = 0;
    int offsetY = 0;
    public int field858 = 0;
    public boolean boolean2 = false;
    public boolean isSolid = false;
    public int int3 = -1;
    public int[] transforms;
    int transformVarbit = -1;
    int transformVarp = -1;
    public int ambientSoundId = -1;
    public int field841 = 0;
    public int int5 = 0;
    public int int7 = 0;
    public int[] soundEffectIds;

    public void method660() {
        if (this.int1 == -1) {
            this.int1 = 0;
            if (this.modelIds != null && (this.models == null || this.models[0] == 10)) {
                this.int1 = 1;
            }

            for (int var1 = 0; var1 < 5; ++var1) {
                if (this.actions[var1] != null) {
                    this.int1 = 1;
                }
            }
        }

        if (this.int3 == -1) {
            this.int3 = this.interactType != 0 ? 1 : 0;
        }

    }

    public void method659(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method680(var1, var2);
        }
    }

    void method680(Buffer var1, int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedByte();
            if (var3 > 0) {
                if (this.modelIds != null && !ObjectDefinition_isLowDetail) {
                    var1.offset += 3 * var3;
                } else {
                    this.models = new int[var3];
                    this.modelIds = new int[var3];

                    for (var4 = 0; var4 < var3; ++var4) {
                        this.modelIds[var4] = var1.readUnsignedShort();
                        this.models[var4] = var1.readUnsignedByte();
                    }
                }
            }
        } else if (var2 == 2) {
            this.name = var1.readChatString();
        } else if (var2 == 5) {
            var3 = var1.readUnsignedByte();
            if (var3 > 0) {
                if (this.modelIds != null && !ObjectDefinition_isLowDetail) {
                    var1.offset += var3 * 2;
                } else {
                    this.models = null;
                    this.modelIds = new int[var3];

                    for (var4 = 0; var4 < var3; ++var4) {
                        this.modelIds[var4] = var1.readUnsignedShort();
                    }
                }
            }
        } else if (var2 == 14) {
            this.sizeX = var1.readUnsignedByte();
        } else if (var2 == 15) {
            this.sizeY = var1.readUnsignedByte();
        } else if (var2 == 17) {
            this.interactType = 0;
            this.boolean1 = false;
        } else if (var2 == 18) {
            this.boolean1 = false;
        } else if (var2 == 19) {
            this.int1 = var1.readUnsignedByte();
        } else if (var2 == 21) {
            this.clipType = 0;
        } else if (var2 == 22) {
            this.nonFlatShading = true;
        } else if (var2 == 23) {
            this.modelClipped = true;
        } else if (var2 == 24) {
            this.animationId = var1.readUnsignedShort();
            if (this.animationId == 65535) {
                this.animationId = -1;
            }
        } else if (var2 == 27) {
            this.interactType = 1;
        } else if (var2 == 28) {
            this.int2 = var1.readUnsignedByte();
        } else if (var2 == 29) {
            this.ambient = var1.readByte();
        } else if (var2 == 39) {
            this.contrast = var1.readByte() * 25;
        } else if (var2 >= 30 && var2 < 35) {
            this.actions[var2 - 30] = var1.readChatString();
            if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
                this.actions[var2 - 30] = null;
            }
        } else if (var2 == 40) {
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
        } else if (var2 == 60) {
            this.field848 = var1.readUnsignedShort();
        } else if (var2 == 62) {
            this.isRotated = true;
        } else if (var2 == 64) {
            this.clipped = false;
        } else if (var2 == 65) {
            this.modelSizeX = var1.readUnsignedShort();
        } else if (var2 == 66) {
            this.modelHeight = var1.readUnsignedShort();
        } else if (var2 == 67) {
            this.modelSizeY = var1.readUnsignedShort();
        } else if (var2 == 68) {
            this.mapSceneId = var1.readUnsignedShort();
        } else if (var2 == 69) {
            this.field858 = var1.readUnsignedByte();
        } else if (var2 == 70) {
            this.offsetX = var1.readShort();
        } else if (var2 == 71) {
            this.offsetHeight = var1.readShort();
        } else if (var2 == 72) {
            this.offsetY = var1.readShort();
        } else if (var2 == 73) {
            this.boolean2 = true;
        } else if (var2 == 74) {
            this.isSolid = true;
        } else if (var2 == 75) {
            this.int3 = var1.readUnsignedByte();
        } else if (var2 == 77) {
            this.transformVarbit = var1.readUnsignedShort();
            if (this.transformVarbit == 65535) {
                this.transformVarbit = -1;
            }

            this.transformVarp = var1.readUnsignedShort();
            if (this.transformVarp == 65535) {
                this.transformVarp = -1;
            }

            var3 = var1.readUnsignedByte();
            this.transforms = new int[var3 + 1];

            for (var4 = 0; var4 <= var3; ++var4) {
                this.transforms[var4] = var1.readUnsignedShort();
                if (this.transforms[var4] == 65535) {
                    this.transforms[var4] = -1;
                }
            }
        } else if (var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field841 = var1.readUnsignedByte();
        } else if (var2 == 79) {
            this.int5 = var1.readUnsignedShort();
            this.int7 = var1.readUnsignedShort();
            this.field841 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.soundEffectIds = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.soundEffectIds[var4] = var1.readUnsignedShort();
            }
        } else if (var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
        }

    }

    public final boolean method661(int var1) {
        if (this.models != null) {
            for (int var4 = 0; var4 < this.models.length; ++var4) {
                if (this.models[var4] == var1) {
                    return ModelData0.ObjectDefinition_modelsArchive.method3206(this.modelIds[var4] & '\uffff', 0);
                }
            }

            return true;
        } else if (this.modelIds == null) {
            return true;
        } else if (var1 != 10) {
            return true;
        } else {
            boolean var2 = true;

            for (int var3 = 0; var3 < this.modelIds.length; ++var3) {
                var2 &= ModelData0.ObjectDefinition_modelsArchive.method3206(this.modelIds[var3] & '\uffff', 0);
            }

            return var2;
        }
    }

    public final boolean method662() {
        if (this.modelIds == null) {
            return true;
        } else {
            boolean var1 = true;

            for (int var2 = 0; var2 < this.modelIds.length; ++var2) {
                var1 &= ModelData0.ObjectDefinition_modelsArchive.method3206(this.modelIds[var2] & '\uffff', 0);
            }

            return var1;
        }
    }

    public final Renderable method669(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
        long var7;
        if (this.models == null) {
            var7 = var2 + (this.id << 10);
        } else {
            var7 = var2 + (var1 << 3) + (this.id << 10);
        }

        Object var9 = ObjectDefinition_cachedEntities.method3474(var7);
        if (var9 == null) {
            ModelData var10 = this.method675(var1, var2);
            if (var10 == null) {
                return null;
            }

            if (!this.nonFlatShading) {
                var9 = var10.method2282(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            } else {
                var10.ambient = (short) (this.ambient + 64);
                var10.contrast = (short) (this.contrast + 768);
                var10.method2271();
                var9 = var10;
            }

            ObjectDefinition_cachedEntities.method3473((DualNode) var9, var7);
        }

        if (this.nonFlatShading) {
            var9 = ((ModelData) var9).method2217();
        }

        if (this.clipType >= 0) {
            if (var9 instanceof Model) {
                var9 = ((Model) var9).method2423(var3, var4, var5, var6, true, this.clipType);
            } else if (var9 instanceof ModelData) {
                var9 = ((ModelData) var9).method2218(var3, var4, var5, var6, true, this.clipType);
            }
        }

        return (Renderable) var9;
    }

    public final Model getModel(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
        long var7;
        if (this.models == null) {
            var7 = var2 + (this.id << 10);
        } else {
            var7 = var2 + (var1 << 3) + (this.id << 10);
        }

        Model var9 = (Model) ObjectDefinition_cachedModels.method3474(var7);
        if (var9 == null) {
            ModelData var10 = this.method675(var1, var2);
            if (var10 == null) {
                return null;
            }

            var9 = var10.method2282(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            ObjectDefinition_cachedModels.method3473(var9, var7);
        }

        if (this.clipType >= 0) {
            var9 = var9.method2423(var3, var4, var5, var6, true, this.clipType);
        }

        return var9;
    }

    public final Model method667(int var1, int var2, int[][] var3, int var4, int var5, int var6, AnimationDefinition var7, int var8) {
        long var9;
        if (this.models == null) {
            var9 = var2 + (this.id << 10);
        } else {
            var9 = var2 + (var1 << 3) + (this.id << 10);
        }

        Model var11 = (Model) ObjectDefinition_cachedModels.method3474(var9);
        if (var11 == null) {
            ModelData var12 = this.method675(var1, var2);
            if (var12 == null) {
                return null;
            }

            var11 = var12.method2282(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            ObjectDefinition_cachedModels.method3473(var11, var9);
        }

        if (var7 == null && this.clipType == -1) {
            return var11;
        } else {
            if (var7 != null) {
                var11 = var7.method726(var11, var8, var2);
            } else {
                var11 = var11.method2424(true);
            }

            if (this.clipType >= 0) {
                var11 = var11.method2423(var3, var4, var5, var6, false, this.clipType);
            }

            return var11;
        }
    }

    final ModelData method675(int var1, int var2) {
        ModelData var3 = null;
        boolean var4;
        int var5;
        int var7;
        if (this.models == null) {
            if (var1 != 10) {
                return null;
            }

            if (this.modelIds == null) {
                return null;
            }

            var4 = this.isRotated;
            if (var1 == 2 && var2 > 3) {
                var4 = !var4;
            }

            var5 = this.modelIds.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                var7 = this.modelIds[var6];
                if (var4) {
                    var7 += 65536;
                }

                var3 = (ModelData) ObjectDefinition_cachedModelData.method3474(var7);
                if (var3 == null) {
                    var3 = ModelData.method2222(ModelData0.ObjectDefinition_modelsArchive, var7 & '\uffff', 0);
                    if (var3 == null) {
                        return null;
                    }

                    if (var4) {
                        var3.method2272();
                    }

                    ObjectDefinition_cachedModelData.method3473(var3, var7);
                }

                if (var5 > 1) {
                    field826[var6] = var3;
                }
            }

            if (var5 > 1) {
                var3 = new ModelData(field826, var5);
            }
        } else {
            int var9 = -1;

            for (var5 = 0; var5 < this.models.length; ++var5) {
                if (this.models[var5] == var1) {
                    var9 = var5;
                    break;
                }
            }

            if (var9 == -1) {
                return null;
            }

            var5 = this.modelIds[var9];
            boolean var10 = this.isRotated ^ var2 > 3;
            if (var10) {
                var5 += 65536;
            }

            var3 = (ModelData) ObjectDefinition_cachedModelData.method3474(var5);
            if (var3 == null) {
                var3 = ModelData.method2222(ModelData0.ObjectDefinition_modelsArchive, var5 & '\uffff', 0);
                if (var3 == null) {
                    return null;
                }

                if (var10) {
                    var3.method2272();
                }

                ObjectDefinition_cachedModelData.method3473(var3, var5);
            }
        }

        var4 = this.modelSizeX != 128 || this.modelHeight != 128 || this.modelSizeY != 128;

        boolean var11;
        var11 = this.offsetX != 0 || this.offsetHeight != 0 || this.offsetY != 0;

        ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.recolorFrom, null == this.retextureFrom, true);
        if (var1 == 4 && var2 > 3) {
            var8.method2228(256);
            var8.method2223(45, 0, -45);
        }

        var2 &= 3;
        if (var2 == 1) {
            var8.method2219();
        } else if (var2 == 2) {
            var8.method2220();
        } else if (var2 == 3) {
            var8.method2221();
        }

        if (this.recolorFrom != null) {
            for (var7 = 0; var7 < this.recolorFrom.length; ++var7) {
                var8.method2234(this.recolorFrom[var7], this.recolorTo[var7]);
            }
        }

        if (this.retextureFrom != null) {
            for (var7 = 0; var7 < this.retextureFrom.length; ++var7) {
                var8.method2236(this.retextureFrom[var7], this.retextureTo[var7]);
            }
        }

        if (var4) {
            var8.method2287(this.modelSizeX, this.modelHeight, this.modelSizeY);
        }

        if (var11) {
            var8.method2223(this.offsetX, this.offsetHeight, this.offsetY);
        }

        return var8;
    }

    public final ObjectDefinition method673() {
        int var1 = -1;
        if (this.transformVarbit != -1) {
            var1 = class133.method2863(this.transformVarbit);
        } else if (this.transformVarp != -1) {
            var1 = Varps.Varps_main[this.transformVarp];
        }

        return var1 >= 0 && var1 < this.transforms.length && this.transforms[var1] != -1 ? Definitions.getObject(this.transforms[var1]) : null;
    }

    public boolean method668() {
        if (this.transforms == null) {
            return this.ambientSoundId != -1 || this.soundEffectIds != null;
        } else {
            for (int var1 = 0; var1 < this.transforms.length; ++var1) {
                if (this.transforms[var1] != -1) {
                    ObjectDefinition var2 = Definitions.getObject(this.transforms[var1]);
                    if (var2.ambientSoundId != -1 || var2.soundEffectIds != null) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static StudioGame[] method672() {
        return new StudioGame[]{StudioGame.game4, StudioGame.game5, StudioGame.runescape, StudioGame.oldscape, StudioGame.game3, StudioGame.stellardawn};
    }

    static final void method698(Widget[] var0, int var1) {
        for (int var2 = 0; var2 < var0.length; ++var2) {
            Widget var3 = var0[var2];
            if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !Archive.method3322(var3))) {
                int var5;
                if (var3.type == 0) {
                    if (!var3.isIf3 && Archive.method3322(var3) && var3 != Tiles.mousedOverWidgetIf1) {
                        continue;
                    }

                    method698(var0, var3.id);
                    if (var3.children != null) {
                        method698(var3.children, var3.id);
                    }

                    InterfaceParent var4 = (InterfaceParent) Client.interfaceParents.method3512(var3.id);
                    if (var4 != null) {
                        var5 = var4.group;
                        if (EnumComposition.method852(var5)) {
                            method698(Widget.Widget_interfaceComponents[var5], -1);
                        }
                    }
                }

                if (var3.type == 6) {
                    if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
                        boolean var7 = class40.method916(var3);
                        if (var7) {
                            var5 = var3.sequenceId2;
                        } else {
                            var5 = var3.sequenceId;
                        }

                        if (var5 != -1) {
                            AnimationDefinition var6 = Definitions.getAnimation(var5);

                            for (var3.modelFrameCycle += Client.field525; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; class82.invalidateWidget(var3)) {
                                var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
                                ++var3.modelFrame;
                                if (var3.modelFrame >= var6.frameIds.length) {
                                    var3.modelFrame -= var6.frameCount;
                                    if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
                                        var3.modelFrame = 0;
                                    }
                                }
                            }
                        }
                    }

                    if (var3.field2601 != 0 && !var3.isIf3) {
                        int var8 = var3.field2601 >> 16;
                        var5 = var3.field2601 << 16 >> 16;
                        var8 *= Client.field525;
                        var5 *= Client.field525;
                        var3.modelAngleX = var8 + var3.modelAngleX & 2047;
                        var3.modelAngleY = var5 + var3.modelAngleY & 2047;
                        class82.invalidateWidget(var3);
                    }
                }
            }
        }

    }
}
