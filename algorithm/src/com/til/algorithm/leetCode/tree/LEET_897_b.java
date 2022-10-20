package com.til.algorithm.leetCode.tree;

public class LEET_897_b {
    TreeNode head;
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        increasingBST(root.left);
        TreeNode node = new TreeNode(root.val);
        if (head == null) {
            head = node;
            curr = node;
        } else {
            curr.right = node;
            curr = curr.right;
        }
        increasingBST(root.right);
        return head;
    }
}
