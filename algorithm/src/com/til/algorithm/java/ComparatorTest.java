package com.til.algorithm.java;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {

        // Tim Sort (Quick + Merge)

        Integer[] tring = new Integer[]   {5, 3, 2, 6, 8, 10, 1};

        // 오름차순
        Comparator<Integer> comparator = (a, b) -> {
            System.out.println(Arrays.toString(tring) + " comparing " + a + " and " + b);
            return a.compareTo(b);
        };
        Arrays.sort(tring, comparator);
        System.out.println(Arrays.toString(tring));

        System.out.println();

        // 내림차순

        Comparator<Integer> comparator2 = (a, b) -> {
            System.out.println(Arrays.toString(tring) + " comparing " + a + " and " + b);
            return b.compareTo(a);
        };
        Arrays.sort(tring, comparator2);
        System.out.println(Arrays.toString(tring));

    }
}
