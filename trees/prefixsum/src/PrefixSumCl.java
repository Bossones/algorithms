import java.util.Objects;

public class PrefixSumCl {

    private int[] arrayPrefixSum;

    public PrefixSumCl(int[] inputArray) {
        setNewPrefixSum(inputArray);
    }

    public void setNewPrefixSum(int[] inputArray) {
        Objects.requireNonNull(inputArray, "Input array is null");
        arrayPrefixSum = new int[inputArray.length];
        arrayPrefixSum[0] = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            arrayPrefixSum[i] = arrayPrefixSum[i - 1] + inputArray[i];
        }
    }

    public int sum(int k) {
        if (k > arrayPrefixSum.length)
            throw new IllegalArgumentException("K is more than array length");
        return arrayPrefixSum[k - 1];
    }

    public int sumRange(int begin, int end) {
        if (end < begin)
            throw new IllegalArgumentException("End is less than begin");
        if (begin == 0)
            return sum(end);
        return arrayPrefixSum[end - 1] - arrayPrefixSum[begin - 1];
    }

    public int get(int index) {
        if (index >= arrayPrefixSum.length)
            throw new IllegalArgumentException("Index is more than array length");
        if (index == 0)
            return arrayPrefixSum[0];
        return arrayPrefixSum[index] - arrayPrefixSum[index - 1];
    }

    public void set(int index, int element) {
        if (index >= arrayPrefixSum.length || index < 0)
            throw new IllegalArgumentException();
        for (int i = arrayPrefixSum.length - 1; i >= index; i--) {
            arrayPrefixSum[i] = arrayPrefixSum[i] + (element - get(index));
        }
    }

    public int size() {
        return arrayPrefixSum.length;
    }

    public static void main(String[] args) {
        PrefixSumCl prefixSum = new PrefixSumCl(new int[] {4, 5, 6, 2, 1});
        System.out.println(prefixSum.get(2));
        System.out.println(prefixSum.sum(5));
        System.out.println(prefixSum.sumRange(0, 5));
        prefixSum.set(1, 10);
        for (int i = 0; i < prefixSum.size(); i++)
            System.out.println(prefixSum.get(i));
    }
}
