package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

import java.applet.Applet;

@ObfuscatedName("ca")
@Implements("RunException")
public class RunException extends RuntimeException {
    @ObfuscatedName("i")
    @Export("RunException_applet")
    static Applet RunException_applet;
    @ObfuscatedName("w")
    public static String field1413;
    @ObfuscatedName("e")
    @Export("message")
    String message;
    @ObfuscatedName("d")
    @Export("throwable")
    Throwable throwable;

    RunException(Throwable var1, String var2) {
        this.message = var2;
        this.throwable = var1;
    }
}
