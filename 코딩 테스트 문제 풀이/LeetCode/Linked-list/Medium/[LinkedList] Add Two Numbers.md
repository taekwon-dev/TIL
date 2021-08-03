# [LinkedList] Add Two Numbers 

### | Question

#### You are given two non-empty linked lists representing two non-negative integers.

#### <u>The digits are stored in reverse order</u>, and each of their nodes contains a single digit.

#### Add the two numbers and return the sum as a linked list. 

#### You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### | Code

\# reverse order via two pointers 

<u>주어진 두 연결 리스트의 끝 점을 맞춘다. (→ 덧셈)</u> 

덧셈 후 역순으로 만들어서 반환해야 하므로, 왼쪽 기준으로 맞춰서 (즉, 헤드부터 하나씩 비교하면서) 덧셈을 해도 결과가 같음

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
      ListNode dummy_head = new ListNode(0);
      ListNode l3 = dummy_head; 
      
      int carry = 0;
      while (l1 != null || l2 != null) {
        // Get Each node val 
        int l1_val = (l1 != null) ? l1.val : 0;
        int l2_val = (l2 != null) ? l2.val : 0; 
				
        int currrent_sum = l1_val + l2_val + carry;
        carry = currrent_sum / 10; 
        int last_digit = currrent_sum % 10; 
        
        ListNode new_node = new ListNode(last_digit);
        l3.next = new_node;
        
        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
        l3 = l3.next;
      }
      if (carry > 0) {
        ListNode new_node = new ListNode(1);
        l3.next = new_node;
        l3 = l3.next;
      }
      
      return dummy_head.next; 
     
    }
}
```

### | Reference

###### https://bcp0109.tistory.com/131

###### https://www.youtube.com/watch?v=aM4Iv7eEr2o