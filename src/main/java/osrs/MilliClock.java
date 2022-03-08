package osrs;


import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MilliClock extends Clock {
    long[] field1255 = new long[10];
    int field1256 = 256;
    int field1262 = 1;
    long field1257 = ClientPreferences.method148();
    int field1254 = 0;
    int field1259;

    MilliClock() {
        for (int var1 = 0; var1 < 10; ++var1) {
            this.field1255[var1] = this.field1257;
        }

    }

    public void vmethod1698() {
        for (int var1 = 0; var1 < 10; ++var1) {
            this.field1255[var1] = 0L;
        }

    }

    int vmethod1701(int var1, int var2) {
        int var3 = this.field1256;
        int var4 = this.field1262;
        this.field1256 = 300;
        this.field1262 = 1;
        this.field1257 = ClientPreferences.method148();
        if (0L == this.field1255[this.field1259]) {
            this.field1256 = var3;
            this.field1262 = var4;
        } else if (this.field1257 > this.field1255[this.field1259]) {
            this.field1256 = (int) ((long) (var1 * 2560) / (this.field1257 - this.field1255[this.field1259]));
        }

        if (this.field1256 < 25) {
            this.field1256 = 25;
        }

        if (this.field1256 > 256) {
            this.field1256 = 256;
            this.field1262 = (int) ((long) var1 - (this.field1257 - this.field1255[this.field1259]) / 10L);
        }

        if (this.field1262 > var1) {
            this.field1262 = var1;
        }

        this.field1255[this.field1259] = this.field1257;
        this.field1259 = (this.field1259 + 1) % 10;
        int var5;
        if (this.field1262 > 1) {
            for (var5 = 0; var5 < 10; ++var5) {
                if (0L != this.field1255[var5]) {
                    this.field1255[var5] += this.field1262;
                }
            }
        }

        if (this.field1262 < var2) {
            this.field1262 = var2;
        }

        AnimationDefinition.sleepWeird(this.field1262);

        for (var5 = 0; this.field1254 < 256; this.field1254 += this.field1256) {
            ++var5;
        }

        this.field1254 &= 255;
        return var5;
    }

    static Frames method1438(int var0) {
        Frames var1 = (Frames) AnimationDefinition.SequenceDefinition_cachedFrames.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            var1 = FloorDecoration.method2382(AnimationDefinition.SequenceDefinition_animationsArchive, AnimationDefinition.SequenceDefinition_skeletonsArchive, var0, false);
            if (var1 != null) {
                AnimationDefinition.SequenceDefinition_cachedFrames.method3473(var1, var0);
            }

            return var1;
        }
    }
}
