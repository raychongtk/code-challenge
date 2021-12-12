package slidingwindow;

/**
 * @author raychong
 */
public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(maximumSubSubarrayOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3));
        System.out.println(maximumSubSubarrayOfSizeK(new int[]{2, 3, 4, 1, 5}, 2));
    }

    private static int maximumSubSubarrayOfSizeK(int[] nums, int k) {
        int currentSum = 0;
        int max = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            max = Math.max(max, currentSum);
            if (end - start == k - 1) {
                currentSum -= nums[start++];
            }
        }
        return max;
    }
}
