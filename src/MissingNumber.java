/**
 * @author raychong
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result ^= i;
        }

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
