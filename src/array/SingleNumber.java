package array;

/**
 * @author raychong
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
