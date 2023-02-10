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
            // 연결 리스트의 마지막 원소에 위치한 값에 지수 0을 넘겨준다.
            return 0;
        }
        // 지수 값
        int p = recursion(node.next);
        answer += node.val * Math.pow(2, p);

        // 지수 값을 + 1 한다.
        return p + 1;
    }
}