package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author raychong
 */
public class SingleNumber2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            int value = map.getOrDefault(num, 0) + 1;
            if (value > 1) {
                numbers.remove(num);
            } else {
                numbers.add(num);
            }
            map.put(num, value);
        }

        return numbers.iterator().next();
    }
}
