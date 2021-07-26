# [LinkedList] Remove Linked List Elements

### | Question

#### Given the head of a linked list and an integer val, remove all the nodes of the linked list that has `Node.val = val`, and return the new head. 

### | Code

######  - 노드 주소가 아닌, 노드의 값을 기준으로 제거

######  - 값 제거



```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
			while (head != null && head.val == val) {
        head = head.next; 
      }
      ListNode curr_node = head; 
      while (curr_node != null && curr_node.next != null) {
        if (curr_node.next.val == val) {
          curr_node.next = curr_node.next.next;
        } else {
          curr_node = curr_node.next;
        }
      }
      return head;
    }
}
```

### | Reference

###### https://leetcode.com/problems/remove-linked-list-elements/

