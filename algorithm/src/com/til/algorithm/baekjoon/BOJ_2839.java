package com.til.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/05/11.
 * Title : 설탕 배달 (https://www.acmicpc.net/problem/2839)
 * Hint  :
 */
public class BOJ_2839 {

    public static void main(String[] args) throws IOException {
        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (n % 5 == 0) {
                count += n / 5;
                System.out.println(count);
                break;
            } else {
                n -= 3;
                count++;
            }

            if (n < 0) {
                System.out.println(-1);
                break;
            }
        }

    }

}
