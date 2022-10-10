package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            postorder(node, result);
        }
        result.add(root.val);
    }
}
