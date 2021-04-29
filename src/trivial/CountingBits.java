package trivial;

import java.util.Arrays;

/**
 * @author raychong
 */
public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int num) {
        int[] bits = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            bits[i] = Integer.toBinaryString(i).replace("0", "").length();
        }

        return bits;
    }
}
