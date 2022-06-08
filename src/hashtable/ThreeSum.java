package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author raychong
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    // Input: nums = [-1,0,1,2,-1,-4]
    // Output: [[-1,-1,2],[-1,0,1]]
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int currentSum = nums[start] + nums[end];

                if (currentSum == currentNumber) {
                    results.add(List.of(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                } else if (currentSum > currentNumber) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return results;
    }
}
