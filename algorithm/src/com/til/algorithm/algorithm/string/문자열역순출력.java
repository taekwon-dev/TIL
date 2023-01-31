package com.til.algorithm.algorithm.string;

public class 문자열역순출력 {

    public static void main(String[] args) {
        String target = "abcde";

        String reverseStringWithSB = reverseStringWithSB(target);
        System.out.println("reverseStringWithSB = " + reverseStringWithSB);

        String reverseStringRecursion = reverseStringWithRecursion(target);
        System.out.println("reverseStringRecursion = " + reverseStringRecursion);
    }

    private static String reverseStringWithSB(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /**
     *   target = abcde
     *
     *   bcde + a
     *   cde + b
     *   de + c
     *   e + d
     *   e
     *
     *   add e -> d -> c -> b -> a
     */
    private static String reverseStringWithRecursion(String target) {
        if (target == null || target.isEmpty()) {
            return target;
        }
        return reverseStringWithRecursion(target.substring(1)) + target.charAt(0);
    }
}
