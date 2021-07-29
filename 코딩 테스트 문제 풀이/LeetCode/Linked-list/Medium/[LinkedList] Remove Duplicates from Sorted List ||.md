# [LinkedList] Remove Duplicates from <u>Sorted</u> List ||

### | Question 

#### Given the head of a sorted linked list, <u>delete all nodes</u> that have dupilcate numbers, leaving only distinct numbers from the original list. 

#### Return the linked list <u>sorted</u> as well. 

##### The list is guranteed to be sorted in ascending order.

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

// 1 → 2 → 3 → 3 → 4 → 4 → 5 
// 1 → 2 → 5 

// 
// (1,2), (2,3), (3,3), *제외*(3,4), (4,4), *제외*(4,5)
// (2,4), (2,5) 

// 3 제거할 때 2 → 4 : 1 → 2 → 4 → 4 → 5 
// 이전 노드에 대한 포인터 필요! 

// 1 → 1 → 2 → ... 

// 중복된 값을 갖고 있는 모든 노드 삭제
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       
    }
}
```

### | Reference

###### https://www.programcreek.com/2014/06/leetcode-remove-duplicates-from-sorted-list-ii-java/