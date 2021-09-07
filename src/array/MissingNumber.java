package array;

/**
 * @author raychong
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumberV2(new int[]{3, 0, 1}));
    }

    private static int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result ^= i;
        }

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    private static int missingNumberV2(int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int current = nums[start];
            if (current < end && nums[start] != nums[current]) {
                nums[start] = nums[current];
                nums[current] = current;
            } else {
                start++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }

        return end;
    }
}
