package string;

/**
 * @author raychong
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        int size = s.length() - 1;
        int count = 0;

        for (int i = size; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (count > 0) {
                return count;
            }
        }

        return count;
    }
}
