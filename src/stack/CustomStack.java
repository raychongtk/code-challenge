package stack;

/**
 * @author raychong
 */
public class CustomStack {
    private final int[] stack;
    private final int maxSize;
    private int currentSize = 0;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (currentSize == maxSize) return;
        stack[currentSize++] = x;
    }

    public int pop() {
        if (currentSize == 0) return -1;
        int value = stack[currentSize--];
        stack[currentSize] = -1;
        return value;
    }

    public void increment(int k, int val) {
        int updateCount = k;
        if (currentSize > k) updateCount = currentSize;
        for (int i = 0; i < updateCount; i++) {
            stack[i] = stack[i] + val;
        }
    }
}
