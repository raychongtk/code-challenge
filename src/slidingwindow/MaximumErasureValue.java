package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author raychong
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int start = 0;
        int max = 0;
        int currentSum = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            if (!set.add(nums[end])) {
                while (set.contains(nums[end])) {
                    int num = nums[start++];
                    currentSum -= num;
                    set.remove(num);
                }
                set.add(nums[end]);
            }

            max = Math.max(max, currentSum);
        }

        return max;
    }
}
