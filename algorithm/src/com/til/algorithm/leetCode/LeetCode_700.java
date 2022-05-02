package com.til.algorithm.leetCode;

/**
 * Created by Youn on 2022/04/27.
 * Title : Search in a Binary Search Tree (https://leetcode.com/problems/search-in-a-binary-search-tree/)
 * Hint  :
 */
public class LeetCode_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;
        if (root.val > val) return searchBST(root.left, val);
        if (root.val < val) return searchBST(root.right, val);
        return root;
    }

}
