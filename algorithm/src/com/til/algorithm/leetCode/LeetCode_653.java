package com.til.algorithm.leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Youn on 2022/04/30.
 * Title : Two Sum - Input is a BST
 * Hint  :
 */
public class LeetCode_653 {

    // DFS
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hashSet = new HashSet<>();
        return dfs(root, hashSet, k);
    }

    private boolean dfs(TreeNode root, Set<Integer> hashSet, int k) {
        if (root == null) return false;
        if (hashSet.contains(k - root.val)) return true;

        hashSet.add(root.val);
        return dfs(root.left, hashSet, k) || dfs(root.right, hashSet, k);
    }

    // BFS
    public boolean findTarget_Queue(TreeNode root, int k) {

        if (root == null) return false;
        Set<Integer> hashSet = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (hashSet.contains(k - currNode.val)) return true;
            hashSet.add(currNode.val);

            if (currNode.left != null) queue.offer(currNode.left);
            if (currNode.right != null) queue.offer(currNode.right);
        }
        return false;
    }

}
