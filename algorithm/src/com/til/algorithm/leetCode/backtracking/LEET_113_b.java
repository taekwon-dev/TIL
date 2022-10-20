package com.til.algorithm.leetCode.backtracking;

import com.til.algorithm.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LEET_113_b {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return preorder(root, targetSum, result, list, 0);
    }

    private List<List<Integer>> preorder(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> list, int sum) {
        if (root == null) {
            return result;
        }
        sum += root.val;
        list.add(root.val);
        if (root.left != null) {
            preorder(root.left, targetSum, result, list, sum);
        }

        if (root.right != null) {
            preorder(root.right, targetSum, result, list, sum);
        }
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(list));
            }
        }
        list.remove(list.size() - 1);
        return result;
    }
}
