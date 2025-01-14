package problem_solving.leetcode.blind_75.same_tree;

public class ps_2025_01_14 {

    public boolean isSameTree(ps_2025_01_13.TreeNode p, ps_2025_01_13.TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    class TreeNode {
        int val;
        ps_2025_01_13.TreeNode left;
        ps_2025_01_13.TreeNode right;
    }
}
