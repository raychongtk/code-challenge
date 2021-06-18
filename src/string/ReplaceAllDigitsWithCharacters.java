package string;

/**
 * @author raychong
 */
public class ReplaceAllDigitsWithCharacters {
    public String replaceDigits(String s) {
        var builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                int shift = current - '0';
                builder.append((char) (s.charAt(i - 1) + shift));
            } else {
                builder.append(current);
            }
        }
        return builder.toString();
    }
}
