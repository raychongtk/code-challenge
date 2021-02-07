/**
 * @author raychong
 */
public class MinStack {
    private final int[] stack;
    private int min = Integer.MAX_VALUE;
    private int index = 0;

    public MinStack() {
        stack = new int[10000];
    }

    public void push(int x) {
        stack[index++] = x;
        min = Math.min(min, x);
    }

    public void pop() {
        index--;
        int value = stack[index];
        stack[index] = 0;
        if (value == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < index; i++) {
                min = Math.min(min, stack[i]);
            }
        }
    }

    public int top() {
        return stack[index - 1];
    }

    public int getMin() {
        return min;
    }
}
