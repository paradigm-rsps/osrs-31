package osrs;

public class DualNode extends Node {
    DualNode previousDual;
    DualNode nextDual;

    public void method3509() {
        if (this.nextDual != null) {
            this.nextDual.previousDual = this.previousDual;
            this.previousDual.nextDual = this.nextDual;
            this.previousDual = null;
            this.nextDual = null;
        }
    }
}
