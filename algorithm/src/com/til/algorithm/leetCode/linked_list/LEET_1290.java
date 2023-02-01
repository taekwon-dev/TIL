package com.til.algorithm.leetCode.linked_list;

import com.til.algorithm.leetCode.tree.ListNode;

public class LEET_1290 {

    private int answer;

    public int getDecimalValue(ListNode head) {
        recursion(head);
        return answer;
    }

    private int recursion(ListNode node) {
        if (node == null) {
            return 0;
        }
        int p = recursion(node.next);
        answer += node.val * Math.pow(2, p);
        return p + 1;
    }
}