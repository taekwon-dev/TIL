# [Java] Primitive Wrapper Class 

```
In object-oriented programming, a wrapper class is a class that encapsulates types, so that those types can be used to create object instances and methods in another class that need those types. So a primitive wrapper class is a wrapper class that encapsulates, hides or wraps data types from the eight primitive data types, so that these can be used to create instantiated objects with methods in another class or in other classes. The primitive wrapper classes are found int the Java API.

- 위키백과 - 
```

### | Primitive Data Types which have the wrapper class :

- **byte**
- **short**
- **int**
- **long**
- **float**
- **double**
- **char**
- **boolean**

### | The difference between wrapper classes and primitive types :

Primitive wrapper classes are not the same thing as primitive types. Whereas variables, for example, can be declared in Java as data types double, short, int, etc., the primitive wrapper classes create instantiated objects and methods that inherit but hide the primitive data types, not like variable that are assigned the data types values. 

Therefore, the term *Primitive wrapper class* does not mean that wrapper classes are primitive types. It should be understood to be a class that wraps primitive types. Wrapper classes can be used to store the same value as of a primitive type value but the instances/objects of wrapper classes themselves are *Non-Primitive*. We cannot say that Wrapper classes themselves are Primitive types. They just wrap the primitive types. 

### | When : 

프로그램에 따라서 기본 타입의 데이터를 <u>객체</u>로 취급해야 하는 경우가 있을 수 있다. 예를 들어, 메소드의 인수로 객체 타입만이 요구되면, 기본 타입의 데이터를 그대로 사용할 수 없는데, 이 때 기본 타입의 데이터를 먼저 객체로 변환 후 작업을 수행할 수 있다. 

###  | Boxing and UnBoxing :

래퍼 클래스는 산술 연산을 위해 정의된 클래스가 아니므로, 인스턴스에 저장된 값을 변경할 수 없다 (<u>Immutable</u>). 단지, 값을 참조하기 위해 새로운 인스턴스를 생성하고, 생성된 인스턴스의 값을 참조할 수만 있다. 