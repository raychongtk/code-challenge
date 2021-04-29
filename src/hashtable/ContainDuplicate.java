package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class ContainDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = map.getOrDefault(num, 0);
            if (value > 0) return true;
            map.put(num, ++value);
        }
        return false;
    }
}
