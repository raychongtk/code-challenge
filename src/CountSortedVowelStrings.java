

/**
 * @author raychong
 */
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        return count(n, 0);
    }

    private int count(int n, int index) {
        if (n == 0) return 1;

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (i >= index) {
                cnt += count(n - 1, i);
            }
        }

        return cnt;
    }
}
