package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author raychong
 */
public class KeyboardRow {
    private final Map<Character, Integer> table = Map.ofEntries(
            Map.entry('q', 0),
            Map.entry('w', 0),
            Map.entry('e', 0),
            Map.entry('r', 0),
            Map.entry('t', 0),
            Map.entry('y', 0),
            Map.entry('u', 0),
            Map.entry('i', 0),
            Map.entry('o', 0),
            Map.entry('p', 0),
            Map.entry('a', 1),
            Map.entry('s', 1),
            Map.entry('d', 1),
            Map.entry('f', 1),
            Map.entry('g', 1),
            Map.entry('h', 1),
            Map.entry('j', 1),
            Map.entry('k', 1),
            Map.entry('l', 1),
            Map.entry('z', 2),
            Map.entry('x', 2),
            Map.entry('c', 2),
            Map.entry('v', 2),
            Map.entry('b', 2),
            Map.entry('n', 2),
            Map.entry('m', 2)
    );

    public String[] findWords(String[] words) {
        List<String> candidates = new ArrayList<>();
        for (String word : words) {
            int row = -1;
            boolean sameRow = true;
            for (char c : word.toCharArray()) {
                int currentRow = table.get(Character.toLowerCase(c));
                if (row == -1) row = currentRow;
                if (row != -1 && row != currentRow) {
                    sameRow = false;
                    break;
                }
            }

            if (sameRow) candidates.add(word);
        }

        String[] result = new String[candidates.size()];
        for (int i = 0; i < candidates.size(); i++) {
            result[i] = candidates.get(i);
        }

        return result;
    }
}
