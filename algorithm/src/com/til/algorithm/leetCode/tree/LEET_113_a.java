package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_113_a {

    private List<List<Integer>> paths = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return paths;
        }
        dfs(root, targetSum);
        return paths;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                paths.add(new ArrayList<>(path));
            }
        }
        path.remove(path.size() - 1);
    }
}