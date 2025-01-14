package problem_solving.leetcode.blind_75.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ps_2025_01_14 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = q.poll();
                currentLevelNodes.add(currentNode.val);

                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                }
            }
            answer.add(currentLevelNodes);
        }
        return answer;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
