import java.util.Arrays;

/**
 * @author raychong
 */
public class ReturnSumOfArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
    }

    public static int[] runningSum(int[] nums) {
        int sum = 0;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            newNums[i] = sum;
        }
        return newNums;
    }
}
