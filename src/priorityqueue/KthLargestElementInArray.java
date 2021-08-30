package priorityqueue;

import java.util.PriorityQueue;

/**
 * @author raychong
 */
public class KthLargestElementInArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargestV2(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1);

        for (int num : nums) {
            priorityQueue.add(num);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.poll();
    }

    public static int findKthLargestV2(int[] nums, int k) {
        return kthLargestElement(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int pivotLoc = low;

        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[pivotLoc];
                nums[pivotLoc++] = temp;
            }
        }

        int temp = nums[high];
        nums[high] = nums[pivotLoc];
        nums[pivotLoc] = temp;

        return pivotLoc;
    }

    private static int kthLargestElement(int[] nums, int low, int high, int k) {
        int pos = partition(nums, low, high);

        if (pos == k - 1) {
            return nums[pos];
        }

        if (pos > k - 1) {
            return kthLargestElement(nums, low, pos - 1, k);
        }

        return kthLargestElement(nums, pos + 1, high, k);
    }
}
