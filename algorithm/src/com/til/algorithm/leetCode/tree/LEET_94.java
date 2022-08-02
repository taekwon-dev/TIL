package com.til.algorithm.leetCode.tree;

import com.til.algorithm.leetCode.*;

import java.util.ArrayList;
import java.util.List;

/**
 *  Binary Tree Inorder Traversal
 *  https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 *  pre order -> Root L R
 *  post order -> L R Root
 *  in order -> L Root R
 */
public class LEET_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        dfs(root, answer);
        return answer;
    }

    private void dfs(TreeNode root, List<Integer> answer) {
        if (root == null) return;
        if (root.left != null) {
            dfs(root.left, answer);
        }
        answer.add(root.val);
        if (root.right != null) {
            dfs(root.right, answer);
        }
    }
}
