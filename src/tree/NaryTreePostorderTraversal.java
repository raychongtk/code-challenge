package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(result, root);
        return result;
    }

    private void postorder(List<Integer> result, Node node) {
        if (node == null) return;

        for (Node child : node.children) {
            postorder(result, child);
        }

        result.add(node.val);
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
