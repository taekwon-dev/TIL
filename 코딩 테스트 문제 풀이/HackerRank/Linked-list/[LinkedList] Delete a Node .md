# [LinkedList] Delete a Node 

### | Question 

#### Delete the node at a given position in a linked list and return a reference the head node. 

#### The head is at position 0.

#### The list may be empty after you delete the node. 

#### In that case, return a null value.

### | Code

주어진 포지션의 노드를 삭제한다 = ___ 행위를 야기한다. 

- 삭제할 노드를 참조하고 있는 것을 끊는다 = 삭제할 노드가 참조하고 있는 노드로 참조 관계를 바꾼다. 
- 단, 주어진 포지션이 0인 경우, head 다음 노드를 반환한다. 
- 포인터를 (삭제 대상 - 1)으로 설정하면 위에서 정리한 것을 모두 처리할 수 있다.

```java
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    // Write your code here
     	if (llist == null) return llist;
      if (position == 0) return llist.next;
      
      SinglyLinkedListNode curr_node = llist;
      int index = 0;
      // set the pointer to right before the given position.
      while (index < position-1) {
      	curr_node = curr_node.next; 
        index++; 
      }

      curr_node.next = curr_node.next.next;
      return llist;
    }
```

