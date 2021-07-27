# [LinkedList] Merge Two Sorted Lists

### | Question

#### Merge two sorted linked lists and <u>return it as a sorted list</u>. 

#### The list should be made by splicing together the nodes of the first two lists. 

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) return l2;
      if (l2 == null) return l1;
      
      ListNode curr_l1 = l1;
      ListNode curr_l2 = l2;
      ListNode head = null;
      ListNode curr_l3 = null;
      
      if (curr_l1.val < curr_l2.val) {
        head = l1; 
      } else {
        head = l2; 
      }
      
      ListNode curr_l3 = head; 
      
      while (curr_l1 != null && curr_l2 != null) {
        if (curr_l1.val < curr_l2.val) {
          curr_l3.next = curr_l1;
          curr_l3 = curr_l3.next; 
        } else {
          curr_l3.next = curr_l2;
          curr_l3 = curr_l3.next; 
        }
      }
      
      if (curr_l1 == null) {
        curr_l3.next = curr_l2;
      }
      
      if (curr_l2 == null) {
        curr_l3.next = curr_l1; 
      }
      
      return head; 
      
    }
}
```

### | Reference

###### https://leetcode.com/problems/merge-two-sorted-lists/
