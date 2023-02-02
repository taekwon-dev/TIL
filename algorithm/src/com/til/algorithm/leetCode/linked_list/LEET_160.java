package com.til.algorithm.leetCode.linked_list;

import com.til.algorithm.leetCode.tree.ListNode;

/**
 *  두 단방향 연결 리스트의 교차점을 찾는 문제
 *
 *  단방향이고, 두 연결 리스트가 서로 길이가 다를 수 있으므로 끝 점을 맞추고, 교차점을 찾는다.
 */
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
        return a;
    }
}
