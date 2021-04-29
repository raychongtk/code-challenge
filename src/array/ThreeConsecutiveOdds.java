package array;

/**
 * @author raychong
 */
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int odd = 0;

        for (int j : arr) {
            if (j % 2 == 0) {
                odd = 0;
            } else {
                odd++;
            }
            if (odd == 3) return true;
        }

        return false;
    }
}
