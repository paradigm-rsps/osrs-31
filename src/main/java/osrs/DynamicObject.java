package osrs;

import osrs.cache.Definitions;

public class DynamicObject extends Renderable {
    static int selectedItemId;
    static Archive archive10;
    int id;
    int type;
    int orientation;
    int plane;
    int x;
    int y;
    AnimationDefinition animationDefinition;
    int frame;
    int cycleStart;

    DynamicObject(int id, int type, int orientation, int plane, int x, int y, int animation, boolean var8, Renderable renderable) {
        this.id = id;
        this.type = type;
        this.orientation = orientation;
        this.plane = plane;
        this.x = x;
        this.y = y;
        if (animation != -1) {
            this.animationDefinition = Definitions.getAnimation(animation);
            this.frame = 0;
            this.cycleStart = Client.cycle - 1;
            if (this.animationDefinition.field901 == 0 && renderable instanceof DynamicObject) {
                DynamicObject dynamicObject = (DynamicObject) renderable;
                if (this.animationDefinition == dynamicObject.animationDefinition) {
                    this.frame = dynamicObject.frame;
                    this.cycleStart = dynamicObject.cycleStart;
                    return;
                }
            }

            if (var8 && this.animationDefinition.frameCount != -1) {
                this.frame = (int) (Math.random() * (double) this.animationDefinition.frameIds.length);
                this.cycleStart -= (int) (Math.random() * (double) this.animationDefinition.frameLengths[this.frame]);
            }
        }

    }

    protected final Model vmethod2030() {
        if (this.animationDefinition != null) {
            int var1 = Client.cycle - this.cycleStart;
            if (var1 > 100 && this.animationDefinition.frameCount > 0) {
                var1 = 100;
            }

            label56:
            {
                do {
                    do {
                        if (var1 <= this.animationDefinition.frameLengths[this.frame]) {
                            break label56;
                        }

                        var1 -= this.animationDefinition.frameLengths[this.frame];
                        ++this.frame;
                    } while (this.frame < this.animationDefinition.frameIds.length);

                    this.frame -= this.animationDefinition.frameCount;
                } while (this.frame >= 0 && this.frame < this.animationDefinition.frameIds.length);

                this.animationDefinition = null;
            }

            this.cycleStart = Client.cycle - var1;
        }

        ObjectDefinition var12 = Definitions.getObject(this.id);
        if (var12.transforms != null) {
            var12 = var12.method673();
        }

        if (var12 == null) {
            return null;
        } else {
            int var2;
            int var3;
            if (this.orientation != 1 && this.orientation != 3) {
                var2 = var12.sizeX;
                var3 = var12.sizeY;
            } else {
                var2 = var12.sizeY;
                var3 = var12.sizeX;
            }

            int var4 = (var2 >> 1) + this.x;
            int var5 = (var2 + 1 >> 1) + this.x;
            int var6 = (var3 >> 1) + this.y;
            int var7 = (var3 + 1 >> 1) + this.y;
            int[][] var8 = Tiles.tileHeights[this.plane];
            int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
            int var10 = (this.x << 7) + (var2 << 6);
            int var11 = (this.y << 7) + (var3 << 6);
            return var12.method667(this.type, this.orientation, var8, var10, var9, var11, this.animationDefinition, this.frame);
        }
    }

    public static EnumComposition method162(int var0) {
        EnumComposition var1 = (EnumComposition) EnumComposition.field968.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = EnumComposition.field977.method3204(8, var0);
            var1 = new EnumComposition();
            if (var2 != null) {
                var1.method839(new Buffer(var2));
            }

            EnumComposition.field968.method3473(var1, var0);
            return var1;
        }
    }

    static final void method160(int var0, int var1) {
        if (Client.field717 == 0 || Client.field717 == 3) {
            if (MouseHandler.PacketBufferNode_packetBufferNodeCount == 1) {
                int var2 = MouseHandler.MouseHandler_lastPressedX - 25 - var0;
                int var3 = MouseHandler.MouseHandler_lastPressedY - 5 - var1;
                if (var2 >= 0 && var3 >= 0 && var2 < 146 && var3 < 151) {
                    var2 -= 73;
                    var3 -= 75;
                    int var4 = Client.field554 + Client.field569 & 2047;
                    int var5 = Rasterizer3D.Rasterizer3D_sine[var4];
                    int var6 = Rasterizer3D.Rasterizer3D_cosine[var4];
                    var5 = (Client.field556 + 256) * var5 >> 8;
                    var6 = var6 * (Client.field556 + 256) >> 8;
                    int var7 = var3 * var5 + var2 * var6 >> 11;
                    int var8 = var6 * var3 - var2 * var5 >> 11;
                    int var9 = var7 + Tiles.localPlayer.x >> 7;
                    int var10 = Tiles.localPlayer.y - var8 >> 7;
                    boolean var11 = FileSystem.method1517(Tiles.localPlayer.pathX[0], Tiles.localPlayer.pathY[0], var9, var10, true, 0, 0, 0, 0, 0, 1);
                    if (var11) {
                        Client.rsaBuf.writeByte(var2);
                        Client.rsaBuf.writeByte(var3);
                        Client.rsaBuf.writeShort(Client.field569);
                        Client.rsaBuf.writeByte(57);
                        Client.rsaBuf.writeByte(Client.field554);
                        Client.rsaBuf.writeByte(Client.field556);
                        Client.rsaBuf.writeByte(89);
                        Client.rsaBuf.writeShort(Tiles.localPlayer.x);
                        Client.rsaBuf.writeShort(Tiles.localPlayer.y);
                        Client.rsaBuf.writeByte(Client.field738);
                        Client.rsaBuf.writeByte(63);
                    }
                }
            }

        }
    }
}
