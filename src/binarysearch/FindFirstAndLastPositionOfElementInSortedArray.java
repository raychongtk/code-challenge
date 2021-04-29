package binarysearch;

/**
 * @author raychong
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int index = -1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (nums[mid] >= target) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

            if (nums[mid] == target) index = mid;
        }

        return index;
    }

    private int findLastPosition(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int index = -1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (nums[mid] <= target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }

            if (nums[mid] == target) index = mid;
        }

        return index;
    }
}
