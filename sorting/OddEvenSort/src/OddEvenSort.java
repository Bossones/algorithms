public final class OddEvenSort {

    public static int[] sort(int[] array) {
        boolean isSorted = false;
        int temp;
        for (int n = 0; n < array.length; n++) {
            for (int k = (n % 2) == 0 ? 1 : 0; k < array.length - 1; k += 2) {
                if (array[k] > array[k + 1]) {
                    temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
        return array;
    }
}
