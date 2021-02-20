/**
 * @author raychong
 */
public class ReverseString2 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 3));
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, n - 1);

            while (start < end) {
                char left = chars[start];
                chars[start++] = chars[end];
                chars[end--] = left;
            }
        }

        return String.valueOf(chars);
    }
}
