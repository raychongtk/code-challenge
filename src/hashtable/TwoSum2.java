package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            Integer value = map.get(key);
            if (value != null) {
                return new int[]{value, i + 1};
            }
            map.put(numbers[i], i + 1);
        }

        return null;
    }
}
