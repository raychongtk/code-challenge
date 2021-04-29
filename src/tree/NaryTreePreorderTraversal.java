package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        return result;
    }

    private void preorder(List<Integer> result, Node node) {
        if (node == null) return;

        result.add(node.val);

        for (Node child : node.children) {
            preorder(result, child);
        }
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
