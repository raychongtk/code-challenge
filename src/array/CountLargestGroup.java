package array;

/**
 * @author raychong
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        if (n <= 9) return n;

        int[] groups = new int[100];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, ++groups[partitionGroup(i)]);
        }

        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (groups[i] == max) count++;
        }

        return count;
    }

    private int partitionGroup(int value) {
        int sum = 0;
        while (value > 0) {
            int remainder = value % 10;
            value = value / 10;
            sum += remainder;
        }
        return sum;
    }
}
