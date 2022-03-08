package osrs;

import osrs.cache.Definitions;

public final class GraphicsObject extends Renderable {
    static int field308;
    static Task field305;
    static IterableNodeHashTableIterator gameSocket;
    static int field307;
    int id;
    int cycleStart;
    int plane;
    int x;
    int y;
    int height;
    AnimationDefinition animationDefinition;
    int frame = 0;
    int frameCycle = 0;
    boolean isFinished = false;

    GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.id = var1;
        this.plane = var2;
        this.x = var3;
        this.y = var4;
        this.height = var5;
        this.cycleStart = var7 + var6;
        int var8 = NPCComposition.method656(this.id).sequence;
        if (var8 != -1) {
            this.isFinished = false;
            this.animationDefinition = Definitions.getAnimation(var8);
        } else {
            this.isFinished = true;
        }

    }

    final void method207(int var1) {
        if (!this.isFinished) {
            this.frameCycle += var1;

            while (this.frameCycle > this.animationDefinition.frameLengths[this.frame]) {
                this.frameCycle -= this.animationDefinition.frameLengths[this.frame];
                ++this.frame;
                if (this.frame >= this.animationDefinition.frameIds.length) {
                    this.isFinished = true;
                    break;
                }
            }

        }
    }

    protected final Model vmethod2030() {
        SpotAnimationDefinition var1 = NPCComposition.method656(this.id);
        Model var2;
        if (!this.isFinished) {
            var2 = var1.method766(this.frame);
        } else {
            var2 = var1.method766(-1);
        }

        return var2;
    }
}
