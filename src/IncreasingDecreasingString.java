/**
 * @author raychong
 */
public class IncreasingDecreasingString {
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
    }

    public static String sortString(String s) {
        int[] ascii = new int[26];
        var builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            ascii[c - 'a']++;
        }

        while (builder.length() < s.length()) {
            for (int i = 0; i < ascii.length; i++) {
                if (ascii[i] != 0) {
                    builder.append((char) (i + 'a'));
                    ascii[i]--;
                }
            }

            for (int i = ascii.length - 1; i >= 0; i--) {
                if (ascii[i] != 0) {
                    builder.append((char) (i + 'a'));
                    ascii[i]--;
                }
            }
        }

        return builder.toString();
    }
}
