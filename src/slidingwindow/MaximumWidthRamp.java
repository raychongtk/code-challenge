package slidingwindow;

/**
 * @author raychong
 */
public class MaximumWidthRamp {
    // keep finding the max number from right to left
    // use sliding window algorithm to scan whether the current start is less than or equals to the current end
    // calculate the max width each iteration
    public int maxWidthRamp(int[] nums) {
        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int start = 0;
        int max = 0;
        for (int end = 1; end < nums.length; end++) {
            if (nums[start] > rightMax[end]) {
                start++;
            }

            max = Math.max(max, end - start);
        }

        return max;
    }
}
