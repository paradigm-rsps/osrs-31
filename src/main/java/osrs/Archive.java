package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.zip.CRC32;

@ObfuscatedName("ez")
@Implements("Archive")
public class Archive extends AbstractArchive {
    @ObfuscatedName("x")
    @Export("Archive_crc")
    static CRC32 Archive_crc = new CRC32();
    @ObfuscatedName("n")
    @Export("archiveDisk")
    @ObfuscatedSignature(
            descriptor = "Lclass70;"
    )
    ArchiveDisk archiveDisk;
    @ObfuscatedName("q")
    @Export("masterDisk")
    @ObfuscatedSignature(
            descriptor = "Lclass70;"
    )
    ArchiveDisk masterDisk;
    @ObfuscatedName("c")
    @Export("index")
    int index;
    @ObfuscatedName("h")
    volatile boolean field2543 = false;
    @ObfuscatedName("b")
    boolean field2544 = false;
    @ObfuscatedName("y")
    @Export("validGroups")
    volatile boolean[] validGroups;
    @ObfuscatedName("ao")
    @Export("indexCrc")
    int indexCrc;
    @ObfuscatedName("ae")
    @Export("indexVersion")
    int indexVersion;
    @ObfuscatedName("aa")
    int field2545 = -1;

    @ObfuscatedSignature(
            descriptor = "(Lclass70;Lclass70;IZZZ)V"
    )
    public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
        super(var4, var5);
        this.archiveDisk = var1;
        this.masterDisk = var2;
        this.index = var3;
        this.field2544 = var6;
        EnumComposition.method851(this, this.index);
    }

    @ObfuscatedName("w")
    @Export("vmethod3297")
    void vmethod3297(int var1) {
        class10.method129(this.index, var1);
    }

    @ObfuscatedName("a")
    @Export("vmethod3298")
    void vmethod3298(int var1) {
        if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
            ArchiveDisk var2 = this.archiveDisk;
            byte[] var4 = null;
            NodeDeque var5 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
            synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
                for (ArchiveDiskAction var6 = (ArchiveDiskAction) ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method3533(); var6 != null; var6 = (ArchiveDiskAction) ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method3535()) {
                    if (var6.key == (long) var1 && var2 == var6.archiveDisk && var6.type == 0) {
                        var4 = var6.data;
                        break;
                    }
                }
            }

            if (var4 != null) {
                this.method3317(var2, var1, var4, true);
            } else {
                byte[] var9 = var2.method1500(var1);
                this.method3317(var2, var1, var9, true);
            }
        } else {
            class148.method3173(this, this.index, var1, super.groupCrcs[var1], (byte) 2, true);
        }

    }

    @ObfuscatedName("ca")
    @Export("method3296")
    public int method3296() {
        if (this.field2543) {
            return 100;
        } else if (super.groups != null) {
            return 99;
        } else {
            int var2 = this.index;
            long var3 = var2 + 16711680;
            int var1;
            if (MusicPatchPcmStream.NetCache_currentResponse != null && MusicPatchPcmStream.NetCache_currentResponse.key == var3) {
                var1 = class68.NetCache_responseArchiveBuffer.offset * 99 / (class68.NetCache_responseArchiveBuffer.array.length - MusicPatchPcmStream.NetCache_currentResponse.padding) + 1;
            } else {
                var1 = 0;
            }

            int var5 = var1;
            if (var1 >= 100) {
                var5 = 99;
            }

            return var5;
        }
    }

    @ObfuscatedName("ck")
    @Export("method3299")
    public void method3299(int var1, int var2) {
        this.indexCrc = var1;
        this.indexVersion = var2;
        if (this.masterDisk != null) {
            int var3 = this.index;
            ArchiveDisk var4 = this.masterDisk;
            byte[] var6 = null;
            NodeDeque var7 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
            synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
                for (ArchiveDiskAction var8 = (ArchiveDiskAction) ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method3533(); var8 != null; var8 = (ArchiveDiskAction) ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method3535()) {
                    if ((long) var3 == var8.key && var4 == var8.archiveDisk && var8.type == 0) {
                        var6 = var8.data;
                        break;
                    }
                }
            }

            if (var6 != null) {
                this.method3317(var4, var3, var6, true);
            } else {
                byte[] var11 = var4.method1500(var3);
                this.method3317(var4, var3, var11, true);
            }
        } else {
            class148.method3173(this, 255, this.index, this.indexCrc, (byte) 0, true);
        }

    }

    @ObfuscatedName("cq")
    @Export("method3300")
    public void method3300(int var1, byte[] var2, boolean var3, boolean var4) {
        if (var3) {
            if (this.field2543) {
                throw new RuntimeException();
            }

            if (this.masterDisk != null) {
                int var5 = this.index;
                ArchiveDisk var6 = this.masterDisk;
                ArchiveDiskAction var7 = new ArchiveDiskAction();
                var7.type = 0;
                var7.key = var5;
                var7.data = var2;
                var7.archiveDisk = var6;
                NodeDeque var8 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
                synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
                    ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method3528(var7);
                }

                Object var21 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
                synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
                    if (ArchiveDiskActionHandler.field2565 == 0) {
                        ItemContainer.taskHandler.method1599(new ArchiveDiskActionHandler(), 5);
                    }

                    ArchiveDiskActionHandler.field2565 = 600;
                }
            }

            this.method3202(var2);
            this.method3305();
        } else {
            var2[var2.length - 2] = (byte) (super.groupVersions[var1] >> 8);
            var2[var2.length - 1] = (byte) super.groupVersions[var1];
            if (this.archiveDisk != null) {
                ArchiveDisk var13 = this.archiveDisk;
                ArchiveDiskAction var18 = new ArchiveDiskAction();
                var18.type = 0;
                var18.key = var1;
                var18.data = var2;
                var18.archiveDisk = var13;
                NodeDeque var19 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
                synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
                    ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.method3528(var18);
                }

                Object var20 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
                synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
                    if (ArchiveDiskActionHandler.field2565 == 0) {
                        ItemContainer.taskHandler.method1599(new ArchiveDiskActionHandler(), 5);
                    }

                    ArchiveDiskActionHandler.field2565 = 600;
                }

                this.validGroups[var1] = true;
            }

            if (var4) {
                super.groups[var1] = PacketBuffer.method2537(var2, false);
            }
        }

    }

    @ObfuscatedName("cg")
    @Export("method3317")
    @ObfuscatedSignature(
            descriptor = "(Lclass70;I[BZ)V"
    )
    public void method3317(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
        int var5;
        if (var1 == this.masterDisk) {
            if (this.field2543) {
                throw new RuntimeException();
            }

            if (var3 == null) {
                class148.method3173(this, 255, this.index, this.indexCrc, (byte) 0, true);
                return;
            }

            Archive_crc.reset();
            Archive_crc.update(var3, 0, var3.length);
            var5 = (int) Archive_crc.getValue();
            Buffer var9 = new Buffer(class120.method2582(var3));
            int var7 = var9.readUnsignedByte();
            if (var7 != 5 && var7 != 6) {
                throw new RuntimeException("");
            }

            int var8 = 0;
            if (var7 >= 6) {
                var8 = var9.readInt();
            }

            if (var5 != this.indexCrc || var8 != this.indexVersion) {
                class148.method3173(this, 255, this.index, this.indexCrc, (byte) 0, true);
                return;
            }

            this.method3202(var3);
            this.method3305();
        } else {
            if (!var4 && var2 == this.field2545) {
                this.field2543 = true;
            }

            if (var3 == null || var3.length <= 2) {
                this.validGroups[var2] = false;
                if (this.field2544 || var4) {
                    class148.method3173(this, this.index, var2, super.groupCrcs[var2], (byte) 2, var4);
                }

                return;
            }

            Archive_crc.reset();
            Archive_crc.update(var3, 0, var3.length - 2);
            var5 = (int) Archive_crc.getValue();
            int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if (var5 != super.groupCrcs[var2] || var6 != super.groupVersions[var2]) {
                this.validGroups[var2] = false;
                if (this.field2544 || var4) {
                    class148.method3173(this, this.index, var2, super.groupCrcs[var2], (byte) 2, var4);
                }

                return;
            }

            this.validGroups[var2] = true;
            if (var4) {
                super.groups[var2] = PacketBuffer.method2537(var3, false);
            }
        }

    }

    @ObfuscatedName("ct")
    @Export("method3305")
    void method3305() {
        this.validGroups = new boolean[super.groups.length];

        int var1;
        for (var1 = 0; var1 < this.validGroups.length; ++var1) {
            this.validGroups[var1] = false;
        }

        if (this.archiveDisk == null) {
            this.field2543 = true;
        } else {
            this.field2545 = -1;

            for (var1 = 0; var1 < this.validGroups.length; ++var1) {
                if (super.fileCounts[var1] > 0) {
                    MidiPcmStream.method2941(var1, this.archiveDisk, this);
                    this.field2545 = var1;
                }
            }

            if (this.field2545 == -1) {
                this.field2543 = true;
            }

        }
    }

    @ObfuscatedName("cc")
    @Export("method3302")
    int method3302(int var1) {
        if (super.groups[var1] != null) {
            return 100;
        } else {
            return this.validGroups[var1] ? 100 : Decimator.method1409(this.index, var1);
        }
    }

    @ObfuscatedName("cx")
    @Export("method3301")
    public int method3301() {
        int var1 = 0;
        int var2 = 0;

        int var3;
        for (var3 = 0; var3 < super.groups.length; ++var3) {
            if (super.fileCounts[var3] > 0) {
                var1 += 100;
                var2 += this.method3302(var3);
            }
        }

        if (var1 == 0) {
            return 100;
        } else {
            var3 = var2 * 100 / var1;
            return var3;
        }
    }

    @ObfuscatedName("do")
    @ObfuscatedSignature(
            descriptor = "(Lclass157;)Z"
    )
    static boolean method3322(Widget var0) {
        if (Client.field652) {
            if (SoundSystem.method1326(var0) != 0) {
                return false;
            }

            if (var0.type == 0) {
                return false;
            }
        }

        return var0.field2588;
    }
}
