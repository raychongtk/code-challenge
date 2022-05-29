package array;

/**
 * @author raychong
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        boolean[][] table = new boolean[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                table[i][c - 'a'] = true;
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            int currentSize = words[i].length();
            for (int j = i + 1; j < words.length; j++) {
                int currentLength = currentSize * words[j].length();
                if (currentLength > max && !hasCommonCharacter(table[i], words[j])) {
                    max = currentLength;
                }
            }
        }

        return max;
    }

    private boolean hasCommonCharacter(boolean[] table, String word) {
        for (char c : word.toCharArray()) {
            if (table[c - 'a']) {
                return true;
            }
        }
        return false;
    }
}
