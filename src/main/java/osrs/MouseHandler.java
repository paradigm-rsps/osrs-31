package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.event.*;

@ObfuscatedName("bi")
@Implements("MouseHandler")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
    @ObfuscatedName("nx")
    @ObfuscatedSignature(
            descriptor = "Lclass61;"
    )
    static Decimator field1392;
    @ObfuscatedName("i")
    @Export("MouseHandler_instance")
    @ObfuscatedSignature(
            descriptor = "Lclass76;"
    )
    public static MouseHandler MouseHandler_instance = new MouseHandler();
    @ObfuscatedName("w")
    @Export("MouseHandler_idleCycles")
    public static volatile int MouseHandler_idleCycles = 0;
    @ObfuscatedName("f")
    @Export("MouseHandler_currentButtonVolatile")
    public static volatile int MouseHandler_currentButtonVolatile = 0;
    @ObfuscatedName("e")
    @Export("MouseHandler_xVolatile")
    public static volatile int MouseHandler_xVolatile = -1;
    @ObfuscatedName("t")
    @Export("MouseHandler_yVolatile")
    public static volatile int MouseHandler_yVolatile = -1;
    @ObfuscatedName("d")
    @Export("MouseHandler_currentButton")
    public static int MouseHandler_currentButton = 0;
    @ObfuscatedName("p")
    @Export("MouseHandler_x")
    public static int MouseHandler_x = 0;
    @ObfuscatedName("k")
    @Export("MouseHandler_y")
    public static int MouseHandler_y = 0;
    @ObfuscatedName("r")
    public static volatile int field1398 = 0;
    @ObfuscatedName("l")
    @Export("MouseHandler_lastPressedXVolatile")
    public static volatile int MouseHandler_lastPressedXVolatile = 0;
    @ObfuscatedName("a")
    @Export("MouseHandler_lastPressedYVolatile")
    public static volatile int MouseHandler_lastPressedYVolatile = 0;
    @ObfuscatedName("z")
    @Export("MouseHandler_lastPressedTimeMillisVolatile")
    public static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;
    @ObfuscatedName("s")
    @Export("PacketBufferNode_packetBufferNodeCount")
    public static int PacketBufferNode_packetBufferNodeCount = 0;
    @ObfuscatedName("m")
    @Export("MouseHandler_lastPressedX")
    public static int MouseHandler_lastPressedX = 0;
    @ObfuscatedName("u")
    @Export("MouseHandler_lastPressedY")
    public static int MouseHandler_lastPressedY = 0;
    @ObfuscatedName("g")
    public static long field1399 = 0L;
    @ObfuscatedName("fz")
    static int field1402;

    public final synchronized void mouseExited(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_xVolatile = -1;
            MouseHandler_yVolatile = -1;
        }

    }

    public final synchronized void focusLost(FocusEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_currentButtonVolatile = 0;
        }

    }

    public final void mouseClicked(MouseEvent var1) {
        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void mouseEntered(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_xVolatile = var1.getX();
            MouseHandler_yVolatile = var1.getY();
        }

    }

    public final synchronized void mouseDragged(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_xVolatile = var1.getX();
            MouseHandler_yVolatile = var1.getY();
        }

    }

    public final synchronized void mouseMoved(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_xVolatile = var1.getX();
            MouseHandler_yVolatile = var1.getY();
        }

    }

    public final void focusGained(FocusEvent var1) {
    }

    public final synchronized void mousePressed(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_lastPressedXVolatile = var1.getX();
            MouseHandler_lastPressedYVolatile = var1.getY();
            MouseHandler_lastPressedTimeMillisVolatile = ClientPreferences.method148();
            if (var1.isMetaDown()) {
                field1398 = 2;
                MouseHandler_currentButtonVolatile = 2;
            } else {
                field1398 = 1;
                MouseHandler_currentButtonVolatile = 1;
            }
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }

    public final synchronized void mouseReleased(MouseEvent var1) {
        if (MouseHandler_instance != null) {
            MouseHandler_idleCycles = 0;
            MouseHandler_currentButtonVolatile = 0;
        }

        if (var1.isPopupTrigger()) {
            var1.consume();
        }

    }
}
