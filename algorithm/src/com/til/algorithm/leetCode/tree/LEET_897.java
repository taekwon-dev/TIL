package com.til.algorithm.leetCode.tree;

public class LEET_897 {
    private TreeNode head;
    private TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return head;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        TreeNode treeNode = new TreeNode(node.val);
        if (head == null) {
            head = treeNode;
            curr = treeNode;
        } else {
            curr.right = treeNode;
            curr = curr.right;
        }
        inorder(node.right);
    }
}
