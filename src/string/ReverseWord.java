package string;

/**
 * @author raychong
 */
public class ReverseWord {
    public String reverseWords(String s) {
        var builder = new StringBuilder();
        char prev = '\0';
        for (char c : s.strip().toCharArray()) {
            if (c == ' ' && prev == ' ') continue;
            prev = c;
            builder.append(c);
        }

        char[] chars = builder.toString().toCharArray();

        reverse(chars, 0, chars.length - 1);

        int start = 0;
        for (int end = 0; end < chars.length; end++) {
            if (chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }

        reverse(chars, start, chars.length - 1);

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        int low = start;
        int high = end;

        while (low < high) {
            char c = chars[low];
            chars[low++] = chars[high];
            chars[high--] = c;
        }
    }
}
