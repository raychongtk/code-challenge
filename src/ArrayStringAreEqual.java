/**
 * @author raychong
 */
public class ArrayStringAreEqual {
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"a", "bc"}, new String[]{"ab", "c"}));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a = String.join("", word1);
        String b = String.join("", word2);
        return a.equals(b);
    }
}
