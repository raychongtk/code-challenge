package tree;

import java.util.List;

/**
 * @author raychong
 */
public class MaxDepthOfNaryTree {
    private int maxLevel = 0;

    public int maxDepth(Node root) {
        if (root == null) return 0;
        return maxDepth(root, 0) + 1;
    }

    private int maxDepth(Node node, int level) {
        if (node == null) return 0;

        for (Node child : node.children) {
            maxDepth(child, level + 1);
        }

        if (level > maxLevel) maxLevel = level;

        return maxLevel;
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
