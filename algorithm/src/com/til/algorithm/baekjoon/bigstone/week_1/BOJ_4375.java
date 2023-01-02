package com.til.algorithm.baekjoon.bigstone.week_1;

import java.io.*;
import java.util.Scanner;

public class BOJ_4375 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int next = 0;
            for (int i = 1; ; i++) {
                next = (next * 10) + 1;
                next %= n;
                if (next == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}