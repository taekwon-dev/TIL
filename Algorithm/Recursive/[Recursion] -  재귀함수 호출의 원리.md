

# [Recursion] -  재귀함수 호출의 원리

\# JVM Stack 

###  | 일반적인 함수 호출 및 리턴 과정 

![image-20210322082726103](./images/recursive0_image1.png)

​								 <그림 1>

### | 재귀함수의 호출 및 리턴 과정

![image-20210322082758710](./images/recursive0_image2.png)

​								 <그림 2>

함수의 실행코드는 메모리에 한 번만 저장되어 같은 공간인 것이 맞지만, 로컬 변수 및 파라미터 등은 전혀 다른 공간에서 새로 생성되어 이전 함수 호출과 전혀 연관없는 진행이 이루어 진다 (JVM 에서는 Stack에 각 메소드가 호출될 때마다 Frame을 생성해서 관리한다). 

함수가 호출 됐을 때 메모리에 각 메소드 객체가 생성된다는 것이 재귀함수를 이해하는 과정에서 가장 중요한 포인트이다. 위 그림과 같이 재귀함수는 함수 내부에서 재귀 함수를 호출하는 시점에 새로운 객체가 생성되고, 각 함수의 리턴 시점에 호출했던 코드의 바로 아래로 되돌아 온다. 

단, <그림 2>에서 볼 수 있듯이 *탈출 조건*이 없는 경우 재귀 함수 호출이 무한히 반복될 수 있으므로 재귀 함수에서 어떤 시점에 재귀 함수 호출에서 탈출하는 지를 미리 설계하는 것이 중요하다. 

### | 예시 

#### 단방향 연결 리스트의 끝에서 K 번째 노드의 값을 찾는 알고리즘 구현

```java
static int KthFromTail(Node node, int k) {
  if (node == null) {
    return 0; 
  }
  // 
  int count = KthFromTail(node.next, k) + 1; 
  // 탈출 조건
  if (count == k) {
    System.out.println(k + "th from the tail is : " + node.data);
  }
  return count; 
}
```

#### Factorials 

```java
static int factorials(int n) {
  if (n >= 1) {
    return n * factorials(n-1);
  } else {
 		// 탈출 조건 - factorials에서 0! = 1, 음수에 대한 facotorials는 정의되어 있지 않다.
  	return 1;
  }
}
```

#### Fibonacci

```java
static int fibonacci(int n) {
	if (n >= 3) {
    return fibonacci(n-1) + fibonacci(n-2);
  } else {
    // 탈출 조건 - fibonacci f(3) 부터 유효 
    return 1;
  }
}
```



### | Reference 

###### http://10bun.tv/beginner/episode-4/#%ED%95%B5%EC%8B%AC-%EA%B0%95%EC%9D%98