package com.til.algorithm.leetCode.tree;

public class LEET_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key == root.val) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left != null && root.right != null) {
                /**
                 *  오른쪽 자식 노드를 기준으로 하는 서브 트리에서 가장 작은 키 값을 가지는 노드를
                 *  삭제할 노드의 위치로 올 수 있도록 값을 덮어쓴다.
                 */
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);

                /**
                 *  왼쪽 자식 노드를 기준으로 하는 서브 트리에서 가장 큰 값을 가지는 노드를
                 *  삭제할 노드의 위치로 올 수 있도록 값을 덮어쓴다.
                 */
                root.val = findMax(root.left);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /**
     *  삭제할 노드의 왼쪽 / 오른쪽 자식 노드가 모두 있는 경우 -> 오른쪽 자식 노드를 삭제할 노드의 위치로 두기
     */
    private int findMin(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    /**
     * 삭제할 노드의 왼쪽 / 오른쪽 자식 노드가 모두 있는 경우 -> 왼쪽 자식 노드를 삭제할 노드의 위치로 두기
     */
    private int findMax(TreeNode root) {
        int max = root.val;
        while (root.right != null) {
            max = root.right.val;
            root = root.right;
        }
        return max;
    }
}