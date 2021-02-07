/**
 * @author raychong
 */
public class MissingNumberCyclicSort {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int j = nums[i];

            if (j < n && j != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) return nums[j];
        }

        return -1;
    }
}
