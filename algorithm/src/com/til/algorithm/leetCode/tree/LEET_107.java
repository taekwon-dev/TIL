package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Leaf to Root
 */
public class LEET_107 {

    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return answer;
        }
        List<TreeNode> nodesToTraverse = new ArrayList<>();
        nodesToTraverse.add(root);

        while (!nodesToTraverse.isEmpty()) {
            List<Integer> element = new ArrayList<>();
            List<TreeNode> nodesToTraverseNext = new ArrayList<>();

            for (TreeNode node : nodesToTraverse) {
                element.add(node.val);
                if (node.left != null) {
                    nodesToTraverseNext.add(node.left);
                }
                if (node.right != null) {
                    nodesToTraverseNext.add(node.right);
                }
            }
            /**
             *   0번 인덱스에 엘리먼트를 추가함으로써, 데이터 입력 순서 조정
             */
            answer.add(0, element);
            nodesToTraverse = nodesToTraverseNext;
        }
        return answer;
    }
}