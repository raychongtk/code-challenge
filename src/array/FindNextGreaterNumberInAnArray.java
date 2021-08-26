package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author raychong
 */
public class FindNextGreaterNumberInAnArray {
    // https://www.geeksforgeeks.org/next-greater-element/
    public static void main(String[] args) {
        // [5, 25, 25, -1, -1]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{4, 5, 2, 25, 10})));
        // [8, 8, 8, 12, 12, 15, 16, -1, 5, 5, -1]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{6, 4, 3, 8, 7, 12, 15, 16, 2, 1, 5})));
        // [5, 25, 25, -1]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{4, 5, 2, 25})));
        // [-1, 12, 12, -1]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{13, 7, 6, 12})));
        // [13, 21, -1, -1]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{11, 13, 21, 3})));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] results = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                results[stack.peek()] = nums[i];
                stack.pop();
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            results[stack.peek()] = -1;
            stack.pop();
        }

        return results;
    }
}
