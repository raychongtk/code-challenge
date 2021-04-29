package string;

/**
 * @author raychong
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        var builder = new StringBuilder("1");
        while (n > 1) {
            int count = 1;
            String value = builder.toString();
            builder.setLength(0);

            char c = value.charAt(0);
            for (int j = 1; j < value.length(); j++) {
                if (value.charAt(j) == c) {
                    count++;
                } else {
                    builder.append(count).append(c);
                    count = 1;
                }
                c = value.charAt(j);
            }

            builder.append(count).append(c);
            n--;
        }

        return builder.toString();
    }
}
