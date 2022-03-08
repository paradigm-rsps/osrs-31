package osrs;

import java.nio.ByteBuffer;

public class DirectByteArrayCopier extends AbstractByteArrayCopier {
    ByteBuffer directBuffer;

    byte[] vmethod2620() {
        byte[] var1 = new byte[this.directBuffer.capacity()];
        this.directBuffer.position(0);
        this.directBuffer.get(var1);
        return var1;
    }

    void vmethod2622(byte[] var1) {
        this.directBuffer = ByteBuffer.allocateDirect(var1.length);
        this.directBuffer.position(0);
        this.directBuffer.put(var1);
    }
}
