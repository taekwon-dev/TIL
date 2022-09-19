package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        preorder(result, root);
        return result;
    }

    private void preorder(List<Integer> result, TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        preorder(result, root.left);
        preorder(result, root.right);
    }
}
