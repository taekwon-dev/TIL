package com.til.algorithm.leetCode.tree;

public class LEET_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        /**
         *  새로운 노드를 추가한 뒤 만들어진 트리의 루트 노드를 반환
         */
        return root;
    }
}
