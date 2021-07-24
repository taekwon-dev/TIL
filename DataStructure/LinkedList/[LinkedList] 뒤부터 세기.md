# [LinkedList] 뒤부터 세기 

### | Question 

#### 단방향 연결 리스트의 끝에서 K 번째 노드를 찾는 알고리즘 구현

### | S1

 연결 리스트 사이즈를 구한다. 

예를 들어, 연결 리스트 사이즈가 5이고 뒤에서 2 번째 노드를 찾는다고 가정하면

5 (연결리스트 사이즈) - 2 (K) = 3

따라서 앞에서 3번째 노드를 찾음으로써 문제를 해결할 수 있다. 

### | S2 재귀 호출 (Recursive Function) *  

```java
// 단방향 연결 리스트의 끝에서 K 번째 노드의 값 

static int KthFromTail(Node node, int k) {
  if (node == null) {
    return 0; 
  } 
  int count = KthFromTail(node.next, k) + 1; 
  // 탈출 조건
  if (count == k) {
    System.out.println(k + "th from the tail is : " + node.data);
  }
  return count; 
}
```

```java
// 단방향 연결 리스트의 끝에서 K 번째 노드 (객체 반환)
class Reference {
  public int count = 0; 
}

static Node KthFromTail(Node node, int k, Reference reference) {
  if (node == null) {
    return null; 
  }
  Node found = KthFromTail(node.next, k, reference);
  reference.count++; 
  // 탈출 조건
  if (reference.count == k) {
    return node; 
  }
  return found; 
}
```

### | S3 Pointer

```java
static Node KthFromTail(Node head, int k) {
  Node p1 = head;
  Node p2 = head; 
  
  // p1 포인터를 K만큼 앞으로 이동 시킨 상태로 초기화
  for (int i = 0; i < k; i++) {
    if (p1 == null) return null;
    p1 = p1.next;
  }
  
  // 두 개의 포인터를 움직이고, p1이 null이 된 시점에 p2가 k번째에 도달 
  while (p1 != null) {
    p1 = p1.next;
    p2 = p2.next;
  }
  return p2;
}
```



### | Reference

###### https://www.youtube.com/watch?v=Vb24scNDAVg

