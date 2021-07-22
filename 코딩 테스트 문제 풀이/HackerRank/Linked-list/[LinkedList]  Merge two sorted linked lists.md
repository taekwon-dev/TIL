# [LinkedList] Merge two sorted linked lists



### | Question

#### Given pointers to the heads of two sorted linked lists, merge them into a single linked list.

#### Either head pointer may be null meaning that the corresponding list is empty.

### | Code	

두 연결 리스트를 병합 할 때 새로운 포인터가 필요함

```java
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

     	if (head1 == null) return head2;
      if (head2 == null) return head1; 

      SinglyLinkedListNode head3 = null; 
      
    	if (head1.data < head2.data) {
        head3 = head1; 
        head1 = head1.next;
      } else {
        head3 = head2;
        head2 = head2.next; 
      }
      SinglyLinkedListNode curr_node = head3; 
      while (head1 != null && head2 != null) {
        if (head1.data < head2.data) {
          curr_node.next = head1; 
          head1 = head1.next; 
        } else{
          curr_node.next = head2;
          head2 = head2.next; 
        }
        curr_node = curr_node.next; 
      }
      
      if (head1 == null) {
        curr_node.next = head2;
      }
      
      if (head2 == null) {
        curr_node.next = head1;
      }
      
      return head3; 
      	
    }
```

