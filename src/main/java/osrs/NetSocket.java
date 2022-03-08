package osrs;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class NetSocket extends class65 implements MouseWheelListener {
    int field1403 = 0;

    public void vmethod1690(Component var1) {
        var1.addMouseWheelListener(this);
    }

    public void vmethod1681(Component var1) {
        var1.removeMouseWheelListener(this);
    }

    public synchronized int vmethod1679() {
        int var1 = this.field1403;
        this.field1403 = 0;
        return var1;
    }

    public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
        this.field1403 += var1.getWheelRotation();
    }
}
