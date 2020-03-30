import java.util.Objects;

public final class TwoModBubbleSort {

    public static int[] sort(int[] array) {
        Objects.requireNonNull(array);
        int temp;
        int in;
        for (int out = array.length - 1, start = 0; out > 0 && start < out; out--, start++) {
            for (in = start; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
            }
            for (; in > start; in--) {
                if (array[in - 1] > array[in]) {
                    temp = array[in];
                    array[in] = array[in - 1];
                    array[in - 1] = temp;
                }
            }
        }
        return array;
    }

    public static double median(int[] array) {
        int[] sortArray = TwoModBubbleSort.sort(array);
        return (sortArray.length % 2 == 0) ? (sortArray[array.length / 2] + sortArray[array.length / 2 - 1]) / (double)2 :
                sortArray[array.length / 2];
    }
}
