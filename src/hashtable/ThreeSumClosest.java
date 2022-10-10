package hashtable;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int bestDiff = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                if (diff < bestDiff) {
                    bestDiff = diff;
                    best = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return best;
    }
}
