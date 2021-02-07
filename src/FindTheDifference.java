/**
 * @author raychong
 */
public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("ae", "aea"));
    }

    public static char findTheDifference(String s, String t) {
        int[] map = new int[26];
        int[] map1 = new int[26];

        int length = Math.max(s.length(), t.length());
        for (int i = 0; i < length; i++) {
            if (i < s.length()) map[s.charAt(i) - 'a']++;
            if (i < t.length()) map1[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] != map1[i]) return (char) (i + 'a');
        }

        return 0;
    }
}
