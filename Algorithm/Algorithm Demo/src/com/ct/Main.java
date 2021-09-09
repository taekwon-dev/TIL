package com.ct;

public class Main {
    
    public static void main(String[] args) {
        // write your code here
        int answer;
        int n = 10;
        answer = factorial(10);
        System.out.println("answer = " + answer);

    }
    public static int factorial(int n) {
        if (n==0) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }
}
