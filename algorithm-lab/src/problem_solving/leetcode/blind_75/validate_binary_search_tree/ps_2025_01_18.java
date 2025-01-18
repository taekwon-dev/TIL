package problem_solving.leetcode.blind_75.validate_binary_search_tree;

public class ps_2025_01_18 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && max <= root.val)) {
            return false;
        }
        return isValidBST(root.right, root.val, max) && isValidBST(root.left, min, root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
