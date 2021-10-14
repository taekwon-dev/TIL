package com.ct.recursion;

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
