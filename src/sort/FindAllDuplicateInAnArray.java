package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class FindAllDuplicateInAnArray {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int j = nums[start] - 1;

            if (j < end && nums[start] != nums[j]) {
                int temp = nums[start];
                nums[start] = nums[j];
                nums[j] = temp;
            } else {
                start++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) result.add(nums[i]);
        }

        return result;
    }
}
