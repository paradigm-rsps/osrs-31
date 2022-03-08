package osrs;

public class MusicPatchNode extends Node {
    static Archive archive1;
    int field2426;
    MusicPatchNode2 field2425;
    MusicPatch patch;
    RawSound rawSound;
    int field2439;
    int field2427;
    int field2428;
    int field2429;
    int field2430;
    int field2436;
    int field2432;
    int field2434;
    int field2423;
    int field2440;
    int field2443;
    int field2437;
    int field2438;
    int field2435;
    RawPcmStream stream;
    int field2441;
    int field2442;

    void method3118() {
        this.patch = null;
        this.rawSound = null;
        this.field2425 = null;
        this.stream = null;
    }

    public static void method3122() {
        try {
            JagexCache.JagexCache_dat2File.method600();

            for (int var0 = 0; var0 < NetFileRequest.field2554; ++var0) {
                class10.JagexCache_idxFiles[var0].method600();
            }

            JagexCache.fontNameVerdana15.method600();
            JagexCache.JagexCache_randomDat.method600();
        } catch (Exception var2) {
        }

    }
}
