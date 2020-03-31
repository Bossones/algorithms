public class Dec {

    private LinkedList linkedList;

    public Dec(int size) {
        linkedList = new LinkedList(size);
    }

    public boolean insertFirst(int data) {
        return linkedList.insertFirst(data);
    }

    public boolean insertLast(int data) {
        return linkedList.insertLast(data);
    }

    public int removeFirst() {
        return linkedList.removeFirst();
    }

    public int removeLast() {
        return linkedList.removeLast();
    }

    public int peekFirst() {
        return linkedList.peekFirst();
    }

    public int peekLast() {
        return linkedList.peekLast();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public boolean isFull() {
        return linkedList.isFull();
    }
}
