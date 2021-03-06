package osrs;

import java.awt.*;

public class NPCComposition extends DualNode {
    protected static Image field801;
    static AbstractArchive NpcDefinition_archive;
    static AbstractArchive NpcDefinition_modelArchive;
    public static EvictingDualNodeHashTable NpcDefinition_cached = new EvictingDualNodeHashTable(64);
    public static EvictingDualNodeHashTable NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
    public int id;
    public String name = "null";
    public int size = 1;
    int[] models;
    int[] field791;
    public int field789 = -1;
    public int textSize = -1;
    public int turnRightSequence = -1;
    public int walkSequence = -1;
    public int walkBackSequence = -1;
    public int walkLeftSequence = -1;
    public int walkRightSequence = -1;
    short[] recolorFrom;
    short[] recolorTo;
    short[] retextureFrom;
    short[] retextureTo;
    public String[] actions = new String[5];
    public boolean field804 = true;
    public int category = -1;
    int widthScale = 128;
    int heightScale = 128;
    public boolean field808 = false;
    int field809 = 0;
    int field810 = 0;
    public int field811 = -1;
    public int field800 = 32;
    public int[] transforms;
    int transformVarbit = -1;
    int transformVarp = -1;
    public boolean isInteractable = true;
    public boolean field803 = true;

    void method628() {
    }

    void method629(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method630(var1, var2);
        }
    }

    void method630(Buffer var1, int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedByte();
            this.models = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.models[var4] = var1.readUnsignedShort();
            }
        } else if (var2 == 2) {
            this.name = var1.readChatString();
        } else if (var2 == 12) {
            this.size = var1.readUnsignedByte();
        } else if (var2 == 13) {
            this.field789 = var1.readUnsignedShort();
        } else if (var2 == 14) {
            this.walkSequence = var1.readUnsignedShort();
        } else if (var2 == 15) {
            this.textSize = var1.readUnsignedShort();
        } else if (var2 == 16) {
            this.turnRightSequence = var1.readUnsignedShort();
        } else if (var2 == 17) {
            this.walkSequence = var1.readUnsignedShort();
            this.walkBackSequence = var1.readUnsignedShort();
            this.walkLeftSequence = var1.readUnsignedShort();
            this.walkRightSequence = var1.readUnsignedShort();
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
            var3 = var1.readUnsignedByte();
            this.field791 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.field791[var4] = var1.readUnsignedShort();
            }
        } else if (var2 == 93) {
            this.field804 = false;
        } else if (var2 == 95) {
            this.category = var1.readUnsignedShort();
        } else if (var2 == 97) {
            this.widthScale = var1.readUnsignedShort();
        } else if (var2 == 98) {
            this.heightScale = var1.readUnsignedShort();
        } else if (var2 == 99) {
            this.field808 = true;
        } else if (var2 == 100) {
            this.field809 = var1.readByte();
        } else if (var2 == 101) {
            this.field810 = var1.readByte() * 5;
        } else if (var2 == 102) {
            this.field811 = var1.readUnsignedShort();
        } else if (var2 == 103) {
            this.field800 = var1.readUnsignedShort();
        } else if (var2 == 106) {
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
        } else if (var2 == 107) {
            this.isInteractable = false;
        } else if (var2 == 109) {
            this.field803 = false;
        }

    }

    public final Model method643(AnimationDefinition var1, int var2, AnimationDefinition var3, int var4) {
        if (this.transforms != null) {
            NPCComposition var12 = this.method657();
            return var12 == null ? null : var12.method643(var1, var2, var3, var4);
        } else {
            Model var5 = (Model) NpcDefinition_cachedModels.method3474(this.id);
            if (var5 == null) {
                boolean var6 = false;

                for (int var7 = 0; var7 < this.models.length; ++var7) {
                    if (!NpcDefinition_modelArchive.method3206(this.models[var7], 0)) {
                        var6 = true;
                    }
                }

                if (var6) {
                    return null;
                }

                ModelData[] var8 = new ModelData[this.models.length];

                int var9;
                for (var9 = 0; var9 < this.models.length; ++var9) {
                    var8[var9] = ModelData.method2222(NpcDefinition_modelArchive, this.models[var9], 0);
                }

                ModelData var10;
                if (var8.length == 1) {
                    var10 = var8[0];
                } else {
                    var10 = new ModelData(var8, var8.length);
                }

                if (this.recolorFrom != null) {
                    for (var9 = 0; var9 < this.recolorFrom.length; ++var9) {
                        var10.method2234(this.recolorFrom[var9], this.recolorTo[var9]);
                    }
                }

                if (this.retextureFrom != null) {
                    for (var9 = 0; var9 < this.retextureFrom.length; ++var9) {
                        var10.method2236(this.retextureFrom[var9], this.retextureTo[var9]);
                    }
                }

                var5 = var10.method2282(this.field809 + 64, this.field810 + 850, -30, -50, -30);
                NpcDefinition_cachedModels.method3473(var5, this.id);
            }

            Model var11;
            if (var1 != null && var3 != null) {
                var11 = var1.method728(var5, var2, var3, var4);
            } else if (var1 != null) {
                var11 = var1.method735(var5, var2);
            } else if (var3 != null) {
                var11 = var3.method735(var5, var4);
            } else {
                var11 = var5.method2424(true);
            }

            if (this.widthScale != 128 || this.heightScale != 128) {
                var11.method2438(this.widthScale, this.heightScale, this.widthScale);
            }

            return var11;
        }
    }

    public final ModelData method632() {
        if (this.transforms != null) {
            NPCComposition var7 = this.method657();
            return var7 == null ? null : var7.method632();
        } else if (this.field791 == null) {
            return null;
        } else {
            boolean var1 = false;

            for (int var2 = 0; var2 < this.field791.length; ++var2) {
                if (!NpcDefinition_modelArchive.method3206(this.field791[var2], 0)) {
                    var1 = true;
                }
            }

            if (var1) {
                return null;
            } else {
                ModelData[] var5 = new ModelData[this.field791.length];

                for (int var3 = 0; var3 < this.field791.length; ++var3) {
                    var5[var3] = ModelData.method2222(NpcDefinition_modelArchive, this.field791[var3], 0);
                }

                ModelData var6;
                if (var5.length == 1) {
                    var6 = var5[0];
                } else {
                    var6 = new ModelData(var5, var5.length);
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

                return var6;
            }
        }
    }

    public final NPCComposition method657() {
        int var1 = -1;
        if (this.transformVarbit != -1) {
            var1 = class133.method2863(this.transformVarbit);
        } else if (this.transformVarp != -1) {
            var1 = Varps.Varps_main[this.transformVarp];
        }

        return var1 >= 0 && var1 < this.transforms.length && this.transforms[var1] != -1 ? class22.method247(this.transforms[var1]) : null;
    }

    public boolean method634() {
        if (this.transforms == null) {
            return true;
        } else {
            int var1 = -1;
            if (this.transformVarbit != -1) {
                var1 = class133.method2863(this.transformVarbit);
            } else if (this.transformVarp != -1) {
                var1 = Varps.Varps_main[this.transformVarp];
            }

            return var1 >= 0 && var1 < this.transforms.length && this.transforms[var1] != -1;
        }
    }

    public static SpotAnimationDefinition method656(int var0) {
        SpotAnimationDefinition var1 = (SpotAnimationDefinition) SpotAnimationDefinition.SpotAnimationDefinition_cached.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.method3204(13, var0);
            var1 = new SpotAnimationDefinition();
            var1.id = var0;
            if (var2 != null) {
                var1.method764(new Buffer(var2));
            }

            SpotAnimationDefinition.SpotAnimationDefinition_cached.method3473(var1, var0);
            return var1;
        }
    }

    static final String method653(int var0) {
        String var1 = Integer.toString(var0);

        for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
            var1 = var1.substring(0, var2) + "," + var1.substring(var2);
        }

        if (var1.length() > 9) {
            return " " + ScriptEvent.method0(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
        } else {
            return var1.length() > 6 ? " " + ScriptEvent.method0(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + ScriptEvent.method0(16776960) + var1 + "</col>";
        }
    }
}
