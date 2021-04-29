package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author raychong
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            if (numbers.contains(num)) {
                numbers.remove(num);
            } else {
                numbers.add(num);
            }
        }

        int[] result = new int[numbers.size()];
        int index = 0;
        for (Integer value : numbers) {
            result[index++] = value;
        }

        return result;
    }
}
