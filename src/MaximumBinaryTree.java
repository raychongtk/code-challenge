/**
 * @author raychong
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode();
        helper(nums, root);
        return root;
    }

    private void helper(int[] nums, TreeNode node) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        node.val = nums[index];

        int[] left = new int[index];
        for (int i = 0; i < index; i++) {
            left[i] = nums[i];
        }

        int[] right = new int[nums.length - index - 1];
        for (int i = index + 1; i < nums.length; i++) {
            right[i - index - 1] = nums[i];
        }

        if (left.length > 0) {
            node.left = new TreeNode(left[0]);
            helper(left, node.left);
        }
        if (right.length > 0) {
            node.right = new TreeNode(right[0]);
            helper(right, node.right);
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
