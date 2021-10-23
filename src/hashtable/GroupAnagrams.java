package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author raychong
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);
            List<String> group = groups.getOrDefault(sortedKey, new ArrayList<>());
            group.add(str);
            groups.put(sortedKey, group);
        }

        return new ArrayList<>(groups.values());
    }
}
