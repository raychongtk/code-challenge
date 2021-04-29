package tree;

/**
 * @author raychong
 */
public class SumOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        return traverse(root, -1, -1);
    }

    private int traverse(TreeNode node, int parent, int current) {
        if (node == null) return 0;

        int grandparent = parent;
        parent = current;

        int sum = 0;
        if (grandparent % 2 == 0) sum = node.val;

        sum += traverse(node.left, parent, node.val);
        sum += traverse(node.right, parent, node.val);
        return sum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
