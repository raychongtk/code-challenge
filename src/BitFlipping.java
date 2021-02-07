import java.util.Arrays;

/**
 * @author raychong
 */
public class BitFlipping {
    public static void main(String[] args) {
        System.out.println(bitFlipping(1, "01011"));
    }

    // given a string that formed by 0 and 1,
    // e.g 01011, with bits 00000 and starting from index 1
    // calculate the smallest flipping count that makes the input become 01011
    public static int bitFlipping(int start, String bits) {
        int[] originBits = new int[bits.length()];
        int[] flippedBits = new int[bits.length()];

        for (int i = 0; i < bits.length(); i++) {
            originBits[i] = bits.charAt(i) - '0';
        }

        int counter = 0;
        for (int i = start; i < flippedBits.length; i++) {
            for (int j = i; j < flippedBits.length; j++) {
                if (flippedBits[j] == 0) {
                    flippedBits[j] = 1;
                } else {
                    flippedBits[j] = 0;
                }
            }
            counter++;
            if (Arrays.equals(flippedBits, originBits)) return counter;
        }

        return -1;
    }
}
