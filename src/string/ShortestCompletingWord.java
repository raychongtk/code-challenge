package string;

/**
 * @author raychong
 */
public class ShortestCompletingWord {
    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                map[Character.toLowerCase(c) - 'a']++;
            }
        }

        String result = "";
        int max = 0;
        for (String word : words) {
            int count = 0;
            int[] lookup = new int[26];
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                lookup[c]++;
                if (map[c] > 0 && map[c] >= lookup[c]) count++;
            }

            if (count > max) {
                max = count;
                result = word;
            } else if (count == max && word.length() < result.length()) {
                result = word;
            }
        }

        return result;
    }
}
