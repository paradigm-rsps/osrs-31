package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

@ObfuscatedName("bt")
@Implements("NetSocket")
public class NetSocket extends class65 implements MouseWheelListener {
    @ObfuscatedName("i")
    int field1403 = 0;

    @ObfuscatedName("i")
    public void vmethod1690(Component var1) {
        var1.addMouseWheelListener(this);
    }

    @ObfuscatedName("w")
    public void vmethod1681(Component var1) {
        var1.removeMouseWheelListener(this);
    }

    @ObfuscatedName("f")
    @Export("vmethod1679")
    public synchronized int vmethod1679() {
        int var1 = this.field1403;
        this.field1403 = 0;
        return var1;
    }

    public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
        this.field1403 += var1.getWheelRotation();
    }
}
