package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author raychong
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    // Input: pattern = "abba", s = "dog cat cat dog"
    // Output: true
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        String[] patterns = new String[26];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            if (patterns[index] == null) {
                if (set.contains(words[i])) return false;
                patterns[index] = words[i];
                set.add(words[i]);
            } else if (!patterns[index].equals(words[i])) {
                return false;
            }
        }

        return true;
    }
}
