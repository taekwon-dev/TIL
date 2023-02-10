package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_590 {

    public List<Integer> postorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        postorder(answer, root);
        return answer;
    }

    private void postorder(List<Integer> answer, Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorder(answer, child);
        }
        answer.add(root.val);
    }
}