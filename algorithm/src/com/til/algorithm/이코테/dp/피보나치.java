package com.til.algorithm.이코테.dp;

public class 피보나치 {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    /**
     *    O(2^N)
     *
     *    f(30) -> 약 10억 연산
     */
    private static int fibonacci(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

}
