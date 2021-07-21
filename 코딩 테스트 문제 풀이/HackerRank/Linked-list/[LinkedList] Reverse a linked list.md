# [LinkedList] Reverse a linked list

### | Question

#### Given the pointer to the head node of linked list, change the next pointers of the nodes so that their order is reversed.

#### The head pointer given may be null meaning that the initial list is empty. 

### | Code

 자료구조를 사용 (Stack) & 각 노드 객체 생성 

또는

순차적으로 포인터를 이동 

- 현재 노드 기준으로 이전 노드, 다음 노드를 (지역) 변수에 저장 
- 현재 노드가 가리키는 노드를 이전 노드로 설정
- 다음 노드로 포인터 이동 후 위 작업 반복

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
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    		if (head == null) return head; 
      
      	SinglyLinkedListNode prev_node = null;
      	SinglyLinkedListNode curr_node = head;
      
      	while (curr_node != null) {
          	curr_node.next = prev_node; 
         		prev_node = curr_node;
          	curr_node = curr_node.next;
        }
      	return curr_node;
    }

```

