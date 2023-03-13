package com.til.algorithm.leetCode.tree;

public class LEET_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     *  BST(Binary Search Tree)
     *
     *  아래 성질 활용
     *  - 왼쪽 자식 노드 < 부모 노드
     *  - 오른쪽 자식 노드 > 부모 노드
     */
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}