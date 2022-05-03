package com.til.algorithm.leetCode;

/**
 * Created by Youn on 2022/05/03.
 * Title : Lowest Common Ancestorx of a Binary Search Tree
 * Hint  : "The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants
 *
 *         #두_정점_사이의_최단거리
 *         #두_노드의_공통된_조상_중에서_가장_가까운_조상_찾기
 *
 *         In graph theory and computer science, the lowest common ancestor (LCA) (also called least common ancestor) of two nodes
 *         v and w in a tree or directed acyclic graph T is the lowest (deepest) node that has both v and w as descendants,
 *         where we define each node to be a descendant of itself.
 *
 *         LCA + DP
 *         LCA + 세그먼트
 *
 */
public class LeetCode_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null || right != null) {
            return left == null ? right : left;
        } else {
            return null;
        }
    }
}
