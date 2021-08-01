# [LinkedList] Linked List Cycle I

### | Question 

#### Given head, the head of a linked list, <u>determine</u> if the linked list has a cycle in it. 

#### There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. 

#### Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to.

#### Note that `pos` is not passed as a parameter.

#### Return `true` if there is a cycle in the linked list. 

#### Otherwise, return `false`

### | Code 

###### - fast + 2 

###### - slow + 1

두 포인터가 연결 리스트 내에서 접점이 있는 경우 = 루프가 있다. 

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
    public boolean hasCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
          return true;
        }
      }
      return false;      
    }
}
```

### | Reference

###### https://leetcode.com/problems/linked-list-cycle/

