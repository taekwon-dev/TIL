package com.til.algorithm.leetCode.linked_list;

import com.til.algorithm.leetCode.tree.ListNode;

public class LEET_876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}