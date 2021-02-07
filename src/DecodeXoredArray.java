import java.util.Arrays;

/**
 * @author raychong
 */
public class DecodeXoredArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{1, 2, 3}, 1)));
    }

    // encoded[i] = arr[i] XOR arr[i + 1]
    // given first, arr[i+1] = encoded[i] XOR first
    public static int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;
        for (int i = 1; i <= encoded.length; i++) {
            decoded[i] = decoded[i - 1] ^ encoded[i - 1];
        }
        return decoded;
    }
}
