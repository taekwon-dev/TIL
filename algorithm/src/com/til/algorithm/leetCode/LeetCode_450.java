package com.til.algorithm.leetCode;

/**
 * Created by Youn on 2022/04/26.
 * Title : Delete Node in a BST
 * Hint  : 세 가지 경우의 수
 *         1) 삭제 노드의 자식 노드가 없는 경우
 *         2) 삭제 노드의 자식 노드가 한 쪽 (왼쪽 또는 오른쪽)만 있는 경우
 *         3) 삭제 노드의 자식 노드가 두 개인 경우
 */

public class LeetCode_450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return root;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.val = findMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int findMin(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

}
