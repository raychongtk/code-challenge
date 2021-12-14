package array;

/**
 * @author raychong
 */
public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(new int[]{0, 1, 1, 0, 1, 1, 1, 0, 0, 1}));
    }

    private static int maxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentOne = 0;

        for (int num : nums) {
            if (num == 0) {
                currentOne = 0;
                continue;
            }

            max = Math.max(max, ++currentOne);
        }

        return max;
    }
}
