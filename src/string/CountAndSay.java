package string;

/**
 * @author raychong
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        result.append("1");
        for (int i = 1; i < n; i++) {
            char target = result.charAt(0);
            int currentCount = 1;
            for (int j = 1; j < result.length(); j++) {
                char current = result.charAt(j);
                if (current == target) {
                    currentCount++;
                } else {
                    builder.append(currentCount).append(target);
                    target = current;
                    currentCount = 1;
                }

            }
            builder.append(currentCount).append(target);
            result.setLength(0);
            result.append(builder);
            builder.setLength(0);
        }
        return result.toString();
    }
}
