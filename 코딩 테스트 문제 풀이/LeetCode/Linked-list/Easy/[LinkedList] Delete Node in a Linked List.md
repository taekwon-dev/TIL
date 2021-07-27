# [LinkedList] Delete Node in a Linked List

### | Question 

#### Write a function to delete a node in a singly-linked list.

#### You will not be given access to the head of the list, instead <u>you will be given access to the node to be deleted directly</u>.

#### It is guaranteed that the node to be deleted <u>is not a tail node</u> in the list. 

### | Code 

#### ! 핵심은 삭제 처리를 위해 필요한 행동을 어떤 포인터에서 할 수 있나?

#### → 파라미터로 받은 삭제 할 노드 포인터에서 할 수 있나? 삭제 할 노드의 직전 노드면 ..? 

파라미터로 삭제할 노드를 받았고, 해당 노드는 주어진 연결 리스트에서 마지막 노드는 아니다. (not a  tail node)

삭제할 노드 (swap) 삭제할 노드가 참조 관계인 노드 (실질적으로는 삭제할 노드의 다음 노드를 삭제하는 형태)

1) 삭제할 노드의 값을 삭제할 노드가 참조한 노드의 값으로 바꾼다. 

2) 삭제할 노드의 참조 노드를 삭제할 노드가 참조하고 있는 노드의 다음 노드로 설정한다.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val; 
        node.next = node.next.next; 
    }
}
```

