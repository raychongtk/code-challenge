package string;

/**
 * @author raychong
 */
public class SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] seen = new boolean[26];

        for (char letter : letters) {
            seen[letter - 'a'] = true;
        }

        int index = (target - 'a') % 26;
        for (int i = 0; i < 26; i++) {
            if (seen[i] && i > index) return (char) (i + 'a');
        }

        return letters[0];
    }
}
