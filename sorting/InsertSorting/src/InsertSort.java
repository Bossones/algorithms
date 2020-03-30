public final class InsertSort {

    public static int[] sort(int[] array) {
        int in;
        int temp;
        for (int i = 1; i < array.length; i ++) {
            in = i;
            temp = array[i];
            while (in > 0 && (array[in - 1] >= temp)) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = temp;
        }
        return array;
    }

    public static int[] noDups(int[] sortedArray) {
        int temp = sortedArray[0];
        int index = 0;
        int counterElem = 0;
        int count = 0;
        int i = 1;
        while (i < sortedArray.length - count) {
            if (temp == sortedArray[i]) {
                counterElem++;
            } else {
                if (counterElem != 0)
                {
                    for (int j = index + counterElem + 1; j < sortedArray.length - count; j++)
                        sortedArray[j - counterElem] = sortedArray[j];
                    i -= counterElem;
                    count += counterElem;
                    counterElem = 0;
                }
                temp = sortedArray[i];
                index = i;
            }
            i++;
        }
        count += counterElem;
        for (i = sortedArray.length - count; i < sortedArray.length; i++)
            sortedArray[i] = 0;
        return sortedArray;
    }
}
