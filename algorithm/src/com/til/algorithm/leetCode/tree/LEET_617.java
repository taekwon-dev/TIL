package com.til.algorithm.leetCode.tree;

import com.til.algorithm.leetCode.tree.TreeNode;

public class LEET_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root2.val = root1.val + root2.val;
        root2.left = mergeTrees(root1.left, root2.left);
        root2.right = mergeTrees(root1.right, root2.right);

        return root2;
    }
}
