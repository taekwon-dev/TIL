# [LinkedList] <u>Remove</u> Duplicates from <u>Sorted</u> List ||

### | Question 

#### Given the head of a sorted linked list, <u>delete all nodes</u> that have duplicate numbers, leaving only distinct numbers from the original list. 

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

// 1 → 2 → 3 → 3 → 3 → 3 → 3 → 4 → 4 → 5
// 1 → 2 → 5 

// 정렬된 연결 리스트에서 중복값을 모두 삭제할 때, 
// 중복된 값을 갖는 노드가 세 개 이상일 수 있으므로 
// 포인터를 이동시키는 반복문과 두 인접한 노드가 동일한 값을 가질 경우 그 다음 노드에도 동일한 값이 있는지 체크할 반복문 필요

// 중복된 노드를 삭제할 때는 이전 노드가 참조하고 있는 것을 중복된 값과 다른 값을 갖는 다음 노드에 함으로써 제거
// 값을 제거하기 위해 이전 노드를 활용할 때 → 이전 노드를 포인터 기준으로 활용

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode prev_node = new ListNode(0, head);
      ListNode curr_node = prev_node;
      
     	while (curr_node.next != null && curr_node.next.next != null) {
        if (curr_node.next.val == curr_node.next.next.val) {
          int dupVal = curr_node.next.val; 
					while (curr_node.next != null && curr_node.next.val == dupVal) {
            curr_node.next = curr_node.next.next;
          }
        } else {
          curr_node = curr_node.next; 
        }
      }
      return prev_node.next; 
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

// 복습 

// delete all nodes that have duplicate numbers 
// the given list is sorted in ascending order

// 노드 삭제, 해당 노드 이전 노드에 포인터를 놓자. 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode prev_node = new ListNode(0, head); 
      // head 노드를 삭제할 준비 
      ListNode curr_node = prev_node; 
     	// 인접한 노드가 같은 값을 갖는 경우 → 대상 조건 → 같은 값이 있을 때 까지 하나씩 검사 
      while (curr_node.next != null && curr_node.next.next != null) {
        if (curr_node.next.val == curr_node.next.next.val) {
          int dupliVal = curr_node.next.val; 
          // 1 → 2 → 2 → 2 → 2 → 3 ...
          while (curr_node.next != null && curr_node.next.val == dupliVal) {
            curr_node = curr_node.next.next; 
          }
        } else {
          curr_node = curr_node.next; 
        }
      }
      return prev_node.next;
    }
}
```



### | Reference

###### https://www.programcreek.com/2014/06/leetcode-remove-duplicates-from-sorted-list-ii-java/

