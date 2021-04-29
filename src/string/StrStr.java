package string;

/**
 * @author raychong
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("aabcdef", "de"));
    }

    // Input: haystack = "hello", needle = "ll"
    // Output: 2
    public static int strStr(String haystack, String needle) {
        if (needle.isBlank()) return 0;

        int n = haystack.length();
        int windowSize = needle.length();
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (end - start + 1 == windowSize) {
                if (haystack.substring(start, end + 1).equals(needle)) {
                    return start;
                }
                start++;
            }
        }

        return -1;
    }
}
