# [LinkedList]  Compare two linked lists

### | Question

#### You're given the pointer to the head nodes of two linked lists. 

#### Compare the data in the nodes of the linked lists to check if they are equal.

#### If all data attributes are equal and the lists are the same length, return 1

#### Otherwise, return 0. 

### | Code

각 연결 리스트의 값을 비교하기 전에 사이즈가 같은 경우에 대해서만 체크 (우선)

1) 

사이즈가 같은 경우에 비교하기 위해 Map에 저장한다.

순차적으로 비교한다. 각 인덱스로 비교. 

2) 

사이즈 비교를 생략하고 (= 사이즈가 같은 경우를 전제, 여사건 → 같은 경우에만 1 반환)

포인터를 이동하면서 바로 값 비교하고, 모두 같은 경우 1 반환

단, 사이즈 비교를 생략했으므로 마지막 노드임을 확인해야 한다. 

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
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2)

				if (head1 == null && head2 == null) return true; 

				while (head1 != null && head2 != null) {
        		if (head1.data != head2.data) {
               	break;
            }
          	
          	if (head1.next == null && head2.next == null) {
              	return true; 
            }
          
          	head1 = head1.next;
          	head2 = head2.next;
        }
				return false; 
    }

```

