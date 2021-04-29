package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author raychong
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(255));
    }

    /*
        Input: n = 19
        Output: true
        Explanation:
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 0^2 = 1
     */
    public static boolean isHappy(int n) {
        if (n == 1) return true;

        int num = n;
        Set<Integer> set = new HashSet<>();

        while (num > 1) {
            int x = num;
            int sum = 0;
            while (x > 0) {
                int remainder = x % 10;
                x = x / 10;
                sum += Math.pow(remainder, 2);
            }
            num = sum;
            if (num == 1) return true;
            if (set.contains(num)) break;
            set.add(num);
        }

        return false;
    }
}
