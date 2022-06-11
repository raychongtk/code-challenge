package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class MinimumOperationsToReduceXToZero {
    // total sum - x
    // find the length of total sum - x
    public int minOperations(int[] nums, int x) {
        int targetSum = -x;

        for (int num : nums) {
            targetSum += num;
        }

        if (targetSum == 0) return nums.length;

        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, -1);

        int currentSum = 0;
        int size = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (hash.containsKey(currentSum - targetSum)) {
                size = Math.max(size, i - hash.get(currentSum - targetSum));
            }
            hash.put(currentSum, i);
        }

        return size == Integer.MIN_VALUE ? -1 : nums.length - size;
    }
}
