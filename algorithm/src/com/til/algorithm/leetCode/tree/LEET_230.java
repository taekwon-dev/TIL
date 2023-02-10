package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> keys = new ArrayList<>();
        inorder(keys, root);
        return keys.get(k - 1);
    }

    private void inorder(List<Integer> keys, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(keys, root.left);
        keys.add(root.val);
        inorder(keys, root.right);
    }
}