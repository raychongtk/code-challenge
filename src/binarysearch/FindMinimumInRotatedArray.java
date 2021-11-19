package binarysearch;

/**
 * @author raychong
 */
public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            min = Math.min(min, nums[mid]);
        }

        return min;
    }
}
