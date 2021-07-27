# [Java] Generic 

### | Wiki

######  Generic are a facility of generic programming that were added to the Java Programming language in 2004 within version J2SE 5.0. They were designed to extend Java's type system to allow "a type or method to operate on objects of various types while providing compile-time type safety". The aspect *compile-time type safety* was not fully achieved, since it was shown in 2016 that it is not guaranteed in all cases. 

###### The Java collections framework supports generics to specify the type of obejcts stored in a collection instance. 



### | Generic 이란 

###### 자바에서 제네릭(generic)이란 데이터의 타입을 일반화한다는 것을 의미한다. 제네릭은 클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 미리 지정한다. 이렇게 컴파일 시 미리 타입 검사를 수행하면 다음과 같은 장점이 있다.

###### 1. 클래스나 메소드 내부에서 사용되는 객체의 타입 안정성을 높일 수 있다.

###### 2. 반환값에 대한 타입 변환 및 타입 검사에 들어가는 노력을 줄일 수 있다. 

###### JDK 1.5 이전에는 여러 타입을 사용하는 대부분의 클래스나 메소드에서 인수나 반환 값으로 Object 타입을 사용했다. 하지만 이 경우 반환된 Object 객체를 다시 원하는 타입으로 타입 변환해야 헀으며, 이 때 오류가 발생할 가능성도 있다.

###### JDK 1.5 부터 도입된 제네릭을 사용하면 컴파일 시에 미리 타입이 정해지므로, 타입 검사나 타입 변환과 같은 번거로운 작업을 생략할 수 있다. 



```java
class LandAnimal { 
  public void crying() { System.out.println("육지동물"); 
} 

class Cat extends LandAnimal { 
  public void crying() { System.out.println("냐옹냐옹"); 
} 

class Dog extends LandAnimal { 
  public void crying() { System.out.println("멍멍"); 
} 

class Sparrow { 
  public void crying() { System.out.println("짹짹"); 
} 
  
class AnimalList<T> {

    ArrayList<T> al = new ArrayList<T>();
  
    void add(T animal) { al.add(animal); }
    T get(int index) { return al.get(index); }
    boolean remove(T animal) { return al.remove(animal); }
    int size() { return al.size(); }
}

public class Generic01 {

    public static void main(String[] args) {

        AnimalList<LandAnimal> landAnimal = new AnimalList<>(); // Java SE 7부터 생략가능함.
        landAnimal.add(new LandAnimal());
        landAnimal.add(new Cat());
        landAnimal.add(new Dog());
      	
        // landAnimal.add(new Sparrow()); // 오류가 발생함 (지정한 타입 X)
        for (int i = 0; i < landAnimal.size() ; i++) {
            landAnimal.get(i).crying();
        }
    }
}
```



### | 타입 변수의 제한 

위 예시 코드에서도 볼 수 있듯이,  **T**같은 타입 변수를 사용하여 타입을 제한할 수 있다. 이 때 **extends** 키워드를 사용하면 타입 변수에 특정 타입만을 사용하도록 제한할 수 있다. 

```java
class AnimalList<T> {

    ArrayList<T> al = new ArrayList<T>();
  
    void add(T animal) { al.add(animal); }
    T get(int index) { return al.get(index); }
    boolean remove(T animal) { return al.remove(animal); }
    int size() { return al.size(); }
}
// 인간 타입만 사용하도록 제한
// 인터페이스를 구현할 경우에도 implements 키워드가 아닌 extends 키워드 사용해야 한다. 
class AnimalList<T extends 인간> {

    ArrayList<T> al = new ArrayList<T>();
  
    void add(T animal) { al.add(animal); }
    T get(int index) { return al.get(index); }
    boolean remove(T animal) { return al.remove(animal); }
    int size() { return al.size(); }
}

// 인간 타입만 사용하도록 제한
// 클래스와 인터페이스를 동시에 상속받고 구현해야 하는 경우 & 기호 사용 
class AnimalList<T extends 인간 & 인터페이스> {

    ArrayList<T> al = new ArrayList<T>();
  
    void add(T animal) { al.add(animal); }
    T get(int index) { return al.get(index); }
    boolean remove(T animal) { return al.remove(animal); }
    int size() { return al.size(); }
}
```

### | 제너릭 메소드 



### | Reference 

###### http://tcpschool.com/java/java_generic_concept