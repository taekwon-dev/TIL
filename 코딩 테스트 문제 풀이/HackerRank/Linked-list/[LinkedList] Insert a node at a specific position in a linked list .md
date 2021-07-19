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

1) 0번 포지션, 연결 리스트 가장 마지막 포지션, 그리고 그 외로 구분해서 처리한다. → 각 조건별로 처리하는 것이 다르므로 

2) 주어진 포지션에 포인터를 두는 것 자체는 동일하다. → 해당 포지션까지 이동 시키고, 위 조건에 따라서 처리하자. 

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
      	
     		// 현재 노드 포인터 (-> refer to head)
      	SinglyLinkedListNode curr_node = head;
      
      	// 주어진 포지션에 포인터 놓기 
      	for (int i = 0; i < position; i++) {
          	curr_node = curr_node.next;
        }
      
      	if (position == 0) {
            new_node.next = curr_node; 
          	return new_node;
        } else if (curr_node.next == null) {
          	curr_node.next = new_node; 
          	return head; 
        } else {
          	// 여기서 주어진 포지션 이전 노드에 대한 포인터가 없어서
            // loop를 통해서 찾아야 하는 상황 (BAD)
            
        }
    		
      
    }
```

___

### | Hint 

주어진 포지션에 포인터를 두지 않고, 주어진 **포지션 - 1**에 포인터를 두면 위에서 발생한 문제를 해결할 수 있다. 또한, 위에서 세 가지 케이스로 구분한 것에서 두 가지 케이스로만 구분해도 된다. (포지션이 0인 경우, 그렇지 않은 경우) 

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
      	
     		// 현재 노드 포인터 (-> refer to head)
      	SinglyLinkedListNode curr_node = head;
      
      	// 주어진 포지션 - 1에 포인터 세팅 
      	int index = 0; 
      	while (index < position-1) {
        		curr_node = curr_node.next;
        		index++;   
        }
      
      	if (position == 0) {
          new_node.next = head; 
          return new_node;
        } else {
          new_node.next = curr_node.next;
          curr_node.next = new_node; 
          return head;
        }
    }
```



### | Reference 

https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem