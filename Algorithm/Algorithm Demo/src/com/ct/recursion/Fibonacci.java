package com.ct.recursion;

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
