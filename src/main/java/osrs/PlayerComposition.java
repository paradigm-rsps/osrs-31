package osrs;

public class PlayerComposition {
    public static short[] field2718;
    public static short[] field2716;
    static final int[] equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
    public static EvictingDualNodeHashTable Widget_cachedSprites = new EvictingDualNodeHashTable(260);
    int[] styles;
    int[] colors;
    public boolean isFemale;
    int npcTransformId;
    long hash;
    long field2712;

    public void setPlayerAppearance(int[] styles, int[] colors, boolean isMale, int transmodNpcId) {
        if (styles == null) {
            styles = new int[12];

            for (int i = 0; i < 7; ++i) {
                for (int j = 0; j < KitDefinition.KitDefinition_fileCount; ++j) {
                    KitDefinition style = class65.readAppearanceStyle(j);
                    if (style != null && !style.nonSelectable && style.bodypartID == i + (isMale ? 7 : 0)) {
                        styles[equipmentIndices[i]] = j + 256;
                        break;
                    }
                }
            }
        }

        this.styles = styles;
        this.colors = colors;
        this.isFemale = isMale;
        this.npcTransformId = transmodNpcId;
        this.method3406();
    }

    public void method3421(int var1, boolean var2) {
        if (var1 != 1 || !this.isFemale) {
            int var3 = this.styles[equipmentIndices[var1]];
            if (var3 != 0) {
                var3 -= 256;

                KitDefinition var4;
                do {
                    if (!var2) {
                        --var3;
                        if (var3 < 0) {
                            var3 = KitDefinition.KitDefinition_fileCount - 1;
                        }
                    } else {
                        ++var3;
                        if (var3 >= KitDefinition.KitDefinition_fileCount) {
                            var3 = 0;
                        }
                    }

                    var4 = class65.readAppearanceStyle(var3);
                } while (var4 == null || var4.nonSelectable || (this.isFemale ? 7 : 0) + var1 != var4.bodypartID);

                this.styles[equipmentIndices[var1]] = var3 + 256;
                this.method3406();
            }
        }
    }

    public void method3403(int var1, boolean var2) {
        int var3 = this.colors[var1];
        if (!var2) {
            --var3;
            if (var3 < 0) {
                var3 = Skeleton.field1792[var1].length - 1;
            }
        } else {
            ++var3;
            if (var3 >= Skeleton.field1792[var1].length) {
                var3 = 0;
            }
        }

        this.colors[var1] = var3;
        this.method3406();
    }

    public void method3404(boolean isMale) {
        if (this.isFemale != isMale) {
            this.setPlayerAppearance(null, this.colors, isMale, -1);
        }
    }

    public void method3405(Buffer var1) {
        var1.writeByte(this.isFemale ? 1 : 0);

        int var2;
        for (var2 = 0; var2 < 7; ++var2) {
            int var3 = this.styles[equipmentIndices[var2]];
            if (var3 == 0) {
                var1.writeByte(-1);
            } else {
                var1.writeByte(var3 - 256);
            }
        }

        for (var2 = 0; var2 < 5; ++var2) {
            var1.writeByte(this.colors[var2]);
        }

    }

    void method3406() {
        long var1 = this.hash;
        int var3 = this.styles[5];
        int var4 = this.styles[9];
        this.styles[5] = var4;
        this.styles[9] = var3;
        this.hash = 0L;

        int var5;
        for (var5 = 0; var5 < 12; ++var5) {
            this.hash <<= 4;
            if (this.styles[var5] >= 256) {
                this.hash += this.styles[var5] - 256;
            }
        }

        if (this.styles[0] >= 256) {
            this.hash += this.styles[0] - 256 >> 4;
        }

        if (this.styles[1] >= 256) {
            this.hash += this.styles[1] - 256 >> 8;
        }

        for (var5 = 0; var5 < 5; ++var5) {
            this.hash <<= 3;
            this.hash += this.colors[var5];
        }

        this.hash <<= 1;
        this.hash += this.isFemale ? 1 : 0;
        this.styles[5] = var3;
        this.styles[9] = var4;
        if (0L != var1 && var1 != this.hash) {
            Widget_cachedSprites.method3475(var1);
        }

    }

    public Model method3407(AnimationDefinition var1, int var2, AnimationDefinition var3, int var4) {
        if (this.npcTransformId != -1) {
            return class22.method247(this.npcTransformId).method643(var1, var2, var3, var4);
        } else {
            long var5 = this.hash;
            int[] var7 = this.styles;
            if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
                var7 = new int[12];

                for (int var8 = 0; var8 < 12; ++var8) {
                    var7[var8] = this.styles[var8];
                }

                if (var1.shield >= 0) {
                    var5 += var1.shield - this.styles[5] << 40;
                    var7[5] = var1.shield;
                }

                if (var1.weapon >= 0) {
                    var5 += var1.weapon - this.styles[3] << 48;
                    var7[3] = var1.weapon;
                }
            }

            Model var15 = (Model) Widget_cachedSprites.method3474(var5);
            if (var15 == null) {
                boolean var9 = false;

                int var11;
                for (int var10 = 0; var10 < 12; ++var10) {
                    var11 = var7[var10];
                    if (var11 >= 256 && var11 < 512 && !class65.readAppearanceStyle(var11 - 256).method779()) {
                        var9 = true;
                    }

                    if (var11 >= 512 && !class27.method571(var11 - 512).method862(this.isFemale)) {
                        var9 = true;
                    }
                }

                if (var9) {
                    if (this.field2712 != -1L) {
                        var15 = (Model) Widget_cachedSprites.method3474(this.field2712);
                    }

                    if (var15 == null) {
                        return null;
                    }
                }

                if (var15 == null) {
                    ModelData[] var16 = new ModelData[12];
                    var11 = 0;

                    int var13;
                    for (int var12 = 0; var12 < 12; ++var12) {
                        var13 = var7[var12];
                        ModelData var14;
                        if (var13 >= 256 && var13 < 512) {
                            var14 = class65.readAppearanceStyle(var13 - 256).method787();
                            if (var14 != null) {
                                var16[var11++] = var14;
                            }
                        }

                        if (var13 >= 512) {
                            var14 = class27.method571(var13 - 512).method860(this.isFemale);
                            if (var14 != null) {
                                var16[var11++] = var14;
                            }
                        }
                    }

                    ModelData var17 = new ModelData(var16, var11);

                    for (var13 = 0; var13 < 5; ++var13) {
                        if (this.colors[var13] < Skeleton.field1792[var13].length) {
                            var17.method2234(field2718[var13], Skeleton.field1792[var13][this.colors[var13]]);
                        }

                        if (this.colors[var13] < Script.field60[var13].length) {
                            var17.method2234(field2716[var13], Script.field60[var13][this.colors[var13]]);
                        }
                    }

                    var15 = var17.method2282(64, 850, -30, -50, -30);
                    Widget_cachedSprites.method3473(var15, var5);
                    this.field2712 = var5;
                }
            }

            if (var1 == null && var3 == null) {
                return var15;
            } else {
                Model var18;
                if (var1 != null && var3 != null) {
                    var18 = var1.method728(var15, var2, var3, var4);
                } else if (var1 != null) {
                    var18 = var1.method735(var15, var2);
                } else {
                    var18 = var3.method735(var15, var4);
                }

                return var18;
            }
        }
    }

    ModelData method3408() {
        if (this.npcTransformId != -1) {
            return class22.method247(this.npcTransformId).method632();
        } else {
            boolean var1 = false;

            int var3;
            for (int var2 = 0; var2 < 12; ++var2) {
                var3 = this.styles[var2];
                if (var3 >= 256 && var3 < 512 && !class65.readAppearanceStyle(var3 - 256).method784()) {
                    var1 = true;
                }

                if (var3 >= 512 && !class27.method571(var3 - 512).method864(this.isFemale)) {
                    var1 = true;
                }
            }

            if (var1) {
                return null;
            } else {
                ModelData[] var7 = new ModelData[12];
                var3 = 0;

                int var5;
                for (int var4 = 0; var4 < 12; ++var4) {
                    var5 = this.styles[var4];
                    ModelData var6;
                    if (var5 >= 256 && var5 < 512) {
                        var6 = class65.readAppearanceStyle(var5 - 256).method780();
                        if (var6 != null) {
                            var7[var3++] = var6;
                        }
                    }

                    if (var5 >= 512) {
                        var6 = class27.method571(var5 - 512).method865(this.isFemale);
                        if (var6 != null) {
                            var7[var3++] = var6;
                        }
                    }
                }

                ModelData var8 = new ModelData(var7, var3);

                for (var5 = 0; var5 < 5; ++var5) {
                    if (this.colors[var5] < Skeleton.field1792[var5].length) {
                        var8.method2234(field2718[var5], Skeleton.field1792[var5][this.colors[var5]]);
                    }

                    if (this.colors[var5] < Script.field60[var5].length) {
                        var8.method2234(field2716[var5], Script.field60[var5][this.colors[var5]]);
                    }
                }

                return var8;
            }
        }
    }

    public int method3401() {
        return this.npcTransformId == -1 ? (this.styles[0] << 15) + this.styles[1] + (this.styles[11] << 5) + (this.styles[8] << 10) + (this.colors[0] << 25) + (this.colors[4] << 20) : 305419896 + class22.method247(this.npcTransformId).id;
    }
}
