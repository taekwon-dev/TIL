package com.til.algorithm.algorithm.string;

public class ReverseAString {
    public static void main(String[] args) {

        String str = "How To Do In Java";
        String reverseStringRecursion = reverseStringWithRecursion(str);
        System.out.println("reverseStringRecursion = " + reverseStringRecursion);

        String reverseStringWithSB = reverseStringWithSB(str);
        System.out.println("reverseStringWithSB = " + reverseStringWithSB);



    }
    
    // Recursion
    private static String reverseStringWithRecursion(String str) {
        if (str == null || str.isEmpty()) return str;
        return reverseStringWithRecursion(str.substring(1)) + str.charAt(0);
    }

    // StringBuilder
    private static String reverseStringWithSB(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Stack
}
