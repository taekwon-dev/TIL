package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_257 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        List<String> paths = new ArrayList<>();
        backtracking(root, paths, "");
        return paths;
    }

    private void backtracking(TreeNode root, List<String> paths, String path) {
        if (root.left == null && root.right == null) {
            path += root.val;
            paths.add(path);
            return;
        }
        if (root.left != null) backtracking(root.left, paths, path + root.val + "->");
        if (root.right != null) backtracking(root.right, paths, path + root.val + "->");
    }
}
