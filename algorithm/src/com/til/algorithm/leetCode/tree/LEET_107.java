package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Leaf to Root
 */
public class LEET_107 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
             return result;
        }
        List<TreeNode> nodesToTraverse = new ArrayList<>();
        nodesToTraverse.add(root);

        while (!nodesToTraverse.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nodesToTraverseNext = new ArrayList<>();

            for (TreeNode node : nodesToTraverse) {
                list.add(node.val);
                if (node.left != null) {
                    nodesToTraverseNext.add(node.left);
                }
                if (node.right != null) {
                    nodesToTraverseNext.add(node.right);
                }
            }
            result.add(0, list);
            nodesToTraverse = nodesToTraverseNext;
        }
        return result;
    }
}