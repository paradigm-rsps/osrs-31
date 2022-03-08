package osrs;

public class VorbisMapping {
    int submaps;
    int mappingMux;
    int[] submapFloor;
    int[] submapResidue;

    VorbisMapping() {
        VorbisSample.method1280(16);
        this.submaps = VorbisSample.method1307() != 0 ? VorbisSample.method1280(4) + 1 : 1;
        if (VorbisSample.method1307() != 0) {
            VorbisSample.method1280(8);
        }

        VorbisSample.method1280(2);
        if (this.submaps > 1) {
            this.mappingMux = VorbisSample.method1280(4);
        }

        this.submapFloor = new int[this.submaps];
        this.submapResidue = new int[this.submaps];

        for (int var1 = 0; var1 < this.submaps; ++var1) {
            VorbisSample.method1280(8);
            this.submapFloor[var1] = VorbisSample.method1280(8);
            this.submapResidue[var1] = VorbisSample.method1280(8);
        }

    }
}
