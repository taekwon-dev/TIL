package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_257 {

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        root2Leaf(root, "");
        return paths;
    }

    private void root2Leaf(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        }
        root2Leaf(root.left, path + root.val + "->");
        root2Leaf(root.right, path + root.val + "->");
    }
}