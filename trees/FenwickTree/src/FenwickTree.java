import java.util.Objects;

public class FenwickTree {

    private int[] arrayFenwick;

    private int[] prefixSum;

    public FenwickTree(int[] inputArray) {
        Objects.requireNonNull(inputArray, "Input array is null");
        createNewFenwickArray(inputArray);
    }

    public void createNewFenwickArray(int[] inputArray) {
        createPrefixSum(inputArray);
        arrayFenwick = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++)
            arrayFenwick[i] = sumRangePrefixArray(i & (i + 1), i + 1);
    }

    private void createPrefixSum(int[] inputArray) {
        prefixSum = new int[inputArray.length];
        prefixSum[0] = inputArray[0];
        for (int i = 1; i < inputArray.length; i++)
            prefixSum[i] = prefixSum[i - 1] + inputArray[i];
    }

    private int sumPrefixArray(int k) {
        if (k > prefixSum.length || k < 0 )
            throw new IllegalArgumentException();
        return (k == 0) ? prefixSum[k] : prefixSum[k - 1];
    }

    private int sumRangePrefixArray(int begin, int end) {
        if (end <= begin || begin < 0 || end > prefixSum.length)
            throw new IllegalArgumentException();
        return (begin == 0) ? sumPrefixArray(end) : prefixSum[end - 1] - prefixSum[begin - 1];
    }

    public int sum(int k) {
        if (k > arrayFenwick.length || k < 0)
            throw new IllegalArgumentException();
        int i = k - 1;
        int sum = 0;
        while (i >= 0) {
            sum += arrayFenwick[i];
            i = ((i + 1) & i) - 1;
        }
        return sum;
    }

    public int rangeSum(int begin, int end) {
        if (end <= begin || begin < 0 || end > arrayFenwick.length)
            throw new IllegalArgumentException();
        return (begin == 0) ? sum(end) : sum(end) - sum(begin);
    }

    public int get(int index) {
        indexException(index);
        return (index == 0) ? arrayFenwick[0] : sum(index + 1) - sum(index);
    }

    public void set(int index, int element) {
        indexException(index);
        addToElement(index, element - get(index));
    }

    public void addToElement(int index, int element) {
        while (index < arrayFenwick.length) {
            arrayFenwick[index] += element;
            index = (index + 1) | index;
        }
    }

    public int size() { return arrayFenwick.length; }

    private void indexException(int index) {
        if (index < 0 || index >= arrayFenwick.length)
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        FenwickTree fenwickTree = new FenwickTree(new int[] {1, 2, 3, 4});
        for (int i = 0; i < fenwickTree.size(); i++)
            System.out.println(fenwickTree.get(i));
        System.out.print("Sum k = 4 is: ");
        System.out.println(fenwickTree.sum(4));
        System.out.printf("Sum from 0 to 2 is: %d \n", fenwickTree.rangeSum(0, 2));
        fenwickTree.set(2, 500);
        System.out.println("Set new element to index 2, 500");
        for (int i = 0; i < fenwickTree.size(); i++)
            System.out.println(fenwickTree.get(i));
    }

}
