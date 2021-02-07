/**
 * @author raychong
 */
public class FindLuckyInteger {
    // [2,2,3,4]
    // 2
    public int findLucky(int[] arr) {
        int[] map = new int[500];
        int max = -1;

        for (int num : arr) {
            map[num]++;
        }

        for (int i = map.length - 1; i > 0; i--) {
            if (map[i] == i) return i;
        }

        return max;
    }
}
