import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class FindCommonCharacters {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
    }

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] common = new int[26];

        for (int i = 0; i < A[0].length(); i++) {
            common[A[0].charAt(i) - 'a']++;
        }

        for (int i = 1; i < A.length; i++) {
            int[] current = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                current[A[i].charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (current[j] < common[j]) common[j] = current[j];
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < common[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }
}
