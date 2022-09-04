package com.til.algorithm.leetCode.tree;

public class LEET_230_2 {
    int cnt = 0;
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;

    }
    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        if (cnt == k) return;
        inorder(root.left, k);
        cnt++;
        if (cnt == k) {
            answer = root.val;
        }
        inorder(root.right, k);
    }
}
