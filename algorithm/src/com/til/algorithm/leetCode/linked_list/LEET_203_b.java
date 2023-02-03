package com.til.algorithm.leetCode.linked_list;

import com.til.algorithm.leetCode.tree.ListNode;

public class LEET_203_b {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
