package string;

/**
 * @author raychong
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        int size = s.length();

        for (int i = 0; i < size; i++) {
            char current = s.charAt(i);
            int currentRomanInt = getRomanInt(current);
            if (i + 1 < size) {
                char next = s.charAt(i + 1);
                int nextRomanInt = getRomanInt(next);
                if (currentRomanInt < nextRomanInt) {
                    sum += nextRomanInt - currentRomanInt;
                    i++;
                } else {
                    sum += currentRomanInt;
                }
            } else {
                sum += currentRomanInt;
            }
        }

        return sum;
    }

    private int getRomanInt(char current) {
        if (current == 'I') return 1;
        if (current == 'V') return 5;
        if (current == 'X') return 10;
        if (current == 'L') return 50;
        if (current == 'C') return 100;
        if (current == 'D') return 500;
        if (current == 'M') return 1000;
        return -1;
    }
}
