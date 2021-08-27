# [Java] Static variable, method 



### | Static Variable 

```java
public class HousePark {
  String lastname = "박";
 	
  public static void main(String[] args) {
    HousePark park1 = new HousePark();
    HousePark park2 = new HousePark();
  }
  
}
```

'박'씨 집안에서 모든 구성원은 성이 '박'씨이다. 위 예시 코드에서 `HousePark` 인스턴스를 두 개 생성했을 때 각각의 인스턴스에서 `lastname` 을 저장하기 위해 메모리가 별도로 할당된다. 하지만 '박'씨 집안의 모든 구성원(=인스턴스)은 '박'씨이므로 사실 모든 구성원이 `lastname` 정보를 가지고 있을 필요는 없다. 이러한 경우 `static` 사용 시 메모리의 이점을 얻을 수 있다. 

다른 예로 커뮤니티 게시판에서 게시글의 조회수를 계산하는 경우를 생각해보자. 

```java
public class Counter {
  int count = 0;
  Counter() {
    this.count++;
    System.out.println(this.count);
  }
  public static void main(String[] args) {
    Counter c1 = new Counter(); // 조회 요청 1
    Counter c2 = new Counter(); // 조회 요청 2
  }
}
```

위 예시 코드에서 조회 요청을 두 번했음에도 각각의 `Counter` 인스턴스가 갖고 있는 `count` 값은 1이다. 인스턴스를 생성할 때 `count` 값을 저장하는 메모리가 생성되기 때문에 위 코드에서는 `count`를 저장하는 메모리가 따로 존재하여 공유되지 않는 것이다. 조회 요청을 두 번 했을 때 실제 `count` 값이 2가 되게 하기 위해서 어떻게 해야할까? 

```java
public class Counter {
  static int count = 0; 
  Counter() {
    this.count++;
    System.out.println(this.count);
  }
  public static void main(String[] args) {
    Counter c1 = new Counter(); // 조회 요청 1
    Counter c2 = new Counter(); // 조회 요청 2
  }
}
```

이 때 `static` 키워드를 변수 타입 앞에 선언하면 된다. `static` 키워드를 붙이면 메모리 할당을 딱 한번만 하기 때문에 위에서 `count` 값이 누적되지 않는 문제를 해결할 수 있다. 

### | Static Method 

```java
public class Counter  {
  	// static variable 
    static int count = 0;
    Counter() {
        this.count++;
    }

  	// static method 
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter(); // 조회 요청 1
        Counter c2 = new Counter(); // 조회 요청 2

        System.out.println(Counter.getCount());
    }
}
```

> ###### \* static method 안에서는 인스턴스 변수 접근이 불가능 하다. 위 예에서 count는 static 변수이기 때문에 static method에서 접근이 가능한 것이다. 

보통 static 메소드는 유틸리티 성 메소드를 작성할 때 많이 사용된다. 

### | Reference

###### https://wikidocs.net/228 