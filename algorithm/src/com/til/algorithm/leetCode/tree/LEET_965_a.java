package com.til.algorithm.leetCode.tree;

import java.util.HashSet;

public class LEET_965_a {
    public boolean isUnivalTree(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        preorder(root, set);
        if (set.size() >= 2) {
            return false;
        } else {
            return true;
        }
    }

    private void preorder(TreeNode root, HashSet<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        preorder(root.left, set);
        preorder(root.right, set);
    }
}
