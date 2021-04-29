package array;

/**
 * @author raychong
 */
public class MaxSubArrays {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArrayV2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    // -2,1,-3,4,-1,2,1,-5,4
    // -2
    // -2 1
    // -2 1 -3
    // ...
    // 1
    // 1 -3
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static int maxSubArrayV2(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int index = 0;
        int[] map = new int[(n * (n + 1)) / 2];

        for (int i = 0; i < nums.length; i++) {
            map[index] = nums[i];
            max = Math.max(max, nums[i]);
            index++;
            for (int j = i + 1; j < nums.length; j++) {
                map[index] = nums[j] + map[index - 1];
                max = Math.max(max, map[index]);
                index++;
            }
        }

        return max;
    }
}
