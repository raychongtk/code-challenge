package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class FindMostFrequentElementInAnArray {
    // https://www.geeksforgeeks.org/frequent-element-array/
    public static void main(String[] args) {
        System.out.println(findMostFrequentElement(new int[]{2, 12, 1, 2, 8, 2, 2, 1, 8, 2})); // 2
        System.out.println(findMostFrequentElement(new int[]{1, 9, 1, 1, 2})); // 1
        System.out.println(findMostFrequentElement(new int[]{1, 9, 2, 1, 2})); // 1
        System.out.println(findMostFrequentElement(new int[]{1, 3, 2, 1, 4, 1})); // 1
        System.out.println(findMostFrequentElement(new int[]{10, 20, 10, 20, 30, 20, 20})); // 20
    }

    public static int findMostFrequentElement(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        int mostFrequent = -1;
        int maxFrequency = -1;

        for (int num : nums) {
            int frequency = table.getOrDefault(num, 0) + 1;

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequent = num;
            }

            table.put(num, frequency);
        }

        return mostFrequent;
    }
}
