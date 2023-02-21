package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        rootToLeafPath(root, paths, "");
        return paths;
    }

    private void rootToLeafPath(TreeNode root, List<String> paths, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        rootToLeafPath(root.left, paths, path + root.val + "->");
        rootToLeafPath(root.right, paths, path + root.val + "->");
    }
}