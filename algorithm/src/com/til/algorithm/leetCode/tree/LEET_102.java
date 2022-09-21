package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LEET_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        return bfs(root, result, list, q);
    }

    private List<List<Integer>> bfs(TreeNode root, List<List<Integer>> result, List<Integer> list, Queue<TreeNode> q) {
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            result.add(new ArrayList<>(list));
            list.clear();
        }
        return result;
    }
}
