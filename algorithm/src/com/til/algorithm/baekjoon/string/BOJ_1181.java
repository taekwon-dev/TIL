package com.til.algorithm.baekjoon.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Youn on 2022/06/02.
 * Title : 단어 정렬 (https://www.acmicpc.net/problem/1181)
 * Hint  : 길이가 짧은 것, 길이가 같으면 사전 순
 */
public class BOJ_1181 {

    static int n;
    static String[] words;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        words = new String[n];


        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        System.out.println(words[0]);
        for (int i = 1; i < n; i++) {
            if (!words[i].equals(words[i - 1])) {
                System.out.println(words[i]);
            }
        }
    }


}
