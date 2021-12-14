package array;

/**
 * @author raychong
 */
public class NoDuplicates {
    public static void main(String[] args) {
        System.out.println(noDuplicates(new int[]{1, 2, 2, 4, 4, 6, 8, 8}));
        System.out.println(noDuplicates(new int[]{1, 2, 3, 3}));
    }

    private static int noDuplicates(int[] arr) {
        int previous = -1;
        int index = 0;

        for (int num : arr) {
            if (num == previous) continue;

            previous = num;
            arr[index++] = num;
        }

        return index;
    }
}
