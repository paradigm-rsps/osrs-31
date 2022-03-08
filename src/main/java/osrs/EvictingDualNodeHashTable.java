package osrs;

public final class EvictingDualNodeHashTable {
    DualNode field2798 = new DualNode();
    int capacity;
    int remainingCapacity;
    NodeHashTable hashTable;
    DualNodeDeque deque = new DualNodeDeque();

    public EvictingDualNodeHashTable(int var1) {
        this.capacity = var1;
        this.remainingCapacity = var1;

        int var2;
        for (var2 = 1; var2 + var2 < var1; var2 += var2) {
        }

        this.hashTable = new NodeHashTable(var2);
    }

    public DualNode method3474(long var1) {
        DualNode var3 = (DualNode) this.hashTable.method3512(var1);
        if (var3 != null) {
            this.deque.method3485(var3);
        }

        return var3;
    }

    public void method3475(long var1) {
        DualNode var3 = (DualNode) this.hashTable.method3512(var1);
        if (var3 != null) {
            var3.remove();
            var3.method3509();
            ++this.remainingCapacity;
        }

    }

    public void method3473(DualNode var1, long var2) {
        if (this.remainingCapacity == 0) {
            DualNode var4 = this.deque.method3498();
            var4.remove();
            var4.method3509();
            if (var4 == this.field2798) {
                var4 = this.deque.method3498();
                var4.remove();
                var4.method3509();
            }
        } else {
            --this.remainingCapacity;
        }

        this.hashTable.method3517(var1, var2);
        this.deque.method3485(var1);
    }

    public void method3482() {
        this.deque.method3497();
        this.hashTable.method3514();
        this.field2798 = new DualNode();
        this.remainingCapacity = this.capacity;
    }
}
