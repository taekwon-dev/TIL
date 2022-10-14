package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, targetSum, result, list);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                result.add(new ArrayList<>(list));
            }
        }
        dfs(root.left, targetSum - root.val, result, list);
        dfs(root.right, targetSum - root.val, result, list);
        list.remove(list.size() - 1);
    }
}
