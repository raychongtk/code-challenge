/**
 * @author raychong
 */
public class MaximumHoliday {
    public static void main(String[] args) {
        System.out.println(maximumHoliday(new int[]{0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1}, 9));
    }

    // 0000011, pto=2
    // output 4, 0001111
    public static int maximumHoliday(int[] holidays, int pto) {
        int max = 0;
        int zero = 0;
        int start = 0;
        for (int end = 0; end < holidays.length; end++) {
            if (holidays[end] == 0) zero++;
            if (zero > pto && holidays[start++] == 0) zero--;
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
