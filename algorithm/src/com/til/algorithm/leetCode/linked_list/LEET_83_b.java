package com.til.algorithm.leetCode.linked_list;

import com.til.algorithm.leetCode.tree.ListNode;

public class LEET_83_b {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            return head.next;
        }
        return head;
    }
}
