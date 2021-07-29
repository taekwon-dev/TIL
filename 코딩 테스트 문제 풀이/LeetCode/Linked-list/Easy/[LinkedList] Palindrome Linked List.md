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
// reverse 대상 노드를 찾아야 한다.
// 조건 - Could you do it in O(n) time and O(1) space : linked list 내부에서 포인터를 이용 
// 1 → 2 → '2' → 1 (짝) 두 쌍을 비교, 두 쌍을 나누는 기준을 이 리스트에서는 두번째 2

// 1 → '2' → 1 (홀) 정 가운데 노드를 기준으로 한 쌍을 비교 

// reverse - 쌍 비교할 때 값이 같은 애들끼리 비교하기 위해 (구조적으로 이렇게 만들어야 한다.)
// middle node - 기준 노드를 찾기 위해 
// 연결 리스트 사이즈를 홀 또는 짝 구분 - 홀/짝의 경우 middle node 기준이 다름

class Solution {
    public boolean isPalindrome(ListNode head) {
      
      // middle node
      ListNode slow = head;
      ListNode fast = head; 
      
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next; 
      }
      
      if (fast != null) {
        slow = slow.next; 
      }
      
      ListNode compare_node = reverse(slow);
      
      // 1 : 1 comparison
      while (head != null && compare_node != null) {
        if (head.val != compare_node.val) return false; 
        head = head.next;
        comare_node = compare_node.next;
      }
      return true;

    }
  
  	public reverse(ListNode head) {
      ListNode prev_node = null;
      while (head != null) {
        ListNode next_node = head.next; 
        head.next = prev_node;
        prev_node = head; 
        head = next_node;
      }
      return prev_node; 
    }
}
```















### | Reference

###### https://www.youtube.com/watch?v=wk4QsvwQwdQ
