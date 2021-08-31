package array;

/**
 * @author raychong
 */
public class MoveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
