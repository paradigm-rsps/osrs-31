package osrs;

public final class DualNodeDeque {
    DualNode sentinel = new DualNode();

    public DualNodeDeque() {
        this.sentinel.previousDual = this.sentinel;
        this.sentinel.nextDual = this.sentinel;
    }

    public void method3485(DualNode var1) {
        if (var1.nextDual != null) {
            var1.method3509();
        }

        var1.nextDual = this.sentinel.nextDual;
        var1.previousDual = this.sentinel;
        var1.nextDual.previousDual = var1;
        var1.previousDual.nextDual = var1;
    }

    public void method3486(DualNode var1) {
        if (var1.nextDual != null) {
            var1.method3509();
        }

        var1.nextDual = this.sentinel;
        var1.previousDual = this.sentinel.previousDual;
        var1.nextDual.previousDual = var1;
        var1.previousDual.nextDual = var1;
    }

    DualNode method3498() {
        DualNode var1 = this.sentinel.previousDual;
        if (var1 == this.sentinel) {
            return null;
        } else {
            var1.method3509();
            return var1;
        }
    }

    public DualNode method3488() {
        DualNode var1 = this.sentinel.previousDual;
        return var1 == this.sentinel ? null : var1;
    }

    void method3497() {
        while (true) {
            DualNode var1 = this.sentinel.previousDual;
            if (var1 == this.sentinel) {
                return;
            }

            var1.method3509();
        }
    }
}
