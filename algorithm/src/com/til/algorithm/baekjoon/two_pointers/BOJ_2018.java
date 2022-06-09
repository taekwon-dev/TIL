package com.til.algorithm.baekjoon.two_pointers;

import java.util.Scanner;

/**
 * Created by Youn on 2022/06/09.
 * Title : 수 들의 합 5 (https://www.acmicpc.net/problem/2018)
 * Hint  : 투 포인터 (배열 내 범위)
 */
public class BOJ_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1, end = 1, sum = 1, result = 0;
        while (start <= end) {
            if (sum == n) {
                result++;
            }
            if (sum < n) {
                end += 1;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        System.out.println(result);
    }
}
