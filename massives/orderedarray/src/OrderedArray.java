import java.util.Arrays;

public class OrderedArray {

    private int[] orderedArray;

    private int curLength;

    private int length;

    public OrderedArray(int length) {
        this.length = length;
        curLength = 0;
        orderedArray = new int[length];
    }

    public void insert(int element) {
        if (curLength == length) {
            System.err.println("Ordered Array is full");
            System.exit(1);
        }
        int i = 0;
        for (; i < curLength; i++)
            if (orderedArray[i] >= element)
                break;
        if (i != curLength) {
            for (int j = curLength; j > i; j--)
                orderedArray[j] = orderedArray[j - 1];
            orderedArray[i] = element;
        } else
            orderedArray[curLength] = element;
        curLength++;
    }

    public int find(int element) {
        return find(element, 0, curLength - 1, (curLength - 1) / 2);
    }

    private int find(int element, int down, int up, int cur) {
        if (orderedArray[cur] == element)
            return cur;
        else if (down > up)
            return -1;
        else {
            if (orderedArray[cur] > element)
                return find(element, down, cur - 1, (cur - 1 + down) / 2);
            else
                return find(element, cur + 1, up, (cur + 1 + up) / 2);
        }
    }

    public void delete(int element) {
        int index;
        if ((index = find(element)) == -1) {
            System.err.println("The element " + element + " is not found");
            System.exit(1);
        }
        for (int i = index; i < curLength - 1; i++)
            orderedArray[i] = orderedArray[i + 1];
        curLength--;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('[');
        for (int i = 0; i < curLength; i++) {
            out.append(orderedArray[i]);
            if (i != curLength - 1) {
                out.append(", ");
            }
        }
        return out.append(']').toString();
    }
}
