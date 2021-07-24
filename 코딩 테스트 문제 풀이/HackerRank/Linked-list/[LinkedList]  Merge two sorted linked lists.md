# [LinkedList] Merge two sorted linked lists



### | Question

#### Given pointers to the heads of two sorted linked lists, merge them into a single linked list.

#### Either head pointer may be null meaning that the corresponding list is empty.

### | Code	

두 연결 리스트를 병합 할 때 새로운 포인터가 필요함

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

// Time Limit Exceeded 
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) return l2;
      if (l2 == null) return l1;
      
      ListNode curr_l1 = l1;
      ListNode curr_l2 = l2;
      ListNode head = null;
      
      if (curr_l1.val < curr_l2.val) {
        head = l1;
        l1 = l1.next;
      } else {
        head = l2; 
        l2 = l2.next;
      }
      
      ListNode curr_l3 = head; 
      
      while (curr_l1 != null && curr_l2 != null) {
        if (curr_l1.val < curr_l2.val) {
          curr_l3.next = curr_l1;
          curr_l1 = curr_l1.next;
        } else {
          curr_l3.next = curr_l2;
          curr_l2 = curr_l2.next;
        }
        
        curr_l3 = curr_l3.next;
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

      ListNode head = null;
      
        
      if (l1.val < l2.val) {
          head = l1;
          l1 = l1.next;
      } else {
          head = l2;
          l2 = l2.next; 
      }
      ListNode curr_node = head;  
      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            curr_node.next = l1;
            l1 = l1.next;
        } else {
            curr_node.next = l2;
            l2 = l2.next;
        } 
        curr_node = curr_node.next;
      }
        
      if (l1 == null) {
          curr_node.next = l2;
      }
        
      if (l2 == null) {
          curr_node.next = l1; 
      }
        
      return head;

    }
}
```

