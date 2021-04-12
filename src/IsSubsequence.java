import java.util.Arrays;

/**
 * @author raychong
 */
public class IsSubsequence {
    // Input: s = "abc", t = "ahbgdc"
    // Output: true
    public boolean isSubsequence(String s, String t) {
        int indexT = 0;
        int n = s.length();
        int k = t.length();
        int[] table = new int[n];

        Arrays.fill(table, -1);
        for (int i = 0; i < n; i++) {
            for (int j = indexT; j < k; j++) {
                if (t.charAt(j) == s.charAt(i) && (i == 0 || table[i - 1] < j)) {
                    table[i] = j;
                    indexT = j;
                    break;
                }
            }
            if (table[i] == -1) return false;
        }

        return true;
    }
}
