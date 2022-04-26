package com.til.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Youn on 2022/04/26.
 * Title : Increasing Order Search Tree (https://leetcode.com/problems/increasing-order-search-tree/)
 * Hint  :
 */
public class LeetCode_897 {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {

        inorder(root);

        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }

        list.get(list.size()-1).left = null;
        list.get(list.size()-1).right = null;

        return list.get(0);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
