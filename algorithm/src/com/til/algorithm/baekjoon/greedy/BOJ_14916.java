package com.til.algorithm.baekjoon.greedy;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/17.
 * Title : 거스름 돈 (https://www.acmicpc.net/problem/14916)
 * Hint  :
 */
public class BOJ_14916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                result = n / 5 + result;
                break;
            }
            n -= 2;
            result++;
        }
        // 보유한 동전 단위로 거스름 돈을 만들 수 없는 경우
        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
