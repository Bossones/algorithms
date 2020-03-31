import java.util.LinkedList;

public class Queue {

    private int maxSize;

    private LinkedList<Integer> linkedList;

    public Queue(int size) {
        maxSize = size;
        linkedList = new LinkedList<>();
    }

    public boolean insert(Integer value) {
        if (isFull())
            return false;
        linkedList.addLast(value);
        return true;
    }

    public int delete() {
        if (isEmpty()) {
            System.err.println("Queue is empty");
            System.exit(1);
        }
        return linkedList.removeFirst();
    }

    public int peek() {
        if (isEmpty()) {
            System.err.println("Queue is empty");
            System.exit(1);
        }
        return linkedList.peekFirst();
    }

    public boolean isFull() {
        return linkedList.size() == maxSize;
    }

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }
}
