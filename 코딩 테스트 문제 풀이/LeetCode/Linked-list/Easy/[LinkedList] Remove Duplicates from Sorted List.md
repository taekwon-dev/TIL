# [LinkedList] Remove Duplicates from <u>Sorted</u> List

### | Question 

#### Given the head of a sorted linked list, delete all dupilicates such that each element appears only once. 

#### Return the linked list sorted as well. 

###### 

### | Code

기준 노드 vs 비교 노드 각각을 가리키는 포인터 두 개를 활용 

중복되는 노드를 삭제할 때 뒤에 나오는 노드의 값을 제거하는 것이 편리함

문제를 잘 읽자! 이번 문제의 조건은 정렬되어 있는 연결 리스트이므로, 두 개의 포인터가 필요하지 않음! 순차적으로 인접 노드의 값을 비교만 하면 돼! 

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
			ListNode curr_node = head;
      while (curr_node != null && curr_node.next != null) {
        if (curr_node.val == curr_node.next.val) {
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

###### https://leetcode.com/problems/remove-duplicates-from-sorted-list/
