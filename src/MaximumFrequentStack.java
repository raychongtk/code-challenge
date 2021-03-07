import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author raychong
 */
public class MaximumFrequentStack {
    private final Map<Integer, Integer> frequencyTable;
    private final List<Stack<Integer>> buckets;

    public MaximumFrequentStack() {
        frequencyTable = new HashMap<>();
        buckets = new ArrayList<>();
    }

    public void push(int val) {
        int value = frequencyTable.getOrDefault(val, 0) + 1;
        frequencyTable.put(val, value);

        if (value > buckets.size()) {
            buckets.add(new Stack<>());
        }

        buckets.get(value - 1).push(val);
    }

    public int pop() {
        int maxFreq = buckets.size();
        Integer key = buckets.get(maxFreq - 1).pop();
        if (buckets.get(maxFreq - 1).isEmpty()) buckets.remove(maxFreq - 1);
        frequencyTable.put(key, frequencyTable.get(key) - 1);
        if (frequencyTable.get(key) == 0) frequencyTable.remove(key);
        return key;
    }
}
