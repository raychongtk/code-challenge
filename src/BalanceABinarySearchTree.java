import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorder(nodes, root);
        return buildBinaryTree(nodes, 0, nodes.size() - 1);
    }

    private void inorder(List<TreeNode> nodes, TreeNode node) {
        if (node == null) return;

        inorder(nodes, node.left);
        nodes.add(node);
        inorder(nodes, node.right);
    }

    private TreeNode buildBinaryTree(List<TreeNode> nodes, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = nodes.get(mid);
        root.left = buildBinaryTree(nodes, start, mid - 1);
        root.right = buildBinaryTree(nodes, mid + 1, end);
        return root;
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
