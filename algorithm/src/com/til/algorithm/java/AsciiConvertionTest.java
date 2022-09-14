package com.til.algorithm.java;

/**
 *   A(65) ~ Z(90)
 *   a(97) ~ z(122)
 */
public class AsciiConvertionTest {
    public static void main(String[] args) {
        System.out.println("(int) 'A' = " + (int) 'A');
        System.out.println("(int) 'a' = " + (int) 'a');
        System.out.println("(int) 'Z' = " + (int) 'Z');
        System.out.println("(int) 'z' = " + (int) 'z');

        System.out.println("ithLetter(0) = " + ithLowerLetter(0));
        System.out.println("ithLetter(1) = " + ithLowerLetter(1));
        System.out.println("ithLetter(2) = " + ithLowerLetter(2));
        System.out.println("ithLetter(3) = " + ithLowerLetter(3));

        System.out.println("ithUpperLetter(0) = " + ithUpperLetter(0));
        System.out.println("ithUpperLetter(1) = " + ithUpperLetter(1));
        System.out.println("ithUpperLetter(2) = " + ithUpperLetter(2));
        System.out.println("ithUpperLetter(3) = " + ithUpperLetter(3));
    }

    private static char ithLowerLetter(int i) {
        return (char) (((int) 'a') + i);
    }

    private static char ithUpperLetter(int i) {
        return (char) (((int) 'A') + i);
    }
}

