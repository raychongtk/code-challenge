package backtracking;

/**
 * @author raychong
 */
public class TargetSum {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, S, 0, 0);
        return count;
    }

    private static void backtrack(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            if (currentSum == target) count++;
            return;
        }

        int sum = currentSum;
        for (int j = 0; j < 2; j++) {
            if (j == 0) {
                sum += nums[index];
                backtrack(nums, target, index + 1, sum);
                sum -= nums[index];
            } else {
                sum += nums[index] * -1;
                backtrack(nums, target, index + 1, sum);
                sum += nums[index];
            }
        }
    }
}
