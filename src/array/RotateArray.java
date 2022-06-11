package array;

/**
 * @author raychong
 */
public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
