package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LEET_783 {
    public int minDiffInBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int min = 100_000;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (min > Math.abs(nums.get(i) - nums.get(i + 1))) {
                min = Math.abs(nums.get(i) - nums.get(i + 1));
            }
        }
        return min;
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
