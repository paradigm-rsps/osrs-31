import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
   @ObfuscatedName("w")
   @Export("directBuffer")
   ByteBuffer directBuffer;

   @ObfuscatedName("e")
   @Export("vmethod2620")
   byte[] vmethod2620() {
      byte[] var1 = new byte[this.directBuffer.capacity()];
      this.directBuffer.position(0);
      this.directBuffer.get(var1);
      return var1;
   }

   @ObfuscatedName("t")
   @Export("vmethod2622")
   void vmethod2622(byte[] var1) {
      this.directBuffer = ByteBuffer.allocateDirect(var1.length);
      this.directBuffer.position(0);
      this.directBuffer.put(var1);
   }
}
