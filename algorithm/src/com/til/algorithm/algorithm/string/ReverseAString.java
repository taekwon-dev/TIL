package com.til.algorithm.algorithm.string;

/**
 *  https://www.geeksforgeeks.org/reverse-a-string-in-java/?ref=leftbar-rightbar
 */
public class ReverseAString {
    public static void main(String[] args) {

        String str = "How To Do In Java";
        String reverseStringRecursion = reverseStringWithRecursion(str);
        System.out.println("reverseStringRecursion = " + reverseStringRecursion);

        String reverseStringWithSB = reverseStringWithSB(str);
        System.out.println("reverseStringWithSB = " + reverseStringWithSB);
    }

    private static String reverseStringWithRecursion(String str) {
        if (str == null || str.isEmpty()) return str;
        return reverseStringWithRecursion(str.substring(1)) + str.charAt(0);
    }

    private static String reverseStringWithSB(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
