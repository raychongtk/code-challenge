import java.util.HashSet;
import java.util.Set;

/**
 * @author raychong
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abb");
    }

    public static int lengthOfLongestSubstring(String s) {
        int added = 0;
        int deleted = 0;
        int max = 0;
        char[] chars = s.toCharArray();

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.add(chars[added++])) {
                max = Math.max(max, added - deleted);
            } else {
                set.remove(chars[deleted++]);
            }
        }

        return max;
    }
}
