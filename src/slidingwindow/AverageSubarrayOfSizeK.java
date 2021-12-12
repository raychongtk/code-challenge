package slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class AverageSubarrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(averageSubarray(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));
    }

    private static List<Double> averageSubarray(int[] nums, int k) {
        List<Double> averageSubarray = new ArrayList<>();
        int currentSum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            if (end - start == k - 1) {
                averageSubarray.add((currentSum * 1.0) / k);
                currentSum -= nums[start++];
            }
        }
        return averageSubarray;
    }
}
