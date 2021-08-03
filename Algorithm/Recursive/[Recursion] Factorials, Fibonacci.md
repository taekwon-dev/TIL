# [Recursion] Factorials, Fibonacci 

[Github]: https://github.com/taekwon-dev/TIL/tree/main/Algorithm/Algorithm%20Demo/src/com/ct/recursion

### | Factorials 

```java
public class Factorials {
    public static void main(String[] args) {
        System.out.println("fact(5) = " + fact(5));
    }

    private static int fact(int n) {
        if (n >= 1) {
            return n * fact(n-1);
        } else {
            return 1;
        }
    }
}
```

### | Fibonacci

```java
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("fibo(4) = " + fibo(4));
    }
    private static int fibo(int n) {
        if (n >= 3) {
            return fibo(n-1) + fibo(n-2);
        } else {
            return 1;
        }
    }
}
```



### | Reference

###### https://www.youtube.com/watch?v=B0NtAFf4bvU

