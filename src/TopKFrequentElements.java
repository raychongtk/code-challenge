import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author raychong
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> table = new HashMap<>();
        Map<Integer, Set<Integer>> table2 = new TreeMap<>(Comparator.reverseOrder());
        int[] result = new int[k];

        for (int num : nums) {
            int value = table.getOrDefault(num, 0) + 1;
            table.put(num, value);

            if (value > 1) table2.get(value - 1).remove(num);
            table2.computeIfAbsent(value, t -> new HashSet<>()).add(num);
        }

        int insertIndex = 0;
        for (Set<Integer> set : table2.values()) {
            for (Integer value : set) {
                result[insertIndex++] = value;
            }
            if (insertIndex >= k) break;
        }

        return result;
    }
}
