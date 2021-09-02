package tree;

/**
 * @author raychong
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode dummy = root;

        while (true) {
            int value = dummy.val;

            if (val > value && dummy.right != null) {
                dummy = dummy.right;
            } else if (val < value && dummy.left != null) {
                dummy = dummy.left;
            } else if (val > value) {
                dummy.right = new TreeNode(val);
                break;
            } else if (val < value) {
                dummy.left = new TreeNode(val);
                break;
            }
        }

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
