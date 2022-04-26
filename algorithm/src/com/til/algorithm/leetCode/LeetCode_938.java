package com.til.algorithm.leetCode;

/**
 * Created by Youn on 2022/04/26.
 * Title : Range Sum of BST
 * Hint  : Traversal + BST 특징 이용하는 것으로 접근 했었는데, Traversal 으로만 접근해서 풀고 최적화를 고민한다면, BST 성질 이용할 수 있음.
 *         재귀 함수 내 지역변수 선언한 것에 계속 더하기 연산이 되는데, 이 부분 자칫 필드로 선언하는 실수 할 수 있음.
 */
public class LeetCode_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {

        int sum = 0;

        if (root == null) return 0;
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }
        sum += rangeSumBST(root.left, low, high);
        sum += rangeSumBST(root.right, low, high);

        return sum;
    }
}
