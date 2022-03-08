package osrs;

public class class137 {
    public static AbstractArchive musicPatchesArchive;
    public static AbstractArchive musicSamplesArchive;
    public static AbstractArchive soundEffectsArchive;
    public static MidiPcmStream midiPcmStream;
    public static int musicPlayerStatus = 0;
    public static AbstractArchive musicTrackArchive;

    public static int method2892(int var0) {
        return var0 >> 17 & 7;
    }
}
