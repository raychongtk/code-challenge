package hashtable;

/**
 * @author raychong
 */
public class FindFirstUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] map = new int[26];

        char[] chars = s.toCharArray();
        for (char c : chars) {
            map[c - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i] - 'a'] == 1) return i;
        }

        return -1;
    }
}
