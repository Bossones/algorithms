package net.bossones.calc.stack;

import net.bossones.calc.lilist.LinkedList;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private final LinkedList<T> linkedList;

    public Stack() {
        linkedList = new LinkedList<>();
    }

    public void add(T element) {
        linkedList.addFirst(element);
    }

    public T remove() {
        return linkedList.removeFirst();
    }

    public T peek() {
        return linkedList.peekFirst();
    }

    public void set(T element) {
        linkedList.removeFirst();
        linkedList.addFirst(element);
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
