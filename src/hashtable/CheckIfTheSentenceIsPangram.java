package hashtable;

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        boolean[] letters = new boolean[26];
        for (char c : sentence.toCharArray()) {
            letters[c - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!letters[i]) return false;
        }

        return true;
    }
}
