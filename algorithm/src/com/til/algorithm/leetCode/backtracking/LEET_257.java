package com.til.algorithm.leetCode.backtracking;

import com.til.algorithm.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LEET_257 {

    private List<String> answer = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return answer;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
            return;
        }
        dfs(root.left, path + root.val + "->");
        dfs(root.right, path + root.val + "->");
    }
}