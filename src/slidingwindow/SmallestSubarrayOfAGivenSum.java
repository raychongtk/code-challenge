package slidingwindow;

/**
 * @author raychong
 */
public class SmallestSubarrayOfAGivenSum {
    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
    }

    private static int findMinSubArray(int S, int[] arr) {
        int minSize = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];
            while (currentSum >= S) {
                minSize = Math.min(minSize, end - start + 1);
                currentSum -= arr[start++];
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
