# [LinkedList] Get Node Value



### | Question 

#### Given a pointer to the head of a linked list and a specific position, determine the data value at that position. 

#### Count backwards from the tail node.

#### The tail is at position 0, its parent is at 1 and so on. 

### | Example 

#### *head* refers to 3 → 2 → 1 → 0 → NULL

#### *positionFromTail* = 2 

#### The value *2* is at the desired position. 

### | Code

주어진 포지션 값이 순차적으로 계산하는 것이 아닌 역순으로 계산하는 상황

위 예시에서 (연결 리스트 사이즈 -  주어진 포지션 값)  = 실제 반환 할 노드의 값의 인덱스로 계산할 수 있다. 

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
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
      		SinglyLinkedListNode curr_node = head; 
      		int count = 0;
      		while (curr_node != null) {
            	curr_node = curr_node.next;
            	// count size of the linked list
            	count++;
          }
      		int index = count - positionFromTail - 1; 
      		for (int i = 0; i < index; i++) {
          		head = head.next; 
          }
      		return head.data;
    }
```

