package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  All Elements in Two Binary Search Trees
 */
public class LEET_1305 {
    List<Integer> answer = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        Collections.sort(answer);
        return answer;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            answer.add(root.val);
            inorder(root.right);
        }
    }
}
