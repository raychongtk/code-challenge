package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        var builder = new StringBuilder();
        builder.append(root.val);
        traverse(result, root, builder);
        return result;
    }

    private void traverse(List<String> result, TreeNode node, StringBuilder path) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(path.toString());
            return;
        }
        int size = path.length();
        if (node.left != null) {
            traverse(result, node.left, path.append("->").append(node.left.val));
        }
        path.setLength(size);
        if (node.right != null) {
            traverse(result, node.right, path.append("->").append(node.right.val));
        }
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
