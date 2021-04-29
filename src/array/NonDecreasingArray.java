package array;

/**
 * @author raychong
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{5, 7, 1, 8}));
    }

    // left == 0   mean first element needs to shift and count only has one
    // [5,7,1,8]   nums[left] <= nums[left + 2]
    // [3,4,2,3]   nums[left + 1] >= nums[left - 1]
    // [1,2,4,5,3] left == nums.length - 2
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        int left = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                count++;
            }
            if (count > 1) return false;
        }

        return left == 0 || left == nums.length - 2 || nums[left + 1] >= nums[left - 1] || nums[left] <= nums[left + 2];
    }
}
