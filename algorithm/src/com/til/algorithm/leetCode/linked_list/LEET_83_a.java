package com.til.algorithm.leetCode.linked_list;

import com.til.algorithm.leetCode.tree.ListNode;

public class LEET_83_a {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(101);
        ListNode curr = dummy;
        dummy.next = head;

        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
