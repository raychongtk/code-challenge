package twopointer;

/**
 * @author raychong
 */
public class RemovePalindromeSubsequences {
    public int removePalindromeSub(String s) {
        int start = 0;
        int end = s.length() - 1;

        char[] chars = s.toCharArray();
        while (start < end) {
            if (chars[start] != chars[end]) {
                return 2;
            }

            start++;
            end--;
        }

        return 1;
    }
}
