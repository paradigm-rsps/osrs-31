package osrs;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.awt.*;

public class DevicePcmPlayer extends PcmPlayer {
    AudioFormat field1095;
    SourceDataLine line;
    int capacity2;
    byte[] byteSamples;

    void vmethod1234(Component var1) {
        this.field1095 = new AudioFormat((float) PcmPlayer.field1099, 16, PcmPlayer.PcmPlayer_stereo ? 2 : 1, true, false);
        this.byteSamples = new byte[256 << (PcmPlayer.PcmPlayer_stereo ? 2 : 1)];
    }

    void vmethod1235(int var1) throws LineUnavailableException {
        try {
            Info var2 = new Info(SourceDataLine.class, this.field1095, var1 << (PcmPlayer.PcmPlayer_stereo ? 2 : 1));
            this.line = (SourceDataLine) AudioSystem.getLine(var2);
            this.line.open();
            this.line.start();
            this.capacity2 = var1;
        } catch (LineUnavailableException var5) {
            if (AnimationDefinition.method760(var1) != 1) {
                int var4 = var1 - 1;
                var4 |= var4 >>> 1;
                var4 |= var4 >>> 2;
                var4 |= var4 >>> 4;
                var4 |= var4 >>> 8;
                var4 |= var4 >>> 16;
                int var3 = var4 + 1;
                this.vmethod1235(var3);
            } else {
                this.line = null;
                throw var5;
            }
        }
    }

    int vmethod1233() {
        return this.capacity2 - (this.line.available() >> (PcmPlayer.PcmPlayer_stereo ? 2 : 1));
    }

    void vmethod1237() {
        int var1 = 256;
        if (PcmPlayer.PcmPlayer_stereo) {
            var1 <<= 1;
        }

        for (int var2 = 0; var2 < var1; ++var2) {
            int var3 = super.samples[var2];
            if ((var3 + 8388608 & -16777216) != 0) {
                var3 = 8388607 ^ var3 >> 31;
            }

            this.byteSamples[var2 * 2] = (byte) (var3 >> 8);
            this.byteSamples[var2 * 2 + 1] = (byte) (var3 >> 16);
        }

        this.line.write(this.byteSamples, 0, var1 << 1);
    }

    void vmethod1238() {
        if (this.line != null) {
            this.line.close();
            this.line = null;
        }

    }

    void vmethod1229() {
        this.line.flush();
    }
}
