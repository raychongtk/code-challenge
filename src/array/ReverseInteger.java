package array;

/**
 * @author raychong
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(550));
        System.out.println(reverse(-73));
    }

    public static int reverse(int num) {
        long reversedNum = 0;

        while (num != 0) {
            int remainder = num % 10;
            num = num / 10;
            reversedNum = reversedNum * 10 + remainder;
        }

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) return 0;
        return (int) reversedNum;
    }
}
