package com.til.algorithm.leetCode.tree;

public class LEET_559 {
    int max = 0;
    public int maxDepth(Node root) {
        findMaxDepth(root, 1);
        return max;
    }

    private void findMaxDepth(Node root, int depth) {
        if (root == null) return;
        if (root.children.size() == 0) {
            max = Math.max(max, depth);
            return;
        }
        if (root.children.size() > 0) {
            for (int i = 0; i < root.children.size(); i++) {
                findMaxDepth(root.children.get(i), depth + 1);
            }
        }
    }
}
