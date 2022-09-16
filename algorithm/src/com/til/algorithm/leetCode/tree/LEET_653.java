package com.til.algorithm.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *   4 + 5 = 9
 *   9 - 5 = 4

     public boolean findTarget(TreeNode root, int k) {
         Set<Integer> hashSet = new HashSet<>();
         return dfs(root, hashSet, k);
     }

     private boolean dfs(TreeNode root, Set<Integer> hashSet, int k) {
         if (root == null) return false;
         if (hashSet.contains(k - root.val)) return true;

         hashSet.add(root.val);
         return dfs(root.left, hashSet, k) || dfs(root.right, hashSet, k);
     }
 */

public class LEET_653 {
    List<Integer> vals = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        preorder(root);
        boolean answer = false;
        for (int i = 0; i < vals.size(); i++) {
            for (int j = i + 1; j < vals.size(); j++) {
                if (vals.get(i) + vals.get(j) == k) {
                    return true;
                }
            }
        }
        return answer;
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            vals.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
}
