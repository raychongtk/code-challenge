package sort;

/**
 * @author raychong
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public static int firstMissingPositive(int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int num = nums[start] - 1;

            if (num < end && num >= 0 && nums[start] != nums[num]) {
                int temp = nums[start];
                nums[start] = nums[num];
                nums[num] = temp;
            } else {
                start++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return end;
    }
}
