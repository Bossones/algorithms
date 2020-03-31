public class Queue {

    private LinkedList linkedList;

    public Queue(int size) { linkedList = new LinkedList(size); }

    public boolean insert(int data) { return linkedList.insertLast(data); }

    public int delete() { return linkedList.removeFirst(); }

    public int peek() { return linkedList.peekFirst(); }

    public boolean isFull() { return linkedList.isFull(); }

    public boolean isEmpty() { return linkedList.isEmpty(); }
}
