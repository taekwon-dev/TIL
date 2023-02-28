package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_113_a {

    private List<List<Integer>> paths = new ArrayList<>();
    private int targetSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        List<Integer> list = new ArrayList<>();
        preorder(root, list, 0);
        return paths;
    }

    private void preorder(TreeNode root, List<Integer> list, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        list.add(root.val);
        if (root.left != null) {
            preorder(root.left, list, sum);
        }

        if (root.right != null) {
            preorder(root.right, list, sum);
        }
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                paths.add(new ArrayList<>(list));
            }
        }
        list.remove(list.size() - 1);
    }
}