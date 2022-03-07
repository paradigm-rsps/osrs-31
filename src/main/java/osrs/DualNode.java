package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("DualNode")
public class DualNode extends Node {
    @ObfuscatedName("cd")
    @Export("previousDual")
    @ObfuscatedSignature(
            descriptor = "Lclass173;"
    )
    DualNode previousDual;
    @ObfuscatedName("ca")
    @Export("nextDual")
    @ObfuscatedSignature(
            descriptor = "Lclass173;"
    )
    DualNode nextDual;

    @ObfuscatedName("fm")
    @Export("method3509")
    public void method3509() {
        if (this.nextDual != null) {
            this.nextDual.previousDual = this.previousDual;
            this.previousDual.nextDual = this.nextDual;
            this.previousDual = null;
            this.nextDual = null;
        }
    }
}
