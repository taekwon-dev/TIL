# [LinkedList] Palindrome Linked List

### | Question

\# reverse # middle of the linked list

#### Given the head of a singly linked list, return true if it is a palindrome.

#### <u>O(n) time and O(1) space</u> 

\# palindrome : 

글자를 거꾸로 읽어도 같은 뜻이 되는 문장 (1 → 2 → 2 → 1)

### | Code

연결 리스트의 중점 찾기 (단, 연결 리스트 사이즈가 홀수인 경우에는 중점 +1 포지션이 대칭 시작점)

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
    public boolean isPalindrome(ListNode head) {
      ListNode slow = head;
      ListNode fast = head; 
      
     	while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next; 
      }
      
      if (fast != null) {
        slow = slow.next; 
      }
      
      ListNode compare = reverse(slow);
      
      while (head != null && compare != null) {
        if (haed.val != compare.val) {
          return false;
        }
        head = head.next;
        compare = compare.next;
      }
      return true;
        
    }
  	public ListNode reverse(ListNode node) {
      ListNode prev_node = null;
      ListNode curr_node = node; 
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

###### https://www.youtube.com/watch?v=wk4QsvwQwdQ
