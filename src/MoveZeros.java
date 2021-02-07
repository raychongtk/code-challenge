/**
 * @author raychong
 */
public class MoveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public static void moveZeroes(int[] nums) {
        int zero = 0;
        for (int num : nums) {
            if (num == 0) zero++;
        }

        while (zero > 0) {
            for (int i = 0; i <= nums.length - 2; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[i] + nums[i + 1];
                    nums[i + 1] = nums[i] - nums[i + 1];
                    nums[i] = nums[i] - nums[i + 1];
                }
            }
            zero--;
        }
    }
}
