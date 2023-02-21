package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Root to Leaf via Queue
 */
public class LEET_102 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        return bfs(root, q);
    }

    private List<List<Integer>> bfs(TreeNode root, Queue<TreeNode> queue) {
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(new ArrayList<>(list));
            list.clear();
        }
        return result;
    }
}