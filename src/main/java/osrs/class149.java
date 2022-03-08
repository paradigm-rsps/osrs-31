package osrs;

import java.io.IOException;

public class class149 {
    static int[] regions;

    public static void method3176(boolean var0) {
        if (NetCache.NetCache_socket != null) {
            try {
                Buffer var1 = new Buffer(4);
                var1.writeByte(var0 ? 2 : 3);
                var1.writeMedium(0);
                NetCache.NetCache_socket.flush(var1.array, 0, 4);
            } catch (IOException var4) {
                try {
                    NetCache.NetCache_socket.method1471();
                } catch (Exception var3) {
                }

                ++NetCache.NetCache_ioExceptions;
                NetCache.NetCache_socket = null;
            }

        }
    }
}
