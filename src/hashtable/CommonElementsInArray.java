package hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author raychong
 */
public class CommonElementsInArray {
    public static void main(String[] args) {
        System.out.println(commonElements(new int[]{4, 7, 3, 9, 2}, new int[]{3, 2, 12, 9, 40, 32, 4}));
    }

    public static List<Integer> commonElements(int[] num1, int[] num2) {
        List<Integer> elements = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : num1) {
            set.add(num);
        }

        for (int num : num2) {
            if (set.contains(num)) {
                elements.add(num);
            }
        }

        return elements;
    }
}
