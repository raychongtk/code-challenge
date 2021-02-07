import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            int majority = nums.length / 2;
            if (map.get(num) > majority) return num;
        }

        return -1;
    }
}
