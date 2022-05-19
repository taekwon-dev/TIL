package com.til.algorithm.baekjoon.greedy;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/17.
 * Title : 폴리오미노 (https://www.acmicpc.net/problem/1343)
 * Hint  :
 */
public class BOJ_1343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String result = poliomino(str);
        System.out.println(result);
    }

    private static String poliomino(String str) {
        str = str.replaceAll("XXXX", "AAAA");
        str = str.replaceAll("XX", "BB");

        if (str.contains("X")) {
            return "-1";
        }
        return str;
    }
}
