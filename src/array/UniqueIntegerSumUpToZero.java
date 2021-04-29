package array;

/**
 * @author raychong
 */
public class UniqueIntegerSumUpToZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];

        int start = 1;
        for (int i = 0; i < n / 2; i++) {
            result[i] = start;
            result[n - i - 1] = -start;
            start++;
        }

        return result;
    }
}
