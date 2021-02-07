import java.util.Arrays;

/**
 * @author raychong
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    // [0,3,7,2,5,8,4,6,0,1] -> 9
    // [100,4,200,1,3,2] -> 4
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Arrays.sort(nums);

        int n = nums.length - 1;
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = nums[i + 1] - nums[i];
            if (sum == 0) continue;
            if (sum == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max + 1;
    }
}
