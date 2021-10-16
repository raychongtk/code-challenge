package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author raychong
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> table = new HashMap<>();
        List<String> uncommon = new ArrayList<>();

        String[] parts1 = s1.split(" ");
        String[] parts2 = s2.split(" ");

        for (String part : parts1) {
            table.put(part, table.getOrDefault(part, 0) + 1);
        }

        for (String part : parts2) {
            table.put(part, table.getOrDefault(part, 0) + 1);
        }

        for (String key : table.keySet()) {
            if (table.get(key) == 1) {
                uncommon.add(key);
            }
        }

        String[] result = new String[uncommon.size()];
        for (int i = 0; i < uncommon.size(); i++) {
            result[i] = uncommon.get(i);
        }

        return result;
    }
}
