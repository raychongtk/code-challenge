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
        int k = m + n - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if (nums1[m] < nums2[n]) {
                nums1[k--] = nums2[n--];
            } else {
                nums1[k--] = nums1[m--];
            }
        }

        while (n >= 0) {
            nums1[k--] = nums2[n--];
        }
        System.out.println(Arrays.toString(nums1));
    }
}
