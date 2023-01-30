package com.til.algorithm.leetCode.tree;

/**
 *  Array(Random Access) vs Linked List(Sequential Access)
 *
 *  " Linked list does not support random access "
 *
 *  Fast(2) and Slow(1) Pointer 활용해서 중간 값 접근
 */
public class LEET_109 {

    public TreeNode sortedListToBST(ListNode head) {
        return findMidNode(head, null);
    }

    private TreeNode findMidNode(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode slow = start;
        ListNode fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = findMidNode(start, slow);
        root.right = findMidNode(slow.next, end);

        return root;
    }
}