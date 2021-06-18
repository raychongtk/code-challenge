package string;

/**
 * @author raychong
 */
public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        var builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ' ') count++;
            if (count == k) break;
            builder.append(current);
        }
        return builder.toString();
    }
}
