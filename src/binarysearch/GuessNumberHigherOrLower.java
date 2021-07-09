package binarysearch;

/**
 * @author raychong
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int ans = guess(mid);
            if (ans == 0) {
                return mid;
            } else if (ans == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private int guess(int num) {
        // PROVIDED BY LEETCODE
        return -1;
    }
}
