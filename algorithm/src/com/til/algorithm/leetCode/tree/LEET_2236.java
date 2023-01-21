package com.til.algorithm.leetCode.tree;

public class LEET_2236 {

    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}
