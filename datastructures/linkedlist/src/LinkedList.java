public class LinkedList {

    private Node end;

    private Node first;

    private int maxSize;

    private int curSize;

    public LinkedList(int size) {
        maxSize = size;
        curSize = 0;
        end = null;
        first = null;
    }

    public boolean insertFirst(int data) {
        if (isFull()) return false;
        if (isEmpty()) {
            first = new Node(data);
            end = first;
        } else {
            Node temp = new Node(first, data);
            first.setPrev(temp);
            first = temp;
        }
        curSize++;
        return true;
    }

    public boolean insertLast(int data) {
        if (isFull()) return false;
        if (isEmpty()) {
            end = new Node(data);
            first = end;
        } else {
            Node temp = new Node(data, end);
            end.setNext(temp);
            end = temp;
        }
        curSize++;
        return true;
    }

    public int removeFirst() {
        if (isEmpty()) {
            System.err.println("Dec is empty");
            System.exit(1);
        }
        if (curSize > 1) {
            first = first.delNext();
            curSize--;
            return first.delPrev().getData();
        } else {
            Node temp = first;
            first = null;
            end = null;
            curSize--;
            return temp.getData();
        }
    }

    public int removeLast() {
        if (isEmpty()) {
            System.err.println("Dec is empty");
            System.exit(1);
        }
        if (curSize > 1) {
            end = end.delPrev();
            curSize--;
            return end.delNext().getData();
        } else {
            Node temp = end;
            end = null;
            first = null;
            curSize--;
            return temp.getData();
        }
    }

    public int peekFirst() {
        if (isEmpty()) {
            System.err.println("Dec is empty");
            System.exit(1);
        }
        return first.getData();
    }

    public int peekLast() {
        if (isEmpty()) {
            System.err.println("Dec is empty");
            System.exit(1);
        }
        return end.getData();
    }

    public boolean isEmpty() { return curSize == 0; }

    public boolean isFull() { return curSize == maxSize; }
}
