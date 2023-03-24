package com.til.algorithm.leetCode.top100_liked;

import com.til.algorithm.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LEET_94 {

    private List<Integer> path = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return path;
        }
        inorder(root);
        return path;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        path.add(root.val);
        inorder(root.right);
    }
}