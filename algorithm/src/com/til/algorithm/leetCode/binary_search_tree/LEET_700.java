package com.til.algorithm.leetCode.binary_search_tree;

import com.til.algorithm.leetCode.TreeNode;


/**
 * Created by Youn on 2022/06/17.
 * Title : Search in a Binary Search Tree (https://leetcode.com/problems/search-in-a-binary-search-tree/)
 * Hint  :
 */
public class LEET_700 {

    TreeNode searchBST(TreeNode root, int val) {
        return findNode(root, val);
    }

    private TreeNode findNode(TreeNode node, int val) {
        if (node == null || node.val == val) {
            return node;
        }
        if (node.val > val) {
            return findNode(node.left, val);
        } else {
            return findNode(node.right, val);
        }
    }
}
