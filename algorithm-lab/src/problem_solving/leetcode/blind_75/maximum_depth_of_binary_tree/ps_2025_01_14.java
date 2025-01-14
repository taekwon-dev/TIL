package problem_solving.leetcode.blind_75.maximum_depth_of_binary_tree;

public class ps_2025_01_14 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
