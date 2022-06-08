package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author raychong
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int start = 0;
        int longestCount = 0;
        char[] chars = s.toCharArray();
        for (int end = 0; end < chars.length; end++) {
            if (!set.add(chars[end])) {
                while (set.contains(chars[end])) {
                    set.remove(chars[start++]);
                }
                set.add(chars[end]);
            }

            longestCount = Math.max(longestCount, end - start + 1);
        }

        return longestCount;
    }
}
