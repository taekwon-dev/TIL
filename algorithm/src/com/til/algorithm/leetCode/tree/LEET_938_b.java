package com.til.algorithm.leetCode.tree;

/**
 *  루트 노드 + 왼쪽 자식 서브트리(재귀) + 오른쪽 자식 서브트리(재귀)
 *  - 왼쪽 자식 서브트리 루트 노드 + 왼쪽 자식 서브트리 + 오른쪽 자식 서브트리 ...
 *  - 오른쪽 자식 서브트리 루트 노드 + 왼쪽 자식 서브트리 + 오른쪽 자식 서브트리 ...
 */
public class LEET_938_b {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}