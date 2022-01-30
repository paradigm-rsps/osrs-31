import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("el")
public class class149 {
   @ObfuscatedName("dt")
   static int[] field2463;

   @ObfuscatedName("i")
   public static void method3176(boolean var0) {
      if (NetCache.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2631(var0 ? 2 : 3);
            var1.method2720(0);
            NetCache.NetCache_socket.method1474(var1.array, 0, 4);
         } catch (IOException var4) {
            try {
               NetCache.NetCache_socket.method1471();
            } catch (Exception var3) {
               ;
            }

            ++NetCache.NetCache_ioExceptions;
            NetCache.NetCache_socket = null;
         }

      }
   }
}
