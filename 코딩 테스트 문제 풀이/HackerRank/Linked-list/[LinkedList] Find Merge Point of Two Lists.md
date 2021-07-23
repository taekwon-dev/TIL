# [LinkedList] Find Merge Point of Two Lists

\# Intersection of Two Linked Lists (on LeetCode)

### | Question 

#### Given pointer to the head nodes of 2 linked lists that merge together at some point, find the node where the  two lists merge. 

#### The merge point is where both lists point to the same node, i.e. they reference <u>the same memory location</u>.

#### <u>It is guaranteed that the two head nodes will be difference, and neither will be NULL</u>.

#### If the lists share a common node, return that node's data value.

### | Example 

#### In the diagram below, the two lists converge at Node x:

![image-20210722122538942](./imgs/Find-Merge-Point-of-Two-Lists.png)

### | Code

 <u>단방향 연결 리스트 → 앞에서 부터 비교할 수 밖에 없음 (뒤에서 순회한다는 구조가 될 수 없음)</u> 

<u>값 비교가 아니고, 주소(참조 값)을 비교  → 동일성 비교</u> 

<u>이 문제에서는 끝 점이 같기 때문에, 끝 점을 맞춘 후 교차 점이 있을 수 있는 대상을 추린 상태에서 `일대일 비교(주소 값)` 를 한다.</u>

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
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head1) {
			int head1_length = getLength(head1);
      int head2_length = getLength(head2);
      
      if (head1_length > head2_length) {
        head1 = getNode(head1, (head1_length-head2_length));
      } else {
        head2 = getNode(head2, (head2_length-head1_length));
      }
      
      while (head1 != null && head2 != null) {
        if (head1 == head2) {
          return head1.data;
        }
        head1 = head1.next;
        head2 = head2.next; 
      }
      return -1;

    }

		static int getLength(SinglyLinkedListNode head) {
    	int count = 0;
      while (head != null) {
        count++;
        head = head.next;
      }
      return count; 
    }

		static SinglyLinkedListNode getNode(SinglyLinkedListNode head, int position) {
      for (int i = 0; i < position; i++) {
        head = head.next; 
      }
      return head; 
    }
```

```java
		

		/*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     * 
     * head1 = 1 → 2 → 3 → 7 → 8  length = 5 
     * head2 = 5 → 6 → 7 → 8      length = 4 
     *
     * head1 = 1 → 2 → 3 → 7 → 8 → 5 → 6 → 7 → 8,  length = 5 + 4 = 9 
     * head2 = 5 → 6 → 7 → 8 → 1 → 2 → 3 → 7 → 8,  length = 4 + 5 = 9
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head1) {
    
   		SinglyLinkedListNode head1_curr = head1; 
      SinglyLinkedListNode head2_curr = head2; 
      
      while (head1_curr != head2_curr) {
        
        if (head1_curr.next == null) {
          head1_curr = head2; 
        } else {
          head1_curr = head1_curr.next;
        }
        
        if (head2_curr.next == null) {
          head2_curr = head1;
        } else {
          head2_curr = head2_curr.next;
        }   
      }
      return head1_curr.data; 
    }
```



### | Reference 

###### https://www.youtube.com/watch?v=dk4oFGJx3ps

###### https://www.youtube.com/watch?v=-wnzqOWSdhU
