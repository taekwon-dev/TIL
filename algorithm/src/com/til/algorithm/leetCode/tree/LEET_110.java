package com.til.algorithm.leetCode.tree;

/**
 *  AVL Tree's BF(Balance Factor)
 */
public class LEET_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lh = getDepth(root.left);
        int rh = getDepth(root.right);
        // 임의의 노드를 기준으로 모든 노드에서 균형 맞는지 체크
        return Math.abs(rh - lh) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        // NULL 노드는 -1로 지정
        if (root == null) {
            return -1;
        }
        // 왼쪽, 오른쪽 자식 노드 높이 값 중 큰 값 + 1
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}