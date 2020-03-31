public class Stack {

    private LinkedList linkedList;

    public Stack(int size) { linkedList = new LinkedList(size); }

    public boolean add(int data) { return linkedList.insertLast(data); }

    public int remove() { return linkedList.removeLast(); }

    public int peek() { return linkedList.peekLast(); }

    public boolean isEmpty() { return linkedList.isEmpty(); }

    public boolean isFull() { return linkedList.isFull(); }
}
