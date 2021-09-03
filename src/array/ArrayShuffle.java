package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raychong
 */
public class ArrayShuffle {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        shuffleV2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // [1, 2, 3, 4]
    // [2, 1, 4, 3]
    private static void shuffle(int[] nums) {
        Queue<Integer> odd = new LinkedList<>();
        Queue<Integer> even = new LinkedList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.offer(num);
            } else {
                odd.offer(num);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even.poll();
            } else {
                nums[i] = odd.poll();
            }
        }
    }

    // [1, 2, 3, 4]
    // [2, 1, 4, 3]
    private static void shuffleV2(int[] nums) {
        int even = 0;
        int odd = 1;
        int size = nums.length;
        while (even < size && odd < size) {
            while (even < size && nums[even] % 2 == 0) {
                even += 2;
            }

            while (odd < size && nums[odd] % 2 == 1) {
                odd += 2;
            }

            if (even < size && odd < size) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
    }
}
