import java.util.Arrays;

/**
 * @author raychong
 */
public class FindLongestSubArrayBySum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findLongestSubArrayBySum(12, new int[]{1, 2, 3, 7, 5})));
        System.out.println(Arrays.toString(findLongestSubArrayBySum(15, new int[]{10, 5, 2, 7, 1, 9})));
        System.out.println(Arrays.toString(findLongestSubArrayBySum(15, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
        System.out.println(Arrays.toString(findLongestSubArrayBySum(15, new int[]{1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10})));
        System.out.println(Arrays.toString(findLongestSubArrayBySum(105, new int[]{10, 5, 2, 7, 1, 9})));
    }

    public static int[] findLongestSubArrayBySum(int s, int[] arr) {
        int[] result = new int[]{-1, -1};

        int start = 0;
        int currentSum = 0;
        int max = 0;

        for (int end = 0; end < arr.length; end++) {
            if (currentSum == s && end - start + 1 > max) {
                result[0] = start + 1;
                result[1] = end;
                max = end - start + 1;
            }

            currentSum += arr[end];
            if (currentSum > s) {
                currentSum -= arr[start++];
            }
        }

        return result;
    }
}
