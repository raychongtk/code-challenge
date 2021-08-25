package string;

/**
 * @author raychong
 */
public class StringCompression {
    public int compress(char[] chars) {
        char current = chars[0];
        int currentIndex = 0;
        int count = 0;

        for (char c : chars) {
            if (current == c) {
                count++;
            } else {
                chars[currentIndex] = current;
                if (count > 1) {
                    String totalCount = String.valueOf(count);
                    for (int i = 0; i < totalCount.length(); i++) {
                        chars[++currentIndex] = totalCount.charAt(i);
                    }
                }
                current = c;
                count = 1;
                currentIndex++;
            }
        }

        chars[currentIndex] = current;
        if (count > 1) {
            String totalCount = String.valueOf(count);
            for (int i = 0; i < totalCount.length(); i++) {
                chars[++currentIndex] = totalCount.charAt(i);
            }
        }

        return currentIndex + 1;
    }
}
