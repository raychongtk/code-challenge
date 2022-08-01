package slidingwindow;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] table = new int[26];
        int start = 0;
        int windowSize = s1.length() - 1;
        int[] frequencies = getFrequency(s1);

        for (int end = 0; end < s2.length(); end++) {
            table[s2.charAt(end) - 'a']++;
            if (end - start == windowSize) {
                boolean match = true;
                for (int i = 0; i < 26; i++) {
                    int frequency = frequencies[i];
                    if (frequency == 0) continue;

                    if (table[i] < frequency) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
                table[s2.charAt(start++) - 'a']--;
            }
        }
        return false;
    }

    private int[] getFrequency(String str) {
        int[] frequencies = new int[26];
        for (char c : str.toCharArray()) {
            frequencies[c - 'a']++;
        }
        return frequencies;
    }
}
