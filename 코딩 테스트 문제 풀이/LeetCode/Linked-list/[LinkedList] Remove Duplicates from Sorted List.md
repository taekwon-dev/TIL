# [LinkedList] Remove Duplicates from Sorted List

### | Question 

#### Given the head of a sorted linked list, delete all dupilicates such that each element appears only once. 

#### Return the linked list sorted as well. 

###### 

### | Code

기준 노드 vs 비교 노드 각각을 가리키는 포인터 두 개를 활용 

중복되는 노드를 삭제할 때 뒤에 나오는 노드의 값을 제거하는 것이 편리함

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
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null) return head; 
      ListNode curr_node = head;
      while (curr_node.next != null) {
        ListNode runner_node = curr_node.next;
        while (runner_node.next != null) {
          if (curr_node.val == runner_node.val) {
            curr_node = runner_node.next;
          } else {
            runner_node = runner_node.next;
          }
        }

      }
      return head;
    }
}
```



### | Reference

###### https://leetcode.com/problems/remove-duplicates-from-sorted-list/
