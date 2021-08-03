# [LinkedList] Add Two Numbers 

### | Question

#### You are given two non-empty linked lists representing two non-negative integers.

#### <u>The digits are stored in reverse order</u>, and each of their nodes contains a single digit.

#### Add the two numbers and return the sum as a linked list. 

#### You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### | Code

\# reverse order via two pointers 

주어진 두 연결 리스트의 끝 점을 맞춘다. (→ 덧셈)

\> 10 인 경우 처리 

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
     
        
    }
  
		private ListNode reverse(ListNode head) {
			ListNode prev = null;
      ListNode curr = head; 
      
      while (curr != null) {
        ListNode next = curr.next; 
        curr.next = prev;
        prev = curr;
        curr = next; 
      }
      return prev; 
    }
}
```

