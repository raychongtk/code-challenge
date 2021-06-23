package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author raychong
 */
public class QueueStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        QueueStack queueStack = new QueueStack();
        System.out.println(queueStack.isEmpty());
        System.out.println(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);
        queueStack.push(4);
        queueStack.push(5);

        System.out.println(queueStack.isEmpty());
        System.out.println(stack.isEmpty());
        System.out.println(queueStack);
        System.out.println(stack);
        System.out.println(queueStack.peek());
        System.out.println(stack.peek());
        System.out.println(queueStack.pop());
        System.out.println(stack.pop());
        System.out.println(queueStack);
        System.out.println(stack);
    }

    // implement a stack using a single queue
    private final Queue<Integer> queue;

    public QueueStack() {
        this.queue = new LinkedList<>();
    }

    // O(N)
    public void push(int value) {
        queue.offer(value);
        if (queue.size() > 1) {
            int index = 0;
            int currentSize = queue.size() - 1;
            while (index < currentSize) {
                queue.offer(queue.poll());
                index++;
            }
        }
    }

    public Integer pop() {
        return queue.poll();
    }

    public Integer peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "QueueStack{" +
                "queue=" + queue +
                '}';
    }
}
