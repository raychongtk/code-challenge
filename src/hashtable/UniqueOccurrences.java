package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author raychong
 */
public class UniqueOccurrences {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }

        for (Integer value : map.values()) {
            if (!set.add(value)) return false;
        }

        return true;
    }
}
