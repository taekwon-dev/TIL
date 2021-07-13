# [Java] How JVM Works - JVM Architecture

```
JVM (Java Virtual Machine)은 자바 바이트 코드를 실행할 수 있는 주체이다. 일반적으로 인터프리터나 JIT 컴파일 방식으로 다른 컴퓨터 위에서 바이트 코드를 실행할 수 있도록 구현되나, jop 자바 프로세서처럼 하드웨어와 소프트웨어를 혼합해 구현하는 경우도 있다. 자바 바이트코드는 플랫폼에 독립적이며 모든 자바 가상 머신은 자바 가상 머신 규격에 정의된 대로 자바 바이트 코드를 실행한다. 따라서 표준 자바 API까지 동일한 동작을 하도록 구현한 상태에서는 이론적으로 모든 자바 프로그램은 CPU나 운영 체제의 종류와 무관하게 동일하게 동작할 것을 보장한다. 

- 위키백과 - 
```

https://www.guru99.com/java-virtual-machine-jvm.html

https://www.geeksforgeeks.org/jvm-works-jvm-architecture/