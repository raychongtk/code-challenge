package array;

/**
 * @author raychong
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    // [1,1,0,1,1,1]
    // output: 3
    public static int longestOnes(int[] nums) {
        int max = 0;
        int one = 0;

        for (int num : nums) {
            if (num == 0) {
                one = 0;
            } else {
                one++;
                max = Math.max(max, one);
            }
        }

        return max;
    }
}
