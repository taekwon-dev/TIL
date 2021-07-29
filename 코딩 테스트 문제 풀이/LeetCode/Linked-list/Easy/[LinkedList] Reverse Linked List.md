# [LinkedList] Reverse Linked List

### | Question

#### Given the head of a singly linked list, reverse the list, and return the reversed list. 

### | Code

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
    public ListNode reverseList(ListNode head) {
    	ListNode prev = null;
      while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
      }
      return prev;
    }
}
```

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

// 복습하기 
// Reverse the given linked list. 

class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode prev_node = null;
      ListNode curr_node = head; 
      
      while (curr_node != null) {
        ListNode next_node = curr_node.next; 
        curr_node.next = prev_node;
        prev_node = curr_node;
        curr_node = next_node; 
      }
      return prev_node; 
    }
}
```



### | Reference

###### https://leetcode.com/problems/reverse-linked-list/
