package hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"badc", "abab", "dddd", "dede", "yyxx"}, "baba"));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            int[] patterns = new int[26];
            int[] wordPattern = new int[26];
            boolean matched = true;
            for (int i = 0; i < word.length(); i++) {
                if (patterns[pattern.charAt(i) - 'a'] != wordPattern[word.charAt(i) - 'a']) {
                    matched = false;
                    break;
                } else {
                    patterns[pattern.charAt(i) - 'a']++;
                    wordPattern[word.charAt(i) - 'a']++;
                }
            }

            if (matched) result.add(word);
        }

        return result;
    }
}
