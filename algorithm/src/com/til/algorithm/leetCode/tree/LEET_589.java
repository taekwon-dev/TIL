package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        result.add(root.val);
        for (Node child : root.children) {
            preorder(child, result);
        }
    }
}
