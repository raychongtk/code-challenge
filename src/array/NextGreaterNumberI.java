package array;

import java.util.Arrays;
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
        Arrays.fill(result, -1);

        for (int i = 0; i < nums1.length; i++) {
            table.put(nums1[i], i);
        }

        stack.push(nums2[0]);
        for (int j = 1; j < nums2.length; j++) {
            while (!stack.isEmpty() && nums2[j] > stack.peek()) {
                int top = stack.pop();
                if (table.containsKey(top)) {
                    result[table.get(top)] = nums2[j];
                }
            }
            stack.push(nums2[j]);
        }

        return result;
    }
}
