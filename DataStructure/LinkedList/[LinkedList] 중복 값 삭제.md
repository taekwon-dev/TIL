# [LinkedList] 중복 값 삭제

### | Question 

#### 정렬 되지 않은 연결 리스트에서 중복 값 삭제 (단, 버퍼 사용 X)

### | S1 Via Pointers

중복 값을 삭제는 결국 기준 값과 비교 값이 있어야 하는 구조가 된다. 즉, 두 개의 포인터가 필요하다. 

기준을 나타내는 포인터 마다 자기 자신 다음 노드부터 하나씩 검사를 해야 한다.  (→ O(N^2))

그리고 중복되는 값을 삭제할 때는 기준 노드를 삭제할 지, 비교할 노드를 삭제할 지 선택해야 하는데 연결 리스트에서 특정 노드를 제거하는 관점에서는 대부분 삭제할 노드의 이전 노드에 포인터가 있으면 편하다. 

```java
void removeDups() {
  Node n = header; 
  while (n != null && n.next != null) {
    Node r = n;
    while (r.next != null) {
       if (n.data == r.next.data) {
         r.next = r.next.next; 
       } else {
         r = r.next;
       }
    }
    n = n.next;
  }
}
```

