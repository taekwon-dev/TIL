# [LinkedList] Linked List Cycle II

### | Question

#### Given a linked list, return the node where the cycle begins.

#### If there is no cycle, return `null`.

#### There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer.

#### Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. 

#### Note that `pos` is not passed as a parameter.

### | Code

루프 찾기

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
			ListNode fast = head;
      ListNode slow = head;
      
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (fast == slow) {
          break; 
        }
      }
      if (fast == null || fast.next == null) {
        return null;
      }
      slow = head; 
      while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
      }
      return fast; 
    }
}
```



### | Reference

###### https://leetcode.com/problems/linked-list-cycle-ii/