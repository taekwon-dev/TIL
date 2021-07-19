# [HackerRank] Insert a node at the head of a linked list

### | Question

#### Given a pointer to the head of a linked list, insert a new node before the head. 

#### The next value in the new node should point to head and the data value should be replaced with a given value. 

#### <u>Return a reference to the new head of the list</u>.

#### The head pointer given may be null meaning that the initial list is empty. 

### | Code 

주어진 값으로 새로운 노드 객체 생성 → 헤드 

예외처리, 헤드가 null 인 경우, 새로 생성한 노드 반환 

---

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
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    			
      	SinglyLinkedListNode head = llist;
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data); 
      	
      	// Exception ; a given pointer to the haed is null 
     		if (head == null) return new_node; 
      
      	new_node.next = head; 
      	return new_node; 
    }
```



