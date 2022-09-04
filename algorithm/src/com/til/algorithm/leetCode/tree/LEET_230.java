package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Kth Smallest Element in a BST
 */
public class LEET_230 {
    List<Integer> nums = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return nums.get(k - 1);
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (!nums.contains(root.val)) nums.add(root.val);
            inorder(root.right);
        }
    }
}
