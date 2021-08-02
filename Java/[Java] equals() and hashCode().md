# [Java] equals() and hashCode()

### | Object class

```java
public class Object {
...
	public native int hashCode();
  
  public boolean equals(Object obj) {
  	return (this == obj);
  }
...
}
```

##### "자바에서 모든 클래스는 사실 Object를 암시적으로 상속받고 있는 것이다. 그런 점에서 Object는 모든 클래스의 조상이라고 할 수 있다. 그 이유는 <u>모든 클래스가 공통으로 포함하고 있어야 하는 기능을 제공</u>하기 위해서다." 

### | equals() 

`equals()`는 객체와 객체가 같은 것인지를 비교하는 API이다. 단, 여기서 <u>같다</u>의 의미는 각 상황 별로 다를 수 있다. 예를 들어, 실제 해당 객체의 참조 값이 같은 경우에만 비교하는 두 객체가 같음을 정의할 수 있고, 두 객체가 서로 같은 값을 갖고 있는 경우 두 객체가 같음을 정의할 수도 있다. 즉, 객체 간 <u>같음</u>에 대한 정의를 필요에 따라 달라질 수 있는 것이다. 

기본적으로 `Object` 클래스에서는 참조 값이 같은 경우에 `equals()` 반환 값으로 `true`를 반환한다. 다만, 위에서 언급한 것과 같이 비교하는 두 객체의 값이 같은 경우 논리적으로 두 객체가 같음을 정의하기 위해서 `Object`의 `equals()` 메소드를 오버라이딩하여 재정의할 수 있는 것이다.

### | hashCode() 







### | Example - String.equals()

```java
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String aString = (String)anObject;
            if (coder() == aString.coder()) {
                return isLatin1() ? StringLatin1.equals(value, aString.value)
                                  : StringUTF16.equals(value, aString.value);
            }
        }
        return false;
    }
```

```java
// StringUTF16.equals(value, aString.value)
public static boolean equals(byte[] value, byte[] other) {
    if (value.length == other.length) {
        int len = value.length >> 1;
        for (int i = 0; i < len; i++) {
            if (getChar(value, i) != getChar(other, i)) {
                return false;
            }
        }
        return true;
    }
    return false;
}
```

### | Reference

###### https://opentutorials.org/course/1223/6241 : Object 클래스

###### https://mangkyu.tistory.com/101 : equals() and hashCode() method 

###### https://www.baeldung.com/java-equals-hashcode-contracts : Relationship between equals() and hashCode()