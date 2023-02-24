package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_257 {

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return paths;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        dfs(root.left, path + root.val + "->");
        dfs(root.right, path + root.val + "->");
    }
}