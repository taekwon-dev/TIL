package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LEET_530 {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i + 1)));
        }
        return min;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
