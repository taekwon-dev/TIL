package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Root to Leaf via Queue
 */
public class LEET_102 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> element = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return answer;
        }
        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                element.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            answer.add(new ArrayList<>(element));
            element.clear();
        }
        return answer;
    }
}