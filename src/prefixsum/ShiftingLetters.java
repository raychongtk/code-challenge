package prefixsum;

/**
 * @author raychong
 */
public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        var builder = new StringBuilder();
        int n = shifts.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = shifts[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = (suffixSum[i + 1] + shifts[i]) % 26;
        }

        for (int i = 0; i < suffixSum.length; i++) {
            int index = s.charAt(i) - 'a';
            builder.append((char) ((index + suffixSum[i]) % 26 + 97));
        }

        return builder.toString();
    }
}
