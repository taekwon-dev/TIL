package com.til.algorithm.leetCode.tree;

public class LEET_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        /**
         *  탐색 대상 노드를 반환
         */
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
