package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LEET_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorder(root, answer);
        return answer;
    }

    private void inorder(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        inorder(root.left, answer);
        answer.add(root.val);
        inorder(root.right, answer);
    }
}
