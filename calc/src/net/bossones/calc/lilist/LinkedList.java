package net.bossones.calc.lilist;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import net.bossones.calc.lilist.node.Node;

public class LinkedList<T> implements Iterable<T>{


    private Node<T> first;

    private Node<T> last;

    private int curSize;

    public LinkedList() {
        first = null;
        last = null;
        curSize = 0;
    }

    public LinkedList(T[] array) {
        this();
        Objects.requireNonNull(array);
        for (T elem : array)
            addLast(elem);
    }

    private class LinkedIterator implements ListIterator<T> {

        private int posPrev;

        private int posNext;

        private Node<T> cur;

        public LinkedIterator() {
            posNext = 0;
            posPrev = -1;
            cur = new Node<>(null, first, null);
        }

        @Override
        public boolean hasPrevious() {
            return cur.getPrev() != null;
        }

        @Override
        public boolean hasNext() {
            return cur.getNext() != null;
        }

        @Override
        public T next() {
            if (cur.getNext() == null)
                throw new NoSuchElementException();
            cur.setPrev(cur.getNext());
            cur.setNext(cur.getNext().getNext());
            posPrev++;
            posNext++;
            return cur.getPrev().getData();
        }

        @Override
        public T previous() {
            if (cur.getPrev() == null)
                throw new NoSuchElementException();
            cur.setNext(cur.getPrev());
            cur.setPrev(cur.getPrev().getPrev());
            posNext--;
            posPrev--;
            return cur.getNext().getData();
        }

        @Override
        public int nextIndex() {
            return posNext;
        }

        @Override
        public int previousIndex() {
            return posPrev;
        }

        @Override
        public void set(T element) {
           Objects.requireNonNull(element, "The element reference is null");
           if (cur.getPrev() == null)
               throw new NoSuchElementException("There is not any object at this position.");
           cur.getPrev().setData(element);
        }

        @Override
        public void add(T element) {
            Objects.requireNonNull(element, "The element reference is null");
            cur.setData(element);
            if (isEmpty()) {
                first = last = cur;
            } else if (cur.getPrev() == null) {
                cur.getNext().setPrev(cur);
                first = cur;
            } else if (cur.getNext() == null) {
                cur.getPrev().setNext(cur);
                last = cur;
            } else {
                cur.getPrev().setNext(cur);
                cur.getNext().setPrev(cur);
            }
            cur = new Node<>(null, cur.getNext(), cur);
            curSize++;
            posNext++;
            posPrev++;
        }

        @Override
        public void remove() {
            if (isEmpty())
                throw new EmptyListException("The linked list is empty");
            if (cur.getPrev() == null)
                throw new NoSuchElementException();
            if (curSize == 1) {
                first = last = null;
                cur.setPrev(null);
            } else {
                if (first == cur.getPrev()) {
                    first = first.getNext();
                } else if (last == cur.getPrev()) {
                    last = last.getPrev();
                } else {
                    cur.setPrev(cur.getPrev().getPrev());
                    cur.getPrev().getNext().setPrev(null);
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().getPrev().setNext(null);
                    cur.getNext().setPrev(cur.getPrev());
                }
            }
            curSize--;
            posNext--;
        }
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            last = first = new Node<>(element, null, null);
        } else {
            Node<T> temp = first;
            first = new Node<>(element, temp, null);
            temp.setPrev(first);
        }
        curSize++;
    }

    public T removeFirst() {
        if (isEmpty())
            throw new EmptyListException("The linked list is empty");
        Node<T> temp = first;
        first = first.getNext();
        if (first != null)
            first.setPrev(null);
        temp.setNext(null);
        curSize--;
        return temp.getData();
    }

    public void addLast(T element) {
        if (isEmpty()) {
            last = first = new Node<>(element, null, null);
        } else {
            Node<T> temp = last;
            last = new Node<>(element, null, temp);
            temp.setNext(last);
        }
        curSize++;
    }

    public T removeLast() {
        if (isEmpty())
            throw new EmptyListException("The linked list is empty");
        Node<T> temp = last;
        last = last.getPrev();
        if (last != null)
            last.setNext(null);
        temp.setPrev(null);
        curSize--;
        return temp.getData();
    }

    public T peekFirst() {
        if (isEmpty())
            throw new EmptyListException("The linked list is empty");
        return first.getData();
    }

    public T peekLast() {
        if (isEmpty())
            throw new EmptyListException("The linked list is empty");
        return last.getData();
    }

    public int size() {
        return curSize;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    @Override
    public ListIterator<T> iterator() {
        return new LinkedIterator();
    }

}
