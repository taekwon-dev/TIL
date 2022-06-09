package com.til.algorithm.baekjoon.math;

import java.util.Scanner;

/**
 * Created by Youn on 2022/06/02.
 * Title : 더하기 사이클 (https://www.acmicpc.net/problem/1110)
 * Hint  : 각 자리의 수를 구하는 과정
 */
public class BOJ_1110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int init = n;
        int result = 0;

        while (true) {
            n = (((n % 10) * 10) + ((n / 10) + (n % 10)) % 10);
            result++;

            if (n == init) {
                break;
            }

        }


        System.out.println(result);
    }
}
