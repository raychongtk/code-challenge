package string;

/**
 * @author raychong
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ab"));
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            boolean isLeftAlphaNumeric = Character.isLetterOrDigit(s.charAt(i));
            boolean isRightAlphaNumeric = Character.isLetterOrDigit(s.charAt(j));
            if (isLeftAlphaNumeric && isRightAlphaNumeric) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
                i++;
                j--;
            } else if (!isLeftAlphaNumeric) {
                i++;
            } else {
                j--;
            }
        }

        return true;
    }
}
