# [LinkedList] Intersection of Two Linked Lists

### | Question

#### Given the heads of two singly linked-lists `headA` and `headB`, return the node at which two lists intersects.

#### If the two lniked lists have no intersection at all, return `null`.

![image-20210722155317945](/Users/youn/Library/Application Support/typora-user-images/image-20210722155317945.png)

#### It is guaranteed that there are no cycles anywhere in the entire linked structure.

#### Note that the linked lists must retain their original structure after the function returns. 

#### A : a1 → a2 → c1 → c2 → c3 → NULL

#### B : b1 → b2 → b3 → c1 → c2 → c3 → NULL

Tail Node를 기준으로 1:1 비교가 가능하도록 한다. (= 끝을 맞춘다) 

#### A : a1 → a2 → *c1* → c2 → c3 → <u>b1 → b2 → b3 → *c1* → c2 → c3</u> → NULL

#### B : b1 → b2 → b3 → *c1* → c2 → c3 → <u>a1 → a2 → *c1* → c2 → c3</u> → NULL

### | Code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      
      if (headA == null || headB == null) return null;
     	
      ListNode curr_A = headA; 
      ListNode curr_B = headB; 
      
      while (curr_A != curr_B) {
        if (curr_A == null) {
          curr_A = headB;
        } else {
          curr_A = curr_A.next;
        }
        
     		if (curr_B == null) {
          curr_B = headA;
        } else {
          curr_B = curr_B.next;
        }
      }
      return curr_A; 
    }
}
```

### | Reference

###### https://leetcode.com/problems/intersection-of-two-linked-lists/