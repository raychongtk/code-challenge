package string;

/**
 * @author raychong
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        char[] charCount = new char[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        int result = 0;
        for (String word : words) {
            boolean canFormWord = true;
            char[] wordCount = new char[26];
            for (char c : word.toCharArray()) {
                if (charCount[c - 'a'] < ++wordCount[c - 'a']) {
                    canFormWord = false;
                    break;
                }
            }
            if (canFormWord) {
                result += word.length();
            }
        }

        return result;
    }
}
