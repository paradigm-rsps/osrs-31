package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("EvictingDualNodeHashTable")
public final class EvictingDualNodeHashTable {
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "Lclass173;"
    )
    DualNode field2798 = new DualNode();
    @ObfuscatedName("w")
    @Export("capacity")
    int capacity;
    @ObfuscatedName("f")
    @Export("remainingCapacity")
    int remainingCapacity;
    @ObfuscatedName("e")
    @Export("hashTable")
    @ObfuscatedSignature(
            descriptor = "Lclass174;"
    )
    NodeHashTable hashTable;
    @ObfuscatedName("t")
    @Export("deque")
    @ObfuscatedSignature(
            descriptor = "Lclass171;"
    )
    DualNodeDeque deque = new DualNodeDeque();

    public EvictingDualNodeHashTable(int var1) {
        this.capacity = var1;
        this.remainingCapacity = var1;

        int var2;
        for (var2 = 1; var2 + var2 < var1; var2 += var2) {
        }

        this.hashTable = new NodeHashTable(var2);
    }

    @ObfuscatedName("i")
    @Export("method3474")
    @ObfuscatedSignature(
            descriptor = "(J)Lclass173;"
    )
    public DualNode method3474(long var1) {
        DualNode var3 = (DualNode) this.hashTable.method3512(var1);
        if (var3 != null) {
            this.deque.method3485(var3);
        }

        return var3;
    }

    @ObfuscatedName("w")
    @Export("method3475")
    public void method3475(long var1) {
        DualNode var3 = (DualNode) this.hashTable.method3512(var1);
        if (var3 != null) {
            var3.remove();
            var3.method3509();
            ++this.remainingCapacity;
        }

    }

    @ObfuscatedName("f")
    @Export("method3473")
    @ObfuscatedSignature(
            descriptor = "(Lclass173;J)V"
    )
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

    @ObfuscatedName("e")
    @Export("method3482")
    public void method3482() {
        this.deque.method3497();
        this.hashTable.method3514();
        this.field2798 = new DualNode();
        this.remainingCapacity = this.capacity;
    }
}
