/**
 * @author raychong
 */
public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int[] data : grid) {
            count += binarySearch(data);
        }

        return count;
    }

    private int binarySearch(int[] data) {
        int start = 0;
        int end = data.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (data[mid] >= 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (data[mid] < 0) index = mid;
        }

        return index == -1 ? 0 : data.length - index;
    }
}
