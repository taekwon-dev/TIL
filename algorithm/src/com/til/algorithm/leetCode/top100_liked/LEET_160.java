package com.til.algorithm.leetCode.linked_list;

import com.til.algorithm.leetCode.tree.ListNode;

public class LEET_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            if (a != null) {
                a = a.next;
            } else {
                a = headB;
            }

            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }
        // return a or b
        return a;
    }
}
