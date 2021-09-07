package prefixsum;

/**
 * @author raychong
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum[i] *= right;
            right *= nums[i];
        }
        return prefixSum;
    }
}
