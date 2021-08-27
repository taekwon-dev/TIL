# [Java] Reference and Reference Variable 

Java 에서 연산자 `new` 는 클래스의 새로운 인스턴스에 대한 `참조(reference)` 를 반환한다. 여기서 `참조(reference)` 란 `참조 변수`가 아닌 `참조 값(reference value, hashCode)` 를 의미한다. 클래스의 참조변수에 참조를 할당할 수 있다. 

```java
A a = new A(); 

// 참조 변수 (reference variable) : a 
// 참조 값 (reference value, hashCode) : new A(); 
```

참고로, C 언어와 달리 자바에서는 인스턴스를 가리키고 있는 실제 물리주소를 반환하지 않고, 해당 인스턴스 메모리 주소 대신 해당 참조 값을 반환한다. 



https://dohe2014.tistory.com/entry/%EC%B0%B8%EC%A1%B0reference%EC%99%80-%EC%B0%B8%EC%A1%B0%EB%B3%80%EC%88%98reference-variable

