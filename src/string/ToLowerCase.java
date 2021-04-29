package string;

/**
 * @author raychong
 */
public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("FuckYou"));
    }

    public static String toLowerCase(String str) {
        var builder = new StringBuilder();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                builder.append((char) (c + 32));
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
