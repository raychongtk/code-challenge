/**
 * @author raychong
 */
public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }

    // Input: A = 'abcde', B = 'cdeab'
    // Output: true
    public static boolean rotateString(String A, String B) {
        if (A.equals(B)) return true;

        var builder = new StringBuilder(A);
        for (int i = 0; i < A.length(); i++) {
            builder.deleteCharAt(0);
            builder.append(A.charAt(i));
            if (builder.toString().equals(B)) return true;
        }

        return false;
    }
}
