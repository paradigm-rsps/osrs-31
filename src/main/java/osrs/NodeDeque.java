package osrs;

public class NodeDeque {
    public Node sentinel = new Node();
    Node current;

    public NodeDeque() {
        this.sentinel.previous = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    public void method3527() {
        while (true) {
            Node var1 = this.sentinel.previous;
            if (var1 == this.sentinel) {
                this.current = null;
                return;
            }

            var1.remove();
        }
    }

    public void method3528(Node var1) {
        if (var1.next != null) {
            var1.remove();
        }

        var1.next = this.sentinel.next;
        var1.previous = this.sentinel;
        var1.next.previous = var1;
        var1.previous.next = var1;
    }

    public void method3529(Node var1) {
        if (var1.next != null) {
            var1.remove();
        }

        var1.next = this.sentinel;
        var1.previous = this.sentinel.previous;
        var1.next.previous = var1;
        var1.previous.next = var1;
    }

    public Node method3549() {
        Node var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            return null;
        } else {
            var1.remove();
            return var1;
        }
    }

    public Node method3532() {
        Node var1 = this.sentinel.next;
        if (var1 == this.sentinel) {
            return null;
        } else {
            var1.remove();
            return var1;
        }
    }

    public Node method3533() {
        Node var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            this.current = null;
            return null;
        } else {
            this.current = var1.previous;
            return var1;
        }
    }

    public Node method3554() {
        Node var1 = this.sentinel.next;
        if (var1 == this.sentinel) {
            this.current = null;
            return null;
        } else {
            this.current = var1.next;
            return var1;
        }
    }

    public Node method3535() {
        Node var1 = this.current;
        if (var1 == this.sentinel) {
            this.current = null;
            return null;
        } else {
            this.current = var1.previous;
            return var1;
        }
    }

    public Node method3561() {
        Node var1 = this.current;
        if (var1 == this.sentinel) {
            this.current = null;
            return null;
        } else {
            this.current = var1.next;
            return var1;
        }
    }

    public static void method3530(Node var0, Node var1) {
        if (var0.next != null) {
            var0.remove();
        }

        var0.next = var1.next;
        var0.previous = var1;
        var0.next.previous = var0;
        var0.previous.next = var0;
    }
}
