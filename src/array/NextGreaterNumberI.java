package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author raychong
 */
public class NextGreaterNumberI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> table = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            table.put(nums1[i], i);
        }

        stack.push(0);
        for (int j = 1; j < nums2.length; j++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[j]) {
                int top = stack.peek();
                stack.pop();
                if (table.containsKey(nums2[top])) {
                    result[table.get(nums2[top])] = nums2[j];
                }
            }

            stack.push(j);
        }

        while (!stack.isEmpty()) {
            int top = stack.peek();
            stack.pop();
            if (table.containsKey(nums2[top])) {
                result[table.get(nums2[top])] = -1;
            }
        }

        return result;
    }
}
