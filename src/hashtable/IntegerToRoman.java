package hashtable;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] numbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if (num < numbers[index]) {
                index++;
                continue;
            }
            builder.append(symbols[index]);
            num -= numbers[index];
        }

        return builder.toString();
    }
}
