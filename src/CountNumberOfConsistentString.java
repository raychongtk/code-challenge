/**
 * @author raychong
 */
public class CountNumberOfConsistentString {
    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int[] map = new int[26];
        for (char c : allowed.toCharArray()) {
            map[c - 'a']++;
        }

        int count = 0;
        for (String word : words) {
            boolean consistent = true;
            for (char c : word.toCharArray()) {
                if (map[c - 'a'] == 0) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) count++;
        }

        return count;
    }
}
