package trivial;

public class AddDigits {
    public int addDigits(int num) {
        while (true) {
            int current = 0;
            while (num > 0) {
                int digit = num % 10;
                num = num / 10;
                current += digit;
            }
            num = current;
            if (current >= 0 && current <= 9) return current;
        }
    }
}
