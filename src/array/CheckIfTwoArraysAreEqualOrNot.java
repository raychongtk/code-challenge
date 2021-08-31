package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class CheckIfTwoArraysAreEqualOrNot {
    public static void main(String[] args) {
        System.out.println(isEquals(new int[]{1, 2, 8}, new int[]{2, 1, 8})); // true
        System.out.println(isEquals(new int[]{0, 2, 5, 1, 2, 23}, new int[]{2, 0, 1, 23, 5, 2})); // true
        System.out.println(isEquals(new int[]{2, 5, 1, 2}, new int[]{2, 0, 1, 2})); // false
        System.out.println(isEquals(new int[]{1, 2, 5, 4, 0}, new int[]{2, 4, 5, 0, 1})); // true
        System.out.println(isEquals(new int[]{1, 2, 5, 4, 0, 2, 1}, new int[]{2, 4, 5, 0, 1, 1, 2})); // true
        System.out.println(isEquals(new int[]{1, 7, 1}, new int[]{7, 7, 1})); // false
    }

    public static boolean isEquals(int[] array1, int[] array2) {
        if (array1.length != array2.length) return false;

        Map<Integer, Integer> table = new HashMap<>();
        for (int num : array1) {
            table.merge(num, 1, Integer::sum);
        }

        for (int num : array2) {
            Integer value = table.get(num);
            if (value == null) return false;
            if (value == 0) return false;
            table.put(num, value - 1);
        }

        return true;
    }
}
