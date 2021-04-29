package array;

import java.util.Arrays;

/**
 * @author raychong
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    // Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    // Output: [1,2,2,3,5,6]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        if (nums1.length - m >= 0) {
            System.arraycopy(nums2, 0, nums1, m, nums1.length - m);
        }

        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
