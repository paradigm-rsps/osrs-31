package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

import java.util.HashMap;

@ObfuscatedName("dx")
public class class112 {
    @ObfuscatedName("d")
    @Export("SpriteBuffer_spriteWidths")
    static int[] SpriteBuffer_spriteWidths;
    @ObfuscatedName("eg")
    static int[] field1931;

    static {
        new HashMap();
    }

    @ObfuscatedName("k")
    public static boolean method2502() {
        try {
            if (class137.musicPlayerStatus == 2) {
                if (FloorDecoration.musicTrack == null) {
                    FloorDecoration.musicTrack = MusicTrack.method2905(class137.musicTrackArchive, class125.musicTrackGroupId, FloorDecoration.musicTrackFileId);
                    if (FloorDecoration.musicTrack == null) {
                        return false;
                    }
                }

                if (class23.soundCache == null) {
                    class23.soundCache = new SoundCache(class137.soundEffectsArchive, class137.musicSamplesArchive);
                }

                if (class137.midiPcmStream.method2917(FloorDecoration.musicTrack, class137.musicPatchesArchive, class23.soundCache, 22050)) {
                    class137.midiPcmStream.method2918();
                    class137.midiPcmStream.method2975(class147.musicTrackVolume);
                    class137.midiPcmStream.method2920(FloorDecoration.musicTrack, VarbitComposition.musicTrackBoolean);
                    class137.musicPlayerStatus = 0;
                    FloorDecoration.musicTrack = null;
                    class23.soundCache = null;
                    class137.musicTrackArchive = null;
                    return true;
                }
            }
        } catch (Exception var1) {
            var1.printStackTrace();
            class137.midiPcmStream.method2951();
            class137.musicPlayerStatus = 0;
            FloorDecoration.musicTrack = null;
            class23.soundCache = null;
            class137.musicTrackArchive = null;
        }

        return false;
    }
}
