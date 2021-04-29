package array;

/**
 * @author raychong
 */
public class JumpGame {
    // brute force T_T
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int possibleRange = nums[start];

            if (possibleRange + start >= end) return true;

            int maxJump = 0;
            int index = 0;
            int zero = 0;
            for (int i = start + 1; i < start + possibleRange + 1; i++) {
                if (nums[i] == 0) zero++;
                if (zero == maxJump) {
                    maxJump = 0;
                    index = 0;
                }
                if (nums[i] >= maxJump) {
                    maxJump = nums[i];
                    index = i;
                }
            }

            if (maxJump == 0) return false;

            start = index;

            if (start >= end) return true;
        }

        return false;
    }
}
