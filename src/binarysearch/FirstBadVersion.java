package binarysearch;

/**
 * @author raychong
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    private boolean isBadVersion(int version) {
        // PROVIDED BY LEETCODE
        return true;
    }

    private int binarySearch(int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end + 1;
    }
}
