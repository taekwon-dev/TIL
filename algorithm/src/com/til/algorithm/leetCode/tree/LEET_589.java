package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        preorder(answer, root);
        return answer;
    }

    private void preorder(List<Integer> answer, Node root) {
        if (root == null) {
            return;
        }
        answer.add(root.val);
        for (Node child : root.children) {
            preorder(answer, child);
        }
    }
}