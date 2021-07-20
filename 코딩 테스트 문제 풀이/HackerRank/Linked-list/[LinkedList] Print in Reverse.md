# [LinkedList] Print in Reverse

\# Stack 

### | Question

#### Given a pointer to the head of a singly-linked list, print each data value from the reversed list. 

#### If the given list is empty, do not print anything. 

#### | Code

Stack (LIFO)을 통해서 문제 해결 

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
    static void reversePrint(SinglyLinkedListNode head) {
      	
    		Stack<Integer> stack = new Stack<Integer>();
      	SinglyLinkedListNode curr_node = head; 
     		
      	while (curr_node != null) {
          	stack.push(curr_node.data);
        		curr_node = curr_node.next; 
        }
      	
      	while(!stack.isEmpty()) {
          	System.out.println(stack.peek());
						stack.pop();
        }
    }
```

