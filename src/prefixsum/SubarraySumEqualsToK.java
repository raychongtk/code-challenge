package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class SubarraySumEqualsToK {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prefixSum[i] - prefixSum[j] == k) count++;
            }
        }

        return count;
    }

    public int subarraySumV2(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int expected = sum - k;
            if (prefixSum.containsKey(expected)) {
                count += prefixSum.get(expected);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
