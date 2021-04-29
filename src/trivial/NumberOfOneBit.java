package trivial;

/**
 * @author raychong
 */
public class NumberOfOneBit {
    public static void main(String[] args) {
        System.out.println(hammingWeight(10));
    }

    public static int hammingWeight(int n) {
        String s = Integer.toUnsignedString(n, 2);
        int count = 0;
        for (char c : s.toCharArray()) {
            if ((c ^ '1') == 0) count++;
        }
        return count;
    }
}
