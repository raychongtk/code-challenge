package stack;

/**
 * @author raychong
 */
public class MinStack {
    private Node root;

    public MinStack() {
    }

    public void push(int val) {
        if (root == null) {
            root = new Node(val, val, null);
        } else {
            root = new Node(val, Math.min(root.min, val), root);
        }
    }

    public void pop() {
        root = root.next;
    }

    public int top() {
        return root.val;
    }

    public int getMin() {
        return root.min;
    }

    private static class Node {
        private final int val;
        private final int min;
        private final Node next;

        public Node(int val, int min, Node node) {
            this.val = val;
            this.min = min;
            this.next = node;
        }
    }
}
