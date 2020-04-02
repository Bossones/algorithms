public class SortedList {

     private Node first;

     private Node last;

     private int maxSize;

     private int curSize;

     public SortedList(int maxSize) {
         first = null;
         last = null;
         this.maxSize = maxSize;
         curSize = 0;
     }

     public boolean isFull() { return curSize == maxSize; }

     public boolean isEmpty() { return curSize == 0; }

     public boolean insert(int data) {
         if (isFull())
             return false;
         if (isEmpty()) {
             first = last = new Node(data);
         } else {
             Node cur = first;
             while (cur.next() != null && data > cur.getData())
                 cur = cur.next();
             if (data < cur.getData()) {
                 Node temp = new Node(cur, data);
                 if (cur.prev() != null) {
                     temp.setPrev(cur.prev());
                     cur.prev().setNext(temp);
                 } else {
                     first = temp;
                 }
                 cur.setPrev(temp);
             } else {
                 Node temp = new Node(data, last);
                 last.setNext(temp);
                 last = temp;
             }
         }
         curSize++;
         return true;
     }

     public int peekMin() throws EmptyListException {
         throwEmptyException();
         return first.getData();
     }

     private void throwEmptyException() throws EmptyListException {
         if (isEmpty())
             throw new EmptyListException("Sorted list is empty");
     }

     public int peekMax() throws EmptyListException {
         throwEmptyException();
         return last.getData();
     }

     public int removeMin() throws EmptyListException {
         throwEmptyException();
         if (curSize != 1) {
             first = first.delNext();
             curSize--;
             return first.delPrev().getData();
         } else {
             Node temp = first;
             first = last = null;
             curSize--;
             return temp.getData();
         }
     }

     public int removeMax() throws EmptyListException {
         throwEmptyException();
         if (curSize != 1) {
             last = last.delPrev();
             curSize--;
             return last.delNext().getData();
         } else {
             Node temp = last;
             first = last = null;
             curSize--;
             return temp.getData();
         }
     }
}
