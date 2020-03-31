public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        for (int i = 23; i < 250; i++)
            queue.insert(i);
        for (int i = 1; i <= 5; i++)
            System.out.println(queue.peek());
        while (!queue.isEmpty())
            System.out.println(queue.delete());
    }
}
