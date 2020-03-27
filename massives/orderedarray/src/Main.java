public class Main {

    public static void main(String[] args) {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(4);
        oa.insert(2);
        oa.insert(1);
        oa.insert(3);
        oa.insert(0);
        System.out.println(oa);
        System.out.println(oa.find(1223));
        oa.delete(1);
        System.out.println(oa);
        System.out.println(oa.find(2));
    }
}
