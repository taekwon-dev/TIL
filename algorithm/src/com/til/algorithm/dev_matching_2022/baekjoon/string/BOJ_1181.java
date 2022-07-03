package com.til.algorithm.dev_matching_2022.baekjoon.string;

import java.util.HashSet;

/**
 * Created by Youn on 2022/06/24.
 * Title : 단어 정렬 (https://www.acmicpc.net/problem/1181)
 * Hint  :
 */
public class BOJ_1181 {
    public static void main(String[] args) {
        long n = 5;
        String num = Long.toString(n);
        System.out.println("num = " + num);
        System.out.println("num.length() = " + num.length());

        int a = 10;

        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i);
            System.out.println("a % i = " + a % i);
            System.out.println();
        }

        System.out.println("a % 11 = " + a % 11);
        System.out.println("a % 12 = " + a % 12);
        System.out.println("a % 13 = " + a % 13);

        HashSet<Integer> set = new HashSet<>();
        set.add(11);
        set.add(11);

        System.out.println("set.size() = " + set.size());

        String num1 = "011";
        String num2 = "11";

        System.out.println("Integer.parseInt(num1) = " + Integer.parseInt(num1));
        System.out.println("Integer.parseInt(num2) = " + Integer.parseInt(num2));

        String test = "0123456789";
        System.out.println("test.substring(0, 5) = " + test.substring(0, 5));

    }
}
