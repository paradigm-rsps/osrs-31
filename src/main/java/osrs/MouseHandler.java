package osrs;

import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
    static Decimator field1392;
    public static MouseHandler MouseHandler_instance = new MouseHandler();
    public static volatile int MouseHandler_idleCycles = 0;
    public static volatile int MouseHandler_currentButtonVolatile = 0;
    public static volatile int MouseHandler_xVolatile = -1;
    public static volatile int MouseHandler_yVolatile = -1;
    public static int MouseHandler_currentButton = 0;
    public static int MouseHandler_x = 0;
    public static int MouseHandler_y = 0;
    public static volatile int field1398 = 0;
    public static volatile int MouseHandler_lastPressedXVolatile = 0;
    public static volatile int MouseHandler_lastPressedYVolatile = 0;
    public static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;
    public static int PacketBufferNode_packetBufferNodeCount = 0;
    public static int MouseHandler_lastPressedX = 0;
    public static int MouseHandler_lastPressedY = 0;
    public static long field1399 = 0L;
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
