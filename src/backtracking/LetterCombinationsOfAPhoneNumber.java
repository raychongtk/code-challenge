package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author raychong
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return List.of();

        Map<Character, List<String>> candidates = letterCandidates();

        List<List<String>> possibleCandidates = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            possibleCandidates.add(candidates.get(c));
        }

        List<String> result = new ArrayList<>();
        backtrack(result, possibleCandidates, new StringBuilder(), digits.length(), 0);
        return result;
    }

    private Map<Character, List<String>> letterCandidates() {
        Map<Character, List<String>> candidates = new HashMap<>();
        candidates.put('2', List.of("a", "b", "c"));
        candidates.put('3', List.of("d", "e", "f"));
        candidates.put('4', List.of("g", "h", "i"));
        candidates.put('5', List.of("j", "k", "l"));
        candidates.put('6', List.of("m", "n", "o"));
        candidates.put('7', List.of("p", "q", "r", "s"));
        candidates.put('8', List.of("t", "u", "v"));
        candidates.put('9', List.of("w", "x", "y", "z"));
        return candidates;
    }

    private void backtrack(List<String> result, List<List<String>> possibleCandidates, StringBuilder candidate, int length, int index) {
        if (candidate.length() == length) {
            result.add(candidate.toString());
            return;
        }

        for (int i = 0; i < possibleCandidates.get(index).size(); i++) {
            candidate.append(possibleCandidates.get(index).get(i));
            backtrack(result, possibleCandidates, candidate, length, index + 1);
            candidate.setLength(candidate.length() - 1);
        }
    }
}
