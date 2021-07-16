# [HackerRank] Insert a Node at the Tail of a Linked list

### | Question

#### You are given the pointer to the head node of a linked list and an integer to add to the list. 

#### Create a new node with the given integer. 

#### <u>Insert this node at the tail of the linked list</u> and <u>return the head node of the linked list</u> formed after inserting this new node. 

#### <u>The given head pointer may be null</u>, meaning that the initial list is empty

### | Code 

* 예외처리 - 주어진 연결 리스트가 빈 리스트인 경우 →  <u>새로 추가한 노드 반환</u>
* 주어진 연결 리스트의 마지막 노드를 찾자 그리고 생성한 노드에 연결한다. → 마지막 노드를 어떻게 찾을까 

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
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    		
      		SinglyLinkedListNode new_node = new SinglyLinkedListNode(data); 
      		if (head == null) {
            	head = new_node; 
            	return head;
          }
      
      		SinglyLinkedListNode curr_node = head; 
      		
      		
      		while (curr_node.next != null) {
          		curr_node = curr_node.next;   
          }
     
      		curr_node.next = new_node; 
      		return head; 
 
    }
```

### | Reference

https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem