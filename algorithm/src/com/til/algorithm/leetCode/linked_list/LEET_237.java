package com.til.algorithm.leetCode.linked_list;

import com.til.algorithm.leetCode.tree.ListNode;

public class LEET_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
