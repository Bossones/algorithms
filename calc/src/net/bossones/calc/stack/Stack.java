package net.bossones.calc.stack;

import net.bossones.calc.lilist.LinkedList;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private final LinkedList<T> linkedList;

    public Stack() {
        linkedList = new LinkedList<>();
    }

    public void add(T element) {
        linkedList.addLast(element);
    }

    public T remove() {
        return linkedList.removeLast();
    }

    public T peek() {
        return linkedList.peekLast();
    }

    public void set(T element) {
        linkedList.removeLast();
        linkedList.addLast(element);
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int size() {
        return linkedList.size();
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
