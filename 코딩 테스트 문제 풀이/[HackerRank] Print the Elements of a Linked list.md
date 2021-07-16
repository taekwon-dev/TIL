# [HackerRank] Print the Elements of a Linked list

### | Question

#### This is an to practice traversing a *linked list*. 

#### Given a pointer to the *head* node of a linked list, print each node's data element, one per line. 

#### If the head pointer is null (indicating the list is empty), there is nothing to print.

### | Code 

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
    static void printLinkedList(SinglyLinkedListNode head) {
          
        SinglyLinkedListNode curr_node = head;  
        
        // Exception : 주어진 Linked List가 비어 있는 경우 (= Head 노드가 NULL인 경우) 
        if (head == null) return; 
       
        while (curr_node != null) {
            
            System.out.println(curr_node.data);
            curr_node = curr_node.next;
        }
    }
```



### | Reference

https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem

