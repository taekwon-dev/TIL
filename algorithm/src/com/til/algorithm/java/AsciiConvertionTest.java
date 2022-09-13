package com.til.algorithm.java;

public class AsciiConvertionTest {
    public static void main(String[] args) {
        System.out.println("(int) 'A' = " + (int) 'A');
        System.out.println("(int) 'a' = " + (int) 'a');
        System.out.println("(int) 'Z' = " + (int) 'Z');
        System.out.println("(int) 'z' = " + (int) 'z');
    }

    private static char ithLetter(int i) {
        return (char) (((int) 'a') + i);
    }
}
