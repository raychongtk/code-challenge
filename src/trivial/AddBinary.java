package trivial;

import java.math.BigInteger;

/**
 * @author raychong
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinaryV2("11", "1"));
    }

    public static String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }

    public static String addBinaryV2(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        var result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) carry += s1.charAt(i--) - '0';
            if (j >= 0) carry += s2.charAt(j--) - '0';
            result.insert(0, carry % 2);
            carry /= 2;
        }

        return result.toString();
    }
}
