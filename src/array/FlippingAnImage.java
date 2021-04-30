package array;

/**
 * @author raychong
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] array : A) {
            int start = 0;
            int end = array.length - 1;

            while (start <= end) {
                int temp = array[start];
                array[start++] = array[end] == 1 ? 0 : 1;
                array[end--] = temp == 1 ? 0 : 1;
            }
        }
        return A;
    }
}
