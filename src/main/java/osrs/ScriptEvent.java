package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.*;
import java.net.URL;

@ObfuscatedName("i")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
    @ObfuscatedName("dy")
    static int[] regionLandArchiveIds;
    @ObfuscatedName("i")
    @Export("args")
    Object[] args;
    @ObfuscatedName("w")
    @Export("widget")
    @ObfuscatedSignature(
            descriptor = "Lclass157;"
    )
    Widget widget;
    @ObfuscatedName("f")
    int field2;
    @ObfuscatedName("e")
    int field7;
    @ObfuscatedName("t")
    int field3;
    @ObfuscatedName("d")
    @ObfuscatedSignature(
            descriptor = "Lclass157;"
    )
    Widget field5;
    @ObfuscatedName("p")
    int field4;
    @ObfuscatedName("k")
    int field9;
    @ObfuscatedName("r")
    String field8;

    @ObfuscatedName("i")
    @Export("method3")
    public static void method3(String var0, Throwable var1) {
        if (var1 != null) {
            var1.printStackTrace();
        } else {
            try {
                String var2 = "";
                if (var1 != null) {
                    Throwable var4 = var1;
                    String var5;
                    if (var1 instanceof RunException) {
                        RunException var6 = (RunException) var1;
                        var5 = var6.message + " | ";
                        var4 = var6.throwable;
                    } else {
                        var5 = "";
                    }

                    StringWriter var18 = new StringWriter();
                    PrintWriter var7 = new PrintWriter(var18);
                    var4.printStackTrace(var7);
                    var7.close();
                    String var8 = var18.toString();
                    BufferedReader var9 = new BufferedReader(new StringReader(var8));
                    String var10 = var9.readLine();

                    label62:
                    while (true) {
                        while (true) {
                            String var11 = var9.readLine();
                            if (var11 == null) {
                                var5 = var5 + "| " + var10;
                                var2 = var5;
                                break label62;
                            }

                            int var12 = var11.indexOf(40);
                            int var13 = var11.indexOf(41, var12 + 1);
                            if (var12 >= 0 && var13 >= 0) {
                                String var14 = var11.substring(var12 + 1, var13);
                                int var15 = var14.indexOf(".java:");
                                if (var15 >= 0) {
                                    var14 = var14.substring(0, var15) + var14.substring(var15 + 5);
                                    var5 = var5 + var14 + ' ';
                                    continue;
                                }

                                var11 = var11.substring(0, var12);
                            }

                            var11 = var11.trim();
                            var11 = var11.substring(var11.lastIndexOf(32) + 1);
                            var11 = var11.substring(var11.lastIndexOf(9) + 1);
                            var5 = var5 + var11 + ' ';
                        }
                    }
                }

                if (var0 != null) {
                    if (var1 != null) {
                        var2 = var2 + " | ";
                    }

                    var2 = var2 + var0;
                }

                System.out.println("Error: " + var2);
                var2 = var2.replace(':', '.');
                var2 = var2.replace('@', '_');
                var2 = var2.replace('&', '_');
                var2 = var2.replace('#', '_');
                if (RunException.RunException_applet == null) {
                    return;
                }

                URL var3 = new URL(RunException.RunException_applet.getCodeBase(), "clienterror.ws?c=" + class125.RunException_revision + "&u=" + RunException.field1413 + "&v1=" + TaskHandler.javaVendor + "&v2=" + TaskHandler.javaVersion + "&e=" + var2);
                DataInputStream var17 = new DataInputStream(var3.openStream());
                var17.read();
                var17.close();
            } catch (Exception var16) {
            }

        }
    }

    @ObfuscatedName("w")
    @Export("method0")
    static String method0(int var0) {
        return "<col=" + Integer.toHexString(var0) + ">";
    }

    @ObfuscatedName("f")
    public static void method2() {
        if (MouseHandler.MouseHandler_instance != null) {
            MouseHandler var0 = MouseHandler.MouseHandler_instance;
            synchronized (MouseHandler.MouseHandler_instance) {
                MouseHandler.MouseHandler_instance = null;
            }
        }

    }

    @ObfuscatedName("s")
    static final int method4(int var0, int var1) {
        int var2 = Script.method37(var0 - 1, var1 - 1) + Script.method37(1 + var0, var1 - 1) + Script.method37(var0 - 1, 1 + var1) + Script.method37(1 + var0, 1 + var1);
        int var3 = Script.method37(var0 - 1, var1) + Script.method37(var0 + 1, var1) + Script.method37(var0, var1 - 1) + Script.method37(var0, 1 + var1);
        int var4 = Script.method37(var0, var1);
        return var2 / 16 + var3 / 8 + var4 / 4;
    }

    @ObfuscatedName("bo")
    @Export("method1")
    static void method1() {
        if (Client.isSpellSelected) {
            Widget var0 = AbstractArchive.method3230(GraphicsObject.field308, Client.selectedSpellChildIndex);
            if (var0 != null && var0.onTargetLeave != null) {
                ScriptEvent var1 = new ScriptEvent();
                var1.widget = var0;
                var1.args = var0.onTargetLeave;
                Renderable.method2040(var1);
            }

            Client.isSpellSelected = false;
            class82.invalidateWidget(var0);
        }
    }
}
