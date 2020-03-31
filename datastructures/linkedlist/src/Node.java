
public class Node {

    private int data;

    private Node next;

    private Node prev;

    public Node(int data) {
        this(data, null, null);
    }

    public Node(int data, Node prev) {
        this(data, prev, null);
    }

    public Node(Node next, int data) {
        this(data, null, next);
    }

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public int getData() { return data; }

    public void setData(int data) { this.data = data; }

    public Node delPrev() {
        Node temp = prev;
        prev = null;
        return temp;
    }

    public Node delNext() {
        Node temp = next;
        next = null;
        return temp;
    }

    public Node next() { return next; }

    public Node prev() { return prev; }

    public void setNext(Node next) { this.next = next; }

    public void setPrev(Node prev) { this.prev = prev; }
}
