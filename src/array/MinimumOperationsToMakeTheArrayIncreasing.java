package array;

/**
 * @author raychong
 */
public class MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i] += 1;
                count++;
            } else if (nums[i] < nums[i - 1]) {
                int temp = nums[i - 1] - nums[i] + 1;
                nums[i] += temp;
                count += temp;
            }
        }
        return count;
    }
}
