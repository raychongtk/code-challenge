package sort;

import java.util.Arrays;

/**
 * @author raychong
 */
public class CountingSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 1, 3, 0, 1, 0})));
        System.out.println(Arrays.toString(sort(new int[]{1, 4, 1, 2, 7, 5, 2})));
    }

    // assume data between 0 - 9
    private static int[] sort(int[] nums) {
        int[] count = new int[9];
        int[] sortedNums = new int[nums.length];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        for (int num : nums) {
            sortedNums[count[num] - 1] = num;
            count[num]--;
        }

        return sortedNums;
    }
}
