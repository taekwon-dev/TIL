package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_94 {

    List<Integer> nodes = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return nodes;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        nodes.add(node.val);
        inorder(node.right);
    }
}
