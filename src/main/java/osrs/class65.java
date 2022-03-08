package osrs;

import java.awt.*;
import java.io.IOException;

public abstract class class65 {
    static int field1268;
    static int pcmSampleLength;

    public abstract void vmethod1690(Component var1);

    public abstract void vmethod1681(Component var1);

    public abstract int vmethod1679();

    public static KitDefinition readAppearanceStyle(int id) {
        KitDefinition var1 = (KitDefinition) KitDefinition.KitDefinition_cached.method3474(id);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = KitDefinition.KitDefinition_archive.method3204(3, id);
            var1 = new KitDefinition();
            if (var2 != null) {
                var1.method777(new Buffer(var2));
            }

            KitDefinition.KitDefinition_cached.method3473(var1, id);
            return var1;
        }
    }

    public static int method1456(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = (var2 << 5) - var2 + class40.method918(var0.charAt(var3));
        }

        return var2;
    }

    static final void method1454(boolean var0) {
        AnimationDefinition.method759();
        ++Client.field669;
        if (Client.field669 >= 50 || var0) {
            Client.field669 = 0;
            if (!Client.field530 && GraphicsObject.gameSocket != null) {
                Client.rsaBuf.writeByteOpcode(217);

                try {
                    GraphicsObject.gameSocket.flush(Client.rsaBuf.array, 0, Client.rsaBuf.offset);
                    Client.rsaBuf.offset = 0;
                } catch (IOException var2) {
                    Client.field530 = true;
                }
            }

        }
    }
}
