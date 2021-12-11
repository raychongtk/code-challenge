package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class LargestUniqueValue {
    public static void main(String[] args) {
        System.out.println(largestUniqueValue(new int[]{1, 2, 9, 4, 8, 9}));
        System.out.println(largestUniqueValue(new int[]{4, 9, 2, 9}));
        System.out.println(largestUniqueValue(new int[]{8, 1, 10, 1, 4, 8, 4, 10}));
        System.out.println(largestUniqueValue(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1}));
        System.out.println(largestUniqueValue(new int[]{9, 9, 8, 8}));
    }

    private static int largestUniqueValue(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        int max = -1;
        for (int num : nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getValue() == 1 && entry.getKey() > max) {
                max = entry.getKey();
            }
        }

        return max;
    }
}
