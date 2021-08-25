package string;

/**
 * @author raychong
 */
public class StringCompression {
    public int compress(char[] chars) {
        int i = 0, j = 0;

        while (j < chars.length) {
            int count = 0;
            char current = chars[j];
            while (j < chars.length && current == chars[j]) {
                count++;
                j++;
            }

            chars[i++] = current;

            if (count > 1) {
                char[] counts = String.valueOf(count).toCharArray();
                for (char c : counts) {
                    chars[i++] = c;
                }
            }
        }

        return i;
    }
}
