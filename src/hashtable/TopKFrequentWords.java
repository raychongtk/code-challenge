package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author raychong
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> table = new TreeMap<>();
        List<String> result = new ArrayList<>();
        int max = 0;
        for (String word : words) {
            int value = table.getOrDefault(word, 0) + 1;
            table.put(word, value);
            max = Math.max(max, value);
        }

        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < max + 1; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        for (int i = max; i >= 0; i--) {
            if (buckets.get(i).isEmpty()) continue;
            for (String word : buckets.get(i)) {
                result.add(word);
                if (result.size() == k) return result;
            }
        }

        return result;
    }
}
