package com.til.algorithm.leetCode.tree;

/**
 *  Delete Node in a BST
 */
public class LEET_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            /** findMin() */
            root.val = findMin(root.right);
            root.right = deleteNode(root.right, root.val);

            /** findMax() */
            root.val = findMax(root.left);
            root.left = deleteNode(root.left, root.val);
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

    private int findMax(TreeNode root) {
        int max = root.val;
        while (root.right != null) {
            max = root.right.val;
            root = root.right;
        }
        return max;
    }
}
