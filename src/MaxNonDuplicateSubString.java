import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class MaxNonDuplicateSubString {
    public static void main(String[] args) {
        System.out.println(maxNonDuplicateSubString("abcdabcdeaaa"));
    }

    // abcabcaaa
    public static int maxNonDuplicateSubString(String text) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < text.length(); end++) {
            char key = text.charAt(end);
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) > 1) {
                map.put(key, map.getOrDefault(key, 0) - 1);
                start++;
            }

            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
