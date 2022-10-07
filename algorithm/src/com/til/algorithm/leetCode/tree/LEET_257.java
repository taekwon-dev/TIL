package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        return result;
    }

    private void dfs(TreeNode root, List<String> result, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(s + root.val);
            return;
        }
        dfs(root.left, result, s + root.val + "->");
        dfs(root.right, result, s + root.val + "->");
    }
}
