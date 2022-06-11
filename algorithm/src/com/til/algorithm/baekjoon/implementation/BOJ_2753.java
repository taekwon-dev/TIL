package com.til.algorithm.baekjoon.implementation;

import java.util.Scanner;

/**
 * Created by Youn on 2022/06/11.
 * Title : 윤년
 * Hint  : 4의 배수이면서 100의 배수가 아닌 경우 "또는" 400의 배수
 */
public class BOJ_2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if ((n % 4 == 0 && n % 100 != 0) || (n % 400 == 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
