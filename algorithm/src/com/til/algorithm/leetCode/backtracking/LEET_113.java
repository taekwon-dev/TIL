package com.til.algorithm.leetCode.backtracking;

import com.til.algorithm.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LEET_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return dfs(root, targetSum, answer, list, 0);
    }

    private List<List<Integer>> dfs(TreeNode root, int targetSum, List<List<Integer>> answer, List<Integer> list, int sum) {
        if (root == null) return answer;
        list.add(root.val);
        sum += root.val;
        if (root.left != null) dfs(root.left, targetSum, answer, list, sum);
        if (root.right != null) dfs(root.right, targetSum, answer, list, sum);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                answer.add(new ArrayList<>(list));
            }
        }
        list.remove(list.size() -1);
        return answer;
    }
}
