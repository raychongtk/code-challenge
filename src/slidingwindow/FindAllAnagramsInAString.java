package slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] anagramPattern = new int[26];
        for (char c : p.toCharArray()) {
            anagramPattern[c - 'a']++;
        }

        int start = 0;
        int windowSize = p.length() - 1;
        int[] anagramCandidate = new int[26];
        List<Integer> anagrams = new ArrayList<>();
        for (int end = 0; end < s.length(); end++) {
            anagramCandidate[s.charAt(end) - 'a']++;
            if (end - start >= windowSize) {
                if (isAnagram(anagramPattern, anagramCandidate)) anagrams.add(start);
                anagramCandidate[s.charAt(start++) - 'a']--;
            }
        }

        return anagrams;
    }

    private boolean isAnagram(int[] anagramPattern, int[] anagramCandidate) {
        for (int i = 0; i < 26; i++) {
            if (anagramPattern[i] != anagramCandidate[i]) return false;
        }
        return true;
    }
}
