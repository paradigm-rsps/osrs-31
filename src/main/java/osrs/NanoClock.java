package osrs;

public class NanoClock extends Clock {
    long lastTimeNano = System.nanoTime();

    public void vmethod1698() {
        this.lastTimeNano = System.nanoTime();
    }

    int vmethod1701(int var1, int var2) {
        long var3 = (long) var2 * 1000000L;
        long var5 = this.lastTimeNano - System.nanoTime();
        if (var5 < var3) {
            var5 = var3;
        }

        AnimationDefinition.sleepWeird(var5 / 1000000L);
        long var7 = System.nanoTime();

        int var9;
        for (var9 = 0; var9 < 10 && (var9 < 1 || this.lastTimeNano < var7); this.lastTimeNano += 1000000L * (long) var1) {
            ++var9;
        }

        if (this.lastTimeNano < var7) {
            this.lastTimeNano = var7;
        }

        return var9;
    }
}
