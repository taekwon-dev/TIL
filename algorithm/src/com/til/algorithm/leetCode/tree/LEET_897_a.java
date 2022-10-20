package com.til.algorithm.leetCode.tree;

public class LEET_897_a {
    TreeNode head;
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return head;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        TreeNode node = new TreeNode(root.val);
        if (head == null) {
            head = node;
            curr = node;
        } else {
            curr.right = node;
            curr = curr.right;
        }
        inorder(root.right);
    }
}
