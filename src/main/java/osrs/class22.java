package osrs;

public class class22 {
    protected static Clock field376;
    static int scenePlane;
    static SpritePixels redHintArrowSprite;
    static int cameraY;
    String field381;
    String field369;
    int field370;
    int field371;
    boolean field372;
    boolean field368;

    public static void method246(AbstractArchive var0, AbstractArchive var1) {
        KitDefinition.KitDefinition_archive = var0;
        KitDefinition.KitDefinition_modelsArchive = var1;
        KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.method3214(3);
    }

    public static NPCComposition method247(int var0) {
        NPCComposition var1 = (NPCComposition) NPCComposition.NpcDefinition_cached.method3474(var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = NPCComposition.NpcDefinition_archive.method3204(9, var0);
            var1 = new NPCComposition();
            var1.id = var0;
            if (var2 != null) {
                var1.method629(new Buffer(var2));
            }

            var1.method628();
            NPCComposition.NpcDefinition_cached.method3473(var1, var0);
            return var1;
        }
    }
}
