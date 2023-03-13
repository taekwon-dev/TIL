package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LEET_113_b {

    private List<List<Integer>> paths = new ArrayList<>();
    private int targetSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, 0, "");
        return paths;
    }

    private void dfs(TreeNode root, int sum, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                List<Integer> path = Arrays.asList(s.split("->"))
                        .stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                paths.add(new ArrayList<>(path));
            }
            return;
        }
        dfs(root.left, sum + root.val, s + root.val + "->");
        dfs(root.right, sum + root.val, s + root.val + "->");
    }
}