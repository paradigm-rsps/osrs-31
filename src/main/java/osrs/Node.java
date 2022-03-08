package osrs;

public class Node {
    public long key;
    public Node previous;
    Node next;

    public void remove() {
        if (this.next != null) {
            this.next.previous = this.previous;
            this.previous.next = this.next;
            this.previous = null;
            this.next = null;
        }
    }

    public boolean method3566() {
        return this.next != null;
    }
}
