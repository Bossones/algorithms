public class Main {

    public static void main(String[] args) throws EmptyListException {

        Dec dec = new Dec(10);
        for (int i = 1; i <= 10; i++)
            dec.insertLast(i);
        System.out.println("This is Dec");
        while (!dec.isEmpty())
            System.out.println(dec.removeFirst());
        System.out.println("==============================");

        Queue queue = new Queue(10);
        for (int i = 1; i <= 10; i++)
            queue.insert(i);
        System.out.println("This is Queue");
        while (!queue.isEmpty())
            System.out.println(queue.delete());
        System.out.println("==============================");

        Stack stack = new Stack(10);
        for (int i = 1; i <= 10; i++)
            stack.add(i);
        System.out.println("This is Stack");
        while (!stack.isEmpty())
            System.out.println(stack.remove());
        System.out.println("==============================");

        SortedList sl = new SortedList(10);
        for (int i = 10; i > 0; i -=2 )
            sl.insert(i);
        sl.insert(-5);
        sl.insert(7);
        sl.insert(12);
        System.out.println("This is Sorted List");
        while (!sl.isEmpty())
            System.out.println(sl.removeMin());

    }
}
/*
    Output:
        This is Dec
        1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        ==============================
        This is Queue
        1
        2
        3
        4
        5
        6
        7
        8
        9
        10
        ==============================
        This is Stack
        10
        9
        8
        7
        6
        5
        4
        3
        2
        1
        ==============================
        This is Sorted List
        -5
        2
        4
        6
        7
        8
        10
        12
 */
