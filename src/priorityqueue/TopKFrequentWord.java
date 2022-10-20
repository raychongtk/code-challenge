package priorityqueue;

import java.util.*;

public class TopKFrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> table = new HashMap<>();
        for (String word : words) {
            table.put(word, table.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            int diff = b.getValue() - a.getValue();
            if (diff == 0) return a.getKey().compareTo(b.getKey());
            return diff;
        });
        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            priorityQueue.offer(entry);
        }

        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(priorityQueue.poll().getKey());
            k--;
        }

        return result;
    }
}
