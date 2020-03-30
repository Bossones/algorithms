import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(OddEvenSort.sort(new int[] {3, 1 ,2, 4, 2, 1, 6, 7})));
        System.out.println(Arrays.toString(OddEvenSort.sort(new int[] {3, 1 ,2, 4, 2, 1, 6, 7, -2, -4, 5, 1, 3, 21, 23, 14, 11, -100, -10, -6, 1, -1, -1, -2})));
    }
}
/*
    output:
        [1, 1, 2, 2, 3, 4, 6, 7]
        [-100, -10, -6, -4, -2, -2, -1, -1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 11, 14, 21, 23]
 */
