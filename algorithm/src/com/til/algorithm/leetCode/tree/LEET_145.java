package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *   Post Order
 *   L -> R -> Root
 */
public class LEET_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorder(root, answer);
        return answer;
    }

    private void postorder(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        postorder(root.left, answer);
        postorder(root.right, answer);
        answer.add(root.val);
    }
}
