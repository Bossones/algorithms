import java.util.Arrays;
import java.util.Objects;

public final class InertSortUtility {

    private InertSortUtility() {
        throw new IllegalStateException();
    }

    public static long[] sort(long[] array){
        Objects.requireNonNull(array);
        long temp;
        int in;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            in = i;
            while (in > 0 && (array[in - 1] >= temp) ) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = temp;
        }
        return array;
    }

    public static int[] sort(int[] array) {
        Objects.requireNonNull(array);
        int temp;
        int in;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            in = i;
            while (in > 0 && (array[in - 1] >= temp) ) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] mass = {4, 3, 1, 2, 5, 7, 6, 10};
        System.out.println(Arrays.toString(sort(mass)));
    }
}
