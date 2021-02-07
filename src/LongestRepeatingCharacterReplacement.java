/**
 * @author raychong
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    // ABAB, 2
    // 4
    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];

        int max = 0;
        int maxCount = 0;
        int start = 0;
        int n = s.length();

        for (int end = 0; end < n; end++) {
            maxCount = Math.max(maxCount, ++map[s.charAt(end) - 'A']);
            if (end - start - maxCount + 1 > k) {
                map[s.charAt(start) - 'A']--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
