# [HackerRank] Insert a node at a specific position in a linked list 

### | Question 

#### Given the pointer to the head node of a linked list and an integer to insert at a certain position, create a new node with the given integer as its data attribute, insert this node at the desired position and <u>return head node</u>.

#### A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. 

#### <u>The head pointer given may be null</u> meaning that the initial list is empty. 

### | Code 

주어진 값으로 새로운 노드 객체 생성 

주어진 포지션 (연결 리스트 인덱스) → 두 가지 처리 (단, head가 null 인 경우에는 새로 생성한 객체를 반환)

- <u>주어진 포지션 - 1</u> 에 위치한 노드가 새로 생성한 객체를 연결 
- <u>주어진 포지션 + 1</u> 를 새로 생성한 객체가 연결 

(고민)

0번 포지션, 연결 리스트 가장 마지막 포지션, 그리고 그 외 

___

```java
    /*
     * For your reference:
     *
     * static class SinglyLinkedListNode {
     *     public int data; 
     *	   public SinglyLinkedListNode next; 
     *		 
     *		 public SinglyLinkedListNode(int nodeData) {
     *		     this.data = nodeData; 
     *         this.next = null; 
     *		 }
     * }
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data, int position) {
    		
        // 새로운 노드 객체 생성 
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data); 
      	
      	// Exception ; a given pointer to the haed is null
      	// 새로 생성한 노드 객체 반환
     		if (head == null) return new_node; 
      
    }
```

