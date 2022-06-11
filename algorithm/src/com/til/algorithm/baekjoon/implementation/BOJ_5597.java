package com.til.algorithm.baekjoon.implementation;

import java.util.Scanner;

/**
 * Created by Youn on 2022/06/11.
 * Title : 과제 안 내신 분 ..? (https://www.acmicpc.net/problem/5597)
 * Hint  :
 */
public class BOJ_5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] students = new int[31];

        for (int i = 1; i <= 28; i++) {
            int num = sc.nextInt();
            students[num] = 1;
        }

        for (int i = 1; i <= 30; i++) {
            if (students[i] != 1) {
                System.out.println(i);
            }
        }
    }
}
